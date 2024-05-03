package net.prangellplays.chartered.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.prangellplays.chartered.Chartered;
import net.prangellplays.chartered.item.CharterItem;
import net.prangellplays.chartered.item.SignedCharterItem;

public class CharteredItems {
    public static final Item CHARTER = registerItem("charter", new CharterItem(new FabricItemSettings().maxCount(1).fireproof().rarity(Rarity.EPIC)));
    public static final Item SIGNED_CHARTER = registerItem("signed_charter", new SignedCharterItem(new FabricItemSettings().maxCount(1).fireproof().rarity(Rarity.EPIC)));

    private static void addItemsToBuildingItemGroup(FabricItemGroupEntries entries){
    }
    private static void addItemsToColoredItemGroup(FabricItemGroupEntries entries){
    }
    private static void addItemsToNaturalItemGroup(FabricItemGroupEntries entries){
    }
    private static void addItemsToFunctionalItemGroup(FabricItemGroupEntries entries){
    }
    private static void addItemsToRedstoneItemGroup(FabricItemGroupEntries entries){
    }
    private static void addItemsToToolsItemGroup(FabricItemGroupEntries entries) {
        entries.add(CHARTER);
    }
    private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries){
    }
    private static void addItemsToFoodItemGroup(FabricItemGroupEntries entries){
    }
    private static void addItemsToIngredientsItemGroup(FabricItemGroupEntries entries){
    }
    private static void addItemsToSpawnItemGroup(FabricItemGroupEntries entries){
    }
    private static void addItemsToOperatorItemGroup(FabricItemGroupEntries entries){
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Chartered.MOD_ID, name), item);
    }

    public static void init() {
        Chartered.LOGGER.info("Registering Mod Items for " + Chartered.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(CharteredItems::addItemsToBuildingItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(CharteredItems::addItemsToColoredItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(CharteredItems::addItemsToNaturalItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(CharteredItems::addItemsToFunctionalItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(CharteredItems::addItemsToRedstoneItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(CharteredItems::addItemsToToolsItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(CharteredItems::addItemsToCombatItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(CharteredItems::addItemsToFoodItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(CharteredItems::addItemsToIngredientsItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(CharteredItems::addItemsToSpawnItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.OPERATOR).register(CharteredItems::addItemsToOperatorItemGroup);
    }
}
