package com.gmail.sneakdevs.netheritebeacons;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class NetheriteBeacons {
    public static final String Mod_ID = "netheritebeacons";

    public static int getBlockCount(World world, BlockPos pos, Block block) {
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
                    if (world.getBlockState(new BlockPos(l, k, m)).equals(block.getDefaultState())) {
                        netheriteCount++;
                    }
                }
            }
        }
        return netheriteCount;
    }
}
