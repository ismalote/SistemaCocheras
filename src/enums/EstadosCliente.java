package enums;

public final class EstadosCliente {
	public final static int ACTIVO = 1;
	public final static int INACTIVO = 2;
	public final static int CON_DEUDA = 3;
	
    public static String getEstado(int estado) {
        String descripcion = "";
        
        switch (estado) {
        case ACTIVO:
        	descripcion = "Activo";
        	break;
        case INACTIVO:
        	descripcion = "Inactivo";
        	break;
        case CON_DEUDA:
        	descripcion = "Con deuda";
        	break;
        default:
        	break;	
        }
        
        return descripcion;
    }
}
