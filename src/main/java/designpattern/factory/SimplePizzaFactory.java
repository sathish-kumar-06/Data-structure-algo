package designpattern.factory;

import javax.lang.model.type.UnknownTypeException;

public class SimplePizzaFactory {
    public Pizza createPizza(String pizzaType) {
        Pizza pizza = null;
        if (pizzaType.equalsIgnoreCase("cheese")) {
            pizza = new CheesePizza();
        } else {
            throw new IllegalArgumentException("Unknow Pizza: " + pizzaType);
        }
        return pizza;
    }
}
