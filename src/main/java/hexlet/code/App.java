package hexlet.code;
public class App {
    public static void main(String[] args) {
        switch (Cli.choice()) {
            case 1:
                Cli.greeting();
                break;
            case 2:
                Even.start();
        }
    }
}
