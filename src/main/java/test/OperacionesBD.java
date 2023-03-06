package test;

import beans.Mascotas;
import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OperacionesBD {
   
    public static void main(String[] args) {
       //actualizarMascota(1,"Dalmata");
       listarMascota(); 
       
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

public static void listarMascota(){
 DBConnection con =new DBConnection();
 String sql="SELECT * FROM mascota";
 try{
     Statement st=con.getConnection().createStatement();
     ResultSet rs = st.executeQuery(sql);
     while(rs.next()){
        int id_mascota = rs.getInt("id_mascota");
        String nombre_mascota=rs.getString("nombre_mascota");
        String tipo=rs.getString("tipo");
        int edad=rs.getInt("edad");
        String sexo=rs.getString("sexo");
        String raza=rs.getString("raza");
        String novedad = rs.getString("novedad");
     
     Mascotas mascotas = new Mascotas(id_mascota,nombre_mascota,tipo,edad,sexo,raza,novedad);
         System.out.println(mascotas.toString());
     }
 }catch(Exception ex){
     System.out.println(ex.getMessage());
 }
 finally{
     con.desconectar();
 }
 
 }    
    
}


