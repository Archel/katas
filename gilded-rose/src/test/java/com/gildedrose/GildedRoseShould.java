package com.gildedrose;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GildedRoseShould {
    @Test
    public void
    decease_the_quality_for_the_normal_items_with_quality_and_sellin_higer_than_zero() {
        Item item = new Item("normal", 1, 1);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item.quality, is(0));
    }
}
