package main.glava3.A;

public class Main {
    public static void main(String[] args) {

        Train[] trains = {
                new Train("Москва", 101, "14:30", 50, 20, 10, 5),
                new Train("Санкт-Петербург", 102, "15:45", 30, 15, 5, 2),
                new Train("Москва", 103, "18:00", 0, 20, 15, 10),
                new Train("Казань", 104, "12:15", 10, 10, 5, 0)
        };


        System.out.println("Поезда до Москвы:");
        printTrainsByDestination(trains, "Москва");


        System.out.println("\nПоезда до Москвы после 15:00:");
        printTrainsByDestinationAndTime(trains, "Москва", "15:00");


        System.out.println("\nПоезда до Москвы с общими местами:");
        printTrainsWithGeneralSeats(trains, "Москва");
    }

    public static void printTrainsByDestination(Train[] trains, String destination) {
        for (Train train : trains) {
            if (train.getDestination().equalsIgnoreCase(destination)) {
                System.out.println(train);
            }
        }
    }

    public static void printTrainsByDestinationAndTime(Train[] trains, String destination, String afterTime) {
        for (Train train : trains) {
            if (train.getDestination().equalsIgnoreCase(destination)
                    && train.getDepartureTime().compareTo(afterTime) > 0) {
                System.out.println(train);
            }
        }
    }


    public static void printTrainsWithGeneralSeats(Train[] trains, String destination) {
        for (Train train : trains) {
            if (train.getDestination().equalsIgnoreCase(destination) && train.getGeneralSeats() > 0) {
                System.out.println(train);
            }
        }
    }
}
