package main.glava3.A;

public class Train {
    private String destination;
    private int trainNumber;
    private String departureTime; // Время в формате HH:mm
    private int generalSeats;
    private int coupeSeats;
    private int reservedSeats;
    private int luxSeats;


    public Train(String destination, int trainNumber, String departureTime,
                 int generalSeats, int coupeSeats, int reservedSeats, int luxSeats) {
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.departureTime = departureTime;
        this.generalSeats = generalSeats;
        this.coupeSeats = coupeSeats;
        this.reservedSeats = reservedSeats;
        this.luxSeats = luxSeats;
    }


    public Train() {
        this("Unknown", 0, "00:00", 0, 0, 0, 0);
    }

    // Getters и Setters
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public int getGeneralSeats() {
        return generalSeats;
    }

    public void setGeneralSeats(int generalSeats) {
        this.generalSeats = generalSeats;
    }


    @Override
    public String toString() {
        return "Поезд {" +
                "Пункт назначения='" + destination + '\'' +
                ", Номер поезда=" + trainNumber +
                ", Время отправления='" + departureTime + '\'' +
                ", Общие места=" + generalSeats +
                ", Купе места=" + coupeSeats +
                ", Плацкарт места=" + reservedSeats +
                ", Люкс места=" + luxSeats +
                '}';
    }

}
