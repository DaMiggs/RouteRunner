import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
//import java.util.Arrays;

public class Routes extends Caravans {

    public static Random rando = new Random(); //initializing the "rando" variable with random class
    static Scanner scan = new Scanner(System.in);
    public static float passRate = rando.nextFloat();
    //public float failRate = (1-passRate);
    public static Routes routes = new Routes();
    //static float[] routearray = new float[3];
    private static ArrayList<Float> routesList = new ArrayList<>();
    //private static int d = 0;
    static int dayCount;

    static ArrayList<Boolean> routeComes = new ArrayList<>();
    static int routeComesSize = routeComes.size();
    static boolean route1Used=false;
    boolean route2Used=false;
    boolean route3Used=false;

    public static void getRoute(int r) {
        System.out.print("Pass Rate: ");
        System.out.printf("%.2f", routesList.get(r));
        System.out.print(" %\n");
    }
    //failChance must be 0.3 at most and 0.1 at the least and successChance must be 0.7 at least and 0.9 at the most
    public static void routeRate() {
    if (dayCount == 0 && !route1Used){
            routesList.add(0,20f);
        } else if (route1Used){
            routesList.add(0,20f);
            System.out.println("route was used");
        }
        while (routesList.size() < 3){
            for (int i = 1; i < 2; i++) {
                float passRate = rando.nextFloat();
                //float failRate = (1 - passRate);
                if (passRate < 0.7 || passRate > 0.9) {
                    while (passRate < 0.7 || passRate > 0.9) {
                        passRate = rando.nextFloat();//declaring new pass rate
                        //failRate = (1 - passRate);//declaring new fail rate
                    }
                    routesList.add(passRate*100);
                    //printing new pass and fail rates
                    //System.out.println("\nFail Rate: "+failRate);
                } else {//keeping first pass and fail rates
                    routesList.add(passRate*100);
                    //System.out.println("\nFail Rate: "+failRate);
                }
            }
        }


    }

    public void attemptRate(int routeChoice) {
        //change to new method to get from array.
        int thisroute = routeChoice-1;
        float attempt = rando.nextFloat();
        System.out.println("Route pass rate is ");
        System.out.printf("%.2f", routesList.get(routeChoice));
        System.out.print(" %");
        //System.out.println("\nAttempt chance is "+(attempt*100)+"\n");

        if (attempt <= routesList.get(thisroute)) {
            System.out.println("\nRoute passed\n");
            routesList.add(0F);

        }
        else {
            crvnFailCnt++;
            System.out.println("\nRoute failed\n");
        }
    }

    public static void sendIt() {
        //System.out.println(routesList+"\n"+routesList.size());
        System.out.println("Select which caravan to send.");//make the next 3 lines print (CaravanLists.get(n)) so you can make an error for not having created a new caravan.
        System.out.println("1.) Caravan 1: "+Caravan1);
        System.out.println("2.) Caravan 2: "+Caravan2);
        System.out.println("3.) Caravan 3: "+Caravan3);
        System.out.println("4.) Return to menu.");
        routeRate();
        //System.out.println(routesList+"\n"+routesList.size());
        switch (scan.nextInt()) {
            case 1:
                System.out.println("Caravan 1:\n");
                System.out.println("1.) Route 1: \nPass Rate: ");
                getRoute(0);
                System.out.println("\n2.) Route 2: ");
                getRoute(1);
                System.out.println("\n3.) Route 3: ");
                getRoute(2);
                System.out.println("\n4.) Return To Menu.");
                //System.out.println(routesList+"\n"+routesList.size());
                int newChoice = scan.nextInt();
                switch (newChoice) {
                    case 1:
                        //caravanarrayn sorted and matched against route classlist
                        System.out.println("Route 1:\n");

                        routes.attemptRate(newChoice);
                        break;
                    case 2:

                        System.out.println("Route 2:\n");
                        routes.attemptRate(newChoice);
                        break;
                    case 3:

                        System.out.println("Route 3:\n");
                        routes.attemptRate(newChoice);
                        break;
                    case 4:
                        break;
                }
                break;
            case 2:
                System.out.println("Caravan 2:\n");

                System.out.println("Route 1: \nPass Rate: 20.00 %");
                System.out.println("Route 2: ");
                routeRate();
                System.out.println("Route 3: ");
                routeRate();
                System.out.println("Return To Menu.");
                switch (RouteRunner.scan.nextInt()) {
                    case 1:
                        //caravanarrayn sorted and matched against route classlist
                    case 2:
                    case 3:
                    case 4:
                        break;
                }
                break;
            case 3:
                System.out.println("Caravan 3:\n");

                System.out.println("Route 1: \nPass Rate: 20.00 %");
                System.out.println("Route 2: ");
                routeRate();
                System.out.println("Route 3: ");
                routeRate();
                System.out.println("Return To Menu. ");
                switch (RouteRunner.scan.nextInt()) {
                    case 1:
                        //caravanarrayn sorted and matched against route classlist
                    case 2:
                    case 3:
                    case 4:
                        break;
                }
                break;
            case 4:
                break;
        }
    }
}

