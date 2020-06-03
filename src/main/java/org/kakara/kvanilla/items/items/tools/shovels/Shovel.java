package org.kakara.kvanilla.items.items.tools.shovels;

import org.kakara.core.game.Tool;
import org.kakara.core.mod.Mod;
import org.kakara.core.mod.game.ModItem;
import org.kakara.kvanilla.bases.DirtBase;

public abstract class Shovel extends ModItem implements Tool {
    public Shovel(Mod mod) {
        super(mod);
    }


    @Override
    public Class<?>[] targetedBlocks() {
        return new Class[]{DirtBase.class};
    }

}