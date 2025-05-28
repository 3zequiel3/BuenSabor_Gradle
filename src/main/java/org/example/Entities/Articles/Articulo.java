package org.example.Entities.Articles;
import org.example.Entities.Base;
import org.example.Entities.Orders.DetallePedido;

import lombok.*;
import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

public abstract class Articulo extends Base {
    protected String denominaminacion;
    protected double precioVenta;

    //Promocion
    protected List<Promocion> promociones = new ArrayList<>();

    //Imagenes
    protected List<String> imagenes = new ArrayList<>();

    //UnidadMedida
    protected UnidadMedida unidadMedida;
    //Categoria
    protected Categoria categoria;
    //Detalle Pedido
    private List<DetallePedido> detallePedidos;
}
