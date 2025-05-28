package org.example.Entities.Articles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.Entities.Base;
import org.example.Entities.Enums.TipoPromocion;
import org.example.Entities.Geography.Sucursal;
import org.example.Entities.Imagen;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class Promocion extends Base {
    private String denominacion;
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private LocalTime horaDesde;
    private LocalTime horaHasta;
    private String descripcionDescuento;
    private double precioPromocional;

    //Tipo Promocion Enum
    private TipoPromocion tipoPromocion;

    //n:n Sucursal
    private List<Sucursal> sucursales = new ArrayList<>();
    // n:n Articulo
    private List<Articulo> articulos = new ArrayList<>();

    //Imagen
    private List<Imagen> imagenes = new ArrayList<>();

}
