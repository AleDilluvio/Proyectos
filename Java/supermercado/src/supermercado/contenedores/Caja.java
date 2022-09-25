package supermercado.contenedores;

import supermercado.enums.TipoContenedor;
import supermercado.IProducto;

public class Caja extends Contenedor{
    private int largo;
    private int ancho;
    
    public Caja(String referencia, int alto, int ancho, int largo){
        super(referencia, largo, 0);
        this.largo = largo;
        this.ancho = ancho;
    }
    
    @Override
    public int getSuperficie() {
        return ancho*largo;
    }

    @Override
    public TipoContenedor getTipo() {
        return TipoContenedor.CAJA;
    }
    
    @Override
    public boolean resiste(IProducto producto) {
        return true;
    }
    
}
