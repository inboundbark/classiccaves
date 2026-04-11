package net.inboundbark.classiccaves.mixins;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.structure.MineshaftStructure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(MineshaftStructure.class)
public class MineshaftStructureMixin {
    @ModifyExpressionValue(
            method = "<init>*",
            at = @At(value = "CONSTANT", args = "doubleValue=0.004", ordinal = 0 // Only the first assign
            ))
    private double revertChance(double chance) {
        return 0.01D;
    }
}
