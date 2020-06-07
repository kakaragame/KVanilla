package org.kakara.kvanilla.entitys.passive.natural;


import org.kakara.core.annotations.Key;
import org.kakara.core.annotations.Model;
import org.kakara.core.annotations.Name;
import org.kakara.core.annotations.Texture;
import org.kakara.core.game.entity.EntitySpawningPattern;
import org.kakara.core.game.entity.PathFinder;
import org.kakara.core.mod.Mod;
import org.kakara.core.mod.game.ModEntity;

@Name("Cow")
@Texture("textures/entities/passive/natural/cow.png")
@Key("cow")
@Model("models/entities/passive/natural/cow.obj")
public class Cow extends ModEntity {

    public Cow(Mod mod) {
        super(mod);
    }

    @Override
    public PathFinder getPathFinder() {
        return null;
    }

    @Override
    public EntitySpawningPattern getEntitySpawningPattern() {
        return null;
    }
}
