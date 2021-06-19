package com.smu.camping.mapper.file;

import com.smu.camping.dto.file.FileInfoDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileInfoMapper {
	public int createFileInfos(FileInfoDto fileInfoDtos);
	public int deleteFileInfo(int fileId);
	public FileInfoDto getFileInfo(int fileId);
	public FileInfoDto getFileInfoByCampsiteId(int campsiteId);
}
