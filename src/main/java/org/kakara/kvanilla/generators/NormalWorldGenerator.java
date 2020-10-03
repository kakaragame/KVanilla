package org.kakara.kvanilla.generators;

import org.kakara.core.Kakara;
import org.kakara.core.annotations.Key;
import org.kakara.core.annotations.Name;
import org.kakara.core.game.Item;
import org.kakara.core.mod.game.ModWorldGenerator;
import org.kakara.core.world.ChunkBase;
import org.kakara.core.world.World;
import org.kakara.core.world.region.RegionGrid;
import org.kakara.kvanilla.KVanillaMain;
import org.kakara.kvanilla.generators.noise.PerlinNoise;
import org.kakara.kvanilla.regions.KRegionGrid;

import java.util.Random;

//TODO change this back to normal
@Name("Default")
@Key("default")
public class NormalWorldGenerator extends ModWorldGenerator {
    Item grassDirt, dirt, stone, infinityStone;
    PerlinNoise noise;

    public NormalWorldGenerator(KVanillaMain mod) {
        super(mod);
        grassDirt = Kakara.getItemManager().getItem(mod.createControllerKey("grassy_dirt"));
        dirt = Kakara.getItemManager().getItem(mod.createControllerKey("dirt"));
        stone = Kakara.getItemManager().getItem(mod.createControllerKey("stone"));
        infinityStone = Kakara.getItemManager().getItem(mod.createControllerKey("infinity_stone"));
        noise = new PerlinNoise();
    }

    @Override
    public ChunkBase generateChunk(int seed, Random random, World world, int cx, int cy, int cz) {
        noise.set(0.2, 0.5, 0.3, 0.5, seed);
        RegionGrid grid = new KRegionGrid();
        ChunkBase chunkBase = new ChunkBase(world, cx, cy, cz, grid);
        for (int x = chunkBase.getX(); x < cx + 16; x++) {
            for (int z = chunkBase.getZ(); z < cz + 16; z++) {
                // TODO add in regions.
                int groundHeight = (int) (noise.getHeight(x, z) * 50) + 50;
                for (int y = chunkBase.getY(); y < 16 + cy; y++) {
                    if (y > groundHeight) {
                        continue;
                    } else if (y == 0) {
                        chunkBase.setBlock(x, y, z, Kakara.createItemStack(infinityStone));
                    } else if (y < 0) {
                        continue;
                    } else if (y == groundHeight) {
                        chunkBase.setBlock(x, y, z, Kakara.createItemStack(grassDirt));
                    } else if (y > groundHeight - 5) {
                        chunkBase.setBlock(x, y, z, Kakara.createItemStack(dirt));
                    } else {
                        chunkBase.setBlock(x, y, z, Kakara.createItemStack(stone));
                    }
                }
            }
        }
        return chunkBase;
    }
}
