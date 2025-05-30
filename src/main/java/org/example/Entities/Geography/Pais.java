package org.example.Entities.Geography;


import jakarta.persistence.*;
import org.example.Entities.Base;
import lombok.*;
import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Pais extends Base {
    private String nombre;
    @OneToMany(mappedBy = "pais",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Provincia> provincias = new ArrayList<>();

    //Metodos
        //Provincia
            //Añadir
    public void añadirProvincia(Provincia provincia){
        this.provincias.add(provincia);
    }
            //Eliminar
    public void eliminarProvincia(Provincia provincia){
        this.provincias.remove(provincia);
    }

}
