package com.gmail.sneakdevs.netheritebeaconsforge;

import com.gmail.sneakdevs.netheritebeacons.NetheriteBeacons;
import com.gmail.sneakdevs.netheritebeacons.config.NetheriteBeaconsConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.minecraftforge.fml.common.Mod;

@Mod(NetheriteBeacons.Mod_ID)
public class NetheriteBeaconsForge {
    public NetheriteBeaconsForge() {
        AutoConfig.register(NetheriteBeaconsConfig.class, Toml4jConfigSerializer::new);
    }
}