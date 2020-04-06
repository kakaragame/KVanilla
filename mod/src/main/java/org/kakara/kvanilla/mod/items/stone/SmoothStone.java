package org.kakara.kvanilla.mod.items.stone;

import org.kakara.core.annotations.Id;
import org.kakara.core.annotations.Name;
import org.kakara.core.annotations.Texture;
import org.kakara.core.events.entity.StepOnEvent;
import org.kakara.core.events.player.click.ClickEvent;
import org.kakara.core.events.player.PlaceEvent;
import org.kakara.core.mod.Mod;
import org.kakara.kvanilla.api.bases.StoneBase;

@Name("Smooth Stone")
@Texture("smooth_stone.png")
@Id("smooth_stone")
public class SmoothStone extends StoneBase {
    public SmoothStone(Mod mod) {
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
