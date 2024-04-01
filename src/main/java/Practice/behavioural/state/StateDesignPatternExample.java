package Practice.behavioural.state;

public class StateDesignPatternExample {
    public static void main(String[] args) {
        OrderState newOrder = new New();
        Item item = new Item(newOrder);
        item.action();
        item.setOrderState(new Purchase());
        item.action();
        item.setOrderState(new Payment());
        item.action();
        item.setOrderState(new Transit());
        item.action();
        item.setOrderState(new Delivered());
        item.action();
    }

}

class Item {
    OrderState orderState;

    public Item(OrderState orderState) {
        this.orderState = orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public void action() {
        orderState.action();
    }
}

interface OrderState {
    public void action();
}

class New implements OrderState {

    @Override
    public void action() {
        System.out.println("Item is in new State");
    }
}

class Purchase implements OrderState {
    @Override
    public void action() {
        System.out.println("Item is in purchase");
    }
}

class Payment implements OrderState {
    @Override
    public void action() {
        System.out.println("Item is in Payment");
    }
}

class Transit implements OrderState {
    @Override
    public void action() {
        System.out.println("Item is in Transit");
    }
}

class Delivered implements OrderState {
    @Override
    public void action() {
        System.out.println("Item is in Delivered");
    }
}