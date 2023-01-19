public class DuckTest {

  public static void main(String[] args) {
    Duck mallardDuck, redHeadDuck, decoyDuck, rubberDuck;
    // Initializations
    mallardDuck = new MallardDuck(); mallardDuck.showDuck();
    redHeadDuck = new RedHeadDuck(); redHeadDuck.showDuck();
    decoyDuck   = new DecoyDuck();   decoyDuck.showDuck();
    rubberDuck  = new RubberDuck();  rubberDuck.showDuck();
  }  
}

  // Interfaces
  // Fly Interface (Supertype)
  interface FlyBehavior {
   public void fly();
  }
  // Subtypes
  class FlyWithWings implements FlyBehavior {
   public void fly() {
    System.out.println("I'm flying");  
   }
  }
  class FlyNoWay implements FlyBehavior {
   public void fly() {
    System.out.println("I can't fly");  
   }
  }
  class FlyWithBalloon implements FlyBehavior {
   public void fly() {
    System.out.println("I can fly with the help of a balloon!"); 
   }
  }

  // Quack Interface (Supertype)
  interface QuackBehavior {
   public void quack();
  }
  // Subtypes
  class Quack implements QuackBehavior {
   public void quack() {
    System.out.println("Quack");  
   }
  }
  class Squeak implements QuackBehavior {
   public void quack() {
    System.out.println("Squeak");  
   }
  }
  class MuteQuack implements QuackBehavior {
   public void quack() {
    System.out.println("<<silence>>"); 
   }
  }

  // Classes
  // Superclass Duck
  class Duck {
    protected FlyBehavior fb;
    protected QuackBehavior qb;

    private void swim() {
     System.out.println("All ducks float, even decoys!");
    }
    public void display() {
    }
    private void performQuack() {
     qb.quack();
    }
    private void performFly() {
     fb.fly();
    }
    public void showDuck() {
     swim();
     display();
     performQuack();
     performFly();
    }
  } 

  // Subclasses
  class MallardDuck extends Duck {
   public MallardDuck() {
    qb = new Quack();
    fb = new FlyWithWings();
   }
   public void display() {
    System.out.println("I'm a real Mallard Duck");
   }  
  }
  class RedHeadDuck extends Duck {
   public RedHeadDuck() {
    qb = new Quack();
    fb = new FlyWithWings();
   }
   public void display() {
    System.out.println("I'm real RedHeadDuck");
   }
  }
  class DecoyDuck extends Duck {
   public DecoyDuck() {
    qb = new MuteQuack();
    fb = new FlyNoWay();
   }
   public void display() {
    System.out.println("I'm a simple Decoy duck");
   }
  }
  class RubberDuck extends Duck {
   public RubberDuck() {
    qb = new Squeak();
    fb = new FlyWithBalloon();
   }
   public void display() {
    System.out.println("I'm pretty Rubber duck");
   }
  }