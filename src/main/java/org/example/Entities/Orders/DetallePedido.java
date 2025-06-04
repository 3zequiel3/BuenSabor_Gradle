package org.example.Entities.Orders;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
}
