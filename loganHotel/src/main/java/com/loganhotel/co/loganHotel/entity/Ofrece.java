package com.loganhotel.co.loganHotel.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ofrece", schema = "hotel")
public class Ofrece {
    @EmbeddedId
    private OfreceId id;
}
