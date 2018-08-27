package me.missionary.magenta.renderer;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import me.missionary.magenta.renderer.sidebar.SidebarRenderer;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Missionary (missionarymc@gmail.com)
 * @since 6/5/2018
 */
public class ScreenRendererManager {

    private final List<IScreenRenderer> SCREEN_RENDERERS = new ArrayList<>();

    private final Minecraft minecraft;

    public ScreenRendererManager(Minecraft minecraft) {
        this.minecraft = minecraft;
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void addScreenRenderers(IScreenRenderer... renderer) {
        SCREEN_RENDERERS.addAll(Arrays.asList(renderer));
    }

    @SubscribeEvent
    public void renderScreen(RenderGameOverlayEvent.Post event) {
        if (event.type != RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }
        GuiIngameForge ingameForge = (GuiIngameForge) minecraft.ingameGUI;
        GuiIngameForge.renderObjective = false;
        for (IScreenRenderer renderer : SCREEN_RENDERERS) {
            if (renderer instanceof SidebarRenderer) {
                ((SidebarRenderer) renderer).setScoreObjective(minecraft.theWorld.getScoreboard().func_96539_a(1));
            }
            renderer.render(ingameForge);
        }
    }
}
