package org.example.Entities.Geography;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.Entities.Base;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Entity
@Table(name = "localidades")
public class Localidad extends Base {
    private String nombre;

    //Provincia
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "provincia_id")
    private Provincia provincia;

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
