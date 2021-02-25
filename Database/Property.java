import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.NumberFormat;
import java.sql.SQLException;
import java.util.Scanner;

public class Property {
	public static final String URL = "jdbc:mysql://localhost/FSD ?serverTimezone=Australia/Sydney";
    public static final String USER = "Aolong";
    public static final String PASSWORD = "32555fsd";
    public static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
   	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	        System.exit(1);
	    }
	    try
	    {
	    	Connection connection = DriverManager.getConnection(URL,USER,PASSWORD );
	    	Statement statement = connection.createStatement();
	    	int ID=0;
	    	String Address="";
	    	String Suburb="";
	    	String State="";
	        String PropertyPrice="";
	    	String PropertyType="";
	    	int Bedrooms=0;
	    	int Bathrooms=0;
	    	int Parking=0;    	   		    
	
	    	//Obtaining Variables to search for
	    	/*
	    	Scanner scanner = new Scanner(System.in);
	    	System.out.println("Which State are you searching for?");
			String customerState = scanner.nextLine();
			System.out.println("Which Suburb are you searching for?");
			String customerSuburb = scanner.nextLine();
			scanner.close();
	    	*/
			
	    	
			//Create SQL SELECT query
			String selectQuery = "SELECT * FROM Property WHERE ID >=495";	
			ResultSet select = statement.executeQuery(selectQuery);
			System.out.println("ID\tAddress\t\t\t\tSuburb\t\tState\t\tPropertyPrice\tPropertyType\tBedrooms\tBathrooms\tParking");
			while(select.next())
	    	{
				ID = select.getInt("ID");
				Address = select.getString("Address");
	    		PropertyPrice = select.getString("PropertyPrice");
	    		PropertyType = select.getString("PropertyType");
	    		Suburb = select.getString("Suburb");
	    		State = select.getString("State");
	    		Bedrooms = select.getInt("Bedrooms");
	    		Bathrooms = select.getInt("Bathrooms");
	    		Parking = select.getInt("Parking");
	    		System.out.printf("%-8d%-32s%-17s%-15s%-17s%-17s%-15d%-15d%-10d",ID, Address,Suburb, State, "$"+PropertyPrice, PropertyType, Bedrooms, Bathrooms, Parking);
	    	    System.out.print("\n");
	    	}
			select.close();
		
		
			
			//Create SQL INSERT query 
			String insertQuery = "INSERT INTO property(ID, FirstName, LastName, Address,Suburb,State,Postcode,PropertyPrice,PropertyType,Bedrooms,Bathrooms,Parking)"+
			                     "VALUES (501,'James','Man','16 PrimeRose Ave','Ryde','NSW',2212,'862612.00','House',5,2,2)";
			int rowsInsert = statement.executeUpdate(insertQuery);
			if (rowsInsert>0) {
				System.out.print("\n");
				System.out.println("A new property advertisement was inserted successfully!");
			}
			ResultSet select2 = statement.executeQuery("SELECT * FROM Property WHERE ID >=495");
			System.out.println("ID\tAddress\t\t\t\tSuburb\t\tState\t\tPropertyPrice\tPropertyType\tBedrooms\tBathrooms\tParking");	
			while(select2.next())
	    	{
				ID = select2.getInt("ID");
				Address = select2.getString("Address");
	    		PropertyPrice = select2.getString("PropertyPrice");
	    		PropertyType = select2.getString("PropertyType");
	    		Suburb = select2.getString("Suburb");
	    		State = select2.getString("State");
	    		Bedrooms = select2.getInt("Bedrooms");
	    		Bathrooms = select2.getInt("Bathrooms");
	    		Parking = select2.getInt("Parking");
	    		System.out.printf("%-8d%-32s%-17s%-15s%-17s%-17s%-15d%-15d%-10d",ID, Address, Suburb, State, "$"+PropertyPrice, PropertyType, Bedrooms, Bathrooms, Parking);
	    	    System.out.print("\n");
	    	}
			select2.close();
			
			
			//Create SQL UPDATE query 
			String updateQuery = "UPDATE Property SET PropertyPrice = '900000.00' WHERE ID = 501";
			int rowsUpdate = statement.executeUpdate(updateQuery);
			if (rowsUpdate>0) {
				System.out.print("\n");
				System.out.println("An existing property advertisement was updated successfully!");
			}
			ResultSet select3 = statement.executeQuery("SELECT * FROM Property WHERE ID >=495");
			System.out.println("ID\tAddress\t\t\t\tSuburb\t\tState\t\tPropertyPrice\tPropertyType\tBedrooms\tBathrooms\tParking");
			while(select3.next())
	    	{
				ID = select3.getInt("ID");
				Address = select3.getString("Address");
	    		PropertyPrice = select3.getString("PropertyPrice");
	    		PropertyType = select3.getString("PropertyType");
	    		Suburb = select3.getString("Suburb");
	    		State = select3.getString("State");
	    		Bedrooms = select3.getInt("Bedrooms");
	    		Bathrooms = select3.getInt("Bathrooms");
	    		Parking = select3.getInt("Parking");
	    		System.out.printf("%-8d%-32s%-17s%-15s%-17s%-17s%-15d%-15d%-10d",ID, Address,Suburb, State, "$"+PropertyPrice, PropertyType, Bedrooms, Bathrooms, Parking);
	    	    System.out.print("\n");
	    	}
			select3.close();
			
			
			
			//Create SQL DELETE query 
			String deleteQuery = "DELETE FROM Property WHERE ID =501";
			int rowsDelete = statement.executeUpdate(deleteQuery);
			if (rowsDelete>0) {
				System.out.print("\n");
				System.out.println("A property advertisement was deleted successfully!");
			}
			ResultSet select4 = statement.executeQuery("SELECT * FROM Property WHERE ID >=495");
			System.out.println("ID\tAddress\t\t\t\tSuburb\t\tState\t\tPropertyPrice\tPropertyType\tBedrooms\tBathrooms\tParking");
			while(select4.next())
	    	{
				ID = select4.getInt("ID");
				Address = select4.getString("Address");
	    		PropertyPrice = select4.getString("PropertyPrice");
	    		PropertyType = select4.getString("PropertyType");
	    		Suburb = select4.getString("Suburb");
	    		State = select4.getString("State");
	    		Bedrooms = select4.getInt("Bedrooms");
	    		Bathrooms = select4.getInt("Bathrooms");
	    		Parking = select4.getInt("Parking");
	    		System.out.printf("%-8d%-32s%-17s%-15s%-17s%-17s%-15d%-15d%-10d",ID, Address,Suburb, State,"$"+PropertyPrice, PropertyType, Bedrooms, Bathrooms, Parking);
	    	    System.out.print("\n");
	    	}
			select4.close();
			
			
		
	    	statement.close();
	    	connection.close();
	    }
	    catch(SQLException e) {
	    	e.printStackTrace();
	    }
	    	
	    

	}

}
