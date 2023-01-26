import java.util.*;

public class UseWeatherData {
 public static void main(String[] args) {
  WeatherData wd = new WeatherData();
  Observer app1 = new CurrentConditions();
  Observer app2 = new StatisticsDisplay();
  Observer app3 = new ForecastDisplay();
  
  // Insertions
  wd.registerObserver(app1);
  wd.registerObserver(app2);
  wd.registerObserver(app3);
  // Notifications
  wd.setMeasurements(8.0f, 23.2f, 12.0f);
  wd.setMeasurements(3.0f, 23.2f, 12.0f);
 }
}

// Interfaces
public interface Subject {
 public void registerObserver(Observer app);
 public void removeObserver(int position);
 public void notifyObservers();
}

public interface Observer {
 public void update(float temperature, float pressure, float humidity);
}

public interface DisplayElement {
 public void display(float temperature, float pressure, float humidity);
}

// Classes
class WeatherData implements Subject {
 private float temperature, pressure, humidity;
 private Vector<Observer> observers; 
 
 public WeatherData() {
  observers = new Vector<Observer>();
 }
 public void registerObserver(Observer app) {
  observers.add(app);
 }
 public void removeObserver(int position) {
  observers.remove(position);
 }
 public void notifyObservers() {
  for(int index = 0; index <= observers.size() - 1; index ++) {
   observers.get(index).update(temperature, pressure, humidity);
  }
 }
 public void setMeasurements(float temperature, float pressure, float humidity) {
     this.temperature = temperature;
     this.pressure = pressure;
     this.humidity = humidity;
   
     measurementsChanged();
 }
 public void measurementsChanged() {
  notifyObservers();
 }
}

class CurrentConditions implements Observer, DisplayElement {
 public void display(float temperature, float pressure, float humidity) {
  System.out.println(
            "\n****** App CurrentConditions ******\n" +
            "\nTemperature is : " + temperature +
            "\nPressure is    : " + pressure +
            "\nHumidity is    : " + humidity 
  );
 }
 public void update(float temperature, float pressure, float humidity) {
  display(temperature, pressure, humidity);
 }
}

class StatisticsDisplay implements Observer, DisplayElement {
 private Vector<Float> temps;

 public StatisticsDisplay() {
  temps = new Vector<>();
 }
 public void display(float temperature, float pressure, float humidity) {
   int index;
   float min, max, average = 0;

   temps.add(temperature);
   Collections.sort(temps); // Ascendent Sort of temperatures 

   for(index = 0; index <= temps.size() - 1; index ++)
    average += temps.get(index);         
   average /= index; // Main of all temperatures

   // Asign of min and max temperatures   
   min = temps.get(0); max = temps.get(temps.size() - 1);
   //System.out.println("Total of temps: " + (temps.size()));   
 
   System.out.println(
            "\n****** App StatisticsDisplay ******\n" +
            "\nTemperature is  : " + temperature +
            "\nMin temp. is    : " + min +
            "\nMax temp. is    : " + max +
            "\nAverage is      : " + average
  );
 }
 public void update(float temperature, float pressure, float humidity) {
  display(temperature, pressure, humidity);
 }
}

class ThirdPartyDisplay implements Observer, DisplayElement {
 public void display(float temperature, float pressure, float humidity) {
  System.out.println(
            "\nTemperature is : " + temperature +
            "\nPressure is    : " + pressure +
            "\nHumidity is    : " + humidity 
  );
 }
 public void update(float temperature, float pressure, float humidity) {
  display(temperature, pressure, humidity);
 }
}

class ForecastDisplay implements Observer, DisplayElement {
 public void display(float temperature, float pressure, float humidity) {
   System.out.println("\n****** App ForecastDisplay ******");
   if(temperature >= 7 && humidity < 17) System.out.println("Sunny day today!");
   else if(pressure > 3) System.out.println("Cloudy day!\n Take with you your umbrella just in case.");
   else System.out.println("Stormy day. Watch out!");
 }
 public void update(float temperature, float pressure, float humidity) {
  display(temperature, pressure, humidity);
 }
}