import java.io.*;
import java.util.*;
public class UserFunctionality{

    private  static final String FileName="user.txt";
    //------------------------Admin Module-------------------------
    public static void admin(Scanner sc,String username){
        System.out.println("--------WELCOME TO THE ADMIN MODULE----------");
        boolean cont=true;
        while(cont){
            System.out.print("Your options are :\n1.Add food\n2.Remove food\n3.View Hotel Menu\n4.Exit\nEnter your choice : ");
            int ch=sc.nextInt();
            sc.nextLine();
            
            switch(ch){
                case 1:
                    System.out.println("-------Add Food Module-------");
                    System.out.print("Enter the name of the food : ");
                    String FNameAdd=sc.nextLine();
                    System.out.print("Enter the "+FNameAdd+"'s quantity : ");
                    int FQuantityAdd=sc.nextInt();
                    addFood(username, FNameAdd, FQuantityAdd);
                    break;
                case 2:
                    System.out.print("------Remove Food Module------");
                    System.out.print("Enter the name of the food : ");
                    String FNameRem=sc.nextLine();
                    System.out.print("Enter the "+FNameRem+"'s quantity to be removed : ");
                    int FQuantityRem=sc.nextInt();
                    removeFood(username,FNameRem,FQuantityRem);
                    break;
                case 3:
                    System.out.println("-----View Hotel Menu module------");
                    viewHotelMenu(username);
                    break;
                case 4:
                    cont=false;
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
    //add Food
    public static void addFood(String username,String FoodName,int foodQuantity){
        try {
            String hotelFile=username+"_menu.txt";
            FileWriter fw = new FileWriter(hotelFile, true);
            fw.write(FoodName + "," + foodQuantity + "\n");
            fw.close();
            System.out.println(FoodName + " added successfully!");
        } 
        catch (IOException e) {
            System.out.println(e.getMessage()+" Error occurred while adding food ");
        }
    }
    //remove food
    public static void removeFood(String username,String FoodName,int foodQuantity){
        try {
            String hotelFile=username+"_menu.txt";
            File file = new File(hotelFile);
            if (!file.exists()) {
                System.out.println("No menu found for this hotel.");
                return;
            }
            
            System.out.println(FoodName + " removed successfully!");
        } 
        catch (Exception e){
            System.out.println(e.getMessage()+" Error occurred while removing food ");
        }
    }
    //View menu of the hotel
    private static void viewHotelMenu(String HName) {
        String hotelFile = HName + "_menu.txt";
        File file = new File(hotelFile);
        if (!file.exists()) {
            System.out.println("No menu found for this hotel.");
            return;
        }

        try {
            Scanner sc = new Scanner(file);
            System.out.println("\nMenu for " + HName );
            int i = 1;
            while (sc.hasNextLine()) {
                System.out.println(i++ + ". " + sc.nextLine());
            }
            sc.close();
        } catch (IOException e) {
            System.out.println("Error reading menu: " + e.getMessage());
        }
    }




    //----------------------CUstomer Module--------------------------
    public static void customer(Scanner sc){
        System.out.println("--------WELCOME TO THE CUSTOMER MODULE-------");
        boolean cont=true;
        while(cont){
            System.out.print("Your options are\n1.View Available Hotels\n2.List of food items Available in a Hotel\n3.Exit");
            int ch=sc.nextInt();
            sc.nextLine();
            switch(ch){
                case 1:
                    System.out.println("Here you have the available hotels ");
                    viewHotels();
                    break;
                case 2:
                    System.out.print("Enter the hotel name : ");
                    String HotelName=sc.nextLine();
                    System.out.println("List of Food Items Available ");
                    viewHotelMenu(HotelName);//same as the admin module
                    break;
                case 3:
                    cont=false;
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
    //view Hotel
    public static void viewHotels(){
        try {
            File file=new File(FileName);
            if(!file.exists()){
                System.out.println("NO record found");
                return;
            }
            Scanner fileScan=new Scanner(file);
            System.out.println("Available Hotels are : ");
            int i=1;
            while(fileScan.hasNextLine()){
                String[] parts=fileScan.nextLine().split(",");
                if(parts.length>=6 && parts[2].equalsIgnoreCase("Admin")){
                    String Hotelname=parts[3];
                    System.out.println(i++ +Hotelname+" ("+parts[0]+")");//Hotel name And it's owner name
                }
            }
            fileScan.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage()+" occured");
        }
    }

}

