public class ValidadorEntrada {
    //Validar sólo letras

    public static String validarLetras(String str) throws IllegalArgumentException {
        if (!str.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
            throw new IllegalArgumentException("Debe contener sólo letras . 😘👌");
        }

        return str;
    }

    public static int validarEdad(int edad) throws EdadInvalidaException {
        if (edad <= 0) {
            throw new EdadInvalidaException("La edad debe ser mayor que cero. 😁😁😁😁");
        }
        return edad;
    }

    public static float validarNota(float nota) throws IllegalArgumentException{
        if (nota <= 0 || nota > 20) {
            throw new IllegalArgumentException("Nota invalida. Rango: 1 - 20. 😉😉😉");
        }
        return nota;
    }
    public static  float validarOpciones(int r) throws  OpcionInvalidadException{
        if (r<=0 || r>6){
            throw new OpcionInvalidadException("La opcion no es correcta");
        }
        return r;
    }
    public static  float validarOpciones2(int opcion) throws  OpcionInvalidadException{
        if (opcion<=0 || opcion>6){
            throw new OpcionInvalidadException("La opcion no es correcta");
        }
        return opcion;
    }

}

