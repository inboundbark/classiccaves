package net.inboundbark.classiccaves.mixins;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.world.gen.carver.CaveCarver;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;


@Mixin(CaveCarver.class)
public class CaveCarverMixin {
    @ModifyExpressionValue(
            method = "carve",
            at = @At(value = "CONSTANT", args = "intValue=15", ordinal = 0))
    private int return40(int integer) {
        return 40;
    }

    @ModifyExpressionValue(
            method = "carve",
            at = @At(value = "CONSTANT", args = "intValue=7", ordinal = 0))
    private int return15(int integer) {
        return 15;
    }
}