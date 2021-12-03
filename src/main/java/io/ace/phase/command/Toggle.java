package io.ace.phase.command;

import io.ace.phase.extendable.Command;
import io.ace.phase.manager.ChatManager;
import io.ace.phase.manager.ModuleManager;
import io.ace.phase.extendable.Module;

public class Toggle extends Command {

    public Toggle() {
        super("Toggle", ".Toggle (module)");
    }

    public void Command(String[] command) {
        try {
            for (Module m : ModuleManager.modules) {
                if (m.getName().equalsIgnoreCase(command[1])) {
                    m.toggle();
                    ChatManager.sendChat(command[1] + " is enabled " + m.isEnabled());
                }
            }


        } catch (Exception e) {
            ChatManager.sendChat("Command Used Incorrectly!" + " Use it like " + this.getUsage());

        }
    }

}
