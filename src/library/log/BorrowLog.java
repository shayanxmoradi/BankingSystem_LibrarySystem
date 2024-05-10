package library.log;

import library.Book;
import library.Customer;
import library.Library;

import java.util.Date;

public class BorrowLog {
    private Customer customer;
    private Book book;
    private Date borrowDate;

    public BorrowLog(Customer customer, Date borrowDate, Book book) {
        this.customer = customer;
        this.borrowDate = borrowDate;
        this.book = book;
    }

    public boolean canCustomerBorrow() {
        if (customer.canBorrow()) {
            for (Book book : Library.getInstance().getBooks()) {
                if (book.getTitle().equalsIgnoreCase(this.book.getTitle())) {
                    if (!book.isBorrowed()) {
                        return true;
                    }
                }
            } // Found the book
        }
        return false;
    }


    public boolean borrowBook() {
        BorrowLog borrowLog = new BorrowLog(customer, borrowDate, book);

        if (borrowLog.canCustomerBorrow()) {
            book.setBorrowed(true);
            Library.getInstance().addBorrowsInfo(borrowLog);
            customer.addBorrowedBook(borrowLog);
            return true;

        }
        return false;
    }

    public boolean returnBook() {

        BorrowLog borrowLog = new BorrowLog(customer, borrowDate, book);

        Library.getInstance().removeBorrowsInfo(borrowLog);
        System.out.println("brefore" + customer.toString());
        customer.removeBorrowedBook(borrowLog);
        System.out.println("after" + customer.toString());

        return true;

    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BorrowLog) {
            BorrowLog borrowLog = (BorrowLog) obj;
            return customer.equals(borrowLog.customer) && book.getTitle().equalsIgnoreCase(borrowLog.book.getTitle());

        }
        return false;
    }


    @Override
    public String toString() {
        return "Borrow{" +

                ", book=" + book +
                ", borrowDate=" + borrowDate +
                "}\n";
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
