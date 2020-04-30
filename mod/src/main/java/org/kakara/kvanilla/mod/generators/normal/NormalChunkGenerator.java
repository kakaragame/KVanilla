package org.kakara.kvanilla.mod.generators.normal;

import org.kakara.core.Kakara;
import org.kakara.core.NameKey;
import org.kakara.core.annotations.Id;
import org.kakara.core.annotations.Name;
import org.kakara.core.game.Item;
import org.kakara.core.mod.Mod;
import org.kakara.core.mod.game.ModChunkGenerator;
import org.kakara.core.world.ChunkBase;
import org.kakara.kvanilla.mod.KRegionGrid;
import org.kakara.kvanilla.mod.generators.NoiseGenerator;

import java.util.Random;

@Name("Default")
@Id("default")
public class NormalChunkGenerator extends ModChunkGenerator {
    private Mod mod;
    public NormalChunkGenerator(Mod mod) {
        super(mod);
        this.mod = mod;
    }

    @Override
    public ChunkBase generateChunk(int seed, Random r, ChunkBase chunkBase) {
        NoiseGenerator n1 = new NoiseGenerator(seed, 0.05F);
        NoiseGenerator n2 = new NoiseGenerator(r.nextInt(), 0.1F);
        for (int x = chunkBase.getX(); x < 16 + chunkBase.getX(); x++) {
            for (int y = chunkBase.getY(); y < 16 + chunkBase.getY(); y++) {
                for (int z = chunkBase.getZ(); z < 16 + chunkBase.getZ(); z++) {
                    int y1 = (int) (n1.getNoiseValue(x, 50, z) * 5);
                    int y2 = (int) (n2.getNoiseValue(x, 50, z) * 5);
                    int groundHeight = y1 + y2;

                    Item item;
                    if (y == groundHeight) {
                        item = Kakara.getItemManager().getItem(new NameKey(mod.getName(), "grassy_dirt"));
                        if (item == null) System.out.println("null Grassy");
                    } else if (y > groundHeight) {
                        continue;
                    } else if (y > groundHeight - 5) {
                        item = Kakara.getItemManager().getItem(new NameKey(mod.getName(), "dirt"));
                        if (item == null) System.out.println("null dirt");

                    } else {
                        item = Kakara.getItemManager().getItem(new NameKey(mod.getName(), "stone"));
                        if (item == null) System.out.println("null stone");

                    }

                    chunkBase.setBlock(x, y, z, Kakara.createItemStack(item));
                }
            }
        }

        chunkBase.setRegionGrid(new KRegionGrid(seed));

        return chunkBase;
    }
}
