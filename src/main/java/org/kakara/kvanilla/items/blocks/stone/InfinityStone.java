package org.kakara.kvanilla.items.blocks.stone;

import org.kakara.core.common.annotations.Hardness;
import org.kakara.core.common.annotations.Key;
import org.kakara.core.common.annotations.Name;
import org.kakara.core.common.annotations.Texture;
import org.kakara.core.common.mod.Mod;
import org.kakara.core.common.mod.game.GameMod;
import org.kakara.kvanilla.bases.StoneBase;

/***
 * You can mine for an infinity but it will never break
 *
 * *Will be used as the bottom layer of blocks. *
 */
@Name("Infinity Stone")
@Texture("textures/items/blocks/stone/infinity_stone.png")
@Key("infinity_stone")
@Hardness(10)
public class InfinityStone extends StoneBase {
    public InfinityStone(GameMod mod) {
        super(mod);
    }


}