import java.util.Random;


public class BankTester {

  public static Random rng = new Random();

  public static void main(String args[]) {
    System.out.println(testAccountCreation());
    System.out.println(testSetPassword());
    System.out.println(testDeposit());
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

  public static boolean testSetPassword() {
    BankAccount accountOne = new BankAccount(1234, "password");
    if (accountOne.getPassword() != "password") return false;

    accountOne.setPasssword("hello");
    if (accountOne.getPassword() != "hello") return false;

    for (int i = 0; i < 100; i++) {
      String password = randomPassword();
      int id = rng.nextInt();
      BankAccount account = new BankAccount(id, password);
      if (account.getPassword() != password) return false;

      String newPassword = randomPassword();
      account.setPasssword(newPassword);
      if (account.getPassword() != newPassword) return false;
    }

    return true;
  }

  public static boolean testDeposit() {
    BankAccount accountOne = new BankAccount(1234, "password");
    if (accountOne.getBalance() != 0) return false;

    if (accountOne.deposit(-90)) return false;
    if (accountOne.getBalance() != 0) return false;

    if (!accountOne.deposit(100)) return false;
    if (accountOne.getBalance() != 100) return false;

    for (int i = 0; i < 100; i++) {
      BankAccount account = new BankAccount(100, "abc");
      double oldBalance = account.getBalance();
      if (oldBalance != 0) return false;

      double toAdd = rng.nextDouble();
      boolean expected = true;
      if (toAdd < 0) expected = false;

      if (account.deposit(toAdd) != expected) return false;
      if ((expected) && (account.getBalance() != (oldBalance + toAdd))) return false;
    }

    return true;
  }

  public static String randomPassword() {
    char[] allChars = new char[] {
      'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
      'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
      'W', 'X', 'Y', 'Z'
    };

    String pass = "";

    for (int i = 0; i < rng.nextInt(101); i++) {
      int rand = rng.nextInt(26);
      pass += allChars[rand];
    }

    return pass;
  }

}
