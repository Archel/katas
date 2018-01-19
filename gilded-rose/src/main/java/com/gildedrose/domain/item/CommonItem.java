package com.gildedrose.domain.item;

import com.gildedrose.Item;

public class CommonItem extends Item {

    private static final int MAXIMUM_QUALITY = 50;
    private static final int MINIMUM_QUALITY = 0;

    public CommonItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateSellInAndQuality() {
        decreaseSellIn();
        updateQuality();
    }

    public void updateQuality() {
        decreaseQuality();

        if (isSoldOut()) {
            decreaseQuality();
        }
    }

    protected boolean isSoldOut() {
        return sellIn < 0;
    }

    protected void decreaseQuality() {
        if (higherThanMinimumQuality()) {
            quality -= 1;
        }
    }

    private boolean higherThanMinimumQuality() {
        return quality > MINIMUM_QUALITY;
    }

    protected void increaseQuality() {
        if (lowerThanMaximumQuality()) {
            quality += 1;
        }
    }

    private boolean lowerThanMaximumQuality() {
        return quality < MAXIMUM_QUALITY;
    }

    private void decreaseSellIn() {
        sellIn -= 1;
    }
}
