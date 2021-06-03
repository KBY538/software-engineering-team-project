package com.smu.camping.dto.campsite;

import com.smu.camping.dto.file.FileInfoDto;
import lombok.*;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TouristDto {
    private int id;

    private int campsiteId;

    private String name;
    private String desc;
    private String address;

    private List<FileInfoDto> image;
}
