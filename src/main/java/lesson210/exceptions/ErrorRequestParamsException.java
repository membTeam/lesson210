package lesson210.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ErrorRequestParamsException extends RuntimeException {
    public ErrorRequestParamsException(String err) {
        super(err);
    }
}
