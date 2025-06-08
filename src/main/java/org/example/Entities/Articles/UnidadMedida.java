package org.example.Entities.Articles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.Entities.Base;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class UnidadMedida extends Base {
    @Column(unique = true)
    private String denominacion;
}
