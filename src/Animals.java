import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Animals {
    Random random = new Random();
    public AnimalsInfo animalsInfo = new AnimalsInfo();
    private ArrayList<String> animalList = new ArrayList<>(Arrays.asList("Dog", "Cat"));
    private String[] lastTime = new String[]{"Morning", "Afternoon", "Evening", "Night", "Previous day"};
    public static int animalCount = 0;
    public static int dogCount = 0;
    public static int catCount = 0;
    public static int horseCount = 0;

    public void getHorses() {
        animalCount++;
        horseCount++;
        System.out.println("Horse");
        System.out.println(animalsInfo);
        boolean hasHay = random.nextBoolean();
        System.out.println("Has hay?: " + hasHay+"\n");

    }

    public void getAnimal() {
        animalCount++;
        int a = new Random().nextInt(2);
        System.out.println(animalList.get(a));
        System.out.println(animalsInfo);
        if (animalList.get(a) == "Dog") {
            dogCount++;
            boolean hasLeash = random.nextBoolean();
            System.out.println("Has leash?: " + hasLeash);
            int l = new Random().nextInt(4);
            System.out.println("Last potty break was: " + lastTime[l]+"\n");
        }
        else if (animalList.get(a) == "Cat") {
            catCount++;
            boolean hasLitter = random.nextBoolean();
            if (hasLitter) {
                int l = new Random().nextInt(4);
                System.out.println("Has litter?: " + hasLitter);
                System.out.println("Last litter box cleaning: " + lastTime[l]+"\n");
            } else {
                System.out.println("Has litter?: " + hasLitter+"\n");
            }
        }

    }

    static class AnimalsInfo {
        //Gives all animals a method to have general info
        private String[] names = new String[]{"Adam", "Alex", "Aaron", "Ben", "Carl", "Dan", "David", "Edward", "Fred", "Frank",
                "George", "Hal", "Hank", "Ike", "John", "Jack", "Joe", "Larry", "Monte", "Matthew", "Mark", "Nathan", "Otto",
                "Paul", "Peter", "Roger", "Roger", "Steve", "Thomas", "Tim", "Ty", "Victor", "Walter", "Karen", "Eloise", "Ruben",
                "Madeline", "Patrick", "Erin", "Evans", "Christopher", "Bonilla", "Cora", "Moses", "Laurie", "Norton", "Diane",
                "Jessica", "Shanna", "Ibarra", "Lorrie", "Marcy", "Coleman", "Marcelino", "Hart", "Autumn", "Bush", "Marcelo", "Greene", "Lesa", "Reed"};

        Random random = new Random();
        private int iD = random.nextInt(100000);
        private int weight = random.nextInt(115) + 10;

        public String randomName() {
            int x = random.nextInt(61);
            return names[x];
        }

        public String toString() {
            return ("Name: " + randomName() + "\t\tOwner: " + randomName() + "\t\tID: " + iD + "\t\tWeight: " + weight + " (lbs)");
        }
    }
}
