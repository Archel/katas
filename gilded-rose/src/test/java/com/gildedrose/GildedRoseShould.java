package com.gildedrose;

import com.gildedrose.domain.item.CommonItem;
import com.gildedrose.domain.item.CommonItemFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GildedRoseShould {
    @Mock
    private CommonItemFactory commonItemFactory;

    @Mock
    private CommonItem commonItem;

    private static final Item A_ITEM = new Item("some commonItem", 1, 1);

    @Test
    public void
    update_the_item_properties() {
        Item[] items = new Item[]{A_ITEM};
        GildedRose gildedRose = new GildedRose(items, commonItemFactory);

        given(commonItemFactory.createFrom(A_ITEM))
                .willReturn(commonItem);

        gildedRose.updateQuality();

        verify(commonItem).updateProperties();
        assertThat(items[0], is(commonItem));
    }
}
