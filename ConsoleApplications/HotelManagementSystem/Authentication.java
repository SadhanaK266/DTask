import java.io.*;
import java.util.*;

public class Authentication {
    Scanner sc=new Scanner(System.in);
    private static final String FileName="user.txt";

    // Login - Existing user
    public static void login(Scanner sc) {
        System.out.println("--------Welcome to the login Page-------- ");
        try{
            File file = new File(FileName);
            if (!file.exists()) {
                System.out.println("No records found. Kindly register first.");
                return;
            }

            System.out.print("Enter username: ");
            String username = sc.nextLine();
            System.out.print("Enter password: ");
            String password = sc.nextLine();

            Scanner fileSc = new Scanner(file);
            boolean found = false;
            while(fileSc.hasNextLine()){
                String[] parts = fileSc.nextLine().split(",");
                if(parts.length == 3 && parts[0].equals(username) && parts[1].equals(password)) {
                    found = true;
                    System.out.println("Login successful!");
                    System.out.println("Welcome " + username + " (" + parts[2] + ")");
                    break;
                }
            }
            if(!found){//found==false
                System.out.println("Invalid username or password!");
            }

        }
        catch (IOException e){
            System.out.println(e+"Error while logging in.");
        }
    }


    // Register new user
    public static void register(Scanner sc) {
        System.out.println("-------Welcome to the Registration page-------");
        try {
            File file = new File(FileName);
            //Creates file if it doesn't exist
            file.createNewFile(); 

            System.out.print("Enter username: ");
            String username = sc.nextLine();
            if (userExists(username)){
                System.out.println("User already exists. Please login instead.");
                return;
            }
            System.out.print("Enter password: ");
            String password = sc.nextLine();
            System.out.print("Enter role (Admin/Customer): ");
            String role = sc.nextLine();

            // Save to file
            FileWriter fw = new FileWriter(FileName, true);//true ==append mode ; false==overwrites 
            fw.write(username + "," + password + "," + role + "\n");
            fw.close();

            System.out.println("Registration successful!");
        }
        catch (IOException e){
            System.out.println(e+" Error while registering user.");
        }
    }


    // Check if username already exists
    private static boolean userExists(String username) {
        try{
            File file = new File(FileName);
            if (!file.exists()){
                return false;
            }

            Scanner fileSc = new Scanner(file);
            while (fileSc.hasNextLine()) {
                String[] parts = fileSc.nextLine().split(",");
                if (parts.length >= 1 && parts[0].equals(username)) {
                    fileSc.close();
                    return true;
                }
            }

        }
        catch (IOException e){
            return false;
        }
        return false;
    }
}

