import java.util.Scanner;

public class RouteRunner {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Animals animals  = new Animals();
        Vehicles vehicles = new Vehicles();

        System.out.println("Welcome to Route Runner!\nWhat is your name?");
        String name = scan.nextLine();
        System.out.println("Hello "+name+"! The first vehicle just pulled up.\n\nVehicle:\n");


        System.out.println("\n"+ Animals.animalCount +"\n"+ Animals.dogCount +"\n"+ Animals.catCount +"\n"+ Animals.horseCount);
        System.out.println("\n"+ Vehicles.compactCount +"\n"+Vehicles.midsizeCount+"\n"+Vehicles.truckCount+"\n"+Vehicles.suvCount+"\n"+Vehicles.trailer2Count+"\n"+Vehicles.getTrailer4Count);

    }
}
