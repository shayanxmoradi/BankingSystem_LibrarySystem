package library;

import library.util.DateUtils;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;

public class Customer {
    private final static double DEBT_PENALTY = 1000;
    private String firstName;
    private String lastName;
    private BorrowLog[] borrowedBooks;
    private int borrowedCount;
    private double debtAmount = 0;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.borrowedBooks = new BorrowLog[2]; // Assuming a maximum of 2 borrowed books
        this.borrowedCount = 0;
    }

    public boolean canBorrow() {
        return borrowedCount < 2;
    }

    public double calculateDebtAmount() {
        debtAmount = 0;
        for (BorrowLog borrowLog : borrowedBooks) {

            if (borrowLog != null) {
                String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
                int differentInDays = DateUtils.borrowDateInDays(borrowLog.getBorrowDate(), 7);
                if (differentInDays > 7) {
                    debtAmount += (differentInDays - 7) * DEBT_PENALTY;
                }
            }
        }
        return debtAmount;
    }

    public String getFirstName() {
        return firstName;
    }

    public void changeFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void changeLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getDebtAmount() {

        return debtAmount;
    }

    public void setDebtAmount(double debtAmount) {
        this.debtAmount = debtAmount;
    }

    public BorrowLog[] getBorrowedBooks() {
        return borrowedBooks;
    }

    public void addBorrowedBook(BorrowLog borrowedBook) {
        if (borrowedCount < 2) {
            borrowedBooks[borrowedCount++] = borrowedBook;
            calculateDebtAmount();
        } else {
            System.out.println("Customer already has 2 borrowed books");
        }
    }

//    public void removeBorrowedBook(Borrow borrowedBook) {
//        for (int i = 0; i < borrowedBooks.length; i++) {
//            if (borrowedBooks[i] != null && borrowedBooks[i].equals(borrowedBook)) {
//                borrowedBooks[i] = null;
//                borrowedCount--;
//                break;
//            }
//        }
//    }
    public void removeBorrowedBook(BorrowLog borrowedBook) {
        for (int i = 0; i < borrowedCount; i++) {
            if (borrowedBooks[i] != null && borrowedBooks[i].equals(borrowedBook)) {
                // Shift elements to the left to fill the gap
                for (int j = i; j < borrowedCount - 1; j++) {
                    borrowedBooks[j] = borrowedBooks[j + 1];
                }
                // Set the last element to null and decrement count
                borrowedBooks[borrowedCount - 1] = null;
                borrowedCount--;
               calculateDebtAmount();
                return; // Exit after removing the first occurrence
            }
        }
    }


    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", borrowedBooks=" + Arrays.toString(borrowedBooks) +
                ", debtAmount=" + debtAmount +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Customer) {
            Customer other = (Customer) obj;
            return firstName.equals(other.firstName) && lastName.equals(other.lastName);
        }
        return false;
    }
}
