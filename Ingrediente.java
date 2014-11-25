public class Ingrediente {

	String nombreIngrediente;
	int cantidadGramos;
	int cantidadUnidad;
	boolean enGramos; 
		
	public String getNombreIngrediente(){
			return nombreIngrediente;
	}
		
	public void  setNombreIngrediente(String nombreIngrediente1){
		nombreIngrediente=nombreIngrediente1;
	}



	public int getCantidadGramos(){
		return cantidadGramos;
	}
		
	public void  setCantidadGramos(int cantidadGramos1){
		cantidadGramos=cantidadGramos1;
	}



	public int getCantidadUnidad(){
		return cantidadUnidad;
	}
		
	public void  setCantidadUnidad(int cantidadUnidad1){
		cantidadUnidad=cantidadUnidad1;
	}

	public boolean getEnGramos(){
		return enGramos;
	}
		
	public void  setEnGramos(boolean enGramos1){
		enGramos=enGramos1;
	}



}

