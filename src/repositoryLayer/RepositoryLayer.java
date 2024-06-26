package repositoryLayer;

import modelLayer.Book;
import ourFirstProject.util.MyLinkedList;
import ourFirstProject.util.MyList;

import java.util.concurrent.atomic.AtomicInteger;

public class RepositoryLayer {

    private static boolean Book;
    private final MyList<Book> books;
    private final AtomicInteger currentId;

    public RepositoryLayer() {
        this.books = new MyLinkedList<>();
        this.currentId = new AtomicInteger(0);
        initBook();
    }

    private void initBook() {
        addBook(new Book("Война и мир", "Толстой.Л.Н", currentId.getAndIncrement()));
    }

    public void addBook(Book book) {
        book.setBookId(currentId.incrementAndGet());
        books.add(book);
    }

    public Book removeBook(int bookId) {
        Book book = findBookById(bookId);
        if (book != null) {
            books.remove(book);
        }
        return book;
    }

    public Book findBookById(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    public void updateBook(int bookId, Book updatedBook) {
        Book book = findBookById(bookId);
        if (book != null) {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
        }
    }

    public MyList<Book> getAllBooks() {
        return books;
    }

}

