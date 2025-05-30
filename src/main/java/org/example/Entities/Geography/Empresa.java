package org.example.Entities.Geography;
import jakarta.persistence.*;
import lombok.*;
import org.example.Entities.Base;

import java.util.ArrayList;
@Data
//Getter
//Setter
//Constructor Personalizado
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "empresas")
public class Empresa extends Base {
    @Column(unique = true)
    private String nombre;
    @Column(unique = true)
    private String razonSocial;
    @Column(unique = true)
    private int cuil;
    //Sucursales
    @OneToMany(mappedBy = "empresa",cascade = CascadeType.ALL,orphanRemoval = true)
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
