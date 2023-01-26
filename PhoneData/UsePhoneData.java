import java.util.*;

public class UsePhoneData {
 public static void main(String[] args) {
  // Phones
  PhoneData iphone12 = new PhoneData("iphone12");
  PhoneData iphone14 = new PhoneData("iphone14");
  // Clients
  // id -> <<number of client by order>> <<Model of interest>> <<Order ascendent>>
  // Queue of clients for iphone12
  Client client1 = new Client("asd", 111);
  Client client2 = new Client("asd", 212);
  Client client3 = new Client("asd", 313);
  // Queue of clients for iphone12
  Client client4 = new Client("asd", 121);
  Client client5 = new Client("asd", 222);

  // Insertions
  iphone12.registerObserver(client1);
  iphone12.registerObserver(client2);
  iphone12.registerObserver(client3);
  iphone14.registerObserver(client4);
  iphone14.registerObserver(client5);

  // Notifications
  iphone12.availabilityChanged();  
  //iphone14.availabilityChanged();

  // Removes 
  iphone12.removeObserver(2); // As an example, removed the third client from the list that are waiting for the iphone12
  System.out.println(" ");
  iphone12.availabilityChanged();  
 }
}

// Interfaces
interface Subject {
 public void registerObserver(Observer app);
 public void removeObserver(int position);
 public void notifyObservers();
}

interface Observer {
 public void update(String phoneModel);
}

// Classes
class PhoneData implements Subject {
 private String model;
 ArrayList<Observer> clients;

 public PhoneData(String model) {
  this.model = model;
  clients = new ArrayList<Observer>();
 }
 public void registerObserver(Observer client){
   clients.add(client);
 }
 public void removeObserver(int position) {
  if(position >= 0)
   clients.remove(position);
 }
 public void notifyObservers() {
  for(int index = 0; index <= clients.size() - 1; index ++)
   clients.get(index).update(model);
 }
 public void availabilityChanged() {
  notifyObservers();
 }
}

class Client implements Observer {
 private String email;
 private int id;

 public Client(String email, int id) {
  this.email = email;
  this.id = id;
 }
 public void update(String model) {
  System.out.println("Client " + id + " here the availability for: " + model);
 }
}
