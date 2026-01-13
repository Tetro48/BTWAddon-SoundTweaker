package net.tetro48.sound_tweaker.mixin;

import btw.client.fx.BTWEffectManager;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Minecraft;
import net.minecraft.src.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(BTWEffectManager.class)
public abstract class BTWEffectManagerMixin {
	@ModifyArg(method = "lambda$initEffects$1", index = 3, at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playSound(DDDLjava/lang/String;FF)V"))
	private static String modifyMobCutSound(String par7Str) {
		return "btw:block.saw.cut";
	}
	@ModifyArgs(method = "lambda$initEffects$3", at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playSound(DDDLjava/lang/String;FF)V"))
	private static void modifyScreamNoise(Args args, Minecraft minecraft, World world, EntityPlayer player, int x, int y, int z, int data) {
		args.set(3, switch (world.getBlockId(x, y, z)) {
			case 92 -> "btw:block.cake.scream";
			case 138 -> "btw:block.beacon.anchor.scream";
			default -> "mob.ghast.scream";
		});
	}
	@ModifyArg(method = "lambda$initEffects$13", index = 3, at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playSound(DDDLjava/lang/String;FF)V"))
	private static String modifyMechanicalBreakSound(String par7Str) {
		return "btw:block.mechanical.break";
	}
}
