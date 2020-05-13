package org.kakara.kvanilla.mod.generators.normal;

import org.kakara.core.Kakara;
import org.kakara.core.NameKey;
import org.kakara.core.annotations.Id;
import org.kakara.core.annotations.Name;
import org.kakara.core.game.ItemStack;
import org.kakara.core.mod.Mod;
import org.kakara.core.mod.game.ModChunkGenerator;
import org.kakara.core.world.ChunkBase;
import org.kakara.kvanilla.mod.KRegionGrid;
import org.kakara.kvanilla.mod.generators.NoiseGenerator;

import java.util.Random;

@Name("Default")
@Id("default")
public class NormalChunkGenerator extends ModChunkGenerator {
    private final Mod mod;

    public NormalChunkGenerator(Mod mod) {
        super(mod);
        this.mod = mod;
    }

    @Override
    public ChunkBase generateChunk(int seed, Random r, ChunkBase chunkBase) {
        NoiseGenerator n1 = new NoiseGenerator(seed, 0.05F);
        ItemStack grassDirt = Kakara.createItemStack(Kakara.getItemManager().getItem(new NameKey(mod.getName(), "grassy_dirt")).get());
        ItemStack dirt = Kakara.createItemStack(Kakara.getItemManager().getItem(new NameKey(mod.getName(), "dirt")).get());
        ItemStack stone = Kakara.createItemStack(Kakara.getItemManager().getItem(new NameKey(mod.getName(), "stone")).get());

        for (int x = chunkBase.getX(); x < 16 + chunkBase.getX(); x++) {
            for (int z = chunkBase.getZ(); z < 16 + chunkBase.getZ(); z++) {
                int groundHeight = (int) (n1.getNoiseValue(x, 0, z) * 40 + 50);

                for (int y = chunkBase.getY(); y < 16 + chunkBase.getY(); y++) {
                    ItemStack item;

                    if (y == groundHeight) {
                        item = grassDirt;
                    } else if (y < groundHeight - 5) {
                        item = stone;
                    } else if (y < groundHeight) {
                        item = dirt;
                    } else continue;

                    chunkBase.setBlock(x, y, z, item);
                }
            }
        }

        chunkBase.setRegionGrid(new KRegionGrid(seed));

        return chunkBase;
    }
}
