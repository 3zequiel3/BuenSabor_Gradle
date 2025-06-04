package org.example.Entities.Articles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.Entities.Base;
import org.example.Entities.Geography.Sucursal;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Categoria extends Base {
    private String denominacion;


    //Sucursales
    @ManyToMany(mappedBy = "categorias")
    private Set<Sucursal> sucursales;
    @ManyToOne
    @JoinColumn(name = "categoria_padre_id")
    private Categoria categoriaPadre;

    @OneToMany(mappedBy = "categoriaPadre", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Categoria> categoriasHijas;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Articulo> articulos;

}

