import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;






public class EscrituraListaCoches {

	public static final String nombreFichero = "C:/proyecto/datos2.dat";

	public static void main(String[] args) throws ClassNotFoundException {

		Scanner leer = new Scanner (System.in);

		Coche coche3 = new Coche();

		List<Coche> listaCoches = new ArrayList<Coche>();
		Coche coche = new Coche();		

		coche.setId(133);
		coche.setMatricula("7733JUJ");
		coche.setMarca("Seat");
		coche.setModelo("Ibiza");
		coche.setColor("Rojo");

		listaCoches.add(coche);

		Coche coche2 = new Coche();

		coche2.setId(2);
		coche2.setMatricula("7732JUJ");
		coche2.setMarca("Seat");
		coche2.setModelo("Ibiza");
		coche2.setColor("Verde");

		listaCoches.add(coche2);

		File file = new File(nombreFichero);

		try (FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			//oos = new ObjectOutputStream(new FileOutputStream(new File(nombreFichero)));
			oos.writeObject(listaCoches);
			System.out.println("Objeto introducido");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		System.out.println("Cerrando programa");

		//Hacemos un bucle do while para que de la opción de elegir del menú hasta que pulse salir
		//que hacer pasará a true y saldremos del bucle
		boolean hacer = false;

		do {


			System.out.println("Elija una opción: " + "\n" +"1.Añadir nuevo coche" + "\n"+"2.Borrar coche por id"+
					"\n"+"3.Consultar coches por id"+"\n"+"4.Listado de coches"+"\n"+"5.Terminar el programa");	 





			int opcion = leer.nextInt();


			switch (opcion) {


			case 1:

				System.out.println("Introduzca id:");
				int addId = leer.nextInt();
				coche3.setId(addId);

				System.out.println("Introduzca matrícula:");
				String addMatricula = leer.next();
				coche3.setMatricula(addMatricula);

				System.out.println("Introduca la marca: ");
				String addMarca= leer.next();
				coche3.setMarca(addMarca);

				System.out.println("Introduzca modelo:");
				String addModelo= leer.next();
				coche3.setModelo(addModelo);

				System.out.println("Introduzca color:");
				String addColor=leer.next();
				coche3.setColor(addColor);


				listaCoches.add(coche3);


				break;
			case 2:
				System.out.println("Escriba el id:");
				int id = leer.nextInt();
				for (int i=0; i<listaCoches.size();i++) {
					if(listaCoches.get(i).getId()==(id)) {
						System.out.println("lo ha encontrado");

						listaCoches.remove(i);	
					}else {
						System.out.println("no lo ha encontrado");
					}
				}

				break;
			case 3:
				System.out.println("Escriba un id");
				int buscadorId =leer.nextInt();
				for (int i=0;i<listaCoches.size();i++) {
					if(listaCoches.get(i).getId()==(buscadorId)) {
						System.out.println(listaCoches.get(i).toString());
					}
				}
				break;
			case 4:
				System.out.println(listaCoches.toString());

				break;
			case 5:
				//una vez pulse 5 exportaremos los objetos a nuestro fichero .dat y lo podremos ver en la clase LecturaListaCoches al ejecutarla
				try (FileOutputStream fos = new FileOutputStream(file);
						ObjectOutputStream oos = new ObjectOutputStream(fos)) {
					//oos = new ObjectOutputStream(new FileOutputStream(new File(nombreFichero)));
					oos.writeObject(listaCoches);
					System.out.println("Objeto introducido");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 

				hacer=true;
				System.out.println("Terminaste");
				break;
			default:

				System.out.println("Elija otra opción");
			}

		}while(!hacer);


	}

}
