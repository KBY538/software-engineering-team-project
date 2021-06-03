package com.smu.camping.dto.post.review;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.smu.camping.dto.campsite.RoomDto;
import lombok.*;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {
    private int id;

    private int campsiteId;
    private int roomId;
    private RoomDto roomDto;

    private String writer;
    private String content;
    private int numStars;

    @JsonFormat(pattern = "yyyyMMdd", timezone = "Asia/Seoul")
    private Date createDate;

    private ReviewCommentDto reviewComment;
}
