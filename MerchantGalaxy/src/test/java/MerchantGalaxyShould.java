import com.codurance.merchantgalaxy.Console;
import com.codurance.merchantgalaxy.MerchantGalaxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MerchantGalaxyShould {
    @Mock
    private Console console;

    @Test
    public void
    show_a_good_bye_message_when_exit() {
        MerchantGalaxy merchantGalaxy = new MerchantGalaxy(console);
        given(console.readLine())
            .willReturn("exit");

        merchantGalaxy.run();

        verify(console).printLine("That's all folks!");
    }
}
