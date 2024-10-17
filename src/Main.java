import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int minOfKmValue = 1;
        int maxOfKmValue = 7;
        int numbersOfAttempts = 3;
        int countForBoxes = 0;
        int countForAttempts = 0;

        System.out.println("Hi, martians! Enter 3 numbers (kilometers) :");

        boolean oneMoreAttempt = true;
        while (oneMoreAttempt) {

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

            while (countForAttempts < 5) {

                int[] martiansAttempt = new int[numbersOfAttempts];

                for (int i = 0; i < martiansAttempt.length; i++) {
                    martiansAttempt[i] = sc.nextInt();
                }

                for (int i = 0; i < martiansAttempt.length; i++) {
                    for (int j = 0; j < martiansAttempt.length; j++) {
                        if (martiansAttempt[i] == rightLocations[j]) {
                            countForBoxes++;
                        }
                    }
                }
                if (countForBoxes == numbersOfAttempts) {
                    System.out.println("Congratulations! You have found all three boxes!");
                    System.exit(0);
                }
                else if (countForBoxes > 0) {
                    System.out.println("You have found " + countForBoxes + " " + boxOrBoxes(countForBoxes) + "! Try again to find another. ");
                    countForBoxes = 0;
                }
                else {
                    System.out.println("Try again.");
                }
                countForAttempts++;
            }
            if (countForAttempts == 5) {
                System.out.println(" ");
                System.out.println("Unfortunately, you have wasted all 5 attempts. " +
                        "\n" + "All three boxes changed their location. Enter 3 numbers again: ");
            }
            countForAttempts = 0;
        }
    }
    static String boxOrBoxes (int countForBoxes) {
        String box = (countForBoxes == 1) ? "box" : "boxes";
        return box;
    }
}
