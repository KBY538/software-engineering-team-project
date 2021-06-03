package com.smu.camping.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
    private boolean error;
    private String errorMessage;
}