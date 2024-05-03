package net.prangellplays.chartered.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.prangellplays.chartered.Chartered;

public class CharteredScreenHandlers {
    public static final ScreenHandlerType<CharterScreenHandler> CHARTER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(Chartered.MOD_ID, "charter"),
                    new ExtendedScreenHandlerType<>(CharterScreenHandler::new));

    public static void init() {
        Chartered.LOGGER.info("Register Screen Handlers for " + Chartered.MOD_ID);
    }
}