package library.menu;

import library.BorrowLog;
import library.Customer;
import library.Library;
import library.Main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static library.Main.borrowBook;
import static library.Main.returnBook;

public class Menu {
    public static void displayMenu() throws ParseException {
        Scanner scanner = new Scanner(System.in);


        borrowBook("ahmad", "zerang", "2024.04.25", "yadgiri JAVA dar 2 saat");
        borrowBook("ahmad", "zerang", "2024.04.25", "yadgiri JAVA dar 2 saat");

        //returnBook("ahmad", "zerang", "yadgiri JAVA dar 2 saat");

        a:
        while (true) {
            System.out.println("\n-------->Tell us what you want to do:<-----------" +
                    "\n- Enter 1 to retrieve all authors based on family name." +
                    "\n- Enter 2 to retrieve all books by searching on author full name." +
                    "\n- Enter 3 to retrieve details of a book by giving its title." +
                    "\n- Enter 4 to borrow a book for a customer." +
                    "\n- Enter 0 to exit." +
                    "\n- Enter 5 to show customer debt." +
                    "\n- Enter 6 to return a book." +
                    "\n- Enter 7 to show borrow history");

            switch (scanner.nextInt()) {
                case 0: {
                    break a;
                }
                case 1: {
                    System.out.println("Enter author family name:");
                    String familyName = scanner.next();
                    Main.getAuthors(familyName);
                    continue;
                }
                case 2: {
                    System.out.println("Enter author first name:");
                    String firstName = scanner.next();
                    System.out.println("Enter author last name:");
                    String lastName = scanner.next();
                    Main.getBooks(firstName, lastName);
                    continue;
                }
                case 3: {
                    scanner.nextLine();
                    System.out.println("Enter book title:");
                    String bookTitle = scanner.nextLine();
                    Main.getBookDetails(bookTitle);
                    continue;
                }
                case 4: {
                    System.out.println("Enter customer first name:");
                    String customerFirstName = scanner.next();
                    System.out.println("Enter customer last name:");
                    String customerLastName = scanner.next();
                    scanner.nextLine();
                    System.out.println("Enter book title:");
                    String bookTitle = scanner.nextLine();
                    System.out.println("Enter borrow date (format: yyyy.MM.dd), enter 'now' to use current date:");
                    String date = scanner.nextLine();
                    borrowBook(customerFirstName, customerLastName, date, bookTitle);
                    continue;
                }
                case 5: {
                    System.out.println("Enter customer first name:");
                    String customerFirstName = scanner.next();
                    System.out.println("Enter customer last name:");
                    String customerLastName = scanner.next();
                    // Library.getInstance().getCustomer(customerFirstName, customerLastName).calculateDebtAmount();
                    try {
                        System.out.println(Library.getInstance().getCustomer(customerFirstName, customerLastName).getDebtAmount());

                    } catch (Exception e) {
                        System.out.println("no customer found");
                    }
                    continue;
                }
                case 6: {
                    System.out.println("Enter customer first name:");
                    String customerFirstName = scanner.next();
                    System.out.println("Enter customer last name:");
                    String customerLastName = scanner.next();
                    scanner.nextLine();
                    System.out.println("Enter book title:");
                    String bookTitle = scanner.nextLine();
                    returnBook(customerFirstName, customerLastName, bookTitle);
                    continue;
                }
                case 7: {
                    System.out.println("Borrow history :\n");
                    for (BorrowLog log : Library.getInstance().getBorrowLogs()) {
                        if (log != null) {
                            System.out.println(log);
                        }
                    }
                    continue;
                }
            }
        }
    }

    private static Date getDate(String dateString) throws ParseException {
        if (dateString.equals("now")) return new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        return dateFormat.parse(dateString);
    }
}