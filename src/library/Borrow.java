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
        if (customer.canborrow()) {
//            System.out.println("customer can borrow");
            for (Book book : Library.getInstance().getBooks()) {
//                System.out.println("book is aviable");
                if (book.getTitle().equalsIgnoreCase(book.getTitle())) {
                    if (!book.isBorrowed()) {
                       return true;
                    }
                }
            } // Found the book
        }
        return false;
    }

       // Library.getInstance().getBooks();

//        if (customer.canborrow()) {
//            return true;
//
//        } else {
//            return false;
//        }
   // }



    public boolean borrowBook() {
        Borrow borrow = new Borrow(customer, borrowDate, book);

        if (borrow.canCustomerBorrow()) {
            book.setBorrowed(true);
            Library.getInstance().addBorrowsInfo(borrow);
            customer.addBorrowedBook(borrow);
            return true;

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
