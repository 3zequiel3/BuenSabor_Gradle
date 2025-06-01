package org.example.Entities.Geography;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.Entities.Base;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Entity
public class Localidad extends Base {
    private String nombre;
    //Domicilio
    @OneToMany
    @Builder.Default
    private List<Domicilio> domicilios = new ArrayList<>();
    //Provincia
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "provincia_id")
    private Provincia provincia;

    //Metodos
        //Domicilio
            //Añadir
    public void añadirDomicilio(Domicilio domicilio){
        this.domicilios.add(domicilio);
    }
            //Eliminar
    public void eliminarDomicilio(Domicilio domicilio){
        this.domicilios.remove(domicilio);
    }

}
