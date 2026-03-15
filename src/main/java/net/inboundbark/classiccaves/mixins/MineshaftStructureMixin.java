package net.inboundbark.classiccaves.mixins;

import net.minecraft.world.gen.structure.MineshaftStructure;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MineshaftStructure.class)
public class MineshaftStructureMixin {
    @Shadow
    private double spawnChance;

    @Inject(
            method = "<init>*",
            at = @At(
                    value = "FIELD",
                    target = "Lnet/minecraft/world/gen/structure/MineshaftStructure;spawnChance:D",
                    opcode = Opcodes.PUTFIELD,
                    shift = At.Shift.AFTER,
                    ordinal = 0 // Only the first assign
            )
    )
    private void revertChance(CallbackInfo ci) {
        this.spawnChance = 0.01D;
    }

}
