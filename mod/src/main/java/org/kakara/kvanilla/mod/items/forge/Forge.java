package org.kakara.kvanilla.mod.items.forge;

import org.kakara.core.events.entity.StepOnEvent;
import org.kakara.core.events.player.PlaceEvent;
import org.kakara.core.events.player.click.ClickEvent;
import org.kakara.core.gui.Menu;
import org.kakara.core.mod.Mod;
import org.kakara.core.mod.game.ModBlock;

public class Forge extends ModBlock {
    public Forge(Mod mod) {
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
        clickEvent.getPlayer().openMenu(new Menu() {
        });
    }
}