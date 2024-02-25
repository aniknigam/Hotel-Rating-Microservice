package com.lcdw.user.service.payload;

import lombok.*;
import org.springframework.http.HttpStatus;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private String message ;

    private boolean success;

    private HttpStatus status;

}
