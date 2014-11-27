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

		try {
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

       	//Lectura del fichero---------------------------------------------------
       	try{
			String ruta = "/home/zubiri/Proyectosjava/azterketanerriro/receta.txt";
 			File archivo2 = new File(ruta);
			FileReader leer2 = new FileReader (archivo2);
			BufferedReader bf2 = new BufferedReader(leer2);
			String salida2 = bf2.readLine();

	        
	        
	        String [] cortarString = null;	
	        System.out.println("\nRecetas");
	        while(salida2!=null){
	        	//separa el string de la  linea usara el ; como referencia de la separacion
	        	cortarString = salida2.split(";");
	        	System.out.println("·····················");
	        	System.out.println("Nombre de la receta: "+cortarString[0]);
	       		System.out.println("Preparacion: "+cortarString[2]);
	       		System.out.println("\n --Ingredientes-- ");
	       		String ingre = cortarString[1];
	       		//cortara lo previamente cortado y se ha guardado en la posicion 1 
	       		cortarString = ingre.split("#");
	       		//hay que recorrer el string de cortarstring por puede que haya mas de un ingrediente
	       		for(int x=0; x<cortarString.length; x++){
	       			String ingreAtribSeparados = cortarString[x];
	       			//solo quedara cortar los ingredientes y su informacion que estara separado por *
	       			String [] cortarString2 = ingreAtribSeparados.split("\\*");
	       			
	       			System.out.println("Ingrediente: "+cortarString2[0] );

	       			if (cortarString2[3].equalsIgnoreCase("true")){
	       			System.out.println("Gramos: "+cortarString2[1]);
	       			} 
	       			else{ 
	       			System.out.println("Unidades: "+cortarString2[2]);
	       			}
	       			System.out.println("\n");
	       			
	       		}
	       		
	       		salida2 = bf2.readLine();
	        }
	        
	    }catch(Exception ioe){
	    	System.out.println("Error: "+ioe);
	    }
	}
}
