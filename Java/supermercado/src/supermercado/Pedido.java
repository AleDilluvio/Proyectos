package supermercado;

import java.util.ArrayList;

public class Pedido implements IPedido {

    private String referencia;
    private ArrayList<IContenedor> contenedores;

    public Pedido(String referencia) {
        this.referencia = referencia;
        this.contenedores = new ArrayList<IContenedor>();
    }

    @Override
    public String getReferencia() {
        return referencia;
    }

    @Override
    public ArrayList<IContenedor> getContenedores() {
        return contenedores;
    }

    @Override
    public void addContenedor(IContenedor contenedor) {
        contenedores.add(contenedor);
    }

    @Override
    public IContenedor addProducto(IProducto producto) {
        for(IContenedor contenedor: contenedores){
            if(contenedor.insertarProducto(producto)){
                return contenedor;
            }
        }
        return null;
    }

    @Override
    public ArrayList<IProducto> getProductos() {
        ArrayList<IProducto> productos = null;
        for(IContenedor c: contenedores){
            if(productos==null){
                productos = c.getProductos();
            } else {
                productos.addAll(c.getProductos());
            }
        }
        return productos;
    }
    
}
