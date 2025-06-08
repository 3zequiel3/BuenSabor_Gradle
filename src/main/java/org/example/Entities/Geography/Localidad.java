package org.example.Entities.Geography;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.Entities.Base;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "localidades")
public class Localidad extends Base {
    private String nombre;

    //Provincia
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "provincia_id")
    private Provincia provincia;

    @OneToMany(mappedBy = "localidad")
    @Builder.Default
    private Set<Domicilio> domicilios = new HashSet<>();

    //Metodos
    //Domicilio
    //Añadir
    public void añadirDomicilio(Domicilio domicilio) {
        this.domicilios.add(domicilio);
    }

    //Eliminar
    public void eliminarDomicilio(Domicilio domicilio) {
        this.domicilios.remove(domicilio);
    }

}
