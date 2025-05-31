package net.tetro48.sound_tweaker.mixin;

import net.minecraft.src.BlockCake;
import net.minecraft.src.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BlockCake.class)
public abstract class BlockCakeMixin {
	@Redirect(method = "onNeighborBlockChange", at = @At(value = "INVOKE", target = "Lnet/minecraft/src/World;playAuxSFX(IIIII)V"))
	public void changePowerOnScreamSound(World world, int auxID, int x, int y, int z, int data) {
		world.playSoundEffect(x, y, z, "btw:block.cake.scream", 1.0F, world.rand.nextFloat() * 0.4F + 0.8F);
	}
}
