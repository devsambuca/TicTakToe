/**
 * @author Fominykh Vladimir
 */
public class Field {

   private String [] field = {"0", "0", "0", "0", "0", "0", "0", "0", "0"};





    public void paintField(){
        System.out.println("     |     |     ");
        for (int i = 0; i < field.length; i++) {
            if (i != 0){
                if (i % 3 == 0) {
                    System.out.println();
                    System.out.println("_____|_____|_____");
                    System.out.println("     |     |     ");
                }
                else
                    System.out.print("|");
            }

            if (field[i].equals("0")) System.out.print("  " + i + "  ");
            if (field[i].equals("1")) System.out.print(" X ");
            if (field[i].equals("2")) System.out.print(" O ");
        }
        System.out.println();
        System.out.println("     |     |     ");
    }


    }

