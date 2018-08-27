package me.missionary.magenta.renderer.sidebar;

import me.missionary.magenta.MagentaMod;
import me.missionary.magenta.renderer.IScreenRenderer;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraftforge.client.GuiIngameForge;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author Missionary (missionarymc@gmail.com)
 * @since 8/26/2018
 */
public class SidebarRenderer implements IScreenRenderer {

    private ScoreObjective scoreObjective;

    public void setScoreObjective(ScoreObjective scoreObjective) {
        this.scoreObjective = scoreObjective;
    }

    @Override
    public void render(GuiIngameForge guiIngameForge) {
        if (scoreObjective == null) {
            return;
        }
        FontRenderer renderer = MagentaMod.getFontRenderer();
        Scoreboard scoreboard = scoreObjective.getScoreboard();
        Collection content = scoreboard.func_96534_i(scoreObjective);
        if (content.size() <= 15) {
            int size = MagentaMod.getFontRenderer().getStringWidth(scoreObjective.getDisplayName());
            String string;

            for (Iterator iterator = content.iterator(); iterator.hasNext(); size = Math.max(size, renderer.getStringWidth(string))) {
                Score score = (Score) iterator.next();
                ScorePlayerTeam team = scoreboard.getPlayersTeam(score.getPlayerName());
                string = ScorePlayerTeam.formatPlayerName(team, score.getPlayerName());
            }

            int incrementor = 0;
            int boxHeight = content.size() * renderer.FONT_HEIGHT;
            int l1 = guiIngameForge.getResolution().getScaledHeight() / 2 + boxHeight / 3;
            int i2 = guiIngameForge.getResolution().getScaledWidth() - size - 3;

            for (Object object : content) {
                Score score = (Score) object;
                incrementor++;
                ScorePlayerTeam scorePlayerTeam = scoreboard.getPlayersTeam(score.getPlayerName());
                String s111 = ScorePlayerTeam.formatPlayerName(scorePlayerTeam, score.getPlayerName());
                int k = l1 - incrementor * renderer.FONT_HEIGHT;
                int l = guiIngameForge.getResolution().getScaledWidth() - 3 + 2;
                Gui.drawRect(-4 + i2 - 2, k, l, k + renderer.FONT_HEIGHT, 1342177280);
                renderer.drawString(s111, -4 + i2, k, 553648127);

                if (incrementor == content.size()) {
                    String objectiveDisplayName = scoreObjective.getDisplayName();
                    Gui.drawRect(-4 + i2 - 2, k - renderer.FONT_HEIGHT - 1, l, k - 1, 1610612736);
                    Gui.drawRect(-4 + i2 - 2, k - 1, l,k, 1342177280);
                    renderer.drawString(objectiveDisplayName, -4 + i2 + size / 2 - renderer.getStringWidth(objectiveDisplayName) / 2, k - renderer.FONT_HEIGHT, 553648127);
                }
            }
        }
    }
}
