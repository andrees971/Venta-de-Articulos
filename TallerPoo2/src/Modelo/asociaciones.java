
package Modelo;

import Modelo.Catalogoo;
import Modelo.Productoss;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class asociaciones {
    
    public int Pganados;
    public int Predimir;
    public int valorProducto;
    public Catalogoo catalogo;
    public Productoss  productos;

    public int getPganados() {
        return Pganados;
    }

    public void setPganados(int Pganados) {
        this.Pganados = Pganados;
    }

    public int getPredimir() {
        return Predimir;
    }

    public void setPredimir(int Predimir) {
        this.Predimir = Predimir;
    }

    public Catalogoo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogoo catalogo) {
        this.catalogo = catalogo;
    }

    public Productoss getProductos() {
        return productos;
    }

    public void setProductos(Productoss productos) {
        this.productos = productos;
    }

    public int getValorProducto() {
        return valorProducto;
    }

    public void setValorProducto(int valorProducto) {
        this.valorProducto = valorProducto;
    }
    
    

    public asociaciones(int Pganados, int Predimir, int valorProducto, Catalogoo catalogo, Productoss productos) {
        this.Pganados = Pganados;
        this.Predimir = Predimir;
        this.valorProducto = valorProducto;
        this.catalogo = catalogo;
        this.productos = productos;
    }

    

    public asociaciones() {
    }
    
    
    ArrayList<asociaciones> listAsociacion=new ArrayList();
    public ArrayList<asociaciones>obtenerAsociacion(){
        return listAsociacion;
    }
    
    public void crearAsociacion(String puntosGanados, String puntosRedimir, String valorProducto, Catalogoo catalogo, Productoss productos){
        asociaciones ap=null;
        
        int ptGana=0;
        int ptRed=0;
        int valProd=0;
        try{
            ptGana=Integer.parseInt(puntosGanados);
            ptRed=Integer.parseInt(puntosRedimir);
            valProd=Integer.parseInt(valorProducto);
        }catch(Exception e){
            
        }
        if(valorProducto.equals("") || puntosGanados.equals("") || puntosRedimir.equals("")){
            JOptionPane.showMessageDialog(null, "todos los campos son obligatorios llenarlos");
        }else{
            for(asociaciones aPC:listAsociacion){
                if(aPC.getProductos().equals(productos) && aPC.getCatalogo().equals(catalogo)){
                    ap=aPC;
                }
            }
            if(ap!=null){
                JOptionPane.showMessageDialog(null, "Este asociacion catalogo producto ya fue realizada");
            }else{
                listAsociacion.add(new asociaciones(ptGana, ptRed, valProd, catalogo, productos));
            }
        }
    }
    public void eliminarAsociacion(Catalogoo catalog,Productoss produc){
        
        asociaciones aP=null;
            for(asociaciones aPC:listAsociacion){
                if(aPC.getProductos().equals(produc) && aPC.getCatalogo().equals(catalog)){
                    aP=aPC;
                }
            }
            if(aP!=null){
                listAsociacion.remove(aP);
            }   
    }
    
}
