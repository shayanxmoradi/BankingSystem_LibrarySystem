package library;

import library.util.DateUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

class Customer {
    private final static double DEBT_PENALTY = 1000;
    private String firstName;
    private String lastName;
    private List<Borrow> borrowedBooks = new ArrayList<Borrow>();
    private double debtAmount = 0;

    public Customer(String firstName, String lastName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public boolean canborrow() {

        if (borrowedBooks == null || borrowedBooks.size() < 2) {
          //  if (borrowedBooks != null)
              //  System.out.println("customer borrowed " + borrowedBooks.size());
            return true;
        } else {
            System.out.println("customer already has 2 borrowed books");
            return false;
        }
    }

    public double calculateDebtAmount() {
        int debt;
        for (Borrow borrow : borrowedBooks) {
            String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
            int diffrentInDays = DateUtils.borrowDateInDays(borrow.getBorrowDate(), 7);
            if (diffrentInDays <= 7) return 0;
            else {
                debtAmount += (diffrentInDays - 7) * DEBT_PENALTY;
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
        calculateDebtAmount();
        return debtAmount;
    }

    public void setDebtAmount(double debtAmount) {
        this.debtAmount = debtAmount;
    }

    public List<Borrow> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Borrow> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public void addBorrowedBook(Borrow borrowedBook) {
        this.borrowedBooks.add(borrowedBook);
    }
    public void removeBorrowedBook(Borrow borrowedBook) {
        this.borrowedBooks.remove(borrowedBook);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                ", debtAmount=" + debtAmount +
                '}';
    }
}
