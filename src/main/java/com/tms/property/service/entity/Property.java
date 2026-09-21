package com.tms.property.service.entity;

import com.tms.property.service.enums.OccupancyStatus;
import com.tms.property.service.enums.PropertyType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "properties")
public class Property extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID propertyId;

    @Column(name = "owner_id", nullable = false)
    private UUID ownerId;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "property_type", nullable = false)
    private PropertyType propertyType;

    @Column(name = "address", nullable = false, length = 255)
    private String address;

    @Column(name = "city", nullable = false, length = 50)
    private String city;

    @Column(name = "state", nullable = false, length = 50)
    private String state;

    @Column(name = "postal_code", length = 10)
    private String postalCode;

    @Column(name = "area_sqft")
    private Integer areaSqft;

    @Column(name = "property_image_url", length = 500)
    private String propertyImageUrl;

    @Column(name = "rent_amount", nullable = false)
    private BigDecimal rentAmount;

    @Column(name = "security_deposit")
    private BigDecimal securityDeposit;

    @Enumerated(EnumType.STRING)
    @Column(name = "occupancy_status")
    private OccupancyStatus occupancyStatus = OccupancyStatus.VACANT;

    public Property() {}

    public Property(UUID propertyId, UUID ownerId, String title, PropertyType propertyType, String address, String city, String state, String postalCode, Integer areaSqft, String propertyImageUrl, BigDecimal rentAmount, BigDecimal securityDeposit, OccupancyStatus occupancyStatus) {
        this.propertyId = propertyId;
        this.ownerId = ownerId;
        this.title = title;
        this.propertyType = propertyType;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.areaSqft = areaSqft;
        this.propertyImageUrl = propertyImageUrl;
        this.rentAmount = rentAmount;
        this.securityDeposit = securityDeposit;
        this.occupancyStatus = occupancyStatus;
    }

    public UUID getPropertyId() { return propertyId; }
    public void setPropertyId(UUID propertyId) { this.propertyId = propertyId; }

    public UUID getOwnerId() { return ownerId; }
    public void setOwnerId(UUID ownerId) { this.ownerId = ownerId; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PropertyType getPropertyType() { return propertyType; }
    public void setPropertyType(PropertyType propertyType) { this.propertyType = propertyType; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    public Integer getAreaSqft() { return areaSqft; }
    public void setAreaSqft(Integer areaSqft) { this.areaSqft = areaSqft; }

    public String getPropertyImageUrl() { return propertyImageUrl; }
    public void setPropertyImageUrl(String propertyImageUrl) { this.propertyImageUrl = propertyImageUrl; }

    public BigDecimal getRentAmount() { return rentAmount; }
    public void setRentAmount(BigDecimal rentAmount) { this.rentAmount = rentAmount; }

    public BigDecimal getSecurityDeposit() { return securityDeposit; }
    public void setSecurityDeposit(BigDecimal securityDeposit) { this.securityDeposit = securityDeposit; }


    public OccupancyStatus getOccupancyStatus() {
        return occupancyStatus;
    }

    public void setOccupancyStatus(OccupancyStatus occupancyStatus) {
        this.occupancyStatus = occupancyStatus;
    }
}
