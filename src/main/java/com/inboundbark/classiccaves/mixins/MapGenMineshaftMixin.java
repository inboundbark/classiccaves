package com.inboundbark.classiccaves.mixins;

import io.github.tox1cozz.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.world.gen.structure.MapGenMineshaft;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.inboundbark.classiccaves.Config;

@Mixin(MapGenMineshaft.class)
public class MapGenMineshaftMixin {

    @ModifyExpressionValue(
        method = "<init>()V",
        at = @At(value = "CONSTANT", args = "doubleValue=0.004", ordinal = 0 // Only the first assign
        ))
    private double revertChance1(double chance) {
        return Config.higherMineshaftChance ? 0.01D : chance;
    }

    @ModifyExpressionValue(
        method = "<init>(Ljava/util/Map;)V",
        at = @At(value = "CONSTANT", args = "doubleValue=0.004", ordinal = 0 // Only the first assign
        ))
    private double revertChance2(double chance) {
        return Config.higherMineshaftChance ? 0.01D : chance;
    }
    // Annoying code duplication because it didn't understand the wildcard "<init>*"
}
