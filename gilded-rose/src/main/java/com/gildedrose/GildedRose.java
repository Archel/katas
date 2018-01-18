package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
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
                    decreaseQuality(item);
                    decreaseQuality(item);

                    if (item.sellIn < 0) {
                        decreaseQuality(item);
                        decreaseQuality(item);
                    }
                    break;
                default:
                    decreaseQuality(item);

                    if (item.sellIn < 0) {
                        decreaseQuality(item);
                    }
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