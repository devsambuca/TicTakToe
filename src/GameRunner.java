import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Fominykh Vladimir
 */
public class GameRunner {
    public static void main(String[] args) throws IOException {

        System.out.println("Game Started!!!");
        GameLogic game = new GameLogic();
        do {

            game.play();

        } while (game.isRunning());
    }
}






//        while (gameLogic.checkGame() == " " && gameLogic.canMove()) {
//            gameLogic.humanMove();
//            gameLogic.compMove();
//            Field.printField();
//        }
//        if (gameLogic.checkGame().equals("X")) {
//            System.out.println("YOU WIN!");
//        }
//        if (gameLogic.checkGame().equals("0")) {
//            System.out.println("YOU LOSE!");
//        }
//        if (gameLogic.checkGame() == null  && !gameLogic.canMove()) {
//            System.out.println("STANDOFF!");
//        }
//    }


