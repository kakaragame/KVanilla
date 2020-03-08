package org.kakara.kvanilla.mod.generators.normal;

import org.kakara.core.Kakara;
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
    public ChunkBase generateChunk(int seed, ChunkBase chunkBase) {
        RegionGrid grid = new KRegionGrid(seed, KVanilla.getInstance().getKakaraCore());

        NoiseGenerator n1 = new NoiseGenerator(new Random(seed).nextInt(5453453), (float) 0.05, 3);
        NoiseGenerator n2 = new NoiseGenerator(new Random(seed).nextInt(5453453), (float) 0.1, 3);

        for (int x = 0; x < 128; x++) {
            for (int z = 0; z < 128; z++) {
                int y1 = (int) (n1.GetPerlin(x, 0, z) * 5);
                int y2 = (int) (n2.GetPerlin(x, 0, z) * 5);
                int y = y1 + y2;

                int height = getChunkFormat().getWorldHeight();

                chunkBase.setBlock(x, y, z, Kakara.createItemStack(KVanilla.get("Grassy Dirt")));

                for (int i = y - 1; i > 5; i--) {
                    chunkBase.setBlock(x, i, z, Kakara.createItemStack(KVanilla.get("Dirt")));
                }

                height -= 5;

                for (int i = 0; i < height; i++) {
                    chunkBase.setBlock(x, i, z, Kakara.createItemStack(KVanilla.get("Stone")));
                }
            }
        }

        chunkBase.setRegionGrid(grid);

        return chunkBase;
    }
}
