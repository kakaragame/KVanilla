package org.kakara.kvanilla.items.blocks.dirt;


import org.kakara.core.common.annotations.Hardness;
import org.kakara.core.common.annotations.Key;
import org.kakara.core.common.annotations.Name;
import org.kakara.core.common.annotations.Texture;
import org.kakara.core.common.mod.Mod;
import org.kakara.kvanilla.bases.DirtBase;

@Name("Dirt")
@Texture("textures/items/blocks/dirt/dirt.png")
@Key("dirt")
@Hardness(1)
public class Dirt extends DirtBase {
    public Dirt(Mod mod) {
        super(mod);
    }

}