// GestorUsuarios.java
import java.util.ArrayList;

public class GestorUsuarios {
    private ArrayList<Persona> listaUsuarios = new ArrayList<>();

    public void agregarUsuario(Persona p) {
        listaUsuarios.add(p);
    }

    public void eliminarUsuario(int id) {
        listaUsuarios.removeIf(p -> p.getId() == id);
    }

    public void editarUsuario(int id, String nuevoNombre, String nuevoCorreo) {
        for (Persona p : listaUsuarios) {
            if (p.getId() == id) {
                p.setNombre(nuevoNombre);
                p.setCorreo(nuevoCorreo);
                break;
            }
        }
    }

    public ArrayList<Persona> obtenerUsuarios() {
        return listaUsuarios;
    }

    public Persona buscarPorId(int id) {
        for (Persona p : listaUsuarios) {
            if (p.getId() == id) return p;
        }
        return null;
    }
}
