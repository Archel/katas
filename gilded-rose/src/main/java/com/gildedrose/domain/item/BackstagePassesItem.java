package com.gildedrose.domain.item;

public class BackstagePassesItem extends CommonItem {
    public BackstagePassesItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        increaseQuality();

        if (sellIn < 10) {
            increaseQuality();
        }

        if (sellIn < 5) {
            increaseQuality();
        }

        if (isAfterTheConcert()) {
            dropQuality();
        }
    }

    private void dropQuality() {
        quality = 0;
    }

    private boolean isAfterTheConcert() {
        return sellIn < 0;
    }
}
