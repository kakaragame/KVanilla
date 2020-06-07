package org.kakara.kvanilla.items.blocks.stone;

import org.kakara.core.annotations.Key;
import org.kakara.core.annotations.Name;
import org.kakara.core.annotations.Texture;
import org.kakara.core.events.entity.StepOnEvent;
import org.kakara.core.events.player.PlaceEvent;
import org.kakara.core.events.player.click.ClickEvent;
import org.kakara.core.mod.Mod;
import org.kakara.kvanilla.bases.StoneBase;

@Name("Cobblestone")
@Texture("textures/items/blocks/stone/cobblestone.png")
@Key("cobblestone")
public class CobbleStone extends StoneBase {
    public CobbleStone(Mod mod) {
        super(mod);
    }

    @Override
    public void onStep(StepOnEvent event) {

    }

    @Override
    public void onPlace(PlaceEvent event) {

    }

    @Override
    public void onClick(ClickEvent clickEvent) {

    }
}