import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Caravans extends Vehicles {

    Random random = new Random();
    Scanner scan = new Scanner(System.in);
    public static ArrayList<ArrayList<String>> CaravanLists = new ArrayList<>();
    public static ArrayList<Integer> Caravan1 = new ArrayList<>();
    public static ArrayList<Integer> Caravan2 = new ArrayList<>();
    public static ArrayList<Integer> Caravan3 = new ArrayList<>();
    String[] carArray = new String[] {"null", "null", "Compact", "Truck", "null", "Midsize", "Truck with double trailer",
            "Truck with quad trailer", "null", "null", "SUV", "null", "SUV with double trailer", "null", "SUV with quad trailer" };
    public static int totlCrvnCnt;
    public static int crvnFailCnt;
    public int capacitySize;


    public void addCaravan(int capacitySize) throws CaravanException {
        if (CaravanLists.size() == 3)  {
            throw new CaravanException("You already have " + CaravanLists.size() + " caravans.");
        }
        else {
            System.out.println("Add to Caravan 1.\nAdd to Caravan 2.\nAdd to Caravan 3.\nCreate new caravan.");
            int addToChoice = scan.nextInt();
            switch (addToChoice) {
                case 1:
                    try {
                        Caravan1.add(capacitySize);
                        System.out.println(capacitySize);
                        System.out.println("Vehicle added! You now have " + Caravan1.size() + " vehicles in Caravan 1.");
                        System.out.println(Caravan1);
                        break;
                    }catch (Exception e) {
                        System.out.println("You need to create a caravan first");
                    }
                case 2:
                    Caravan2.add(capacitySize);
                    System.out.println("Vehicle added! You now have " + Caravan2.size() + " vehicles in Caravan 2.");
                    System.out.println(Caravan2);

                    break;
                case 3:
                    Caravan3.add(capacitySize);
                    System.out.println("Vehicle added! You now have " + Caravan3.size() + " vehicles in Caravan 3.");
                    System.out.println(Caravan3);
                    break;
                case 4:
                    //CaravanLists.add();
                    CaravanLists.add(new ArrayList<>());
                    totlCrvnCnt++;
                    System.out.println("Caravan created! You now have " + CaravanLists.size() + " caravans.");
                    break;
            }

        }
    }

        public void sortedCaravan() {
        }

        public class CaravanException extends Exception {
            CaravanException (String message) {
                super(message);
            }
        }
    }


