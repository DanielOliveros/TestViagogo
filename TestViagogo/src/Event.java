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
		orderTicketsByPrice();
	}
	
	public void orderTicketsByPrice(){
		Ticket[] ticketsArray = this.ticketsList.toArray(new Ticket[this.ticketsList.size()]);
		for(int i=0;i<(ticketsArray.length-1);i++){
            for(int j=i+1;j<ticketsArray.length;j++){
                if(ticketsArray[i].getPrice()>ticketsArray[j].getPrice()){
                    Ticket auxTicket=ticketsArray[i];
                    ticketsArray[i]=ticketsArray[j];
                    ticketsArray[j]=auxTicket;
                }
            }
        }
		List<Ticket> orderedTicketsList = new ArrayList<Ticket>();
		for(int i=0; i<this.ticketsList.size(); i++){
			orderedTicketsList.add(ticketsArray[i]);
		}
		this.setTicketsList(orderedTicketsList);
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
