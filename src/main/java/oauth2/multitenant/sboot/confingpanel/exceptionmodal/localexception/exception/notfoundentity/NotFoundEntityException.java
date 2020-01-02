package oauth2.multitenant.sboot.confingpanel.exceptionmodal.localexception.exception.notfoundentity;

public class NotFoundEntityException extends RuntimeException {

    public NotFoundEntityException() {
    }

    public NotFoundEntityException(String s) {
        super(s);
    }

    public NotFoundEntityException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NotFoundEntityException(Throwable throwable) {
        super(throwable);
    }

    public NotFoundEntityException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
