package org.kakara.kvanilla.generators;


import org.kakara.core.common.KValidate;
import org.kakara.core.common.Kakara;
import org.kakara.core.common.annotations.Key;
import org.kakara.core.common.annotations.Name;
import org.kakara.core.common.game.Item;
import org.kakara.core.common.mod.game.ModWorldGenerator;
import org.kakara.core.common.world.ChunkBase;
import org.kakara.core.common.world.World;
import org.kakara.core.common.world.region.RegionGrid;
import org.kakara.core.server.ServerGameInstance;
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
    private ServerGameInstance serverGameInstance;

    public NormalWorldGenerator(KVanillaMain mod) {
        super(mod);

        KValidate.gameInstanceCheckServer();
        serverGameInstance = (ServerGameInstance) Kakara.getGameInstance();
        grassDirt = Kakara.getGameInstance().getItemRegistry().getItem(mod.createControllerKey("grassy_dirt"));
        dirt = Kakara.getGameInstance().getItemRegistry().getItem(mod.createControllerKey("dirt"));
        stone = Kakara.getGameInstance().getItemRegistry().getItem(mod.createControllerKey("stone"));
        infinityStone = Kakara.getGameInstance().getItemRegistry().getItem(mod.createControllerKey("infinity_stone"));
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

                        chunkBase.setBlock(x, y, z, serverGameInstance.createItemStack(infinityStone));
                    } else if (y < 0) {
                        continue;
                    } else if (y == groundHeight) {
                        chunkBase.setBlock(x, y, z, serverGameInstance.createItemStack(grassDirt));
                    } else if (y > groundHeight - 5) {
                        chunkBase.setBlock(x, y, z, serverGameInstance.createItemStack(dirt));
                    } else {
                        chunkBase.setBlock(x, y, z, serverGameInstance.createItemStack(stone));
                    }
                }
            }
        }
        return chunkBase;
    }
}
