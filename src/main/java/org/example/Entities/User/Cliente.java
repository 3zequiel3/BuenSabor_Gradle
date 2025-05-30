package org.example.Entities.User;

import lombok.*;
import jakarta.persistence.*;
import org.example.Entities.Base;
import org.example.Entities.Geography.Domicilio;
import org.example.Entities.Imagen;
import org.example.Entities.Orders.Pedido;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente extends Base {
    //Pedidios
    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Pedido> pedidos = new ArrayList<>();
    //Domicilio
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "cliente_id", joinColumns = @JoinColumn(name = "cliente_id"), inverseJoinColumns = @JoinColumn(name = "domicilio_id"))
    private List<Domicilio> domicilios = new ArrayList<>();
    //Imagen
    @ManyToOne(cascade = CascadeType.ALL)
    private Imagen imagen;
}
