package com.user.servies.UserService.com.user.response;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {

    private String msg;
    private Boolean success;
    private HttpStatus status;

}
