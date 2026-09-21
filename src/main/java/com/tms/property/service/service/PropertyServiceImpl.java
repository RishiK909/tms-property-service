package com.tms.property.service.service;

import com.tms.property.service.dto.ApiResponse;
import com.tms.property.service.dto.PropertyRegisterDTO;
import com.tms.property.service.entity.Property;
import com.tms.property.service.repository.PropertyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;

    public PropertyServiceImpl(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public ApiResponse<Void> createProperty(UUID ownerId, PropertyRegisterDTO request) {
        Property property = new Property();
        property.setOwnerId(ownerId);
        property.setPropertyType(request.getPropertyType());
        property.setAddress(request.getAddress());
        property.setCity(request.getCity());
        property.setTitle(request.getTitle());
        property.setState(request.getState());
        property.setPostalCode(request.getPostalCode());
        property.setAreaSqft(request.getAreaSqft());
        property.setPropertyImageUrl(request.getPropertyImageUrl());
        property.setRentAmount(request.getRentAmount());
        property.setSecurityDeposit(request.getSecurityDeposit());

        propertyRepository.save(property);
        return new ApiResponse<>("Property created successfully", true);
    }

    @Override
    public ApiResponse<Property> getPropertyById(UUID id) {
        Optional<Property> propertyOptional = propertyRepository.findById(id);
        if (propertyOptional.isEmpty()) {
            return new ApiResponse<>("Property not found", false);
        }
        return new ApiResponse<>("Property fetched successfully", true, propertyOptional.get());
    }

    @Override
    public ApiResponse<List<Property>> getMyProperties(UUID ownerId) {
        List<Property> properties = propertyRepository.findByOwnerId(ownerId);
        return new ApiResponse<>("Properties fetched successfully", true, properties);
    }

    @Override
    public ApiResponse<Void> updateProperty(UUID id, UUID ownerId, PropertyRegisterDTO request) {
        Optional<Property> propertyOptional = propertyRepository.findById(id);
        if (propertyOptional.isEmpty()) {
            return new ApiResponse<>("Property not found", false);
        }

        Property property = propertyOptional.get();
        if (!property.getOwnerId().equals(ownerId)) {
            return new ApiResponse<>("You do not have permission to update this property", false);
        }

        property.setPropertyType(request.getPropertyType());
        property.setAddress(request.getAddress());
        property.setCity(request.getCity());
        property.setState(request.getState());
        property.setPostalCode(request.getPostalCode());
        property.setAreaSqft(request.getAreaSqft());
        property.setPropertyImageUrl(request.getPropertyImageUrl());
        property.setRentAmount(request.getRentAmount());
        property.setSecurityDeposit(request.getSecurityDeposit());

        propertyRepository.save(property);
        return new ApiResponse<>("Property updated successfully", true);
    }
}