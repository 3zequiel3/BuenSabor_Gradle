package org.example.Entities.Geography;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.Entities.Base;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@Table(name = "provincias")
public class Provincia extends Base {
    private String nombre;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pais_id")
    private Pais pais;

    @OneToMany(cascade = CascadeType.ALL)
    @Builder.Default
    private Set<Localidad> localidades = new HashSet<>();

    public void addLocalidad(Localidad localidad) {
        this.localidades.add(localidad);
    }

    public void removeLocalidad(Localidad localidad) {
        this.localidades.remove(localidad);
    }


}
