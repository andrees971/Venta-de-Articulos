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
public class Clientess {
    
    //estos son los atributos de la clase
    int NumeroDeIdentificacion;
    String PrimerNombre;
    String SegundoNombe;
    String PrimerApellido;
    String SegundoApellido;
    int Contraseña;
    int NumeroTelefonico;
//esta es el contructor del cual esta recibiendo de prametros todos los atributos de la clase, para poder ingresar la informacion.
    public Clientess(int NumeroDeIdentificacion, String PrimerNombre, String SegundoNombe, String PrimerApellido, String SegundoApellido, int Contraseña, int NumeroTelefonico) {
        this.NumeroDeIdentificacion = NumeroDeIdentificacion;
        this.PrimerNombre = PrimerNombre;
        this.SegundoNombe = SegundoNombe;
        this.PrimerApellido = PrimerApellido;
        this.SegundoApellido = SegundoApellido;
        this.Contraseña = Contraseña;
        this.NumeroTelefonico = NumeroTelefonico;
    }
//este es otro constructo de la clase, y es para no llamar en otras clase el anterior con todos los atributos.
    public Clientess() {
    }
    
    
//estos son los get y los set de cada atributo, con los get puedes llamr la informacion que se encuentre en ese atributo, y con el set puede modificarla
    public int getNumeroDeIdentificacion() {
        return NumeroDeIdentificacion;
    }

    public void setNumeroDeIdentificacion(int NumeroDeIdentificacion) {
        this.NumeroDeIdentificacion = NumeroDeIdentificacion;
    }

    public String getPrimerNombre() {
        return PrimerNombre;
    }

    public void setPrimerNombre(String PrimerNombre) {
        this.PrimerNombre = PrimerNombre;
    }

    public String getSegundoNombe() {
        return SegundoNombe;
    }

    public void setSegundoNombe(String SegundoNombe) {
        this.SegundoNombe = SegundoNombe;
    }

    public String getPrimerApellido() {
        return PrimerApellido;
    }

    public void setPrimerApellido(String PrimerApellido) {
        this.PrimerApellido = PrimerApellido;
    }

    public String getSegundoApellido() {
        return SegundoApellido;
    }

    public void setSegundoApellido(String SegundoApellido) {
        this.SegundoApellido = SegundoApellido;
    }

    public int getContraseña() {
        return Contraseña;
    }

    public void setContraseña(int Contraseña) {
        this.Contraseña = Contraseña;
    }

    public int getNumeroTelefonico() {
        return NumeroTelefonico;
    }

    public void setNumeroTelefonico(int NumeroTelefonico) {
        this.NumeroTelefonico = NumeroTelefonico;
    }
    
    //aqui estamos creando un arraylist, para depues poder almacenar informacion en ella.
    ArrayList<Clientess> ListaClienteses= new ArrayList();
    //este metodo de getlista es para poder retornar la informacion que estoy guardando en el arraylist
     public ArrayList<Clientess> getListaDeClientes(){
        return ListaClienteses;
     }
     
     //este es el metodo crear el cual tiene de parametros todos los atributos de la clase, dado que por hay es donde va ingresar la informacion que s eva digitar por teclado
     public void IngresarClientes(int NumeroDeIdentificacion, String PrimerNombre,String SegundoNombree, String PrimerApellido, String SegundoApellido, int Contraseña, int NumeroTelefonico){
         
         Clientess Cc=null;//se crea una varable de tipo clientes que comienze en null.
         for(Clientess cl:ListaClienteses){ //este for recorre el arraylist y va almacenando cada posicion de la informacion en la variable cl de tipo cliente
             if(cl.getNumeroDeIdentificacion() == NumeroDeIdentificacion){ //esta condicion dice, que si al estar recorriendo el array en la posicion cl con lo que tenga almacenado en identificacion es igual a lo que yo estoy digitando por teclado
             Cc=cl;//entonces si lo anterior es cierto el va almacenar toda la informacion de la clace en la posicion que este en el arraylist en Cc la cual estaba en null y ya no.
             }
         }if(Cc!=null){//en esta condicion dice que si Cc es distinto de null lo cual va depender de la condicion de arriba
             JOptionPane.showMessageDialog(null, "Ese cliente ya fue ingresado");//entonces va imprimir el mensaje que ese cliente esta registrado
         }else{//este else esque si no se cumple lo anterior
             ListaClienteses.add(new Clientess(NumeroDeIdentificacion,PrimerNombre, SegundoNombree, PrimerApellido, SegundoApellido, Contraseña, NumeroTelefonico));
         //el va llamar el arraylist va usar la funcion add que es agregar y lo qeu va agregar es toda la informacion que se estan pasando por los parametros de arriba por medio del constructor, por lo tanto en ese moneto todos los get de la clase van a tener la informacion digitada.
         }
     }
     
     //este seria el metodo de consultar el cual tiene un solo parametro tipo string, y ademas la clase va retorna algo de tipo entero
      public int Consultar(String Counsulta){
          // aqui igual que la anterior tenemos una variable tipo clientes que comienza en null para hacer el mismo procedimiento de arriba de si ya existe o no la informacion digitada
         Clientess Cc=null;
         //estas varible es para guardar la informacion en caso de que se encuentre algo
         int Resultado=0;
         //esta es par ahacer la conversion del string del parametro en entero dado, que vamos a buscar si la informacion digitada es igual a una identificacion antes ya ingresada, y dado que la id es entero se debe hacer la conversion
         //el try catch se hae para evitar que errores en conversion paren la ejecucion del codigo
         int cons=0;
         try{
             cons=Integer.parseInt(Counsulta);
         }catch (NumberFormatException e){
             
         }
         
         for(Clientess cl:ListaClienteses){//entonces el for igual vuelve a recorrer el arraylis el cual esta almacneando la informacion y va trayendo posision por posicion y la guarda en cl
             //entonces la condicion lo que hace es verificar si lo que estamos pasando por el prametro de consultar es igual a la informacion de numero de id los nombres en la posisicion que este actualmente el arraylist
             //recordar el arraylist hasta que halla traido el ultimo dato registrado en el arraylist
             if(cl.getNumeroDeIdentificacion()==cons || cl.getPrimerNombre().equals(Counsulta) || cl.getSegundoNombe().equals(Counsulta) || cl.getPrimerApellido().equals(Counsulta) || cl.getSegundoApellido().equals(Counsulta)){
             Cc=cl;
             }
             
         }if(Cc!=null){//entonces otraves la condicion de que si encontro algo va ser distinto de null
             Resultado=Cc.getNumeroDeIdentificacion();//y si es distinto de null en la variable resultado va guardar la identificacion, la cual estaba en la posicion que encontro los datos anteriores
         }
         return Resultado;//y este es el return lo que hace es retornar la variable que seria el id de tipo entero que se a almacenado si se encontro algo
         
     }
      
      //en modificacion lo que se hace es que se dan tres parametros, el numero de id es para buscar a la persona que se quiere midificar
      // y numero telefonico y contraseña va hacer la nueva informacion que se cambiar
      public void modificarCliente(int NumeroDeIdentificacion, int NumeroTelefonico, int contra){
        Clientess Cc=null;
            for(Clientess cl:ListaClienteses){
                if(cl.getNumeroDeIdentificacion()==NumeroDeIdentificacion){
                    Cc=cl;
                }
            }
            //aqui hace le mismo procedimiento de las anteriores, recorre el arraylis hasta qu eincuentre el id registrado o hasta que se acave la infromacion almacenada en el arraylist
           
            if(Cc!=null){//entonces si la encuentra. ya cc va ser distinto de null
                //y va a modificar en la posicion que la encontro la contraseña y el telefono

                Cc.setContraseña(contra);   
                Cc.setNumeroTelefonico(NumeroTelefonico);
            }
    }
      
      //eliminar hace lo mismo de las anteriores se le pasa un parametro para que haga la busquedad de lo que estoy buscando 
      public void eliminarCliente(int ClienteNumeroDeIdentificacion){
        
        Clientess cl=null;
            for(Clientess clie:ListaClienteses){
                if(clie.getNumeroDeIdentificacion()==(ClienteNumeroDeIdentificacion)){
                    cl=clie;
                }
            }
            if(cl!=null){
                //y si lo encuntra remueve en el arraylis esa posicion por lo tanto toda la informacion desaparece.
                ListaClienteses.remove(cl);
            }
        
    }
}


