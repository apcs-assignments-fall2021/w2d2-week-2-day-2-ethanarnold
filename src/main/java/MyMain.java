import java.util.Scanner;

public class MyMain {
    // Write a method that asks the user to input a double between 0.0 and 1000000.0
    // Your method should keep asking them until they type in a valid value
    // The method returns the final double they type in

    // scan.nextDouble() might be useful here

    public static double inputDouble() {
        Scanner scan = new Scanner(System.in);
        double money;
        System.out.println("Please input a number between 0.0 and 1000000.0.");
        money = scan.nextDouble();
        while(money > 1000000.0 || money < 0.0) {
            System.out.println("Invalid input. Please input a number between 0.0 and 1000000.0.");
            money = scan.nextDouble();
        }
        return money;
    }

    double money = inputDouble();

    public static int numQuarters(double money) {
        double remainder = money;
        int res = 0;
        while(remainder > 0.25) {
            remainder = remainder - 0.25;
            res++;
        }
        return res;
    }

    // Takes a double money as input and returns the number of dimes that we
    // can return in change
    // You should use a while loop!
    public static int numDimes(double money) {
        return (int) ((money-numQuarters(money)*0.25)/0.1);
    }

    // Takes a double money as input and returns the number of nickels that we
    // can return in change
    // You should use a while loop!
    public static int numNickels(double money) {
        double AfterQuarters = money-numQuarters(money)*0.25;
        double AfterDimes = AfterQuarters-numDimes(money)*0.1;
        return (int) (AfterDimes/0.05);
    }

    // Takes a double money as input and returns the number of pennies that we
    // can return in change
    // You should use a while loop!
    public static int numPennies(double money) {
        double AfterQuarters = money-numQuarters(money)*0.25;
        double AfterDimes = AfterQuarters-numDimes(money)*0.1;
        double AfterNickels = AfterDimes-numNickels(money)*0.05;
        return (int) (AfterNickels/0.01);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // You should test inputDouble yourself!
        double d = inputDouble();

        System.out.println("You will recieve " + numQuarters(d) + " quarters, " + numDimes(d) + " dimes, " + numNickels(d) + " nickels, and " + numPennies(d) + " pennies.");
        scan.close();
    }
}