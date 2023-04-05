public class Cinema {
    int row;
    int seats;
    int sumSeats;

    public Cinema(int row, int seats) {
        this.row = row;
        this.seats = seats;
        sumSeats = row * seats;
    }
        public int calculatesAllCost() {
        if (sumSeats > 60) {
            int middle = row / 2;
            return middle * seats * 10 + (row - middle) * seats * 8;
        }
        return sumSeats * 10;
    }
    public int calculateCostPlaceCinema(int seatRow, int seatNumber) {
     int costPlace;
     int middle = row / 2;
        if (sumSeats <= 60) {
            costPlace = 10;
        } else {
            int frontHalfOfRows = row / 2;
            if (seatRow <= frontHalfOfRows) {
                costPlace = 10;
            } else {
                costPlace = 8;
            }
        }
        return costPlace;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getSumSeats() {
        return sumSeats;
    }

    public void setSumSeats(int sumSeats) {
        this.sumSeats = sumSeats;
    }
}
