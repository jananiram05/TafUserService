package com.tekarch.TafUserService.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String phone;
    private LocalDateTime createdAt = LocalDateTime.now();  // Timestamp for when the account was created

    private LocalDateTime updatedAt = LocalDateTime.now();


}