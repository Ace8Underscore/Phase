package io.ace.phase.gui.componets;

import io.ace.phase.Phase;
import io.ace.phase.gui.Gui;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class Component {

    public void getMouseLocation(ScreenEvent.MouseClickedEvent event) {
        Phase.LOGGER.info(event.getMouseX() + " " + event.getMouseY());
    }


}
