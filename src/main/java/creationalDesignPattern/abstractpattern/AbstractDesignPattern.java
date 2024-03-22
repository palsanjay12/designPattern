package creationalDesignPattern.abstractpattern;

public class AbstractDesignPattern {
    public static void main(String[] args) {
        Company asusCompony= new AsusManufactorer();
        asusCompony.assempleGpu();
        asusCompony.assempleMonitor();
        Company msiCompany = new MsiManufactorer();
        msiCompany.assempleMonitor();
        msiCompany.assempleGpu();
    }
}
abstract class Company{
    void assempleGpu(){
        Gpu gpu= createGpu();
        gpu.assemple();
    }
    void assempleMonitor(){
        Monitor monitor= createMonitor();
        monitor.assemple();
    }
    abstract Gpu createGpu();
    abstract Monitor createMonitor();
}
interface Monitor{
    void assemple();
}
class MsiMonitor implements Monitor {

    @Override
    public void assemple() {
        System.out.println("MSI monitor assembled");
    }
}
class AsusMonitor implements Monitor {

    @Override
    public void assemple() {
        System.out.println("Asus monitor assembled");
    }
}
interface Gpu{
    void assemple();
}
class MsiGpu implements Gpu {

    @Override
    public void assemple() {
        System.out.println("MSI gpu assembled");
    }
}
class AsusGpu implements Gpu {

    @Override
    public void assemple() {
        System.out.println("Asus gpu assembled");
    }
}
class AsusManufactorer extends Company{

    @Override
    Gpu createGpu() {
        return new AsusGpu();
    }

    @Override
    Monitor createMonitor() {
        return new AsusMonitor();
    }
}

class MsiManufactorer extends Company{

    @Override
    Gpu createGpu() {
        return new MsiGpu();
    }

    @Override
    Monitor createMonitor() {
        return new MsiMonitor();
    }
}
