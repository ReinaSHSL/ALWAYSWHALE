package ALWAYS.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.neow.NeowRoom;
import com.megacrit.cardcrawl.relics.*;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import ALWAYS.FakeNeowRoom;

import java.util.ArrayList;
import java.util.List;

@SpirePatch(
        clz= AbstractDungeon.class,
        method="returnRandomRelicKey"
)
public class fuckofflock {
    private static List<String> relicBlacklist = new ArrayList<>();

    static {
        relicBlacklist.add(CallingBell.ID);
        relicBlacklist.add(Orrery.ID);
        relicBlacklist.add(TinyHouse.ID);
        relicBlacklist.add(PandorasBox.ID);
        relicBlacklist.add(Astrolabe.ID);
    }

    public static String Postfix(String __result, AbstractRelic.RelicTier tier) {
        if (AbstractDungeon.currMapNode != null) {
            AbstractRoom room = AbstractDungeon.getCurrRoom();
            if (room != null) {
                if (room instanceof FakeNeowRoom) {
                    if (relicBlacklist.contains(__result)) {
                        return AbstractDungeon.returnRandomRelicKey(tier);
                    }
                }
            }
        }

        return __result;
    }
}
