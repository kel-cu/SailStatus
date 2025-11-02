package ru.kelcuprum.sailstatus.presence.menu;

import com.jagrosh.discordipc.entities.*;
import ru.kelcuprum.sailstatus.SailStatus;
import ru.kelcuprum.sailstatus.config.Assets;

import static ru.kelcuprum.sailstatus.SailStatus.defaultBuilder;

public class Disconnect {
    /**
     * Состояние: Игрок отключён<br>
     * Причины: Игрок был отключён от сервера без его помощи
     */
    public static void execute() {
        RichPresence.Builder presence = defaultBuilder();
        presence.setState(SailStatus.localization.getLocalization("server.disconnected", true));
        presence.setLargeImage(Assets.getSelected().getIcon("unknown_world"));
        SailStatus.sendPresence(presence.build());
    }
}
