#include <iostream>

using namespace std;

// Classes
// Target interface
class Duck {
 public:
  virtual void quack() {
   cout << "Quack!\n";
  }

  virtual void fly() {
   cout << "I'm flying.\n";
  }
};

// Adaptee interface
class Turkey {
 public:
  virtual void gobble() {
   cout << "Gobble gobble\n";
  }
  
  virtual void fly() {
   cout << "I'm flying a short distance.\n";
  }
};

// Adapter
class TurkeyAdapter: public Duck, public Turkey {
 public:
  void gobble() {
   cout << "Glu glu glu\n";
  }
  void quack() {
   gobble();
  }
  void fly() {
   for(int i = 0; i <= 4; i ++)
    Turkey::fly();
  }
};

// Client
void testDuck(Duck &duck) {
 duck.quack();
 duck.fly();
}

int
main() { 
 Duck* turkey = new TurkeyAdapter;
 cout << "\nThe turkey adapter says...\n";
 testDuck(*turkey);

 return 0;
}

