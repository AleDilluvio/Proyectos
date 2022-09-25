package supermercado;

import supermercado.contenedores.*;
import supermercado.productos.*;

public class Main {
    public static void main(String[] args) {
        IPedido miPedido = new Pedido("pedido001");
        
        IContenedor bolsa1 = new Bolsa("B111",50,60,1000);
        IContenedor caja1 = new Caja("C111",30,50,70);
        miPedido.addContenedor(caja1);
        miPedido.addContenedor(bolsa1);
        
        IProducto bananas = new Fresco("BNN",500,900);
        IProducto naranjas = new Fresco("NRJ",800,1200);
        IProducto cuadril = new Congelado("CDL",300,1000);
        IProducto pastaDental = new Higiene("PST",1000,2500);
        IContenedor contBananas = miPedido.addProducto(bananas);
        IContenedor contNaranjas = miPedido.addProducto(naranjas);
        IContenedor contCuadril = miPedido.addProducto(cuadril);
        IContenedor contPastaDental = miPedido.addProducto(pastaDental);
    }
}
