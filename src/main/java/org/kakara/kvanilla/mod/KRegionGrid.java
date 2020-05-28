package org.kakara.kvanilla.mod;

import org.kakara.core.Kakara;
import org.kakara.core.world.Location;
import org.kakara.core.world.region.Region;
import org.kakara.core.world.region.RegionGrid;
import org.kakara.kvanilla.mod.generators.NoiseGenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class KRegionGrid implements RegionGrid {
    private final Map<Location, Region> overrides = new HashMap<>();
    private final NoiseGenerator n;

    public KRegionGrid(int seed) {
        n = new NoiseGenerator(new Random(seed).nextInt(64), (float) 0.01);
    }

    @Override
    public Region getRegion(int x, int z) {
        Location l = new Location(x, 0, z);
        if (overrides.containsKey(l)) return overrides.get(l);

        List<Region> regions = Kakara.getWorldGenerationManager().getRegions();
        double inc = 1D / regions.size();

        double num = n.getNoiseValue(x, 0, z);

        Region r = null;
        int index = 0;
        for (double i = 0; i <= 1; i += inc) {
            if (i > num && i < num + inc) {
                r = regions.get(index);

                continue;
            }

            index++;
        }

        return r;
    }

    @Override
    public void setRegion(int x, int z, Region region) {
        overrides.put(new Location(x, 0, z), region);
    }
}
