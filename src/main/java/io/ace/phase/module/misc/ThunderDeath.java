package io.ace.phase.module.misc;

import io.ace.phase.extendable.Module;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ThunderDeath extends Module {

    public ThunderDeath() {
        super("ThunderDeath", Category.MISC);
    }

    LightningBolt e;

    @SubscribeEvent
    public void onUpdate(TickEvent.PlayerTickEvent event) {
        if (mc.level == null || mc.player == null) return;
        if (e != null) e.tick();
        for (Player p : mc.level.players()) {
            if (p.isDeadOrDying()) {
                e = new LightningBolt(EntityType.LIGHTNING_BOLT, mc.level);
                e.setId(-1746164);
                e.setPos(p.position());
                e.hurtMarked = false;
                e.noPhysics = false;
                e.hasImpulse = true;
                e.level.oThunderLevel = 1;
                e.level.thunderLevel = 1;
                mc.level.putNonPlayerEntity(e.getId(), e);
                e.tick();
            }
        }

    }
}
