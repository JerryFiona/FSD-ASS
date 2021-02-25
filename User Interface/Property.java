
public class Property {
	private String address;
	private String suburb;
	private String state;
	private long price;
	private String type;
	private int bedrooms;
	private int bathrooms;
	private int parking;


	public Property(String a, String su, String st,long p,String ty, int b, int ba, int pa) {
		address = a;
		suburb=su;
		state=st;
		price = p;
		type=ty;
		bedrooms=b;
		bathrooms =ba;
		parking=pa;
	}
	public void setSuburb(String suburb) {
		this.suburb=suburb;
	}
	public void setState(String state) {
		this.state=state;
	}
	public void setType(String type) {
		this.type=type;
	}
	public void setAddress(String address) {
		this.address=address;
	}

	public void setBedroom(int bedrooms) {
		this.bedrooms = bedrooms;
	}
	public void setBathroom(int bathrooms) {
		this.bathrooms = bathrooms;
	}
	public void setParking(int parking) {
		this.parking = parking;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
	public int getBedrooms() {
		return this.bedrooms;
	}
	public int getBathrooms() {
		return this.bathrooms;
	}
	public int getParking() {
		return this.parking;
	}
	public String getAddress() {
		return this.address;
	}
	public long getPrice() {
		return this.price;
	}
	public String getState() {
		return this.state;
	}
	public String getSuburb() {
		return this.suburb;
	}
	public String getType() {
		return this.type;
	}
}



