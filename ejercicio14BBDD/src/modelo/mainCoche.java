package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.entidades.Coche;
import modelo.negocio.GestorCoche;

public class mainCoche {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		GestorCoche gc = new GestorCoche();
		
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
			System.out.println("Error de conexi�n con la BBDD");
		}else if(alta == 2){
			System.out.println("La matricula no tiene 7 car�cteres o est� repetida o los KM<0");
		}
		System.out.println("A continuaci�n se listan todos los coches de la bbdd: ");
		List<Coche> lista = gc.listar();
		for (int i=0;i<lista.size();i++) {
			System.out.println(lista.get(i));
		}
		
		System.out.println("Modificar coche (id). Introduce la id ");
		int id = sc.nextInt();
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
				System.out.println("Error de conexi�n con la BBDD");
			}else if(modificar  == 2){
				System.out.println("La matricula no tiene 7 car�cteres o est� repetida o los KM<0");
			}
			System.out.println(gc.buscarId(id));
		}
		
		System.out.println("Eliminar coche (id). Introduce la id ");
		id = sc.nextInt();
		if(gc.baja(id)) {
			System.out.println("Coche eliminado");
		} else {
			System.out.println("No se ha podido eliminar");
		}
		
		System.out.println("Buscar coche por ID: ");
		id = sc.nextInt();
		if (gc.buscarId(id)==null) {
			System.out.println("No se ha encontrado el coche");
		} else {
			System.out.println(gc.buscarId(id));
		}
		
		System.out.println("Buscar coche por matricula: ");
		matricula = sc.next();
		if (gc.buscarMatricula(matricula)==null) {
			System.out.println("No se ha encontrado el coche");
		} else {
			System.out.println(gc.buscarMatricula(matricula));
		}
		
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


		System.out.println("Fin del programa");
	}
}