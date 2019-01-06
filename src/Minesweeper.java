import java.util.Random;
import java.util.Scanner;

public class Minesweeper {

  public static void main(String[] args) {

    int mine_a = 0;
    int mine_b = 0;
    while (mine_a == mine_b) {
      mine_a = new Random().nextInt(15);
      mine_b = new Random().nextInt(15);
    }
    String[] ija = getij(mine_a).split("");
    String[] ijb = getij(mine_b).split("");
    String[][] gameboard = new String[4][4];
    String[][] displayboard = new String[4][4];
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        displayboard[i][j] = ".";
      }
    }
    for (int i = 0; i < 4; i++) {
      System.out.println("\n");
      for (int j = 0; j < 4; j++) {
        if ((i == Integer.parseInt(ija[0]) && j == Integer.parseInt(ija[1]))
            || (i == Integer.parseInt(ijb[0]) && j == Integer.parseInt(ijb[1]))) {
          System.out.print(".");
          gameboard[i][j] = "*";
        } else {
          System.out.print(".");
          gameboard[i][j] = ".";
        }
      }
    }
    int over = 0;
    int move = 0;
    while (over == 0) {

      Scanner in = new Scanner(System.in);
      System.out.println("\n\n Enter the square you choose: ");
      move++;
      int square = in.nextInt();
      String[] user_ip = getij(square - 1).split("");
      if (gameboard[Integer.parseInt(user_ip[0])][Integer.parseInt(user_ip[1])].equals("*")) {
        displayboard[Integer.parseInt(user_ip[0])][Integer.parseInt(user_ip[1])] = "*";
        System.out.println("Game Over");
        for (int i = 0; i < 4; i++) {
          System.out.print("\n");
          for (int j = 0; j < 4; j++) {
            System.out.print(displayboard[i][j]);
          }
        }
        over = 1;
      } else {

        int count = 0;

        if ((Integer.parseInt(user_ip[0]) - 1) > -1 && (Integer.parseInt(user_ip[0])) - 1 < 4
            && (Integer.parseInt(user_ip[1])) - 1 > -1 && Integer.parseInt(user_ip[1]) - 1 < 4) {
          if (gameboard[Integer.parseInt(user_ip[0]) - 1][Integer.parseInt(user_ip[1]) - 1].equals("*")) {
            count++;
          }

        }
        if ((Integer.parseInt(user_ip[0]) - 1) > -1 && (Integer.parseInt(user_ip[0])) - 1 < 4
            && (Integer.parseInt(user_ip[1])) > -1 && Integer.parseInt(user_ip[1]) < 4) {
          if (gameboard[Integer.parseInt(user_ip[0]) - 1][Integer.parseInt(user_ip[1])].equals("*")) {
            count++;
          }
        }
        if ((Integer.parseInt(user_ip[0]) - 1) > -1 && (Integer.parseInt(user_ip[0])) - 1 < 4
            && (Integer.parseInt(user_ip[1])) + 1 > -1 && Integer.parseInt(user_ip[1]) + 1 < 4) {
          if (gameboard[Integer.parseInt(user_ip[0]) - 1][Integer.parseInt(user_ip[1]) + 1].equals("*")) {
            count++;
          }
        }

        if ((Integer.parseInt(user_ip[0])) > -1 && (Integer.parseInt(user_ip[0])) < 4
            && (Integer.parseInt(user_ip[1])) - 1 > -1 && Integer.parseInt(user_ip[1]) - 1 < 4) {
          if (gameboard[Integer.parseInt(user_ip[0])][Integer.parseInt(user_ip[1]) - 1].equals("*")) {
            count++;
          }
        }

        if ((Integer.parseInt(user_ip[0])) > -1 && (Integer.parseInt(user_ip[0])) < 4
            && (Integer.parseInt(user_ip[1])) + 1 > -1 && Integer.parseInt(user_ip[1]) + 1 < 4) {
          if (gameboard[Integer.parseInt(user_ip[0])][Integer.parseInt(user_ip[1]) + 1].equals("*")) {
            count++;
          }
        }

        if ((Integer.parseInt(user_ip[0]) + 1) > -1 && (Integer.parseInt(user_ip[0])) + 1 < 4
            && (Integer.parseInt(user_ip[1])) - 1 > -1 && Integer.parseInt(user_ip[1]) - 1 < 4) {

          if (gameboard[Integer.parseInt(user_ip[0]) + 1][Integer.parseInt(user_ip[1]) - 1].equals("*")) {
            count++;
          }
        }

        if ((Integer.parseInt(user_ip[0]) + 1) > -1 && (Integer.parseInt(user_ip[0])) + 1 < 4
            && (Integer.parseInt(user_ip[1])) > -1 && Integer.parseInt(user_ip[1]) < 4) {
          if (gameboard[Integer.parseInt(user_ip[0]) + 1][Integer.parseInt(user_ip[1])].equals("*")) {
            count++;
          }
        }
        if ((Integer.parseInt(user_ip[0]) + 1) > -1 && (Integer.parseInt(user_ip[0])) + 1 < 4
            && (Integer.parseInt(user_ip[1])) + 1 > -1 && Integer.parseInt(user_ip[1]) + 1 < 4) {
          if (gameboard[Integer.parseInt(user_ip[0]) + 1][Integer.parseInt(user_ip[1]) + 1].equals("*")) {
            count++;
          }
        }

        displayboard[Integer.parseInt(user_ip[0])][Integer.parseInt(user_ip[1])] = Integer.toString(count);
        for (int i = 0; i < 4; i++) {
          System.out.print("\n");
          for (int j = 0; j < 4; j++) {
            System.out.print(displayboard[i][j]);
          }
        }
      }
      if (move == 14) {
        over = 1;
        System.out.println("\n\nCongrats!!! You Won");
      }
    }

  }

  private static void subsquare(int parseInt, int parseInt2) {
    // TODO Auto-generated method stub

  }

  private static void generatehint(int i) {
    // TODO Auto-generated method stub

  }

  private static String getij(int mine_a) {
    // TODO Auto-generated method stub
    int x = mine_a;
    String map[] = { "00", "01", "02", "03", "10", "11", "12", "13", "20", "21", "22", "23", "30", "31", "32", "33" };
    return map[x];

  }

}
