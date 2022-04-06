import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Caravans extends Vehicles {

    Scanner scan = new Scanner(System.in);
    public ArrayList<ArrayList<String>> CaravanLists = new ArrayList<>();
    private ArrayList<Integer> Caravan1 = new ArrayList<>();
    private ArrayList<Integer> Caravan2 = new ArrayList<>();
    private ArrayList<Integer> Caravan3 = new ArrayList<>();
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
                    Caravan1.add(capacitySize);
                    System.out.println(capacitySize);
                    System.out.println("Caravan added! You now have " + Caravan1.size() + " vehicles in Caravan 1.");
                    System.out.println(Caravan1);
                    break;
                case 2:
                    Caravan2.add(capacitySize);
                    System.out.println("Caravan added! You now have " + Caravan2.size() + " vehicles in Caravan 2.");
                    System.out.println(Caravan2);

                    break;
                case 3:
                    Caravan3.add(capacitySize);
                    System.out.println("Caravan added! You now have " + Caravan3.size() + " vehicles in Caravan 3.");
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

    public void sendIt() {
        System.out.println("1.) Send Caravan 1.");
        System.out.println("2.) Send Caravan 2.");
        System.out.println("3.) Send Caravan 3.");
        System.out.println("4.) Return to menu.");
        switch (RouteRunner.scan.nextInt()) {
            case 1:
                //caravanarrayn sorted and matched against route classlist
                System.out.println(Caravan1.size());
                System.out.println(Caravan1);
            case 2:
            case 3:
            case 4:
                break;

        }
    }

    public void sortedCaravan() {
    }

    static class Routes {

            Random rando = new Random(); //initializing the "rando" variable with random class
            private float passRate = rando.nextFloat();
            private float failRate = (1-passRate);

            //failChance must be 0.3 at most and 0.1 at the least and successChance must be 0.7 at least and 0.9 at the most
        public void routeRate() {
            if (passRate < 0.7 || passRate > 0.9) {
                while (passRate < 0.7 || passRate > 0.9) {
                    passRate = rando.nextFloat();//declaring new pass rate
                    failRate = (1-passRate);//declaring new fail rate
                }
                //printing new pass and fail rates
                System.out.println("\n Pass Rate: "+passRate);
                System.out.println("\nFail Rate: "+failRate);
            }
            else {//keeping first pass and fail rates
                System.out.println("\n Pass Rate: "+passRate);
                System.out.println("\nFail Rate: "+failRate);
            }
        }

        public void attemptRate() {
            float attempt = rando.nextFloat();
            System.out.println("\nAttempt chance is "+attempt);
            if (attempt <= passRate) {
                System.out.println("\nRoute passed");
            }
            else {
                System.out.println("\nRoute failed");
            }
        }

        }
        public class CaravanException extends Exception {
            CaravanException (String message) {
                super(message);
            }
        }
    }


