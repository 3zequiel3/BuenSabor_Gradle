package org.example.Entities.Geography;

import lombok.*;
import org.example.Entities.Base;
import org.example.Entities.Orders.Pedido;
import org.example.Entities.User.Cliente;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class Domicilio extends Base {
    private String calle;
    private int numero;
    private int cp;
    //Localidad
    private Localidad localidad;
    //Pedidos
    private List<Pedido> pedidos = new ArrayList<>();
    //Cliente
    private List<Cliente> clientes = new ArrayList<>();

    //Metodos
        //Pedidos
            //Añadir
    public void añadirPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }
            //Eliminar
    public void eliminarPedido(Pedido pedido) {
        this.pedidos.remove(pedido);
    }
        //Clientes
            //Añadir
    public void añadirCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }
            //Eliminar
    public void eliminarCliente(Cliente cliente) {
        this.clientes.remove(cliente);
    }

}
