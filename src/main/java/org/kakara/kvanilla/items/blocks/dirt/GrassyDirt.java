package org.kakara.kvanilla.items.blocks.dirt;

import org.kakara.core.common.annotations.Hardness;
import org.kakara.core.common.annotations.Key;
import org.kakara.core.common.annotations.Name;
import org.kakara.core.common.annotations.Texture;
import org.kakara.core.common.mod.Mod;
import org.kakara.core.common.mod.game.GameMod;
import org.kakara.kvanilla.bases.DirtBase;

@Name("Grassy Dirt")
@Texture("textures/items/blocks/dirt/grassy_dirt.png")
@Key("grassy_dirt")
@Hardness(1)
public class GrassyDirt extends DirtBase {
    public GrassyDirt(GameMod mod) {
        super(mod);
    }


}