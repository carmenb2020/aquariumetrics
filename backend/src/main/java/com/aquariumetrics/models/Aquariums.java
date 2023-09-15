package com.aquariumetrics.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="aquariums")
@NoArgsConstructor
@AllArgsConstructor
@CrossOrigin("*")
public class Aquariums {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name", nullable = false, length= 25)
    private String name;

    @Column(name = "anh3", nullable = false, scale = 1, columnDefinition="Decimal(2,1) default '00.0'")
    private Double anh3;

    @Column(name = "ano2", nullable = false, scale = 1, columnDefinition="Decimal(2,1) default '00.0'")
    private Double ano2;

    @Column(name = "ano3", nullable = false, scale = 1, columnDefinition="Decimal(2,1) default '00.0'")
    private Double ano3;

    @Column(name = "apo4", nullable = false, scale = 1, columnDefinition="Decimal(2,1) default '00.0'")
    private Double apo4;

    @Column(name = "agh", nullable = false, scale = 1, columnDefinition="Decimal(2,1) default '00.0'")
    private Double agh;

    @Column(name = "akh", nullable = false, scale = 1, columnDefinition="Decimal(2,1) default '00.0'")
    private Double akh;

    @Column(name = "aph", nullable = false, scale = 1, columnDefinition="Decimal(2,1) default '00.0'")
    private Double aph;

/*    @OneToMany(mappedBy = "aquariums", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Metrics> metricsList;

 */
}
