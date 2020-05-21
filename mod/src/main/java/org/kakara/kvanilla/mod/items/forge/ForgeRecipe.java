package org.kakara.kvanilla.mod.items.forge;

import org.kakara.core.game.Item;
import org.kakara.kvanilla.mod.items.materials.*;

public enum ForgeRecipe {
    BRONZE(Copper.class, Tin.class, Bronze.class),
    AURON(Gold.class, Iron.class, Auron.class);

    private final Class<? extends Item> one;
    private final Class<? extends Item> two;
    private final Class<? extends Item> result;

    ForgeRecipe(Class<? extends Item> one, Class<? extends Item> two, Class<? extends Item> result) {
        this.one = one;
        this.two = two;
        this.result = result;
    }

    public Class<? extends Item> getOne() {
        return one;
    }

    public Class<? extends Item> getTwo() {
        return two;
    }

    public Class<? extends Item> getResult() {
        return result;
    }
}
