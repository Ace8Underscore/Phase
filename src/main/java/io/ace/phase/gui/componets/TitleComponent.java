package io.ace.phase.gui.componets;

import com.mojang.blaze3d.vertex.PoseStack;
import io.ace.phase.extendable.Module;
import io.ace.phase.gui.Gui;
import io.ace.phase.manager.ModuleManager;
import net.minecraft.client.Minecraft;

import java.awt.*;

public class TitleComponent extends Component {

    public static int titleWidth = 40;
    public static int titleHeight = 5;
    public static int ySpacing = 0;

    public static void init() {
        //render(poseStack);
        //toggleComponent = new ToggleComponent();
    }

    public static void render(PoseStack poseStack, Module.Category category, int x, int y) {
        for (Module module : ModuleManager.modules) {
            if (module.getCategory().equals(category))  {
                ySpacing += 15;
                Gui.toggleComponent.render(poseStack, module, x, y + ySpacing);
            }
        }
        ySpacing = 0;
        // color for the category titles
        Color c = new Color(29, 37, 48, 255);
        Gui.fill(poseStack, x - titleWidth, y - titleHeight, x + titleWidth, y + (titleHeight * 2), c.getRGB());
        Gui.drawCenteredString(poseStack, Minecraft.getInstance().font, category.name(), x, y, -1);
    }

}
