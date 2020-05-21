package org.kakara.kvanilla.mod.generators.normal;

import org.kakara.core.annotations.Id;
import org.kakara.core.annotations.Name;
import org.kakara.core.mod.Mod;
import org.kakara.core.mod.game.ModWorldGenerator;
import org.kakara.core.world.ChunkBase;
import org.kakara.core.world.GameBlock;
import org.kakara.core.world.Location;
import org.kakara.core.world.World;
import org.kakara.core.world.region.Region;
import org.kakara.core.world.region.RegionGrid;
import org.kakara.kvanilla.mod.KRegionGrid;
import org.kakara.kvanilla.mod.generators.NoiseGenerator;

import java.util.Random;

@Name("Normal")
@Id("normal")
public class NormalWorldGenerator extends ModWorldGenerator {
    public NormalWorldGenerator(Mod mod) {
        super(mod);
    }

    @Override
    public ChunkBase generateChunk(int seed, Random random, World world, int x1, int y1, int z1) {
        NoiseGenerator n1 = new NoiseGenerator(seed, 0.05F);
        RegionGrid grid = new KRegionGrid(seed);
        ChunkBase chunkBase = new ChunkBase(world, x1, y1, z1, grid);

        for (int x = chunkBase.getX(); x < 16 + x1; x++) {
            for (int z = chunkBase.getZ(); z < 16 + z1; z++) {
                Region region = grid.getRegion(x, z);
                int groundHeight = (int) (n1.getNoiseValue(x, 0, z) * 40 + 50);

                for (int y = chunkBase.getY(); y < 16 + y1; y++) {
                    for (GameBlock gameBlock : region.generate(chunkBase.toChunkLocation(), x, y, z, groundHeight, seed, random)) {
                        Location l = gameBlock.getLocation();
                        chunkBase.setBlock((int) l.getX(), (int) l.getY(), (int) l.getZ(), gameBlock.getItemStack());
                    }
                }
            }
        }

        return chunkBase;
    }
}
