package supermercado.productos;

import supermercado.IContenedor;
import supermercado.IProducto;
import supermercado.contenedores.*;

public abstract class Producto implements IProducto{
    
    private String referencia;
    private int peso;
    private int volumen;
    private IContenedor contenedor;
    
    public Producto(String referencia, int peso, int volumen){
        this.referencia = referencia;
        this.peso = peso;
        this.volumen = volumen;
    }
    
    @Override
    public String getReferencia() {
        return referencia;
    }

    @Override
    public int getPeso() {
        return peso;
    }

    @Override
    public int getVolumen() {
        return volumen;
    }

    @Override
    public boolean hayEspacio(IContenedor contenedor) {
        return contenedor.volumenDisponible() > getVolumen();
    }
    
    @Override
    public void insertar(Contenedor contenedor){
        this.contenedor = contenedor;
    }
    
}
