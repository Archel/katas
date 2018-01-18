package com.gildedrose;

import com.gildedrose.domain.item.CommonItem;
import com.gildedrose.domain.item.ConjuredItem;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }

            decreaseSellIn(item);

            switch (item.name) {
                case "Aged Brie":
                    increaseQuality(item);

                    if (item.sellIn < 0) {
                        increaseQuality(item);
                    }
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    increaseQuality(item);

                    if (item.sellIn < 10) {
                        increaseQuality(item);
                    }

                    if (item.sellIn < 5) {
                        increaseQuality(item);
                    }

                    if (item.sellIn < 0) {
                        item.quality = 0;
                    }
                    break;
                case "Conjured Mana Cake":
                    ConjuredItem conjuredItem = new ConjuredItem(item.name, item.sellIn, item.quality);
                    conjuredItem.updateQuality();
                    items[i] = conjuredItem;
                    break;
                default:
                    CommonItem commonItem = new CommonItem(item.name, item.sellIn, item.quality);
                    commonItem.updateQuality();
                    items[i] = commonItem;
                    break;
            }
        }
    }

    private void decreaseSellIn(Item item) {
        item.sellIn -= 1;
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality -= 1;
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
        }
    }
}