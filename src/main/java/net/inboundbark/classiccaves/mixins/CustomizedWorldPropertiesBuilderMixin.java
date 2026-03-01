package net.inboundbark.classiccaves.mixins;

import net.minecraft.world.gen.CustomizedWorldProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(CustomizedWorldProperties.Builder.class)
public class CustomizedWorldPropertiesBuilderMixin {
    @Shadow
    public int dungeonChance;

    @Inject(
            method = "resetToDefault",
            at = @At("TAIL")
    )
    private void doubleDungeonChance(CallbackInfo ci) {
        dungeonChance = 16;
    }
}
