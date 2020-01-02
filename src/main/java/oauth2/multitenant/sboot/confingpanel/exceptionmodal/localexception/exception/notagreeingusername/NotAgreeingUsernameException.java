package oauth2.multitenant.sboot.confingpanel.exceptionmodal.localexception.exception.notagreeingusername;

public class NotAgreeingUsernameException extends RuntimeException {

    public NotAgreeingUsernameException() {
    }

    public NotAgreeingUsernameException(String s) {
        super(s);
    }

    public NotAgreeingUsernameException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NotAgreeingUsernameException(Throwable throwable) {
        super(throwable);
    }

    public NotAgreeingUsernameException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
