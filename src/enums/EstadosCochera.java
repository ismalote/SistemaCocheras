package enums;

public final class EstadosCochera {
	public final static int LIBRE = 1;
	public final static int OCUPADA = 2;
	public final static int INACTIVA = 3;
	
    public static String getEstado(int estado) {
        String descripcion = "";
        
        switch (estado) {
        case LIBRE:
        	descripcion = "Libre";
        	break;
        case OCUPADA:
        	descripcion = "Ocupada";
        	break;
        case INACTIVA:
        	descripcion = "Inactiva";
        	break;
        default:
        	break;	
        }
        
        return descripcion;
    }
}