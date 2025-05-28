package org.example.Entities.Orders;


import lombok.*;
import org.example.Entities.Enums.FormaPago;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Factura {
    private LocalDate fechaFacturacion;
    private int mpPaymentId;
    private int mpMerchantOrderId;
    private String mpPreferenceId;
    private String mpPaymentType;
    private FormaPago formaPago;
    private double totalVenta;
    //Pedido
    private Pedido pedido;
}
