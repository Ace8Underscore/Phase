package io.ace.phase.gui.componets;

import com.mojang.blaze3d.vertex.PoseStack;
import io.ace.phase.Phase;
import io.ace.phase.extendable.Module;
import io.ace.phase.gui.Gui;
import io.ace.phase.module.client.ClickGui;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.awt.*;

public class ToggleComponent extends Component {

    public ToggleComponent() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    int x = 0;
    int y = 0;
    Module module;

    public void render(PoseStack poseStack, Module module, int x, int y) {
        Color c = new Color(29, 37, 48, 255);
        Gui.fill(poseStack, x - TitleComponent.titleWidth, y - TitleComponent.titleHeight, x + TitleComponent.titleWidth, y + (TitleComponent.titleHeight * 2), c.getRGB());
        Gui.drawCenteredString(poseStack, Minecraft.getInstance().font, module.getName(), x, y, module.isEnabled() ? 16777216 : -1);
        this.x = x;
        this.y = y;
        this.module = module;


    }

    public void mouseClicked(double mouseX, double mouseY) {
        Phase.LOGGER.info(mouseX + ":Mouse:" + mouseY);
        //if (this.module.getName().equalsIgnoreCase("POC")) Phase.LOGGER.info(this.x + " " + this.y);
        if (isMouseOver(mouseX, mouseY)) {
            Phase.LOGGER.info("clickedover");
            this.module.toggle();
        }
    }

    public boolean isMouseOver(double mouseX, double mouseY) {
        return (mouseX < x + TitleComponent.titleHeight && mouseX > x - TitleComponent.titleHeight && mouseY < y + (TitleComponent.titleHeight * 2) && mouseY > y - TitleComponent.titleHeight);
    }



}
