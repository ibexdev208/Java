package error_old;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(String id) {
        super("Book id not found : " + id);
    }
}
