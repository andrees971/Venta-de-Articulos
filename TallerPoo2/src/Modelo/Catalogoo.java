/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author WIN-10 GENERATION
 */
public class Catalogoo {
    
    String NombreDelCatalogo;
    String Fecha;
    String Estado;

    public Catalogoo(String NombreDelCatalogo, String Fecha, String Estado) {
        this.NombreDelCatalogo = NombreDelCatalogo;
        this.Fecha = Fecha;
        this.Estado = Estado;
    }

    public Catalogoo() {
    }
    
    

    public String getNombreDelCatalogo() {
        return NombreDelCatalogo;
    }

    public void setNombreDelCatalogo(String NombreDelCatalogo) {
        this.NombreDelCatalogo = NombreDelCatalogo;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    ArrayList<Catalogoo> listaCatalogo= new ArrayList();
    
    public ArrayList<Catalogoo> getListaCatalogo(){
        return listaCatalogo;
        
        
    }
    
     public void IngresarListaCatalogo(String Nombre,String Fecha, String Estado){
         Catalogoo C=null;
         if(Nombre.equals("") && Fecha.equals("") && Estado.equals("")){
             JOptionPane.showMessageDialog(null, "No se han enccontrado datos");
         }else{
         for(Catalogoo ca:listaCatalogo){
             if(ca.getNombreDelCatalogo().equals(Nombre)){
             C=ca;
             }
         }if(C!=null){
             JOptionPane.showMessageDialog(null, "Ese catalogo ya fue ingresado");
         }else{
             listaCatalogo.add(new Catalogoo(Nombre, Fecha, Estado));
         }
         }
     }
     
     public String Consultar(String Counsulta){
         Catalogoo C=null;
         String Resultado="";
         for(Catalogoo ca:listaCatalogo){
             if(ca.getNombreDelCatalogo().equals(Counsulta) || ca.getFecha().equals(Counsulta)){
             C=ca;
             }
         }if(C!=null){
             Resultado=C.getNombreDelCatalogo();
         }
         return Resultado;
         
     }
     public void modificarCatalogo(String Nombre, String Fecha, String Estado){
        Catalogoo C=null;
            for(Catalogoo ca:listaCatalogo){
                if(ca.getNombreDelCatalogo().equals(Nombre)){
                    C=ca;
                }
            }
            if(C!=null){
                C.setFecha(Fecha);
                C.setEstado(Estado);
            }
    }
    
    public void eliminarCatalogo(String CatalogoNombre){
        
        Catalogoo ca=null;
            for(Catalogoo cat:listaCatalogo){
                if(cat.getNombreDelCatalogo().equals(CatalogoNombre)){
                    ca=cat;
                }
            }
            if(ca!=null){
                listaCatalogo.remove(ca);
            }
        
    }
     
    
   
    
}
