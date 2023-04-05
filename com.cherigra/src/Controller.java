import java.util.Scanner;

public class Controller {
    private static final Scanner scanner = new Scanner(System.in);
    int row;
    int colum;
    int rowSeats;
    int columSeats;
    Cinema cinema = fillCinemaRoom();
    public Controller() {
    }

    public Cinema fillCinemaRoom() {
        System.out.println("Enter the number of rows:");
        row = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        colum = scanner.nextInt();

        return new Cinema(row, colum);
    }

    public int fillCalculatesCostCinemaPrint() {
        System.out.println("\nEnter a row number:");
        rowSeats = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        columSeats = scanner.nextInt();
        return cinema.calculateCostPlaceCinema(rowSeats, columSeats);
    }
    public int getAllCostSeats() {
        return cinema.calculatesAllCost();
    }
}
