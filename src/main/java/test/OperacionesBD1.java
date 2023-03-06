package test;

import beans.Usuario;
import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OperacionesBD1 {
   
    public static void main(String[] args) {
       //actualizarMascota(1,"Dalmata");
       listarUser(); 
       
    }
    
 public static void actualizarMascota(int id_mascota, String raza){
 DBConnection con =new DBConnection();
 String sql="UPDATE Mascota SET raza ='" + raza +"'WHERE id_mascota="+ id_mascota;
 try{
     Statement st=con.getConnection().createStatement();
     st.executeUpdate(sql);
 
 }catch(Exception ex){
     System.out.println(ex.getMessage());
 }
 finally{
     con.desconectar();
 }
 
 }  

public static void listarUser(){
 DBConnection con =new DBConnection();
 String sql="SELECT * FROM usuario where username = 'joha' and contrasena = '4567'";
 try{
     Statement st=con.getConnection().createStatement();
     ResultSet rs = st.executeQuery(sql);
     while(rs.next()){
        String username = rs.getString("username");
        String contrasena=rs.getString("contrasena");
        String nombre=rs.getString("nombre");
        String apellido=rs.getString("apellido");
        String direccion=rs.getString("direccion");
        String email=rs.getString("email");
        int telefono=rs.getInt("telefono");
        String ciudad=rs.getString("ciudad");
     
     Usuario usuarios = new Usuario(username,contrasena,nombre,apellido,direccion,email,telefono,ciudad);
         System.out.println(usuarios.toString());
     }
 }catch(Exception ex){
     System.out.println(ex.getMessage());
 }
 finally{
     con.desconectar();
 }
 
 }    
    
}


