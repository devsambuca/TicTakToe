import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Fominykh Vladimir
 */
public class GameRunner {
    public static void main(String[] args) throws IOException {
        GameLogic gameLogic = new GameLogic();
        Field field = new Field();
        System.out.println("Game Started!!!");
        while (gameLogic.checkGame() == " " && gameLogic.canMove()) {
            gameLogic.humanMove();
            gameLogic.compMove();
            gameLogic.printField();
        }
        if (gameLogic.checkGame().equals("X")) {
            System.out.println("YOU WIN!");
        }
        if (gameLogic.checkGame().equals("0")) {
            System.out.println("YOU LOSE!");
        }
        if (gameLogic.checkGame() == " "  && !gameLogic.canMove()) {
            System.out.println("STANDOFF!");
        }
    }


}

