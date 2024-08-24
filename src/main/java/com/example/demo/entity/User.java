package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

// class này là một table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // UUID sẽ random ngẫu nhiên và không trùng lặp
    String id;

    String username;
    String password;
    String firstName;
    String lastName;
    LocalDate dob;

    /**
     * Set là một tập hợp các phần tử duy nhất, điều này có nghĩa là
     * mỗi phần tử chỉ được lưu trữ một lần trong Set.
     * Thứ hai, các phần tử trong Set không được sắp xếp theo bất kỳ
     * thứ tự nào và thứ tự của chúng có thể thay đổi khi bạn thêm
     * hoặc xóa các phần tử
     */
    @ManyToMany
    Set<Role> roles;
}
