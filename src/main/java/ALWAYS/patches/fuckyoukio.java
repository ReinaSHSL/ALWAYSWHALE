package ALWAYS.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.relics.NeowsLament;

import java.util.ArrayList;

@SpirePatch(
        clz = NeowsLament.class,
        method = "atBattleStart"
)
public class fuckyoukio {
    private static ArrayList<AbstractRelic> laments = new ArrayList<>();
    private static AbstractRelic fuckukio = null;
    public static SpireReturn Prefix(NeowsLament __instance) {
        for (AbstractRelic r : AbstractDungeon.player.relics) {
            if (r.relicId.equals(NeowsLament.ID)) {
                laments.add(r);
            }
        }
        for (AbstractRelic r : laments) {
            if (fuckukio == null) {
                fuckukio = r;
            }
            if (fuckukio.counter < 0 && r.counter > 0) {
                fuckukio = r;
            }
            if (r.counter < fuckukio.counter && r.counter > 0) {
                fuckukio = r;
            }
        }
        if (__instance == fuckukio) {
            return SpireReturn.Continue();
        } else {
            return SpireReturn.Return(null);
        }
    }
}
