package io.ace.phase.module.client;

import io.ace.phase.Phase;
import io.ace.phase.extendable.Module;
import io.ace.phase.gui.Gui;
import io.ace.phase.manager.BindManager;
import io.ace.phase.manager.ModuleManager;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.lwjgl.glfw.GLFW;

public class ClickGui extends Module {

    public ClickGui() {
        super("ClickGui", Category.GUI);
    }

    public static boolean guiEnabled = false;

    public void onEnable() {
        //Phase.LOGGER.info("Enable Working");
        mc.setScreen(new Gui());
        guiEnabled = true;
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void keyboardListener(InputEvent.KeyInputEvent event) {
        Phase.LOGGER.info(event.getKey());
        //below action 1 is when the key is pressed down action 2 should be when key is released and if no action is used it will spam
        // Phase.LOGGER.info(event.getKey() + " Was Just Pressed" + event.getScanCode());
            // keybinding debug stuff ChatManager.sendChat("key just pressed " + event.getKey());
                if (event.getKey() == GLFW.GLFW_KEY_ESCAPE) {
                    this.disable();
                    guiEnabled = false;
            }

    }

    public void onDisable() {
        guiEnabled = false;
        MinecraftForge.EVENT_BUS.unregister(this);
    }
}
