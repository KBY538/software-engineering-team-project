package com.smu.camping.dto.campsite;

import lombok.*;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SearchFilterDto {
    private String campsiteName;
    private List<String> facilities;
    private List<String> operatings;
}