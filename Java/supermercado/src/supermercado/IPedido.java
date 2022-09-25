package supermercado;

import java.util.ArrayList;

public interface IPedido {
    String getReferencia();
    
    ArrayList<IProducto> getProductos();
    
    ArrayList<IContenedor> getContenedores();
    
    void addContenedor(IContenedor contenedor);
    
    IContenedor addProducto(IProducto producto);
}
