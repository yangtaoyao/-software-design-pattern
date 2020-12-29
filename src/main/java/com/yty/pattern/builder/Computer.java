package com.yty.pattern.builder;


//@Builder
//@Data
public class Computer {
    private String cpu;//必须
    private String ram;//必须
    private int usbCount;//可选
    private String keyboard;//可选
    private String display;//可选

    public Computer(ComputerBuilder builder){
        cpu = builder.cpu;
        ram = builder.ram;
        usbCount = builder.usbCount;
        keyboard = builder.keyboard;
        display = builder.display;
    }

    public static class ComputerBuilder{
        private Computer computer;
        private String cpu;//必须
        private String ram;//必须
        private int usbCount;//可选
        private String keyboard;//可选
        private String display;//可选

        public ComputerBuilder(){
        }


        public ComputerBuilder setComputer(Computer computer) {
            this.computer = computer;
            return this;
        }

        public ComputerBuilder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public ComputerBuilder setRam(String ram) {
            this.ram = ram;
            return this;
        }
        public ComputerBuilder setUsbCount(int usbCount) {
            this.usbCount = usbCount;
            return this;
        }
        public ComputerBuilder setKeyboard(String keyboard) {
            this.keyboard = keyboard;
            return this;
        }

        public ComputerBuilder setDisplay(String display) {
            this.display = display;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }

        // --------------

        public Computer getComputer() {
            return computer;
        }
        public String getCpu() {
            return cpu;
        }

        public String getRam() {
            return ram;
        }

        public int getUsbCount() {
            return usbCount;
        }

        public String getDisplay() {
            return display;
        }

        public String getKeyboard() {
            return keyboard;
        }

    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public int getUsbCount() {
        return usbCount;
    }

    public void setUsbCount(int usbCount) {
        this.usbCount = usbCount;
    }

    public String getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }
}
