package optifinder.core;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = OptiFinder.MODID, name = OptiFinder.NAME, version = OptiFinder.VERSION)
public class OptiFinder {
	
    public static final String MODID = "optifinder";
    public static final String NAME = "OptiFinder";
    public static final String VERSION = "1.10.2_HD_U_E7";

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