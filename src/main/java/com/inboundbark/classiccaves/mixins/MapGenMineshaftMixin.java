package com.inboundbark.classiccaves.mixins;

import net.minecraft.world.gen.structure.MapGenMineshaft;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.inboundbark.classiccaves.Config;

import io.github.tox1cozz.mixinextras.injector.ModifyExpressionValue;

@Mixin(MapGenMineshaft.class)
public class MapGenMineshaftMixin {

    @ModifyExpressionValue(
        method = { "<init>()V", "<init>(Ljava/util/Map;)V" },
        at = @At(value = "CONSTANT", args = "doubleValue=0.004", ordinal = 0 // Only the first assign
        ))
    private double revertChance(double chance) {
        return Config.higherMineshaftChance ? 0.01D : chance;
    }
}
