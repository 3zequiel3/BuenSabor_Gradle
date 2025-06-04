package org.example.Entities.Articles;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.Entities.Base;
import org.example.Entities.Enums.TipoPromocion;
import org.example.Entities.Imagen;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "promociones")
@SuperBuilder
public class Promocion extends Base {
    @Column(nullable = false)
    private String denominacion;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate fechaDesde;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate fechaHasta;

    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private LocalTime horaDesde;

    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private LocalTime horaHasta;

    @Column(nullable = false)
    private String descripcionDescuento;

    @Column(nullable = false)
    private double precioPromocional;

    //Tipo Promocion Enum
    private TipoPromocion tipoPromocion;


    // n:n Articulo
    @ManyToMany
    @JoinTable(name = "articulo_id",
            joinColumns = @JoinColumn(name = "promocion_id"),
            inverseJoinColumns = @JoinColumn(name = "articulo_id"))
    @Builder.Default
    private Set<Articulo> articulos = new HashSet<>();

    //Imagen
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Imagen imagen;

}
