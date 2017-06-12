import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class World {
	private List<Event> events = new ArrayList<Event>();
	public World(){}
	
	public void run(){
		generateEvents(); //generates 10 random events
		Location l = displayMenu(); //asks the user for his location
		printFiveCloserEvents(orderEventsByDistance(l)); //orders the events by distance to the user location and prints the five closer
	}
	
	public void printFiveCloserEvents(List<Event> events){
		List<Event> closerEvents = new ArrayList<Event>();
		for(int i=0; i<5; i++){
			closerEvents.add(events.get(i));
		}
		System.out.println("The five closer events to your location are:");
		printEvents(closerEvents);
	}
	
	public List<Event> orderEventsByDistance(Location l){
		List<Event> closeEvents = new ArrayList<Event>();
		Event[] eventsArray = this.events.toArray(new Event[this.events.size()]);
		
		for(int i=0;i<(eventsArray.length-1);i++){
            for(int j=i+1;j<eventsArray.length;j++){
                if(getDistance(l, eventsArray[i].getLocation())>getDistance(l, eventsArray[j].getLocation())){
                    Event auxEvent=eventsArray[i];
                    eventsArray[i]=eventsArray[j];
                    eventsArray[j]=auxEvent;
                }
            }
        }
		for(int i=0; i<eventsArray.length; i++){
			closeEvents.add(eventsArray[i]);
		}
		return closeEvents;
	}
	
	public int getDistance (Location locA, Location locB){
		return Math.abs(locA.getX()-locB.getX()) + Math.abs(locA.getY()-locB.getY());
	}
	
 	public Location displayMenu(){
		int coordX, coordY;
		Scanner read = new Scanner(System.in);
		boolean wrongInput = false;
		do{
		System.out.println("Please introduce your location: \nCoordenate x:");
		coordX=read.nextInt();
		System.out.println("Coordenate y:");
		coordY=read.nextInt();
		if(coordX < -10 || coordX > 10 || coordY < -10 || coordY > 10){
			wrongInput = true;
			System.out.println("You have introduced an invalid location.");
		}
		}while(wrongInput);
		read.close();
		return new Location (coordX, coordY);
	}
	
	public void printEvents(List<Event> eventList){
		for(int i=0;i<eventList.size();i++){
			Event e = eventList.get(i);
			System.out.print("Event "+e.getId()+" - Location: "+e.getLocation().getX()+","+e.getLocation().getY()+". Tickets prices: ");
			printTicketPrices(e.getTicketsList());
			System.out.println("");
		}
	}
	public void printTicketPrices(List<Ticket> tickets){
		for(int i=0; i<tickets.size(); i++){
			System.out.print(tickets.get(i).getPrice() +"€ - ");
		}
	}
	public void generateEvents(){
		for(int i = 0; i<10; i++){
			Location location = getRandomLocation();
			Event e = new Event(i, location);
			e.generateTickets();
			this.events.add(e);
		}
		System.out.println("Random data generated: ");
		printEvents(this.events);
	}
	public Location getRandomLocation(){
		int randomX, randomY;
		do{
			randomX = -10 + (int) (Math.random() * ((10 - (-10)) + 1));
			randomY = -10 + (int) (Math.random() * ((10 - (-10)) + 1));
		}while(!locationAvailable(randomX, randomY));
		Location l = new Location(randomX, randomY);
		return l;
	}	
	public boolean locationAvailable(int x, int y){
		for(int i=0; i<this.events.size(); i++){
			if(this.events.get(i).getLocation().getX()==x && this.events.get(i).getLocation().getY()==y){
				return false;
			}
		}
		return true;
	}
}
