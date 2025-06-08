package org.example.Entities.Geography;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.Entities.Base;

import java.util.HashSet;
import java.util.Set;

@Data
//Getter
//Setter
//Constructor Personalizado
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder
@Table(name = "empresas")
public class Empresa extends Base {
    @Column(unique = true, nullable = false)
    private String nombre;
    @Column(unique = true, nullable = false)
    private String razonSocial;
    @Column(unique = true, nullable = false)
    private long cuil;
    //Sucursales
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "sucursal_id")
    @Builder.Default
    private Set<Sucursal> sucursales = new HashSet<>();

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
