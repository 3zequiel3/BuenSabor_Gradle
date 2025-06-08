package org.example.Entities.Orders;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.Entities.Base;
import org.example.Entities.Enums.Estado;
import org.example.Entities.Enums.FormaPago;
import org.example.Entities.Enums.TipoEnvio;
import org.example.Entities.Geography.Domicilio;
import org.example.Entities.Geography.Sucursal;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "pedidos")
public class Pedido extends Base {
    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private LocalTime horaEstimadaFinalizacion;

    @Column(nullable = false)
    private double total;

    @Column(nullable = false)
    private double totalCosto;

    @Temporal(TemporalType.DATE)
    private LocalDate fechaPedido;

    //Estado Enum
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Estado estado;

    //TipoEnvio Enum
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoEnvio tipoEnvio;

    //FormaPago Enum
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FormaPago formaPago;

    //DetallePedido
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private Set<DetallePedido> detallePedido = new HashSet<>();

    //Factura
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "factura_id")
    private Factura factura;

    //Domicilio
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "domicilio_id")
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

    public void calcularTotalPedido() {
        double total = 0;
        for (DetallePedido detallePedido : detallePedido) {
            total += detallePedido.getSubtotal();
        }
        this.total = total;
    }
}
