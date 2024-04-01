package Practice.behavioural.mediator;

import java.util.HashMap;
import java.util.Map;

public class MediatorDesignPattern {
    public static void main(String[] args) {
        Mediator mediator = new MediatorImpl();
        User sanjay = new User("sanjay", mediator);
        mediator.addUser(sanjay);
        User pal = new User("pal", mediator);
        mediator.addUser(pal);
        sanjay.send("Hi Pal", "pal");
        System.out.println("------------------------");
        sanjay.send("Hi Pal", "all");

    }
}

interface Mediator {
    public void sendMessage(String msg, String fromUser, String toUser);

    void addUser(User user);
}

class MediatorImpl implements Mediator {
    Map<String, User> userInfo;

    public MediatorImpl() {
        userInfo = new HashMap<>();
    }

    @Override
    public void sendMessage(String msg, String fromUser, String toUser) {
        if (userInfo.containsKey(toUser)) {
            userInfo.get(toUser).receiveMessage(msg, fromUser);
            return;
        }
        if ("All".equalsIgnoreCase(toUser)) {
            userInfo.values().forEach(user -> {
                if (!user.name.equalsIgnoreCase(fromUser))
                    user.receiveMessage(msg, fromUser);
            });
            return;
        }
        System.out.println("failed to send message");
    }

    @Override
    public void addUser(User user) {
        if (!userInfo.containsKey(user.name))
            userInfo.put(user.name, user);
        System.out.println("added user:" + user.name);
    }
}

class User {
    String name;
    Mediator mediator;

    public User(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    void receiveMessage(String message, String fromUser) {
        System.out.println("recieved:" + message + " from :" + fromUser);
    }

    void send(String message, String toUser) {
        System.out.println("sending message:" + message + " to:" + toUser);
        mediator.sendMessage(message, name, toUser);
    }
}