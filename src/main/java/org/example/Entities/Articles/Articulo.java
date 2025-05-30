package org.example.Entities.Articles;
import jakarta.persistence.*;
import org.example.Entities.Base;
import org.example.Entities.Orders.DetallePedido;

import lombok.*;
import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public abstract class Articulo extends Base {
    protected String denominaminacion;
    protected double precioVenta;

    //Promocion
    @ManyToMany
    protected List<Promocion> promociones = new ArrayList<>();

    //Imagenes
    protected List<String> imagenes = new ArrayList<>();

    //UnidadMedida
    @OneToOne
    protected UnidadMedida unidadMedida;
    //Categoria
    @ManyToOne
    protected Categoria categoria;
    //Detalle Pedido
    @OneToMany(mappedBy = "articulos")
    private List<DetallePedido> detallePedidos;
}
