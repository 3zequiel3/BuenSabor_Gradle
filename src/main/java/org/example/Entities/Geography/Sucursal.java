package org.example.Entities.Geography;
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
public class Sucursal extends Base {
    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    //Empresa
    private Empresa empresa;
    //Domicilio
    private Domicilio domicilio;
    //Promociones
    private List<Promocion> promociones = new ArrayList<>();
    //Pedidos
    private List<Pedido> pedidos = new ArrayList<>();

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
