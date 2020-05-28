package org.kakara.kvanilla.api;

import org.kakara.core.game.Item;

public interface ForgeRecipe {
    Item getFirstIngredient();

    Item getSecondIngredient();

    Item getResult();

    long getTime();
}