package Practice.behavioural.observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverDesignPattern {

    public static void main(String[] args) {
        NotificationService notificationService= new NotificationService();
        Store store= new Store(notificationService);
        EventListener emailMsgListener= new EmailMsgListener("sanjay.pal@aa");
        EventListener mobileAppListener= new MobileAppListener("sanjay.pal");

        notificationService.subscribe(emailMsgListener);
        notificationService.subscribe(mobileAppListener);
        store.addProduct("Pen");

        notificationService.unsubscribe(emailMsgListener);
        store.addProduct("Paper");

    }
}
class Store{

    private final NotificationService notificationService;
    public Store(NotificationService notificationService){
        this.notificationService=notificationService;
    }
    public void addProduct(String name){
        System.out.println("Added product:"+ name);
        notificationService.notofyAll("Store has new product: "+ name);
    }

}
interface EventListener{
    void sendNotification(String message);
}
class EmailMsgListener implements EventListener{
    String email;
    public EmailMsgListener(String email){
        this.email=email;
    }
    public void sendNotification(String message){
        System.out.println("sending emaim notifcation to:"+ email+" message:"+ message);
    }
}
class MobileAppListener implements EventListener{
    String userName;
    public MobileAppListener(String userName){
        this.userName=userName;
    }
    public void sendNotification(String message){
        System.out.println("sending mobile push notifcation to:"+ userName+" message:"+message);
    }
}
class NotificationService{
    List<EventListener> subscriber;
    public  NotificationService(){
        subscriber= new ArrayList<>();
    }
    public void subscribe(EventListener email){
        subscriber.add(email);
    }
    public void unsubscribe(EventListener emailMsgListener){
        subscriber.remove(emailMsgListener);
    }
    public void notofyAll(String message){
        subscriber.forEach(eventListener -> eventListener.sendNotification(message));
    }
}