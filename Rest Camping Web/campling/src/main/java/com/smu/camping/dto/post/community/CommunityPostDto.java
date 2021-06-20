package com.smu.camping.dto.post.community;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CommunityPostDto {
    private int id;
    
    private String title;
    private String type;
    private String writer;
    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private Date createDate;
    
    private List<CommunityCommentDto> comments;
}
