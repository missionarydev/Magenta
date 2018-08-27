package me.missionary.magenta.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.client.GuiIngameForge;

/**
 * @author Missionary (missionarymc@gmail.com)
 * @since 6/5/2018
 */
@FunctionalInterface
public interface IScreenRenderer {

    @SideOnly(Side.CLIENT)
    void render(GuiIngameForge guiIngameForge);
}
