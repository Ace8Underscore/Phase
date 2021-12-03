package io.ace.phase.event;

import io.ace.phase.manager.ChatManager;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class LaunchEvent {

    final Minecraft mc = Minecraft.getInstance();

    public LaunchEvent() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void checkChat(ClientChatEvent event) {
        //every chat messsage sent by the client is checked to see if it matches the clients prefix
        if (event.getMessage().startsWith(ChatManager.prefix)) {
            event.setCanceled(true);
            // we do this so the player can up arrow to last sent commands because canceling sending the message does not add it to chat history
            mc.gui.getChat().addRecentChat(event.getOriginalMessage());
            String[] messageInPieces = event.getOriginalMessage().split(" ");
            ChatManager.sentCommand(messageInPieces);
        }
    }
}
