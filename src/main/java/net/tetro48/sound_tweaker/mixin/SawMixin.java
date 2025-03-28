package net.tetro48.sound_tweaker.mixin;

import btw.block.blocks.SawBlock;
import net.minecraft.src.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SawBlock.class)
public class SawMixin {
    @ModifyArg(method = "updateTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playSoundEffect(DDDLjava/lang/String;FF)V", ordinal = 0))
    public String changePowerOnSound(String par7Str) {
        return "btw:block.saw.powered";
    }
    @ModifyArg(method = "updateTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playSoundEffect(DDDLjava/lang/String;FF)V", ordinal = 1))
    public String changePowerOffSound(String par7Str) {
        return "btw:block.saw.unpowered";
    }
    @ModifyArg(method = "scheduleUpdateIfRequired", at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playSoundEffect(DDDLjava/lang/String;FF)V", ordinal = 0))
    public String changeSawCutSound(String par7Str) {
        return "btw:block.saw.cut";
    }
    @Redirect(method = "onEntityCollidedWithBlock", at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playAuxSFX(IIIII)V"))
    public void redirectMobCutSound(World world, int par1, int i, int j, int k, int par5) {
        world.playSoundEffect(i + 0.5D, j + 0.5D, k + 0.5D, "btw:block.saw.cut", 1.5F + world.rand.nextFloat() * 0.1F, 1.9F + world.rand.nextFloat() * 0.1F);
    }
    @Redirect(method = "breakSaw", at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playAuxSFX(IIIII)V"))
    public void redirectSawBreakSound(World world, int par1, int i, int j, int k, int par5) {
        world.playSoundEffect(i + 0.5D, j + 0.5D, k + 0.5D, "btw:block.mechanical.break", 2, 1f);
    }
}
