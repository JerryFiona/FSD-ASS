import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.table.*;
import javax.swing.JFrame;
import javax.swing.event.*;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.JSlider;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JTable;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.NumberFormat;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Homepage extends JFrame {

	
	
	private JPanel contentPane;
	private JTextField suburbField;
	private JTable searchResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Homepage frame = new Homepage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Homepage() {
		//initComponents();
		//showTable();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 964, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search Properties");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 37));
		lblNewLabel.setBounds(347, 6, 345, 95);
		contentPane.add(lblNewLabel);
		JLabel minLabel = new JLabel("min$");
		
		minLabel.setBounds(295, 221, 114, 16);
		contentPane.add(minLabel);
		
		
		JLabel maxLabel = new JLabel("max$");
		maxLabel.setBounds(295, 296, 114, 16);
		contentPane.add(maxLabel);
		
	
		
		JLabel minPriceLabel = new JLabel("Min Price");
		minPriceLabel.setBounds(110, 177, 61, 16);
		contentPane.add(minPriceLabel);
		
		
		
		JLabel maxPriceLabel = new JLabel("Max Price");
		maxPriceLabel.setBounds(110, 248, 61, 16);
		contentPane.add(maxPriceLabel);

		
		JComboBox StateBox = new JComboBox();
		StateBox.addItem("ANY");
		StateBox.addItem("NSW");
		StateBox.addItem("QLD");	
		StateBox.addItem("SA");
		StateBox.addItem("VIC");
		StateBox.addItem("TAS");
		StateBox.addItem("WA");
		StateBox.addItem("ACT");
		StateBox.addItem("NT");

	
		StateBox.setSelectedItem("ANY");
		StateBox.setBounds(708, 128, 179, 38);
		contentPane.add(StateBox);
		
		JComboBox typeBox = new JComboBox();
		typeBox.addItem("ANY");
		typeBox.addItem("Apartment");
		typeBox.addItem("House");
		typeBox.addItem("Studio");
		typeBox.addItem("Terrace");
		typeBox.setSelectedItem("ANY");
		
		typeBox.setBounds(511, 129, 179, 37);
		contentPane.add(typeBox);
		
		
		JLabel typeLabel = new JLabel("Property Type");
		typeLabel.setBounds(540, 115, 136, 16);
		contentPane.add(typeLabel);
		
	
		JLabel stateLabel = new JLabel("State");
		stateLabel.setBounds(770, 115, 61, 16);
		contentPane.add(stateLabel);
		
		
		suburbField = new JTextField();
		suburbField.setBounds(115, 128, 317, 37);
		contentPane.add(suburbField);
		suburbField.setColumns(10);
		
		JLabel suburbLabel = new JLabel("Which suburb should we search?");
		suburbLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		suburbLabel.setForeground(new Color(0, 0, 0));
		suburbLabel.setBackground(Color.WHITE);
		suburbLabel.setBounds(113, 100, 326, 16);
		contentPane.add(suburbLabel);
		
		JSlider minSlider = new JSlider();
		
		minSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				String minInteger = Integer.toString(minSlider.getValue())+"0000";
				Double numParsed = Double.parseDouble(minInteger);
				 String numString = String.format("%,.0f", numParsed);
				minLabel.setText("$"+numString);
			 }
			}
				
			
		);
		minSlider.setMinorTickSpacing(5);
		minSlider.setMajorTickSpacing(25);
		minSlider.setPaintLabels(true);
		minSlider.setMaximum(200);
		minSlider.setMinimum(50);
		minSlider.setValue(50);
		minSlider.setBounds(183, 163, 268, 46);
		contentPane.add(minSlider);
		
		JSlider maxSlider = new JSlider();
		
		maxSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				String maxInteger = Integer.toString(maxSlider.getValue())+"0000";
				Double numParsed2 = Double.parseDouble(maxInteger);
				 String numString2 = String.format("%,.0f", numParsed2);
				maxLabel.setText("$"+numString2);
			}
		});
		maxSlider.setMajorTickSpacing(25);
		maxSlider.setPaintLabels(true);
		maxSlider.setMaximum(200);
		maxSlider.setMinimum(50);
		maxSlider.setValue(200);
		maxSlider.setBounds(183, 248, 277, 46);
		contentPane.add(maxSlider);
		

		
		String[] columnNames = { "Address", "Suburb","State","Price","Type", "Bedrooms","Bathrooms","Parking"};
		DefaultTableModel model1 = new DefaultTableModel(columnNames, 0);
		searchResult = new JTable(model1);
	    
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(110, 336, 765, 181);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(searchResult);
		
		

		
		
		JButton searchButton = new JButton("Search");
		
		
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String suburbKeyword = suburbField.getText();
				 String stateKeyword =StateBox.getSelectedItem().toString();;
				 if (StateBox.getSelectedItem()=="ANY") {
					 stateKeyword = null;
				 }
				
			     String typeKeyword =typeBox.getSelectedItem().toString();
				 if (typeBox.getSelectedItem()=="ANY") {
					 typeKeyword = null;
				 }
				 
				 int minKeyword = minSlider.getValue();
				 int maxKeyword = maxSlider.getValue();
			showTable(suburbKeyword, stateKeyword, typeKeyword,minKeyword,maxKeyword);
			
			}});
		
		
		
		searchButton.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		searchButton.setBounds(558, 216, 297, 58);
		contentPane.add(searchButton);
	
	
	}
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost/FSD ?serverTimezone=Australia/Sydney","Aolong","32555fsd" );
			return con;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public ArrayList<Property> propertiesList(String suburb,String state,String type, int min, int max)
	{
		ArrayList<Property> propertiesList = new ArrayList<Property>();
		 Connection connection = getConnection();
	String query = null;
		if (suburb.isEmpty()&&state==null&&type==null) {
			query = "SELECT * FROM Property WHERE PropertyPrice<"+max+"0000 AND PropertyPrice>"+min+"0000";
		}
		if ((!(suburb.isEmpty()))&&state==null&&type==null) {
			query = "SELECT * FROM Property WHERE Suburb='"+suburb+"' AND PropertyPrice<"+max+"0000 AND PropertyPrice>"+min+"0000";
		}
		if (suburb.isEmpty()&&(!(state==null))&&type==null) {
			 query = "SELECT * FROM Property WHERE State='"+state+"' AND PropertyPrice<"+max+"0000 AND PropertyPrice>"+min+"0000";
		}
		if (suburb.isEmpty()&&state==null&&(!(type==null))) {
			query = "SELECT * FROM Property WHERE PropertyType='"+type+"' AND PropertyPrice<"+max+"0000 AND PropertyPrice>"+min+"0000";
		}
		if ((!(suburb.isEmpty()))&&(!(state==null))&&type==null) {
			query = "SELECT * FROM Property WHERE Suburb='"+suburb+"'AND State='"+state+"'AND PropertyPrice<"+max+"0000 AND PropertyPrice>"+min+"0000";
		}
		if ((!(suburb.isEmpty()))&&state==null&&(!(type==null))) {
			 query = "SELECT * FROM Property WHERE Suburb='"+suburb+"'AND PropertyType='"+type+"' AND PropertyPrice<"+max+"0000 AND PropertyPrice>"+min+"0000";
		}
		if (suburb.isEmpty()&&(!(state==null))&&(!(type==null))) {
			query = "SELECT * FROM Property WHERE State='"+state+"'AND PropertyType='"+type+"' AND PropertyPrice<"+max+"0000 AND PropertyPrice>"+min+"0000";
		}
		if ((!(suburb.isEmpty()))&&(!(state==null))&&(!(type==null))) {
			query = "SELECT * FROM Property WHERE Suburb='"+suburb+"'AND State='"+state+"'AND PropertyType='"+type+"' AND PropertyPrice<"
					      +max+"0000 AND PropertyPrice>"+min+"0000";
		}
	
		 
		 Statement st;
		 ResultSet rs;
		 try {
			 st=connection.createStatement();
			 rs=st.executeQuery(query);
			 Property property;
			 while(rs.next())
			 {
				 property = new Property(rs.getString("Address"),rs.getString("Suburb"),rs.getString("State"),rs.getLong("PropertyPrice"),rs.getString("PropertyType"),rs.getInt("Bedrooms"),rs.getInt("Bathrooms"),rs.getInt("Parking"));
                 propertiesList.add(property);			
			 }
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 return propertiesList;
	}
	
	public void showTable(String suburb, String state, String type, int min, int max) {
		ArrayList<Property> list =propertiesList(suburb, state, type, min,max);
		DefaultTableModel model = (DefaultTableModel)searchResult.getModel();
		Object[] row = new Object[8];
		model.setRowCount(0);
		for (int i=0; i<list.size();i++ )
		{
			row[0]=list.get(i).getAddress();
			row[1]=list.get(i).getSuburb();
			row[2]=list.get(i).getState();
			row[3]="$"+list.get(i).getPrice();
			row[4]=list.get(i).getType();
			row[5]=list.get(i).getBedrooms();
			row[6]=list.get(i).getBathrooms();
			row[7]=list.get(i).getParking();
			
			
			model.addRow(row);
			
			
		}	
		
	}
	
	
	
	
    	

       
    
    }
	


