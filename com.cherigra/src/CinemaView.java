import java.rmi.AlreadyBoundException;
import java.util.Scanner;

public class CinemaView {
    int row;
    int seats;
    char[][] cinemaRoom;
    int countTickets;

    Controller controller = new Controller();
    public CinemaView() {
      this.row = controller.row;
      this.seats = controller.colum;
        inicilizationCinemaView();
    }

    public void printMenu() {
        System.out.println("\n1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    public void menuCinema() {
        while (true) {
            printMenu();
            int chooseUser = controller.getChooseMenu();
            switch (chooseUser) {
                case 0:
                    return;
                case 1:
                    printCinemaRoom();
                   break;
                case 2:
                    printCostOnePlace();
                   break;
                case 3:
                    inputStatistics();
                    break;
            }
        }
    }

    public void inputStatistics() {
        System.out.printf("Number of purchased tickets: %d", countTickets);
        System.out.printf("\nPercentage: %.2f%c", (double)countTickets * 100 / (row * seats), '%');
        System.out.printf("\nCurrent income: $%d", controller.getProceedsCinema());
        System.out.printf("\nTotal income: $%d\n", controller.getAllCostSeats());
    }
    public void inicilizationCinemaView() {
        cinemaRoom = fillsCinemaHollSeats();
        menuCinema();
    }
        private void printCinemaRoom() {
        System.out.println("\nCinema:");
        System.out.print("  ");
        for (int i = 0; i < seats; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < row; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < cinemaRoom[i].length; j++) {
                System.out.print(cinemaRoom[i][j] + " ");
            }
            System.out.println();
        }
    }
        private char[][] fillsCinemaHollSeats() {
        String str = "S";
        char[][] cinemaRoom = new char[row][seats];
        for (int i = 0; i < cinemaRoom.length; i++) {
            for (int j = 0; j < cinemaRoom[i].length; j++) {
                cinemaRoom[i][j] += 'S';
            }
        }
        return cinemaRoom;
    }

    public void printCostOnePlace() {
        int cost = 0;
        try {
            int[] coordinates = controller.fillCalculatesCostCinemaPrint();
            cost = coordinates[2];
            takeSeats(coordinates[0] ,coordinates[1]);
            System.out.println("\nTicket price: $" + cost);
        } catch (AlreadyTakenSeatException e) {
            System.out.println("That ticket has already been purchased!");
            printCostOnePlace();
        }catch (NonExistingSeatException e) {
            System.out.println("Wrong input! ");
            System.out.println();
            printCostOnePlace();
        };
    }

    public void takeSeats(int rowSeats, int columSeats ) throws AlreadyTakenSeatException {

            if (cinemaRoom[rowSeats - 1][columSeats - 1] == 'B') {
                throw new AlreadyTakenSeatException();
            }
            cinemaRoom[rowSeats - 1][columSeats - 1] = 'B';
        countTickets+=1;

    }
}
