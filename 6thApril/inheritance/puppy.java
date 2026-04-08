package inheritance;

public class puppy extends dog {
    void weep(){
        System.out.println("Puppy is weeping...");
    }

    public static void main(String[] args) {
        puppy obj = new puppy();
        obj.eat(); 
        obj.bark(); 
        obj.weep(); 
    }
}
