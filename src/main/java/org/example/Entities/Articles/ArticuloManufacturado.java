package org.example.Entities.Articles;


import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class ArticuloManufacturado extends Articulo{
    private String descripcion;
    private int tiempoEstimadoMinutos;
    private String preparacion;

    //ArticuloManufacturadoDetalle
    private List<ArticuloManufacturadoDetalle> articuloManufacturadoDetalles = new ArrayList<>();
}
