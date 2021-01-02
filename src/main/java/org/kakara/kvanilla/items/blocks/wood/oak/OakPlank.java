package org.kakara.kvanilla.items.blocks.wood.oak;

import org.kakara.core.common.annotations.Hardness;
import org.kakara.core.common.annotations.Key;
import org.kakara.core.common.annotations.Name;
import org.kakara.core.common.annotations.Texture;
import org.kakara.core.common.mod.Mod;
import org.kakara.core.common.mod.game.GameMod;
import org.kakara.kvanilla.items.blocks.wood.Plank;

@Name("Oak Planks")
@Texture("textures/items/blocks/wood/oak/oak_planks.png")
@Key("oak")
public class OakPlank extends Plank {
    public OakPlank(GameMod mod) {
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
