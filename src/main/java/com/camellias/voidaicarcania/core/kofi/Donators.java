package com.camellias.voidaicarcania.core.kofi;

import java.util.HashMap;
import java.util.UUID;

public class Donators
{
	public static final HashMap<UUID, Integer> DONATOR_ID = new HashMap<UUID, Integer>();
	
	public static final UUID TigersHideout = UUID.fromString("01155b6d-2338-4513-909c-224ddcc0214f");
	public static final UUID DanTheDetermined = UUID.fromString("3810639e-b52f-4df1-ad4b-748236bf77b9");
	
	public static void addDonators()
	{
		DONATOR_ID.put(TigersHideout, 0);
		DONATOR_ID.put(DanTheDetermined, 0);
	}
}
