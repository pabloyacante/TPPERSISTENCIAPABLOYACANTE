package com.utn.tp1persistencia;

import com.utn.tp1persistencia.entidades.*;
import com.utn.tp1persistencia.enumeraciones.EstadoPedido;
import com.utn.tp1persistencia.enumeraciones.FormaDePago;
import com.utn.tp1persistencia.enumeraciones.TipoProducto;
import com.utn.tp1persistencia.enumeraciones.TipoEnvio;
import com.utn.tp1persistencia.repositorios.ClienteRepository;
import com.utn.tp1persistencia.repositorios.RubroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class Tp1persistenciaApplication {

	@Autowired
	RubroRepository rubroRepository;
	@Autowired
	ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(Tp1persistenciaApplication.class, args);
		System.out.println("Estoy andando bien");
	}
	@Bean
	CommandLineRunner init(RubroRepository rubroRepository1, ClienteRepository clienteRepository1){
		return args -> {
			System.out.println("----------------ESTOY----FUNCIONANDO---------------------");

			Rubro rubro1 = Rubro.builder()
					.denominacion("Pizzas")
					.build();

			Producto producto1 = Producto.builder()
					.tiempoestimadococina(60)
					.denominacion("Pizza Napolitana")
					.precioVenta(2500)
					.precioCompra(1600)
					.stockActual(20)
					.stockMinimo(10)
					.unidadMedida("unidad1")
					.receta("receta1")
					.tipoProducto(TipoProducto.Manufacturado)
					.build();
			Producto producto2 = Producto.builder()
					.tiempoestimadococina(150)
					.denominacion("Pizza Cuatro Quesos")
					.precioVenta(2800)
					.precioCompra(1700)
					.stockActual(26)
					.stockMinimo(8)
					.unidadMedida("unidad2")
					.receta("receta2")
					.tipoProducto(TipoProducto.Manufacturado)
					.build();

			rubro1.agregarProducto(producto1);
			rubro1.agregarProducto(producto2);

			rubroRepository.save(rubro1);

			Cliente cliente1 = Cliente.builder()
					.nombre("Pablo")
					.apellido("Yacante")
					.email("pabloyacante18@gmail.com")
					.telefono("telefono")
					.build();

			Domicilio domicilio1 = Domicilio.builder()
					.calle("Fleming")
					.numero(1230)
					.localidad("Guaymallén")
					.build();
			Domicilio domicilio2 = Domicilio.builder()
					.calle("Pringles")
					.numero(1250)
					.localidad("Guaymallén")
					.build();

			cliente1.agregarDomicilio(domicilio1);
			cliente1.agregarDomicilio(domicilio2);

			DetallePedido detallePedido1 = DetallePedido.builder()
					.cantidad(5)
					.subtotal(5699)
					.build();
			DetallePedido detallePedido2 = DetallePedido.builder()
					.cantidad(3)
					.subtotal(4000)
					.build();
			DetallePedido detallePedido3 = DetallePedido.builder()
					.cantidad(6)
					.subtotal(12000)
					.build();

			SimpleDateFormat formatoFecha = new SimpleDateFormat ("yyyy-MM-dd");
			String fechaString = "2023-09-09";

			Date fecha = formatoFecha.parse(fechaString);

			Pedido pedido1 = Pedido.builder()
					.fecha(fecha)
					.total(7400)
					.estadoPedido(EstadoPedido.Preparacion)
					.tipoEnvio(TipoEnvio.Retira)
					.build();
			Pedido pedido2 = Pedido.builder()
					.fecha(fecha)
					.total(1700)
					.estadoPedido(EstadoPedido.Entregado)
					.tipoEnvio(TipoEnvio.Retira)
					.build();

			Factura factura = Factura.builder()
					.fecha(fecha)
					.total(7000)
					.numero(2)
					.descuento(200)
					.formaDePago(FormaDePago.Tarjeta)
					.build();
			Factura factura2 = Factura.builder()
					.fecha(fecha)
					.total(6000)
					.numero(5)
					.descuento(600)
					.formaDePago(FormaDePago.Efectivo)
					.build();

			pedido1.agregarDetallePedido(detallePedido1);
			pedido1.agregarDetallePedido(detallePedido2);
			pedido2.agregarDetallePedido(detallePedido3);

			cliente1.agregarPedido(pedido1);
			cliente1.agregarPedido(pedido2);

			detallePedido1.setProducto(producto1);
			detallePedido2.setProducto(producto2);
			detallePedido3.setProducto(producto1);

			pedido1.setFactura(factura);
			pedido2.setFactura(factura2);

			clienteRepository.save(cliente1);


			Rubro rubroRecuperado = rubroRepository.findById(rubro1.getId()).orElse(null);
			if (rubroRecuperado != null){
				System.out.println("------------------------------------------");
				System.out.println("Denominacion: " + rubroRecuperado.getDenominacion());
				rubroRecuperado.mostrarProductos();
				System.out.println("------------------------------------------");
			}
			Cliente clienteRecuperado = clienteRepository.findById(cliente1.getId()).orElse(null);
			if (clienteRecuperado != null){
				System.out.println("------------------------------------------");
				System.out.println("Nombre: " + clienteRecuperado.getNombre());
				System.out.println("Apellido: " + clienteRecuperado.getApellido());
				System.out.println("EMail: " + clienteRecuperado.getEmail());
				System.out.println("Telefono: " + clienteRecuperado.getTelefono());
				System.out.println("----------------------------------------");
				clienteRecuperado.mostrarDomicilios();
				clienteRecuperado.mostrarPedidos();

			}
		};
	}

}


