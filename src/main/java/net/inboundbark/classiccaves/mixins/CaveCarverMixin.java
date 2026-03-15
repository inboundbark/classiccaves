package net.inboundbark.classiccaves.mixins;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.world.gen.carver.CaveWorldCarver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;


@Mixin(CaveWorldCarver.class)
public class CaveCarverMixin {
    @ModifyExpressionValue(
            method = "place(Lnet/minecraft/world/World;IIIILnet/minecraft/world/chunk/BlockStateStorage;)V",
            at = @At(value = "CONSTANT", args = "intValue=15", ordinal = 0))
    private int return40(int integer) {
        return 40;
    }

    @ModifyExpressionValue(
            method = "place(Lnet/minecraft/world/World;IIIILnet/minecraft/world/chunk/BlockStateStorage;)V",
            at = @At(value = "CONSTANT", args = "intValue=7", ordinal = 0))
    private int return15(int integer) {
        return 15;
    }
}