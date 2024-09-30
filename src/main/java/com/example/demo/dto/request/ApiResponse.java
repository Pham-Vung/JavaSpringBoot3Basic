package com.example.demo.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL) // để response trả về những trường dữ liệu nào null sẽ không hiển thị
public class ApiResponse<T> {
    @Builder.Default
    int code = 1000;

    String message;
    T result;
}
