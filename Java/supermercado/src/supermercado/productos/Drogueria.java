package supermercado.productos;

import supermercado.enums.Categoria;
import supermercado.IProducto;

public class Drogueria extends Producto{

    public Drogueria(String referencia, int peso, int volumen) {
        super(referencia, peso, volumen);
    }

    @Override
    public Categoria getCategoria() {
        return Categoria.DROGUERIA;
    }

    @Override
    public boolean esCompatible(IProducto p) {
        return !Categoria.ALIMENTACION.equals(p.getCategoria()) && !Categoria.MASCOTAS.equals(p.getCategoria());
    }
    
}
