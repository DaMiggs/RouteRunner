import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Caravans extends Vehicles {

    Random random = new Random();
    Scanner scan = new Scanner(System.in);
    public static ArrayList<ArrayList<Integer>> CaravanLists = new ArrayList<>(3);
    public static ArrayList<Integer> Caravan1 = new ArrayList<>();
    public static ArrayList<Integer> Caravan2 = new ArrayList<>();
    public static ArrayList<Integer> Caravan3 = new ArrayList<>();
    static String[] carArray = new String[] {"null", "null", "Compact", "Truck", "null", "Midsize", "Truck with double trailer",
            "Truck with quad trailer", "null", "null", "SUV", "null", "SUV with double trailer", "null", "SUV with quad trailer" };
    public static int totlCrvnCnt;
    public static int crvnSaveCnt;
    public int capacitySize;


    public void addtoCaravan(int capacitySize) {
            System.out.println("1: Add to Caravan 1.\n2: Add to Caravan 2.\n3: Add to Caravan 3.\n4: Return to menu.");
            int addToChoice = scan.nextInt();
                try {
                    switch (addToChoice) {
                    case 1:
                        if (CaravanLists.get(0) == null) {
                            throw new CaravanLimitException("Create a caravan before adding a vehicle.");
                        } else if (Caravan1.size() == 10) {
                            throw new CaravanLimitException("Reached vehicle limit. Pick another caravan.");
                        } else {
                            Caravan1.add(capacitySize);
                            System.out.println(capacitySize);
                            System.out.println("Vehicle added! You now have " + Caravan1.size() + " vehicles in Caravan 1.");
                            CaravanLists.get(0);
                            Routes.getMatch1();
                            break;
                        }
                    case 2:
                        if (CaravanLists.get(1) == null) {
                            throw new CaravanLimitException("Create a caravan before adding a vehicle.");
                        } else if (Caravan2.size() == 10) {
                            throw new CaravanLimitException("Reached vehicle limit. Pick another caravan.");
                        } else {
                            Caravan2.add(capacitySize);
                            System.out.println(capacitySize);
                            System.out.println("Vehicle added! You now have " + Caravan2.size() + " vehicles in Caravan 2.");
                            CaravanLists.get(1);
                            Routes.getMatch2();
                            break;
                        }
                    case 3:
                        if (CaravanLists.get(2) == null) {
                            throw new CaravanLimitException("Create a caravan before adding a vehicle.");
                        } else if (Caravan3.size() == 10) {
                            throw new CaravanLimitException("Reached vehicle limit. Pick another caravan.");
                        } else {
                            Caravan3.add(capacitySize);
                            System.out.println(capacitySize);
                            System.out.println("Vehicle added! You now have " + Caravan3.size() + " vehicles in Caravan 3.");
                            CaravanLists.get(2);
                            Routes.getMatch3();
                            break;
                        }

                    case 4:
                        //return to menu
                        break;
                        default:
                            if (CaravanLists.get(2) == null) {
                                throw new CaravanLimitException("Create a caravan before adding a vehicle.");
                            } else if (Caravan3.size() == 10) {
                                throw new CaravanLimitException("Reached vehicle limit. Pick another caravan.");
                            }
                    }
                }
                catch(CaravanLimitException c){
                    System.err.println("Missing Caravan.\n\t\t" + c);
                }catch(Exception e){
                    System.err.println("You need to create a caravan first." + e);
            }

    }

    public void addCaravan() throws CaravanException {
        if (CaravanLists.size() >= 4) {
            throw new CaravanException("You already have " + CaravanLists.size() + " caravans.");
        } else {
            System.out.println("1: Create Caravan 1\n2: Create Caravan 2\n3: Create Caravan 3\n4: Return to menu");
            int addToChoice = scan.nextInt();
            switch (addToChoice) {
                case 1:
                    try {
                        if (CaravanLists.get(0) == Caravan1){
                            throw new CaravanException("Caravan 1 already exists");
                        } else {
                            CaravanLists.set(0, Caravan1);
                            totlCrvnCnt++;
                            System.out.println("Caravan created!\n");
                        }
                    }catch (Exception e){
                        System.err.println("Pick another caravan to create " + e);
                    }
                    break;
                case 2:
                    try {
                        if (CaravanLists.get(1) == Caravan2){
                            throw new CaravanException("Caravan 2 already exists");
                        } else {
                            CaravanLists.set(1, Caravan2);
                            totlCrvnCnt++;
                            System.out.println("Caravan created!\n");
                        }
                    }catch (Exception e){
                        System.err.println("Pick another caravan to create " + e);
                    }
                    break;
                case 3:
                    try {
                        if (CaravanLists.get(2) == Caravan3){
                            throw new CaravanException("Caravan 3 already exists");
                        } else {
                            CaravanLists.set(2, Caravan3);
                            totlCrvnCnt++;
                            System.out.println("Caravan created!\n");
                        }
                    }catch (Exception e){
                        System.err.println("Pick another caravan to create " + e);
                    }
                    break;
                case 4:
                    //return to menu
                    break;
            }
            //CaravanLists.add(new ArrayList<>());
            //System.out.println(CaravanLists);

        }
    }
        public class CaravanLimitException extends Exception {
        CaravanLimitException (String message) {
            super((message));
        }
        }
        public class CaravanException extends Exception {
            CaravanException (String message) {
                super(message);
            }
        }
        public void sortedCaravan() {
        }

    }


