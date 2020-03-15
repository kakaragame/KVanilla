package org.kakara.kvanilla.mod.generators.normal;

import org.kakara.core.Kakara;
import org.kakara.core.mod.Mod;
import org.kakara.core.world.ChunkBase;
import org.kakara.core.world.ChunkGenerator;
import org.kakara.core.world.region.RegionGrid;
import org.kakara.kvanilla.api.KConstants;
import org.kakara.kvanilla.mod.KRegionGrid;
import org.kakara.kvanilla.mod.KVanilla;
import org.kakara.kvanilla.mod.generators.NoiseGenerator;

import java.util.Random;

public class NormalChunkGenerator implements ChunkGenerator {
    @Override
    public String getName() {
        return "Default";
    }

    @Override
    public ChunkFormat getChunkFormat() {
        return KConstants.CHUNK_FORMAT;
    }

    @Override
    public Mod getMod() {
        return KVanilla.getInstance();
    }

    @Override
    public ChunkBase generateChunk(int seed, ChunkBase chunkBase) {
        RegionGrid grid = new KRegionGrid(seed, KVanilla.getInstance().getGameInstance());

        NoiseGenerator n1 = new NoiseGenerator(new Random(seed).nextInt(5453453), (float) 0.05, 3);
        NoiseGenerator n2 = new NoiseGenerator(new Random(seed).nextInt(5453453), (float) 0.1, 3);

        for (int x = chunkBase.getX(); x < 4 + chunkBase.getX(); x++) {
            for (int z = chunkBase.getZ(); z < 4 + chunkBase.getX(); z++) {
                int y1 = (int) (n1.GetPerlin(x, 0, z) * 5);
                int y2 = (int) (n2.GetPerlin(x, 0, z) * 5);
                int y = y1 + y2;

                int height = getChunkFormat().getWorldHeight() / 2;

                y += height;

                for (int i = 0; i < y - 6; i++) {
                    chunkBase.setBlock(x, i, z, Kakara.createItemStack(KVanilla.get("KVanilla:stone")));
                }

                for (int i = y - 6; i < y; i++) {
                    chunkBase.setBlock(x, i, z, Kakara.createItemStack(KVanilla.get("KVanilla:dirt")));
                }

                chunkBase.setBlock(x, y, z, Kakara.createItemStack(KVanilla.get("KVanilla:grassy_dirt")));
            }
        }

        chunkBase.setRegionGrid(grid);

        return chunkBase;
    }
}
