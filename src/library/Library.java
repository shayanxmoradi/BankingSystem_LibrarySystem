package library;

import java.util.List;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Library {
    private static Library instance;

    private Library() {
        // Initialize lists
        this.books = new Book[100];
        this.customers = new Customer[100];
        this.borrowLogs = new BorrowLog[100];
    }

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

    private Book[] books;
    private Customer[] customers;
    private BorrowLog[] borrowLogs;

    public void borrowBook(Book book) {

    }


//    public Customer getCustomer(String firstName, String lastName) {
//        for (Customer customer : Library.getInstance().getCustomers()) {
//            if (customer.getFirstName().equals(firstName) && customer.getLastName().equals(lastName)) {
//                return customer;
//            }
//        }
//        System.err.println("\n\n----->Customer not found<------\n\n");
//        return null;
//    }

//    public BorrowLog getBorrow(Customer customer, String bookTitle) {
//    for (BorrowLog borrowLog : Library.getInstance().getBorrowLogs()) {
//        if (borrowLog.getCustomer().getFirstName().equals(customer.getFirstName()) &&
//                borrowLog.getCustomer().getLastName().equals(customer.getLastName()) &&
//                borrowLog.getBook().getTitle().equals(bookTitle)
//                        ) {
//            return borrowLog;
//        }
//    }
//    throw new RuntimeException("Customer not found");
//    }

    ///////////////////
    ////


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

    public Author[] getAuthors(String familyName) {
        List<Author> authors = new ArrayList<>();
        for (Book book : books) {
            if (book != null && book.getAuthor().getLastName().equals(familyName)) {
                authors.add(book.getAuthor());
            }
        }
        return authors.toArray(new Author[0]);
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


    //
    ///
    ///
    ///

//    public List<Author> getAuthors(String familyName) {
//        return books.stream()
//                .filter(book -> book.getAuthor().getLastName().equals(familyName))
//                .map(Book::getAuthor)
//                .collect(Collectors.toList());
//    }

//    public List<Book> getBooks(String firstName, String lastName) {
//        return books.stream()
//                .filter(book -> book.getAuthor().getFullName().equals(firstName + lastName))
//                .collect(Collectors.toList());
//    }

//    public List<Book> getBooks(String title) {
//        return books.stream()
//                .filter(book -> book.getTitle().equals(title))
//                .collect(Collectors.toList());
//    }

    public static void setInstance(Library instance) {
        Library.instance = instance;
    }

//    public static void iniateData() {
//        Author authour1 = new Author("shayan", "moradi", 1999);
//        Author authour2 = new Author("kimia", "mohamadi", 1970);
//        Author authour3 = new Author("hamid", "kalbas", 2000);
//        Author authour4 = new Author("hainye", "rammesh", 1980);
//        Author authour5 = new Author("asghar", "pa ghermez", 1991);
//
//        Book book1 = new Book("shena bedone ab", authour1, "modern", 2024, false);
//        Book book2 = new Book("parvaz toye sakhree", authour2, "phantesy", 2014, false);
//        Book book3 = new Book("amozesh paresh ba maanee", authour3, "modern", 2015, false);
//        Book book4 = new Book("tarz tahye abgosht", authour4, "coocking", 2020, false);
//        Book book5 = new Book("yadgiri JAVA dar 2 saat", authour5, "modern", 2023, false);
//        Book book8 = new Book("yadgiri JAVA dar 2 saat", authour5, "modern", 2023, false);
//        Book book6 = new Book("yadgiri pokht kalbas dar 12 saal", authour5, "coocking", 2020, false);
//        Book book7 = new Book("sakht fandak bedon atish", authour3, "invovation", 2010, false);
//        List<Book> books = new ArrayList<Book>();
//        books.add(book1);
//        books.add(book2);
//        books.add(book3);
//        books.add(book4);
//        books.add(book5);
//        books.add(book6);
//        books.add(book7);
//        books.add(book8);
//        Library.getInstance().addBooks(books);
//
//        //iniate customers
//        Customer customer1 = new Customer("soghra", "shalvar palangi");
//        Customer customer2 = new Customer("ahmad", "zerang");
//        Customer customer3 = new Customer("sosan", "zardchobe");
//        Customer customer4 = new Customer("mosi", "bi ghaam");
//        List<Customer> customers = new ArrayList<>();
//        customers.add(customer1);
//        customers.add(customer2);
//        customers.add(customer3);
//        customers.add(customer4);
//        Library.getInstance().addCustomers(customers);
//
//
//    }

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
        Book book6 = new Book("yadgiri pokht kalbas dar 12 saal", authour5, "coocking", 2020, false);
        Book book7 = new Book("sakht fandak bedon atish", authour3, "invovation", 2010, false);
        Book book8 = new Book("yadgiri JAVA dar 2 saat", authour5, "modern", 2023, false);

        Book[] booksArray = {book1, book2, book3, book4, book5, book6, book7, book8};
        Library.getInstance().addBooks(booksArray);

        // Initialize customers
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

//    public void removeBorrowsInfo(BorrowLog borrowsInfo) {
//        for (int i = 0; i < this.borrowLogs.length; i++) {
//            if (this.borrowLogs[i] != null && this.borrowLogs[i].equals(borrowsInfo)) {
//                this.borrowLogs[i] = null;
//                return;
//            }
//        }
//        System.err.println("Borrow log not found.");}
//

    public void removeBorrowsInfo(BorrowLog removeBorrowsLog) {
        //  System.out.println("give" + removeBorrowsLog.toString());
        for (int i = 0; i < borrowLogs.length; i++) {


//            try {
//                System.out.println("exists " + borrowLogs[i].toString());
//
//            }catch (Exception e) {}
            if (borrowLogs[i] != null && borrowLogs[i].equals(removeBorrowsLog)) {

                // Shift elements to the left to fill the gap
                for (int j = i; j < borrowLogs.length - 1; j++) {
                    borrowLogs[j] = borrowLogs[j + 1];
                }
                // Set the last element to null and decrement count
                borrowLogs[borrowLogs.length - 1] = null;
                //borrowedCount--;
                return;
            }
        }
        System.out.println("Failed to remove borrow info.not found");
    }

}

