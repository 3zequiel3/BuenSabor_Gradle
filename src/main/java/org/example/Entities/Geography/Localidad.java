package org.example.Entities.Geography;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.Entities.Base;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Localidad extends Base {
    private String nombre;
    //Domicilio
    @OneToMany
    private List<Domicilio> domicilios = new ArrayList<>();
    //Provincia
    @ManyToOne
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
