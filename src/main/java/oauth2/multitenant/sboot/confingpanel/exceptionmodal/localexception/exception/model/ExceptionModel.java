package oauth2.multitenant.sboot.confingpanel.exceptionmodal.localexception.exception.model;


import java.util.Date;

public class ExceptionModel {

    private int status;
    private String message;
    private Date date;

    public ExceptionModel(int status, String message, Date date) {
        super();
        this.status = status;
        this.message = message;
        this.date = date;
    }

    public ExceptionModel() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
