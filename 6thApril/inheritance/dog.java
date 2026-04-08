package inheritance;

public class dog extends Animal {
    void bark(){
        System.out.println("Dog is barking...");
    }


public static void main(String[] args) {
    dog obj = new dog();
    obj.eat(); 
    obj.bark(); 
       }
}