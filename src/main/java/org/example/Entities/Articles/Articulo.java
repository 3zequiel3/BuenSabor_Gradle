package org.example.Entities.Articles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.Entities.Base;
import org.example.Entities.Imagen;
import org.example.Entities.Orders.DetallePedido;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public abstract class Articulo extends Base {
    @Column(nullable = false)
    protected String denominaminacion;
    @Column(nullable = false)
    protected double precioVenta;

    //Imagenes
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn()
    protected Set<Imagen> imagenes = new HashSet<>();

    //UnidadMedida
    @ManyToOne
    protected UnidadMedida unidadMedida;


    //Detalle Pedido
    @OneToMany(mappedBy = "articulo")
    private Set<DetallePedido> detallePedidos;
}
