package net.prangellplays.chartered.item;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.OverlayMessageS2CPacket;
import net.minecraft.network.packet.s2c.play.TitleS2CPacket;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.prangellplays.chartered.registry.CharteredItems;
import net.prangellplays.chartered.screen.CharterScreen;
import net.prangellplays.chartered.screen.CharterScreenHandler;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class CharterItem extends Item {
    private static final Text TITLE = Text.literal("Charter");
    public CharterItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user.isInSneakingPose()) {
            user.setStackInHand(hand, CharteredItems.SIGNED_CHARTER.getDefaultStack());
            if (user instanceof ServerPlayerEntity serverPlayerEntity) {
                serverPlayerEntity.networkHandler.sendPacket(new TitleS2CPacket(Text.literal("Your fate has been sealed...").formatted(Formatting.DARK_RED).formatted(Formatting.UNDERLINE)));
            }
            world.playSound(user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_TOTEM_USE, SoundCategory.MASTER, 100.0F, (-1.0F + (new Random().nextFloat() - new Random().nextFloat()) * 0.2F) * 0.7F, false);
            MinecraftClient.getInstance().gameRenderer.showFloatingItem(CharteredItems.SIGNED_CHARTER.getDefaultStack());
            return TypedActionResult.success(user.getStackInHand(hand));
        } else {
            //user.openHandledScreen(createScreenHandlerFactory());
            return TypedActionResult.pass(user.getStackInHand(hand));
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.literal("Sign the charter").formatted(Formatting.GOLD));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }

    //public NamedScreenHandlerFactory createScreenHandlerFactory() {
   //     return new SimpleNamedScreenHandlerFactory((i, playerInventory, playerEntity) -> new CharterScreenHandler(i, playerInventory), TITLE);
   //
}
