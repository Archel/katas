package com.gildedrose;

public class ItemBuilder {

    private final String name;
    private int sellIn;
    private int quality;

    private ItemBuilder(String name) {
        this.name = name;
    }

    public static ItemBuilder aNormalItem() {
        return new ItemBuilder("normal");
    }

    public ItemBuilder withQuality(int quality) {
        this.quality = quality;
        return this;
    }

    public ItemBuilder withSellIn(int sellIn) {
        this.sellIn = sellIn;
        return this;
    }

    public Item build() {
        return new Item(name, sellIn, quality);
    }
}
