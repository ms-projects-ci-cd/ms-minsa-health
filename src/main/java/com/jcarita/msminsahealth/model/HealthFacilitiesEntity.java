package com.jcarita.msminsahealth.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "health_facilities")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HealthFacilitiesEntity {

    @Id
    @Column(name = "id_eess")
    private Long id;

    @Column(name="codigo_renaes")
    private String codeR;

    @Column(name="categoria")
    private String category;

    @Column(name="nombre")
    private String name;

    @Column(name="diresa")
    private String description;

    @Column(name="red")
    private String red;

    @Column(name="direccion")
    private String address;

    @Column(name="longitud")
    private String longitude;

    @Column(name="latitud")
    private String latitude;

    @Column(name="id_ubigeo")
    private String ubigeoCode;
}
