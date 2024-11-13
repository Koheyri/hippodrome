import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;


class MainTest {

    @Disabled
    @Test
    @DisplayName("Check times 22sec")
    @Timeout(value = 22,unit = TimeUnit.SECONDS)
    public void mainTest() throws Exception{
        Main.main(new String[0]);
    }
}