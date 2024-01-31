package tech.group15.springbootbestpractice.exception;

public class CustomerNotFoundException extends RuntimeException {
  public CustomerNotFoundException(String errorMessage) {
    super(errorMessage);
  }
}
