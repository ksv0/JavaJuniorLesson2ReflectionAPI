package ksv.task1;

public class Dog extends Animal {
    public boolean isGoodBoy;
    public Dog(String name, boolean isGoodBoy) {
        super(name);
        this.isGoodBoy = isGoodBoy;
    }
    public boolean getIsGoodBoy() {
        return isGoodBoy;
    }

}
