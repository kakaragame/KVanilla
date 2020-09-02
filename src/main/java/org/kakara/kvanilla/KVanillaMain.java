package org.kakara.kvanilla;

import org.kakara.core.game.ItemManager;
import org.kakara.core.game.entity.EntityManager;
import org.kakara.core.mod.annotations.LoadingStage;
import org.kakara.core.mod.game.GameMod;
import org.kakara.core.world.WorldGenerationManager;
import org.kakara.kvanilla.entitys.passive.natural.Cow;
import org.kakara.kvanilla.generators.NormalWorldGenerator;
import org.kakara.kvanilla.items.blocks.dirt.Dirt;
import org.kakara.kvanilla.items.blocks.dirt.GrassyDirt;
import org.kakara.kvanilla.items.blocks.stone.CobbleStone;
import org.kakara.kvanilla.items.blocks.stone.InfinityStone;
import org.kakara.kvanilla.items.blocks.stone.Stone;
import org.kakara.kvanilla.items.blocks.wood.oak.OakPlank;
import org.kakara.kvanilla.regions.natural.PlainsRegion;

public class KVanillaMain extends GameMod {
    @LoadingStage
    public void itemLoad(ItemManager itemManager) {
        itemManager.registerItem(new GrassyDirt(this));
        itemManager.registerItem(new Dirt(this));
        itemManager.registerItem(new OakPlank(this));
        itemManager.registerItem(new CobbleStone(this));
        itemManager.registerItem(new Stone(this));
        itemManager.registerItem(new InfinityStone(this));
    }

    @LoadingStage
    public void worldGenLoad(WorldGenerationManager worldGenerationManager) {
        worldGenerationManager.registerChunkGenerator(new NormalWorldGenerator(this));
        worldGenerationManager.registerRegion(new PlainsRegion(this));
    }

    @LoadingStage
    public void entityLoad(EntityManager entityManager) {
        entityManager.registerEntity(new Cow(this));
    }
}
