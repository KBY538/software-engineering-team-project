package com.smu.camping.dto.file;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FileInfoDto {
    private int id;
    
    private String username;

    private String filePath;
}
