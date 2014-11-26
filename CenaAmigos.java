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

			ingredientes = new ArrayList<Ingrediente>();

			for (int y=0 ; y<num_ing ; y++){

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
			String ruta = "/home/zubiri/Proyectosjava/azterketanerriro/receta.txt";
 			File archivo2 = new File(ruta);
			FileWriter fw = new FileWriter(archivo2);
			BufferedWriter bw = new BufferedWriter(fw);

			for(int r=0; r<recetas.size(); r++){
	            bw.write(recetas.get(r).getNombreReceta() + ";");
	            ingredientes = recetas.get(r).getIngredientes();
	            for(int i=0; i<ingredientes.size(); i++){
					bw.write(ingredientes.get(i).getNombreIngrediente()+
					"*"+ingredientes.get(i).getCantidadGramos()+
					"*"+ingredientes.get(i).getCantidadUnidad()+
					"*"+ingredientes.get(i).getEnGramos()+"#");
	            }	
            	bw.write(";" + recetas.get(r).getPreparacion() + "\n");   
        	}	
       		bw.close();
        }
        catch (FileNotFoundException ex) {
           	System.out.println(ex.getMessage());
       	}


       	try{
			File listaRecetas2 = new File("/home/zubiri/Proyectosjava/azterketanerriro/receta.txt");
			FileInputStream fis = new FileInputStream(listaRecetas2);
	        InputStreamReader isr = new InputStreamReader(fis, "UTF8");
	        BufferedReader br = new BufferedReader(isr);

	        String linea;
	        linea = br.readLine();
	        String [] campos = null;
	        System.out.println("\nTus recetas...");
	        while(linea!=null){
	        	campos = linea.split(";");
	        	System.out.println("--------------------------------");
	        	System.out.println("Nombre: "+campos[0]);
	       		System.out.println("Descripcion: "+campos[2]);
	       		String ingre = campos[1];
	       		campos = ingre.split("#");
	       		for(int x=0; x<campos.length; x++){
	       			String ingreAtribSeparados = campos[x];
	       			String [] campos2 = ingreAtribSeparados.split("\\*");
	       			System.out.println("Ingredientes: ");
	       			System.out.println("Nombre: "+campos2[0]);
	       			System.out.println("Gramos: "+campos2[1]);
	       			System.out.println("Unidades: "+campos2[2]);
	       			System.out.println("--------------------------------");
	       			//System.out.println("¿En gramos?: "+campos2[3]);
	       		}
	       		
	       		linea = br.readLine();
	        }
	        
	    }catch(Exception ioe){
	    	System.out.println("Error: "+ioe);
	    }
	}
}
