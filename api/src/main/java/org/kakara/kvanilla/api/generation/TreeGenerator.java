package org.kakara.kvanilla.api.generation;

import org.kakara.core.world.Schematic;

import javax.swing.plaf.synth.Region;

public interface TreeGenerator {
    Schematic generateTree(Region region);
}
