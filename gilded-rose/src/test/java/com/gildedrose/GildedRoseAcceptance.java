package com.gildedrose;

import com.gildedrose.domain.item.CommonItemFactory;
import org.junit.Test;

import static com.gildedrose.ItemBuilder.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GildedRoseAcceptance {

    @Test
    public void
    decrease_the_sell_in_of_the_common_item() {
        Item item = aCommonItem()
                .withQuality(4)
                .withSellIn(1)
                .build();

        Item updatedItem = updateQualityOf(item);

        assertThat(updatedItem.sellIn, is(0));
    }

    @Test
    public void
    decease_the_quality_for_the_common_items_with_quality_and_sell_in_higher_than_zero() {
        Item item = aCommonItem()
                        .withQuality(1)
                        .withSellIn(1)
                        .build();

        Item updatedItem = updateQualityOf(item);

        assertThat(updatedItem.quality, is(0));
    }

    @Test
    public void
    don_t_decrease_the_quality_for_an_items_with_quality_zero() {
        Item item = aCommonItem()
                .withQuality(0)
                .withSellIn(1)
                .build();

        Item updatedItem = updateQualityOf(item);

        assertThat(updatedItem.quality, is(0));
    }


    @Test
    public void
    decrease_the_quality_twice_if_the_common_item_sell_in_is_below_than_zero() {
        Item item = aCommonItem()
                .withQuality(4)
                .withSellIn(0)
                .build();

        Item updatedItem = updateQualityOf(item);

        assertThat(updatedItem.quality, is(2));
    }

    @Test
    public void
    don_t_increase_of_decrease_the_sell_in_or_quality_of_legendary_item() {
        Item item = aLegendaryItem()
                        .withQuality(1)
                        .withSellIn(1)
                        .build();

        Item updatedItem = updateQualityOf(item);

        assertThat(updatedItem.sellIn, is(1));
        assertThat(updatedItem.quality, is(1));
    }

    @Test
    public void
    decrease_the_sell_in_of_aged_brie() {
        Item item = anAgedBrie()
                .withQuality(1)
                .withSellIn(2)
                .build();

        Item updatedItem = updateQualityOf(item);

        assertThat(updatedItem.sellIn, is(1));
    }

    @Test
    public void
    don_t_increase_the_quality_of_aged_brie_over_fifty() {
        Item item = anAgedBrie()
                        .withQuality(50)
                        .withSellIn(1)
                        .build();

        Item updatedItem = updateQualityOf(item);

        assertThat(updatedItem.quality, is(50));

    }

    @Test
    public void
    increase_the_quality_of_the_aged_brie() {
        Item item = anAgedBrie()
                        .withSellIn(1)
                        .withQuality(1)
                        .build();

        Item updatedItem = updateQualityOf(item);

        assertThat(updatedItem.quality, is(2));
    }

    @Test
    public void
    increase_twice_the_quality_of_the_aged_brie_if_the_sell_in_is_below_zero() {
        Item item = anAgedBrie()
                        .withQuality(1)
                        .withSellIn(0)
                        .build();

        Item updatedItem = updateQualityOf(item);

        assertThat(updatedItem.quality, is(3));
    }

    @Test
    public void
    decrease_the_sell_in_of_backstage_passes() {
        Item item = aBackstagePasses()
                        .withQuality(0)
                        .withSellIn(1)
                        .build();

        Item updatedItem = updateQualityOf(item);

        assertThat(updatedItem.sellIn, is(0));
    }

    @Test
    public void
    don_t_increase_the_quality_of_backstage_passes_over_fifty() {
        Item item = aBackstagePasses()
                        .withQuality(50)
                        .withSellIn(8)
                        .build();

        Item updatedItem = updateQualityOf(item);

        assertThat(updatedItem.quality, is(50));
    }

    @Test
    public void
    increase_the_quality_of_backstage_passes_by_three_if_the_sell_in_is_below_five_but_higher_than_zero() {
        Item item = aBackstagePasses()
                .withQuality(0)
                .withSellIn(5)
                .build();

        Item updatedItem = updateQualityOf(item);

        assertThat(updatedItem.quality, is(3));
    }

    @Test
    public void
    increase_the_quality_twice_of_backstage_passes_if_the_sell_in_is_between_five_and_ten() {
        Item item = aBackstagePasses()
                        .withQuality(8)
                        .withSellIn(8)
                        .build();

        Item updatedItem = updateQualityOf(item);

        assertThat(updatedItem.quality, is(10));
    }

    @Test
    public void
    set_the_quality_to_zero_of_backstage_passes_if_the_sell_in_is_below_zero() {
        Item item = aBackstagePasses()
                        .withQuality(8)
                        .withSellIn(0)
                        .build();

        Item updatedItem = updateQualityOf(item);

        assertThat(updatedItem.quality, is(0));
    }

    @Test
    public void
    decrease_the_sell_in_of_conjured_items() {
        Item item = aConjuredItem()
                        .withQuality(0)
                        .withSellIn(1)
                        .build();

        Item updatedItem = updateQualityOf(item);

        assertThat(updatedItem.sellIn, is(0));
    }

    @Test
    public void
    decrease_twice_the_quality_of_conjured_item_if_the_sell_in_is_higher_than_zero() {
        Item item = aConjuredItem()
                .withQuality(2)
                .withSellIn(1)
                .build();

        Item updatedItem = updateQualityOf(item);

        assertThat(updatedItem.quality, is(0));
    }

    @Test
    public void
    decrease_the_quality_by_four_of_conjured_item_if_the_sell_in_is_below_zero() {
        Item item = aConjuredItem()
                .withQuality(5)
                .withSellIn(0)
                .build();

        Item updatedItem = updateQualityOf(item);

        assertThat(updatedItem.quality, is(1));
    }

    private Item updateQualityOf(Item item) {
        Item[] items = new Item[]{item};
        GildedRose gildedRose = new GildedRose(items, new CommonItemFactory());
        gildedRose.updateQuality();

        return items[0];
    }
}
