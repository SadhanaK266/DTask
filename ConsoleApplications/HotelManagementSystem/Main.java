import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Authentication obj=new Authentication();
        System.out.println("Welcome to the Hotel Management System!...");
        
        boolean cont=true;
        while(cont){
            System.out.println("Enter your Choice\n1.Login\n2.Register\n3.Exit");
            int ch=sc.nextInt();
            sc.nextLine();
            if(ch==1){
                Authentication.login(sc);
            }
            else if(ch==2){
                Authentication.register(sc);
            }
            else if(ch==3){
                System.out.println("Thank you for visiting!...\nHave a Nice Day!...");
                sc.close();
                cont=false;
            }
            else{
                System.out.println("Invalid choice");

            }
        }
    }
}