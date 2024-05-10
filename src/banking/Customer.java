package banking;

 class Customer {
    private String name;
    private Account account;
    private Account[] accounts= new Account[1];

    public Customer(String name, Account account) {
        this.name = name;
        this.account = account;
        accounts[0] = account;
    }


    public double calCustomerBalance() {
        double balance = 0;
        for (Account account : accounts) {
            balance+= account.getCreditCard().getCurrentBalance();
        }
        return balance;

    }
     public void addAccounts(Account account) {
         int sizeBevore=  accounts.length;
         Account[] newAccounts= new Account[sizeBevore+1];
         System.arraycopy(accounts, 0, newAccounts, 0, sizeBevore);
         newAccounts[sizeBevore] = account;
         accounts = newAccounts;
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

     public Account[] getAccounts() {
         return accounts;
     }


 }
