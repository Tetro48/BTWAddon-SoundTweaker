package net.tetro48.sound_tweaker.mixin;

import btw.client.fx.BTWEffectManager;
import net.minecraft.src.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BTWEffectManager.class)
public abstract class BTWEffectManagerMixin {
	@ModifyArg(method = "lambda$initEffects$1", index = 3, at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playSound(DDDLjava/lang/String;FF)V"))
	private static String modifyMobCutSound(String par7Str) {
		return "btw:block.saw.cut";
	}
	@Redirect(method = "lambda$initEffects$3", at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playSound(DDDLjava/lang/String;FF)V"))
	private static void modifyScreamNoise(World world, double x, double y, double z, String soundID, float volume, float pitch) {
		switch (world.getBlockId((int) x, (int) y, (int) z)) {
			case 92: soundID = "btw:block.cake.scream"; break;
			case 138: soundID = "btw:block.beacon.anchor.scream"; break;
			default: break;
		}
		world.playSound(x, y, z, soundID, volume, pitch);
	}
	@ModifyArg(method = "lambda$initEffects$13", index = 3, at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playSound(DDDLjava/lang/String;FF)V"))
	private static String modifyMechanicalBreakSound(String par7Str) {
		return "btw:block.mechanical.break";
	}
}
