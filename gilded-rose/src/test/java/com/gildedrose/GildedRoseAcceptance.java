package com.gildedrose;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GildedRoseAcceptance {

    private static final int DAYS = 30;

    @Test
    public void
    update_the_items_quality_through_the_days() {
        OutputStream byteArrayOutputStream = redirectOutputToInMemory();
        String[] args = {String.valueOf(DAYS)};

        TexttestFixture.main(args);

        assertThat(byteArrayOutputStream.toString(), is(loadGameResultFromFile(DAYS)));
    }

    private ByteArrayOutputStream redirectOutputToInMemory() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);
        return byteArrayOutputStream;
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
