package library;

import library.menu.Menu;
import library.util.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        //returning has problem.
        Library.getInstance().iniateData();
        Menu.displayMenu();
    }


    private static Date getDate(String dateString) throws ParseException {
        if (dateString.equals("now")) return DateUtils.getCurrentDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        return dateFormat.parse(dateString);
    }

    public static boolean borrowBook(String customerName, String customerLastName, String borrowDate, String bookTitle) throws ParseException {
        Customer customer = Library.getInstance().getCustomer(customerName, customerLastName);
        Book book = Library.getInstance().getBooks(bookTitle)[0];
        Date date = getDate(borrowDate);
        BorrowLog borrowLog = new BorrowLog(customer, date, book);
        return borrowLog.borrowBook();
    }

    public static boolean returnBook(String customerName, String customerLastName, String bookTitle) {
        Customer customer = Library.getInstance().getCustomer(customerName, customerLastName);
        Book book = Library.getInstance().getBooks(bookTitle)[0];
        BorrowLog borrowLog = new BorrowLog(customer, new Date(), book);
        return borrowLog.returnBook();
    }

    public static void getAuthors(String familyName) {
        for (Author author : Library.getInstance().getAuthors(familyName)) {
            System.out.println(author);
            return;
        }
        System.out.println("nothing found");

    }

    public static void getBooks(String firstName, String lastName) {
        for (Book book : Library.getInstance().getBooks(firstName, lastName)) {
            System.out.println(book);
            return;
        }
        System.out.println("nothing found");

    }

    public static void getBookDetails(String title) {
        for (Book book : Library.getInstance().getBooks(title)) {
            System.out.println(book);
            return;
        }
        System.out.println("nothing found");

    }
}
