import java.util.*;
import static java.lang.System.*;

public class PizzaFactoriesStyle {
 public static void main(String[] args) {
  Pizza pizza;
  PizzaStore pizza_store;

  /* Pizza New York */
  pizza_store = new NYPizzaStore();
  pizza = pizza_store.orderPizza("cheese");
  out.println(pizza);

  /* Pizza New York */
  pizza_store = new ChicagoPizzaStore();
  pizza = pizza_store.orderPizza("cheese");
  out.println(pizza);
 } 
}

// Classes
abstract class PizzaStore {
 PizzaFactory factory = new PizzaFactory();  
 Pizza pizza;
 String style = "simple";

 public String getStyle() {
  return style; 
 }

 public Pizza orderPizza(String type) {
  return factory.createPizza(type, style);
 }
}

class NYPizzaStore extends PizzaStore {
 public NYPizzaStore() {
  style = "hand-tossed thin crust";
 }

 public Pizza orderPizza(String type) {
  pizza = factory.createPizza(type, style);
  if(pizza != null) {
   out.println("\n\n--------------- Pizza New York style --------------");
   pizza.addToppingStyle(style);
  }
  return pizza;
 }
}

class ChicagoPizzaStore extends PizzaStore {
 public ChicagoPizzaStore() {
  style = "deep-dish";
 }
  
 public Pizza orderPizza(String type) {
  pizza = factory.createPizza(type, style);
  if(pizza != null) {
   out.println("\n\n--------------- Pizza Chicago style --------------");
   pizza.addToppingStyle(style);
  }
  return pizza;
 }
}

// Factory
// Factory
class PizzaFactory {
 Pizza pizza;

 public void pizzaSteps() {
  pizza.prepare();
  pizza.bake();
  pizza.cut();
  pizza.box();
 }

 public Pizza createPizza(String type, String style) {
  switch(type) {
   case "cheese":
    pizza  = new CheesePizza();
    pizzaSteps();
   break;
   case "pepperoni":
    pizza  = new PepperoniPizza();
    pizzaSteps();
   break;
   case "veggie":
    pizza  = new VeggiePizza();
    pizzaSteps();
   break;
   case "clam":
    pizza  = new ClamPizza();
    pizzaSteps();
   break;
   default:
    out.println("Soon, that taste ;) (Ask it to our service client)");
  }  
  
  return pizza;
 }
}

// Pizza
abstract class Pizza {
 String name;
 List<String> toppings = new ArrayList<String>();
 
 public String getName() {
  return name;
 }

 public void prepare() {
   out.println("... ");
   out.println("Preparing " + name);
 }

 public void bake() {
   out.println("... ");
   out.println("Baking " + name);
 }

 public void cut() {
    out.println("... ");
    out.println("Cutting " + name);
 }

 public void box() {
    out.println("... ");
    out.println("Boxing " + name);
    out.println("... ");
 }

 public void addToppingStyle(String topping) {
  toppings.add("Our unique touch : " + topping + ", OUR ORIGINAL STYLE");
 }

 public String toString() {
  StringBuffer display = new StringBuffer();
  out.println(" **** " + name + " with " + "toppings: *** ");

  for(String topping : toppings)
   display.append("\t" + topping + "\n");
  display.append("It's ready to eat or take away!!!!");

  return display.toString();
 }
}

// Sub-classes from Pizza - Pizzas on the menu
class CheesePizza extends Pizza {
 public CheesePizza() {
  name = "Cheese Pizza";
  toppings.add("Mozzarella");
  toppings.add("Parmesan");
  toppings.add("Provolone");
  toppings.add("Cheddar");
  toppings.add("Ricotta");
  toppings.add("Romano");
  toppings.add("Crisp border");
 }
}

class PepperoniPizza extends Pizza {
 public PepperoniPizza() {
  name = "Pepperoni Pizza";
  toppings.add("Mozzarella");
  toppings.add("Parmesan");
  toppings.add("Pepperoni");
  toppings.add("Onion");
  toppings.add("spices");
  toppings.add("Cheese filled border");
 } 
}

class VeggiePizza extends Pizza {
 public VeggiePizza() {
  name = "Veggie Pizza";
  toppings.add("Mozzarella");
  toppings.add("Parmesan");
  toppings.add("Zucchini");
  toppings.add("bell peppers");
  toppings.add("brocolli");
  toppings.add("spinach");
  toppings.add("toasted border");
 } 
}

class ClamPizza extends Pizza {
 public ClamPizza() {
  name = "Veggie Pizza";
  toppings.add("Mozzarella");
  toppings.add("clam");
  toppings.add("Roasted red peppers");
  toppings.add("Grilled eggplant");
  toppings.add("Roasted fennel");
  toppings.add("toasted border");
 } 
}

