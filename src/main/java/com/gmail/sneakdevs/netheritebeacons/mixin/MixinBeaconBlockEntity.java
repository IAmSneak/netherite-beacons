package com.gmail.sneakdevs.netheritebeacons.mixin;

import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BeaconBlockEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(BeaconBlockEntity.class)
public class MixinBeaconBlockEntity {
    @ModifyConstant(method = "applyPlayerEffects", constant = @Constant(intValue = 1))
    private static int newAmount(int original, World world, BlockPos pos, int beaconLevel, @Nullable StatusEffect primaryEffect, @Nullable StatusEffect secondaryEffect){
        int netheriteCount = 1;

        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

        for(int j = 1; j <= 4; j++) {
            int k = y - j;
            if (k < world.getBottomY()) {
                break;
            }

            for(int l = x - j; l <= x + j; ++l) {
                for(int m = z - j; m <= z + j; ++m) {
                    if (world.getBlockState(new BlockPos(l, k, m)).equals(Blocks.NETHERITE_BLOCK.getDefaultState())) {
                        netheriteCount++;
                    }
                }
            }
        }

        return (primaryEffect.equals(StatusEffects.HASTE)) ? netheriteCount : ++netheriteCount / 2;
    }
}