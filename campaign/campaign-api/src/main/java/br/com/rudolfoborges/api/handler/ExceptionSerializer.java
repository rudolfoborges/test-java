package br.com.rudolfoborges.api.handler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rudolfoborges
 * @since 7/26/17 12:45 PM
 */
public class ExceptionSerializer {

    private final int status;

    private final List<ErroItem> errors;

    public ExceptionSerializer(int status) {
        this.status = status;
        this.errors = new ArrayList<>();
    }

    public void addErro(String code, String message) {
        errors.add(new ErroItem(code, message));
    }

    public List<ErroItem> getErrors() {
        return errors;
    }

    public int getStatus() {
        return status;
    }

}

class ErroItem {

    private final String code;
    private final String message;

    public ErroItem(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
