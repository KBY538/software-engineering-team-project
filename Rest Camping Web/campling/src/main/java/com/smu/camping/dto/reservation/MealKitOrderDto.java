package com.smu.camping.dto.reservation;

import com.smu.camping.dto.campsite.MealKitDto;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MealKitOrderDto {
    private int id;
    private int cnt;
    private int reservationId;
    private MealKitDto mealKit;
}
