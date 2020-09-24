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
public class Productoss {
    
    String NombreDelProducto;
    int CantidadEnExistencia;
    String AgregarFoto;

    public Productoss(String NombreDelProducto, int CantidadEnExistencia, String AgregarFoto) {
        this.NombreDelProducto = NombreDelProducto;
        this.CantidadEnExistencia = CantidadEnExistencia;
        this.AgregarFoto= AgregarFoto;
    }

    public Productoss() {
    }
    

    public String getNombreDelProducto() {
        return NombreDelProducto;
    }

    public void setNombreDelProducto(String NombreDelProducto) {
        this.NombreDelProducto = NombreDelProducto;
    }
    
    public  String getAgregarFoto(){
        return AgregarFoto;
    }
    
    public void setAgregarFoto (String AgregarFoto){
        this.AgregarFoto= AgregarFoto;
    }

    public int getCantidadEnExistencia() {
        return CantidadEnExistencia;
    }

    public void setCantidadEnExistencia(int CantidadEnExistencia) {
        this.CantidadEnExistencia = CantidadEnExistencia;
    }
    
    
    ArrayList<Productoss>  ListaDeProductos = new ArrayList<>();
     public ArrayList<Productoss> getListaProductos(){
        return ListaDeProductos;
    
    
}
     public void IngresarListaDeProductos(String NombreDelProducto,int CantidadEnExistencia, String AgregarFoto){
         Productoss P=null;
         
         for(Productoss pc:ListaDeProductos){
             if(pc.getNombreDelProducto().equals(NombreDelProducto)){
             P=pc;
             }
         }if(P!=null){
             JOptionPane.showMessageDialog(null, "Ese Producto ya fue ingresado");
         }else{
             ListaDeProductos.add(new Productoss(NombreDelProducto, CantidadEnExistencia, AgregarFoto));
         }
     }
     
public String ConsultarProducto(String Counsulta){
         Productoss P=null;
         String Resultado="";
         for(Productoss pc:ListaDeProductos){
             if(pc.getNombreDelProducto().equals(Counsulta)){
             P=pc;
             }
         }if(P!=null){
             Resultado=P.getNombreDelProducto();
         }
         return Resultado;
         
     }
public void modificarProducto(String NombreDelProducto, int CantidadEnExistencia,String AgregarFoto){
        Productoss P=null;
            for(Productoss pc:ListaDeProductos){
                if(pc.getNombreDelProducto().equals(NombreDelProducto)){
                    P=pc;
                }
            }
            if(P!=null){
                P.setNombreDelProducto(NombreDelProducto);
                P.setCantidadEnExistencia(CantidadEnExistencia);
                P.setAgregarFoto(AgregarFoto);
                
            }
    }
public void eliminarProducto(String NombreDelProducto){
        
        Productoss pc=null;
            for(Productoss Pro:ListaDeProductos){
                if(Pro.getNombreDelProducto().equals(NombreDelProducto)){
                    pc=Pro;
                }
            }
            if(pc!=null){
                ListaDeProductos.remove(pc);
            }
        
    }
}
