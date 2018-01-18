package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.ItemBuilder.aNormalItem;
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

    private void updateQualityOf(Item item) {
        GildedRose gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();
    }
}
