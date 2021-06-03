package com.smu.camping.dto.post.question;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class CampsiteQuestionDto {

    private int id;

    private int campsiteId;
    
    private String writer;
    private String title;
    private String type;
    private String content;
    private boolean isAnswer;

    @JsonFormat(pattern = "yyyyMMdd", timezone = "Asia/Seoul")
    private Date createDate;

    private CampsiteQuestionCommentDto questionCommentInfo;
    
}
