package solid.i;

interface IAnimal {
    void fly();
    void run();
    void swim();
    void jump();
}

interface Flyable {
    void fly();
}

interface Runnable {
    void run();
}

interface Swimmable {
    void swim();
}

interface Jumpable {
    void jump();
}

public class InterfaceSegregationDemo {
    public static void main(String[] args) {
        // Interface Segregation
        // Chia một interface lớn thành nhiều interface nhỏ
        // với từng mục đích cụ thể
    }
}
