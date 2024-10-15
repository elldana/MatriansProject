import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int minOfKmValue = 1;
        int maxOfKmValue = 7;
        int numbersOfAttempts = 3;
        int count = 0;

        System.out.println("Hi, martians! Enter 3 numbers (kilometers) :");

        boolean oneMoreAttempts = true;
        while (oneMoreAttempts) {
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

            while (count < 5) {
                int[] martiansAttempt = new int[numbersOfAttempts];
                for (int i = 0; i < numbersOfAttempts; i++) {
                    martiansAttempt[i] = sc.nextInt();
                }

                if ((martiansAttempt[0] == rightLocations[0]) && (martiansAttempt[1] == rightLocations[1]) && (martiansAttempt[2] == rightLocations[2])) {
                    System.out.println("Congratulations! You found all boxes.");
                    System.exit(0);
                }
                else if ((martiansAttempt[0] == rightLocations[0]) && (martiansAttempt[1] == rightLocations[1])) {
                    System.out.println("You found two boxes! Try again to find another box.");
                }
                else if ((martiansAttempt[1] == rightLocations[1]) && (martiansAttempt[2] == rightLocations[2])) {
                    System.out.println("You found two boxes! Try again to find another box.");
                }
                else if ((martiansAttempt[0] == rightLocations[0]) && (martiansAttempt[2] == rightLocations[2])) {
                    System.out.println("You found two boxes! Try again to find another box.");
                }
                else if (martiansAttempt[0] == rightLocations[0]) {
                    System.out.println("You found one box! Try again to find another boxes.");
                }
                else if (martiansAttempt[1] == rightLocations[1]) {
                    System.out.println("You found one box! Try again to find another boxes.");
                }
                else if (martiansAttempt[2] == rightLocations[2]) {
                    System.out.println("You found one box! Try again to find another boxes.");
                }
                else {
                    System.out.println("Try again.");
                }
                count++;
            }
            if (count == 5) {
                System.out.println(" ");
                System.out.println("Unfortunately, you have wasted all 5 attempts. " +
                        "\n" + "All three boxes changed their location. Enter 3 numbers again: ");
            }
            count = 0;
            }
        }
    }