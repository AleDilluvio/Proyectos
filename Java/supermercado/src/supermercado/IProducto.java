package supermercado;

import supermercado.enums.Categoria;
import supermercado.contenedores.*;

public interface IProducto {
    String getReferencia();
    
    int getPeso();
    
    int getVolumen();
    
    Categoria getCategoria();
    
    boolean esCompatible(IProducto producto);
    
    boolean hayEspacio(IContenedor contenedor);
    
    void insertar(Contenedor contenedor);
}
