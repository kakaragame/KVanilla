package org.kakara.kvanilla.api.generation;

import org.kakara.core.mod.Mod;
import org.kakara.core.mod.game.ModRegion;
import org.kakara.core.world.ChunkLocation;
import org.kakara.core.world.GameBlock;
import org.kakara.kvanilla.api.KNoiseGenerator;

import java.util.List;
import java.util.Random;

public abstract class KRegion extends ModRegion {
					public KNoiseGenerator noiseGenerator;

					public KRegion(Mod mod, KNoiseGenerator noiseGenerator) {
										super(mod);
										this.noiseGenerator = noiseGenerator;
					}

					@Override
					public List<GameBlock> generate(ChunkLocation chunkLocation, int x, int y, int z, int groundHeight, int seed, Random random) {
										return null;
					}
}
