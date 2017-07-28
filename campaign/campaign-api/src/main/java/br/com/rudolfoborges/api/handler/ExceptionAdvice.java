package br.com.rudolfoborges.api.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import br.com.rudolfoborges.core.exception.CampaignException;

/**
 * @author rudolfoborges
 * @since 7/26/17 12:38 PM
 */
@RestControllerAdvice
public class ExceptionAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionAdvice.class);


    @ResponseBody
    @ExceptionHandler(value = {CampaignException.class})
    public ResponseEntity<ExceptionSerializer> handler(CampaignException e, HttpServletRequest request) {

        final ResponseStatus responseStatus = e.getClass().getAnnotation(ResponseStatus.class);
        final HttpStatus httpStatus = responseStatus.value();

        final String message = e.getMessage();

        LOGGER.warn("Status: ERROR, HttpStatus: {},  Message: {}", httpStatus.value(), message);

        final ExceptionSerializer exceptionSerializer = new ExceptionSerializer(httpStatus.value());
        exceptionSerializer.addErro(httpStatus.toString(), message);

        return ResponseEntity.status(httpStatus).body(exceptionSerializer);
    }


}
