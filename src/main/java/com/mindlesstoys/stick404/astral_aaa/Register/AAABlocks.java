package com.mindlesstoys.stick404.astral_aaa.Register;

import com.mindlesstoys.stick404.astral_aaa.Block.MultiBlockTest;
import net.minecraft.world.item.BlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.mindlesstoys.stick404.astral_aaa.Astral_aaa.MODID;

public class AAABlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    public static final DeferredBlock<MultiBlockTest> MULTI_BLOCK_TEST_BLOCK = BLOCKS.registerBlock("multi_block_test_block",
            MultiBlockTest::new);
    public static final DeferredItem<BlockItem> MULTI_BLOCK_TEST_BLOCK_ITEM = ITEMS.registerSimpleBlockItem(MULTI_BLOCK_TEST_BLOCK);

    public static void register(IEventBus bus){
        BLOCKS.register(bus);
        ITEMS.register(bus);
    }
}
