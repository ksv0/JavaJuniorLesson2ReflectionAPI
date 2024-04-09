package ksv.task1;

public class Fox extends Animal {
    private final int count;
    public Fox(String name, int count) {
        super(name);
        this.count = count;
    }
    public void makeSound() {
        int i = 0;
        String s = "";
        while (i < count) {
            s+="вуп-";
            i++;
        }
        System.out.println(s.substring(0, s.length()-1));
    }
}
