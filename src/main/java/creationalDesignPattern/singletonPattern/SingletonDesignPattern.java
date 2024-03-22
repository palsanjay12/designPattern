package creationalDesignPattern.singletonPattern;

public class SingletonDesignPattern {
//    private static SingletonDesignPattern singletonDesignPattern; // a shared varible can be partially created and
                                                                // can be refrence to avoid such issue we need make our avribale
                                                                //volatile
    private String url;
    private static volatile SingletonDesignPattern singletonDesignPattern;
    private SingletonDesignPattern(String url) {
        this.url = url;
    }

    public SingletonDesignPattern getInstance(String url) {
        if (singletonDesignPattern == null) {
            singletonDesignPattern = new SingletonDesignPattern(url);
        }
        return singletonDesignPattern;
    }

    public SingletonDesignPattern getInstanceInCaseOfMultiThreading(String url) {
        synchronized (SingletonDesignPattern.class) {// even instance is created everythread has to wait
            if (singletonDesignPattern == null) {
                singletonDesignPattern = new SingletonDesignPattern(url);
            }
        }
        return singletonDesignPattern;
    }

    public SingletonDesignPattern getInstanceInCaseOfMultiThreadingDoubleCheckedLockingIdiom(String url) {
        if(singletonDesignPattern==null) {// the above problem is resolved
            synchronized (SingletonDesignPattern.class) {
                if (singletonDesignPattern == null) {
                    singletonDesignPattern = new SingletonDesignPattern(url);
                }
            }
        }
        return singletonDesignPattern;
    }
    public SingletonDesignPattern getInstanceInCaseOfMultiThreadingDoubleCheckedLockingIdiomEnhancePerformance(String url) {
        SingletonDesignPattern result= singletonDesignPattern;// this will improve the performance
        if(result==null) {// the above problem is resolved
            synchronized (SingletonDesignPattern.class) {
                result= singletonDesignPattern;
                if (result == null) {
                    singletonDesignPattern = result=new SingletonDesignPattern(url);
                }
            }
        }
        return result;
    }
}
