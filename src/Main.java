import java.util.Random;
public class Main {
    public static void main(String[] args) {

        int minOfKmValue = 1;
        int maxOfKmValue = 7;

        System.out.println("Hi, martians! Enter 3 numbers (kilometers) :");

        int[] rightLocations = new int[maxOfKmValue];

        for (int i = 0; i < rightLocations.length; i++) {
            rightLocations[i] = minOfKmValue + i;
        }
        Random random = new Random();
        for (int i = 0; i < rightLocations.length; i++) {
            int location = random.nextInt(rightLocations.length);

            int temp = rightLocations[i];
            rightLocations[i] = rightLocations[location];
            rightLocations[location] = temp;
        }
    }
}