package net.tetro48.sound_tweaker.mixin;

import api.block.beacon.BeaconEffect;
import net.minecraft.src.BlockBeacon;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(BeaconEffect.class)
public class BeaconEffectMixin {
    @ModifyArg(method = "onPowerOff", at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playSound(DDDLjava/lang/String;FF)V"), index = 3)
    public String changeDeactivateSound(String par7Str) {
        return "btw:block.beacon.deactivate";
    }
    @ModifyArg(method = "onPowerOn", at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playSound(DDDLjava/lang/String;FF)V"), index = 3)
    public String changeActivateSound(String par7Str) {
        return "btw:block.beacon.activate";
    }
}
