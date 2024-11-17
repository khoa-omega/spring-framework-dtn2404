package solid.o;

class PostRepositoryV1 {
    public void findAll() {
        // ...
    }
}

final class PostRepositoryV2 extends PostRepositoryV1 {
    @Override
    public void findAll() {
        // ...
    }

    public void findById() {
        // ...
    }
}

class PostRepositoryV3 {
    private PostRepositoryV2 repository;

    public void findAll() {
        repository.findAll();
    }

    public void findById() {
        // ...
    }
}

public class OpenClosedDemo {
    public static void main(String[] args) {
        // Open / Closed
        // Mở rộng mà không làm thay đổi code cũ
        PostRepositoryV2 repository = new PostRepositoryV2();
        repository.findAll();
        repository.findById();
    }
}
