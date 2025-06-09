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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@Table(name = "promociones")
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
    @Enumerated(EnumType.STRING)
    private TipoPromocion tipoPromocion;


    // n:n Articulo
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "articulo_id",
            joinColumns = @JoinColumn(name = "promocion_id"),
            inverseJoinColumns = @JoinColumn(name = "articulo_id"))
    @Builder.Default
    private Set<Articulo> articulos = new HashSet<>();

    //Imagen
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    @JoinTable(name = "imagen_id",
                joinColumns = @JoinColumn(name= "promocion_id"),
                inverseJoinColumns = @JoinColumn(name = "imagen_id"))
    private Set<Imagen> imagenes = new HashSet<>();


    public void addArticulo(Articulo articulo) {
        articulos.add(articulo);
    }

    public void removeArticulo(Articulo articulo) {
        articulos.remove(articulo);
    }
    public void addImagen(Imagen imagen) {
        this.imagenes.add(imagen);
    }
    public void removeImagen(Imagen imagen) {
        this.imagenes.remove(imagen);
    }

}
