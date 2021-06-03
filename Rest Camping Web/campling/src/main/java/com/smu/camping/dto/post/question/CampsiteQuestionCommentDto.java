package com.smu.camping.dto.post.question;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CampsiteQuestionCommentDto {
    private int id;

    private int questionId;

    private String writer;
    private String content;

    @JsonFormat(pattern = "yyyyMMdd", timezone = "Asia/Seoul")
    private Date createDate;
}