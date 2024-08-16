package com.example.demo.dto.request;

import com.example.demo.exception.ErrorCode;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor// hàm tạo k tham số
@AllArgsConstructor// hàm tạo chứa tất cả các field
@Builder // giúp khởi tạo đối tượng nhanh hơn với so lượng field tùy ý
@FieldDefaults(level = AccessLevel.PRIVATE)// mọi field đều là private

public class UserCreationRequest {
    @Size(min = 3, message = "USERNAME_INVALID")
    String username;

    @Size(min = 8, message = "INVALID_PASSWORD")
    String password;
    String firstName;
    String lastName;
    LocalDate dob;
}
