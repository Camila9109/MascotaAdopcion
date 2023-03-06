
package beans;


public class Mascotas {
    
    private int id_mascota;
    private String nombre_mascota;
    private String tipo;
    private int edad;
    private String sexo;
    private String raza;
    private String novedad;

    public Mascotas(int id_mascota, String nombre_mascota, String tipo, int edad, String sexo, String raza, String novedad) {
        this.id_mascota = id_mascota;
        this.nombre_mascota = nombre_mascota;
        this.tipo = tipo;
        this.edad = edad;
        this.sexo = sexo;
        this.raza = raza;
        this.novedad = novedad;
    }

    public int getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(int id_mascota) {
        this.id_mascota = id_mascota;
    }

    public String getNombre_mascota() {
        return nombre_mascota;
    }

    public void setNombre_mascota(String nombre_mascota) {
        this.nombre_mascota = nombre_mascota;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getNovedad() {
        return novedad;
    }

    public void setNovedad(String novedad) {
        this.novedad = novedad;
    }

    @Override
    public String toString() {
        return "Mascotas{" + "id_mascota=" + id_mascota + ", nombre_mascota=" + nombre_mascota + ", tipo=" + tipo + ", edad=" + edad + ", sexo=" + sexo + ", raza=" + raza + ", novedad=" + novedad + '}';
    }
    
    
}
