package org.example.Entities.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.Entities.Base;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")
@SuperBuilder
public class Usuario extends Base {
    @Column(nullable = false)
    private String aunthID;
    @Column(nullable = false)
    private String username;


}
