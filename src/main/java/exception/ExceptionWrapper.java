package exception;

public class ExceptionWrapper {
    public static String getWrapMessage(Exception e) {
        return "[ERROR]" + e.getMessage();
    }
}
