package io.ace.phase.command;

import io.ace.phase.Phase;
import io.ace.phase.extendable.Command;
import io.ace.phase.manager.ChatManager;
import net.minecraft.client.Minecraft;

public class Prefix extends Command {

    public Prefix() {
        super("Prefix", ".Prefix (new prefix)");
    }

    public void Command(String[] command) {
        try {

            ChatManager.prefix = command[1];
            ChatManager.sendChat("Client Prefix has been changed to " + command[1]);


        } catch (Exception e) {
            ChatManager.sendChat("Command Used Incorrectly!" + " Use it like " + this.getUsage());

        }
    }
}

