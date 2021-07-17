package jp.ac.ait.k19061.section09;

public class PasswordRulesViolationException extends Exception {
    public PasswordRulesViolationException() {
        super();
    }
    public PasswordRulesViolationException(String message) {
        super(message);
    }
    public PasswordRulesViolationException(Throwable cause) {
        super(cause);
    }
    public PasswordRulesViolationException(String message, Throwable cause) {
        super(message, cause);
    }
}
