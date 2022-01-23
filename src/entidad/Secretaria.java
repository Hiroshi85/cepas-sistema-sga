
package entidad;

/**
 *
 * @author benja
 */
public class Secretaria extends Usuario{
    
    private String oficio;

    public Secretaria() {
        super();
    }

    public Secretaria(String dni, String password, String nombre, String apellido_p, String apellido_m, String sexo, int edad, String telefono, String fecha_nacimiento, String oficio) {
        super(dni, password, nombre, apellido_p, apellido_m, sexo, edad, telefono, fecha_nacimiento);
        this.oficio = oficio;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }
    
    
}
