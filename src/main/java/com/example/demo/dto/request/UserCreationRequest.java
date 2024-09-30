package com.example.demo.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;

import com.example.demo.validator.DobConstraint;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor // hàm tạo k tham số
@AllArgsConstructor // hàm tạo chứa tất cả các field
@Builder // giúp khởi tạo đối tượng nhanh hơn với so lượng field tùy ý
@FieldDefaults(level = AccessLevel.PRIVATE) // mọi field đều là private
public class UserCreationRequest {
    @Size(min = 3, message = "USERNAME_INVALID")
    String username;

    @Size(min = 8, message = "INVALID_PASSWORD")
    String password;

    String firstName;
    String lastName;

    @DobConstraint(min = 18, message = "INVALID_DOB")
    LocalDate dob;
}
