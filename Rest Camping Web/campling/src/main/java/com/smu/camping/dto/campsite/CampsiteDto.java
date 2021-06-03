package com.smu.camping.dto.campsite;

import com.smu.camping.dto.file.FileInfoDto;
import com.smu.camping.dto.post.review.ReviewDto;
import com.smu.camping.dto.reservation.CampsiteReservationInfoDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CampsiteDto {
    private int id;
    
    private String owner;
    private String introduction;
    private String notice;

    private boolean isApprove;

    private CampsiteBaseInfoDto baseInfo;

    private CampsiteReservationInfoDto reservationInfo;
    private List<RoomDto> rooms;
    private List<MealKitDto> mealKits;

    private List<TouristDto> touristInfos;
    private List<RestaurantDto> restaurantInfos;

    private List<ReviewDto> reviews;

    private List<FileInfoDto> image;
}
