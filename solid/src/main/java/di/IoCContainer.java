package di;

public class IoCContainer {
    public Repository repository() {
        return new RepositoryImpl();
    }

    public Repository repositoryV2() {
        return new RepositoryImplV2();
    }

    public Service service() {
        Repository repository = repositoryV2();
        return new ServiceImpl(repository);
    }

    public Controller controller() {
        Service service = service();
        return new Controller(service);
    }
}
