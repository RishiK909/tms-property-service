package com.tms.property.service.controller;

import com.tms.property.service.dto.ApiResponse;
import com.tms.property.service.dto.PropertyRegisterDTO;
import com.tms.property.service.entity.Property;
import com.tms.property.service.service.PropertyService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/property")
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping
    @PreAuthorize("hasRole('Owner')")
    public ResponseEntity<ApiResponse<Void>> createProperty(
            @Valid @RequestBody PropertyRegisterDTO request,
            HttpServletRequest httpRequest) {
        UUID ownerId = (UUID) httpRequest.getAttribute("userId");
        ApiResponse<Void> response = propertyService.createProperty(ownerId, request);
        return response.isStatus() ? ResponseEntity.ok(response) : ResponseEntity.badRequest().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Property>> getPropertyById(@PathVariable UUID id) {
        ApiResponse<Property> response = propertyService.getPropertyById(id);
        return response.isStatus() ? ResponseEntity.ok(response) : ResponseEntity.badRequest().body(response);
    }

    @GetMapping("/my-properties")
    @PreAuthorize("hasRole('Owner')")
    public ResponseEntity<ApiResponse<List<Property>>> getMyProperties(HttpServletRequest httpRequest) {
        UUID ownerId = (UUID) httpRequest.getAttribute("userId");
        return ResponseEntity.ok(propertyService.getMyProperties(ownerId));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('Owner')")
    public ResponseEntity<ApiResponse<Void>> updateProperty(
            @PathVariable UUID id,
            @Valid @RequestBody PropertyRegisterDTO request,
            HttpServletRequest httpRequest) {
        UUID ownerId = (UUID) httpRequest.getAttribute("userId");
        ApiResponse<Void> response = propertyService.updateProperty(id, ownerId, request);
        return response.isStatus() ? ResponseEntity.ok(response) : ResponseEntity.badRequest().body(response);
    }
}