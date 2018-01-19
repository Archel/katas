package com.gildedrose.domain.item;

import com.gildedrose.Item;

public class CommonItemFactory {
    public CommonItem createFrom(Item item) {
        return new CommonItem(item.name, item.sellIn, item.quality);
    }
}
