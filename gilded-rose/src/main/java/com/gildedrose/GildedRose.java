package com.gildedrose;

import com.gildedrose.domain.item.*;

class GildedRose {
    Item[] items;
    private CommonItemFactory commonItemFactory;

    public GildedRose(Item[] items) {
        this.items = items;
        commonItemFactory = new CommonItemFactory();
    }

    public GildedRose(Item[] items, CommonItemFactory commonItemFactory) {
        this.items = items;
        this.commonItemFactory = commonItemFactory;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            CommonItem commonItem = commonItemFactory.createFrom(items[i]);
            commonItem.updateSellInAndQuality();
            items[i] = commonItem;
        }
    }
}