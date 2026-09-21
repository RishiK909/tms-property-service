package com.tms.property.service.service;

import com.tms.property.service.dto.ApiResponse;
import com.tms.property.service.dto.PropertyRegisterDTO;
import com.tms.property.service.entity.Property;

import java.util.List;
import java.util.UUID;

public interface PropertyService {

    ApiResponse<Void> createProperty(UUID ownerId, PropertyRegisterDTO request);
    ApiResponse<Property> getPropertyById(UUID id);
    ApiResponse<List<Property>> getMyProperties(UUID ownerId);
    ApiResponse<Void> updateProperty(UUID id, UUID ownerId, PropertyRegisterDTO request);

}
