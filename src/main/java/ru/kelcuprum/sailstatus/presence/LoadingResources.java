package ru.kelcuprum.sailstatus.presence;

import com.jagrosh.discordipc.entities.*;
import ru.kelcuprum.alinlib.AlinLib;
import ru.kelcuprum.sailstatus.SailStatus;
import ru.kelcuprum.sailstatus.config.Assets;

import static ru.kelcuprum.sailstatus.SailStatus.defaultBuilder;

public class LoadingResources {
    /**
     * Состояние: <br>
     * Причины:
     */
    public static void execute(){
        RichPresence.Builder presence = defaultBuilder();
        presence.setDetails(SailStatus.localization.getLocalization("loading", true));
        presence.setLargeImage(Assets.getSelected().getIcon("unknown"));
        if(AlinLib.isAprilFool()){
            presence.setLargeImage("https://wf.kelcu.ru/mods/waterplayer/icons/clownfish.png");
            presence.setState(SailStatus.localization.getLocalization("loading.af", true));
        }else if(SailStatus.isPEnable < 0.03) {
            presence.setLargeImage("https://wf.kelcu.ru/mods/simplystatus/what/wm/en_yawn.png");
            presence.setState("The world machine hasn't started");
        }
        SailStatus.sendPresence(presence.build());
    }
}
