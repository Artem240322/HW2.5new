package pro.sky.hw_2_5.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class EmployeeStoragelsFullException extends RuntimeException {
}
