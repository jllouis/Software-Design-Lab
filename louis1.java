import java.lang.*;
import java.util.Scanner;

public class louis1
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in); // Scanner object to read from std input.
        System.out.print("Welcome! Enter your first name! "); // Prompt
        String name = keyboard.nextLine();  // input mechanism
        System.out.print("Select operation: 1 to Add\t2 to Subtract\t3 to Divide\t4 to Multiply: ");
        int choice = keyboard.nextInt();
        System.out.print("Enter first number: ");
        double num1 = keyboard.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = keyboard.nextDouble();

        switch (choice) // do operation selected by user
        {
            case 1:
                System.out.println(num1+"+"+num2+"="+(num1+num2));
                break;
            case 2:
                System.out.println(num1+"-"+num2+"="+(num1-num2));
                break;
            case 3:
                System.out.println(num1+"/"+num2+"="+(num1/num2));
                break;
            case 4:
                System.out.println(num1+"*"+num2+"="+(num1*num2));
                break;
        }

        //part two of assignment

        System.out.print("Enter a double variable so I can convert it to a string: ");
        double var = keyboard.nextDouble();
        String input = Double.toString(var); // conversion from double to string
        System.out.println("Your input in string is: " + "\""+input+"\"");
    }
}
