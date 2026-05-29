package com.mindlesstoys.stick404.astral_aaa.Block.Entites;

import com.klikli_dev.modonomicon.api.ModonomiconAPI;
import com.klikli_dev.modonomicon.api.multiblock.Multiblock;
import com.mindlesstoys.stick404.astral_aaa.Block.MultiBlockTest;
import com.mindlesstoys.stick404.astral_aaa.Register.AAABlockEntites;
import com.mindlesstoys.stick404.astral_aaa.Register.AAABlocks;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import team.lodestar.lodestone.helpers.RandomHelper;
import team.lodestar.lodestone.systems.easing.Easing;
import team.lodestar.lodestone.systems.multiblock.MultiBlockCoreEntity;
import team.lodestar.lodestone.systems.multiblock.MultiBlockStructure;
import team.lodestar.lodestone.systems.multiblock.MultiBlockStructure.StructurePiece;
import team.lodestar.lodestone.systems.particle.ParticleEffectSpawner;
import team.lodestar.lodestone.systems.particle.SimpleParticleOptions;
import team.lodestar.lodestone.systems.particle.builder.WorldParticleBuilder;
import team.lodestar.lodestone.systems.particle.data.GenericParticleData;
import team.lodestar.lodestone.systems.particle.data.spin.SpinParticleData;
import team.lodestar.lodestone.systems.particle.world.LodestoneWorldParticle;
import team.lodestar.lodestone.systems.particle.world.options.LodestoneItemCrumbsParticleOptions;
import team.lodestar.lodestone.systems.particle.world.type.LodestoneItemCrumbsParticleType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static com.mindlesstoys.stick404.astral_aaa.Astral_aaa.MODID;

public class MultiBlockTestEntity extends MultiBlockCoreEntity {
    public static final MultiBlockStructure TEST_STRUCTURE = new MultiBlockStructure(new ArrayList<>(List.of(new MultiBlockStructure.StructurePiece[]{
            new StructurePiece(0, 0, 0, AAABlocks.MULTI_BLOCK_TEST_BLOCK.get().defaultBlockState()),
            new StructurePiece(0, 1, 0, Blocks.DIAMOND_BLOCK.defaultBlockState()),
            new StructurePiece(0, 2, 0, Blocks.BEACON.defaultBlockState())
    })) );

    public static final Multiblock TEST_MULTI_BLOCK = ModonomiconAPI.get().getMultiblock(ResourceLocation.fromNamespaceAndPath(MODID, "test"));

    public MultiBlockTestEntity(BlockPos pos, BlockState state) {
        super(AAABlockEntites.MULTIBLOCK_TEST.get(), TEST_STRUCTURE, pos, state);
    }

    @Override
    public void commonTick(Level level) {
        if (level.getGameTime() % 40 == 0 && level instanceof ClientLevel) {
            if (TEST_MULTI_BLOCK.validate(level, this.worldPosition, Rotation.NONE)){
                System.out.println("True!!");
                final Consumer<LodestoneWorldParticle> slowDown = p -> p.setParticleSpeed(p.getParticleSpeed().scale(0.925f));
                var options = new LodestoneItemCrumbsParticleOptions(LodestoneItemCrumbsParticleType::new, Items.DIAMOND.getDefaultInstance());
                var part = WorldParticleBuilder.create(options)
                        .setSpinData(SpinParticleData.create(0.7f))
                        .setTransparencyData(GenericParticleData.create(0.5f, 1f, 0.25f).setEasing(Easing.EXPO_IN, Easing.SINE_IN_OUT).build())
                        .setScaleData(GenericParticleData.create(0.05f, RandomHelper.randomBetween(level.random, 0.06f, 0.07f), 0f).build())
                        .setRenderType(ParticleRenderType.TERRAIN_SHEET)
                        .addTickActor(slowDown);
                ParticleEffectSpawner particleEffectSpawner = new ParticleEffectSpawner(level, worldPosition.getCenter(), part);
                particleEffectSpawner.spawnParticles();
            }
        }
    }

    @Override
    public void serverTick(ServerLevel level) {
        super.serverTick(level);
        if (level.getGameTime() % 40 == 0) {

        }
    }
}
