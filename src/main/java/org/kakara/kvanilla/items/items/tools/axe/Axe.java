package org.kakara.kvanilla.items.items.tools.axe;

import org.kakara.core.game.Tool;
import org.kakara.core.mod.Mod;
import org.kakara.core.mod.game.ModItem;
import org.kakara.kvanilla.bases.WoodBase;

public abstract class Axe extends ModItem implements Tool {

    public Axe(Mod mod) {
        super(mod);
    }

    @Override
    public Class<?>[] targetedBlocks() {
        return new Class[]{WoodBase.class};
    }

}
