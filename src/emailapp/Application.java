package emailapp;

import java.util.Scanner;

public class Application {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome, to create your office email, please provide the accurate information: ");
        System.out.print("Enter your first Name: ");
        String fName = input.next();
        System.out.print("Enter your last name: ");
        String lName = input.next();

        Email user1 = new Email(fName, lName);
        System.out.println("Congrats, your email has been created!");
        int choice;
        do {
            System.out.println("\nPlease, enter your option: \n1. Get Info\n2. Change Password\n3. Change email storage capacity\n4. Change Alternative Email\n5. Logout");
            choice = input.nextInt();
            switch (choice){
                case 1:
                    user1.getUserInfo();
                    break;
                case 2:
                    user1.setPassword();
                    break;
                case 3:
                    user1.setEmailCapacity();
                    break;
                case 4:
                    user1.setAlterEmail();
                    break;
                case 5:
                    System.out.println("Thank you! See you soon.");
                    break;
                default:
                    System.out.println("You Entered invalid option.");
            }
        }while (choice!=5);

    }
}
