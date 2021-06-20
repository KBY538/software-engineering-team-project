package com.smu.camping.dto.reservation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.smu.camping.dto.campsite.CampsiteDto;
import com.smu.camping.dto.campsite.RoomDto;
import com.smu.camping.dto.user.UserDto;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {
    private int id;
    private String username;
    private String bookerName;
    private String bookerPhoneNum;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private Date checkInDate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private Date checkOutDate;

    private boolean isApprove;

    private int reservationHeadCnt;
    private int reservationNumCars;
    
    private List<MealKitOrderDto> mealKitOrders;
    private RoomDto roomDto;
    private CampsiteDto campsiteDto;
    
    private int totalPrice;
}