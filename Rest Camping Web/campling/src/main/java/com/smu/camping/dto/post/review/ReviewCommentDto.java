package com.smu.camping.dto.post.review;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReviewCommentDto {

    private int id;

    private int reviewId;

    private String writer;
    private String content;

    @JsonFormat(pattern = "yyyyMMdd", timezone = "Asia/Seoul")
    private Date createDate;
}
