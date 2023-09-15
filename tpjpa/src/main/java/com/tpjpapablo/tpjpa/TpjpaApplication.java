package com.tpjpapablo.tpjpa;

import com.tpjpapablo.tpjpa.entidades.*;
import com.tpjpapablo.tpjpa.enumeraciones.EstadoPedido;
import com.tpjpapablo.tpjpa.enumeraciones.FormaDePago;
import com.tpjpapablo.tpjpa.enumeraciones.TipoEnvio;
import com.tpjpapablo.tpjpa.enumeraciones.TipoProducto;
import com.tpjpapablo.tpjpa.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class TpjpaApplication {

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	RubroRepository rubroRepository;
	@Autowired
	DetallePedidoRepository detallePedidoRepository;
	@Autowired
	FacturaRepository facturaRepository;
	@Autowired
	ProductoRepository productoRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	DomicilioRepository domicilioRepository;

	public static void main(String[] args) {
		SpringApplication.run(TpjpaApplication.class, args);
		System.out.println("Estoy funcionando");

	}

	@Bean
	CommandLineRunner init(RubroRepository rubroRepository, ClienteRepository clienteRepository) {
		return args -> {
			System.out.println("-------ESTOY FUNCIONANDO--------");

			Rubro rubro = Rubro.builder()
					.denominacion("Pizzas")
					.build();
			Producto producto = Producto.builder()
					.tiempoestimadococina(120)
					.denominacion("Pizza Napolitana")
					.precioVenta(2500)
					.precioCompra(1300)
					.stockActual(20)
					.stockMinimo(10)
					.unidadMedida("unidad")
					.receta("receta")
					.tipoProducto(TipoProducto.Insumo)
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
					.tipoProducto(TipoProducto.Insumo)
					.build();

			rubro.agregarProducto(producto);
			rubro.agregarProducto(producto2);

			DetallePedido detallePedido = DetallePedido.builder()
					.cantidad(5)
					.subtotal(5699)
					.producto(producto)
					.build();
			DetallePedido detallePedido2 = DetallePedido.builder()
					.cantidad(3)
					.subtotal(4000)
					.producto(producto2)
					.build();

			Cliente cliente = Cliente.builder()
					.nombre("Pablo")
					.apellido("Yacante")
					.email("pabloyacante18@gmail.com")
					.telefono("telefono")
					.build();

			Domicilio domicilio = Domicilio.builder()
					.calle("Fleming")
					.numero(1230)
					.localidad("Guaymallén")
					.build();
			Domicilio domicilio2 = Domicilio.builder()
					.calle("Pringles")
					.numero(1250)
					.localidad("Guaymallén")
					.build();

			SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
			String fechaString = "2023-09-11";
			Date fecha = formatoFecha.parse(fechaString);

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

			Pedido pedido = Pedido.builder()
					.fecha(fecha)
					.total(7400)
					.estado(EstadoPedido.Preparacion)
					.tipoEnvio(TipoEnvio.Retira)
					.factura(factura)
					.build();
			Pedido pedido2 = Pedido.builder()
					.fecha(fecha)
					.total(1700)
					.estado(EstadoPedido.Entregado)
					.tipoEnvio(TipoEnvio.Retira)
					.factura(factura2)
					.build();


			pedido.agregarDetallePedido(detallePedido);
			pedido.agregarDetallePedido(detallePedido2);

			cliente.agregarDomicilio(domicilio);
			cliente.agregarDomicilio(domicilio2);
			cliente.agregarPedido(pedido);

			cliente.agregarPedido(pedido2);
			cliente.agregarPedido(pedido);

			rubroRepository.save(rubro);
			productoRepository.save(producto);
			productoRepository.save(producto2);
			clienteRepository.save(cliente);
			domicilioRepository.save(domicilio);
			domicilioRepository.save(domicilio2);
			pedidoRepository.save(pedido);
			pedidoRepository.save(pedido2);
			facturaRepository.save(factura);
			facturaRepository.save(factura2);
			detallePedidoRepository.save(detallePedido);
			detallePedidoRepository.save(detallePedido2);

			Rubro rubroRecuperado = rubroRepository.findById(rubro.getId()).orElse(null);
			if (rubroRecuperado != null) {
				System.out.println("Denominacion: " + rubroRecuperado.getDenominacion());
				rubroRecuperado.mostrarProductos();
			}
			Cliente clienteRecuperado = clienteRepository.findById(cliente.getId()).orElse(null);
			if (clienteRecuperado != null) {
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
