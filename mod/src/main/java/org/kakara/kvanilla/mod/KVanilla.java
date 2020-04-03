package org.kakara.kvanilla.mod;

import org.kakara.core.game.ItemManager;
import org.kakara.core.mod.annotations.LoadingStage;
import org.kakara.core.mod.game.GameMod;
import org.kakara.core.world.WorldGenerationManager;
import org.kakara.kvanilla.mod.generators.normal.NormalChunkGenerator;
import org.kakara.kvanilla.mod.items.dirt.CoarseDirt;
import org.kakara.kvanilla.mod.items.dirt.Dirt;
import org.kakara.kvanilla.mod.items.dirt.FineDirt;
import org.kakara.kvanilla.mod.items.dirt.GrassyDirt;
import org.kakara.kvanilla.mod.items.stone.Stone;
import org.kakara.kvanilla.mod.regions.EnchantedForestRegion;

public class KVanilla extends GameMod {

    @LoadingStage
    public void loadItems(ItemManager itemManager) {
        itemManager.registerItem(new CoarseDirt(this), this);
        itemManager.registerItem(new Dirt(this), this);
        itemManager.registerItem(new FineDirt(this), this);
        itemManager.registerItem(new GrassyDirt(this), this);
        itemManager.registerItem(new Stone(this), this);
    }

    @LoadingStage
    public void loadWorldGen(WorldGenerationManager worldGenerationManager) {
        System.out.println("Loading");
        worldGenerationManager.registerRegion(new EnchantedForestRegion(this));
        worldGenerationManager.registerChunkGenerator(new NormalChunkGenerator(this));
    }
}