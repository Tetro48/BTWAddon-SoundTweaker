package net.tetro48.sound_tweaker.mixin;

import btw.block.tileentity.beacon.SpawnAnchorBeaconEffect;
import net.minecraft.src.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SpawnAnchorBeaconEffect.class)
public class SpawnAnchorBeaconEffectMixin {
    @Redirect(method = "checkPlayerSpawnedAtBeacon", at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playAuxSFX(IIIII)V"))
    public void changeRespawnSound(World world, int auxID, int x, int y, int z, int data) {
        world.playSound(x, y, z, "btw:block.beacon.anchor.scream", 1.0F, world.rand.nextFloat() * 0.4F + 0.25F);
    }
    @ModifyArg(method = "checkPlayerSpawnedAtBeacon", at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playSoundEffect(DDDLjava/lang/String;FF)V"), index = 3)
    public String changeRespawnSound(String par7Str) {
        return "btw:block.beacon.anchor.respawn";
    }
    @ModifyArg(method = "onPowerOn", at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playSound(DDDLjava/lang/String;FF)V"), index = 3)
    public String changeActivateSound(String par7Str) {
        return "btw:block.beacon.anchor.scream";
    }
    @ModifyArg(method = "playSoundEffect", at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playSound(DDDLjava/lang/String;FF)V"), index = 3)
    public String changeAmbientSound(String par7Str) {
        return "btw:block.beacon.anchor.ambient";
    }
}
