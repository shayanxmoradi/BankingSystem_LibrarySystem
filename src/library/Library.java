package library;

import java.util.Date;
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

//    public List<Customer> getCustomer(String firstName, String lastName) {
//        return customers.stream()
//                .filter(customer -> customer.getFirstName().equals(firstName) &&
//                        customer.getLastName().equals(lastName))
//                .collect(Collectors.toList());
//    }
    public Customer getCustomer(String firstName, String lastName) {
    for (Customer customer : Library.getInstance().getCustomers()) {
        if (customer.getFirstName().equals(firstName) && customer.getLastName().equals(lastName)) {
            return customer;
        }
    }
    throw new RuntimeException("Customer not found");
    }
    public List<Author> getAuthors(String familyName) {
        return books.stream()
                .filter(book -> book.getAuthor().getLastName().equals(familyName))
                .map(Book::getAuthor)
                .collect(Collectors.toList());
    }

    public List<Book> getBooks(String firstName, String lastName) {
        return books.stream()
                .filter(book -> book.getAuthor().getFullName().equals(firstName + lastName))
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

    public static void iniateData() {
        Author authour1 = new Author("shayan", "moradi", 1999);
        Author authour2 = new Author("kimia", "mohamadi", 1970);
        Author authour3 = new Author("hamid", "kalbas", 2000);
        Author authour4 = new Author("hainye", "rammesh", 1980);
        Author authour5 = new Author("asghar", "pa ghermez", 1991);

        Book book1 = new Book("shena bedone ab", authour1, "modern", 2024, false);
        Book book2 = new Book("parvaz toye sakhree", authour2, "phantesy", 2014, false);
        Book book3 = new Book("amozesh paresh ba maanee", authour3, "modern", 2015, false);
        Book book4 = new Book("tarz tahye abgosht", authour4, "coocking", 2020, false);
        Book book5 = new Book("yadgiri JAVA dar 2 saat", authour5, "modern", 2023, false);
        Book book8 = new Book("yadgiri JAVA dar 2 saat", authour5, "modern", 2023, false);
        Book book6 = new Book("yadgiri pokht kalbas dar 12 saal", authour5, "coocking", 2020, false);
        Book book7 = new Book("sakht fandak bedon atish", authour3, "invovation", 2010, false);
        List<Book> books = new ArrayList<Book>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book7);
        books.add(book8);
        Library.getInstance().addBooks(books);

        //iniate customers
        Customer customer1 = new Customer("soghra", "shalvar palangi");
        Customer customer2 = new Customer("ahmad", "zerang");
        Customer customer3 = new Customer("sosan", "zardchobe");
        Customer customer4 = new Customer("mosi", "bi ghaam");
        List<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        Library.getInstance().addCustomers(customers);


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
