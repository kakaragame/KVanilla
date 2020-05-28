package org.kakara.kvanilla.api;

import org.kakara.kvanilla.api.generation.KRegion;
import org.kakara.kvanilla.mod.KEntity;

import java.util.Set;

public interface KRegistry {
					Set<KRegion> getAllRegions();

					Set<KRegion> getNormalRegions();

					Set<KEntity> getAllEntities();

					Set<KEntity> getPassiveEntities();

					Set<KEntity> getAggressiveEntities();

					Set<KEntity> getNormalEntities();

					Set<KItem> getAllItems();

					Set<KOre> getAllOres();

					Set<KOre> getNormalOres();

					Set<ForgeRecipe> getForgeRecipes();

					default void add(KRegistry registry) {
										getAllRegions().addAll(registry.getAllRegions());
										getNormalRegions().addAll(registry.getNormalRegions());
										getAllEntities().addAll(registry.getAllEntities());
										getPassiveEntities().addAll(registry.getPassiveEntities());
										getAggressiveEntities().addAll(registry.getAggressiveEntities());
										getNormalEntities().addAll(registry.getNormalEntities());
										getAllItems().addAll(registry.getAllItems());
										getAllOres().addAll(registry.getAllOres());
										getNormalOres().addAll(registry.getNormalOres());
										getForgeRecipes().addAll(registry.getForgeRecipes());
					}
}
