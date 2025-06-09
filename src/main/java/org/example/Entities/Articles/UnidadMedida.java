package org.example.Entities.Articles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.Entities.Base;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class UnidadMedida extends Base {
    @Column(unique = true)
    private String denominacion;
}
