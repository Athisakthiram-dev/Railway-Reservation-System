import java.util.HashMap;
import java.util.Map;

    public class TicketCancelling extends TicketBooking {
        private static char preferenceTracker;
        private static int canceledSeatNumber;
        private static Map<Integer,Character> seatWithPrefernce=new HashMap<>();
        public static String cancelling(int id){
            for(Passengers p: confirmedList){
                if(p.getId()==id){
                    cancel(p);
                    return "Success";
                }
            }
            for(Passengers p: racQueue){
                if(p.getId()==id){
                    cancel(p);
                    return "Success";
                }
            }
            for(Passengers p: waitingListQueue){
                if(p.getId()==id){
                    cancel(p);
                    return "Success";
                }
            }
            return "Invalid Id";
        }

        private static  void cancel(Passengers p) {
            if(p.getTicketType()=="berth"){
                preferenceTracker=p.getSeatPreference();
                canceledSeatNumber=p.getSeatNumber();
                seatWithPrefernce.put(canceledSeatNumber,preferenceTracker);

                deleteFromAllLists(p);
                addRactoBerth(racQueue.poll());
                addWaitingtoRac(waitingListQueue.poll());

            }else if(p.getTicketType()=="RAC"){
                racQueue.remove(p);
                addWaitingtoRac(waitingListQueue.poll());
            }else{
                waitingListQueue.remove(p);
            }
        }

        private static void addWaitingtoRac(Passengers p) {
            if(p!=null){
                p.setTicketType("RAC");
                racQueue.add(p);
            }
        }

        private static void addRactoBerth(Passengers p) {
            if(p!=null){
                p.setSeatNumber(canceledSeatNumber);
                p.setTicketType("berth");
                p.setSeatPreference(preferenceTracker);

                if(preferenceTracker=='U'){
                    upperList.add(p);
                }else if(preferenceTracker=='M'){
                    middleList.add(p);
                }else{
                    lowerList.add(p);
                }
                confirmedList.add(p);
                seatWithPrefernce.remove(canceledSeatNumber);
                preferenceTracker='\0';
                canceledSeatNumber=0;
            }
        }

        private static void deleteFromAllLists(Passengers p) {
            confirmedList.remove(p);
            upperList.remove(p);
            middleList.remove(p);
            lowerList.remove(p);
        }
        public static Map<Integer,Character> getSeatNumberwithBerth(){
            return seatWithPrefernce;
        }
    }


