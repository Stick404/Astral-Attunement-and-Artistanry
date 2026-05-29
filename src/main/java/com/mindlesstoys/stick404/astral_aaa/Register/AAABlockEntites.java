package com.mindlesstoys.stick404.astral_aaa.Register;

import com.mindlesstoys.stick404.astral_aaa.Block.Entites.MultiBlockTestEntity;
import net.minecraft.Util;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import team.lodestar.lodestone.systems.multiblock.MultiBlockItem;

import static com.mindlesstoys.stick404.astral_aaa.Astral_aaa.MODID;
import static com.mindlesstoys.stick404.astral_aaa.Register.AAABlocks.MULTI_BLOCK_TEST_BLOCK;

public class AAABlockEntites {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, MODID);
    public static final DeferredRegister.Blocks MULTI_BLOCK_BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredRegister.Items MULTI_BLOCK_ITEMS = DeferredRegister.createItems(MODID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MultiBlockTestEntity>> MULTIBLOCK_TEST = BLOCK_ENTITY_TYPES.register("multiblock_test_entity", (a) ->
            BlockEntityType.Builder.of(MultiBlockTestEntity::new, MULTI_BLOCK_TEST_BLOCK.get())
                    .build(Util.fetchChoiceType(References.BLOCK_ENTITY, a.getPath())));

    public static final DeferredBlock<Block> MULTIBLOCK_BLOCK_TEST_ITEM = MULTI_BLOCK_BLOCKS.registerSimpleBlock("multiblock_test_placer");
    public static final DeferredItem<MultiBlockItem> MULTIBLOCK_TEST_ITEM = MULTI_BLOCK_ITEMS.register("multiblock_test_item", a ->
            new MultiBlockItem(MULTIBLOCK_BLOCK_TEST_ITEM.get(), new Item.Properties(), () -> MultiBlockTestEntity.TEST_STRUCTURE));

    public static void register(IEventBus bus){
        BLOCK_ENTITY_TYPES.register(bus);
        MULTI_BLOCK_BLOCKS.register(bus);
        MULTI_BLOCK_ITEMS.register(bus);
    }
}
