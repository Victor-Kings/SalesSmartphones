package com.sales.smartphones.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler{
//    @ExceptionHandler
//    public ResponseEntity<ApiError> handleProductNotFoundException(ProductNotFoundException e, WebRequest request){
//        ApiError error = new ApiError(HttpStatus.NOT_FOUND,e.getMessage(),e);
//        return ResponseEntity.badRequest().body(error);
//    }
//    @ExceptionHandler
//    public ResponseEntity<ApiError> handleMarkNotInformedException(MarkNotInformedException e, WebRequest request){
//        ApiError error = new ApiError(HttpStatus.NOT_FOUND,e.getMessage(),e);
//        return ResponseEntity.badRequest().body(error);
//    }
    @ExceptionHandler({MarkNotInformedException.class, ProductNotFoundException.class, CustomerNotFoundException.class})
    public ResponseEntity<ApiError> handleNotInformedException(Exception e, WebRequest request){
        ApiError error = new ApiError(HttpStatus.NOT_FOUND,e.getMessage(),e);
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler
    public ResponseEntity<ApiError> handleAmountNotValidException(AmountNotValidException e, WebRequest request){
        ApiError error = new ApiError(HttpStatus.BAD_REQUEST,e.getMessage(),e);
        return ResponseEntity.badRequest().body(error);
    }
}
