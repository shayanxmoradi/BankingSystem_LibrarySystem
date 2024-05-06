package library;

import library.util.DateUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the library");
        Library.getInstance().iniateData();

        //1
        //  getAuthors("kalbas");
        //2
        // getBooks("hamid", "kalbas");
        //3
        // getBookDetails("yadgiri JAVA dar 2 saat");
        //4
        borrowBook("ahmad","zerang",DateUtils.getCurrentDate(),"yadgiri JAVA dar 2 saat");
        borrowBook("ahmad","zerang",DateUtils.getCurrentDate(),"yadgiri JAVA dar 2 saat");
        borrowBook("ahmad","zerang",DateUtils.getCurrentDate(),"yadgiri JAVA dar 2 saat");

        System.out.println(Library.getInstance().getBorrowsInfo());

    }

    public static boolean  borrowBook(String customerName,String customerLastName,Date borrowDate,String bookTitle) {
        Customer customer = Library.getInstance().getCustomer(customerName, customerLastName);
        Book book = Library.getInstance().getBooks(bookTitle).get(0);
        Borrow borrow1 = new Borrow(customer, borrowDate, book);



       return   borrow1.borrowBook();
    }

    public static void getAuthors(String familyName) {
        System.out.println(Library.getInstance().getAuthors(familyName).toString());
    }

    public static void getBooks(String firstName, String lastName) {
        System.out.println(Library.getInstance().getBooks("hamid", "kalbas").toString());
    }

    public static void getBookDetails(String title) {
        System.out.println(Library.getInstance().getBooks(title).toString());

    }

}