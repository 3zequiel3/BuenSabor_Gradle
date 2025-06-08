package org.example.Entities.Articles;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.Entities.Base;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = {"articuloInsumo"})
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
