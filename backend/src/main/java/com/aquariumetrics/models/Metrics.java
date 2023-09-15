package com.aquariumetrics.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name="metrics")
@NoArgsConstructor
@AllArgsConstructor
@CrossOrigin("*")
public class Metrics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date day;

    @Column(name = "nh3", nullable = false, scale = 1, columnDefinition="Decimal(3,1) default '00.0'")
    private Double nh3;

    @Column(name = "no2", nullable = false, scale = 1, columnDefinition="Decimal(3,1) default '00.0'")
    private Double no2;

    @Column(name = "no3", nullable = false, scale = 1, columnDefinition="Decimal(3,1) default '00.0'")
    private Double no3;

    @Column(name = "po4", nullable = false, scale = 1, columnDefinition="Decimal(3,1) default '00.0'")
    private Double po4;

    @Column(name = "gh", nullable = false, scale = 1, columnDefinition="Decimal(3,1) default '00.0'")
    private Double gh;

    @Column(name = "kh", nullable = false, scale = 1, columnDefinition="Decimal(3,1) default '00.0'")
    private Double kh;

    @Column(name = "ph", nullable = false, scale = 1, columnDefinition="Decimal(3,1) default '00.0'")
    private Double ph;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "aquarium_id", referencedColumnName = "id")
    private Aquariums aquariums;

}