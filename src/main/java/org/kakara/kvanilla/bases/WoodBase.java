package org.kakara.kvanilla.bases;
import org.kakara.core.common.game.GameToolTypes;
import org.kakara.core.common.game.ToolType;
import org.kakara.core.common.mod.Mod;
import org.kakara.core.common.mod.game.GameMod;
import org.kakara.core.common.mod.game.ModBlock;

import java.util.Set;

public abstract class WoodBase extends ModBlock {
    public WoodBase(GameMod mod) {
        super(mod);
    }

    @Override
    public Set<ToolType> requiredToolTypes() {
        return Set.of(GameToolTypes.AXE, GameToolTypes.HAND);
    }
}
