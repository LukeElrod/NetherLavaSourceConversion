package com.lukeelrod.examplemod.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.LavaFluid;

@Mixin(LavaFluid.class)
public class LavaFluidMixin {
    @Inject(method = "canConvertToSource", at = @At("HEAD"), cancellable = true)
    private void canConvertToSource(Level level, CallbackInfoReturnable<Boolean> cir) {
        if (level.dimension().location().toString().equals("minecraft:the_nether")) {
            cir.setReturnValue(true);
        }
    }
}
