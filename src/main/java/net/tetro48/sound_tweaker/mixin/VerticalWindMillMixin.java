package net.tetro48.sound_tweaker.mixin;

import btw.entity.mechanical.source.VerticalWindMillEntity;
import btw.entity.mechanical.source.WindMillEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(VerticalWindMillEntity.class)
public class VerticalWindMillMixin {
    @ModifyArg(method = "clientNotifyGearboxOfOverpoweredOctantChangeInDirection", at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playSound(DDDLjava/lang/String;FF)V", ordinal = 0))
    public String changeOverpoweringSound(String par7Str) {
        return "btw:entity.wind_mill.overpowering";
    }
}
