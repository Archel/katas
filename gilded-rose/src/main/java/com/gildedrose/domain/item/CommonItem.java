package com.gildedrose.domain.item;

import com.gildedrose.Item;

public class CommonItem extends Item {
    public CommonItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality() {
        decreaseQuality();

        if (sellIn < 0) {
            decreaseQuality();
        }
    }

    protected void decreaseQuality() {
        if (quality > 0) {
            quality -= 1;
        }
    }
}
