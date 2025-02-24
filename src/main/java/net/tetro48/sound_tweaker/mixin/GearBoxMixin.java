package net.tetro48.sound_tweaker.mixin;

import btw.block.blocks.GearBoxBlock;
import net.minecraft.src.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(GearBoxBlock.class)
public class GearBoxMixin {
    @ModifyArg(method = "clientNotificationOfMetadataChange", at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playSound(DDDLjava/lang/String;FF)V", ordinal = 0))
    public String changeCreakSound(String par7Str) {
        return "btw:gearbox.ambient";
    }
    @Redirect(method = "breakGearBox", at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playAuxSFX(IIIII)V", ordinal = 0))
    public void redirectSoundPlay(World world, int par1, int i, int j, int k, int par5) {
        world.playSoundEffect(i + 0.5D, j + 0.5D, k + 0.5D, "btw:mechanical.break", 2f, 0.9f + world.rand.nextFloat() * 0.1f);
    }
}
