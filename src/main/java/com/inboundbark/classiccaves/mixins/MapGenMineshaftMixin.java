package com.inboundbark.classiccaves.mixins;

import net.minecraft.world.gen.structure.MapGenMineshaft;

import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.inboundbark.classiccaves.Config;

@Mixin(MapGenMineshaft.class)
public class MapGenMineshaftMixin {

    @Shadow
    private double field_82673_e;

    @Inject(
        method = "<init>*",
        at = @At(
            value = "FIELD",
            target = "Lnet/minecraft/world/gen/structure/MapGenMineshaft;field_82673_e:D",
            opcode = Opcodes.PUTFIELD,
            shift = At.Shift.AFTER,
            ordinal = 0 // Only the first assign
        ))
    private void revertChance(CallbackInfo ci) {
        this.field_82673_e = Config.higherMineshaftChance ? 0.01D : this.field_82673_e;
    }

}
