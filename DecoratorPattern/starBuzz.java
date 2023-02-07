/*
 Program description: Apply Decoration Pattern through a system for a cafeteria 
 Author: Mario A. Núñez Zavala
 Problem: Once define the component, condiment decorator and their concrete classes
          we need provide the beverage size.
          For the solution, I use to options:
          1. Treat each available size (small, standard/medium and large) as condiment decorators
          2. Do a reading by keyboard to get the size using set and get methods from super class Beverage
*/

import static java.lang.System.*;
import java.util.*;

public class StarBuzz {
 public static void main(String[] args) {
  String size = "";
  double beverage_cost = 0.0f;

  Beverage beverage = new Expresso();
  out.println(beverage.getDescription() + " $" + beverage.cost());
  
  Beverage beverage2 = new DarkRoast();
  beverage2 = new Milk(beverage2);
  beverage2 = new Mocha(beverage2);
  beverage2 = new Soy(beverage2);
  beverage2 = new Whip(beverage2);
  
  // Second option to treat the size of the drink: from the main function provide the measurement by keyboard reading
  Scanner in = new Scanner(System.in);
  out.print("S. Small" +
            "\nM. Standard/Medium" +
            "\nL. Large" +
            "\nEnter beverage size: ");
  size = in.nextLine();

  beverage.setSize(size);

  if(beverage.getSize().equals("S") || beverage.getSize().equals("Small") || beverage.getSize().equals("s")) 
   out.println(beverage2.getDescription() + " $" + beverage2.cost() + " -> Small size");
  else if(beverage.getSize().equals("M") || beverage.getSize().equals("Medium") || beverage.getSize().equals("M"))  {
   beverage_cost =(beverage2.cost() + (beverage2.cost() * 0.5f));
   out.println(beverage2.getDescription() + " $" + beverage_cost + " -> Standard/Medium size");
  }
  else if(beverage.getSize().equals("L") || beverage.getSize().equals("Large") || beverage.getSize().equals("l")) {
   beverage_cost = (2 * beverage2.cost());
   out.println(beverage2.getDescription() + " $" + beverage_cost + " -> Large size");
  }
  else
   out.println("Size not available");
 }
}

// Component
abstract class Beverage {
 String description = "Unknown beverage";
 String size = "Standard size";
 
 public String getDescription() {
  return description;
 }
 
 public String getSize() {
  return size;
 }

 public void setSize(String size) {
  this.size = size;
 }

 public abstract double cost();
}

// Decorator
abstract class CondimentDecorator extends Beverage {
 public abstract String getDescription();
} 

// Concret Components
class DarkRoast extends Beverage {
 public DarkRoast() {
  description = "Dark Roast Coffe";
 }

 @Override
 public double cost() {
  return 0.99;
 }
}

class HouseBlend extends Beverage {
 public HouseBlend() {
  description = "House Blend Coffe";
 }

 @Override
 public double cost() {
  return 0.89;
 }
}

class Decaf extends Beverage {
 public Decaf() {
  description = "Decaf Coffe";
 }

 @Override
 public double cost() {
  return 1.05;
 }
}

class Expresso extends Beverage {
 public Expresso () {
  description = "Expresso";
 }

 @Override
 public double cost() {
  return 1.99;
 }
}

// Concret Decorators
public class Milk extends CondimentDecorator {
 Beverage beverage;

 public Milk(Beverage beverage) {
  this.beverage = beverage;  
 }

 @Override
 public String getDescription() {
  return beverage.getDescription() + ", Milk";
 }
 
 @Override
 public double cost() {
  return beverage.cost() + 0.10;
 }
}

public class Mocha extends CondimentDecorator {
 Beverage beverage;

 public Mocha(Beverage beverage) {
  this.beverage = beverage;  
 }

 @Override
 public String getDescription() {
  return beverage.getDescription() + ", Mocha";
 }
 
 @Override
 public double cost() {
  return beverage.cost() + 0.20;
 }
}

public class Soy extends CondimentDecorator {
 Beverage beverage;

 public Soy(Beverage beverage) {
  this.beverage = beverage;  
 }

 @Override
 public String getDescription() {
  return beverage.getDescription() + ", Soy";
 }
 
 @Override
 public double cost() {
  return beverage.cost() + 0.15;
 }
}

public class Whip extends CondimentDecorator {
 Beverage beverage;

 public Whip(Beverage beverage) {
  this.beverage = beverage;  
 }

 @Override
 public String getDescription() {
  return beverage.getDescription() + ", Whip";
 }
 
 @Override
 public double cost() {
  return beverage.cost() + 0.10;
 }
}

// First option to set the Beverega size: Treat sizes as codiments
class Small extends CondimentDecorator {
 Beverage beverage;

 public Small(Beverage beverage) {
  this.beverage = beverage;
 }

 @Override
 public String getDescription() {
  return beverage.getDescription() + " -> Small size";
 }

 @Override
 public double cost() {
  return beverage.cost(); 
 }
}

class Standard extends CondimentDecorator {
 Beverage beverage;

 public Standard(Beverage beverage) {
  this.beverage = beverage;
 }

 @Override
 public String getDescription() {
  return beverage.getDescription() + " -> Medium/Standard size";
 }

 @Override
 public double cost() {
  return beverage.cost() + (0.5f * beverage.cost()); 
 }
}

class Large extends CondimentDecorator {
 Beverage beverage;

 public Large(Beverage beverage) {
  this.beverage = beverage;
 }

 @Override
 public String getDescription() {
  return beverage.getDescription() + " -> Large size";
 }

 @Override
 public double cost() {
  return 2 * beverage.cost(); 
 }
}