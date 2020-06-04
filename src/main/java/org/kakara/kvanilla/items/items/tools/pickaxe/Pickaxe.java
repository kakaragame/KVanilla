package org.kakara.kvanilla.items.items.tools.pickaxe;

import org.kakara.core.events.player.click.ClickEvent;
import org.kakara.core.game.Tool;
import org.kakara.core.mod.Mod;
import org.kakara.core.mod.game.ModItem;
import org.kakara.kvanilla.bases.StoneBase;


public abstract class Pickaxe extends ModItem implements Tool {

    public Pickaxe(Mod mod) {
        super(mod);
    }


    @Override
    public Class<?>[] targetedBlocks() {
        return new Class[]{StoneBase.class};
    }
}