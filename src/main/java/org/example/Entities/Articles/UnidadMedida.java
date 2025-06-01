package org.example.Entities.Articles;

import lombok.*;
import jakarta.persistence.*;
import org.example.Entities.Base;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class UnidadMedida extends Base {
    @Column(unique = true)
    private String denominacion;
    @ManyToOne
    @JoinColumn(name = "articulo_id")
    private Articulo articulo;
}
