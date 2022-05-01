package com.gmail.sneakdevs.netheritebeacons;

import com.gmail.sneakdevs.netheritebeacons.config.NBConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class NetheriteBeacons implements  ModInitializer {
    public static final String Mod_ID = "netheritebeacons";

    @Override
    public void onInitialize() {
        AutoConfig.register(NBConfig.class, Toml4jConfigSerializer::new);
    }

    public static int getNetheriteCount(World world, BlockPos pos) {
        int netheriteCount = 1;

        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

        for (int j = 1; j <= 4; j++) {
            int k = y - j;
            if (k < world.getBottomY()) {
                break;
            }

            for (int l = x - j; l <= x + j; ++l) {
                for (int m = z - j; m <= z + j; ++m) {
                    if (world.getBlockState(new BlockPos(l, k, m)).equals(Blocks.NETHERITE_BLOCK.getDefaultState())) {
                        netheriteCount++;
                    }
                }
            }
        }
        return netheriteCount;
    }
}
