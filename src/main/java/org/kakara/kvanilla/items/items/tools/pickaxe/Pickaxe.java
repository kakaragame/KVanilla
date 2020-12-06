package org.kakara.kvanilla.items.items.tools.pickaxe;

import org.kakara.core.common.game.Tool;
import org.kakara.core.common.mod.Mod;
import org.kakara.core.common.mod.game.ModItem;
import org.kakara.kvanilla.bases.StoneBase;


public abstract class Pickaxe extends ModItem implements Tool {

    public Pickaxe(Mod mod) {
        super(mod);
    }


    @Override
    public Class<?>[] targetedBlocks() {
        return new Class[]{StoneBase.class};
    }

    @Override
    public String getModel() {
        return "models/items/tools/pickaxe.obj";
    }
}
