package com.gmail.sneakdevs.netheritebeacons.mixin;

import com.gmail.sneakdevs.netheritebeacons.NetheriteBeacons;
import com.gmail.sneakdevs.netheritebeacons.config.NetheriteBeaconsConfig;
import me.shedaniel.autoconfig.AutoConfig;
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
public class MixinBeaconBlockEntity_NetheriteBeacons {
    @ModifyConstant(method = "applyPlayerEffects", constant = @Constant(intValue = 1))
    private static int netheritebeacon_newEffect(int original, World world, BlockPos pos, int beaconLevel, @Nullable StatusEffect primaryEffect, @Nullable StatusEffect secondaryEffect) {
        float bonus = NetheriteBeaconsConfig.getBonus(primaryEffect);
        if (bonus > 0) {
            return (int) Math.max(1, NetheriteBeacons.getNetheriteCount(world, pos) * bonus);
        }
        return 1;
    }
    @ModifyConstant(method = "applyPlayerEffects", constant = @Constant(intValue = 0, ordinal = 1))
    private static int netheritebeacon_newRegen(int original, World world, BlockPos pos, int beaconLevel, @Nullable StatusEffect primaryEffect, @Nullable StatusEffect secondaryEffect) {
        float bonus = AutoConfig.getConfigHolder(NetheriteBeaconsConfig.class).getConfig().regenerationBonus;
        if (bonus > 0 && secondaryEffect == StatusEffects.REGENERATION) {
            return (int) Math.max(0, NetheriteBeacons.getNetheriteCount(world, pos) * bonus);
        }
        return 0;
    }

}