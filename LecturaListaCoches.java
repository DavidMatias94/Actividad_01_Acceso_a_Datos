import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;



public class LecturaListaCoches {

	public static void main(String[] args) {


		File file = new File(EscrituraListaCoches.nombreFichero);

		if (file.exists()) {

			try (FileInputStream fis = new FileInputStream(file);
					ObjectInputStream ois = new ObjectInputStream(fis);) {

				List<Coche> listaCoches = (List<Coche>)ois.readObject();

				System.out.println("Objeto leido");
				System.out.println("Imprimiendo lista de coches");

				for(Coche p : listaCoches){
					System.out.println(p);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

			System.out.println("Cerrando programa");
		}else {
			System.out.println("El fichero no existe");
		}
		
		
		
		

	}


	}


