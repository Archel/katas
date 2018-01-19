package com.gildedrose.domain.item;

public class BackstagePassesItem extends CommonItem {
    public BackstagePassesItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        increaseQualityIfLowerThanMaximumQuality();

        if (tenDaysRemaining()) {
            increaseQualityIfLowerThanMaximumQuality();
        }

        if (fiveDaysRemaining()) {
            increaseQualityIfLowerThanMaximumQuality();
        }

        if (isAfterTheConcert()) {
            dropQuality();
        }
    }

    private boolean fiveDaysRemaining() {
        return sellIn < 5;
    }

    private boolean tenDaysRemaining() {
        return sellIn < 10;
    }

    private void dropQuality() {
        quality = 0;
    }

    private boolean isAfterTheConcert() {
        return sellIn < 0;
    }
}
