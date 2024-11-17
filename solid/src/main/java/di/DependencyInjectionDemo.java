package di;

public class DependencyInjectionDemo {
    public static void main(String[] args) {
        IoCContainer container = new IoCContainer();
        Controller controller = container.controller();
        controller.findAll();
    }
}
