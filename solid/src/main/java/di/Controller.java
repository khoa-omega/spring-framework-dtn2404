package di;

// @Controller
public class Controller {
    private Service service;

    public Controller(Service service) {
        this.service = service;
    }

    public void findAll() {
        System.out.println("Controller find all");
        service.findAll();
    }
}
