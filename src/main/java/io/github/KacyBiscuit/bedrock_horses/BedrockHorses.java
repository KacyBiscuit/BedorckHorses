package io.github.KacyBiscuit.bedrock_horses;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BedrockHorses implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Bedrock Horses");

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("Loading...");
	}
}
