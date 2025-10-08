import java.util.Scanner;

public class ejercicio3 {
    //Hacer un array que contenga 5 números . Realiza un programa que te muestre por pantalla solo el más pequeño de ellos.
    public static void main(String[] args ){

        Scanner sc = new Scanner(System.in);
        int[] numeros = new int [5];
        
        //Pedir al usuario los 5 números 
        for (int i=0; i<5; i++){
            System.out.println("introduce el numero "+ (i+1) + ":");
            numeros[i]= sc.nextInt();
            
        }
        //Pensaremos que el primer número es el más pequeño
        int menor = numeros [0];
        //Recorremos el arrays para encontar el menos
        for(int i=1; i< numeros.length; i++){
            if (numeros[i]<menor){
                menor = numeros [i];

            }
        }

        //Mostrar el número más pequeño
        System.out.println("el numero mas pequeño es :" + menor);
        

    }
    
}
