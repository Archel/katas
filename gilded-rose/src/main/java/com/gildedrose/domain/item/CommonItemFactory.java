package com.gildedrose.domain.item;

import com.gildedrose.Item;

public class CommonItemFactory {

    private static final String LEGENDARY_ITEM = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED_ITEM = "Conjured Mana Cake";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    public CommonItem createFrom(Item item) {
        if (isLegendary(item)) {
            return new LegendaryItem(item.name, item.sellIn, item.quality);
        }

        if(isConjured(item)) {
            return new ConjuredItem(item.name, item.sellIn, item.quality);
        }

        if (isBackStagePasses(item)) {
            return new BackstagePassesItem(item.name, item.sellIn, item.quality);
        }

        return new CommonItem(item.name, item.sellIn, item.quality);
    }

    private boolean isBackStagePasses(Item item) {
        return item.name.equals(BACKSTAGE_PASSES);
    }

    private boolean isConjured(Item item) {
        return item.name.equals(CONJURED_ITEM);
    }

    private boolean isLegendary(Item item) {
        return item.name.equals(LEGENDARY_ITEM);
    }
}
