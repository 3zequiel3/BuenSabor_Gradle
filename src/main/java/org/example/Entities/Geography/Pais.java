package org.example.Entities.Geography;


import org.example.Entities.Base;
import lombok.*;
import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class Pais extends Base {
    private String nombre;

    private List<Provincia> provincias = new ArrayList<>();

    //Metodos
        //Provincia
            //Añadir
    public void añadirProvincia(Provincia provincia){
        this.provincias.add(provincia);
    }
            //Eliminar
    public void eliminarProvincia(Provincia provincia){
        this.provincias.remove(provincia);
    }

}
