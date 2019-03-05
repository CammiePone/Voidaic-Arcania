package com.camellias.voidaicarcania.kofi;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Donators
{
	public static final List<UUID> DONATOR_ID = new ArrayList<UUID>();
	
	public static final UUID TigersHideout = UUID.fromString("01155b6d-2338-4513-909c-224ddcc0214f");
	public static final UUID DanTheDetermined = UUID.fromString("3810639e-b52f-4df1-ad4b-748236bf77b9");
	
	public static void addDonators()
	{
		DONATOR_ID.add(TigersHideout);
		DONATOR_ID.add(DanTheDetermined);
	}
}
