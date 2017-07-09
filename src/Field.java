import java.io.IOException;

/**
 * @author Fominykh Vladimir
 */
public class Field {

    public final String EMPTY_CELL = "0";
    public final String CROSS_CELL = "1";
    public final String ZERO_CELL = "2";
    public final int MEASUREMENT = 9;
    private String[] cells = new String[MEASUREMENT];
    private String humanCellType;
    private String compCellType;


    Field() {
        humanCellType = CROSS_CELL;
        compCellType = ZERO_CELL;

        for (int x = 0; x < MEASUREMENT; x++) {

            cells[x] = EMPTY_CELL;
        }
    }

    public void addHumanCell(int n) {
        addCell(n, humanCellType);
    }

    public void addCompCell(int n) {
        addCell(n, compCellType);
    }

    private void addCell(int n, String cellType) {
        boolean cellTypeAcceptable = cellType == EMPTY_CELL || cellType == CROSS_CELL || cellType == ZERO_CELL;
        if (isCellCanBeAdded(n) && cellTypeAcceptable) {
            cells[n] = cellType;
        } else {
            System.out.println("Failed to add cell");
        }
    }


    public boolean isCellCanBeAdded(int n) {
        boolean canBeAdded = false;
        try {
            canBeAdded = isCellEmpty(n);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return canBeAdded;
    }

    public boolean isCellExists(int n) {
        return n >= 0 && n < MEASUREMENT;
    }

    public boolean isCellEmpty(int n) throws IOException {
        if (! isCellExists(n)) {
            throw new IOException("Out of cells bounds");
        }

        return cells[n] == EMPTY_CELL;
    }


    //Следующий метод определяет остались ли еще на игровом поле свободные клетки.
    public boolean canMove() {
        boolean canMove = true;
        for (int i = 0; i < MEASUREMENT; i++) {
            if (cells[i] == EMPTY_CELL) {
                canMove = false;
                break;
            }
        }
        return canMove;
    }

    public void paintField() {
        System.out.println("     |     |     ");
        for (int i = 0; i < MEASUREMENT; i++) {
            if (i != 0) {
                if (i % 3 == 0) {
                    System.out.println();
                    System.out.println("_____|_____|_____");
                    System.out.println("     |     |     ");
                } else
                    System.out.print("|");
            }
            drawCells(i);
        }

            System.out.println();
            System.out.println("     |     |     ");

    }


    public void drawCells(int n) {
        String cell = cells[n];
        switch (cell) {
            case EMPTY_CELL:
                System.out.print("  " + " " + "  ");
                break;
            case CROSS_CELL:
                System.out.print("  " + "X" + "  ");
                break;
            case ZERO_CELL:
                System.out.print("  " + "O" + "  ");
        }
    }


    public boolean hasWinnerCombination(String cellType) {
        boolean vertical = false;
        // Проверка по горизонтали
        for (int i = 0; i <= 6; i += 3) {
            if (cells[i] == cellType && cells[i + 1] == cellType && cells[i + 2] == cellType) {
                vertical = true;
            }
        }
        // Проверка по вертикали если победитель пока не найден
        boolean horizontal = false;
        for (int i = 0; i < 3; i++){
            if (cells[i] == cellType && cells[i + 3] == cellType && cells[i + 6] == cellType) {
                horizontal = true;
            }
        }

        // Проверка главной диагонали если победитель пока не найден
        boolean diagonal = false;
            if (cells[0] == cellType && cells[4] == cellType && cells[8] == cellType){
                diagonal = true;
            }


        // Проверка побочной диагонали если победитель пока не найден
        boolean reverseDiagonal = false;
            if (cells[2] == cellType && cells[4] == cellType && cells[6] == cellType){

                reverseDiagonal = true;
            }

        boolean hasWinner = horizontal || vertical || diagonal | reverseDiagonal;
        return hasWinner;
    }

    /**
     * Check is computer won
     *
     * @return boolean
     */
    public boolean isComputerWin() {
        return hasWinnerCombination(compCellType);
    }

    /**
     * Check is user win
     *
     * @return boolean
     */
    public boolean isUserWin() {
        return hasWinnerCombination(humanCellType);
    }
}



