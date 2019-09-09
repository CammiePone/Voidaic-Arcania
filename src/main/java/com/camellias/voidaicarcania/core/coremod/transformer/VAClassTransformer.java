package com.camellias.voidaicarcania.core.coremod.transformer;

import java.util.ListIterator;
import java.util.function.Predicate;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;

import net.minecraft.launchwrapper.IClassTransformer;

/**
 * @author Gegy
 * All code below belongs to CrypticMushroom under the GNU General Public License 3.0.
 * https://github.com/Cryptic-Mushroom
 */
public class VAClassTransformer implements IClassTransformer, Opcodes
{
	private static final String SOURCE_LWJGL_NAME = "paulscode/sound/libraries/SourceLWJGLOpenAL";
	private static final String CHANNEL_LWJGL_NAME = "paulscode/sound/libraries/ChannelLWJGLOpenAL";
	
	private static final Logger LOGGER = LogManager.getLogger(VAClassTransformer.class);
	
	@Override
	public byte[] transform(String name, String transformedName, byte[] data)
	{
		if(data == null)
		{
			return null;
		}
		
		if(transformedName.equals("paulscode.sound.libraries.SourceLWJGLOpenAL"))
		{
			return this.applyTransform(transformedName, data, this::transformSoundSource);
		}
		return data;
	}
	
	private boolean transformSoundSource(ClassNode node)
	{
		for(MethodNode method : node.methods)
		{
			if(method.name.equals("play"))
			{
				this.insertBefore(method.instructions, this.invoke(SOURCE_LWJGL_NAME, "checkPitch"::equals), () ->
				{
					InsnList instructions = new InsnList();
					instructions.add(new VarInsnNode(ALOAD, 0));
					instructions.add(new FieldInsnNode(GETFIELD, SOURCE_LWJGL_NAME, "channelOpenAL", "L" + CHANNEL_LWJGL_NAME + ";"));
					instructions.add(new FieldInsnNode(GETFIELD, CHANNEL_LWJGL_NAME, "ALSource", "Ljava/nio/IntBuffer;"));
					instructions.add(new InsnNode(ICONST_0));
					instructions.add(new MethodInsnNode(INVOKEVIRTUAL, "java/nio/IntBuffer", "get", "(I)I", false));
					instructions.add(new MethodInsnNode(INVOKESTATIC, "com/camellias/voidaicarcania/core/handlers/SoundReverbHandler", "onPlaySound", "(I)V", false));
					return instructions;
				});
				
				return true;
			}
		}
		return false;
	}
	
	private byte[] applyTransform(String name, byte[] data, Predicate<ClassNode> transformer)
	{
		ClassNode node = new ClassNode();
		ClassReader reader = new ClassReader(data);
		reader.accept(node, 0);
		LOGGER.info("Patching class {}", name);
		
		if(transformer.test(node))
		{
			ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS);
			node.accept(writer);
			
			return writer.toByteArray();
		}
		else
		{
			LOGGER.warn("Unable to patch class {}", name);
			return data;
		}
	}
	
	private void insertBefore(InsnList instructions, Predicate<AbstractInsnNode> predicate, Supplier<InsnList> insert)
	{
		AbstractInsnNode node = this.selectNode(instructions, predicate);
		
		if(node != null)
		{
			instructions.insertBefore(node, insert.get());
		}
		else
		{
			StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
			LOGGER.warn("Failed to find location to insert for {}", stackTrace[1].getMethodName());
		}
	}
	
	private void insertAfter(InsnList instructions, Predicate<AbstractInsnNode> predicate, Supplier<InsnList> insert)
	{
		AbstractInsnNode node = this.selectNode(instructions, predicate);
		
		if(node != null)
		{
			instructions.insert(node, insert.get());
		}
		else
		{
			StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
			LOGGER.warn("Failed to find location to insert for {}", stackTrace[1].getMethodName());
		}
	}
	
	@Nullable
	private AbstractInsnNode selectNode(InsnList instructions, Predicate<AbstractInsnNode> predicate)
	{
		ListIterator<AbstractInsnNode> iterator = instructions.iterator();
		
		while(iterator.hasNext())
		{
			AbstractInsnNode node = iterator.next();
			
			if(predicate.test(node))
			{
				return node;
			}
		}
		return null;
	}
	
	private Predicate<AbstractInsnNode> invoke(String owner, Predicate<String> name)
	{
		return n -> n instanceof MethodInsnNode && ((MethodInsnNode) n).owner.equals(owner) && name.test(((MethodInsnNode) n).name);
	}
}
