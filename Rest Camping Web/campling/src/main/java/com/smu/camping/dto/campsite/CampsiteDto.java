package com.smu.camping.dto.campsite;

import com.smu.camping.dto.file.FileInfoDto;
import com.smu.camping.dto.post.review.ReviewDto;
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
    private boolean isApprove;

    private String name;
    private String address;
    private String contact;

    private String introduction;
    private String notice;
    private int cheapestRoomPrice;

    private int pricePerExcessPerson;
    private int pricePerExcessCar;

    private List<String> operatingTypes;
    private List<String> facilities;

    private List<RoomDto> rooms;
    private List<MealKitDto> mealKits;

    private List<TouristDto> touristInfos;
    private List<RestaurantDto> restaurantInfos;

    private List<ReviewDto> reviews;

    private FileInfoDto image;
}
