package inheritance;

public class Cat extends Animal {
    void meow() {
        System.out.println("Cat is meowing...");
    }

    public static void main(String[] args) {
        Cat obj = new Cat();
        obj.eat();
        obj.meow();
    }
}
