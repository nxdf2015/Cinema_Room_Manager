package cinema;


import java.util.Arrays;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {

        Scanner in  = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = in.nextInt();
        System.out.println("Enter the number of seats in each rows:");
        int seats = in.nextInt();

        App app = new App(rows, seats);

        boolean exit = false;
        while(!exit){
            System.lineSeparator();
            System.out.println("1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit\n");
            int action = in.nextInt();
            System.lineSeparator();
            switch (action){
                case 0:
                    exit = true;
                    break;
                case 1:
                    app.print();
                    break;
                case 2:
                    int rowNumber,colNumber;
                    do {
                        System.out.println("Enter a row number:");
                          rowNumber = in.nextInt();
                        System.out.println("Enter a seat number in that row:");
                          colNumber = in.nextInt();

                      if (!app.isValid(rowNumber,colNumber)){
                          System.out.println("Wrong input!");
                      } else if (!app.isAvailable(rowNumber,colNumber)){
                          System.out.println("That ticket has already been purchased!");
                      } else {
                          break;
                      }
                    } while(true);
                    app.buy(rowNumber, colNumber);
                    break;
                case 3:
                    app.stats();
                    break;
                default:
                    System.out.println("Wrong input!");
                    break;
            }
        }

    }
}