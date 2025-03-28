package net.tetro48.sound_tweaker.mixin;

import btw.block.blocks.MillstoneBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(MillstoneBlock.class)
public class MillstoneBlockMixin {
    @ModifyArg(method = "randomDisplayTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playSound(DDDLjava/lang/String;FF)V", ordinal = 0))
    public String changeInvalidSound(String par7Str) {
        return "btw:block.mill_stone.invalid";
    }
    @ModifyArg(method = "randomDisplayTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playSound(DDDLjava/lang/String;FF)V", ordinal = 1))
    public String changeActiveSound(String par7Str) {
        return "btw:block.mill_stone.active";
    }
    @ModifyArg(method = "randomDisplayTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playSound(DDDLjava/lang/String;FF)V", ordinal = 2))
    public String changeIdleSound(String par7Str) {
        return "btw:block.mill_stone.idle";
    }
    @ModifyArg(method = "randomDisplayTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playSound(DDDLjava/lang/String;FF)V", ordinal = 3))
    public String changeNetherrackSound(String par7Str) {
        return "btw:block.mill_stone.netherrack";
    }
    @ModifyArg(method = "randomDisplayTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playSound(DDDLjava/lang/String;FF)V", ordinal = 4))
    public String changeCompanionCubeSound(String par7Str) {
        return "btw:block.mill_stone.wolf_cube";
    }
    @ModifyArg(method = "clientNotificationOfMetadataChange", at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playSound(DDDLjava/lang/String;FF)V", ordinal = 0))
    public String changeCompanionCubeSoundPowerOn(String par7Str) {
        return "btw:block.mill_stone.wolf_cube";
    }
    @ModifyArg(method = "clientNotificationOfMetadataChange", at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playSound(DDDLjava/lang/String;FF)V", ordinal = 1))
    public String changePowerOnSound(String par7Str) {
        return "btw:block.mill_stone.idle";
    }
}
