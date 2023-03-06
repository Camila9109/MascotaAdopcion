package beans;

import java.sql.Date;

public class Adopcion {
    
    private int id_mascota;
    private String username;
    private Date fecha;
    private String novedad;
    private String raza;

    public Adopcion(int id_mascota, String username, Date fecha, String novedad, String raza) {
        this.id_mascota = id_mascota;
        this.username = username;
        this.fecha = fecha;
        this.novedad = novedad;
        this.raza = raza;
    }

    public int getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(int id_mascota) {
        this.id_mascota = id_mascota;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String isNovedad() {
        return novedad;
    }

    public void setNovedad(String novedad) {
        this.novedad = novedad;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public String toString() {
        return "Adopcion{" + "id_mascota=" + id_mascota + ", username=" + username + ", fecha=" + fecha + ", novedad=" + novedad + ", raza=" + raza + '}';
    }
    
    
}
