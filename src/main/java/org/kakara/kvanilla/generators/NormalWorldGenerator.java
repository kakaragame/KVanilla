package org.kakara.kvanilla.generators;

import org.kakara.core.annotations.Id;
import org.kakara.core.annotations.Name;
import org.kakara.core.mod.Mod;
import org.kakara.core.mod.game.ModWorldGenerator;
import org.kakara.core.world.ChunkBase;
import org.kakara.core.world.World;

import java.util.Random;

@Name("Normal")
@Id("normal")
public class NormalWorldGenerator extends ModWorldGenerator {
    public NormalWorldGenerator(Mod mod) {
        super(mod);
    }

    @Override
    public ChunkBase generateChunk(int seed, Random random, World world, int x, int y, int z) {
        return null;
    }
}
