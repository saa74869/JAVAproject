public class InvalidCreditCardException extends Exception {
  public InvalidCreditCardException() {
    super("Error:  Wrong credit card number!!  Only enter 16 numbers on your credit card.");
  }
  
  public InvalidCreditCardException(String message) {
    super(message);
  }
}