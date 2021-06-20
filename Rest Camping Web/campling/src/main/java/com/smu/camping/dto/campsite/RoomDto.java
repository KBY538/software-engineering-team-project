package com.smu.camping.dto.campsite;

import com.smu.camping.dto.file.FileInfoDto;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RoomDto {
    private int id;
    private int campsiteId;

    private String name;
    private int price;
    private int roomNums;

    private int maxHeadCnt;
    private int baseHeadCnt;
    private int baseNumCars;

    private FileInfoDto image;
}
