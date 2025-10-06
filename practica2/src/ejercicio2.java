public class ejercicio2 {
    //Muestra por pantalla todos los elementos de un array de números enteros separados por un espacio.
    public static void main(String[] args){
        int[] numeros = {2,4,6,8,10,12, 14,16};

        //Mostrar todos los elementos separados por un espacio
        System.out.println("elementos del arrays:");
        for(int i = 0; i< numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }
         //Salto de linea al final
        System.out.println();

    }
}
