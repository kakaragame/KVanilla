package org.kakara.kvanilla.mod.regions;

import org.kakara.core.annotations.Id;
import org.kakara.core.annotations.Name;
import org.kakara.core.game.Entity;
import org.kakara.core.mod.Mod;
import org.kakara.core.mod.game.ModRegion;
import org.kakara.core.world.ChunkLocation;
import org.kakara.core.world.GameBlock;

import java.util.List;
import java.util.Random;

@Name("Enchanted Forest")
@Id("enchanted_forest")
public class EnchantedForestRegion extends ModRegion {
    public EnchantedForestRegion(Mod mod) {
        super(mod);
    }

    @Override
    public Entity[] getEntitySpawns() {
        return new Entity[0];
    }

    @Override
    public List<GameBlock> generate(ChunkLocation chunkLocation, int x, int y, int z, int groundHeight, int seed, Random random) {

    }
}
