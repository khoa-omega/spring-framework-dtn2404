package di;

// @Repository
public class RepositoryImpl implements Repository {
    @Override
    public void findAll() {
        System.out.println("Repository find all");
    }
}
