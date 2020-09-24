/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjecucionPrincipal;

import Controlador.*;
import Modelo.*;
import Vistas.*;

/**
 *
 * @author WIN-10 GENERATION
 */
public class principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Clientes ClientesVistas = new Clientes();
        Clientess clientesModelo= new Clientess();
//        ControladorCliente controladoC=new ControladorCliente(ClientesVistas, clientesModelo);
        
//        ClientesVistas.setVisible(true);
        
        
        Catalogo catalogoVistas = new Catalogo();
        Catalogoo catalogoModelo= new Catalogoo();
        
              Productos ProductosVistas= new Productos();
        Productoss productosModelo= new Productoss();
        
        asociacion asociacionVista=new asociacion();
        asociaciones asociacionModelo=new asociaciones();
    
        Menu menuVistas= new Menu();
        Entrada entradaVista= new Entrada();
        
        
        
        ControladorFinal controladorVistas= new ControladorFinal(ProductosVistas, productosModelo, entradaVista, menuVistas, catalogoVistas, catalogoModelo, ClientesVistas, clientesModelo, asociacionVista, asociacionModelo);
        controladorVistas.iniciar();
//        ControladorCatalogo controladorC= new ControladorCatalogo(catalogoVistas, catalogoModelo);
        
//        catalogoVistas.setVisible(true);
        
        
    }
    
    
    
}
