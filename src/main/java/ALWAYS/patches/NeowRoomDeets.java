package ALWAYS.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.events.AbstractEvent;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.neow.NeowEvent;
import com.megacrit.cardcrawl.neow.NeowRoom;
import com.megacrit.cardcrawl.rooms.AbstractRoom;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class NeowRoomDeets {

    @SpirePatch(
            clz = NeowRoom.class,
            method = SpirePatch.CONSTRUCTOR
    )
    public static class MapPatch {
        public static void Postfix(NeowRoom __instance, boolean isDone) {
            __instance.setMapImg(ImageMaster.loadImage("ALWAYS/ALWAYS.png"), ImageMaster.loadImage("ALWAYS/ALWAYSOUTLINE.png"));
            __instance.setMapSymbol("WH");
        }
    }

}
