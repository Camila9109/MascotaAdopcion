
package controller;

import java.util.Map;

public interface IUsuarioController {
    
    public String login(String username, String contrasena);
    
    public String register(String username, String contrasena, String nombre, String apellido, String direccion, String email, int telefono, String ciudad);
    
    public String pedir(String username);
    
    public String modificar(String username, String nuevaContrasena,
            String nuevoNombre, String nuevosApellido, String nuevaDireccion,
            String nuevoEmail, int nuevoTelefono, String nuevaCiudad);
    
    public String eliminar(String username);
}
