package io.ace.phase.command;

import io.ace.phase.extendable.Command;
import io.ace.phase.extendable.Module;
import io.ace.phase.manager.ChatManager;
import io.ace.phase.manager.ModuleManager;
import net.minecraft.ChatFormatting;

public class Modules extends Command {

    public Modules() {
        super("Modules", "How the fuck did u mess this up retard");
    }

    public void Command(String[] command) {
        try {
        StringBuilder message = new StringBuilder();
        for (Module e : ModuleManager.modules) {
            if (e.isEnabled()) message.append(ChatFormatting.GREEN);
            else message.append(ChatFormatting.WHITE);
            message.append(e.getName()).append(", ");
        }
        ChatManager.sendChat(message.toString());

        } catch (Exception e) {
            ChatManager.sendChat("Command Used Incorrectly!" + this.getUsage());

        }


    }
}
