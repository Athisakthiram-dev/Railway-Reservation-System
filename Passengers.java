
    public class Passengers {
        private static int idProvider;
        private int id;
        private String name;
        private int age;
        private char gender;
        private char seatPreference;
        private String ticketType;
        private int seatNumber;

        public Passengers(String name,int age, char seatPreference){
            this.id=++idProvider;
            this.name=name;
            this.age=age;
            this.seatPreference=seatPreference;
        }
        public int getId(){
            return id;
        }
        public void setId(int id){
            Passengers.idProvider=id;
        }
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name=name;
        }
        public int getAge(){
            return age;
        }
        public void setAge(int age){
            this.age=age;
        }
        public char getSeatPreference(){
            return seatPreference;
        }
        public void setSeatPreference(char seatPreference){
            this.seatPreference=seatPreference;
        }
        public String getTicketType(){
            return ticketType;
        }
        public void setTicketType(String ticketType){
            this.ticketType=ticketType;
        }
        public int getSeatNumber(){
            return seatNumber;
        }
        public void setSeatNumber(int seatNumber){
            this.seatNumber=seatNumber;
        }
        @Override
        public String toString(){
            return "Passenger Ticket id : "+id+"\nPassenger name : " + name
                    + "\nPassenger age : " + age +"\nPassenger Seat no : "+seatNumber+
                    "\nPassenger preference : " + seatPreference;
        }

    }


