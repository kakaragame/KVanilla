package org.kakara.kvanilla.mod;

import org.kakara.core.Kakara;
import org.kakara.core.game.Item;
import org.kakara.core.game.ItemManager;
import org.kakara.core.mod.ModType;
import org.kakara.core.mod.annotations.*;
import org.kakara.core.mod.game.GameMod;
import org.kakara.core.world.WorldGenerationManager;
import org.kakara.kvanilla.mod.generators.normal.NormalChunkGenerator;
import org.kakara.kvanilla.mod.items.dirt.CoarseDirt;
import org.kakara.kvanilla.mod.items.dirt.Dirt;
import org.kakara.kvanilla.mod.items.dirt.FineDirt;
import org.kakara.kvanilla.mod.items.dirt.GrassyDirt;
import org.kakara.kvanilla.mod.items.stone.Stone;
import org.kakara.kvanilla.mod.regions.EnchantedForestRegion;

@ModInfo(name = "KVanilla", description = "The Vanilla Game for Kakara", authors = "The Kakara Development Team", modType = ModType.REGULAR, version = "1.0-SNAPSHOT")
public class KVanilla extends GameMod {
    private static KVanilla instance;

    public static Item get(String name) {
        return Kakara.getItemManager().getItem(name);
    }

    @LoadingStage
    public void loadItems(ItemManager itemManager) {
        itemManager.registerItem(new CoarseDirt(this), this);
        itemManager.registerItem(new Dirt(this), this);
        itemManager.registerItem(new FineDirt(this), this);
        itemManager.registerItem(new GrassyDirt(this), this);
        itemManager.registerItem(new Stone(this), this);
    }

    public static KVanilla getInstance() {
        return instance;
    }

    @LoadingStage
    public void loadWorldGen(WorldGenerationManager worldGenerationManager) {
        worldGenerationManager.registerRegion(new EnchantedForestRegion());
        worldGenerationManager.registerChunkGenerator(new NormalChunkGenerator());
    }
}