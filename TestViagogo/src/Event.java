import java.util.ArrayList;
import java.util.List;

public class Event {
	private int id;
	private Location location;
	private List<Ticket> ticketsList = new ArrayList<Ticket>();
	public Event(int id, Location location){
		this.id=id;
		this.location = location;
	}
	
	public void generateTickets(){//generates 10 ticket with i as id and a random price between 50€ and 100€
		for(int i=0; i<5; i++){
			this.ticketsList.add(new Ticket(i, roundTwoDecimals((Math.random() * 50) + 50)));
		}
	}
	
	public double roundTwoDecimals(double d) {
		d = Math.round(d * 100);
		d = d/100;
		return d;
	}
	
	public void setId(int id){
		this.id=id;
	}
	public int getId(){
		return id;
	}
	public void setLocation(Location location){
		this.location = location;
	}
	public Location getLocation(){
		return location;
	}
	public void setTicketsList(List<Ticket> ticketsList){
		this.ticketsList=ticketsList;
	}
	public List<Ticket> getTicketsList(){
		return ticketsList;
	}
}
