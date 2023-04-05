import java.util.Scanner;

public class CinemaView {
    int row;
    int seats;
    char[][] cinemaRoom;

    Controller controller = new Controller();
    public CinemaView() {
      this.row = controller.row;
      this.seats = controller.colum;
        inicilizationCinemaView();
    }

    public void printMenu() {
        System.out.println("\n1. Show the seats");
        System.out.println("2. Buy a ticket");
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
                    takeSeats();
                   break;
            }
        }
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
    public void printAllCostSeats() {
        int cost = controller.getAllCostSeats();
        System.out.println("\nTicket All price: $" + cost);
    }

    public void printCostOnePlace() {
        int cost = controller.fillCalculatesCostCinemaPrint();
        System.out.println("\nTicket price: $" + cost);
    }

    public void takeSeats() {
        cinemaRoom[controller.rowSeats - 1][controller.columSeats - 1] = 'B';
    }
}
