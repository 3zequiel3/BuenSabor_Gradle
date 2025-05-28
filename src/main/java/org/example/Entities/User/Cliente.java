package org.example.Entities.User;

import lombok.*;
import org.example.Entities.Geography.Domicilio;
import org.example.Entities.Imagen;
import org.example.Entities.Orders.Pedido;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Cliente {
    //Pedidios
    private List<Pedido> pedidos = new ArrayList<>();
    //Domicilio
    private List<Domicilio> domicilios = new ArrayList<>();
    //Imagen
    private Imagen imagen;
}
