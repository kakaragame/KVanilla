package org.kakara.kvanilla.mod;

import org.kakara.core.game.Entity;
import org.kakara.core.game.Item;
import org.kakara.core.game.Ore;
import org.kakara.kvanilla.api.ForgeRecipe;
import org.kakara.kvanilla.api.KItem;
import org.kakara.kvanilla.api.KOre;
import org.kakara.kvanilla.api.KRegistry;

import java.util.Set;
import java.util.stream.Collectors;

public class KGenericRegistry implements KRegistry {
					private final Set<KEntity> allEntities = new AppliedHashSet<>();
					private final Set<KEntity> passiveEntities = allEntities.stream().filter(KEntity::isPassive).collect(Collectors.toUnmodifiableSet());
					private final Set<KEntity> aggressiveEntities = allEntities.stream().filter((entity) -> !entity.isPassive()).collect(Collectors.toUnmodifiableSet());

					@Override
					public Set<KEntity> getAllEntities() {
										return allEntities;
					}

					@Override
					public Set<KEntity> getPassiveEntities() {
										return passiveEntities;
					}

					@Override
					public Set<KEntity> getAggressiveEntities() {
										return aggressiveEntities;
					}

					@Override
					public Set<KEntity> getNormalEntities() {
										return null;
					}

					@Override
					public Set<KItem> getAllItems() {
										return null;
					}

					@Override
					public Set<KOre> getAllOres() {
										return null;
					}

					@Override
					public Set<KOre> getNormalOres() {
										return null;
					}

					@Override
					public Set<ForgeRecipe> getForgeRecipes() {
										return null;
					}
}
