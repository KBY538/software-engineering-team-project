package com.smu.camping.dto.reservation;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CampsiteReservationInfoDto {
    private List<String> operatingTypes;
    private List<String> facilities;

    private int pricePerExcessPerson;
    private int pricePerExcessCar;
}