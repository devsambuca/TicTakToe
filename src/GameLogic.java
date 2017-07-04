import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Fominykh Vladimir
 */
public class GameLogic {

    // Игровое поле
    public static String[] field = new String[9];

    // Ход человека
    public static void humanMove() throws IOException {
        int x;
        System.out.println("Enter cell (0..8):");
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));
        x = Integer.parseInt(reader.readLine());
        while (field[x] == "0" || field[x] == "X" || x < 0 || x > 8) {
            System.out.println("Enter cell:");
            x = Integer.parseInt(reader.readLine());

        }
        field[x] = "X";
    }

    // Ход компьютера (random-бот)
    public static void compMove() {
        int x = (int) (Math.random() * 9), y = (int) (Math.random() * 3);
        while (field[x] == "0" || field[x] == "X") {
            x = (int) (Math.random() * 9);

        }
        field[x] = "0";
    }

    // Проерка состояния игры и есть ли победители
// возвращает символ победителя если пока никто не
// выиграл
    public static String checkGame() {
        String winner = " ";
        // Проверка по горизонтали
        for (int i = 0; i < 3; i++) {
            if (field[0] == field[1] && field[1] == field[2]
                    && field[0] != null) {
                winner = field[0];
                break;
            }
        }

        // Проверка по вертикали если победитель пока не найден
        if (winner == null) {
            for (int i = 0; i < 3; i++) {
                if (field[0] == field[3] && field[3] == field[6]
                        && field[0] != null) {
                    winner = field[0];
                    break;
                }
                if (field[3] == field[4] && field[4] == field[5]
                        && field[0] != null) {
                    winner = field[0];
                    break;
                }
                if (field[6] == field[7] && field[7] == field[8]
                        && field[0] != null) {
                    winner = field[0];
                    break;
                }
            }
        }

        // Проверка главной диагонали если победитель пока не найден
        if (winner == null) {
            if (field[0] == field[4] && field[4] == field[8]
                    && field[0] != null) {
                winner = field[0];
            }
        }

        // Проверка побочной диагонали если победитель пока не найден
        if (winner == null) {
            if (field[2] == field[4] && field[4] == field[6]
                    && field[2] != null) {
                winner = field[2];
            }
        }
        return winner;
    }




    //Следующий метод определяет остались ли еще на игровом поле свободные клетки.
    public static boolean canMove() {
        boolean p = false;
        for (int i = 0; i < 9; i++) {
                if (field[i] == null) {
                    p = true;
                    break;
                }
            }


        return p;
    }

    public static void printField() {
        for (int i = 0; i < 9; i++) {

                System.out.print(field[i]);
            }
            System.out.println();
        }
    }




