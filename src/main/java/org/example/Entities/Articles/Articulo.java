package org.example.Entities.Articles;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.Entities.Base;
import org.example.Entities.Imagen;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@Table(name = "articulos")
public abstract class Articulo extends Base {
    @Column(nullable = false)
    protected String denominaminacion;
    @Column(nullable = false)
    protected double precioVenta;

    //Imagenes
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "imagen_id")
    @Builder.Default
    protected Set<Imagen> imagenes = new HashSet<>();

    //UnidadMedida
    @ManyToOne(cascade = CascadeType.ALL)
    protected UnidadMedida unidadMedida;


    public void añadirImagenes(Imagen imagen) {
        this.getImagenes().add(imagen);
    }

    public void eliminarImagenes(Imagen imagen) {
        this.getImagenes().remove(imagen);
    }


}
