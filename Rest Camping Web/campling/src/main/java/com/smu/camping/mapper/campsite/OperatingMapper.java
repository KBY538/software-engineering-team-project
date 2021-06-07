package com.smu.camping.mapper.campsite;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperatingMapper {
    List<String> getCampsiteOperatingByCampsiteId(int campsiteId);
    int createCampsiteOperating(int campsiteId, List<String> types);
}
