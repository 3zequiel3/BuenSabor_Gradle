package org.example.Entities.Orders;


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
@Data
@AllArgsConstructor
@NoArgsConstructor
 @Builder
public class Pedido {
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
    private List<DetallePedido> detallePedido = new ArrayList<>();
    //Cliente
    private Cliente cliente;
    //Factura
    private Factura factura;
    //Domicilio
    private Domicilio domicilio;
    //Sucursal
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
