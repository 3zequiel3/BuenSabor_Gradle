package org.example.Entities.Articles;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
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
@Entity
@Table(name = "promociones")
@SuperBuilder
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
    @ManyToMany
    @JoinTable(name = "sucursal_id", joinColumns = @JoinColumn(name = "promocion_id"), inverseJoinColumns = @JoinColumn(name = "sucursal_id"))
    private List<Sucursal> sucursales = new ArrayList<>();
    // n:n Articulo
    @ManyToMany
    @JoinTable(name = "articulo_id", joinColumns = @JoinColumn(name = "promocion_id"), inverseJoinColumns = @JoinColumn(name = "articulo_id"))
    private List<Articulo> articulos = new ArrayList<>();

    //Imagen
    @OneToMany(mappedBy = "promocion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Imagen> imagenes = new ArrayList<>();

}
