package cinema;

import java.util.Arrays;

public class App {
    private String[][] cinema;
    private int rows;
    private int seats;
    private int seatBuy;
    private int currentIncome;

    public App(int rows, int seats) {
        this.rows = rows;
        this.seats = seats;
        this.cinema = new String[rows][seats];
        this.seatBuy = 0;
        this.currentIncome = 0;
        initialize();
    }
    public boolean isAvailable(int row, int seat){
        return cinema[row - 1][seat - 1].equals("S");
    }

    private int  totalSeats(){
        return seats * rows;
    }

    private double percentageBuy(){
        return 100 *(double)seatBuy /  totalSeats() ;
    }

    private int totalIncome(){
        int total = 10 * rows * seats;
        int half = rows / 2;
        if (rows * seats >= 60){
            total = seats * ( 10 * half + (rows - half) * 8);
        }
        return total;

    }


    public void buy(int row, int seat){

            seatBuy++;

            int half = rows / 2;
            cinema[row - 1][seat - 1] = "B";

            int price = 10;
            if (seats * rows >= 60 && row > half) {
                price = 8;
            }
            currentIncome += price;
            System.lineSeparator();
            System.out.println("Ticket price: $" + price);
            System.lineSeparator();

    }

    public boolean isValid(int seat,int row){
        return isValidSeat(seat) && isValidRow(row);
    }
    private boolean isValidSeat(int seat) {
        return seat > 0 && seat <= seats;
    }

    private boolean isValidRow(int row) {
        return row >0 && row <= rows;
    }

    public void stats(){
        System.out.printf("Number of purchased tickets: %d\n",seatBuy);
        System.out.printf("Percentage: %.2f%%\n",percentageBuy());
        System.out.printf("Current income: $%d\n",currentIncome);
        System.out.printf("Total income $%d\n",totalIncome());
        System.lineSeparator();
    }

    public void print(){
        System.out.println("Cinema:");
        String s = " ";
        for(int i = 1; i<= seats; i++){
            s += " " + i;
        }
        System.out.println(s);

        for(int i = 0; i < rows; i++){
            System.out.println((i + 1) + " " + String.join(" ",cinema[i]));
        }
    }

    private void initialize(){
        for(String[] row : cinema){
            Arrays.fill(row,"S");
        }
    }
}
