package supermercado.contenedores;

import java.util.ArrayList;
import supermercado.IContenedor;
import supermercado.IProducto;

public abstract class Contenedor implements IContenedor {
    
    private String referencia;
    private int alto;
    private ArrayList<IProducto> productos;
    private int resistencia;
    
    public Contenedor(String referencia, int alto, int resistencia){
        this.referencia = referencia;
        this.alto = alto;
        this.resistencia = resistencia;
        this.productos = new ArrayList<IProducto>();
    }
    
    @Override
    public String getReferencia() {
        return referencia;
    }

    @Override
    public int getVolumen() {
        return alto * getSuperficie();
    }

    @Override
    public int volumenDisponible() {
        return getVolumen() - volumenOcupado();
    }
    
    public int volumenOcupado(){
        int res = 0;
        for(IProducto p : productos){
            res += p.getVolumen();
        }
        return res;
    }

    @Override
    public int getResistencia() {
        return resistencia;
    }

    @Override
    public ArrayList<IProducto> getProductos() {
        return productos;
    }

    @Override
    public boolean insertarProducto(IProducto producto) {
        boolean compatibilidadOk = true;
        
        for(IProducto p : productos){
            if (!producto.esCompatible(p)){
                compatibilidadOk = false;
                break;
            }
        }
        
        boolean acepta = resiste(producto) && producto.hayEspacio(this) && compatibilidadOk;
        if(acepta){
            productos.add(producto);
            producto.insertar(this);
        }
        return acepta;
    }

    @Override
    public boolean resiste(IProducto producto) {
        return getResistencia()> producto.getPeso();
    }
    
}
