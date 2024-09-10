import java.security.KeyStore;
import java.util.*;

    public class TicketBooking {

        private static int berthLimit=6/2;
        private static int racCount=1;
        private static int waitingListCount=1;
        private static int upperBerth=1;
        private static int lowerBerth=3;
        private static int middleBerth=2;

        static List<Passengers> confirmedList=new ArrayList<>();
        static List<Passengers> upperList=new ArrayList<>();
        static List<Passengers> middleList=new ArrayList<>();
        static List<Passengers> lowerList=new ArrayList<>();
        static Queue<Passengers> racQueue=new LinkedList<>();
        static Queue<Passengers> waitingListQueue=new LinkedList<>();


        public static void bookTicket(Passengers p){
            if(upperList.size()==berthLimit && middleList.size()==berthLimit && lowerList.size()==berthLimit ){
                if(updateRac(p)){
                    System.out.println("The ticket is update to RAC: "+ p.getId());
                }else if(updateWaitingList(p)){
                    System.out.println("The ticket is update to Waiting List: "+p.getId());
                }
            }else if(checkAvailability(p)){
                System.out.println("The ticket is update to berth and the ticket id is: "+p.getId());
                p.setTicketType("berth");
                confirmedList.add(p);
            }else{
                p.setId(p.getId()-1);
                System.out.println("The tickets are not available");
                availableList();
            }
        }

        private static void availableList() {
            System.out.println("Check out no of seats available");
            System.out.println("UpperBerth: "+ Math.abs(upperList.size()-upperBerth));
            System.out.println("MiddleBerth: "+Math.abs(middleList.size()-middleBerth));
            System.out.println("LowerBerth: "+Math.abs(lowerList.size()-lowerBerth));
        }

        private static boolean checkAvailability(Passengers p) {
            Map<Integer,Character> map=TicketCancelling.getSeatNumberwithBerth();
            if(p.getSeatPreference()=='U'){
                if(!map.isEmpty()){
                    getDetails(p,map);
                }else{
                    p.setSeatNumber(upperBerth);
                    upperBerth+=3;

                }
                upperList.add(p);
                return true;
            }
            if(p.getSeatPreference()=='M'){
                if(!map.isEmpty()){
                    getDetails(p,map);
                }else{
                    p.setSeatNumber(middleBerth);
                    middleBerth+=3;

                }

                middleList.add(p);
                return true;
            }
            if(p.getSeatPreference()=='L'){
                if(!map.isEmpty()){
                    getDetails(p,map);
                }else{
                    p.setSeatNumber(lowerBerth);
                    lowerBerth+=3;

                }
                lowerList.add(p);
                return true;
            }
            return false;
        }

        private static void getDetails(Passengers p, Map<Integer, Character> map) {
            int seatNumber=checkforPreference(map,p.getSeatPreference());
            p.setSeatNumber(seatNumber);
            map.remove(seatNumber);

        }

        private static int checkforPreference(Map<Integer, Character> map, char seatPreference) {
            int seatNumber=0;
            for(Map.Entry<Integer,Character> e:map.entrySet()){
                if(seatPreference==(char) e.getValue()){
                    seatNumber=(int) e.getKey();
                    break;
                }
            }
            return seatNumber;
        }

        private static boolean updateWaitingList(Passengers p) {
            if(waitingListQueue.size() < waitingListCount){
                p.setTicketType("Waiting List");
                waitingListQueue.add(p);
                return true;
            }
            return false;
        }

        private static boolean updateRac(Passengers p) {
            if(racQueue.size()<racCount){
                p.setTicketType("RAC");
                racQueue.add(p);
                return true;
            }
            return false;
        }
        public static void displayConfirmed(){
            System.out.println("--------------------------------------");
            for(Passengers p: confirmedList){
                System.out.println(p.toString());
                System.out.println("--------------------------------------");

            }
        }
        public static void displayRac(){
            System.out.println("--------------------------------------");
            for(Passengers p: racQueue){
                System.out.println(p.toString());
                System.out.println("--------------------------------------");
            }
        }
        public static void displayWaitingList(){
            System.out.println("--------------------------------------");
            for(Passengers p: waitingListQueue){
                System.out.println(p.toString());
                System.out.println("--------------------------------------");
            }
        }
    }


