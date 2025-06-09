package org.example.Entities.Geography;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.Entities.Articles.Categoria;
import org.example.Entities.Articles.Promocion;
import org.example.Entities.Base;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@Table(name = "sucursales")
public class Sucursal extends Base {
    @Column(unique = true, nullable = false)
    private String nombre;

    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private LocalTime horarioApertura;

    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private LocalTime horarioCierre;

    //Domicilio
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "domicilio_id")
    private Domicilio domicilio;

    //Promociones
    @ManyToMany
    @JoinTable(name = "sucursal_id",
            joinColumns = @JoinColumn(name = "sucursal_id"),
            inverseJoinColumns = @JoinColumn(name = "promocion_id"))
    @Builder.Default
    private Set<Promocion> promociones = new HashSet<>();

    //Categorias
    @ManyToMany
    @JoinTable(name = "sucursal_id",
            joinColumns = @JoinColumn(name = "sucursal_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    @Builder.Default
    private List<Categoria> categorias = new ArrayList<>();

    //Metodos
    //Promocion
    //Añadir
    public void añadirPromocion(Promocion promocion) {
        this.promociones.add(promocion);
    }

    //Eliminar
    public void eliminarPromocion(Promocion promocion) {
        this.promociones.remove(promocion);
    }

    //Categoria
    //Añadir
    public void añadirCategoria(Categoria categoria) {
        this.categorias.add(categoria);
    }

    //Eliminar
    public void eliminarCategoria(Categoria categoria) {
        this.categorias.remove(categoria);
    }

}
