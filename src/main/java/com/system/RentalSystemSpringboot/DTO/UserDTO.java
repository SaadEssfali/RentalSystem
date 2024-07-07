package com.system.RentalSystemSpringboot.DTO;

import lombok.Data;

@Data
public class UserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String keycloakId;
    private Boolean enabled;
    private Boolean accountLocked;
    private String etat;
}
