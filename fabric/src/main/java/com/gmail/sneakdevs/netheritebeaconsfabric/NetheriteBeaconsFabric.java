package com.gmail.sneakdevs.netheritebeaconsfabric;

import com.gmail.sneakdevs.netheritebeacons.config.NetheriteBeaconsConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ModInitializer;

public class NetheriteBeaconsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        AutoConfig.register(NetheriteBeaconsConfig.class, Toml4jConfigSerializer::new);
    }

}
