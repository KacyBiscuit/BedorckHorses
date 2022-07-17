package io.github.KacyBiscuit.bedrock_horses.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.HorseBaseEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HorseBaseEntity.class)
public abstract class HorseBaseEntityMixin extends AnimalEntity {

	@Shadow
	protected abstract double getChildMovementSpeedBonus(RandomGenerator randomGenerator);

	protected HorseBaseEntityMixin(EntityType<? extends AnimalEntity> entityType, World world) {
		super(entityType, world);
	}

	@Inject(method = "setChildAttributes",
			at = @At("TAIL"))
	private void setChildAttributes(PassiveEntity mate, HorseBaseEntity child, CallbackInfo ci) {
		double f = this.getMovementSpeed()
				+ mate.getMovementSpeed()
				+ this.getChildMovementSpeedBonus(this.random);
		child.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue(f / 3.0);
	}
}
