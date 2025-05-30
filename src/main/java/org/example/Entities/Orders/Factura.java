package org.example.Entities.Orders;


import jakarta.persistence.*;
import lombok.*;
import org.example.Entities.Base;
import org.example.Entities.Enums.FormaPago;

import java.time.LocalDate;
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Factura extends Base {
    private LocalDate fechaFacturacion;
    private int mpPaymentId;
    private int mpMerchantOrderId;
    private String mpPreferenceId;
    private String mpPaymentType;
    private FormaPago formaPago;
    private double totalVenta;
    //Pedido
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Pedido pedido;
}
