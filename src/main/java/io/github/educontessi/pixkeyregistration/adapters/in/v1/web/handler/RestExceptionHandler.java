package io.github.educontessi.pixkeyregistration.adapters.in.v1.web.handler;

import io.github.educontessi.pixkeyregistration.adapters.in.v1.web.exception.DtoInvalidoException;
import io.github.educontessi.pixkeyregistration.adapters.in.v1.web.response.ErrorDetail;
import io.github.educontessi.pixkeyregistration.adapters.in.v1.web.response.ErrorType;
import io.github.educontessi.pixkeyregistration.adapters.in.v1.web.response.ResponseError;
import io.github.educontessi.pixkeyregistration.core.exception.EntityNotFoundException;
import io.github.educontessi.pixkeyregistration.core.exception.NegocioException;
import io.github.educontessi.pixkeyregistration.core.exception.ValidacaoChavePixException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Eduardo Possamai Contessi
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    public static final String GENERIC_ERROR_MESSAGE_TO_END_USER
            = "An unexpected internal system error has occurred. Please try again and if "
            + "the problem persists, contact your system administrator.";

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        HttpStatus statusResponse = HttpStatus.UNPROCESSABLE_ENTITY;
        ErrorType errorType = ErrorType.INVALID_REQUEST;
        String userMessage = "Content-Type was not informed";

        ResponseError responseError = getRequestError(ex, statusResponse, errorType, userMessage);
        return handleExceptionInternal(ex, responseError, headers, statusResponse, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        HttpStatus statusResponse = HttpStatus.UNPROCESSABLE_ENTITY;
        ErrorType errorType = ErrorType.INCOMPREHENSIVE_MESSAGE;
        String userMessage = "The request body is invalid. Check syntax error.";

        ResponseError responseError = getRequestError(ex, statusResponse, errorType, userMessage);
        return handleExceptionInternal(ex, responseError, headers, statusResponse, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatusCode status, WebRequest request) { // Exception usada quando não utiliza dto
        HttpStatus statusResponse = HttpStatus.UNPROCESSABLE_ENTITY;
        ErrorType errorType = ErrorType.INVALID_DATA;
        String userMessage = "One or more fields are invalid. Please fill in correctly and try again.";

        ResponseError responseError = getRequestError(ex, statusResponse, errorType, userMessage);
        responseError.setDatails(getErrorDatails(ex.getBindingResult()));
        return handleExceptionInternal(ex, responseError, headers, statusResponse, request);
    }

    @ExceptionHandler({NegocioException.class})
    public ResponseEntity<Object> handleNegocioException(NegocioException ex, WebRequest request) {
        HttpStatus statusResponse = HttpStatus.UNPROCESSABLE_ENTITY;
        ErrorType errorType = ErrorType.BUSINESS_ERROR;
        String userMessage = ex.getMessage();

        ResponseError responseError = getRequestError(ex, statusResponse, errorType, userMessage);
        return handleExceptionInternal(ex, responseError, new HttpHeaders(), statusResponse, request);
    }

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request) {
        HttpStatus statusResponse = HttpStatus.NOT_FOUND;
        ErrorType errorType = ErrorType.RESOURCE_NOT_FOUND;
        String userMessage = ex.getMessage();

        ResponseError responseError = getRequestError(ex, statusResponse, errorType, userMessage);
        return handleExceptionInternal(ex, responseError, new HttpHeaders(), statusResponse, request);
    }

    @ExceptionHandler({DtoInvalidoException.class})
    public ResponseEntity<Object> handleDtoInvalidoException(DtoInvalidoException ex, WebRequest request) {
        HttpStatus statusResponse = HttpStatus.UNPROCESSABLE_ENTITY;
        ErrorType errorType = ErrorType.BUSINESS_ERROR;
        String userMessage = ex.getMessage();

        ResponseError responseError = getRequestError(ex, statusResponse, errorType, userMessage);
        return handleExceptionInternal(ex, responseError, new HttpHeaders(), statusResponse, request);
    }

    @ExceptionHandler({ValidacaoChavePixException.class})
    public ResponseEntity<Object> handleValidacaoChavePixException(ValidacaoChavePixException ex, WebRequest request) {
        HttpStatus statusResponse = HttpStatus.UNPROCESSABLE_ENTITY;
        ErrorType errorType = ErrorType.INVALID_DATA;
        String userMessage = ex.getMessage();

        ResponseError responseError = getRequestError(ex, statusResponse, errorType, userMessage);
        return handleExceptionInternal(ex, responseError, new HttpHeaders(), statusResponse, request);
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex, WebRequest request) {
        HttpStatus statusResponse = HttpStatus.UNPROCESSABLE_ENTITY;
        ErrorType errorType = ErrorType.INVALID_DATA;
        String userMessage = ex.getMessage();

        ResponseError responseError = getRequestError(ex, statusResponse, errorType, userMessage);
        return handleExceptionInternal(ex, responseError, new HttpHeaders(), statusResponse, request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleUncaught(Exception ex, WebRequest request) {
        HttpStatus statusResponse = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorType errorType = ErrorType.INTERNAL_SERVER_ERROR;

        ResponseError responseError = getRequestError(ex, statusResponse, errorType, GENERIC_ERROR_MESSAGE_TO_END_USER);
        return handleExceptionInternal(ex, responseError, new HttpHeaders(), statusResponse, request);
    }

    protected ResponseError getRequestError(Exception ex, HttpStatus status, ErrorType errorType, String userMessage) {
        ResponseError responseError = new ResponseError();
        responseError.setStatus(status.value());
        responseError.setTimestamp(OffsetDateTime.now());
        responseError.setType(errorType.name());
        responseError.setTitle(errorType.getTitle());
        responseError.setUrlError(errorType.getPath());
        responseError.setUserMessage(userMessage);
        responseError.setException(ex.getClass().getName());
        responseError.setExceptionMessage(ex.getMessage());

        return responseError;
    }

    protected List<ErrorDetail> getErrorDatails(BindingResult bindingResult) {
        List<ErrorDetail> erros = new ArrayList<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            var field = fieldError.getField();
            var userMessage = Objects.requireNonNull(fieldError.getDefaultMessage()).replace("{0}", fieldError.getField());
            var exceptionMessage = fieldError.toString();
            erros.add(new ErrorDetail(field, userMessage, exceptionMessage));
        }
        return erros;
    }

}
