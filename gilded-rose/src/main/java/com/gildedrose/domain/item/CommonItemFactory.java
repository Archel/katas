package com.gildedrose.domain.item;

import com.gildedrose.Item;

public class CommonItemFactory {

    public static final String LEGENDARY_ITEM_NAME = "Sulfuras, Hand of Ragnaros";

    public CommonItem createFrom(Item item) {
        if (isLegendary(item)) {
            return new LegendaryItem(item.name, item.sellIn, item.quality);
        }

        return new CommonItem(item.name, item.sellIn, item.quality);
    }

    private boolean isLegendary(Item item) {
        return item.name.equals(LEGENDARY_ITEM_NAME);
    }
}
