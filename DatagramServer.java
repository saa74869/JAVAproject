import java.net.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DatagramServer {

 private DatagramSocket socket;
 
 public DatagramServer() {
  Scanner keyboard = new Scanner(System.in);
  try {
   socket = new DatagramSocket(1097);
   System.out.println("Server is running...");
   while(true) {
    byte data [] = new byte[100]; //byte to store data
    //get packet from client
    DatagramPacket packet = new DatagramPacket(data, data.length);
    socket.receive(packet);
    //convert byte to String
    String message = new String(packet.getData());
    String url = "jdbc:mysql://localhost/hotel?user=root&password=root";
      Class.forName("com.mysql.jdbc.Driver");
      Connection conn = DriverManager.getConnection(url);
      System.out.println("Connected!!!");
      Statement stmt = conn.createStatement();
      String search = "select * from creditcard WHERE creditcardinfo = '" + message + "';";
      ResultSet result = stmt.executeQuery(search);
      result.last(); // step to the last row in ResultSet
      int row_number = result.getRow(); // get the row number of the last row returned
      int print = result.getRow();
      if (print == 0) {
        System.out.print("\nServer says: ");
        message = "No";
        data = message.getBytes();
        packet = new DatagramPacket(data, data.length, 
           packet.getAddress(),
           packet.getPort());
        socket.send(packet);
      } else {
    System.out.print("\nServer says: ");
    message = "Yes";
    data = message.getBytes();
    packet = new DatagramPacket(data, data.length, 
           packet.getAddress(),
           packet.getPort());
    socket.send(packet);
   }

  }
  }
  catch(SocketException se) { se.printStackTrace(); }
  catch(IOException ioe) { ioe.printStackTrace(); }
  catch(ClassNotFoundException cnfe) {
   cnfe.printStackTrace(); 
  }
  catch(SQLException sqle)  { sqle.printStackTrace(); }
 }
 
 public static void main(String [] args) {
  new DatagramServer();
 } 
}