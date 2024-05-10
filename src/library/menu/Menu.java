package library.menu;

import library.*;
import library.log.BorrowLog;

import java.text.ParseException;

import java.util.Scanner;


public class Menu {
    public static void displayMenu() throws ParseException {
        Scanner scanner = new Scanner(System.in);

        a:
        while (true) {
            System.out.println("\n--------> Library Management System <-----------");
            System.out.println("1. Retrieve all authors based on family name.");
            System.out.println("2. Retrieve all books by searching on author full name.");
            System.out.println("3. Retrieve details of a book by giving its title.");
            System.out.println("4. Borrow a book for a customer.");
            System.out.println("5. Return a borrowed book.");
            System.out.println("6. Show customer debt.");
            System.out.println("7. Show borrow history.");
            System.out.println("8. Add a new customer.");
            System.out.println("9. Add a new book.");
            System.out.println("10. Show all customers.");
            System.out.println("11. Show all books.");
            System.out.println("12. Show all authors.");
            System.out.println("13. add new authors.");

            System.out.println("0. Exit.");

           b: switch (scanner.nextInt()) {
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
                    borrowBook(scanner);
                    continue;
                }
                case 5: {
                    returnBook(scanner);
                    continue;
                }
                case 6: {
                    showCustomerDebt(scanner);
                    continue;
                }
                case 7: {
                    showBorrowHistory();
                    continue;
                }
                case 8: {
                    addNewCustomer(scanner);
                    continue;
                }
                case 9: {
                    addNewBook(scanner);
                    continue;
                }
                case 10: {
                    showAllCustomers();
                    continue;
                }
                case 11: {
                    showAllBooks();
                    continue;
                }

                case 12: {
                    showAllAuthors();
                    continue;
                }
                case 13: {
                    addNewAuthor(scanner);
                    break ;
                }
               default: {
                   System.out.println("Invalid input. Try again.");

               }
            }
        }
    }

    private static void borrowBook(Scanner scanner) throws ParseException {
        System.out.println("Enter customer first name:");
        String customerFirstName = scanner.next();
        System.out.println("Enter customer last name:");
        String customerLastName = scanner.next();
        scanner.nextLine();
        System.out.println("Enter book title:");
        String bookTitle = scanner.nextLine();
        System.out.println("Enter borrow date (format: yyyy.MM.dd), enter 'now' to use current date:");
        String date = scanner.nextLine();
        Main.borrowBook(customerFirstName, customerLastName, date, bookTitle);
    }

    private static void returnBook(Scanner scanner) {
        System.out.println("Enter customer first name:");
        String customerFirstName = scanner.next();
        System.out.println("Enter customer last name:");
        String customerLastName = scanner.next();
        scanner.nextLine();
        System.out.println("Enter book title:");
        String bookTitle = scanner.nextLine();
        Main.returnBook(customerFirstName, customerLastName, bookTitle);
    }

    private static void showCustomerDebt(Scanner scanner) {
        System.out.println("Enter customer first name:");
        String customerFirstName = scanner.next();
        System.out.println("Enter customer last name:");
        String customerLastName = scanner.next();
        try {
            System.out.println(Library.getInstance().getCustomer(customerFirstName, customerLastName).getDebtAmount());
        } catch (Exception e) {
            System.out.println("No customer found.");
        }
    }

    private static void showBorrowHistory() {
        System.out.println("Borrow history :\n");
        for (BorrowLog log : Library.getInstance().getBorrowLogs()) {
            if (log != null) {
                System.out.println(log);
            }
        }
    }

    private static void addNewCustomer(Scanner scanner) {
        System.out.println("Enter new customer's first name:");
        String firstName = scanner.next();
        System.out.println("Enter new customer's last name:");
        String lastName = scanner.next();
        Customer newCustomer = new Customer(firstName, lastName);
        Library.getInstance().addCustomer(newCustomer);
        System.out.println("New customer added successfully.");
    }

    private static void addNewBook(Scanner scanner) {
        System.out.println("Enter new book's title:");
        String title = scanner.nextLine();
        System.out.println("Enter new book's author's first name:");
        String authorFirstName = scanner.next();
        System.out.println("Enter new book's author's last name:");
        String authorLastName = scanner.next();
        System.out.println("Enter new book's genre:");
        String genre = scanner.next();
        System.out.println("Enter new book's publication year:");
        int publicationYear = scanner.nextInt();
        System.out.println("Enter 'true' if the book is borrowed, otherwise enter 'false':");
        boolean isBorrowed = scanner.nextBoolean();
        Author author = new Author(authorFirstName, authorLastName, 0);
        Book newBook = new library.Book(title, author, genre, publicationYear, isBorrowed);
        Library.getInstance().addBook(newBook);
        System.out.println("New book added successfully.");
    }

    private static void showAllCustomers() {
        System.out.println("\n--------> All Customers <-----------");
        for (Customer customer : Library.getInstance().getCustomers()) {
            if (customer != null) {
                System.out.println(customer);
            }
        }
    }

    private static void showAllBooks() {
        System.out.println("\n--------> All Books <-----------");

        for (Book book : Library.getInstance().getBooks()) {
            if (book != null) {
                System.out.println(book);

            }
        }
    }

    private static void showAllAuthors() {
        System.out.println("\n--------> All Authors <-----------");
        for (Author author : Library.getInstance().getAuthors()) {
            if (author != null)
                System.out.println(author);
        }
    }

    private static void addNewAuthor(Scanner scanner) {
        System.out.println("Enter new author's first name:");
        String firstName = scanner.next();
        System.out.println("Enter new author's last name:");
        String lastName = scanner.next();
        System.out.println("Enter new author's birth year:");
        int birthYear = scanner.nextInt();
        Author newAuthor = new Author(firstName, lastName, birthYear);
        Library.getInstance().addAuthor(newAuthor);
        System.out.println("New author added successfully.");
    }
}
