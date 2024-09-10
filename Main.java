import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean loop=true;
        while(loop){
            System.out.println("\n Choose any one \n 1.Book ticket \n 2.Cancel ticket \n 3.Display RAC list \n 4.Display Confirmed \n 5.Display WaitingList \n 6.Exit");
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            switch(n){
                case 1:
                    System.out.println("Enter your name:");
                    String name=sc.next();
                    System.out.println("Enter the age:");
                    int age=sc.nextInt();
                    System.out.println("Enter your berth:");
                    char preference=sc.next().charAt(0);
                    if(preference=='U' || preference=='M' || preference=='U'){
                        TicketBooking.bookTicket(new Passengers(name,age,preference));
                    }else{
                        System.out.println("Invalid Berth");
                    }
                    break;
                case 2:
                    System.out.println("Enter your ticket id:");
                    int id=sc.nextInt();
                    System.out.println(TicketCancelling.cancelling( id));
                    break;

                case 3:
                    TicketBooking.displayRac();
                    break;

                case 4:
                    TicketBooking.displayConfirmed();
                    break;
                case 5:
                    TicketBooking.displayWaitingList();
                    break;
                case 6:
                    System.out.println("/exit");
                    sc.close();
                    System.out.println("Thank You!!!");
                    loop=false;
                    break;

            }
        }
    }
}