package library;

import library.log.BorrowLog;

import java.util.Arrays;
import java.util.List;

import java.util.ArrayList;

public class Library {
    private static Library instance;

    private Library() {
        // Initialize lists
        this.books = new Book[100];
        this.customers = new Customer[100];
        this.borrowLogs = new BorrowLog[100];
        this.authors=new Author[100];
    }

    public static Library getInstance() {
        if (instance == null) {
            synchronized (Library.class) {
                if (instance == null) {
                    instance = new Library();
                }
            }
        }
      //  System.out.println();
        return instance;
    }

    private Book[] books;
    private Customer[] customers;
    private BorrowLog[] borrowLogs;
    private Author[] authors;



    public Customer getCustomer(String firstName, String lastName) {
        for (Customer customer : customers) {
            if (customer != null && customer.getFirstName().equals(firstName) && customer.getLastName().equals(lastName)) {
                return customer;
            }
        }
        System.err.println("\n\n----->Customer not found<------\n\n");
        return null;
    }

    public BorrowLog getBorrow(Customer customer, String bookTitle) {
        for (BorrowLog borrowLog : borrowLogs) {
            if (borrowLog != null && borrowLog.getCustomer().getFirstName().equals(customer.getFirstName()) &&
                    borrowLog.getCustomer().getLastName().equals(customer.getLastName()) &&
                    borrowLog.getBook().getTitle().equals(bookTitle)) {
                return borrowLog;
            }
        }
        throw new RuntimeException("Borrow not found");
    }



    // Getter for authors
    public Author[] getAuthors() {
        return authors;
    }

    // Method to add a single author
    public void addAuthor(Author author) {
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] == null) {
                authors[i] = author;
                return;
            }
        }
        System.err.println("Failed to add author. Library is full.");
    }

    public void removeAuthor(Author author) {
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] != null && authors[i].equals(author)) {
                // Shift elements to the left to fill the gap
                for (int j = i; j < authors.length - 1; j++) {
                    authors[j] = authors[j + 1];
                }
                // Set the last element to null
                authors[authors.length - 1] = null;
                return;
            }
        }
        System.err.println("Failed to remove author. Author not found.");
    }



public Author[] getAuthors(String familyName) {
    Author[] authors = new Author[100];
    int index = 0;

    for (Book book : books) {
        if (book != null && book.getAuthor().getLastName().equals(familyName)) {
            authors[index++] = book.getAuthor();
        }
    }

    return Arrays.copyOf(authors, index);
}

    public Book[] getBooks(String firstName, String lastName) {
        List<Book> matchingBooks = new ArrayList<>();
        String fullName = firstName + lastName;
        for (Book book : books) {
            if (book != null && book.getAuthor().getFullName().equals(fullName)) {
                matchingBooks.add(book);
            }
        }
        return matchingBooks.toArray(new Book[0]);
    }

    public Book[] getBooks(String title) {
        List<Book> matchingBooks = new ArrayList<>();
        for (Book book : books) {
            if (book != null && book.getTitle().equals(title)) {
                matchingBooks.add(book);
            }
        }
        return matchingBooks.toArray(new Book[0]);
    }



    public static void setInstance(Library instance) {
        Library.instance = instance;
    }



    public static void iniateData() {
        Author authour1 = new Author("shayan", "moradi", 1999);
        Author authour2 = new Author("kimia", "moradi", 1970);
        Author authour3 = new Author("hamid", "kalbas", 2000);
        Author authour4 = new Author("hainye", "rammesh", 1980);
        Author authour5 = new Author("asghar", "pa ghermez", 1991);

        Library.getInstance().addAuthor(authour1);
        Library.getInstance().addAuthor(authour2);
        Library.getInstance().addAuthor(authour3);
        Library.getInstance().addAuthor(authour4);
        Library.getInstance().addAuthor(authour5);


        Book book1 = new Book("shena bedone ab", authour1, "modern", 2024, false);
        Book book2 = new Book("parvaz toye sakhree", authour2, "phantesy", 2014, false);
        Book book3 = new Book("amozesh paresh ba maanee", authour3, "modern", 2015, false);
        Book book4 = new Book("tarz tahye abgosht", authour4, "coocking", 2020, false);
        Book book5 = new Book("yadgiri JAVA dar 2 saat", authour5, "modern", 2023, false);
        Book book6 = new Book("yadgiri pokht kalbas dar 12 saal", authour5, "coocking", 2020, false);
        Book book7 = new Book("sakht fandak bedon atish", authour3, "invovation", 2010, false);
        Book book8 = new Book("yadgiri JAVA dar 2 saat", authour5, "modern", 2023, false);

        Book[] booksArray = {book1, book2, book3, book4, book5, book6, book7, book8};
        Library.getInstance().addBooks(booksArray);

        //  customers
        Customer customer1 = new Customer("soghra", "shalvar palangi");
        Customer customer2 = new Customer("ahmad", "zerang");
        Customer customer3 = new Customer("sosan", "zardchobe");
        Customer customer4 = new Customer("mosi", "bi ghaam");

        Customer[] customersArray = {customer1, customer2, customer3, customer4};
        Library.getInstance().addCustomers(customersArray);
    }

    public Book[] getBooks() {
        return books;
    }

    public void addBooks(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            this.books[i] = books[i];
        }
    }

    public void addBook(Book book) {
        for (int i = 0; i < this.books.length; i++) {
            if (this.books[i] == null) {
                this.books[i] = book;
                return;
            }
        }
        System.err.println("Failed to add book. Library is full.");
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public void addCustomers(Customer[] customers) {
        for (int i = 0; i < customers.length; i++) {
            this.customers[i] = customers[i];
        }
    }

    public void addCustomer(Customer customer) {
        for (int i = 0; i < this.customers.length; i++) {
            if (this.customers[i] == null) {
                this.customers[i] = customer;
                return;
            }
        }
        System.err.println("Failed to add customer. Library is full.");
    }

    public BorrowLog[] getBorrowLogs() {
        return borrowLogs;
    }

    public void addBorrowsInfos(BorrowLog[] borrowsInfo) {
        for (int i = 0; i < borrowsInfo.length; i++) {
            this.borrowLogs[i] = borrowsInfo[i];
        }
    }

    public void addBorrowsInfo(BorrowLog borrowsInfo) {
        for (int i = 0; i < this.borrowLogs.length; i++) {
            if (this.borrowLogs[i] == null) {
                this.borrowLogs[i] = borrowsInfo;
                return;
            }
        }
        System.err.println("Failed to add borrow info. Library is full.");
    }



    public void removeBorrowsInfo(BorrowLog removeBorrowsLog) {
        for (int i = 0; i < borrowLogs.length; i++) {


            if (borrowLogs[i] != null && borrowLogs[i].equals(removeBorrowsLog)) {

                for (int j = i; j < borrowLogs.length - 1; j++) {
                    borrowLogs[j] = borrowLogs[j + 1];
                }
                borrowLogs[borrowLogs.length - 1] = null;
                return;
            }
        }
        System.out.println("Failed to remove borrow info.not found");
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    public void setBorrowLogs(BorrowLog[] borrowLogs) {
        this.borrowLogs = borrowLogs;
    }
}

