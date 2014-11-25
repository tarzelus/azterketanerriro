import java.util.*;

public class Receta {
	String nombreReceta;
	ArrayList<Ingrediente> ingredientes;
	String preparacion;


	public String getNombreReceta(){
		return nombreReceta;
	}
		
	public void  setNombreReceta(String nombreReceta1){
		nombreReceta=nombreReceta1;
	}
		

	public ArrayList<Ingrediente> getIngredientes(){
		return ingredientes;
	}
		
	public void  setIngredientes(ArrayList<Ingrediente> ingredientes1){
		ingredientes=ingredientes1;
	}

	
	public String getPreparacion(){
		return preparacion;
	}
		
	public void  setPreparacion(String preparacion1){
		preparacion=preparacion1;
	}



	}

