package org.example.Entities.Geography;


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
public class Localidad extends Base {
    private String nombre;
    //Domicilio
    private List<Domicilio> domicilios = new ArrayList<>();
    //Provincia
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
