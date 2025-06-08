package org.example.Entities.Geography;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.Entities.Base;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder
@Table(name = "paises")
public class Pais extends Base {
    private String nombre;

    @OneToMany
    @Builder.Default
    private Set<Provincia> provincias = new HashSet<>();

    public void addProvincia(Provincia provincia) {
        this.provincias.add(provincia);
    }

    public void removeProvincia(Provincia provincia) {
        this.provincias.remove(provincia);
    }

}
