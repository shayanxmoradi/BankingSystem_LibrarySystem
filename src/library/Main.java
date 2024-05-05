package library;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
        System.out.println(timeStamp);
        iniateData();

        // System.out.println(Library.getInstance().getBooks().get(0).getAuthor().toString());
//1
        System.out.println(Library.getInstance().getAuthors("kalbas").toString());
        //2
        System.out.println(Library.getInstance().getBooks("hamid", "kalbas").toString());
        //
        System.out.println(Library.getInstance().getBooks("yadgiri JAVA dar 2 saat").toString());

        //
        System.out.println(Library.getInstance().getBorrowsInfo());


    }

    private static void iniateData() {
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
        Customer customer1 = new Customer("soghar", "shalvar palangi");
        Customer customer2 = new Customer("ahmad", "zerang");
        Customer customer3 = new Customer("sosan", "zardchobe");
        Customer customer4 = new Customer("mosi", "bi ghaam");
        List<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        Library.getInstance().addCustomers(customers);


        // Get the current time in milliseconds
        long currentTimeMillis = System.currentTimeMillis();

        // Create a Date object using the current time
        Date currentDate = new Date(currentTimeMillis);
        //set up borrow

        Borrow borrow = new Borrow(customer1, currentDate, book1);
        if (borrow.canCustomerBorrow()) {
            Library.getInstance().addBorrowsInfo(borrow);

        }


    }
}