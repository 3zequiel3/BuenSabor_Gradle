package org.example.Entities.Articles;
import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ArticuloManufacturadoDetalle {
    private int cantidad;

    //ArticuloManufacturado
    private ArticuloManufacturado articuloManufacturado;

    //ArticuloInsumo
    private ArticuloInsumo articuloInsumo;
}
