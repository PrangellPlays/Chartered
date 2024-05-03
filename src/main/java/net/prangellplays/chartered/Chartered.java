package net.prangellplays.chartered;

import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import net.prangellplays.chartered.registry.CharteredBlocks;
import net.prangellplays.chartered.registry.CharteredItems;
import net.prangellplays.chartered.screen.CharteredScreenHandlers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
public class Chartered implements ModInitializer {
	public static final String MOD_ID = "chartered";
	public static final Logger LOGGER = LoggerFactory.getLogger("chartered");

	@Override
	public void onInitialize() {
		CharteredItems.init();
		CharteredBlocks.init();
		CharteredScreenHandlers.init();
	}
	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}
}