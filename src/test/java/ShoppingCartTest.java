import org.example.ShoppingCart;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShoppingCartTest {

    @Test
    void costOfItemsTest() {
        String input = "1\n2\n10\n2\n5\n3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        ShoppingCart.main(new String[]{});

        String result = output.toString();
        assertTrue(result.contains("35"), "Output should contain total cost 35");
    }
}
