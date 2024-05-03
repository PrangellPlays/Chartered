package net.prangellplays.chartered;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.prangellplays.chartered.screen.CharterScreen;
import net.prangellplays.chartered.screen.CharteredScreenHandlers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CharteredClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		HandledScreens.register(CharteredScreenHandlers.CHARTER_SCREEN_HANDLER, CharterScreen::new);
	}
}