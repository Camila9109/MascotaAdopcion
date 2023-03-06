package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import beans.Mascotas;
import com.google.gson.Gson;
import connection.DBConnection;

public class MascotaController implements IMascotaController {

    @Override
    public String listar(boolean ordenar, String orden) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Select * from mascota";

        if (ordenar == true) {
            sql += " order by id_mascota " + orden;
        }

        List<String> mascota = new ArrayList<String>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                int id_mascota = rs.getInt("id_mascota");
                String nombre_mascota = rs.getString("nombre_mascota");
                String tipo = rs.getString("tipo");
                int edad = rs.getInt("edad");
                String sexo = rs.getString("sexo");
                String raza = rs.getString("raza");
                String novedad = rs.getString("novedad");

                Mascotas mascotas = new Mascotas(id_mascota, nombre_mascota, tipo, edad, sexo, raza, novedad);

                mascota.add(gson.toJson(mascotas));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return gson.toJson(mascota);

    }
}