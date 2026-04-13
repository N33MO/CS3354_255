package Module5.solid.lsp;

public class Demo4 {
    
}


// BEFORE
class Animal {
    public void eat()       { System.out.println("Eating..."); }
    public void makeSound() { System.out.println("..."); }
    public void fly()       { System.out.println("Flying..."); }
}

class Dog extends Animal {
    @Override
    public void makeSound() { System.out.println("Woof!"); }
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Dogs can't fly!");
    }
}

class Parrot extends Animal {
    @Override
    public void makeSound() { System.out.println("Squawk!"); }
    @Override
    public void fly()       { System.out.println("Parrot flying..."); }
}

// AFTER
interface Eater { void eat(); }
interface SoundMaker { void makeSound(); }
interface Flyer { void fly(); }

class Dog implements Eater, SoundMaker {
  public void eat() { System.out.println("Eating..."); }
  public void makeSound() { System.out.println("Woof!"); }
}

class Parrot implements Eater, SoundMaker, Flyer {
  public void eat() { System.out.println("Eating..."); }
  public void makeSound() { System.out.println("Squawk!"); }
  public void fly() { System.out.println("Parrot flying..."); }
}

class Fish implements Eater {
  public void eat() { System.out.println("Eating..."); }
}

class AnimalTrainer {
  public void train(Flyer animal) {
    animal.fly();
    // Dog, Fish, Snake cannot be
    // passed here — compile error
  }
}