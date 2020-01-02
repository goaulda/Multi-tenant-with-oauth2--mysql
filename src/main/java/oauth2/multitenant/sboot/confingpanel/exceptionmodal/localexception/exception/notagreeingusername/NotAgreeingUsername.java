package oauth2.multitenant.sboot.confingpanel.exceptionmodal.localexception.exception.notagreeingusername;

import oauth2.multitenant.sboot.confingpanel.exceptionmodal.localexception.exception.model.ExceptionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
@RestController
public class NotAgreeingUsername extends NotAgreeingUsernameException {

    @ExceptionHandler
    public final ResponseEntity<ExceptionModel> handleNotAgreeingUsernameException(NotAgreeingUsernameException ex, WebRequest request) {
        Date date = new Date();
        ExceptionModel errorDetails = new ExceptionModel(401, ex.getMessage(), date);
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }


}
