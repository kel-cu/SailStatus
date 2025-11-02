package ru.kelcuprum.sailstatus.presence.ingame;

import com.jagrosh.discordipc.entities.*;
import ru.kelcuprum.alinlib.info.World;
import ru.kelcuprum.sailstatus.SailStatus;
import ru.kelcuprum.sailstatus.config.Assets;
import ru.kelcuprum.sailstatus.info.*;

import static ru.kelcuprum.sailstatus.SailStatus.defaultBuilder;

public class SinglePlayer {
    public static void execute() {
        RichPresence.Builder presence = defaultBuilder();
        SailStatus.updateContentPresenceByConfigs(presence);
        presence.setDetails(PresencePlayer.getState());
        presence.setState(SailStatus.localization.getLocalization("player.world.state", true));
        if(SailStatus.userConfig.getBoolean("ENABLE_WORLD", true)){
            if(World.getCodeName().endsWith("overworld") && SailStatus.userConfig.getBoolean("ENABLE_TIME_CYCLE", true)) PresenceWorld.getTime(presence);
            else {
                presence.setLargeImage(PresenceWorld.getAssets(), World.getName(), "");
            }
        } else presence.setLargeImage(Assets.getSelected().getIcon("logo"));
        SailStatus.sendPresence(presence.build());
    }
}
