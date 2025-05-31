package net.tetro48.sound_tweaker.mixin;

import net.minecraft.src.BlockBeacon;
import net.minecraft.src.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BlockBeacon.class)
public class BlockBeaconMixin {
    @ModifyArg(method = "breakBlock", at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playSoundEffect(DDDLjava/lang/String;FF)V"), index = 3)
    public String changeDeactivateSound(String par7Str) {
        return "btw:block.beacon.deactivate";
    }
    @ModifyArg(method = "onBlockActivated", at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playSoundEffect(DDDLjava/lang/String;FF)V"), index = 3)
    public String changeActivateSound(String par7Str) {
        return "btw:block.beacon.activate";
    }
}
