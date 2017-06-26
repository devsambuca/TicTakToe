import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Fominykh Vladimir
 */
public class GameRunner {
    public static void main(String[] args) throws IOException {
        GameLogic logic = new GameLogic();
        logic.change();
        Field field = new Field();
        field.paintField();
    }
}
