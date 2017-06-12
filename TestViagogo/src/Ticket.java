
public class Ticket {
	private int id;
	private double price; 
	public Ticket(int id, double price){
		this.id=id;
		this.price = price;
	}
	public void setId(int id){
		this.id=id;
	}
	public void setPrice(double price){
		this.price=price;
	}
	public int getId(){
		return id;
	} 
	public double getPrice(){
		return price;
	}
}
