package com.loganhotel.co.loganHotel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "trabaja", schema = "hotel")
public class Trabaja {
    @EmbeddedId
    private TrabajaId id;
}
