package org.example.Entities.Articles;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
public class ArticuloManufacturado extends Articulo {
    private String descripcion;
    private int tiempoEstimadoMinutos;
    private String preparacion;

    //Articulo Manufacturado Detalle Relacion OnetoMany
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "articulo_manufacturado_detalle_id")
    @Builder.Default
    private Set<ArticuloManufacturadoDetalle> detalles = new HashSet<>();

    public void addArticuloManufacturadoDetalle(ArticuloManufacturadoDetalle detalle) {
        this.detalles.add(detalle);
    }

    public void removeArticuloManufacturadoDetalle(ArticuloManufacturadoDetalle detalle) {
        this.detalles.remove(detalle);
    }

}
