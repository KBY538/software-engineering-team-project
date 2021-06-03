package com.smu.camping.dto.post.marker;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MarkerDto {
    private int id;

    private String username;
    
    private String location;
    private String campInfo;
    private String memo;

    @JsonFormat(pattern = "yyyyMMdd", timezone = "Asia/Seoul")
    private Date createDate;
}
