package net.peppermint.boilerplatemod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.peppermint.boilerplatemod.BoilerplateMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.peppermint.boilerplatemod.BoilerplateMod;

public class ModItems {
    public static final Item SWEET_POTION = registerItem("sweet_potion",
            new Item(new FabricItemSettings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(BoilerplateMod.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ItemGroups.INGREDIENTS, SWEET_POTION);


    }

    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }
    public static void registerModItems() {
        BoilerplateMod.LOGGER.info("Registering Mod Items for " + BoilerplateMod.MOD_ID);

        addItemsToItemGroup();
    }
}
