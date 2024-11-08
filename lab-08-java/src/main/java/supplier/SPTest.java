package supplier;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

public class SPTest {

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        Supplier<LocalDateTime> s = () -> LocalDateTime.now();
        LocalDateTime time = s.get();

        System.out.println(time);
    }
}
