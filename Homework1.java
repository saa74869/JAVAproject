import java.awt.*; //this imports all of the classes for creating user interfaces and painting graphics and images.  This is needed for JFrame
import javax.swing.*; // provides a set of lightweight components that work the same on all platforms.  We are declaring this for JFrame
import java.awt.event.*;  // provides interfaces and classes for dealing with different types of events fired by AWT components.  This is also needed for JFrame.
import java.io.*; // Provides for system input and output through data streams, serialization and the file system
import java.util.Scanner; // A built in text scanner which can parse primitive types and strings using regular expressions (declare when using System.out.println())
import java.sql.*; // Provides the API (application programming interface) for accessing and processing data stored in a data source (usually a relational database)
import java.net.*; // provides the classes for implementing networking applications

public class Homework1 extends JFrame implements ActionListener  { // Here we are declaring the class, using JFrame which is used to build the GUI, and implementing an actionlistener which makes buttons listen when they are clicked
  // below we declare all of our variables
  //these variables are part of the GUI
  private JLabel firstNameLabel, lastNameLabel, checkInLabel, checkOutLabel, noOfRoomsLabel, guestPerRoomLabel, billingLabel, billingLabel2, streetLabel, cityLabel, stateLabel, zipLabel, phoneLabel, creditTypeLabel, creditNumLabel, expirationLabel, roomNumLabel, guestsLabel, specialLabel, roomTypeLabel, comment, cLabel;
  private JTextField firstNameField, lastNameField, checkInField, checkOutField, streetField, cityField, zipField, phoneField, creditNumField, expirationField;
  private JPanel wPanel, northpanel, westpanel, westpanel2, westpanel3, westpanel4, southpanel, eastpanel, centerpanel, centerpanel2, centerpanel3, centerpanel4;
  private JButton submit, cancel, searchCredit, delete;
  private JComboBox noOfRooms, guestPerRoom, state;
  private JCheckBox studio, standard, family, suite;
  private JRadioButton none, aaa, senior, govt, visa, master,amex, discover;
  private JTextArea specialRequest;
  //These variables connect the radiobuttons into groups
  private ButtonGroup group, group2;
  private DatagramSocket socket;
  // These variables allow for the stream server to operate
  //private Socket socket; // A socket is the endpoint of a two way commo link between two programs runing on the network.  It is bound to a port number so that the TCP layer can identify the application that data is destined to be sent to.
  //private ObjectOutputStream outputter; // This declares the variable for the data that will be streamed.
 
  //Setting up the GUI.  
  public Homework1() {
   setTitle("Hotel Reservation System");
   Color bcolor = new Color(85, 214, 203);
   
   //NORTH PANEL
   setLayout(new BorderLayout());
    firstNameLabel = new JLabel("First Name");
    firstNameField = new JTextField(10);
    lastNameLabel = new JLabel("Last Name");
    lastNameField = new JTextField(10);
    northpanel = new JPanel();
    northpanel.setBackground(bcolor);
    northpanel.setLayout(new FlowLayout());
    northpanel.add(firstNameLabel);
    northpanel.add(firstNameField);
    northpanel.add(lastNameLabel);
    northpanel.add(lastNameField);
    add(northpanel, BorderLayout.NORTH);
    
    
    //WEST PANEL
    checkInLabel = new JLabel("Check-in date (mm/dd/yy)");
    checkOutLabel = new JLabel("Check-out date (mm/dd/yy)");
    checkInField = new JTextField (8);
    checkOutField = new JTextField (8);
    westpanel = new JPanel();
    westpanel.add(checkInLabel);
    westpanel.add(checkInField);
    westpanel.add(checkOutLabel);
    westpanel.add(checkOutField);
    noOfRoomsLabel = new JLabel("Number of rooms");
    guestPerRoomLabel = new JLabel("Guests per room");
    String roomsArray [] = {"1","2","3","4-9","10-25", "26+"};
    noOfRooms = new JComboBox(roomsArray);
    String guestArray [] = {"1","2","3","4","5","6"};
    guestPerRoom = new JComboBox(guestArray);
    westpanel2 = new JPanel();
    westpanel2.setLayout(new GridLayout(3,2));
    westpanel2.add(westpanel);
    westpanel2.add(noOfRoomsLabel);
    westpanel2.add(guestPerRoomLabel);
    westpanel2.add(noOfRooms);
    westpanel2.add(guestPerRoom);
    specialLabel = new JLabel("SPECIAL RATES");
    roomTypeLabel = new JLabel("Room Types");
    none = new JRadioButton("None");
    aaa = new JRadioButton("AAA/CAA");
    senior = new JRadioButton("Senior Discount");
    govt = new JRadioButton("Government & Military");
    group2 = new ButtonGroup();
    group2.add(none);
    group2.add(aaa);
    group2.add(senior);
    group2.add(govt);
    roomTypeLabel = new JLabel("Room Types");
    studio = new JCheckBox ("Studio");
    studio.setToolTipText("One Queen Bed");
    standard = new JCheckBox ("Standard");
    standard.setToolTipText("One King Bed or Two Queen Beds");
    family = new JCheckBox ("Family");
    family.setToolTipText("Three Queen Beds and Living Room");
    suite = new JCheckBox ("Suite");
    suite.setToolTipText("Two Bedrooms, Living Room and Kitchen");
    cLabel = new JLabel("Special Requests:");
    specialRequest = new JTextArea(55,55);
    westpanel3 = new JPanel();
    westpanel3.setLayout(new GridLayout(5,2));
    westpanel3.add(specialLabel);
    westpanel3.add(roomTypeLabel);
    westpanel3.add(none);
    westpanel3.add(studio);
    westpanel3.add(aaa);
    westpanel3.add(standard);
    westpanel3.add(senior);
    westpanel3.add(family);
    westpanel3.add(govt);
    westpanel3.add(suite);
    westpanel4 = new JPanel();
    westpanel4.setLayout(new GridLayout(2,2));
    westpanel4.add(cLabel);
    westpanel4.add(specialRequest);
    wPanel = new JPanel();
    wPanel.setLayout(new GridLayout(10,4));
    wPanel.add(westpanel);
    wPanel.add(westpanel2);
    wPanel.add(westpanel3);
    wPanel.add(westpanel4);
    add(wPanel, BorderLayout.WEST);
    
    //CENTER PANEL
    centerpanel = new JPanel();
    centerpanel.setLayout(new GridLayout(6,2));
    billingLabel = new JLabel("Billing Address:");
    billingLabel2 = new JLabel("");
    streetLabel = new JLabel("Street");
    streetField = new JTextField(10);
    cityLabel = new JLabel("City");
    stateLabel = new JLabel ("State");
    String stateArray [] = {"VA", "MD", "DC", "AZ", "FL"};
    state = new JComboBox(stateArray);
    cityField = new JTextField(10);
    zipLabel = new JLabel ("Zip Code");
    zipField = new JTextField(5);
    phoneLabel = new JLabel ("Phone");
    phoneField = new JTextField(12);
    centerpanel.add(billingLabel);
    centerpanel.add(billingLabel2);
    centerpanel.add(streetLabel);
    centerpanel.add(streetField);
    centerpanel.add(cityLabel);                       
    centerpanel.add(cityField);
    centerpanel.add(stateLabel);
    centerpanel.add(state);
    centerpanel.add(zipLabel);
    centerpanel.add(zipField);
    centerpanel.add(phoneLabel);
    centerpanel.add(phoneField);
    
    creditTypeLabel = new JLabel("Credit Card Type");
    ImageIcon visapic = new ImageIcon("visa.gif");
    ImageIcon masterpic = new ImageIcon("mastercard.gif");
    ImageIcon amexpic = new ImageIcon("amex.gif");
    ImageIcon discoverpic = new ImageIcon("discover.gif");
    JLabel visalabel = new JLabel(visapic);
    JLabel masterlabel = new JLabel(masterpic);
    JLabel amexlabel = new JLabel(amexpic);
    JLabel discoverlabel = new JLabel (discoverpic);
    visa = new JRadioButton("");
    master = new JRadioButton("");
    amex = new JRadioButton("");
    discover = new JRadioButton("");
    JLabel blank = new JLabel("");
    group = new ButtonGroup();
    group.add(visa);
    group.add(master);
    group.add(amex);
    group.add(discover);
    centerpanel2 = new JPanel();
    centerpanel2.setLayout(new GridLayout(5,2));
    centerpanel2.add(creditTypeLabel);
    centerpanel2.add(blank);
    centerpanel2.add(visa);
    centerpanel2.add(visalabel);
    centerpanel2.add(master);
    centerpanel2.add(masterlabel);
    centerpanel2.add(amex);
    centerpanel2.add(amexlabel);
    centerpanel2.add(discover);
    centerpanel2.add(discoverlabel);
    centerpanel3 = new JPanel();
    centerpanel3.setLayout(new GridLayout(6,2));
    creditNumLabel = new JLabel ("Credit Card Number:");
    creditNumField = new JTextField (7);
    expirationLabel = new JLabel("Expiration (mm/yy):");
    expirationField = new JTextField(7);
    centerpanel3.add(creditNumLabel);
    centerpanel3.add(creditNumField);
    centerpanel3.add(expirationLabel);
    centerpanel3.add(expirationField);
    centerpanel4 = new JPanel();
    centerpanel4.setLayout(new GridLayout(5,1));
    centerpanel4.add(centerpanel);
    centerpanel4.add(centerpanel2);
    centerpanel4.add(centerpanel3);
    add(centerpanel4, BorderLayout.CENTER);
    
    //south panel
    southpanel = new JPanel();
    southpanel.setBackground(bcolor);
    submit = new JButton("Submit");
    submit.addActionListener(this);
    cancel = new JButton("Cancel");
    cancel.addActionListener(this);
    searchCredit = new JButton("Search for Credit Card");
    searchCredit.addActionListener(this);
    delete = new JButton("Delete");
    delete.addActionListener(this);
    southpanel.add(submit);
    southpanel.add(cancel);
    southpanel.add(searchCredit);
    southpanel.add(delete);
    add(southpanel, BorderLayout.SOUTH);
    
    setSize(1000,1000);
    setVisible(true);
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  //This is the part of the code which takes the data the user inputs and displays and stores it
  public void actionPerformed(ActionEvent event) {
      
      //transferring all data to string format
      String fn = firstNameField.getText();
      String ln = lastNameField.getText();
      String ci = checkInField.getText();
      String co = checkOutField.getText();
      String roomnum = noOfRooms.getSelectedItem().toString();
      String roomguest = guestPerRoom.getSelectedItem().toString();
      String sr = "";
      if (none.isSelected()) {
       sr = "None"; 
      } else if(aaa.isSelected()) {
       sr = "AAA/CAA"; 
      } else if(senior.isSelected()) {
       sr = "Senior Discount"; 
      } else if(govt.isSelected()) {
       sr = "Government & Military"; 
      }
      boolean roomtype1 = studio.isSelected();
      boolean roomtype2 = standard.isSelected();
      boolean roomtype3 = family.isSelected();
      boolean roomtype4 = suite.isSelected();
      String spr = specialRequest.getText();
      String str = streetField.getText();
      String cit = cityField.getText();
      String sta = state.getSelectedItem().toString();
      String zi = zipField.getText();
      String pho = phoneField.getText();
      String cred = "";
      if (visa.isSelected()) {
       cred = "visa"; 
      } else if(master.isSelected()) {
       cred = "mastercard"; 
      } else if(amex.isSelected()) {
       cred = "amex"; 
      } else if(discover.isSelected()) {
       cred = "discover"; 
      }
      String crednum = creditNumField.getText();
      String credex = expirationField.getText();
      int credDigits = crednum.length();
      
      //Various exceptions for credit card
     try {
        if (cred != "amex" && (credDigits < 16 || credDigits > 16 && (cred == "visa" | cred == "mastercard" | cred == "discover"))) {
         throw new InvalidCreditCardException(); 
        } 
        if (credDigits < 15 || credDigits > 15 && cred == "amex") {
         throw new InvalidCreditCardException("Invalid Amex card number!  Only enter 15 numbers on your card without spaces."); 
        }
      }
         catch (InvalidCreditCardException ie) {
         JOptionPane.showMessageDialog(null, ie.getMessage()); 
        }
         
         //this is the string for a successful output which will be displayed in the GUI
         String output = "Your reservation has been successfully submitted!" + "\nName: " + fn + " " + ln +  "\nCheck in date: " + ci + "\nCheck out date: " + co + "\nNumber of rooms: "
           + roomnum + "\nNumber of guests: " + roomguest + "\nSpecial Rates: " + sr + "\nRoom Types:" + "\n   -Studio: " + roomtype1 + "\n   -Standard: " + roomtype2 + "\n   -Family: " + roomtype3 + 
           "\n   -Suite: " + roomtype4 + "\nSpecial Requests: " + spr + "\nAddress: " + str + " " + cit + " " + sta + " " + zi + "\nPhone: " + pho + "\nCredit Card: " + cred + "\nCredit Card Number: "
           + crednum + "\nExpiration: " + credex;

         
         // This sets up what happens when submit is clicked
         if(event.getSource() == submit && ((credDigits == 16 && cred != "amex") || (credDigits == 15 && cred == "amex"))) {
           System.out.println("Client is running...");
           
           // This sets up a socket as a client in datagram
           Scanner keyboard = new Scanner(System.in);
             try {
               socket = new DatagramSocket(); //create socket
               String result = "true";
               while(result == "true") {
                 String message = crednum + credex;
                 byte data [] = message.getBytes(); //convert message to bytes
                 //create packet sent via udp using localhost and port 1097
                 DatagramPacket packet = new DatagramPacket(data, data.length, 
                                                            InetAddress.getLocalHost(), 1097); 
                 socket.send(packet); //send packet
    
                 //byte data received from server
                 data = new byte[100];
                 //packet received from server
                 packet = new DatagramPacket(data, data.length);
                 socket.receive(packet);
                 //convert packet to String
                 message = new String(packet.getData()); 
                 System.out.print("Server says: " + message); //trim message
                 if (message == "Yes") {
                  JOptionPane.showMessageDialog(null, output); 
                 } else if (message == "No") {
                   String neg = "Credit Card not valid!  Please press CTRL-C";
                  JOptionPane.showMessageDialog(null, neg); 
                 } else {
                   result = "false";
                   String neg = "Credit Card not valid!  Please press CTRL-C";
                   JOptionPane.showMessageDialog(null, neg);
                 }
               }
             }
             catch(IOException ioe) { ioe.printStackTrace(); }
             
           /* //This sets up a socket as a client in stream
           try {
             //use socket to connect to server running on port 1098
             socket = new Socket(InetAddress.getByName("localhost"), 1098);
             //create output stream
             outputter = new ObjectOutputStream(socket.getOutputStream());
             String message = crednum + credex;
             //convert message to stream
             outputter.writeObject(message);
             //write buffered output bytes and flush through to the underlying stream
             outputter.flush();
             System.out.println("Message sent...");
           }
           catch(UnknownHostException uhe) {
             uhe.printStackTrace(); 
           }
           catch(IOException ioe) {
             ioe.printStackTrace(); 
           } */
           
           //This outputs the message to the GUI
        
        
        //setting up the connection to the SQL database
         try {
           //create a URL to connect to MySQL database
           String url = "jdbc:mysql://localhost/hotel?user=root&password=root";
      
           /*
            Use com.mysql.jdbc.Driver as the connector between your java
            and MySQL database. The driver "mysql-connector-java-5.1.5-bin.jar"
            must exist in your jdk folder.
            Windows: C:\Program Files\Java\jdk_of_your_version\jre\lib\ext
            */
           Class.forName("com.mysql.jdbc.Driver");
       
           // create a Connection object to connect to the database using url created above
           Connection conn = DriverManager.getConnection(url);
           System.out.println("Connected!!!");
      
           // create a Statement object to run SQL language (select, update, insert, delete)
           Statement stmt = conn.createStatement();
    
           String sqlStatement = "INSERT INTO reservations VALUES('" + fn +  "', '" +  ln + "', '" +  ci +  "', '" +  co + "', '" + roomnum + "', '" + roomguest + "', '" + sr + "', '" + roomtype1 + "', '" + roomtype2 + 
             "', '" + roomtype3 + "','" + roomtype4 + "', '" + spr + "', '" + str + "', '" + cit + "', '" + sta +  "', '" + zi +  "', '" +  pho + "', '" + cred + "', '" + crednum + "', '" + credex + "');";
      
           stmt.execute(sqlStatement);
              }

         catch(ClassNotFoundException cnfe) 
              { cnfe.printStackTrace(); }
         catch(SQLException sqle)  
              { sqle.printStackTrace(); }
      
         //This code puts the data being input into a .txt file
         /*
          try {
          PrintWriter file = new PrintWriter(new FileWriter(crednum + ".txt", true));
          file.print(output);
          file.close();
          }   
          catch(IOException ioe) { ioe.printStackTrace(); }
          */
    }
    
    // This sets up if the cancel button is clicked     
    else if(event.getSource() == cancel) {
      
      firstNameField.setText("");
      lastNameField.setText("");
      checkInField.setText("");
      checkOutField.setText("");
      studio.setSelected(false);
      standard.setSelected(false);
      family.setSelected(false);
      suite.setSelected(false);
      specialRequest.setText("");
      streetField.setText("");
      cityField.setText("");
      zipField.setText("");
      phoneField.setText("");
      group.clearSelection();
      group2.clearSelection();
      creditNumField.setText("");
      expirationField.setText("");
      
    // This sets up if the search button is clicked  
    }  else if(event.getSource() == searchCredit) {
            
      // This try statement communicates with SQL 
      try {     
      String url = "jdbc:mysql://localhost/hotel?user=root&password=root";
  
      Class.forName("com.mysql.jdbc.Driver");

      Connection conn = DriverManager.getConnection(url);
      System.out.println("Connected!!!");

      Statement stmt = conn.createStatement();
      String search = "select * from reservations WHERE creditcardnum = '" + crednum + "';";
      ResultSet result = stmt.executeQuery(search);
      int count = 1;
       while(result.next()) {
        System.out.println(result.getString(19));
        String credoutput = "Credit card found! " + result.getString(19);
        JOptionPane.showMessageDialog(null, credoutput);
        count = count + 1;
        }
       if(count == 1) {
         String fail = "No credit card information has been found.";
        JOptionPane.showMessageDialog(null, fail);  
       } else {
        System.out.println("You have found the secret line of the code!!"); 
       }
      }

      catch(ClassNotFoundException cnfe) { cnfe.printStackTrace(); }
      catch(SQLException sqle)  { sqle.printStackTrace(); }
      
      //This sets up if the delete button is clicked
    }  else if(event.getSource() == delete) {
       try {
           
      String url = "jdbc:mysql://localhost/hotel?user=root&password=root";
  
      Class.forName("com.mysql.jdbc.Driver");

      Connection conn = DriverManager.getConnection(url);
      System.out.println("Connected!!!");

      Statement stmt = conn.createStatement();
      String delete = "delete from reservations where creditcardnum='" + crednum + "';";
      stmt.execute(delete);
      }

    catch(ClassNotFoundException cnfe) { cnfe.printStackTrace(); }
    catch(SQLException sqle)  { sqle.printStackTrace(); }
    
    String delete = "Your card information has been deleted";
     JOptionPane.showMessageDialog(null, delete);
    }
    
    // This sets up a search feature for a .txt file
    /*String filename = crednum + ".txt"; 
    File file = new File(filename); // Create an actual file
    try {
       if (crednum == "") {
       throw new FileNotFoundException();
       }
      // Read file using Scanner
      Scanner reader = new Scanner(file);
      String line = "";
      while(reader.hasNext()) { // loop through each line in the file
        line = line + reader.nextLine() + "\n"; // retrieve data from each line
      } JOptionPane.showMessageDialog(null, line);
    }
    catch(FileNotFoundException fnfe) {
      System.out.println(fnfe.toString());
    }*/
  }
  //This is where the class is actually run
   public static void main (String [] args) { 
   Homework1 gui = new Homework1();
  }
}