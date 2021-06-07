package com.smu.camping.mapper.campsite;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacilityMapper {
    List<String> getCampsiteFacilityByCampsiteId(int campsiteId);
    int createCampsiteFacility(int campsiteId, List<String> facilityNames);
}
