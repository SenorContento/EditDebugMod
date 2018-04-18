package com.senorcontento.editdebug;

import java.util.Iterator;

import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;

@Mod(modid = EditDebug.MODID, version = EditDebug.VERSION, name = EditDebug.NAME)
public class EditDebug {
    public static final String MODID = "editdebug";
    public static final String NAME = "Edit Debug Screen";
    public static final String VERSION = "1.0";
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
        if(FMLCommonHandler.instance().getEffectiveSide().isClient())
            MinecraftForge.EVENT_BUS.register(this);
    }
    
    @SubscribeEvent
    public void renderOverlayEvent(RenderGameOverlayEvent.Text event) {
        //EntityPlayer player = Minecraft.getMinecraft().player;
        //if(player.capabilities.isCreativeMode)
        //    return;
        
        Iterator<String> it = event.getLeft().listIterator();
        while (it.hasNext()) {
            String value = it.next();
            if (value != null && (value.startsWith("XYZ:") || value.startsWith("Chunk:") || value.startsWith("Block:") || value.startsWith("Facing:") || value.startsWith("Looking at:")))
                it.remove();
        }
    }
}
