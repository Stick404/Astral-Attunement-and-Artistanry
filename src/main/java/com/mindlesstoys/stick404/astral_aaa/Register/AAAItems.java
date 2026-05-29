package com.mindlesstoys.stick404.astral_aaa.Register;

import com.mindlesstoys.stick404.astral_aaa.Items.TestItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.mindlesstoys.stick404.astral_aaa.Astral_aaa.MODID;

public class AAAItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    public static final DeferredItem<TestItem> TEST_ITEM = ITEMS.registerItem("test_item", TestItem::new);

    public static void register(IEventBus bus){
        ITEMS.register(bus);
    }
}
