package library;

import java.util.List;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private static Library instance;

    // Private constructor to prevent instantiation from outside
    private Library() {
        // Initialize lists
        this.books = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.borrowsInfo = new ArrayList<>();
    }

    // Public method to get the singleton instance
    public static Library getInstance() {
        if (instance == null) {
            synchronized (Library.class) {
                if (instance == null) {
                    instance = new Library();
                }
            }
        }
        return instance;
    }

    private List<Book> books;
    private List<Customer> customers;
    private List<Borrow> borrowsInfo;

public void borrowBook(Book book) {

}

    public List<Author> getAuthors(String familyName) {
        return books.stream()
                .filter(book -> book.getAuthor().getLastName().equals(familyName))
                .map(Book::getAuthor)
                .collect(Collectors.toList());
    }

    public List<Book> getBooks(String firstName,String lastName) {
        return books.stream()
                .filter(book -> book.getAuthor().getFullName().equals(firstName+lastName))
                .collect(Collectors.toList());
    }
    public List<Book> getBooks(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equals(title))
                .collect(Collectors.toList());
    }
    public static void setInstance(Library instance) {
        Library.instance = instance;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBooks(List<Book> books) {
        this.books.addAll(books);
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void addCustomers(List<Customer> customers) {
        this.customers.addAll(customers);
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public List<Borrow> getBorrowsInfo() {
        return borrowsInfo;
    }

    public void addBorrowsInfos(List<Borrow> borrowsInfo) {
        this.borrowsInfo.addAll(borrowsInfo);
    }

    public void addBorrowsInfo(Borrow borrowsInfo) {
        this.borrowsInfo.add(borrowsInfo);
    }
}
