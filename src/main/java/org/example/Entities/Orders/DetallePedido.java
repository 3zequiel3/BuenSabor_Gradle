package org.example.Entities.Orders;

import lombok.*;
import org.example.Entities.Articles.Articulo;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetallePedido {
    private int cantidad;
    private double subtotal;

    //Articulo
    private Articulo articulo;
    //Pedido
    private Pedido pedido;
}
