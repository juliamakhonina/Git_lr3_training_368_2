import java.util.ArrayList;
import java.util.List;

public class App {

    private final List<String> log = new ArrayList<>();

    public void add(String message) {
        log.add(message);
    }

    public void printAll() {
        for (int i = 0; i < log.size(); i++) {
            System.out.println((i + 1) + ") " + log.get(i));
        }
    }

    public static void main(String[] args) {
        App app = new App();
        app.add("First message");
        app.add("Second message");
        app.add("Third message");
        app.printAll();
    }
}