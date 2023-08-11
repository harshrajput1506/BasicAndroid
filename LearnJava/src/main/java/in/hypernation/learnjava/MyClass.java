package in.hypernation.learnjava;

public class MyClass {
    public static void main(String[] args) {

        Animal tiger = new Animal("tiger", 2);
        Human harsh = new Human("male", 18);
        harsh.setName("Harsh Rajput");
        harsh.setType(1);
        int num = 24757396;
        long num1 = 265656995;
        float pif = 3.14f;
        double pi = 3.1;
        String name = "Harsh";
        System.out.println("Hello World" + name + num + num1 + pif + pi);
        System.out.println(tiger.getName() + " " + harsh.getName());
    }
}