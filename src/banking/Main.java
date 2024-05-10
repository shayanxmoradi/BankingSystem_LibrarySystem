package banking;

public class Main {
    public static void main(String[] args) {
        Branch branch = new Branch(12,"dortmund",Grade.LOW);
        CreditCard creditCard = new CreditCard("2412134634531224",55000);
        Account account = new Account("112342414124312",creditCard);
        Customer customer = new Customer("shayan",account);
        System.out.println(customer.calCustomerBalance());
        CreditCard newCreditCard = new CreditCard("2123412341234",55000);
        Account newAccount = new Account("5534123412341234",newCreditCard);
        customer.addAccounts(newAccount);
        System.out.println(customer.calCustomerBalance());
    }
}
