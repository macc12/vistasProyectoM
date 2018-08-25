package DAOMock;

/**
 *
 * @author Marco
 */
public class Usuario {
    String nombre;
    String pass;
    String tipo;

    public Usuario(String nombre, String pass, String tipo) {
        this.nombre = nombre;
        this.pass = pass;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
