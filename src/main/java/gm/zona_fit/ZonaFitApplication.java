package gm.zona_fit;

import gm.zona_fit.model.Cliente;
import gm.zona_fit.servicio.IClienteServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Console;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ZonaFitApplication implements CommandLineRunner {

	//inyectamos una dependencia de servicio hacia la capa de presentacion
	@Autowired
	private IClienteServicio clienteServicio;

	private static final Logger logger =
			LoggerFactory.getLogger(ZonaFitApplication.class);

	String nl = System.lineSeparator();

	public static void main(String[] args) {
		logger.info("Iniciando la aplicacion");
		//Levantar la fabrica de spring
		SpringApplication.run(ZonaFitApplication.class, args);
		logger.info("Aplicacion Finalizada");
	}

	@Override
	public void run(String... args) throws Exception {
		zonaFitApp();
	}

	private void zonaFitApp(){
		logger.info(nl + "***Aplicacion Zona Fit (Gym)***" + nl);
		Scanner consola = new Scanner(System.in);
		boolean salir = false;
		while(!salir){
		int opcion = mostrarMenu(consola);
			salir = ejecutarOpciones(consola,opcion);
			logger.info(nl);
		}
	}

	private int mostrarMenu(Scanner consola){
		logger.info("""
				1.Listar Clientes
				2.Buscar Clientes
				3.Agregar clientes
				4.Modificar clientes
				5.Eliminar clientes
				6.Salir
				Elige una opcion
				""");
		int opcion = consola.nextInt();
		return opcion;
	}

	private boolean ejecutarOpciones(Scanner consola,int opcion){
		boolean salir = false;
		switch (opcion){
			case 1-> {
				//Listar clientes
				logger.info(nl + "--- Listado de clientes ---" + nl);
				List<Cliente> clientes = clienteServicio.listarClientes();
				clientes.forEach(cliente -> logger.info(cliente.toString() + nl));
			}

			case 2 -> {
				logger.info(nl + "---Buscar cliente por id---");
				logger.info(nl + "Digite el cliente a buscar: ");
				int idCliente = consola.nextInt();
				Cliente cliente = clienteServicio.buscarClientePorId(idCliente);
				if (cliente != null){
					logger.info("Cliente encontrado  " + cliente + nl);

				}else{
					logger.info("Cliente no encontrado");
				}
			}

			case 3 -> {
				logger.info("---Agregar estudiante---" + nl);
				consola.nextLine();
				logger.info("Nombre: ");
				String nombre = consola.nextLine();
				logger.info("Apellido: ");
				String apellido = consola.nextLine();
				logger.info("Membresia: ");
				int membresia = consola.nextInt();

				Cliente cliente = new Cliente();
				cliente.setNombre(nombre);
				cliente.setApellido(apellido);
				cliente.setMembresia(membresia);

				clienteServicio.guardarCliente(cliente);
				logger.info("Cliente agregado " + cliente + nl);

			}

			case 4 -> {
				logger.info("----Modificar cliente---");
                logger.info("Digite el Id del cliente a modificar");
				int idCliente = consola.nextInt();
				Cliente cliente = clienteServicio.buscarClientePorId(idCliente);
				if (cliente != null){
					consola.nextLine();
					logger.info("Nombre: ");
					String nombre = consola.nextLine();
					logger.info("Apellido: ");
					String apellido = consola.nextLine();
					logger.info("Membresia: ");
					int membresia = consola.nextInt();
					cliente.setNombre(nombre);
					cliente.setApellido(apellido);
					cliente.setMembresia(membresia);
					clienteServicio.guardarCliente(cliente);
					logger.info("Cliente modificado");
				}else{
					logger.info("Cliente no encontrado " + cliente + nl);
				}
			}

			case 5 -> {
				logger.info("---Eliminar cliente---");
				logger.info("Id cliente a eliminar");
				int idCliente = consola.nextInt();
				Cliente cliente = clienteServicio.buscarClientePorId(idCliente);
				if (cliente != null){
					clienteServicio.elimiarCliente(cliente);
					logger.info("Cliente eliminado " + cliente);
				}else{
					logger.info("Cliente no encontrado");
				}

			}

			case 6 -> {
				logger.info("Hasta pronto " + nl + nl);
				salir = true;

			}
		}
		return salir;
	}
}
