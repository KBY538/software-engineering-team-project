package com.smu.camping.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String username;
    private String password;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private Date createDate;
}
