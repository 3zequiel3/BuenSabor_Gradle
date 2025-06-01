package org.example.Entities.Orders;

import jakarta.persistence.*;
import lombok.*;
import org.example.Entities.Articles.Articulo;
import org.example.Entities.Base;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class DetallePedido extends Base {
    private int cantidad;
    private double subtotal;

    //Articulo
    @ManyToOne
    private Articulo articulo;
    //Pedido
    @ManyToOne
    private Pedido pedido;
}
