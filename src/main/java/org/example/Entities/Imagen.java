package org.example.Entities;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.Entities.Articles.Promocion;
import org.example.Entities.User.Cliente;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Imagen {
    private String denominacion;
    private Promocion promocion;
    private Cliente cliente;
}
