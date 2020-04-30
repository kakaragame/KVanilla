package org.kakara.kvanilla.api.generation;

import org.kakara.core.world.Schematic;
import org.kakara.core.world.region.Region;

public interface TreeGenerator {
    Schematic generateTree(Region region);
}
