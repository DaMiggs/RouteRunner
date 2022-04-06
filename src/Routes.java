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
    public static ArrayList<Float> routesList = new ArrayList<>();
    static int d;
    static int dayCount = 1;
    private static int thisCaravan = scan.nextInt();
    static ArrayList<Boolean> routeComes = new ArrayList<>();
    static int routeComesSize = routeComes.size();
    public static boolean route1Used=false;
    public static boolean route2Used=false;
    public static boolean route3Used=false;
    public static int failedCount;
    public static void getRoute(int r) {
        System.out.print("Pass Rate: ");
        System.out.printf("%.2f", routesList.get(r));
        System.out.print(" %\n");
    }
    //failChance must be 0.3 at most and 0.1 at the least and successChance must be 0.7 at least and 0.9 at the most
    public static void routeRate() {
        if (d != dayCount) {
            d++;
            for (int i = 1; i < 3; i++) {
                passRate = rando.nextFloat();
                //float failRate = (1 - passRate);
                if (passRate < 0.7 || passRate > 0.9) {
                    while (passRate < 0.7 || passRate > 0.9) {
                        passRate = rando.nextFloat();//declaring new pass rate
                        //failRate = (1 - passRate);//declaring new fail rate
                    }
                    routesList.set(i, passRate * 100);
                    //printing new pass and fail rates
                    //System.out.println("\nFail Rate: "+passRate);
                } else {//keeping first pass and fail rates
                    routesList.set(i, passRate * 100);
                    //System.out.println("\nFail Rate: "+passRate);
                }
            }
        }
        if (routesList.get(0)==0f && !route1Used) {
            routesList.set(0,20f);
        } else if (route1Used){
            routesList.set(0,20f);
            System.out.println("route was used");
        }
    }

    public void attemptRate(int routeChoice, int thisCaravan) {
        //change to new method to get from array.
        int thisRoute = routeChoice-1;
        float attempt = rando.nextFloat();
        getRoute(thisRoute);
        //System.out.println("\nAttempt chance is "+(attempt*100)+"\n");
        if (attempt <= routesList.get(thisRoute)) {
            System.out.println("Route passed\n");
            crvnSaveCnt++;
            if (thisCaravan == 1) {
                clearSetter1(thisCaravan);
            } else if (thisCaravan == 2) {
                clearSetter2(thisCaravan);
            }else {
                clearSetter3(thisCaravan);
            }

        }
        else {
            System.out.println("Route failed\n");
            failedCount++;
        }
    }

    private void clearSetter1(int thisRoute) {
        routesList.set(thisRoute, 0F);
        Caravan1.clear();
    }
    private void clearSetter2(int thisRoute) {
        routesList.set(thisRoute, 0F);
        Caravan2.clear();
    }
    private void clearSetter3(int thisRoute) {
        routesList.set(thisRoute, 0F);
        Caravan3.clear();
    }

    public void sendIt() throws RouteException {
        System.out.println(routesList+"\n"+routesList.size());
        System.out.println("Select which caravan to send.");//make the next 3 lines print (CaravanLists.get(n)) so you can make an error for not having created a new caravan.
        System.out.println("1.) Caravan 1: ");
        getMatch1();
        System.out.println("2.) Caravan 2: ");
        getMatch2();
        System.out.println("3.) Caravan 3: ");
        getMatch3();
        System.out.println("4.) Return to menu.");
        routeRate();
        System.out.println(routesList+"\n"+routesList.size());
        thisCaravan=scan.nextInt();
        switch (thisCaravan) {
            case 1:
                System.out.println("Caravan 1:\n");
                System.out.println("1.) Route 1: ");
                getRoute(0);
                System.out.println("\n2.) Route 2: ");
                getRoute(1);
                System.out.println("\n3.) Route 3: ");
                getRoute(2);
                System.out.println("\n4.) Return To Menu.");
                System.out.println(routesList+"\n"+routesList.size());
                int newChoice = scan.nextInt();
                pickRoute(newChoice, thisCaravan);
                break;
            case 2:
                System.out.println("Caravan 2:\n");
                System.out.println("1.) Route 1: ");
                getRoute(0);
                System.out.println("\n2.) Route 2: ");
                getRoute(1);
                System.out.println("\n3.) Route 3: ");
                getRoute(2);
                System.out.println("\n4.) Return To Menu.");
                System.out.println(routesList+"\n"+routesList.size());
                newChoice = scan.nextInt();
                pickRoute(newChoice, thisCaravan);
                break;
            case 3:
                System.out.println("Caravan 3:\n");
                System.out.println("1.) Route 1: ");
                getRoute(0);
                System.out.println("\n2.) Route 2: ");
                getRoute(1);
                System.out.println("\n3.) Route 3: ");
                getRoute(2);
                System.out.println("\n4.) Return To Menu.");
                System.out.println(routesList+"\n"+routesList.size());
                newChoice = scan.nextInt();
                pickRoute(newChoice, thisCaravan);
                break;
            case 4:
                break;
        }
    }
    public static void getMatch1(/*int mList*/){
        for (int i = 0; i < Caravan1.size(); i++) {
            System.out.print(carArray[Caravan1.get(i)]+"\t\t");
        }
        System.out.println("\n");
    }
    public static void getMatch2(/*int mList*/){
        for (int i = 0; i < Caravan2.size(); i++) {
            System.out.print(carArray[Caravan2.get(i)]+"\t\t");
        }
        System.out.println("\n");
    }
    public static void getMatch3(/*int mList*/){
        for (int i = 0; i < Caravan3.size(); i++) {
            System.out.print(carArray[Caravan3.get(i)]+"\t\t");
        }
        System.out.println("\n");
    }
    private void pickRoute(int newChoice, int thisCaravan) {
        try {
            if (route1Used || route2Used || route3Used) {
                throw new RouteException("Can't reuse this route today.");
            } else {
            switch (newChoice) {
                case 1:
                    if (route1Used == false) {
                        //caravanarrayn sorted and matched against route classlist
                        System.out.println("Route 1:\n");
                        route1Used = true;
                        routes.attemptRate(newChoice, thisCaravan);
                    }
                    else {
                        throw new RouteException("Can't reuse this route. Pick another route.");
                }
                    break;
                case 2:
                    if (route2Used == false) {
                        System.out.println("Route 2:\n");
                        route2Used = true;
                        routes.attemptRate(newChoice, thisCaravan);
                    } else {
                        throw new RouteException("Can't reuse this route. Pick another route.");
                    }
                    break;
                case 3:
                    if (route3Used == false) {
                        System.out.println("Route 3:\n");
                        route3Used = true;
                        routes.attemptRate(newChoice, thisCaravan);
                    }else {
                        throw new RouteException("Can't reuse this route. Pick another route.");
                    }
                    break;
                case 4:
                    break;
            }
        }
        }catch (RouteException e) {
            System.err.println("You cant reuse a route the same day.");
        }
    }
    public class RouteException extends Exception{
        RouteException(String message){
            super(message);
        }
    }
}

