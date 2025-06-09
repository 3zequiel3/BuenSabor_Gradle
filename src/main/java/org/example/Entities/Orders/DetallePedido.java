package org.example.Entities.Orders;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.Entities.Articles.Articulo;
import org.example.Entities.Base;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
public class DetallePedido extends Base {
    private int cantidad;
    private double subtotal;

    //Articulo
    @OneToMany(cascade = CascadeType.ALL)
    @Builder.Default
    private Set<Articulo> articulos = new HashSet<>();
    //Pedido
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    public void addArticulo(Articulo articulo) {
        articulos.add(articulo);
    }

    public void removeArticulo(Articulo articulo) {
        articulos.remove(articulo);
    }

    private double calcularSubtotal() {
        double sumaPreciosArticulos = 0.0;
        if (this.articulos != null && !this.articulos.isEmpty()) {
            for (Articulo articulo : articulos) {
                if (articulo != null && articulo.getPrecioVenta() > 0) {
                    sumaPreciosArticulos += articulo.getPrecioVenta();
                }
            }
        }
        return this.cantidad * sumaPreciosArticulos;
    }
}
