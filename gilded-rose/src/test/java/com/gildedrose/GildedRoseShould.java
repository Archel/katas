package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.ItemBuilder.aLegendaryItem;
import static com.gildedrose.ItemBuilder.aNormalItem;
import static com.gildedrose.ItemBuilder.anAgedBrie;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GildedRoseShould {
    @Test
    public void
    decease_the_quality_for_the_normal_items_with_quality_and_sell_in_higher_than_zero() {
        Item item = aNormalItem()
                        .withQuality(1)
                        .withSellIn(1)
                        .build();

        updateQualityOf(item);

        assertThat(item.quality, is(0));
    }

    @Test
    public void
    don_t_decrease_the_quality_for_the_normal_items_with_quality_zero() {
        Item item = aNormalItem()
                .withQuality(0)
                .withSellIn(1)
                .build();

        updateQualityOf(item);

        assertThat(item.quality, is(0));
    }


    @Test
    public void
    decrease_the_quality_twice_if_the_normal_item_sell_int_is_lower_than_zero() {
        Item item = aNormalItem()
                .withQuality(4)
                .withSellIn(-1)
                .build();

        updateQualityOf(item);

        assertThat(item.quality, is(2));
    }

    @Test
    public void
    decrease_the_sell_in_of_the_normal_item() {
        Item item = aNormalItem()
                .withQuality(4)
                .withSellIn(1)
                .build();

        updateQualityOf(item);

        assertThat(item.sellIn, is(0));
    }

    @Test
    public void
    don_t_increase_of_decrease_the_sell_in_or_quality_of_legendary_item() {
        Item item = aLegendaryItem()
                        .withQuality(1)
                        .withSellIn(1)
                        .build();

        updateQualityOf(item);

        assertThat(item.sellIn, is(1));
        assertThat(item.quality, is(1));
    }

    @Test
    public void
    increase_the_quality_of_the_aged_brie_item() {
        Item item = anAgedBrie()
                        .withSellIn(1)
                        .withQuality(1)
                        .build();

        updateQualityOf(item);

        assertThat(item.quality, is(2));
    }

    @Test
    public void
    increase_twice_the_quality_of_the_aged_brie_item_if_the_sell_in_is_below_zero() {
        Item item = anAgedBrie()
                        .withQuality(1)
                        .withSellIn(0)
                        .build();

        updateQualityOf(item);

        assertThat(item.quality, is(3));
    }

    @Test
    public void
    decrease_the_sell_in_of_aged_brie_item() {
        Item item = anAgedBrie()
                .withQuality(1)
                .withSellIn(2)
                .build();

        updateQualityOf(item);

        assertThat(item.sellIn, is(1));
    }

    private void updateQualityOf(Item item) {
        GildedRose gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();
    }
}
