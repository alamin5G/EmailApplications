package emailapp;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class Email {

    Scanner input = new Scanner(System.in);
    private static final String COMPANY_NAME =  "iubat.edu";
    private String fName;
    private String lName;
    private String dept;
    private String email;
    private String password;
    private int emailCapacity = 500;
    private String alterEmail;


    public Email(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
        System.out.println("New Employee: " + this.fName + " " + this.lName );
        this.dept = setDept();
        this.email = generate_email();
        this.password = generate_password(10);
        setAlterEmail();

    }

    //generate email
    private String generate_email(){
        return this.fName.toLowerCase() + "." + this.lName.toLowerCase() + "@" + this.dept.toLowerCase() + "."+ COMPANY_NAME;
    }

    //asking for department
    private String setDept(){
        System.out.println("Department codes: \n1 for Sales\n2 for Development\n3 for Accounts");

        boolean flag = true;

        do {
            System.out.println("Enter Department Code:");
            int choice = input.nextInt();
            switch (choice){
                case 1:
                    flag = false;
                    return "Sales";
                case 2:
                    flag = false;
                    return "Development";
                case 3:
                    flag = false;
                    return "Accounting";
                default:
                    System.out.println("Invalid choice, please choose it again");
            }
        }while (flag);

        return null;
    }

    //generate random password
    private String generate_password(int length){
        Random random = new Random();
        String capitalCharacter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallCharacter = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "';!@#$%^&*()/.,?";
        String valueOfPassword = capitalCharacter + smallCharacter + numbers + symbols;
        StringBuilder password = new StringBuilder();
        for(int i = 0; i< length; i++){
            password.append(valueOfPassword.charAt(random.nextInt(valueOfPassword.length())));
        }
        return password.toString();
    }


    //Changing password for user;
    public void setPassword(){
        boolean flag = false;
        do {
            System.out.println("Do ou want to change your password? (y/n): ");
            char choice = input.next().charAt(0);
            if(choice == 'y' || choice == 'Y'){
                System.out.println("Enter current Password: ");
                String tempPassword = input.next();
                if(tempPassword.equals(this.password)) {
                    System.out.println("Enter new Password: ");
                    this.password = input.next();
                    System.out.println("Successfully password changed.");
                    flag = true;
                }else{
                    System.out.println("You entered an wrong password!");
                }
            } else if (choice=='n' || choice == 'N') {
                flag = true;
                System.out.println("We have cancelled your password changing request!");

            }else{
                System.out.println("You have chosen wrong character.. chose right one.");
            }

        } while (!flag);
    }

    //email storage capacity

    public void setEmailCapacity(){
        System.out.println("Your current capacity is: " + this.emailCapacity+ "MB");
        System.out.println("Enter your new capacity: ");
         this.emailCapacity = input.nextInt();
        System.out.println("Your Email Storage updated to: " + this.emailCapacity + "MB");
    }

    // alternative email
    public void setAlterEmail(){
        System.out.println("Enter your alternative email to future uses");
        this.alterEmail = input.next();
        System.out.println("Alternative email is set successfully.");
    }

    //user info

    public void getUserInfo(){
        System.out.println("New user:" + this.fName + " " + this.lName);
        System.out.println("Department: " + this.dept);
        System.out.println("New Email: " + this.email);
        System.out.println("Password: " + this.password);
        System.out.println("Email Storage: " + this.emailCapacity + "MB.");
        System.out.println("Alternative Email: " + this.alterEmail);
    }


    //Store user info

    public void storeFile(){
        try {
            FileWriter fileWriter = new FileWriter("C:\\Users\\alami\\Desktop\\userInfo.txt");
            fileWriter.write("First Name: " + this.fName);
            fileWriter.append("\nLastName: " + this.lName);
            fileWriter.append("\nEmail: " + this.email);
            fileWriter.append("\nPassword: " + this.password);
            fileWriter.append("\nCapacity: " + this.emailCapacity);
            fileWriter.append("\nAlter Eamil: " + this.alterEmail + "MB");
            fileWriter.close();
            System.out.println("Data Stored successfully.");
        }catch (Exception e){
            System.out.println(e);
        }
    }


    //read the information
    public void readFile(){
        try {
            FileReader fileReader = new FileReader("C:\\Users\\alami\\Desktop\\userInfo.txt");
            int i;
            while ((i=fileReader.read()) != -1){
                System.out.print((char) i);
            }
            fileReader.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
