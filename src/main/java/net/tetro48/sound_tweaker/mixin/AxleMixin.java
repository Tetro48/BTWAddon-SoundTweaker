package net.tetro48.sound_tweaker.mixin;

import btw.block.blocks.AxleBlock;
import net.minecraft.src.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AxleBlock.class)
public class AxleMixin {
    @ModifyArg(method = "randomDisplayTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playSound(DDDLjava/lang/String;FF)V", ordinal = 0))
    public String changeAmbientSound(String par7Str){
        return "btw:block.mechanical.ambient";
    }
}
