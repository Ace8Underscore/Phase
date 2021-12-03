package io.ace.phase.module.misc;

import io.ace.phase.extendable.Module;
import net.minecraft.network.chat.Component;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class POC extends Module {

    public POC() {
        super("POC", Category.MISC);
    }

    @SubscribeEvent
    public void onUpdate(TickEvent.PlayerTickEvent event) {
        if (mc.level == null || mc.player == null) return;
        mc.player.sendMessage(Component.nullToEmpty("Modular System Working"), mc.player.getUUID());
    }

}
