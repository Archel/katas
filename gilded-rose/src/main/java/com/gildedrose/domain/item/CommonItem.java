package com.gildedrose.domain.item;

import com.gildedrose.Item;

public class CommonItem extends Item {

    private static final int MAXIMUM_QUALITY = 50;
    private static final int MINIMUM_QUALITY = 0;

    public CommonItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateProperties() {
        decreaseSellIn();
        updateQuality();
    }

    public void updateQuality() {
        decreaseQualityIfHigherThanMinimumQuality();

        if (isSoldOut()) {
            decreaseQualityIfHigherThanMinimumQuality();
        }
    }

    protected boolean isSoldOut() {
        return sellIn < 0;
    }

    protected void decreaseQualityIfHigherThanMinimumQuality() {
        if (higherThanMinimumQuality()) {
            quality -= 1;
        }
    }

    private boolean higherThanMinimumQuality() {
        return quality > MINIMUM_QUALITY;
    }

    protected void increaseQualityIfLowerThanMaximumQuality() {
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
