package org.example.Entities.Orders;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.Entities.Base;
import org.example.Entities.Enums.FormaPago;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@Table(name = "facturas")
public class Factura extends Base {
    @Temporal(TemporalType.DATE)
    private LocalDate fechaFacturacion;
    @Column
    private int mpPaymentId;
    @Column
    private int mpMerchantOrderId;
    @Column
    private String mpPreferenceId;
    @Column
    private String mpPaymentType;
    @Enumerated(EnumType.STRING)
    private FormaPago formaPago;
    @Column
    private double totalVenta;

}
