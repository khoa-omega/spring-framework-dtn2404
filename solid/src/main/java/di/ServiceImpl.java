package di;

// @Service
public class ServiceImpl implements Service {
    private Repository repository;

    public ServiceImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void findAll() {
        System.out.println("Service find all");
        repository.findAll();
    }
}
