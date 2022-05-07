package com.gmail.sneakdevs.netheritebeacons.mixin;

import com.gmail.sneakdevs.netheritebeacons.NetheriteBeacons;
import com.gmail.sneakdevs.netheritebeacons.config.NetheriteBeaconsConfig;
import me.shedaniel.autoconfig.AutoConfig;
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
public class MixinBeaconBlockEntity_NetheriteBeacons {
    @ModifyConstant(method = "applyPlayerEffects", constant = @Constant(intValue = 1, ordinal = 0))
    private static int netheritebeacons_newEffect(int original, World world, BlockPos pos, int beaconLevel, @Nullable StatusEffect primaryEffect, @Nullable StatusEffect secondaryEffect) {
        if (AutoConfig.getConfigHolder(NetheriteBeaconsConfig.class).getConfig().netheriteBonusEnabled) {
            float bonus = NetheriteBeaconsConfig.getBonus(primaryEffect);
            if (bonus != 0) {
                return Math.min((int)Math.max(1, NetheriteBeacons.getBlockCount(world, pos, Blocks.NETHERITE_BLOCK) * bonus), NetheriteBeaconsConfig.getMaxLevel(primaryEffect));
            }
        }
        return Math.min(1, NetheriteBeaconsConfig.getMaxLevel(primaryEffect));
    }
    @ModifyConstant(method = "applyPlayerEffects", constant = @Constant(intValue = 0, ordinal = 1))
    private static int netheritebeacons_newRegen(int original, World world, BlockPos pos, int beaconLevel, @Nullable StatusEffect primaryEffect, @Nullable StatusEffect secondaryEffect) {
        if (AutoConfig.getConfigHolder(NetheriteBeaconsConfig.class).getConfig().netheriteBonusEnabled) {
            float bonus = AutoConfig.getConfigHolder(NetheriteBeaconsConfig.class).getConfig().regenerationBonus;
            if (bonus != 0 && secondaryEffect == StatusEffects.REGENERATION) {
                return (int) Math.max(0, Math.min(NetheriteBeacons.getBlockCount(world, pos, Blocks.NETHERITE_BLOCK) * bonus, AutoConfig.getConfigHolder(NetheriteBeaconsConfig.class).getConfig().maxRegenerationBonus));
            }
        }
        return 0;
    }

    @ModifyConstant(method = "applyPlayerEffects", constant = @Constant(intValue = 10, ordinal = 1))
    private static int netheritebeacons_newPlayerRange(int original, World world, BlockPos pos, int beaconLevel, @Nullable StatusEffect primaryEffect, @Nullable StatusEffect secondaryEffect) {
        return 10 + Math.min(((AutoConfig.getConfigHolder(NetheriteBeaconsConfig.class).getConfig().diamondBlocksBeaconReachBonus == 0) ? 0 : NetheriteBeacons.getBlockCount(world, pos, Blocks.DIAMOND_BLOCK) * AutoConfig.getConfigHolder(NetheriteBeaconsConfig.class).getConfig().diamondBlocksBeaconReachBonus), AutoConfig.getConfigHolder(NetheriteBeaconsConfig.class).getConfig().maxBonusReach);
    }
}