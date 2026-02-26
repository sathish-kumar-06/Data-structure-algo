package designpattern.factory;

public class CheesePizza implements Pizza{
    @Override
    public void prpare() {
        System.out.println("Preparing Cheese Pizzaa");
    }

    @Override
    public void bake() {
        System.out.println("Baking Pizzaa");
    }

    @Override
    public void cut() {
        System.out.println("Cutiing Pizzaa");
    }

    @Override
    public void pack() {
        System.out.println("Packing Pizzaa");
    }
}
