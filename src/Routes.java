import java.util.Random;

public class Routes {

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
