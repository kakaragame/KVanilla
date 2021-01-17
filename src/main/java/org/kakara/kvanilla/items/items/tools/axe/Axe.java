package org.kakara.kvanilla.items.items.tools.axe;


import org.kakara.core.common.game.Tool;
import org.kakara.core.common.mod.Mod;
import org.kakara.core.common.mod.game.GameMod;
import org.kakara.core.common.mod.game.ModItem;
import org.kakara.kvanilla.bases.WoodBase;

public abstract class Axe extends ModItem implements Tool {

    public Axe(GameMod mod) {
        super(mod);
    }
}
