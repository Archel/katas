package com.gildedrose.domain.item;

public class AgedBrieItem extends CommonItem {
    public AgedBrieItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        increaseQualityIfLowerThanMaximumQuality();

        if (isSoldOut()) {
            increaseQualityIfLowerThanMaximumQuality();
        }
    }
}
