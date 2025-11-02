package ru.kelcuprum.sailstatus.presence.menu;

import com.jagrosh.discordipc.entities.*;
import ru.kelcuprum.sailstatus.SailStatus;
import ru.kelcuprum.sailstatus.config.Assets;

import static ru.kelcuprum.sailstatus.SailStatus.defaultBuilder;

public class Loading {
    /**
     * Состояние: <br>
     * Причины:
     */
    public static void execute() {
        RichPresence.Builder presence = defaultBuilder();
        presence.setState(SailStatus.localization.getLocalization("world.loading", true));
        presence.setLargeImage(Assets.getSelected().getIcon("unknown_world"));
        SailStatus.sendPresence(presence.build());
    }
}
