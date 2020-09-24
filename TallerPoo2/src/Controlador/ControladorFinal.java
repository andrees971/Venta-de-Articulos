/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import Vistas.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author WIN-10 GENERATION
 */
public class ControladorFinal implements ActionListener{
    
    //todos estoes que estan aqui es para llamar las clases vista y de modelo y poder luego llamar los metodos con la variable objeto que seria la que va antes de el =
    Catalogo catalogoVistas= new Catalogo();
    Catalogoo catalogoModelo= new Catalogoo();
      Productos ProductosVistas= new Productos();
    Productoss productosModelo= new Productoss();
    Clientes ClientesVistas = new Clientes();
    Clientess clientesModelo= new Clientess();
    Entrada  entradaVista= new Entrada();
    asociacion asociacionVista=new asociacion();
    asociaciones asociacionModelo=new asociaciones();
    Menu  menuVista=new Menu();
    
//este es el contructor de el cual va inizilizar todos las claces y botones
    public ControladorFinal(Productos productosVistas, Productoss productossModelo, Entrada entradaVista, Menu menuVista, Catalogo catalogoVistas, Catalogoo catalogoModelo, Clientes ClientesVistas, Clientess clientesModelo,asociacion asociacionVista, asociaciones asociacionModelo) {
        this.catalogoModelo=catalogoModelo;
        this.catalogoVistas=catalogoVistas;
        
        this.catalogoVistas.btModificar.addActionListener(this);
        this.catalogoVistas.btConsultar.addActionListener(this);
        this.catalogoVistas.btModificar.addActionListener(this);
        this.catalogoVistas.btActivo.addActionListener(this);
        this.catalogoVistas.btNoActivo.addActionListener(this);
        this.catalogoVistas.btEliminar.addActionListener(this);
        this.catalogoVistas.btCrearCatalogo.addActionListener(this);
        
        this.clientesModelo=clientesModelo;
        this.ClientesVistas=ClientesVistas;
        
        this.ClientesVistas.btCrear.addActionListener(this);
        this.ClientesVistas.btConsultar.addActionListener(this);
        this.ClientesVistas.btModificar.addActionListener(this);
        this.ClientesVistas.btEliminar.addActionListener(this);
        
        this.entradaVista.jButton1.addActionListener(this);
        this.menuVista.btAsociacion.addActionListener(this);
        this.menuVista.btModuloCliente.addActionListener(this);
        this.menuVista.btProcesoDeCatalogo.addActionListener(this);
        this.menuVista.btProductos.addActionListener(this);
        
         this.productosModelo=productossModelo;
        this.ProductosVistas=ProductosVistas;
        
        this.ProductosVistas.btModificacion.addActionListener(this);
        this.ProductosVistas.btConsultarProductos.addActionListener(this);
        this.ProductosVistas.btEliminar.addActionListener(this);
        this.ProductosVistas.btAgregarFoto.addActionListener(this);
        this.ProductosVistas.btCrearProducto.addActionListener(this);
        this.menuVista.btProductos.addActionListener(this);
        this.ProductosVistas.btAtrasProducto.addActionListener(this);
        
        
        this.asociacionVista=asociacionVista;
        this.asociacionModelo=asociacionModelo;
        
        this.asociacionVista.btAsociar.addActionListener(this);
        this.asociacionVista.btConsultaAso.addActionListener(this);
        this.asociacionVista.btEliminarA.addActionListener(this);
        this.asociacionVista.btAtrasA.addActionListener(this);
    }
    //este iniciar lo que hace es abrir el menu de entrada
    public void iniciar(){
        entradaVista.setVisible(true);
    }
    
    //este llenar tabla lo que hace es llenar la tabla que esta en la vista
    public void llenarTablaCatalogo(JTable tablaDC){
        DefaultTableModel  modeloDC=new DefaultTableModel();//esto es un modelo de tabla
        
        
        //esto es para decir cual es la cabezaera del tabla
        String[] cabecera= {"ID","1° Nombre","2° Nombre", "1° Apellido", "2° Apellido", "Contraseña", "Numero Telefono"};
        modeloDC.setColumnIdentifiers(cabecera);
        
        //en este definimos el tamaño de la tabla
        Object[] columna= new Object[7];

        //con esto for vamos a recorrer el arraylis y vamos trayendo la informacion
        for(Clientess c:clientesModelo.getListaDeClientes()){
            //entonces vamos almacenando cada informacion que es ete almacenado en ese posicion en cada columna
            columna[1]=c.getPrimerNombre();
            columna[2]=c.getSegundoNombe();
            columna[3]=c.getPrimerApellido();
            columna[4]=c.getSegundoApellido();
            columna[6]=c.getNumeroTelefonico();
            columna[0]=c.getNumeroDeIdentificacion();
            columna[5]=c.getContraseña();
            //con esto definimos el numero de filas etnonces por cada ves traemos un nuevo grupo de informacion del arraylist el va aumentado su tamaño
            modeloDC.addRow(columna);           
        }
        //por ultimo mostramos la informacion el tabla de la vista
        ClientesVistas.JTablaClientes.setModel(modeloDC);
    }
    //llanar campos lo que hace es llenar los campos en los cuales estamos digitadno, en el caso de que estemos buscando algo
    public void llenarCamposClientes(int datos){
        Clientess cl=null;
            for(Clientess cli:clientesModelo.getListaDeClientes()){
                if(cli.getNumeroDeIdentificacion()==(datos)){
                    cl=cli;
                }
            }if(cl!=null){
                //entonces lo que hace es buscar el dato que le estoy pasando en e parametro 
                //y si lo encuntra va trayendo esa informacion y la escribe en los campos de texto
                ClientesVistas.JTexNumeroDeIdentificacion.setText(Integer.toString(cl.getNumeroDeIdentificacion()));
                ClientesVistas.JTexPrimerNombre.setText(cl.getPrimerNombre());
                ClientesVistas.JTexSegundoNombre.setText(cl.getSegundoNombe());
                ClientesVistas.JTexPrimerApellido.setText(cl.getPrimerApellido());
                ClientesVistas.JTexSegundoApellido.setText(cl.getSegundoApellido());
                try{
                ClientesVistas.JPasswordContraseña.setText(Integer.toString(cl.getContraseña()));
                ClientesVistas.JTexNumeroTelefonico.setText(Integer.toString(cl.getNumeroTelefonico()));
                }catch(Exception e){
                    
                }
            }
            
    }
    //este limpiar campos lo que hace es poner todos los campos de vistas en vacio ""
     public void limpiarCamposClientes(){
        ClientesVistas.JTexPrimerNombre.setText("");
        ClientesVistas.JTexSegundoNombre.setText("");
        ClientesVistas.JTexPrimerApellido.setText("");
        ClientesVistas.JTexSegundoApellido.setText("");
        ClientesVistas.JTexNumeroTelefonico.setText("");
        ClientesVistas.JTexNumeroDeIdentificacion.setText("");
        ClientesVistas.JTexConsultar.setText("");
        ClientesVistas.JPasswordContraseña.setText("");
    }
     
     public void llenarTabla(JTable tablaDC){
        DefaultTableModel  modeloDC=new DefaultTableModel();
        
        

        String[] cabecera= {"Nombre Del Catalogo", "Fecha","Estado"};
        modeloDC.setColumnIdentifiers(cabecera);
        Object[] columna= new Object[3];

        
        for(Catalogoo c:catalogoModelo.getListaCatalogo()){
            
            columna[0]=c.getNombreDelCatalogo();
            columna[1]=c.getFecha();
            columna[2]=c.getEstado();
           
            modeloDC.addRow(columna);           
        }
        
        catalogoVistas.JTlistaCatalogo.setModel(modeloDC);
    }
    
    public void llenarCamposCatalogo(String datos){
        Catalogoo cat=null;
            for(Catalogoo cata:catalogoModelo.getListaCatalogo()){
                if(cata.getNombreDelCatalogo().equals(datos)){
                    cat=cata;
                }
            }if(cat!=null){
                catalogoVistas.txtNombreDelCatalogo.setText(cat.getNombreDelCatalogo());
                catalogoVistas.txtFecha.setText(cat.getFecha());
               if(cat.getEstado().equals(catalogoVistas.btActivo.getText())){
                    catalogoVistas.btActivo.setSelected(true);
                }else if(cat.getEstado().equals(catalogoVistas.btNoActivo.getText())){
                    catalogoVistas.btNoActivo.setSelected(true);
                }
            }
            
    }
    
    public void limpiarCamposCatalogo(){
        catalogoVistas.txtNombreDelCatalogo.setText("");
        catalogoVistas.txtFecha.setText("");
       
    }
    
    public  void Entrada(){
        if(entradaVista.txtusuario.getText().equals("Jose")&& entradaVista.Password.getText().equals("sevillano")){
            menuVista.setVisible(true);
            entradaVista.setVisible(false);
        }else{ 
            JOptionPane.showMessageDialog(null, "No se pudo");
        }
        
    }
     public void llenarTablaProducto(JTable tablaDC){
        DefaultTableModel  modeloDC=new DefaultTableModel();
        
        

        String[] cabecera= {"Nombre Del Producto", "Cantidad en Existencia"};
        modeloDC.setColumnIdentifiers(cabecera);
        Object[] columna= new Object[2];

        
        for(Productoss c:productosModelo.getListaProductos()){
            
            columna[0]=c.getNombreDelProducto();
            columna[1]=c.getCantidadEnExistencia();
            
           
            modeloDC.addRow(columna);           
        }
        
        ProductosVistas.JTListaProductos.setModel(modeloDC);
    }
    
    public void llenarCamposproductos(String datos){
        Productoss prod=null;
            for(Productoss cata:productosModelo.getListaProductos()){
                if(cata.getNombreDelProducto().equals(datos)){
                    prod=cata;
                }
            }if(prod!=null){
                ProductosVistas.JTEXNombreDelProducto.setText(prod.getNombreDelProducto());
                try{
                ProductosVistas.JTEXCantidadEnExistencia.setText(Integer.toString(prod.getCantidadEnExistencia()));
                }catch(Exception e){
                    
                }
                ProductosVistas.jTextImagen.setText(prod.getAgregarFoto());
                Image foto= ProductosVistas.getToolkit().getImage(ProductosVistas.jTextImagen.getText());
            foto=foto.getScaledInstance(110, 110, Image.SCALE_DEFAULT);
            ProductosVistas.Imagen.setIcon(new ImageIcon(foto));
            }
            
    }
    
    public void limpiarCamposProducto(){
        ProductosVistas.JTEXNombreDelProducto.setText("");
        ProductosVistas.JTEXCantidadEnExistencia.setText("");
        ProductosVistas.jTextImagen.setText("");
        ProductosVistas.Imagen.setIcon(null);
       
    }
public void GetOnFoto(){
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Formato de archivo JPEG(.JPG;.JPEG)", "jpg","jpeg");
        JFileChooser archivo=new JFileChooser();
        archivo.addChoosableFileFilter(filtro);
        archivo.setDialogTitle("Buscar imagen o foto");
        File ruta= new File("D:/fotos");
        archivo.setCurrentDirectory(ruta);
        int ventana = archivo.showOpenDialog(null);
        String img=null;
        File file=null;
        
        if(ventana== JFileChooser.APPROVE_OPTION){
            
            file=archivo.getSelectedFile();
            ProductosVistas.jTextImagen.setText(String.valueOf(file));
            Image foto= ProductosVistas.getToolkit().getImage(ProductosVistas.jTextImagen.getText());
            foto=foto.getScaledInstance(110, 110, Image.SCALE_DEFAULT);
            ProductosVistas.Imagen.setIcon(new ImageIcon(foto));
            img=ProductosVistas.jTextImagen.getText();   
        }   
    } 
 public void llenarTablaAso(JTable tablaDA){
        DefaultTableModel  modeloDA=new DefaultTableModel();
        
        String[] cabecera= {"Nombre del catalogo","Nombre del producto","Valor producto", "Puntos ganados", "Puntos redimir"};
        modeloDA.setColumnIdentifiers(cabecera);
        Object[] columna= new Object[5];
        
        for(asociaciones a:asociacionModelo.obtenerAsociacion()){     
            columna[0]=a.getCatalogo();
            columna[1]=a.getProductos();
            columna[2]=a.getValorProducto();
            columna[3]=a.getPganados();
            columna[4]=a.getPredimir();
            
            modeloDA.addRow(columna);           
        } 
        asociacionVista.jTable1.setModel(modeloDA);
    }
    
    public void limpiarCamposAso(){
        asociacionVista.txValorProd.setText("");
        asociacionVista.txPuntosGa.setText("");
        asociacionVista.txPuntosRe.setText("");
    }
    public void camposCatalogoAso(){
        DefaultComboBoxModel catalogo =new DefaultComboBoxModel();
        
        for(Catalogoo ca:catalogoModelo.getListaCatalogo()){
            catalogo.addElement(ca);
        }
        asociacionVista.cbCatalogo.setModel(catalogo);
    }
    
    public void camposProductos(){
        DefaultComboBoxModel produtos =new DefaultComboBoxModel();
        for(Productoss po:productosModelo.getListaProductos()){
            produtos.addElement(po);
        }
        asociacionVista.cbProducto.setModel(produtos);
    }
    
    public void llenarCamposAso(){
        asociaciones aP=null;
        for(asociaciones aPC:asociacionModelo.obtenerAsociacion()){
            if((asociacionVista.cbCatalogo.getSelectedItem().equals(aPC.getCatalogo())&& (asociacionVista.cbProducto.getSelectedItem().equals(aPC.getProductos())))){
                aP=aPC;
            }
        }if(aP!=null){
            try{
            asociacionVista.txValorProd.setText(Integer.toString(aP.getValorProducto()));
            asociacionVista.txPuntosGa.setText(Integer.toString(aP.getPganados()));
            asociacionVista.txPuntosRe.setText(Integer.toString(aP.getPredimir()));
            }catch(Exception e){
                
            }
        }
    }

    
    public void actionPerformed(ActionEvent e){
        
        //en action performed es donde vamos a traer la informacion que estamos digitando en los campos de texto,
        //ademas de que estamos diciendo que evonto va hacer cada boton
            String id=ClientesVistas.JTexNumeroDeIdentificacion.getText();
            String primerNom=ClientesVistas.JTexPrimerNombre.getText();
            String segundoNom=ClientesVistas.JTexSegundoNombre.getText();
            String primerApe=ClientesVistas.JTexPrimerApellido.getText();
            String segundoApe=ClientesVistas.JTexSegundoApellido.getText();
            String contraseña=ClientesVistas.JPasswordContraseña.getText();
            String tel=ClientesVistas.JTexNumeroTelefonico.getText();
            int conID;
            String consulta=ClientesVistas.JTexConsultar.getText();
            int identifi=0;
            int tele=0;
            int contr=0;
            
            try{
                identifi=Integer.parseInt(id);
                tele=Integer.parseInt(tel);
                contr=Integer.parseInt(contraseña);
                       
            }catch(Exception e1){
                
            }
            
            if(e.getSource()==ClientesVistas.btCrear){  
                clientesModelo.IngresarClientes(identifi, primerNom, segundoNom, primerApe, segundoApe, contr, tele);
                llenarTablaCatalogo(ClientesVistas.JTablaClientes);
                limpiarCamposClientes();

            }
            if(e.getSource()==ClientesVistas.btConsultar){
                conID=clientesModelo.Consultar(consulta);
                llenarCamposClientes(conID);

            }
            if(e.getSource()==ClientesVistas.btModificar){
                conID=clientesModelo.Consultar(consulta);
                clientesModelo.modificarCliente(conID,tele,contr);
                llenarTablaCatalogo(ClientesVistas.JTablaClientes);
                

            }if(e.getSource()==ClientesVistas.btEliminar){
                conID=clientesModelo.Consultar(consulta);
                clientesModelo.eliminarCliente(conID);
                llenarTablaCatalogo(ClientesVistas.JTablaClientes);
                limpiarCamposClientes();
            }
            String NombreCatalogo=catalogoVistas.txtNombreDelCatalogo.getText();
            String fecha=catalogoVistas.txtFecha.getText();
           
           
            String consultaCatalogo=catalogoVistas.txConsulta.getText();
            String NombreCatalogoo="";
            String estado="";
           
           if(catalogoVistas.btActivo.isSelected()){
                estado=catalogoVistas.btActivo.getText();
            }else if(catalogoVistas.btNoActivo.isSelected()){
                estado=catalogoVistas.btNoActivo.getText();
            } 
            
            
            if(e.getSource()==catalogoVistas.btCrearCatalogo){  
                catalogoModelo.IngresarListaCatalogo(NombreCatalogo, fecha, estado);
                llenarTabla(catalogoVistas.JTlistaCatalogo);
                limpiarCamposCatalogo();

            }
            if(e.getSource()==catalogoVistas.btConsultar){
                NombreCatalogoo=catalogoModelo.Consultar(consultaCatalogo);
                llenarCamposCatalogo(NombreCatalogoo);

            }
            if(e.getSource()==catalogoVistas.btModificar){
                NombreCatalogoo=catalogoModelo.Consultar(consultaCatalogo);
                catalogoModelo.modificarCatalogo(NombreCatalogoo, fecha, estado);
                llenarTabla(catalogoVistas.JTlistaCatalogo);
                

            }if(e.getSource()==catalogoVistas.btEliminar){
                NombreCatalogoo=catalogoModelo.Consultar(consultaCatalogo);
                catalogoModelo.eliminarCatalogo(NombreCatalogoo);
                llenarTabla(catalogoVistas.JTlistaCatalogo);
                limpiarCamposCatalogo();
            }
            
             String NombreDelProducto=ProductosVistas.JTEXNombreDelProducto.getText();
            String CantidadEnExistenci=ProductosVistas.JTEXCantidadEnExistencia.getText();
            int CantidadDeExistencia=0;
            
            try{
                CantidadDeExistencia= Integer.parseInt(CantidadEnExistenci);
            }catch(Exception e1){
            }
           
           
            String consultaProductos=ProductosVistas.jTexConsultaP.getText();
            String NombreDelProductoo="";
            String AgregarFoto=ProductosVistas.jTextImagen.getText();
          if(e.getSource()==ProductosVistas.btAgregarFoto){
              GetOnFoto();
          }
              
            
            
            if(e.getSource()==ProductosVistas.btCrearProducto){  
                productosModelo.IngresarListaDeProductos(NombreDelProducto, CantidadDeExistencia, AgregarFoto);
                llenarTablaProducto(ProductosVistas.JTListaProductos);
                limpiarCamposProducto();

            }
            if(e.getSource()==ProductosVistas.btConsultarProductos){
                NombreDelProductoo=productosModelo.ConsultarProducto(consultaProductos);
                llenarCamposproductos(NombreDelProductoo);

            }
            if(e.getSource()==ProductosVistas.btModificacion){
                NombreDelProductoo=productosModelo.ConsultarProducto(consultaProductos);
                productosModelo.modificarProducto(NombreDelProducto, CantidadDeExistencia, AgregarFoto);
                llenarTablaProducto(ProductosVistas.JTListaProductos);
                

            }if(e.getSource()==ProductosVistas.btEliminar){
                NombreDelProductoo=productosModelo.ConsultarProducto(consultaProductos);
                productosModelo.eliminarProducto(NombreDelProductoo);
                llenarTablaProducto(ProductosVistas.JTListaProductos);
                limpiarCamposProducto();
            }
            
            Catalogoo catalogo=(Catalogoo)asociacionVista.cbCatalogo.getSelectedItem();
         Productoss producto=(Productoss)asociacionVista.cbProducto.getSelectedItem();
         String valorProduc=asociacionVista.txValorProd.getText();
         String puntosGana=asociacionVista.txPuntosGa.getText();
         String puntosRedimir=asociacionVista.txPuntosRe.getText();
         

         if(e.getSource()==asociacionVista.btAsociar){
            asociacionModelo.crearAsociacion(puntosGana, puntosRedimir, valorProduc, catalogo, producto);
            llenarTablaAso(asociacionVista.jTable1);
            limpiarCamposAso();
         }
         if(e.getSource()==asociacionVista.btConsultaAso){
            llenarCamposAso();
         }if(e.getSource()==asociacionVista.btEliminarA){
            asociacionModelo.eliminarAsociacion(catalogo, producto);
            llenarTablaAso(asociacionVista.jTable1);
            limpiarCamposAso();
         }
            
            if(e.getSource()==entradaVista.jButton1){
                 Entrada();
                
            }if(e.getSource()==menuVista.btModuloCliente){
                ClientesVistas.setVisible(true);
                menuVista.setVisible(false);
            }if(e.getSource()==menuVista.btProcesoDeCatalogo){
                catalogoVistas.setVisible(true);
                menuVista.setVisible(false);
            }   
            if(e.getSource()==menuVista.btProductos){
                ProductosVistas.setVisible(true);
                menuVista.setVisible(false);
                
            }   if(e.getSource()==ProductosVistas.btAtrasProducto){
                menuVista.setVisible(true);
                ProductosVistas.setVisible(false);  
            } if(e.getSource()==menuVista.btAsociacion){
                asociacionVista.setVisible(true);
                menuVista.setVisible(false);
                camposCatalogoAso();
                camposProductos();
            }if(e.getSource()==asociacionVista.btAtrasA){
            menuVista.setVisible(true);
            asociacionVista.setVisible(false);
            }  
        }        
        
    }

    
    
    
    
    

