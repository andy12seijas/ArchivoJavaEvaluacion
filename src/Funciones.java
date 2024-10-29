import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Funciones {
    private static ArrayList<Persona> listaPar = new ArrayList<>();

    public static void  pausar() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();

    }
    public static void Deseralizar() {
        try (FileInputStream archivo = new FileInputStream("personas.bin")) {
            ObjectInputStream entrada = new ObjectInputStream(archivo);
            listaPar = (ArrayList<Persona>) entrada.readObject();
            entrada.close();

        } catch (IOException e) {
            System.out.println("No hay datos para cargar o ocurrió un error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada: " + e.getMessage());
        }
    }
    public static void Serializar() {
        try (FileOutputStream archivo = new FileOutputStream("personas.bin")) {
            ObjectOutputStream salida = new ObjectOutputStream(archivo);
            salida.writeObject(listaPar);

        } catch (IOException e) {
            System.out.println("Error al serializar: " + e.getMessage());
            e.printStackTrace(); // Imprime la traza de la excepción para obtener detalles
        }
    }

    public static void CrearReporte() throws IOException {
        if (listaPar.isEmpty()){
            System.out.println("No hay nadie agregado");
            pausar();

        }else {
            listaPar.forEach(System.out::println);

            int edad1 = 0;
            float nota1 = 0;
            System.out.println("Para crear un reporte debe indicar la edad y la nota de los alumnos:");
            int edad = ValidacionTry.ValidadorEdad(edad1);
            float nota = ValidacionTry.NumerosFLoat(nota1);
            String report = listaPar.stream().filter(e -> e.getNota() >= nota).filter(e -> e.getEdad() >= edad).toList().toString();
            if (report.equals("[]")) {
                System.out.println("No hay ninguna persona con las especificaciones que nos propocionaste ");
                pausar();
            } else {
                try (FileWriter fw = new FileWriter("reportes.txt")) {
                    fw.write(report + "\n");
                    System.out.println("Archivo guardado exitosamente");
                    pausar();
                }
            }
        }

    }
    public static void agregar(){
        int edad1=0;
        String input=null;
        float numero=0;
        String nombre=ValidacionTry.Letras(input,"nombre");
        String apellido=ValidacionTry.Letras(input,"apellido");
        int edad=ValidacionTry.ValidadorEdad(edad1);
        float  nota=ValidacionTry.NumerosFLoat(numero);

        listaPar.add(new Persona(nombre,apellido,edad,nota));
        Serializar();
    }
    public static void mostrar(){

        if (listaPar.isEmpty()){
            System.out.println("No hay nadie agregado");
            pausar();
        }else {
            listaPar.forEach(System.out::println);
            pausar();
        }
    }
    public static void eliminar(){

        if (listaPar.isEmpty()){
            System.out.println("No hay nadie agregado");
            pausar();

        }else {
            for (Persona par : listaPar) {
                System.out.println(par);
            }
            String input=null;
            String n=ValidacionTry.Letras(input,"nombre");
            for(int i = 0; i < listaPar.size(); i++){
                if (listaPar.get(i).nombre.equalsIgnoreCase(n)){
                    listaPar.remove(i);
                    System.out.println("La persona " + n + " ha sido eliminada.");
                    Serializar();
                    pausar();
                }



            }
        }
    }
    public static void actualizar(){
        Scanner scanner= new Scanner(System.in);
        if (listaPar.isEmpty()) {
            System.out.println("No hay nadie agregado");
            pausar();
        } else {

            for (Persona par : listaPar) {
                System.out.println(par);
            }
            String input=null;
            int edad1=0;
            String nombre_actualizar =ValidacionTry.Letras(input,"nombre de la persona que desea actualizar");
            boolean encontrado = false;
            for (int i = 0; i < listaPar.size(); i++) {
                Persona persona = listaPar.get(i);
                float numero=0;
                if (persona.nombre.equalsIgnoreCase(nombre_actualizar)) {
                    encontrado = true;
                    int opcion=0;
                    opcion=ValidacionTry.opciones2(opcion);
                    scanner.nextLine();
                    switch (opcion) {
                        case 1:
                            String nombre_new = ValidacionTry.Letras(input,"nombre");
                            persona.nombre = nombre_new;
                            Serializar();
                            pausar();
                            break;
                        case 2:
                            String apellido_new = ValidacionTry.Letras(input,"apellido");
                            persona.apellido = apellido_new;
                            Serializar();
                            pausar();
                            break;
                        case 3:
                            int edad_new=ValidacionTry.ValidadorEdad(edad1);
                            persona.edad=edad_new;
                            Serializar();
                            break;
                        case 4:
                            Float nota_new = ValidacionTry.NumerosFLoat(numero);
                            persona.nota = nota_new;
                            Serializar();
                            pausar();
                            break;
                        case 5:
                            nombre_new = ValidacionTry.Letras(input,"nombre");
                            apellido_new = ValidacionTry.Letras(input,"apellido");
                            edad_new=ValidacionTry.ValidadorEdad(edad1);
                            nota_new = ValidacionTry.NumerosFLoat(numero);
                            persona.nombre = nombre_new;
                            persona.apellido = apellido_new;
                            persona.edad=edad_new;
                            persona.nota = nota_new;
                            Serializar();
                            pausar();
                            break;
                        case 6:
                            System.out.println("Volviendo al menu...");
                            pausar();
                            break;
                        default:
                            System.out.println("Opción no válida.");
                    }
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("No existe esa persona.");
            }

        }
    }
    public static void buscar(){

        if (listaPar.isEmpty()){
            System.out.println("No hay nadie agregado");
            pausar();

        }else {
            String input=null;
            String nombre_buscar=ValidacionTry.Letras(input,"nombre de la persona que desea buscar:").toLowerCase();
            for(int i = 0; i < listaPar.size(); i++){
                Persona persona =listaPar.get(i);

                if (persona.nombre.toLowerCase().startsWith(nombre_buscar)) {
                    System.out.println("Nombre:" + persona.nombre);
                    System.out.println("Apellido:" + persona.apellido);
                    System.out.println("Nota:" + persona.nota + "\n----------------");
                }

            }
            pausar();
        }
    }
}
