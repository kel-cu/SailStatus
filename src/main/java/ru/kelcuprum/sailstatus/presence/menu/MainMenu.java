package ru.kelcuprum.sailstatus.presence.menu;

import com.jagrosh.discordipc.entities.*;
import ru.kelcuprum.sailstatus.SailStatus;
import ru.kelcuprum.sailstatus.config.Assets;

import static ru.kelcuprum.sailstatus.SailStatus.defaultBuilder;

public class MainMenu {
    public static void execute() {
        RichPresence.Builder presence = defaultBuilder();
        presence.setLargeImage(Assets.getSelected().getIcon("logo"), SailStatus.localization.getLocalization("mainmenu.icon", true), "");
        if(SailStatus.localization.getLocalization("mainmenu", false).equals("sailstatus.presence.mainmenu")) presence.setState("Resources unready!");
        else  {
            presence.setDetails(SailStatus.localization.getLocalization("mainmenu", true));
            if(SailStatus.localization.getLocalization("mainmenu.state", true).equals("sailstatus.presence.mainmenu.state"))  presence.setDetails("Please wait...");
            else presence.setState(SailStatus.localization.getLocalization("mainmenu.state", true));
        }
        SailStatus.updateContentPresenceByConfigs(presence, false, true);

        if(SailStatus.isMusicModsEnable){
            if(SailStatus.userConfig.getBoolean("VIEW_MUSIC_LISTENER", false) && !SailStatus.waterPlayerSupport.paused){
                presence.setState(SailStatus.waterPlayerSupport.artistIsNull ? SailStatus.localization.getLocalization("mod.music.menu.noauthor", true) : SailStatus.localization.getLocalization("mod.music.menu", true));
            }
        }

        SailStatus.sendPresence(presence.build());
    }
}
