package Restaurant.Project.Restaurant.Controller.advice;

import Restaurant.Project.Restaurant.Controller.exceptions.BadRequestException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExcptionHandler {


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorMessage> handleRuntimeExceptions(RuntimeException ex){
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setTime(LocalDateTime.now());
        errorMessage.setMessage("Something went wrong");
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorMessage> handleBadRequestExceptions(BadRequestException ex, HttpServletRequest httpServletRequest){
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setTime(LocalDateTime.now());
        errorMessage.setMessage(ex.getMessage());
        errorMessage.setPath(httpServletRequest.getServletPath());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
