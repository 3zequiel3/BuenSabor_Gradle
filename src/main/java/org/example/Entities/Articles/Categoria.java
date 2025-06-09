package org.example.Entities.Articles;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.Entities.Base;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
public class Categoria extends Base {
    private String denominacion;


    //Sucursales
    @ManyToOne
    @JoinColumn(name = "categoria_padre_id")
    private Categoria categoriaPadre;

    @OneToMany(mappedBy = "categoriaPadre", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private Set<Categoria> categoriasHijas = new HashSet<>();

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private Set<Articulo> articulos = new HashSet<>();

    public void addCategoriaHija(Categoria c) {
        this.categoriasHijas.add(c);
    }

    public void removeCategoriaHija(Categoria c) {
        this.categoriasHijas.remove(c);
    }

    public void addArticulo(Articulo a) {
        this.articulos.add(a);
    }

    public void removeArticulo(Articulo a) {
        this.articulos.remove(a);
    }

}

