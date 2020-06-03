package org.kakara.kvanilla;

import org.kakara.core.annotations.GameType;
import org.kakara.core.game.ItemManager;
import org.kakara.core.mod.annotations.LoadingStage;
import org.kakara.core.mod.game.GameMod;
import org.kakara.core.world.WorldGenerationManager;
import org.kakara.kvanilla.generators.NormalWorldGenerator;
import org.kakara.kvanilla.items.blocks.GrassyDirt;

public class KVanillaMain extends GameMod {
    @LoadingStage
    public void itemLoad(ItemManager itemManager) {
        itemManager.registerItem(new GrassyDirt(this));
    }

    @LoadingStage
    public void worldGenLoad(WorldGenerationManager worldGenerationManager) {
        worldGenerationManager.registerChunkGenerator(new NormalWorldGenerator(this));
    }
}
