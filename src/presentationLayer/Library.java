package presentationLayer;

import modelLayer.Book;
import repositoryLayer.RepositoryLayer;

public class Library {

    public static void main(String[] args) {
        Library library = new Library();
        library.runLibrary();
    }

    public void runLibrary() {
        RepositoryLayer repository = new RepositoryLayer();
        Book addedBook = repository.findBookById(1);
        if (addedBook != null) {
            System.out.println("Added book: " + addedBook);
        } else {
            System.out.println("No book found with the specified ID.");
        }
    }
}
