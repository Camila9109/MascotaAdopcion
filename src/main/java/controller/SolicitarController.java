package controller;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import com.google.gson.Gson;

import beans.Adopcion;
import connection.DBConnection;

public class SolicitarController implements ISolicitarController {

    @Override
    public String listarSolicitudes(String username) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();

        String sql = "Select l.id_mascota, l.nombre_mascota, l.tipo, l.edad, l.sexo, l.raza, l.novedad, a.fecha from mascota l "
                + "inner join adopcion a on l.id_mascota = a.id_mascota inner join usuario u on a.username = u.username "
                + "where a.username = '" + username + "'";

        List<String> solicitudes = new ArrayList<String>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id_mascota = rs.getInt("id_mascota");
                Date fechaSolicitud = rs.getDate("fecha");
                String novedad = rs.getString("novedad");
                String raza = rs.getString("raza");
                
                

                Adopcion adopcion = new Adopcion(id_mascota, username, fechaSolicitud, novedad,raza);

                solicitudes.add(gson.toJson(adopcion));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return gson.toJson(solicitudes);
    }
}
