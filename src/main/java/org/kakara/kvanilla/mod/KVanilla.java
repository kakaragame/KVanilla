package org.kakara.kvanilla.mod;

import org.kakara.core.game.ItemManager;
import org.kakara.core.mod.annotations.LoadingStage;
import org.kakara.core.mod.game.GameMod;
import org.kakara.core.world.WorldGenerationManager;
import org.kakara.kvanilla.api.KItem;
import org.kakara.kvanilla.api.KRegistry;
import org.kakara.kvanilla.api.generation.KRegion;
import org.kakara.kvanilla.mod.generators.normal.NormalWorldGenerator;

public class KVanilla extends GameMod {
    private static KVanilla instance = null;

    public KVanilla() {
        if (instance == null) {
            instance = this;
        }
    }

    private KRegistry registry = new KGenericRegistry();

    @LoadingStage
    public void load(ItemManager manager) {
        for (KItem item : registry.getAllItems()) {
            manager.registerItem(item);
        }
    }

    @LoadingStage
    public void load(WorldGenerationManager manager) {
        manager.registerChunkGenerator(new NormalWorldGenerator(this));

        for (KRegion region : registry.getAllRegions()) {
            manager.registerRegion(region);
        }
    }

    public KRegistry getRegistry() {
        return registry;
    }

    public void setRegistry(KRegistry registry) {
        this.registry = registry;
    }

    public static KVanilla getInstance() {
        return instance;
    }
}