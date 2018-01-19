package com.gildedrose.domain.item;

import com.gildedrose.Item;

public class CommonItem extends Item {
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
        if (hasTheMinimumQuality()) {
            quality -= 1;
        }
    }

    private boolean hasTheMinimumQuality() {
        return quality > 0;
    }

    protected void increaseQuality() {
        if (hasTheMaximumQuality()) {
            quality += 1;
        }
    }

    private boolean hasTheMaximumQuality() {
        return quality < 50;
    }

    private void decreaseSellIn() {
        sellIn -= 1;
    }
}
