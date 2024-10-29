import java.io.Serializable;

public  class Persona implements Serializable {
    String nombre;
    String apellido;
    int edad;
    Float nota;


    public Persona(String nombre, String apellido, int edad, Float nota) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.nota = nota;
    }

    @Override
        public String toString() {
            return "Nombre: " + nombre + "\nApellido:"+apellido+ "\nEdad:"+edad+"\nNota: " + nota+"\n------------\n";
        }
    public boolean esAprobado() {
        return this.nota >= 10;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }
}
