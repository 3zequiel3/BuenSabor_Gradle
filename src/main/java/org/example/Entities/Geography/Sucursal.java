package org.example.Entities.Geography;
import jakarta.persistence.*;
import lombok.experimental.SuperBuilder;
import org.example.Entities.Articles.Promocion;
import org.example.Entities.Base;
import lombok.*;
import org.example.Entities.Orders.Pedido;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "sucursales")
@SuperBuilder
public class Sucursal extends Base {
    @Column(unique = true, nullable = false)
    private String nombre;
    @Column(nullable = false)
    private LocalTime horarioApertura;
    @Column(nullable = false)
    private LocalTime horarioCierre;
    //Empresa
    @ManyToOne
    @JoinTable(name = "empresa_id", joinColumns = @JoinColumn(name = "sucursal_id"), inverseJoinColumns = @JoinColumn(name = "empresa_id"))
    private Empresa empresa;
    //Domicilio
    @OneToOne(cascade = CascadeType.ALL , orphanRemoval = true)
    @JoinColumn(name = "domicilio_id")
    private Domicilio domicilio;
    //Promociones
    @ManyToMany(mappedBy = "sucursales", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @Builder.Default
    private List<Promocion> promociones = new ArrayList<>();
    //Pedidos
    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<>()    ;

    //Metodos
        //Promocion
            //Añadir
    public void añadirPromocion(Promocion promocion) {
        this.promociones.add(promocion);
    }

            //Eliminar
    public void eliminarPromocion(Promocion promocion) {
        this.promociones.remove(promocion);
    }

        //Pedidos
            //Añadir
    public void añadirPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }
            //Eliminar
    public void eliminarPedido(Pedido pedido) {
        this.pedidos.remove(pedido);
    }

}
