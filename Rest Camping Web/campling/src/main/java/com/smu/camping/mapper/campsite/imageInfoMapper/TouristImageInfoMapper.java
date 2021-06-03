package com.smu.camping.mapper.campsite.imageInfoMapper;

import com.smu.camping.dto.campsite.ImageInfoDto;
import org.springframework.stereotype.Repository;

@Repository
public interface TouristImageInfoMapper extends ImageInfoMapper {
	ImageInfoDto getImageInfoById(int touristId);
	int createImageInfo(ImageInfoDto imageInfoDto);
}
