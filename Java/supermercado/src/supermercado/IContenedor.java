package supermercado;

import supermercado.enums.TipoContenedor;
import java.util.ArrayList;

public interface IContenedor {
    String getReferencia();
    
    int getVolumen();
    
    int getSuperficie();
    
    int volumenDisponible();
    
    int getResistencia();
    
    ArrayList<IProducto> getProductos();
    
    TipoContenedor getTipo();
    
    boolean insertarProducto(IProducto producto);
    
    boolean resiste(IProducto producto);
}
