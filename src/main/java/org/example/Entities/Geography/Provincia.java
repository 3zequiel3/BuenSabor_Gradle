package org.example.Entities.Geography;
import lombok.*;
import org.example.Entities.Base;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class Provincia extends Base {
    private String nombre;
    private Pais pais;

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
