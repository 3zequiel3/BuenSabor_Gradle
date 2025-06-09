package org.example.Entities.Articles;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.Entities.Base;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
public class ArticuloManufacturadoDetalle extends Base {
    private int cantidad;

    //ArticuloInsumo
    @ManyToOne
    private ArticuloInsumo articuloInsumo;

    @ManyToOne
    private ArticuloManufacturado articuloManufacturado;
}
