package org.kakara.kvanilla.mod.regions;

import org.kakara.core.game.Entity;
import org.kakara.core.mod.Mod;
import org.kakara.core.mod.game.ModRegion;
import org.kakara.core.world.Structure;
import org.kakara.core.world.region.BlockAbove;
import org.kakara.core.world.region.GenerationLayer;
import org.kakara.core.world.region.Region;

public class EnchantedForestRegion extends ModRegion {
    public EnchantedForestRegion(Mod mod) {
        super(mod);
    }

    @Override
    public String getName() {
        return "Enchanted Forest";
    }

    @Override
    public Structure[] getStructures() {
        return new Structure[0];
    }

    @Override
    public GenerationLayer[] getLayers() {
        return new GenerationLayer[0];
    }

    @Override
    public Entity[] getEntitySpawns() {
        return new Entity[0];
    }

    @Override
    public BlockAbove[] getAboveBlocks() {
        return new BlockAbove[0];
    }

    @Override
    public int getPrecipitationChance() {
        return 0;
    }

    @Override
    public int getHeatLevel() {
        return 0;
    }

    @Override
    public int getMinimumY() {
        return 0;
    }

    @Override
    public int getMaximumY() {
        return 0;
    }
}
