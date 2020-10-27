import java.util.Random;


public class BankTester {

  public static Random rng = new Random();

  public static void main(String args[]) {
    System.out.println(testAccountCreation());
    System.out.println(testSetPassword());
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
