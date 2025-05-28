package org.example.Entities.Articles;
import lombok.*;
import org.example.Entities.Base;

import java.util.List;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class Categoria extends Base {
    private String denominacion;

    //Categoria
    private Categoria categoriaPadre;
    //Articulo
    private List<Articulo> articulos;
    private Set<Categoria> categorias;
}
