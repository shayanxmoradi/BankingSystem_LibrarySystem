package banking;

 class Account {
    private String accountNumber;
    private CreditCard creditCard;

     Account(String accountNumber, CreditCard creditCard) {
        this.accountNumber = accountNumber;
        this.creditCard = creditCard;
    }

    @Override
    public String toString() {
        return "this banking.Account: " +
                "account number='" + accountNumber + '\'' +
                ", creditCard=" + creditCard.toString();
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }
}
