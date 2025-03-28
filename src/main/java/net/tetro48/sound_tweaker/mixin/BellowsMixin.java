package net.tetro48.sound_tweaker.mixin;

import btw.block.blocks.BellowsBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(BellowsBlock.class)
public class BellowsMixin {
    @ModifyArg(method = "clientNotificationOfMetadataChange", at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playSound(DDDLjava/lang/String;FF)V", ordinal = 0))
    public String changeBlowSound (String par7Str){
        return "btw:block.bellows.blow";
    }
    @ModifyArg(method = "clientNotificationOfMetadataChange", at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playSound(DDDLjava/lang/String;FF)V", ordinal = 1))
    public String changeSuckSound (String par7Str){
        return "btw:block.bellows.suck";
    }
}
