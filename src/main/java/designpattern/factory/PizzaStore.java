package designpattern.factory;

public class PizzaStore {
    SimplePizzaFactory simplePizzaFactory;

    public PizzaStore(SimplePizzaFactory simplePizzaFactory) {
        this.simplePizzaFactory = simplePizzaFactory;
    }

    public static void main(String[] args) {
        SimplePizzaFactory simplePizzaFactory1= new SimplePizzaFactory();
        PizzaStore pizzaStore= new PizzaStore(simplePizzaFactory1);
        pizzaStore.OrderPizza("Cheese");
    }

    private void OrderPizza(String pizzaStore) {
        Pizza pizza;
        pizza=simplePizzaFactory.createPizza(pizzaStore);
        pizza.prpare();
        pizza.bake();
        pizza.cut();
        pizza.pack();

    }
}
