package com.inboundbark.classiccaves.mixins;

import net.minecraft.world.gen.ChunkProviderGenerate;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.inboundbark.classiccaves.Config;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;

@Mixin(ChunkProviderGenerate.class)
public class ChunkProviderGenerateMixin {

    @ModifyExpressionValue(method = "populate", at = @At(value = "CONSTANT", args = "intValue=256", ordinal = 1))
    private int revertDungeonSpawnHeight(int integer) {
        return Config.lowerDungeonSpawnLimit ? 128 : integer;
    }
}
