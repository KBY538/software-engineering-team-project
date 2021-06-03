package com.smu.camping.dto.reservation;

import com.smu.camping.dto.campsite.MealKitDto;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MealKitOrderDto {
    private int cnt;
    private MealKitDto mealKit;
}
