package ALWAYS.patches;


import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.events.AbstractEvent;
import com.megacrit.cardcrawl.map.MapGenerator;
import com.megacrit.cardcrawl.map.MapRoomNode;
import com.megacrit.cardcrawl.neow.NeowEvent;
import com.megacrit.cardcrawl.neow.NeowRoom;
import com.megacrit.cardcrawl.random.Random;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.rooms.EventRoom;
import javassist.CtBehavior;
import ALWAYS.FakeNeowRoom;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@SpirePatch(
        clz=AbstractDungeon.class,
        method="generateMap"
)
public class ALWAYS {
    @SpireInsertPatch(
            locator = Locator.class
    )
    public static void ALWAYSNeowRoom() {
        for (List<MapRoomNode> rows : AbstractDungeon.map) {
            for (MapRoomNode node : rows) {
                if (node.room instanceof EventRoom) {
                    node.setRoom(new FakeNeowRoom());
                }
            }
        }
    }

    private static class Locator extends SpireInsertLocator {
        @Override
        public int[] Locate(CtBehavior ctMethodToPatch) throws Exception {
            Matcher finalMatcher = new Matcher.MethodCallMatcher(MapGenerator.class, "toString");
            return LineFinder.findInOrder(ctMethodToPatch, finalMatcher);
        }
    }


}
