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
        System.out.println("Enter cell (1..9):");
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));
        x = Integer.parseInt(reader.readLine());
        while (field[x] == "0" || field[x] == "X" || x < 0 || x > 2) {
            System.out.println("Enter x:");
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
// возвращает символ победителя или символ пробела если пока никто не
// выиграл
    public static char checkGame() {
        String winner = " ";
        // Проверка по горизонтали
        for (int i = 0; i < 3; i++) {
            if (field[i][0] == field[i][1] && field[i][1] == field[i][2]
                    && field[i][0] != '+') {
                winner = field[i][0];
                break;
            }
        }

        // Проверка по вертикали если победитель пока не найден
        if (winner == ' ') {
            for (int i = 0; i < 3; i++) {
                if (field[0][i] == field[1][i] && field[1][i] == field[2][i]
                        && field[0][i] != '+') {
                    winner = field[0][i];
                    break;
                }
            }
        }

        // Проверка главной диагонали если победитель пока не найден
        if (winner == ' ') {
            if (field[0][0] == field[1][1] && field[1][1] == field[2][2]
                    && field[0][0] != '+') {
                winner = field[0][0];
            }
        }

        // Проверка побочной диагонали если победитель пока не найден
        if (winner == ' ') {
            if (field[0][2] == field[1][1] && field[1][1] == field[2][0]
                    && field[0][2] != '+') {
                //UPD: Спасибо Михаилу! Вот здесь ошибочка!:
                //winner = field[0][0];
                // Должно быть так:
                winner = field[0][2];
            }
        }
        // Возвращаем победителя или проебл, если такового пока нет
        return winner;
    }

    //Следующий метод определяет остались ли еще на игровом поле свободные клетки.
    public static boolean canMove() {
        boolean p = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j] == '+') {
                    p = true;
                    break;
                }
            }
            if (p = true) {
                break;
            }
        }
        return p;
    }

    public static void printField() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }
}



