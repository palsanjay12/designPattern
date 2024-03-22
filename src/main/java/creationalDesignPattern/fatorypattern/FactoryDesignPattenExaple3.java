package creationalDesignPattern.fatorypattern;

public class FactoryDesignPattenExaple3 {
    public static void main(String[] args) {
        Company company1= new MsiManufactorer();
        company1.assempleGpu();
       Company company2= new AsusManufactorer();
        company2.assempleGpu();
    }
}
class MsiManufactorer extends Company {

    @Override
    public Gpu createGpu() {
        return new MsiGpu();
    }
}
class AsusManufactorer extends Company {

    @Override
    public Gpu createGpu() {
        return new AsusGpu();
    }
}

abstract class Company{
    public Gpu assempleGpu(){
        Gpu gpu= createGpu();
        gpu.assemple();
        return gpu;
    }
    public abstract Gpu createGpu();
}
interface Gpu{
    void assemple();
}
class MsiGpu implements Gpu{

    @Override
    public void assemple() {
        System.out.println("MSI gpu assembled");
    }
}
class AsusGpu implements Gpu{

    @Override
    public void assemple() {
        System.out.println("AsusGpu gpu assembled");
    }
}