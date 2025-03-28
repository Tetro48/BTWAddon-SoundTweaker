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
    @Redirect(method = "onBlockActivated", at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playAuxSFX(IIIII)V"))
    public void changeScreamNoise(World world, int id, int i, int j, int k, int par5) {
        world.playSoundEffect(i + 0.5D, j + 0.5D, k + 0.5D, "btw:block.beacon.anchor.scream", 1.0F + world.rand.nextFloat() * 0.1F, 1.0F + world.rand.nextFloat() * 0.1F);
    }
}
