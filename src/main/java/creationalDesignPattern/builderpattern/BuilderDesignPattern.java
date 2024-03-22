package creationalDesignPattern.builderpattern;

public class BuilderDesignPattern {
    public static void main(String[] args) {
        Computer model1 = new Computer.ComputerBuilder(
                "1 TB", "16 GB", "15.6")
                .setBluetoothEnabled(true)
                .setGraphicsCardEnabled(true)
                .setTouchScreenEnabled(true)
                .setWebCamEnabled(true)
                .build();
        System.out.println("model1: " + model1.toString());

        Computer model2 = new Computer.ComputerBuilder(
                "256 GB", "8 GB", "14.6")
                .setBluetoothEnabled(true)
                .setGraphicsCardEnabled(true)
                .build();
        System.out.println("model2: " + model2.toString());


        Computer model3 = new Computer.ComputerBuilder(
                "128 GB", "4 GB", "13.6")
                .build();
        System.out.println("model3: " + model3.toString());
    }

}


class Computer{
    private String HDD;
    private String RAM;
    private String screenSize;

    //optional parameters
    private boolean isGraphicsCardEnabled;
    private boolean isBluetoothEnabled;
    private boolean isWebCamEnabled;
    private boolean isTouchScreenEnabled;

    public String getHDD() {
        return HDD;
    }

    public String getRAM() {
        return RAM;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public boolean isGraphicsCardEnabled() {
        return isGraphicsCardEnabled;
    }

    public boolean isBluetoothEnabled() {
        return isBluetoothEnabled;
    }

    public boolean isWebCamEnabled() {
        return isWebCamEnabled;
    }

    public boolean isTouchScreenEnabled() {
        return isTouchScreenEnabled;
    }
    @Override
    public String toString() {
        return "Computer{" +
                "HDD='" + HDD + '\'' +
                ", RAM='" + RAM + '\'' +
                ", screenSize='" + screenSize + '\'' +
                ", isGraphicsCardEnabled=" + isGraphicsCardEnabled +
                ", isBluetoothEnabled=" + isBluetoothEnabled +
                ", isWebCamEnabled=" + isWebCamEnabled +
                ", isTouchScreenEnabled=" + isTouchScreenEnabled +
                '}';
    }
    private Computer(ComputerBuilder builder) {
        this.HDD = builder.HDD;
        this.RAM = builder.RAM;
        this.screenSize = builder.screenSize;
        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
        this.isTouchScreenEnabled = builder.isTouchScreenEnabled;
        this.isWebCamEnabled = builder.isWebCamEnabled;
        this.isWebCamEnabled = builder.isWebCamEnabled;
    }
    static class ComputerBuilder{
        private String HDD;
        private String RAM;
        private String screenSize;

        //optional parameters
        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;
        private boolean isWebCamEnabled;
        private boolean isTouchScreenEnabled;

        public ComputerBuilder(String hdd, String ram, String screenSize) {
            this.HDD = hdd;
            this.RAM = ram;
            this.screenSize = screenSize;
        }

        public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
            this.isGraphicsCardEnabled = isGraphicsCardEnabled;
            return this;
        }

        public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        public ComputerBuilder setWebCamEnabled(boolean webCamEnabled) {
            isWebCamEnabled = webCamEnabled;
            return this;
        }

        public ComputerBuilder setTouchScreenEnabled(boolean touchScreenEnabled) {
            isTouchScreenEnabled = touchScreenEnabled;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

}
