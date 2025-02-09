import java.util.*;

// Book class with basic properties
class Book {
    String title, author, ISBN;
    boolean isBorrowed;

    Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isBorrowed = false;
    }
}

// User class representing a library member
class User {
    String name, userID;
    List<Book> borrowedBooks;

    User(String name, String userID) {
        this.name = name;
        this.userID = userID;
        this.borrowedBooks = new ArrayList<>();
    }
}

// Library System
class Library {
    List<Book> books = new ArrayList<>();
    List<User> users = new ArrayList<>();

    void addBook(Book book) {
        books.add(book);
    }

    void addUser(User user) {
        users.add(user);
    }

    void borrowBook(String ISBN, String userID) {
        for (User user : users) {
            if (user.userID.equals(userID)) {
                for (Book book : books) {
                    if (book.ISBN.equals(ISBN) && !book.isBorrowed) {
                        book.isBorrowed = true;
                        user.borrowedBooks.add(book);
                        System.out.println(user.name + " borrowed " + book.title);
                        return;
                    }
                }
            }
        }
        System.out.println("Book not available or user not found.");
    }

    void returnBook(String ISBN, String userID) {
        for (User user : users) {
            if (user.userID.equals(userID)) {
                for (Book book : user.borrowedBooks) {
                    if (book.ISBN.equals(ISBN)) {
                        book.isBorrowed = false;
                        user.borrowedBooks.remove(book);
                        System.out.println(user.name + " returned " + book.title);
                        return;
                    }
                }
            }
        }
        System.out.println("Book not found in user's borrowed list.");
    }
}

// Main class
public class Main2 {
    public static void main(String[] args) {
        Library library = new Library();
        
        library.addBook(new Book("Harry Potter", "J.K. Rowling", "12345"));
        library.addUser(new User("Alice", "U001"));
        
        library.borrowBook("12345", "U001");
        library.returnBook("12345", "U001");
    }
}

