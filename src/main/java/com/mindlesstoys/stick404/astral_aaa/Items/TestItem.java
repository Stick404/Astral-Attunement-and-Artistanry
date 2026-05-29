package com.mindlesstoys.stick404.astral_aaa.Items;

import com.mindlesstoys.stick404.astral_aaa.Astral_aaa;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.quasar.particle.ParticleEmitter;
import foundry.veil.api.quasar.particle.ParticleSystemManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static com.mindlesstoys.stick404.astral_aaa.Astral_aaa.MODID;

public class TestItem extends Item {
    public TestItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        try {
            ParticleSystemManager manager = VeilRenderSystem.renderer().getParticleManager();
            System.out.println("Got Manager");
            ParticleEmitter emitter = manager.createEmitter(ResourceLocation.fromNamespaceAndPath(MODID, "wind"));
            System.out.println("Got Emitter");
            emitter.setPosition(player.getEyePosition());
            System.out.println("Attached");
            manager.addParticleSystem(emitter);
            System.out.println("Started");
        } catch (Exception ignored) {
            Astral_aaa.LOGGER.debug(ignored.getMessage());
        }

        return InteractionResultHolder.success(stack);
    }
}
