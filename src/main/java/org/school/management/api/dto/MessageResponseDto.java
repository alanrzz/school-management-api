package org.school.management.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class MessageResponseDto {

    private HttpStatus status;
    private final LocalDateTime timestamp;
    private String message;

    private MessageResponseDto() {
        timestamp = LocalDateTime.now();
    }

    public MessageResponseDto(HttpStatus status) {
        this();
        this.status = status;
    }

    public MessageResponseDto(HttpStatus status, String message) {
        this();
        this.status = status;
        this.message = message;
    }
}
