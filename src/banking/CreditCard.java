package banking;

 class CreditCard {
    private String creditCardNumber;
    private double currentBalance;

    public CreditCard(String creditCardNumber, double currentBalance) {
        this.creditCardNumber = creditCardNumber;
        this.currentBalance = currentBalance;
    }

    @Override
    public String toString() {
        return "banking.CreditCard  has " +
                "creditcard Number='" + creditCardNumber + '\'' +
                ", with currentBalance=" + currentBalance;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }
}
