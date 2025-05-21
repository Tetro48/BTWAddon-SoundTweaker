package net.tetro48.sound_tweaker.mixin;

import btw.client.fx.BTWEffectManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(BTWEffectManager.class)
public abstract class BTWEffectManagerMixin {
	@ModifyArg(method = "lambda$initEffects$1", index = 3, at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playSound(DDDLjava/lang/String;FF)V"))
	private static String modifyMobCutSound(String par7Str) {
		return "btw:block.saw.cut";
	}
	@ModifyArg(method = "lambda$initEffects$13", index = 3, at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playSound(DDDLjava/lang/String;FF)V"))
	private static String modifyMechanicalBreakSound(String par7Str) {
		return "btw:block.mechanical.break";
	}
}
