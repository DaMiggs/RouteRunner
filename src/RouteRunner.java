//********************************************************************************
// Name: Miguelangel Tamargo
// FIU email: mtama028@fiu.edu
// PantherID: 5866999
// CLASS: COP 3337 – 2022
// ASSIGNMENT # 1
// DATE: 3/4/2022
//
// I hereby swear and affirm that this work is solely my own, and not the work
// or the derivative of the work of someone else.
//********************************************************************************
import java.util.InputMismatchException;
import java.util.Scanner;

public class RouteRunner extends Routes {


    public static void promptEnterKey(){
        System.out.println("Press \"ENTER\" to continue...");
        sc.nextLine();
    }
    public static Scanner scan = new Scanner(System.in);
    static Scanner sc = new Scanner(System.in);
    static String name;
    public static int capacitySize;
    public static Routes routes = new Routes();
    public static void main(String[] args) {
        promptEnterKey();
        CaravanLists.add(null);
        CaravanLists.add(null);
        CaravanLists.add(null);
        Vehicles vehicles = new Vehicles();
        Caravans caravans = new Caravans();

        boolean begin = false;
        int start;


        System.out.println("Welcome to Route Runner!\nWhat is your name?");
        name = scan.nextLine();
        System.out.println("\nHello " + name + "! Are you ready to begin?");

        while (!begin) {
            while (true) {
                System.out.println("1.Start 	2.Quit");
                try {
                    start = scan.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.err.println("Please enter a '1' or '2':\n" + e);
                    scan.next();
                }
            }
            switch (start) {
                case 1 -> begin = true;
                case 2 -> endProgram();
            }
        }

        System.out.println("Hey " + name + "! The first new vehicle just pulled up.\nWhat do you want to do with it?\n");
        //routesList.add(0,0f);
        vehicles.getVehicle();//easier way to deal with any nulls being entered into array of caravans at the start
        capacitySize = vehicles.capacitySize;//used to store vehicle
        while (begin) {
            System.out.println("1: See new vehicle.\n2: Add to caravan.\n3: Create new Caravan\n4: Send Caravan\n5: End Day\n6: Quit game.\n");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    vehicles.getVehicle();
                    capacitySize = vehicles.capacitySize;
                    break;
                case 2:
                    try {
                        caravans.addtoCaravan(capacitySize);
                    } catch (Exception e) {
                        System.err.println("There was a problem adding a vehicle: " + e);
                    }
                    break;
                case 3:
                    try {
                        caravans.addCaravan();
                    } catch (Exception e) {
                        System.err.println("You've reached the caravan limit! \n\t\t\t\t"+e);
                    }
                    break;
                case 4:
                    try {
                        if (routesList.size()==0){
                            System.out.println("we add");
                            routesList.add(0f);
                            routesList.add(0f);
                            routesList.add(0f);
                            routes.sendIt();
                        }else {
                            System.out.println("we dont add");
                            routes.sendIt();
                        }
                    }catch (Exception e) {
                        System.out.println("You already used that route today."+e);
                    }
                    break;
                case 5:
                    System.out.println("End day.");
                    newDay();
                    break;
                case 6:
                    endProgram();
            }
        }
    }
    static void newDay() {
        dayCount++;
        routes.routesList.clear();
    }


    static void quitProgram() {
        System.out.println("Your Stats:\nVolunteer Name: "+name+"\nTotal Days: "+dayCount);
        System.out.println("\nTotal Animals:"+ Animals.animalCount +"\nTotal Dogs: "+ Animals.dogCount +"\nTotal Cats: "+
                Animals.catCount +"\nTotal Horses: " + Animals.horseCount+"\nTotal Saved Animals: " /*+ Vehicles.savedCount*/);
        System.out.println("\nTotal Compact: "+ Vehicles.compactCount +"\nTotal Midsize: "+Vehicles.midsizeCount+
                "\nTotal Trucks: "+Vehicles.truckCount+"\nTotal SUV: "+ Vehicles.suvCount+"\nTotal Double Trailer: "+
                Vehicles.trailer2Count+"\nTotal Quad Trailers: "+Vehicles.getTrailer4Count);
        System.out.println("\nTotal Caravans: "+ Caravans.totlCrvnCnt + "\nTotal Saved Caravans: "+ Caravans.crvnSaveCnt
                + "\nPercent Saved: " + (crvnSaveCnt/totlCrvnCnt)*100+ "Percent Failed: " + (1-(crvnSaveCnt/totlCrvnCnt))*100 );

        System.out.println("\nGoodbye " + name + "!");
        System.exit(0);
    }

    static void endProgram() {
        System.out.println("Would you like to quit?");
        System.out.println("1:Yes	2:No");
        int quitProgram = scan.nextInt();
        if (quitProgram == 1) {
            quitProgram();
        }
    }
}