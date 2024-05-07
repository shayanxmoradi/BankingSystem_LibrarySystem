package library;

import library.util.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
     //it doesnt remove from customer when i return a book
        //when i want to borrow for customer says not found
        Library.getInstance().iniateData();


        borrowBook("ahmad", "zerang", "2024.04.25", "yadgiri JAVA dar 2 saat");
        borrowBook("ahmad", "zerang", "2024.04.25", "yadgiri JAVA dar 2 saat");

        returnBook("ahmad", "zerang", "yadgiri JAVA dar 2 saat");

        System.out.println(Library.getInstance().getBorrowsInfo());


        interactivePart();

    }

    private static void interactivePart() throws ParseException {
        Scanner scanner = new Scanner(System.in);

        a:
        while (true) {
            System.out.println("\n tell us what you want to do" +
                    "\n -enter 1 for retrive all authors based on FamilyName " +
                    "\n -enter 2 for retrive all Book by searching on Author full name" +
                    "\n -enter 3 for retrive detail of book by giving book title" +
                    "\n -enter 4 for borrow book to customer" +
                    "\n -enter 0 for exit" +
                    "\n -enter 5 for show customer debt" +
                    "\n -enter 6 for returning a book");

            switch (scanner.nextInt()) {
                case 0: {
                    break a;
                }
                case 1: {
                    System.out.println("enter author familyname");
                    String familyName = scanner.next();
                    getAuthors(familyName);
                    continue;
                }
                case 2: {
                    System.out.println("enter Author firstname");
                    String firstName = scanner.next();
                    System.out.println("enter Author lastname");
                    String lastName = scanner.next();
                    getBooks(firstName, lastName);
                    continue;

                }
                case 3: {
                    scanner.nextLine();
                    System.out.println("enter book title");
                    String bookTitle = scanner.nextLine();
                    getBookDetails(bookTitle);
                    continue;
                }
                case 4: {

                    System.out.println("enter customer firstname");
                    String customerFirstName = scanner.next();
                    System.out.println("enter customer lastName");
                    String customerLastName = scanner.next();
                    scanner.nextLine();
                    System.out.println("enter book title");
                    String bookTitle = scanner.nextLine();

                    System.out.println("enter borrow Date, enter now to use current date");
                    String date = scanner.nextLine();

                    borrowBook(customerFirstName, customerLastName, date, bookTitle);
                    System.out.println(Library.getInstance().getBorrowsInfo());
                    continue;
                }
                case 5: {
                    System.out.println("enter customer firstname");
                    String customerFirstName = scanner.next();
                    System.out.println("enter customer lastName");
                    String customerLastName = scanner.next();
                    System.out.println(Library.getInstance().getCustomer(customerFirstName, customerLastName).getDebtAmount());
                    continue;
                }
                case 6: {
                    System.out.println("enter customer firstname");
                    String customerFirstName = scanner.next();
                    System.out.println("enter customer lastName");
                    String customerLastName = scanner.next();
                    scanner.nextLine();
                    System.out.println("enter book title");
                    String bookTitle = scanner.nextLine();


                    returnBook(customerFirstName, customerLastName, bookTitle);
                    System.out.println(Library.getInstance().getBorrowsInfo());
                    System.out.println(Library.getInstance().getBorrowsInfo());

                    continue;

                }
            }
            scanner.close();

            //1
            //  getAuthors("kalbas");
            //2
            // getBooks("hamid", "kalbas");
            //3
            // getBookDetails("yadgiri JAVA dar 2 saat");
            //4

//            Date date = getDate("2024.04.25");
//
//            borrowBook("ahmad", "zerang", "2024.04.25", "yadgiri JAVA dar 2 saat");
//            borrowBook("ahmad", "zerang", "2024.04.25", "yadgiri JAVA dar 2 saat");
//            borrowBook("ahmad", "zerang", "2024.04.25", "yadgiri JAVA dar 2 saat");

            //   System.out.println(Library.getInstance().getBorrowsInfo());
            System.out.println(Library.getInstance().getCustomer("ahmad", "zerang").getDebtAmount());

        }
    }

    private static Date getDate(String dateString) throws ParseException {
        if (dateString.equals("now"))return DateUtils.getCurrentDate();

        Date date = null;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        try {
            date = dateFormat.parse(dateString);
            System.out.println("Date: " + date);
        } catch (ParseException e) {
            System.err.println("\n\n----->invalid DATE<------\n\n");
          //  e.printStackTrace();
        }
        return date;
    }

    public static boolean borrowBook(String customerName, String customerLastName, String borrowDate, String bookTitle) throws ParseException {
        Customer customer = Library.getInstance().getCustomer(customerName, customerLastName);
        try {


            Book book = Library.getInstance().getBooks(bookTitle).get(0);
            Date date = getDate(borrowDate);
            DateUtils.getCurrentDate();
            Borrow borrow1 = new Borrow(customer, date, book);


            return borrow1.borrowBook();
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean returnBook(String customerName, String customerLastName, String bookTitle) throws ParseException {
        Customer customer = Library.getInstance().getCustomer(customerName, customerLastName);
        try {
            Book book = Library.getInstance().getBooks(bookTitle).get(0);
            Date date = DateUtils.getCurrentDate();
            Borrow borrow1 = new Borrow(customer, date, book);

            return borrow1.returnBook();
        } catch (Exception e) {
            return false;
        }

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