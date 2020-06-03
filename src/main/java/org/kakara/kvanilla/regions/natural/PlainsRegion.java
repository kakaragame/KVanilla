package org.kakara.kvanilla.regions.natural;

import org.kakara.core.Kakara;
import org.kakara.core.game.Entity;
import org.kakara.core.mod.Mod;
import org.kakara.core.mod.game.ModRegion;
import org.kakara.core.world.ChunkLocation;
import org.kakara.core.world.GameBlock;

import java.util.List;
import java.util.Random;

public class PlainsRegion extends ModRegion {
    public PlainsRegion(Mod mod) {
        super(mod);
    }

    @Override
    public Entity[] getEntitySpawns() {
        return new Entity[]{Kakara.getEntityManager().getEntity("kvanilla:cow").orElseThrow(RuntimeException::new)};
    }

    @Override
    public List<GameBlock> generate(ChunkLocation chunkLocation, int x, int y, int z, int groundHeight, int seed, Random random) {
        return null;
    }
}
