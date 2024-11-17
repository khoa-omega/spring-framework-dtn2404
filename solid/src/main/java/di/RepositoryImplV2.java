package di;

// @Repository
// @Primary
public class RepositoryImplV2 implements Repository {
    @Override
    public void findAll() {
        System.out.println("RepositoryV2 find all");
    }
}
