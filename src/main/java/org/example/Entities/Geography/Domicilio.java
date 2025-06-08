package org.example.Entities.Geography;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.Entities.Base;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder
@Table(name = "domicilios")
public class Domicilio extends Base {
    @Column(nullable = false)
    private String calle;
    @Column(nullable = false)
    private int numero;
    @Column(nullable = false)
    private int cp;

    //Localidad
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "localidad_id")
    private Localidad localidad;


}
