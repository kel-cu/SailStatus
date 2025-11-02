package ru.kelcuprum.sailstatus.presence;

import com.jagrosh.discordipc.entities.*;
import ru.kelcuprum.sailstatus.SailStatus;
import ru.kelcuprum.sailstatus.config.Assets;

import static ru.kelcuprum.sailstatus.SailStatus.defaultBuilder;

public class Unknown {
    /**
     * Состояние: what?<br>
     * Причины: Ни одна проверка не нашла подходящий вариант
     */
    public static void execute(){
        RichPresence.Builder presence = defaultBuilder();
        presence.setState(SailStatus.localization.getLocalization("unknown", true));
        presence.setLargeImage(Assets.getSelected().getIcon("unknown"));
        SailStatus.sendPresence(presence.build());
    }
}
