package behavioralDesignPatterns;

public class TemplateDesignPattern {
    public static void main(String[] args) {
        Trip trip1= new PackageA();
        trip1.performTrip();
        Trip trip2= new PackageB();
        trip2.performTrip();
        Trip trip3= new PackageC();
        trip3.performTrip();
    }
}
 abstract class Trip {
    public final void performTrip(){
        doComingTransport();
        doDayA();
        doDayB();
        doDayC();
        giveGift();
        doReturningTransport();
    }
     protected   abstract void doComingTransport();
     protected abstract void doDayA();
     protected abstract void doDayB();
     protected abstract void doDayC();
     void giveGift(){
         System.out.println("suprise gift is mobile");
     }
     protected abstract void doReturningTransport();
}

 class PackageA extends Trip {
    public void doComingTransport() {
        System.out.println("The turists are comming by air ...");
    }
    public void doDayA() {
        System.out.println("The turists are visiting the aquarium ...");
    }
    public void doDayB() {
        System.out.println("The turists are going to the beach ...");
    }
    public void doDayC() {
        System.out.println("The turists are going to mountains ...");
    }
     void giveGift(){
         System.out.println("suprise gift is laptop");
     }
    public void doReturningTransport() {
        System.out.println("The turists are going home by air ...");
    }
}
 class PackageB extends Trip {
     public void doComingTransport() {
         System.out.println("The turists are comming by train ...");
     }

     public void doDayA() {
         System.out.println("The turists are visiting the mountain ...");
     }

     public void doDayB() {
         System.out.println("The turists are going to the beach ...");
     }

     public void doDayC() {
         System.out.println("The turists are going to zoo ...");
     }

     void giveGift() {
         System.out.println("no suprise gift");
     }

     public void doReturningTransport() {
         System.out.println("The turists are going home by train ...");
     }
 }
     class PackageC extends Trip {
         public void doComingTransport() {
             System.out.println("The turists are comming by train ...");
         }
         public void doDayA() {
             System.out.println("The turists are visiting the mountain ...");
         }
         public void doDayB() {
             System.out.println("The turists are going to the beach ...");
         }
         public void doDayC() {
             System.out.println("The turists are going to zoo ...");
         }

         public void doReturningTransport() {
             System.out.println("The turists are going home by train ...");
         }
}