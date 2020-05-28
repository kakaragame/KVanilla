package org.kakara.kvanilla.api.generation;

import org.kakara.core.world.Schematic;

public interface OreGenerator {
    Schematic generateOreVein(int y);
}
