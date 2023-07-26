import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class AccountNumberGenerator {
    public static String[] generateRandomAccountNumbers(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("Count must be a positive integer.");
        }

        String[] accountNumbers = new String[count];
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 10; j++) {
                sb.append(random.nextInt(10));
            }
            accountNumbers[i] = sb.toString();
        }

        return accountNumbers;
    }
}

