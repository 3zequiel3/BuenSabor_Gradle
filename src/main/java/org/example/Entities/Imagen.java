package org.example.Entities;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.Entities.Articles.Promocion;
import org.example.Entities.User.Cliente;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class Imagen extends Base{
    private String denominacion;

    @ManyToOne
    @JoinColumn(name = "promocion_id", nullable = false)
    private Promocion promocion;
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;
}
