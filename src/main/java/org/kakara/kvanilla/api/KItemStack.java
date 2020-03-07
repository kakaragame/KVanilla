package org.kakara.kvanilla.api;

import org.kakara.core.charm.Charm;
import org.kakara.core.game.Item;
import org.kakara.core.game.ItemStack;
import org.kakara.core.game.MetaData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KItemStack implements ItemStack {
    private Item item;
    private MetaData metaData;
    private int count = 1;
    private Map<Charm, Byte> charms = new HashMap<>();

    public KItemStack(Item item) {
        this.item = item;
        this.metaData = new MetaData() {
            private String name = item.getName();
            private List<String> lore = new ArrayList<>();

            @Override
            public String getName() {
                return name;
            }

            @Override
            public void setName(String name) {
                this.name = name;
            }

            @Override
            public void setLore(List<String> lore) {
                this.lore = lore;
            }

            @Override
            public List<String> getLore() {
                return lore;
            }

            @Override
            public Map<String, String> getItemData() {
                return metaData.getItemData();
            }

            @Override
            public void setItemData(String key, String value) {
                metaData.setItemData(key, value);
            }
        };
    }

    @Override
    public Item getItem() {
        return item;
    }

    @Override
    public MetaData getMetaData() {
        return metaData;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public Map<Charm, Byte> getCharms() {
        return charms;
    }

    @Override
    public void addCharm(Charm charm, Byte level) {
        charms.put(charm, level);
    }
}
