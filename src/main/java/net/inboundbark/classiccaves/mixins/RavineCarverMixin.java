package net.inboundbark.classiccaves.mixins;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.world.gen.carver.RavineCarver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(RavineCarver.class)
public class RavineCarverMixin {
    @ModifyExpressionValue(
            method = "carveRavine",
            at = @At(value = "CONSTANT", args = "intValue=256", ordinal = 0))
    private int revertRavineCurvature(int integer) {
        return 128;
    }
    // This does not affect the frequency of ravines, just their shape. Changing this to 128 makes them spawn exactly
    // like in 1.6.4. Source: TheMasterCaver
    // https://www.minecraftforum.net/forums/minecraft-java-edition/discussion/2835864-why-do-i-still-play-in-1-6-4
}
