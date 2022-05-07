package com.gmail.sneakdevs.netheritebeacons.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;

@Config(name = "netherite_beacons")
public class NetheriteBeaconsConfig implements ConfigData {
    public float hasteBonus = 1.0F;
    public float speedBonus = 0.5F;
    public float resistanceBonus = 0.5F;
    public float jumpBoostBonus = 0.5F;
    public float strengthBonus = 0.5F;
    public float regenerationBonus = 0.5F;

    @SuppressWarnings("unused")
    public static NetheriteBeaconsConfig getInstance() {
        return AutoConfig.getConfigHolder(NetheriteBeaconsConfig.class).getConfig();
    }

    public static float getBonus(StatusEffect se) {
        if (StatusEffects.HASTE.equals(se)) {
            return AutoConfig.getConfigHolder(NetheriteBeaconsConfig.class).getConfig().hasteBonus;
        } else if (StatusEffects.SPEED.equals(se)) {
            return AutoConfig.getConfigHolder(NetheriteBeaconsConfig.class).getConfig().speedBonus;
        } else if (StatusEffects.RESISTANCE.equals(se)) {
            return AutoConfig.getConfigHolder(NetheriteBeaconsConfig.class).getConfig().resistanceBonus;
        } else if (StatusEffects.JUMP_BOOST.equals(se)) {
            return AutoConfig.getConfigHolder(NetheriteBeaconsConfig.class).getConfig().jumpBoostBonus;
        } else if (StatusEffects.STRENGTH.equals(se)) {
            return AutoConfig.getConfigHolder(NetheriteBeaconsConfig.class).getConfig().strengthBonus;
        }
        return 0.5F;
    }
}