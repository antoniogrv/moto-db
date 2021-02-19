import endpoint.MotoDB;
import config.Config;

public class App {
    public static void main(String[] args) {
        Config.setConfigurations();
        new MotoDB();
    }
}
