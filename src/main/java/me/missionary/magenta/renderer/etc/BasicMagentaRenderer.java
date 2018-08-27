package me.missionary.magenta.renderer.etc;

import me.missionary.magenta.renderer.IScreenRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.GuiIngameForge;

/**
 * @author Missionary (missionarymc@gmail.com)
 * @since 6/5/2018
 */
public class BasicMagentaRenderer implements IScreenRenderer {

    @Override
    public void render(GuiIngameForge guiIngameForge) {
        guiIngameForge.drawString(Minecraft.getMinecraft().fontRenderer, EnumChatFormatting.LIGHT_PURPLE + "Magenta", 4, 5, 0);
    }
}
