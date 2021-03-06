package org.kakara.kvanilla.items.blocks.stone;

import org.kakara.core.common.annotations.Hardness;
import org.kakara.core.common.annotations.Key;
import org.kakara.core.common.annotations.Name;
import org.kakara.core.common.annotations.Texture;
import org.kakara.core.common.mod.Mod;
import org.kakara.core.common.mod.game.GameMod;
import org.kakara.kvanilla.bases.StoneBase;

@Name("Stone")
@Texture("textures/items/blocks/stone/stone.png")
@Key("stone")
public class Stone extends StoneBase {
    public Stone(GameMod mod) {
        super(mod);
    }


    @Override
    public float getResistance() {
        return 0;
    }

    @Override
    public int getHarvestLevel() {
        return 0;
    }
}
