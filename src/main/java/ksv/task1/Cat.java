package ksv.task1;

public class Cat extends Animal {
    private int sleepDuration;
    public Cat(String name, int sleepDuration) {
        super(name);
        this.sleepDuration = sleepDuration;
    }

    public int getSleepDuration() {
        return sleepDuration;
    }

    private void makeSound() {
        System.out.println("Мяу");
    }
}
