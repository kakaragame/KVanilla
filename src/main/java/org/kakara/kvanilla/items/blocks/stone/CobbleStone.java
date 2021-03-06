package org.kakara.kvanilla.items.blocks.stone;

import org.kakara.core.common.annotations.Hardness;
import org.kakara.core.common.annotations.Key;
import org.kakara.core.common.annotations.Name;
import org.kakara.core.common.annotations.Texture;
import org.kakara.core.common.mod.Mod;
import org.kakara.core.common.mod.game.GameMod;
import org.kakara.kvanilla.bases.StoneBase;

@Name("Cobblestone")
@Texture("textures/items/blocks/stone/cobblestone.png")
@Key("cobblestone")
public class CobbleStone extends StoneBase {
    public CobbleStone(GameMod mod) {
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