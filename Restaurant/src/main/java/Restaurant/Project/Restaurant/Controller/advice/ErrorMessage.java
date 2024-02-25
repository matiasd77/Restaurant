package Restaurant.Project.Restaurant.Controller.advice;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorMessage {
    private LocalDateTime time;
    private String message;
    private String path;
}
