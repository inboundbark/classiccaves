package com.inboundbark.classiccaves.mixins;

import net.minecraft.world.gen.MapGenCaves;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.inboundbark.classiccaves.Config;

import io.github.tox1cozz.mixinextras.injector.ModifyExpressionValue;

@Mixin(value = MapGenCaves.class)
public abstract class MapGenCavesMixin {

    @ModifyExpressionValue(method = "func_151538_a", at = @At(value = "CONSTANT", args = "intValue=15", ordinal = 0))
    private int return40(int integer) {
        return Config.higherCaveFrequency ? 40 : integer;
    }

    @ModifyExpressionValue(method = "func_151538_a", at = @At(value = "CONSTANT", args = "intValue=7", ordinal = 0))
    private int return15(int integer) {
        return Config.higherCaveFrequency ? 15 : integer;
    }
}
