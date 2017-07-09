
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * @author Fominykh Vladimir
 */
public class GameLogic {

    private Field field;
    private BufferedReader reader;

    GameLogic() {
        field = new Field();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }


    public void play() throws IOException {
        field.paintField();
        humanMove();
        if (!field.canMove()) {
            compMove();
        }
    }

//}
    // Ход человека
    private void humanMove() throws IOException {
        int n;
        boolean isReaderCorrect;
        do {
            System.out.println("Enter cell (0..8):");
            n = Integer.parseInt(reader.readLine());
            isReaderCorrect = field.isCellCanBeAdded(n);
            if (! isReaderCorrect) {
                System.out.println("Incorrect X should be in [0,8],Or cell in not empty");
            }
        } while (! isReaderCorrect);

        field.addHumanCell(n);
    }

    // Ход компьютера (random-бот)
    private void compMove() {
        int n;
        boolean isReaderCorrect;
        do {
            n = (int) (Math.random() * 9);
            isReaderCorrect = field.isCellCanBeAdded(n);
        } while (!isReaderCorrect);
            field.addCompCell(n);
        }



    public boolean isRunning() {
        boolean isRunning = true;

            if (field.isUserWin()) {
                field.paintField();
                System.out.println("YOU WIN!");
                isRunning = false;

            } else if (field.isComputerWin()) {
                field.paintField();
                System.out.println("YOU LOSE!");
                isRunning = false;

            } else if (field.canMove()) {
                field.paintField();
                System.out.println("STANDOFF!");
                isRunning = false;

            }
            return isRunning;
    }
}











