import java.util.Scanner;

public class CalculatorApp {

        public static int add(int a, int b) {
            return a + b;
        }
        public static int sub(int a, int b) {
            if(a>b){
              return a - b;
            }
            else{
                return b-a;
            }
            
        }
        public static int mul(int a, int b) {
            return a * b;
        }
        public static double div(int a, int b) {
            return (double) a / b;
        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 1st input:");
        int a = sc.nextInt();

        System.out.println("Enter 2nd input:");
        int b = sc.nextInt();

        while (true) {
            System.out.println("\nChoose an operation to perform:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(add(a, b));
                    break;
                case 2:
                    System.out.println(sub(a, b));
                    break;
                case 3:
                    System.out.println(mul(a, b));
                    break;
                case 4:
                    if (b != 0) {
                        System.out.println(div(a, b));
                    } else {
                        System.out.println("Cannot divide by zero!");
                    }
                    break;
                case 5:
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Invalid input.Enter a number between 1 and 5.");
            }
        }
    }
}
