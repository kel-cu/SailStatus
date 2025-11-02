package ru.kelcuprum.sailstatus.presence.ingame;

import com.jagrosh.discordipc.entities.ActivityType;
import com.jagrosh.discordipc.entities.RichPresence;
import ru.kelcuprum.sailstatus.SailStatus;
import ru.kelcuprum.sailstatus.config.Assets;

import static ru.kelcuprum.sailstatus.SailStatus.defaultBuilder;

public class SaveWorld {
    public static void execute() {
        RichPresence.Builder presence = defaultBuilder();
        presence.setState(SailStatus.localization.getLocalization("save.world", true));
        presence.setLargeImage(Assets.getSelected().getIcon("unknown"));
        SailStatus.sendPresence(presence.build());
    }
}
