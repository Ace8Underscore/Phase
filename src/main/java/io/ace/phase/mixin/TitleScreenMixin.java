package io.ace.phase.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin {


    // if we inject at HEAD aka the start of the method our code will be added to minecrafts fade at the begining
    @Inject(at = @At("TAIL"),method = "render", cancellable = true, remap = false)
    public void render(PoseStack p_96739_, int p_96740_, int p_96741_, float p_96742_, CallbackInfo callbackInfo) {
        Minecraft.getInstance().font.draw(p_96739_, "Hacks on 1.18 O_O", 1, 1, -1);
    }

}
