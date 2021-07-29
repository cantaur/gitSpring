package soo.ct.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class ToDoDTO {
    private String subject;

    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date cdate;
}

