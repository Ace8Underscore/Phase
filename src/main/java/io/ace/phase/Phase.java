package io.ace.phase;

import io.ace.phase.event.LaunchEvent;
import io.ace.phase.manager.BindManager;
import io.ace.phase.manager.ChatManager;
import io.ace.phase.manager.ModuleManager;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("phase")
public class Phase {

    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    private static final  Minecraft mc = Minecraft.getInstance();
    public static final String NAME = "Phase";
    public static final String VERSION = "V0.0.1";
    public static LaunchEvent launchEvent;
    public static ModuleManager moduleManager;
    public static ChatManager chatManager;
    public static BindManager bindManager;

    public Phase() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        MinecraftForge.EVENT_BUS.register(this);
        bindManager = new BindManager();
        moduleManager = new ModuleManager();
        launchEvent = new LaunchEvent();
        chatManager = new ChatManager();
    }


    @SubscribeEvent
    public void onUpdate(TickEvent.WorldTickEvent event) {
        if (mc.level == null || mc.player == null) return;
        //mc.player.sendMessage(Component.nullToEmpty("world is ticking"), mc.player.getUUID());
    }

    //simple text rendering for in game ads
    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Text event) {
        mc.font.draw(event.getMatrixStack(), NAME + "(" + mc.getLaunchedVersion() + ")", 1, 1, -1);

    }
}
