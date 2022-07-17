package io.github.KacyBiscuit.bedrock_horses;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import io.github.KacyBiscuit.bedrock_horses.Enchantments.BetterCursesEnchantments;
import net.minecraft.command.CommandBuildContext;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.command.api.CommandRegistrationCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BedrockHorses implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Better Curses");

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("Loading...", mod.metadata().name());
		new BetterCursesEnchantments();
		CommandRegistrationCallback.EVENT.register(this::register);
	}

	private void register(CommandDispatcher<ServerCommandSource> serverCommandSourceCommandDispatcher, CommandBuildContext commandBuildContext, CommandManager.RegistrationEnvironment registrationEnvironment) {
		serverCommandSourceCommandDispatcher.register(CommandManager.literal("getLuck").executes(this::run));
	}

	private int run(CommandContext<ServerCommandSource> serverCommandSourceCommandContext) throws CommandSyntaxException {
			serverCommandSourceCommandContext.getSource().sendFeedback(Text.of(Float.toString(serverCommandSourceCommandContext.getSource().getPlayer().getLuck())), false);
		return 1;
	}
}
