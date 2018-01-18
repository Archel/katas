package com.gildedrose;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

    @Test
    public void
    update_the_product_quality_of_given_days() {
        String[] args = {"4"};

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        TexttestFixture.main(args);

        System.out.flush();
        assertThat(byteArrayOutputStream.toString(), is(loadGameResultFromFile(4)));
    }

    private String loadGameResultFromFile(int days) {
        String gameResultFile = String.format("result-days-%d.txt", days);
        System.out.print(gameResultFile);
        try {
            return IOUtils.toString(this.getClass().getResourceAsStream(gameResultFile), "UTF-8");
        } catch (IOException e) {
            return "";
        }
    }
}
