package io.ace.phase.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import io.ace.phase.Phase;
import io.ace.phase.extendable.Module;
import io.ace.phase.gui.componets.TitleComponent;
import io.ace.phase.gui.componets.ToggleComponent;
import io.ace.phase.manager.ModuleManager;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.TextComponent;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

// biggest thing if you dont know how to do something look in the src to see how minecraft did it
// best advice to solve almost any issues^
public class Gui extends Screen {

    int x = 10;
    int y = 10;
    int xSpacing = 0;
    public static ToggleComponent toggleComponent;

    public Gui() {
        super(new TextComponent("menu.game"));
        toggleComponent = new ToggleComponent();
        TitleComponent.init();
    }

    @Override
    public void render(@NotNull PoseStack poseStack, int p_96563_, int p_96564_, float p_96565_) {
        x = 20;
        for (Module.Category category : ModuleManager.categoryArrayList) {
            xSpacing += 6;
            int xChanged = x * xSpacing;
            // this starts off rendering the categorys
            TitleComponent.render(poseStack, category, xChanged, y);

        }

        xSpacing = 0;
        //this.blit(p_96562_, 1, 10, 1, 10, 0, 10);
        Color c = new Color(29, 37, 48, 255);
        //Gui.fill(poseStack, 1, 1, 1 + 100, 1 + 100, c.getRGB());
        super.render(poseStack, p_96563_, p_96564_, p_96565_);
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    public boolean isMouseOver(double x, double y) {
        return super.isMouseOver(x, y);
    }

    @Override
    public boolean mouseClicked(double x, double y, int mouseButton) {
        Phase.LOGGER.info("clicked1");
        if (mouseButton == 0) {
            toggleComponent.mouseClicked(x, y);
            Phase.LOGGER.info("clicked2");
        }
        return super.mouseClicked(x, y, mouseButton);
    }

}
