import java.util.*;
import java.io.*;

public class CenaAmigos {

public static void main (String args[]) throws IOException{		
		Scanner sc = new Scanner(System.in);

		System.out.print("Ingresa el numero de recetas que quieras insertar:");	
		int num_rec=sc.nextInt();

		ArrayList<Receta> recetas = new ArrayList<Receta>();
		ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();

		for (int x=0 ; x<num_rec ; x++){

			Receta receta = new Receta();

			System.out.print("Ingresa el nombre de la receta:");	
			receta.setNombreReceta(sc.next());

			System.out.print("Ingresa el numero de ingredientes que tiene la receta:");
			int num_ing=sc.nextInt();

			for (int y=0 ; y<num_rec ; y++){

				Ingrediente ingrediente = new Ingrediente();

				System.out.print("Ingresa el nombre del ingrediente:");	
				ingrediente.setNombreIngrediente(sc.next());

				System.out.print("1 si el ingrediente es en gramos o 0 si es en unidades:");
				int en=	sc.nextInt();

				if (en == 1){
					ingrediente.setEnGramos(true);
					System.out.print("Cuantos gramos tiene?");
					ingrediente.setCantidadGramos(sc.nextInt());
					ingrediente.setCantidadUnidad(-1);
				}
				else{
					ingrediente.setEnGramos(false);
					System.out.print("Cuantas unidades?");
					ingrediente.setCantidadUnidad(sc.nextInt());
					ingrediente.setCantidadGramos(-1);
				}
				ingredientes.add(ingrediente);
			}

			receta.setIngredientes(ingredientes);	

			System.out.print("Cual es la preparacion de lareceta?");	
			receta.setPreparacion(sc.next());

			recetas.add(receta);
		}
		//escribir en el fichero-----------------------------------------------------------

		try {//para escribir en el fichero
			String ruta = "/home/zubiri/Proyectosjava/examen2/receta.txt";
 			File archivo2 = new File(ruta);
			FileWriter fw = new FileWriter(archivo2);
			BufferedWriter bw = new BufferedWriter(fw);

			for(int r=0; r<recetas.size(); r++){
	            bw.write(recetas.get(r).getNombreReceta() + " ");
	            ingredientes = recetas.get(r).getIngredientes();
	            for(int i=0; i<recetas.size(); i++){
					bw.append(ingredientes.get(i).getNombreIngrediente()+
					"*"+ingredientes.get(i).getCantidadGramos()+
					"*"+ingredientes.get(i).getCantidadUnidad()+
					"*"+ingredientes.get(i).getEnGramos()+"#");
	            }	
            	bw.write(recetas.get(r).getPreparacion() + "\n");   
        	}	
       		bw.close();
        }
        catch (FileNotFoundException ex) {
           	System.out.println(ex.getMessage());
       	}
	}
}
