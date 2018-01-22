package com.codurance.merchantgalaxy.acceptance;

import com.codurance.merchantgalaxy.Console;
import com.codurance.merchantgalaxy.MerchantGalaxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class MerchantGalaxyFeature {
    @Mock
    private Console console;

    @Test
    public void
    calculate_the_conversions_between_materials_and_currency() {
        MerchantGalaxy merchantGalaxy = new MerchantGalaxy(console);
        given(console.readLine())
                .willReturn(
                        "glob is I",
                        "prok is V",
                        "pish is X",
                        "tegj is L",
                        "glob glob Silver is 34 Credits",
                        "glob prok Gold is 57800 Credits",
                        "pish pish Iron is 3910 Credits",
                        "how much is pish tegj glob glob ?",
                        "how many Credits is glob prok Silver ?",
                        "how many Credits is glob prok Gold ?",
                        "how many Credits is glob prok Iron ?",
                        "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"
                );

        merchantGalaxy.run();

        InOrder inOrder = Mockito.inOrder(console);
        inOrder.verify(console).printLine("pish tegj glob glob is 42");
        inOrder.verify(console).printLine("glob prok Silver is 68 Credits");
        inOrder.verify(console).printLine("glob prok Gold is 57800 Credits");
        inOrder.verify(console).printLine("glob prok Iron is 782 Credits");
        inOrder.verify(console).printLine("I have no idea what you are talking about");
    }
}
