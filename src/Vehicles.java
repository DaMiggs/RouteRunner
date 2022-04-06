import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Vehicles extends Animals{

    private static ArrayList<String> vehicleList = new ArrayList<>(Arrays.asList("Compact", "Mid-size", "Truck", "SUV"));
    private static int[] trailerSizeList = new int[]{2,4};
    private boolean hasTrailer;
    public static int trailer2Count=0;
    public static int getTrailer4Count=0;
    public static int compactCount=0;
    public static int midsizeCount=0;
    public static int truckCount=0;
    public static int suvCount=0;
    public static int vehicleCount=0;
    public int  t;
    public int trailerSize;
    public int capacitySize;


    public void getVehicle() {
        String vehicle = vehicleList.get(new Random().nextInt(vehicleList.size()));
        System.out.println(vehicle+"\n");
        if (vehicle == "Compact") {
            this.capacitySize = 2;
            compactCount++;
            for (int i=0; i < 2;i++){
                getAnimal();
            }
        }
        if (vehicle == "Mid-size") {
            this.capacitySize = 5;
            midsizeCount++;
            for (int i=0; i < 5;i++){
                getAnimal();
            }
        }
        if (vehicle == "Truck") {
            truckCount++;
            hasTrailer = random.nextBoolean();
            if (hasTrailer) {
                t = random.nextInt(2);
                trailerSize = trailerSizeList[t];
                System.out.println("Trailer size: " + trailerSize+"\n");
                if (trailerSize == 2) {
                    this.capacitySize = 6;
                    trailer2Count++;
                    for (int i = 0; i < 2; i++) {
                        getHorses();
                    }
                }
                else {
                    this.capacitySize = 7;
                    getTrailer4Count++;
                    for (int i = 0; i < 4; i++) {
                        getHorses();
                    }
                }
                for (int i=0; i < 3;i++){
                    getAnimal();
                }
            }
            else {
                this.capacitySize = 3;
                for (int i=0; i < 3;i++){
                    getAnimal();
                }
            }
        }
        if (vehicle == "SUV") {
            suvCount++;
            hasTrailer = random.nextBoolean();
            if (hasTrailer) {
                t = random.nextInt(2);
                trailerSize = trailerSizeList[t];
                System.out.println("Trailer size: " + trailerSize+"\n");
                if (trailerSize == 2) {
                    this.capacitySize = 12;
                    trailer2Count++;
                    for (int i = 0; i < 2; i++) {
                        getHorses();
                    }
                }
                else {
                    getTrailer4Count++;
                    this.capacitySize = 14;
                    for (int i = 0; i < 4; i++) {
                        getHorses();
                    }
                }
                for (int i=0; i < 10;i++){
                    getAnimal();
                }
            }
            else {
                this.capacitySize = 10;
                for (int i=0; i < 10;i++){
                    getAnimal();
                }
            }
        }
        vehicleCount++;
    }
    public void vehicleSorting() {
    }
}