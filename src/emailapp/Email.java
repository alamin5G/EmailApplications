package emailapp;

import java.util.Scanner;

public class Email {

    Scanner input = new Scanner(System.in);
    private final String COMPANY_NAME =  "iubat.edu";
    private String fName;
    private String lName;
    private String dept;
    private String email;
    private String password;
    private final int emailCapacity = 500;
    private String alterEmail;

    public Email(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
        System.out.println("New Employee: " + this.fName + " " + this.lName );
    }

    //generate email
    private String generate_email(){
        return this.fName.toLowerCase() + "." + this.lName.toLowerCase() + "@" + this.dept.toLowerCase() + ""
    }

    //asking for department
    private String setDept(){
        System.out.println("Department codes: \n1 for Sales\n2 for Development\n3 for Accounts");

        boolean flag = false;

        do {
            System.out.println("Enter Department Code:");
            int choice = input.nextInt();
            switch (choice){
                case 1:
                    flag = true;
                    return "Sales";

                case 2:
                    flag = true;
                    return "Development";
                case 3:
                    flag = true;
                    return "Accounting";
                default:
                    System.out.println("Invalid choice, please choose it again");
            }
        }while (!true);

        return null;
    }
}
