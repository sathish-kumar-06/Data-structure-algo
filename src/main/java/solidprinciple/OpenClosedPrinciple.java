package solidprinciple;

// Classes should be open for extension, but closed for modification.
public class OpenClosedPrinciple {

    //Dont Do
    public double apply(String userType, double price) {
        if (userType.equals("student")) {
            return price * 0.8;
        } else if (userType.equals("senior")) {
            return price * 0.7;
        }
        // ❌ Every new discount type forces us to modify this class
        return price;
    }

    //    DO
    interface Discount {
        double apply(double price);
    }

    // Each discount type is a new class — no modification needed
    class StudentDiscount implements Discount {
        public double apply(double price) {
            return price * 0.8;
        }
    }

    class SeniorDiscount implements Discount {
        public double apply(double price) {
            return price * 0.7;
        }
    }

    class VIPDiscount implements Discount {     // ✅ Just add a new class!
        public double apply(double price) {
            return price * 0.5;
        }
    }

    // Usage
    class OrderService {
        public double getFinalPrice(Discount discount, double price) {
            return discount.apply(price); // Works with ANY discount type
        }

    }

}
