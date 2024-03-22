package creationalDesignPattern.fatorypattern;

public class FactoryDesignPattern {
    public static void main(String[] args) {
        Restaurant beefRestro = new BeefBurgerRestaurant();
        beefRestro.orderBurger();
        Restaurant veggieRestro = new VeggieBurgerRestaurant();
        veggieRestro.orderBurger();

    }
}
     abstract class Restaurant{
        public Burger orderBurger(){
            Burger burger= createBurger();
            burger.prepare();;
            return burger;
        }
        public abstract Burger createBurger();
    }
     class BeefBurgerRestaurant extends Restaurant{

        @Override
        public Burger createBurger() {
            return new BeefBurger();
        }
    }

     class VeggieBurgerRestaurant extends Restaurant{

        @Override
        public Burger createBurger() {
            return new VeggieBurger();
        }
    }
     interface  Burger{
        void prepare();
    }
     class VeggieBurger implements Burger{


        @Override
        public void prepare() {
            System.out.println("VeggieBurger preparing...");
        }
    }
     class BeefBurger implements Burger{


        @Override
        public void prepare() {
            System.out.println("BeefBurger preparing...");
        }
    }

