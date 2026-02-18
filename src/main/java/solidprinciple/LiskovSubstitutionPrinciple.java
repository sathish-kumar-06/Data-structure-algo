package solidprinciple;
//Subclasses should be replaceable for their parent class without breaking the program.
public class LiskovSubstitutionPrinciple {
//      Dont Do
        class Bird {
        public void fly() {
            System.out.println("Flying...");
        }
    }

    class Penguin extends Bird {
        @Override
        public void fly() {
            // ❌ Penguin can't fly! This breaks the contract of Bird
            throw new UnsupportedOperationException("Penguins can't fly!");
        }
    }

    // This will CRASH at runtime
    Bird bird = new Penguin();
//    bird.fly(); // ❌ Boom!

//    DO
// Separate the behaviors properly
interface BirdGood {
    void eat();
}

    interface FlyingBird extends BirdGood {
        void fly();
    }

    class Sparrow implements FlyingBird {
        public void eat() { System.out.println("Sparrow eating..."); }
        public void fly() { System.out.println("Sparrow flying..."); }
    }

    class PenguinSafe implements BirdGood {          // ✅ Penguin doesn't need to fly
        public void eat() { System.out.println("Penguin eating..."); }
    }

    // Now substitution is safe
    FlyingBird BirdGood = new Sparrow();
//    bird.fly(); // ✅ Works perfectly

}
