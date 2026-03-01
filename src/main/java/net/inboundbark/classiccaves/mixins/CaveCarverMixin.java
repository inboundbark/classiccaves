package net.inboundbark.classiccaves.mixins;

import net.minecraft.world.gen.carver.CaveCarver;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;


@Mixin(CaveCarver.class)
public class CaveCarverMixin {
    @ModifyConstant(
            method = "carve",
            constant = @Constant(intValue = 15, ordinal = 0))
    private int return40(int integer) {
        return 40;
    }

    @ModifyConstant(
            method = "carve",
            constant = @Constant(intValue = 7, ordinal = 0))
    private int return15(int integer) {
        return 15;
    }
}