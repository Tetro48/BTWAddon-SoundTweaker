package net.tetro48.sound_tweaker.mixin;

import net.minecraft.src.SoundManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(SoundManager.class)
public class SoundManagerMixin {
	@ModifyConstant(method = "playSound", constant = @Constant(intValue = 256))
	private int changeMaxSounds(int constant) {
		return 4096;
	}
	@ModifyConstant(method = "playSoundFX", constant = @Constant(intValue = 256))
	private int changeMaxSoundsFX(int constant) {
		return 4096;
	}
}
