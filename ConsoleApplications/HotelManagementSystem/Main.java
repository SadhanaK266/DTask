import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Authentication obj=new Authentication();
        System.out.println("Welcome to the Hotel Management System!...");
        
        boolean cont=true;
        while(cont){
            System.out.println("The Available Choices are\n1.Login\n2.Register\n3.Exit\nEnter your Choice : ");
            int ch=sc.nextInt();
            sc.nextLine();
            switch (ch) {
                case 1:
                    Authentication.login(sc);
                    break;
                case 2:
                    obj.register(sc);
                    break;
                case 3:
                    System.out.println("Thank you for visiting!...\nHave a Nice Day!...");
                    sc.close();
                    cont=false;
            }           
        }
        
    }
}