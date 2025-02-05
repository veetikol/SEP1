import java.util.ArrayList;

public class Library {
    private ArrayList<String> books;

    public Library(ArrayList<String> books) {
        this.books = books;
    }

    public void addBook(String book) {
        books.add(book);
    }

    public void removeBook(String book) {
        books.remove(book);
    }

    public ArrayList<String> listBooks() {
        return books;
    }
}
