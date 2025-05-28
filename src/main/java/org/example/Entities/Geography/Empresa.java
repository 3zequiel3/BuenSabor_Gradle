package org.example.Entities.Geography;
import lombok.*;
import org.example.Entities.Base;

import java.util.ArrayList;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class Empresa extends Base {
    private String nombre;
    private String razonSocial;
    private int cuil;
    //Sucursales
    private ArrayList<Sucursal> sucursales;

    //Metodos
        //Añadir
    public void añadirSucursal(Sucursal sucursal) {
        this.sucursales.add(sucursal);
    }
        //Eliminar
    public void eliminarSucursal(Sucursal sucursal) {
        this.sucursales.remove(sucursal);
    }

}
