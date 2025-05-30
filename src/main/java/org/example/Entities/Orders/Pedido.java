package org.example.Entities.Orders;



import jakarta.persistence.*;
import lombok.experimental.SuperBuilder;
import org.example.Entities.Base;
import org.example.Entities.Enums.Estado;
import org.example.Entities.Enums.FormaPago;
import org.example.Entities.Enums.TipoEnvio;
import org.example.Entities.Geography.Domicilio;
import org.example.Entities.Geography.Sucursal;
import org.example.Entities.User.Cliente;

import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class Pedido extends Base {
    private LocalTime horaEstimadaFinalizacion;
    private double total;
    private double totalCosto;
    private LocalDate fechaPedido;
    //Estado Enum
    private Estado estado;
    //TipoEnvio Enum
    private TipoEnvio tipoEnvio;
    //FormaPago Enum
    private FormaPago formaPago;
    //DetallePedido
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "detalle_pedido_id", joinColumns = @JoinColumn(name = "pedido_id"), inverseJoinColumns = @JoinColumn(name = "detalle_pedido_id"))
    private List<DetallePedido> detallePedido = new ArrayList<>();
    //Cliente
    @ManyToOne(optional = false)
    @JoinTable(name = "cliente_id", joinColumns = @JoinColumn(name = "pedido_id"), inverseJoinColumns = @JoinColumn(name = "cliente_id"))
    private Cliente cliente;
    //Factura
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Factura factura;
    //Domicilio
    @ManyToOne(optional = false)
    @JoinTable(name = "domicilio_id", joinColumns = @JoinColumn(name = "pedido_id"), inverseJoinColumns = @JoinColumn(name = "domicilio_id"))
    private Domicilio domicilio;
    //Sucursal
    @ManyToOne
    @JoinColumn(name = "sucursal_id")
    private Sucursal sucursal;
    //Metodos
    //Detalle del pedido
    //Añadir
    public void añadirDetallePedido(DetallePedido detallePedido) {
        this.detallePedido.add(detallePedido);
    }
    //Eliminar
    public void eliminarDetallePedido(DetallePedido detallePedido) {
        this.detallePedido.remove(detallePedido);
    }
}
