CREATE TABLE properties
(
    id                  UUID NOT NULL,
    owner_id            UUID NOT NULL,
    title               VARCHAR(100) NOT NULL,
    property_type       VARCHAR(50) NOT NULL,
    address             VARCHAR(255) NOT NULL,
    city                VARCHAR(50) NOT NULL,
    state               VARCHAR(50) NOT NULL,
    postal_code         VARCHAR(10),
    area_sqft           INT,
    property_image_url  VARCHAR(500),
    rent_amount         DECIMAL(10,2) NOT NULL,
    security_deposit    DECIMAL(10,2),
    occupancy_status    VARCHAR(50) NOT NULL DEFAULT 'VACANT',

    created_at          TIMESTAMP WITHOUT TIME ZONE,
    created_by          UUID,
    updated_at          TIMESTAMP WITHOUT TIME ZONE,
    updated_by          UUID,
    deleted_at          TIMESTAMP WITHOUT TIME ZONE,
    status              VARCHAR(255),
    version             BIGINT,

    CONSTRAINT pk_properties PRIMARY KEY (id)
);