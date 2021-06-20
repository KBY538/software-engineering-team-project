package com.smu.camping.dto.campsite;

import com.smu.camping.dto.file.FileInfoDto;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MealKitDto {
    private int id;
    private int campsiteId;

    private String name;
    private int price;

    private int numRemains;

    private FileInfoDto image;
}
