package com.smu.camping.mapper.campsite.imageInfoMapper;

import com.smu.camping.dto.campsite.ImageInfoDto;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageInfoMapper {
	public ImageInfoDto getImageInfoById(int campsiteId);
	public int createImageInfo(ImageInfoDto imageInfoDto);
	public int deleteImageInfoByImageInfos(int ImageInfoId);
}
