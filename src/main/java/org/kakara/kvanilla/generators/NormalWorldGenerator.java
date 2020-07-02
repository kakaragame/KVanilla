package org.kakara.kvanilla.generators;

import org.kakara.core.Kakara;
import org.kakara.core.NameKey;
import org.kakara.core.annotations.Key;
import org.kakara.core.annotations.Name;
import org.kakara.core.game.ItemStack;
import org.kakara.core.mod.Mod;
import org.kakara.core.mod.game.ModWorldGenerator;
import org.kakara.core.world.ChunkBase;
import org.kakara.core.world.World;
import org.kakara.core.world.region.RegionGrid;
import org.kakara.kvanilla.generators.noise.PerlinNoise;
import org.kakara.kvanilla.regions.KRegionGrid;

import java.util.Random;
//TODO change this back to normal
@Name("Default")
@Key("default")
public class NormalWorldGenerator extends ModWorldGenerator {
    ItemStack grassDirt, dirt, stone, infinityStone;
    PerlinNoise noise;

    public NormalWorldGenerator(Mod mod) {
        super(mod);
        grassDirt = Kakara.createItemStack(Kakara.getItemManager().getItem(new NameKey(mod, "grassy_dirt")).get());
        dirt = Kakara.createItemStack(Kakara.getItemManager().getItem(new NameKey(mod, "dirt")).get());
        stone = Kakara.createItemStack(Kakara.getItemManager().getItem(new NameKey(mod, "stone")).get());
        infinityStone = Kakara.createItemStack(Kakara.getItemManager().getItem(new NameKey(mod, "infinity_stone")).get());
        noise = new PerlinNoise();
    }

    @Override
    public ChunkBase generateChunk(int seed, Random random, World world, int cx, int cy, int cz) {
        noise.set(0.2, 0.5, 0.3, 0.5, seed);
        RegionGrid grid = new KRegionGrid();
        ChunkBase chunkBase = new ChunkBase(world, cx, cy, cz, grid);
        for(int x = chunkBase.getX(); x < cx + 16; x++){
            for(int z = chunkBase.getZ(); z < cz + 16; z++){
                // TODO add in regions.
                int groundHeight = (int) (noise.getHeight(x, z) * 50) + 50;
                for(int y = chunkBase.getY(); y < 16 + cy; y++){
                    if(y > groundHeight){
                        continue;
                    }else if(y == 0){
                        chunkBase.setBlock(x, y, z, infinityStone);
                    }else if(y < 0){
                        continue;
                    }else if( y == groundHeight){
                        chunkBase.setBlock(x, y, z, grassDirt);
                    }else if(y > groundHeight - 5){
                        chunkBase.setBlock(x, y, z, dirt);
                    }else{
                        chunkBase.setBlock(x, y, z, stone);
                    }
                }
            }
        }
        return chunkBase;
    }
}
