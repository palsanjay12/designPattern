package Practice.behavioural.iterator;

import java.util.ArrayList;
import java.util.List;

public class IteratorDesignPattern {
    public static void main(String[] args) {
        NotificationManager notificationManager= new NotificationManager();
        notificationManager.add(new Notifications(Type.EMAIL,"message1"));
        notificationManager.add(new Notifications(Type.MOBILE,"message2"));
        notificationManager.add(new Notifications(Type.EMAIL,"message3"));
        Iterator iterator= notificationManager.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
enum Type{
    MOBILE,EMAIL
}
class Notifications{
    Type type;
    String message;

    @Override
    public String toString() {
        return "Notifications{" +
                "type=" + type +
                ", message='" + message + '\'' +
                '}';
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Notifications(Type type, String message) {
        this.type = type;
        this.message = message;
    }
}
class NotificationManager {
    List<Notifications> notifications;
    public NotificationManager(){
        notifications= new ArrayList<>();
    }
    void add(Notifications notification){
        notifications.add(notification);
    }
    boolean remove(Notifications notification){
        if(notifications.contains(notification)){
            notifications.remove(notification);
            return true;
        }
        return false;
    }
    public Iterator iterator(){
        return new NotificationIterator(notifications);
    }
}
interface Iterator{
    boolean hasNext();
    Notifications next();
}
class NotificationIterator implements Iterator{

    List<Notifications> notifications;
    int pos=0;
    public NotificationIterator(List<Notifications> notifications) {
        this.notifications = notifications;
        pos=0;
    }

    @Override
    public boolean hasNext() {
        if(pos<notifications.size())
                return true;
        return false;
    }

    @Override
    public Notifications next() {
        if(hasNext()){
            pos++;
          return   notifications.get(pos-1);
        }
        return null;
    }
}