import java.util.Random;


public class BankTester {

  public static Random rng = new Random();

  public static void main(String args[]) {
    System.out.println(testAccountCreation());

  }

  public static boolean testAccountCreation() {
    BankAccount accountOne = new BankAccount(1234, "password");
    if (accountOne.getBalance() != 0) return false;
    if (accountOne.getAccountID() != 1234) return false;

    for (int i = 0; i < 100; i++) {
      String password = "abc";
      int id = rng.nextInt();
      BankAccount account = new BankAccount(id, password);
      if (account.getBalance() != 0) return false;
      if (account.getAccountID() != id) return false;
    }

    return true;
  }

}
