package net.javaguides.springboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    // User first name should not be null or empty
    @NotEmpty(message = "User first name should not be null or empty")
    private String firstName;

    // User last name should not be null or empty
    @NotEmpty(message = "User last name should not be null or empty")
    private String lastName;

    // User email should not be null or empty
    // Email address should be valid
    @NotEmpty(message = "User email should not be null or empty")
    @Email(message = "Email address should be valid")
    private String email;
}
