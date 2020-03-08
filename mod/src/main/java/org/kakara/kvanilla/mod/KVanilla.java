package org.kakara.kvanilla.mod;

import org.kakara.core.game.Item;
import org.kakara.core.game.ItemManager;
import org.kakara.core.mod.ModType;
import org.kakara.core.mod.annotations.ModInfo;
import org.kakara.core.mod.annotations.OnDisable;
import org.kakara.core.mod.annotations.OnEnable;
import org.kakara.core.mod.annotations.Reload;
import org.kakara.core.mod.game.GameMod;
import org.kakara.core.world.WorldGenerationManager;
import org.kakara.kvanilla.mod.generators.normal.NormalChunkGenerator;
import org.kakara.kvanilla.mod.items.dirt.CoarseDirt;
import org.kakara.kvanilla.mod.items.dirt.Dirt;
import org.kakara.kvanilla.mod.items.dirt.FineDirt;
import org.kakara.kvanilla.mod.items.dirt.GrassyDirt;
import org.slf4j.Logger;

@ModInfo(name = "KVanilla", description = "The Vanilla Game for Kakara", authors = "The Kakara Development Team", modType = ModType.REGULAR, version = "1.0-SNAPSHOT")
public class KVanilla extends GameMod {
    private static KVanilla instance;

    @OnEnable
    public void onEnable() {
        instance = this;

        WorldGenerationManager g = getKakaraCore().getWorldGenerationManager();
        g.registerChunkGenerator(new NormalChunkGenerator());

        register(
                new CoarseDirt(this),
                new Dirt(this),
                new FineDirt(this),
                new GrassyDirt(this)
        );
    }

    public void register(Item... items) {
        ItemManager itemManager = getKakaraCore().getItemManager();

        for (Item item : items) {
            itemManager.registerItem(item, this);
        }
    }

    @Reload
    public void onReload() {

    }

    @OnDisable
    public void onDisable() {

    }

    public static KVanilla getInstance() {
        return instance;
    }

    public static Item get(String name) {
        return getInstance().getKakaraCore().getItemManager().getItem(name);
    }

    @Override
    public Logger getLogger() {
        //Will be deleted later. Just let it sit here to make intellij happy
        return null;
    }
}