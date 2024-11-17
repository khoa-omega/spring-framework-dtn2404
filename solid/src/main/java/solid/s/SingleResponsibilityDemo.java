package solid.s;

class Book {
    private String title;

    // Book không thể tự in chính mình
    // Cần tạo BookPrinter
    public void print() {
        System.out.println(title);
    }

    public String getTitle() {
        return title;
    }
}

class BookPrinter {
    public void printBook(Book book) {
        System.out.println(book.getTitle());
    }
}

public class SingleResponsibilityDemo {
    public static void main(String[] args) {
        // Single Responsibility
        // Một class chỉ có một trách nhiệm
    }
}
