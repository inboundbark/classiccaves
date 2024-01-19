package com.inboundbark.classiccaves.mixins;

import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCaves;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import com.inboundbark.classiccaves.Config;

@Mixin(value = MapGenCaves.class)
public abstract class MapGenCavesMixin extends MapGenBase {

    @ModifyConstant(
        method = "Lnet/minecraft/world/gen/MapGenCaves;func_151538_a(Lnet/minecraft/world/World;IIII[Lnet/minecraft/block/Block;)V",
        constant = @Constant(intValue = 15, ordinal = 0))
    private int return40(int integer) {
        return Config.enabled ? 40 : 15;
    }

    @ModifyConstant(
        method = "Lnet/minecraft/world/gen/MapGenCaves;func_151538_a(Lnet/minecraft/world/World;IIII[Lnet/minecraft/block/Block;)V",
        constant = @Constant(intValue = 7, ordinal = 0))
    private int return15(int integer) {
        return Config.enabled ? 15 : 7;
    }
}
