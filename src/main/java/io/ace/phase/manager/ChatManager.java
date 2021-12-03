package io.ace.phase.manager;

import io.ace.phase.command.*;
import io.ace.phase.extendable.Command;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.ArrayList;

public class ChatManager {

    public static ArrayList<Command> commandList;

    public ChatManager() {
        initCommands();
    }

    public static String commands = "";


    public static String prefix = ".";

    public static void sentCommand(String[] command) {
        // below you'll switch the words below with what ever command your doing ik its chinese but i like it
        if (command[0].contains("commands")) {
            Commands c = new Commands();
            c.Command(command);
            return;
        }
        if (command[0].contains("setpos")) {
            SetPos c = new SetPos();
            c.Command(command);
            return;
        }
        if (command[0].contains("toggle")) {
            Toggle c = new Toggle();
            c.Command(command);
            return;
        }
        if (command[0].contains("prefix")) {
            Prefix c = new Prefix();
            c.Command(command);
            return;
        }
        if (command[0].contains("modules")) {
            Modules c = new Modules();
            c.Command(command);
            return;
        }
        if (command[0].contains("bind")) {
            Bind c = new Bind();
            c.Command(command);
            return;
        }

    }

    public static void sendChat(String message) {
        assert Minecraft.getInstance().player != null;
        Minecraft.getInstance().player.displayClientMessage(Component.nullToEmpty(message), false);
    }

    // uses the new minecraft chat above the players hotbar for messages
    public static void sendHotBarChat(String message) {
        assert Minecraft.getInstance().player != null;
        Minecraft.getInstance().player.displayClientMessage(Component.nullToEmpty(message), true);
    }

    public void initCommands() {
        commandList = new ArrayList<Command>();
        commandList.add(new Prefix());
        commandList.add(new SetPos());
        commandList.add(new Toggle());
        commandList.add(new Modules());
        commandList.add(new Bind());


    }

}
