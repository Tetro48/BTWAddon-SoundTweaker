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
}
