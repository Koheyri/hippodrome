import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;


class MainTest {

    @Disabled
    @Test
    @DisplayName("Check times 22sec")
    @Timeout(value = 22)
    public void mainTest() throws Exception{
        Main.main(new String[0]);
    }
}