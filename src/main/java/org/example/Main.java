package org.example;

import jakarta.persistence.EntityManager;
import org.example.Entities.Connection.ConexionJPA;
import org.example.Entities.Connection.Implementacion.EmpresaDAOImpl;
import org.example.Entities.Connection.Implementacion.SucursalDAOImplHibernate;
import org.example.Entities.Geography.*;
import org.example.Entities.Articles.*;
import org.example.Entities.Orders.*;
import org.example.Entities.User.*;
import org.example.Entities.Imagen;
import org.example.Entities.Enums.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        // 1. Ubicación
        Pais pais = Pais.builder().nombre("Argentina").build();
        Provincia provincia = Provincia.builder().nombre("Córdoba").pais(pais).build();
        pais.addProvincia(provincia);
        Localidad localidad = Localidad.builder().nombre("Villa María").provincia(provincia).build();
        provincia.addLocalidad(localidad);
        Domicilio domicilio = Domicilio.builder().calle("San Martín").numero(123).cp(5900).localidad(localidad).build();
        localidad.añadirDomicilio(domicilio);

        // 2. Empresa y Sucursal
        Empresa empresa = Empresa.builder()
                .nombre("Buen Sabor")
                .razonSocial("Buen Sabor SRL")
                .cuil(30712345678L)
                .build();

        Sucursal sucursal = Sucursal.builder()
                .nombre("Sucursal Centro")
                .horarioApertura(LocalTime.of(9, 0))
                .horarioCierre(LocalTime.of(18, 0))
                .domicilio(domicilio)
                .build();
        empresa.añadirSucursal(sucursal);

        // 3. Unidad de medida
        UnidadMedida unidad = UnidadMedida.builder().denominacion("Kilogramo").build();

        // 4. Categoría y asociación a sucursal
        Categoria categoria = Categoria.builder().denominacion("Bebidas").build();
        sucursal.añadirCategoria(categoria);

        // 5. Artículo Insumo y Manufacturado
        ArticuloInsumo insumo = ArticuloInsumo.builder()
                .denominaminacion("Azúcar")
                .precioVenta(50.0)
                .precioCompra(30.0)
                .stockActual(500)
                .stockMaximo(1000)
                .esParaElaborar(false)
                .unidadMedida(unidad)
                .build();

        ArticuloManufacturadoDetalle detalleManu = ArticuloManufacturadoDetalle.builder()
                .cantidad(2)
                .articuloInsumo(insumo)
                .build();

        ArticuloManufacturado manufacturado = ArticuloManufacturado.builder()
                .denominaminacion("Café con leche")
                .precioVenta(200.0)
                .descripcion("Café con leche y azúcar")
                .tiempoEstimadoMinutos(5)
                .preparacion("Preparar café, agregar leche y azúcar.")
                .unidadMedida(unidad)
                .build();
        manufacturado.addArticuloManufacturadoDetalle(detalleManu);

        // 6. Imagen para Promoción y Cliente
        Imagen promoImg = Imagen.builder().denominacion("promo1.jpg").build();
        Imagen clienteImg = Imagen.builder().denominacion("cliente1.jpg").build();

        Promocion promo = Promocion.builder()
                .denominacion("Promo Desayuno")
                .fechaDesde(LocalDate.now())
                .fechaHasta(LocalDate.now().plusDays(7))
                .horaDesde(LocalTime.of(8, 0))
                .horaHasta(LocalTime.of(11, 0))
                .descripcionDescuento("20% off desayuno")
                .precioPromocional(150.0)
                .tipoPromocion(TipoPromocion.HAPPYHOUR)
                .build();
        promo.addArticulo(manufacturado);
        promo.addImagen(promoImg);
        sucursal.añadirPromocion(promo);

        Usuario usuario = Usuario.builder()
                .aunthID("auth123")
                .username("jdoe")
                .build();

        Cliente cliente = Cliente.builder()
                .nombre("Juan")
                .apellido("Doe")
                .correo("juan@correo.com")
                .telefono("3511111111")
                .fechaNacimiento(LocalDate.of(1990, 5, 20))
                .usuario(usuario)
                .imagen(clienteImg)
                .build();

        Factura factura = Factura.builder()
                .fechaFacturacion(LocalDate.now())
                .mpPaymentId(999)
                .mpMerchantOrderId(888)
                .mpPreferenceId("pref123")
                .mpPaymentType("credit_card")
                .formaPago(FormaPago.EFECTIVO)
                .totalVenta(350.0)
                .build();

        Pedido pedido = Pedido.builder()
                .horaEstimadaFinalizacion(LocalTime.of(10, 30))
                .total(350.0)
                .totalCosto(200.0)
                .fechaPedido(LocalDate.now())
                .estado(Estado.PENDIENTE)
                .tipoEnvio(TipoEnvio.DELIBERY)
                .formaPago(FormaPago.EFECTIVO)
                .domicilio(domicilio)
                .sucursal(sucursal)
                .build();
        pedido.setFactura(factura);

        DetallePedido detallePedido = DetallePedido.builder()
                .cantidad(1)
                .subtotal(200.0)
                .pedido(pedido)
                .build();
        detallePedido.addArticulo(manufacturado);
        pedido.añadirDetallePedido(detallePedido);

        cliente.getPedidos().add(pedido);
        cliente.getDomicilios().add(domicilio);

        // GUARDAR Empresa POR JDBC (DAO)
        EmpresaDAOImpl empresaDAO = new EmpresaDAOImpl();
        empresaDAO.guardar(empresa);
        System.out.println("Empresa guardada en base de datos (JDBC)");

        // GUARDAR Sucursal POR JPA (DAO)

        SucursalDAOImplHibernate sucursalDAO = new SucursalDAOImplHibernate();
        sucursalDAO.guardar(sucursal);
        System.out.println("Sucursal guardada en base de datos (JPA)");

        System.out.println("Datos de ejemplo creados y guardados correctamente.");
    }
}