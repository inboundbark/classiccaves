package net.inboundbark.classiccaves.mixins;


import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.world.gen.chunk.OverworldChunkGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(OverworldChunkGenerator.class)
public class SurfaceChunkGeneratorMixin {
    @ModifyExpressionValue(
            method = "populateChunk",
            at = @At(value = "CONSTANT", args = "intValue=256", ordinal = 1))
    private int revertDungeonSpawnHeight(int integer) {
        return 128;
    }
}
