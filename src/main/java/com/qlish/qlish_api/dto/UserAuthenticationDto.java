package com.qlish.qlish_api.dto;

import com.qlish.qlish_api.constants.auth_enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class UserAuthenticationDto {

    private ObjectId id;
    private String firstname;
    private String lastname;
    private String email;
    private String profileName;
    private Role role;
    private String authProvider;
    private LocalDateTime createdAt;
    private LocalDateTime lastLoginAt;
}