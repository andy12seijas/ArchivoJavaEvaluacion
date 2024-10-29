import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidacionTry {
    public static int Opciones(int r) {
        Scanner scanner = new Scanner(System.in);
        while (r <= 0) {
            try {
                System.out.println("Elige una opción:");
                r = (int) ValidadorEntrada.validarOpciones(scanner.nextInt());
                scanner.nextLine();
            } catch (OpcionInvalidadException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Error: debes ingresar un número entero.");
                scanner.nextLine();
            } catch (NumberFormatException e) {
                System.out.println("Error: debes ingresar un número válido.");
                scanner.nextLine();
            }
        }
        return r;
    }
    public static int ValidadorEdad(int edad){
        Scanner scanner = new Scanner(System.in);
        while (edad <= 0) {
            System.out.print("Ingrese su edad: ");
            try {
                edad = ValidadorEntrada.validarEdad(scanner.nextInt());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Debes ingresar un numero");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Error no controlado");
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }
        return edad;
    }
    public static String Letras(String input,String campo){
        Scanner scanner = new Scanner(System.in);
        while (input == null){
           System.out.print("Ingrese el "+campo+":");
            try {

                input = ValidadorEntrada.validarLetras(scanner.nextLine());

            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            } catch (Exception e){
                System.out.println("Error no controlado");
                System.out.println(e.getMessage());
            }
        }
        return input;

    }
    public static float NumerosFLoat(float numero){
        Scanner scanner = new Scanner(System.in);
        while (numero <= 0) {
            System.out.print("Ingrese la nota: ");
            try {
                numero = ValidadorEntrada.validarNota(scanner.nextFloat());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("El decimal debe identificarse con una coma (,)");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Error no controlado");
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }
        return numero;
    }
    public  static  int opciones2(int opcion){
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Qué desea actualizar? \n1.Nombre\n2.Apellido \n3.Edad \n4.Nota\n5.Todas\n6.Cancelar");
        while(opcion<=0){
            try {
                System.out.println("Elige una opcion:");
                opcion= (int) ValidadorEntrada.validarOpciones2(scanner.nextInt());
            }catch (OpcionInvalidadException e){
                System.out.println(e.getMessage());
            }catch (InputMismatchException e){
                System.out.println("Error no encontrado");
                scanner.nextLine();
            }catch (NumberFormatException e){
                System.out.println("Error no encontrado");
                scanner.nextLine();
            }
        }
        return opcion;
    }
}
