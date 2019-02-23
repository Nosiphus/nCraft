package optifinder.core;

import net.minecraft.init.Blocks;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = OptiFinder.MODID, name = OptiFinder.NAME, version = OptiFinder.VERSION)
public class OptiFinder {
	
    public static final String MODID = "optifinder";
    public static final String NAME = "OptiFinder";
    public static final String VERSION = "1.7.10_HD_U_E7";

    private static Logger logger;

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