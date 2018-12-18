package ALWAYS.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.neow.NeowEvent;
import com.megacrit.cardcrawl.random.Random;

@SpirePatch(
        clz = NeowEvent.class,
        method = "blessing"
)
public class FUCKUCASEYANDORANTHONY {
    @SpireInsertPatch(
            rloc = 2
    )
    public static void FUCK(NeowEvent __instance) {
        NeowEvent.rng = new Random(Settings.seed + AbstractDungeon.floorNum);
    }
}
