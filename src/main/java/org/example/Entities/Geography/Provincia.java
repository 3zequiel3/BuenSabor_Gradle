package org.example.Entities.Geography;
import jakarta.persistence.*;
import lombok.*;
import org.example.Entities.Base;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Provincia extends Base {
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;

    @OneToMany(mappedBy = "provincia",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Localidad> localidades = new ArrayList<>();

    //Metodos
        //Localidades
            //Añadir
    public void añadirLocalidad(Localidad localidad){
        this.localidades.add(localidad);
    }
            //Eliminar
    public void eliminarLocalidad(Localidad localidad){
        this.localidades.remove(localidad);
    }
}
