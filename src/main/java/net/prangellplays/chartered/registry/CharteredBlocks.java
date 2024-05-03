package net.prangellplays.chartered.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.prangellplays.chartered.Chartered;

public class CharteredBlocks {
    //public static final Block VITALITUS_BEACON = registerBlock("vitalitus_beacon",
    //        new Block(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS).strength(4.0f).requiresTool().dropsNothing().hardness(-1f).luminance(state -> 15).sounds(BlockSoundGroup.AMETHYST_BLOCK)), ItemGroups.BUILDING_BLOCKS);


    private static Block registerBlock(String name, Block block, RegistryKey<ItemGroup> group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(Chartered.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, RegistryKey<ItemGroup> group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(Chartered.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return item;
    }

    public static void init() {
        Chartered.LOGGER.info("Registering ModBlocks for " + Chartered.MOD_ID);
    }
}
