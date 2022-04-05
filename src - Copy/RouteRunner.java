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

public class RouteRunner {

    public static Scanner scan = new Scanner(System.in);
    static String name;

    public static void main(String[] args) {

        Vehicles vehicles = new Vehicles();
        Caravans caravans = new Caravans();
        boolean begin = false;
        int start = 0;

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
            while (begin) {
                System.out.println("1: See new vehicle.\n2: Add caravan.\n3: Send Caravan\n4: End Day\n5: Quit game.\n");
                int choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        vehicles.getVehicle();
                        break;
                    case 2:
                        try {
                            caravans.addCaravan();
                        } catch (Exception e) {
                            System.out.println("You've reached the caravan limit!");
                        }
                        break;
                    case 3:
                        System.out.println("Send Caravan.");
                        break;
                    case 4:
                        System.out.println("End day.");
                        break;
                    case 5:
                        endProgram();
                }
            }
    }



        /*System.out.println("\n"+ Animals.animalCount +"\n"+ Animals.dogCount +"\n"+ Animals.catCount +"\n" + Animals.horseCount);
        System.out.println("\n"+ Vehicles.compactCount +"\n"+Vehicles.midsizeCount+"\n"+Vehicles.truckCount+"\n"+
        Vehicles.suvCount+"\n"+Vehicles.trailer2Count+"\n"+Vehicles.getTrailer4Count);*/


    static void quitProgram() {
        System.out.println("Goodbye " + name + "!");
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
