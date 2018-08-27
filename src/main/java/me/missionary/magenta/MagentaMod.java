package me.missionary.magenta;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import me.missionary.magenta.renderer.ScreenRendererManager;
import me.missionary.magenta.renderer.etc.BasicMagentaRenderer;
import me.missionary.magenta.renderer.sidebar.SidebarRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

@Mod(modid = "magenta", name = "Magenta", version = "1.0.0-SNAPSHOT")
public class MagentaMod {

    private static FontRenderer FONT_RENDERER;
    private ScreenRendererManager screenRendererManager;

    public static FontRenderer getFontRenderer() {
        return FONT_RENDERER;
    }

    @EventHandler // like the psvm in java
    public void init(FMLInitializationEvent event) {
        FMLCommonHandler.instance().bus().register(this);
        FONT_RENDERER = Minecraft.getMinecraft().fontRenderer;
        this.screenRendererManager = new ScreenRendererManager(Minecraft.getMinecraft());
        screenRendererManager.addScreenRenderers(new BasicMagentaRenderer(), new SidebarRenderer());
    }
}
