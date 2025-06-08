package org.example.Entities.Articles;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "articulomanufacturado")
@SuperBuilder
public class ArticuloManufacturado extends Articulo {
    private String descripcion;
    private int tiempoEstimadoMinutos;
    private String preparacion;

    //Articulo Manufacturado Detalle Relacion OnetoMany
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "articulo_manufacturado_detalle_id")
    @Builder.Default
    private Set<ArticuloManufacturadoDetalle> articulos = new HashSet<>();

    public void addArticuloManufacturadoDetalle(ArticuloManufacturadoDetalle detalle) {
        this.articulos.add(detalle);
    }

    public void removeArticuloManufacturadoDetalle(ArticuloManufacturadoDetalle detalle) {
        this.articulos.remove(detalle);
    }

}
