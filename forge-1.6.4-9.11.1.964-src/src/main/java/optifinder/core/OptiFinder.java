package optifinder.core;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = OptiFinder.MODID, name = OptiFinder.NAME, version = OptiFinder.VERSION)
public class OptiFinder {
	
    public static final String MODID = "optifinder";
    public static final String NAME = "OptiFinder";
    public static final String VERSION = "1.6.4_HD_U_D1";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	ScanModsFolder.main(VERSION);
    }
}