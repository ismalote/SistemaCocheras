package enums;

public final class Tamanios {
	public final static int PEQUENIA = 1;
	public final static int MEDIANA = 2;
	public final static int GRANDE = 3;
	
    public static String getDescripcion(int tamanio) {
        String descripcion = "";
        
        switch (tamanio) {
        case PEQUENIA:
        	descripcion = "Pequeña";
        	break;
        case MEDIANA:
        	descripcion = "Mediana";
        	break;
        case GRANDE:
        	descripcion = "Grande";
        	break;
        default:
        	break;	
        }
        
        return descripcion;
    }
}