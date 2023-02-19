import static java.lang.System.*;
import java.util.*;

public class useContentDB {
 public static void main(String[] args) {
  ConnectToDB connect1 = ConnectToDB.getInstance("pmi_db", "pmbook", "root", "");
  ConnectToDB connect2 = ConnectToDB.getInstance("pmi_db", "pmbook", "root", "");

  connect1.verifyConnection(); // The connection is open
  connect2.close(); // We close the connection with the second object
  connect1.verifyConnection(); // Although it was the connect2 object that closed the connection, connect1 displays the connection closed.
 }
}

// Classes
class ConnectToDB {
 private volatile static ConnectToDB unique_link;
 private String host;
 private String db_name;
 private String user;
 private String password;
 static boolean connection;

 private ConnectToDB(String host, String db_name, String user, String password) { 
  this.host     = host;
  this.db_name  = db_name;
  this.user     = user;
  this.password = password; 
  connection    = false;
 }
 
 public static ConnectToDB getInstance(String host, String db_name, String user, String password) {
  if(unique_link == null) 
   synchronized(ConnectToDB.class) {
    if(unique_link == null)
     unique_link = new ConnectToDB(host, db_name, user, password);
     // Code to verify connection status
     connection = true;
    } 

  return unique_link;
 }

 public boolean bindParam(String aka, String value, String tipo) {
  boolean bind = false;
  // Code top bind a value to its "aka"
  bind = true;
  return bind;
 } 

 public boolean prepare(String query) {
  boolean status = false;
  // Code to run the query receive to th DB
  status = true;
  return status;
 }

 public void close() {
  connection = false;
 }

 public void verifyConnection() {
  if(connection)
   out.println("\nConnection to the Data Base " + host + " open.\n");
  else
   out.println("\nConnection to the Data Base " + host + " closed.\n");
 }
}