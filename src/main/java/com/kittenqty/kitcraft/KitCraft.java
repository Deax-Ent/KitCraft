package com.kittenqty.kitcraft;

import com.kittenqty.kitcraft.handler.ConfigurationHandler;
import com.kittenqty.kitcraft.init.ModBlocks;
import com.kittenqty.kitcraft.init.ModItems;
import com.kittenqty.kitcraft.init.Recipes;
import com.kittenqty.kitcraft.proxy.IProxy;
import com.kittenqty.kitcraft.reference.Messages;
import com.kittenqty.kitcraft.reference.Reference;
import com.kittenqty.kitcraft.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLFingerprintViolationEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, certificateFingerprint = Reference.FINGERPRINT, version = Reference.MOD_VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class KitCraft
{

    @Mod.Instance(Reference.MOD_ID)
    public static KitCraft instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void invalidFingerprint(FMLFingerprintViolationEvent event)
    {
        if(Reference.FINGERPRINT.equals("@FINGERPRINT@")) {
            LogHelper.info(Messages.NO_FINGERPRINT_MESSAGE);
        } else {
            LogHelper.warn(Messages.INVALID_FINGERPRINT_MESSAGE);
        }
    }

    @Mod.EventHandler
    public static void preLoad(FMLPreInitializationEvent PreEvent)
    {
        ConfigurationHandler.init(PreEvent.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

        ModItems.init();
        ModBlocks.init();
    }

    @Mod.EventHandler
    public static void load(FMLInitializationEvent event)
    {
        Recipes.init();
    }

    @Mod.EventHandler
    public static void postLoad(FMLPostInitializationEvent PostEvent)
    {

    }

}
