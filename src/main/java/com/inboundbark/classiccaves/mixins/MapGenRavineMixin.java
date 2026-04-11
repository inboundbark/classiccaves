package com.inboundbark.classiccaves.mixins;

import net.minecraft.world.gen.MapGenRavine;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.inboundbark.classiccaves.Config;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;

@Mixin(MapGenRavine.class)
public class MapGenRavineMixin {

    @ModifyExpressionValue(method = "func_151540_a", at = @At(value = "CONSTANT", args = "intValue=256", ordinal = 0))
    private int revertRavineCurvature(int integer) {
        return Config.oldRavineShape ? 128 : integer;
    }
    // This does not affect the frequency of ravines, just their shape. Changing this to 128 makes them spawn exactly
    // like in 1.6.4. Source: TheMasterCaver
    // https://www.minecraftforum.net/forums/minecraft-java-edition/discussion/2835864-why-do-i-still-play-in-1-6-4
}
