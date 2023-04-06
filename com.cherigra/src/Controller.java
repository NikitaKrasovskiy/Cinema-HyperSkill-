import java.util.Scanner;

class AlreadyTakenSeatException extends Exception {}

class NonExistingSeatException extends Exception {}
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

    public int[] fillCalculatesCostCinemaPrint() throws NonExistingSeatException {
        System.out.println("\nEnter a row number:");
        rowSeats = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        columSeats = scanner.nextInt();
        if (row < 1 || rowSeats > row || colum < 1 || columSeats >colum) {
            throw new NonExistingSeatException();
        }
        int cost = cinema.calculateCostPlaceCinema(rowSeats, columSeats); // исправить этот кастылль
        return new int[]{rowSeats,columSeats, cost}; // и этот
    }
    public int getAllCostSeats() {
        return cinema.calculatesAllCost();
    }

    public int getChooseMenu() {
        return scanner.nextInt();
    }

//    public int getCountTickets() {
//        return cinema.getCountTickets();
//    }
//
//    public double getInterestTickets() {
//        return cinema.getInterestTickets();
//    }

    public int getProceedsCinema() {
        return cinema.getProceeds();
    }

    public int getCostCinemaTicket() {
        return cinema.getCost();
    }
}
