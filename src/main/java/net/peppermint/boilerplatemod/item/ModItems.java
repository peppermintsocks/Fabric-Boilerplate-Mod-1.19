package net.peppermint.boilerplatemod.item;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.peppermint.boilerplatemod.BoilerplateMod;

public class ModItems {

//    ItemGroup PEPPERMINT_ITEMS = FabricItemGroup.builder(new Identifier("boilerplatemod", "peppermint_items"))
//            .displayName(Text.literal("Peppermint's Items"))
//            .icon(() -> new ItemStack(Items.BEEHIVE))
//            .build();

    private static Item registerItem (String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(BoilerplateMod.MOD_ID, name), item);
    }

    public static final Item SWEET_POTION = registerItem("sweet_potion", new Item(new FabricItemSettings()));

    public static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void addItemsToItemGroup(){
        addToItemGroup(ItemGroups.INGREDIENTS, SWEET_POTION);
    }

    public static void registerModItems(){
        BoilerplateMod.LOGGER.debug("Registering Mod Items for " + BoilerplateMod.MOD_ID);
        addItemsToItemGroup();
    }



}
