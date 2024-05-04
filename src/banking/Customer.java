package banking;

 class Customer {
    private String name;
    private Account account;

    public Customer(String name, Account account) {
        this.name = name;
        this.account = account;
    }

    public double calCustomerBalance() {
        return account.getCreditCard().getCurrentBalance();
    }

    @Override
    public String toString() {
        return "banking.Customer : " +
                "with name='" + name + '\'' +
                " has account : " + account.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
