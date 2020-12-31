package org.kakara.kvanilla;


import org.kakara.core.common.game.ItemRegistry;
import org.kakara.core.common.mod.annotations.LoadingStage;
import org.kakara.core.common.mod.game.GameMod;
import org.kakara.core.common.world.WorldGenerationRegistry;
import org.kakara.kvanilla.generators.NormalWorldGenerator;
import org.kakara.kvanilla.items.blocks.dirt.Dirt;
import org.kakara.kvanilla.items.blocks.dirt.GrassyDirt;
import org.kakara.kvanilla.items.blocks.stone.CobbleStone;
import org.kakara.kvanilla.items.blocks.stone.InfinityStone;
import org.kakara.kvanilla.items.blocks.stone.Stone;
import org.kakara.kvanilla.items.blocks.wood.oak.OakPlank;

public class KVanillaMain extends GameMod {
    @LoadingStage
    public void itemLoad(ItemRegistry itemManager) {
        itemManager.registerItem(new GrassyDirt(this));
        itemManager.registerItem(new Dirt(this));
        itemManager.registerItem(new OakPlank(this));
        itemManager.registerItem(new CobbleStone(this));
        itemManager.registerItem(new Stone(this));
        itemManager.registerItem(new InfinityStone(this));
    }

    @LoadingStage
    public void worldGenLoad(WorldGenerationRegistry worldGenerationManager) {
        worldGenerationManager.registerChunkGenerator(new NormalWorldGenerator(this));
        //worldGenerationManager.registerRegion(new PlainsRegion(this));
    }

}
