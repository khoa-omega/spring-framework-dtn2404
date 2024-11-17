package solid.l;

class Animal {
    public void eat() {
    }
}

class Dog extends Animal {
}

class Cat extends Animal {
    @Override
    public void eat() {
        // Không tuân thủ nguyên tắc
        throw new IllegalStateException();
    }
}

public class LiskovSubstitutionDemo {
    public static void main(String[] args) {
        // Liskov Substitution
        // Đối tượng của lớp con có thể thay thế cho lớp cha
        // mà không làm thay đổi tính đúng đắn
        Dog dog = new Dog();
        Cat cat = new Cat();
        feed(dog);
        feed(cat);
    }

    public static void feed(Animal animal) {
        animal.eat();
    }
}
