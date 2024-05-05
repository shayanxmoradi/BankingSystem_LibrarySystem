package library;

import java.util.Date;

class Borrow {
    private Customer customer;
    private Book book;
    private Date borrowDate;

    public Borrow(Customer customer, Date borrowDate, Book book) {
        this.customer = customer;
        this.borrowDate = borrowDate;
        this.book = book;
    }

    public boolean canCustomerBorrow() {
        boolean isBookInLibrary;
        if (customer.canborrow()) {
            for (Book book : Library.getInstance().getBooks()) {
                if (book.getTitle().equalsIgnoreCase(book.getTitle())) {
                    if (!book.isBorrowed()) {
                        isBookInLibrary = true;
                    }
                } else return false;
            } // Found the book
        }

        Library.getInstance().getBooks();

        if (customer.canborrow()) {
            return true;

        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "customer=" + customer +
                ", book=" + book +
                ", borrowDate=" + borrowDate +
                '}';
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
