package com.gmail.sneakdevs.netheritebeacons.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;

@Config(name = "netherite_beacons")
public class NetheriteBeaconsConfig implements ConfigData {

    @Comment("Extra blocks of reach the beacon has for each diamond block in the base (0 for no bonus)")
    public int diamondBlocksBeaconReachBonus = 2;

    @Comment("Max extra blocks of reach diamond blocks can add (-1 for infinite)")
    public int maxBonusReach = -1;

    @Comment("Enables/disables the beacon effect bonuses")
    public boolean netheriteBonusEnabled = true;

    @Comment("Bonus amount of levels each netherite block gives (0.0 for no bonus)")
    public float hasteBonus = 1.0F;
    public float speedBonus = 0.5F;
    public float resistanceBonus = 0.5F;
    public float jumpBoostBonus = 0.5F;
    public float strengthBonus = 0.5F;
    public float regenerationBonus = 0.5F;

    @Comment("Max level the beacon effects can be (0-255)")
    public int maxHasteBonus = 255;
    public int maxSpeedBonus = 7;
    public int maxResistanceBonus = 4;
    public int maxJumpBoostBonus = 7;
    public int maxStrengthBonus = 4;
    public int maxRegenerationBonus = 3;

    public static NetheriteBeaconsConfig getInstance() {
        return AutoConfig.getConfigHolder(NetheriteBeaconsConfig.class).getConfig();
    }

    public static float getBonus(StatusEffect se) {
        if (StatusEffects.HASTE.equals(se)) {
            return NetheriteBeaconsConfig.getInstance().hasteBonus;
        } else if (StatusEffects.SPEED.equals(se)) {
            return NetheriteBeaconsConfig.getInstance().speedBonus;
        } else if (StatusEffects.RESISTANCE.equals(se)) {
            return NetheriteBeaconsConfig.getInstance().resistanceBonus;
        } else if (StatusEffects.JUMP_BOOST.equals(se)) {
            return NetheriteBeaconsConfig.getInstance().jumpBoostBonus;
        } else if (StatusEffects.STRENGTH.equals(se)) {
            return NetheriteBeaconsConfig.getInstance().strengthBonus;
        }
        return 0.5F;
    }

    public static int getMaxLevel(StatusEffect se) {
        if (StatusEffects.HASTE.equals(se)) {
            return NetheriteBeaconsConfig.getInstance().maxHasteBonus;
        } else if (StatusEffects.SPEED.equals(se)) {
            return NetheriteBeaconsConfig.getInstance().maxSpeedBonus;
        } else if (StatusEffects.RESISTANCE.equals(se)) {
            return NetheriteBeaconsConfig.getInstance().maxResistanceBonus;
        } else if (StatusEffects.JUMP_BOOST.equals(se)) {
            return NetheriteBeaconsConfig.getInstance().maxJumpBoostBonus;
        } else if (StatusEffects.STRENGTH.equals(se)) {
            return NetheriteBeaconsConfig.getInstance().maxStrengthBonus;
        }
        return 255;
    }
}