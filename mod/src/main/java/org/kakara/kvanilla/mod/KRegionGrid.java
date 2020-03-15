package org.kakara.kvanilla.mod;

import org.kakara.core.GameInstance;
import org.kakara.core.world.Location;
import org.kakara.core.world.region.Region;
import org.kakara.core.world.region.RegionGrid;
import org.kakara.kvanilla.mod.generators.NoiseGenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KRegionGrid implements RegionGrid {
    private Map<Location, Region> overrides = new HashMap<>();
    private final NoiseGenerator n;
    private final GameInstance kc;

    public KRegionGrid(int seed, GameInstance kc) {
        n = new NoiseGenerator(seed, (float) 0.01, 3);
        this.kc = kc;
    }

    @Override
    public Region getRegion(int x, int z) {
        Location l = new Location(x, 0, z);
        if (overrides.containsKey(l)) return overrides.get(l);

        List<Region> regions = kc.getWorldGenerationManager().getRegions();
        double inc = 1D / regions.size();

        double num = n.GetPerlin(x, z);

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
