package org.kakara.kvanilla.items.blocks.stone;

import org.kakara.core.annotations.Hardness;
import org.kakara.core.annotations.Id;
import org.kakara.core.annotations.Name;
import org.kakara.core.annotations.Texture;
import org.kakara.core.events.entity.StepOnEvent;
import org.kakara.core.events.player.PlaceEvent;
import org.kakara.core.events.player.click.ClickEvent;
import org.kakara.core.mod.Mod;
import org.kakara.kvanilla.bases.StoneBase;

/***
 * You can mine for an infinity but it will never break
 *
 * *Will be used as the bottom layer of blocks. *
 */
@Name("Infinity Stone")
@Texture("textures/items/blocks/stone/infinity_stone.png")
@Id("infinity_stone")
@Hardness(10)
public class InfinityStone extends StoneBase {
    public InfinityStone(Mod mod) {
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