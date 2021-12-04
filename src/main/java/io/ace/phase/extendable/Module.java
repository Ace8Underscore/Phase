package io.ace.phase.extendable;

import io.ace.phase.manager.ChatManager;
import net.minecraft.ChatFormatting;
import net.minecraft.client.KeyboardHandler;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

import java.util.ArrayList;

public class Module {

    public final Minecraft mc = Minecraft.getInstance();

    String name;
    String description;
    Category category;
    boolean isEnabled;
    KeyboardHandler keyboardHandler;
    int bindKeyCode = -1;

    public Module(String name, String description, Category category) {
        this.name = name;
        this.description = description;
        this.category = category;
        //isEnabled = false;

    }

    public Module(String name, Category category) {
        this.name = name;
        this.category = category;

    }

    public void onEnable() {
        MinecraftForge.EVENT_BUS.register(this);
        ChatManager.sendHotBarChat(ChatFormatting.GREEN + this.getName() + " Was Enabled");
    }

    public void onDisable() {
        MinecraftForge.EVENT_BUS.unregister(this);
        ChatManager.sendHotBarChat(ChatFormatting.RED + this.getName() + " Was Disabled");
    }

    public void enable() {
        this.isEnabled = true;
        this.onEnable();
    }

    public void disable() {
        this.isEnabled = false;
        this.onDisable();
    }

    public void toggle() {
        if (!this.isEnabled) this.enable();
        else this.disable();
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public String getName() {
        return this.name;
    }

    public int getBindKeyCode() {return this.bindKeyCode;}

    public void setBindKeyCode(int bindKeyCode) {this.bindKeyCode = bindKeyCode;}

    public Category getCategory() {return this.category;}


    public static enum Category {
        COMBAT,
        GUI,
        MISC,
    }

}
