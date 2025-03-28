package net.tetro48.sound_tweaker.mixin;

import net.minecraft.src.Container;
import net.minecraft.src.ContainerEnchantment;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(ContainerEnchantment.class)
public class ContainerEnchantmentMixin {
    @Shadow private World worldPointer;

    @ModifyArg(method = "enchantItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playSoundAtEntity(Lnet/minecraft/src/Entity;Ljava/lang/String;FF)V"), index = 1)
    public String changeEnchantmentSoundName(String par2Str) {

        return "btw:block.enchantment_table.enchant";
    }
    @ModifyArg(method = "enchantItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playSoundAtEntity(Lnet/minecraft/src/Entity;Ljava/lang/String;FF)V"), index = 2)
    public float changeEnchantmentVolume(float par3) {
        return par3 * 2;
    }
    @ModifyArg(method = "enchantItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playSoundAtEntity(Lnet/minecraft/src/Entity;Ljava/lang/String;FF)V"), index = 3)
    public float changeEnchantmentPitch(float par3) {
        return par3 * 2;
    }
}
