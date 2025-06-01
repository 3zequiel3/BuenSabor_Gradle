package org.example.Entities.Geography;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
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
@SuperBuilder
@Table(name = "empresas")
public class Empresa extends Base {
    @Column(unique = true)
    private String nombre;
    @Column(unique = true)
    private String razonSocial;
    @Column(unique = true)
    private long cuil;
    //Sucursales
    @OneToMany(mappedBy = "empresa",cascade = CascadeType.ALL,orphanRemoval = true)
    @Builder.Default
    private ArrayList<Sucursal> sucursales = new ArrayList<>()   ;

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
