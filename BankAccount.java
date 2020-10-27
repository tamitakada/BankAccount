public class BankAccount {

  private double balance;
  private int accountID;
  private String password;

  public static void main(String args[]) {

  }

  public BankAccount(int a, String p) {
    balance = 0;
    accountID = a;
    password = p;
  }

  public double getBalance() {
    return balance;
  }

  public int getAccountID() {
    return accountID;
  }

  public void setPasssword(String p) {
    password = p;
  }

}
