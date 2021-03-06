package com.gildedrose.domain.item;

public class ConjuredItem extends CommonItem {
    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        decreaseQualityIfHigherThanMinimumQuality();
        decreaseQualityIfHigherThanMinimumQuality();

        if (isSoldOut()) {
            decreaseQualityIfHigherThanMinimumQuality();
            decreaseQualityIfHigherThanMinimumQuality();
        }
    }
}
