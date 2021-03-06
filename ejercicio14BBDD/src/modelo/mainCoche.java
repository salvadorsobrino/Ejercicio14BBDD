package modelo;

import java.util.List;
import java.util.Scanner;

import modelo.entidades.Coche;
import modelo.negocio.GestorCoche;

public class mainCoche {
	public static void main(String[] args) {

		System.out.println("Bienvenidos a nuestra CRUD de coches");
		Scanner sc = new Scanner(System.in);
		boolean fin = false;
		GestorCoche gc = new GestorCoche();
		List<Coche> lista = null;
		/*
		1. Alta de coche
		2. Eliminar coche por id
		3. Modificar coche por id
		4. buscar coche por id
		5. buscar coche por matricula
		6. buscar coches por marca
		7. buscar coches por modelo
		8. listar todos los coches
		9. Salir de la aplicación*/
		
		do {
			menu();
			int opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				System.out.println("Dar alta coche (matricula/marca/modelo/km). Pulsa ENTER por cada valor");
				
				String matricula = sc.next();
				String marca = sc.next();
				String modelo = sc.next();
				int km  = sc.nextInt();
				
				Coche c = new Coche(matricula,marca,modelo,km);
				int alta = gc.alta(c);
				if(alta == 0) {
					System.out.println("Coche dado de alta");
				}else if(alta == 1) {
					System.out.println("Error de conexión con la BBDD");
				}else if(alta == 2){
					System.out.println("La matricula no tiene 7 carácteres o está repetida o los KM<0");
				}
				break;
			case 2:
				System.out.println("Eliminar coche (id). Introduce la id ");
				int id = sc.nextInt();
				if(gc.baja(id)) {
					System.out.println("Coche eliminado");
				} else {
					System.out.println("No se ha podido eliminar");
				}
				break;
			case 3:
				System.out.println("Modificar coche (id). Introduce la id ");
				id = sc.nextInt();
				if (gc.buscarId(id)==null) {
					System.out.println("No se ha encontrado el coche");
				} else {
					System.out.println(gc.buscarId(id));
					System.out.println("Modificar valores (matricula/marca/modelo/km). Pulsa ENTER por cada valor");
					
					matricula = sc.next();
					marca = sc.next();
					modelo = sc.next();
					km  = sc.nextInt();
					
					c = new Coche(id,matricula,marca,modelo,km);
					int modificar = gc.modificar(c);
					if(modificar  == 0) {
						System.out.println("Coche modificado");
					}else if(modificar == 1) {
						System.out.println("Error de conexión con la BBDD");
					}else if(modificar  == 2){
						System.out.println("La matricula no tiene 7 carácteres o está repetida o los KM<0");
					}
					System.out.println(gc.buscarId(id));
				}

				break;
			case 4:
				System.out.println("Buscar coche por ID: ");
				id = sc.nextInt();
				if (gc.buscarId(id)==null) {
					System.out.println("No se ha encontrado el coche");
				} else {
					System.out.println(gc.buscarId(id));
				}
				break;
			case 5:
				System.out.println("Buscar coche por matricula: ");
				matricula = sc.next();
				if (gc.buscarMatricula(matricula)==null) {
					System.out.println("No se ha encontrado el coche");
				} else {
					System.out.println(gc.buscarMatricula(matricula));
				}
				
				break;
			case 6:
				System.out.println("Buscar coches por marca: ");
				marca = sc.next();
				lista = gc.buscarMarca(marca);
				if (lista.size()>0) {
					for (int i=0;i<lista.size();i++) {
						System.out.println(lista.get(i));
					}
				} else {
					System.out.println("No se ha encontrado la marca");
				}
				break;
			case 7:
				System.out.println("Buscar coches por modelo: ");
				modelo = sc.next();
				lista = gc.buscarModelo(modelo);
				if (lista.size()>0) {
					for (int i=0;i<lista.size();i++) {
						System.out.println(lista.get(i));
					}
				} else {
					System.out.println("No se ha encontrado el modelo");
				}
				break;
			case 8:
				System.out.println("A continuación se listan todos los coches de la bbdd: ");
				lista = gc.listar();
				for (int i=0;i<lista.size();i++) {
					System.out.println(lista.get(i));
				}
				break;
			case 9:
				fin = true;
				break;
			}
		}while(!fin);
		
		System.out.println("Fin de programa");

	}

	private static void menu() {
		System.out.println("Elija una opción:");
		System.out.println("1- Alta de coche");
		System.out.println("2- Eliminar coche por id");
		System.out.println("3- Modificar coche por id");
		System.out.println("4- Buscar coche por id");
		System.out.println("5- Buscar coche por matricula");
		System.out.println("6- Buscar coches por marca");
		System.out.println("7- Buscar coches por modelo");
		System.out.println("8- Listar todos los coches");
		System.out.println("9- Salir del programa");
	}
}

