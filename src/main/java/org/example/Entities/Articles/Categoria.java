package org.example.Entities.Articles;
import lombok.*;
import jakarta.persistence.*;
import org.example.Entities.Base;

import java.util.List;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity

public class Categoria extends Base {
    private String denominacion;

    //Categoria
    @ManyToOne
    @JoinColumn(name = "categoria_padre_id")
    private Categoria categoriaPadre;

    @OneToMany(mappedBy = "categoriaPadre",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Categoria> categoriasHijas;
    //Articulo
    @OneToMany(mappedBy = "categoria",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Articulo> articulos;
    private Set<Categoria> categorias;
}
