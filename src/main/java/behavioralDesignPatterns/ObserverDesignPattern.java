package behavioralDesignPatterns;

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
        notificationService.notofyAll();
        notificationService.unsubscribe(emailMsgListener);

        notificationService.notofyAll();

    }
}
class Store{
    private final NotificationService notificationService;
    public Store(NotificationService notificationService){
        this.notificationService=notificationService;
    }

}
interface EventListener{
    void sendNotification();
}
class EmailMsgListener implements EventListener{
    String email;
    public EmailMsgListener(String email){
        this.email=email;
    }
    public void sendNotification(){
        System.out.println("sending emaim notifcation to:"+ email);
    }
}
class MobileAppListener implements EventListener{
    String userName;
    public MobileAppListener(String userName){
        this.userName=userName;
    }
    public void sendNotification(){
        System.out.println("sending mobile push notifcation to:"+ userName);
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
    public void notofyAll(){
        subscriber.forEach(eventListener -> eventListener.sendNotification());
    }
}