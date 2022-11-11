
package examen1p1_rodrigovasquez;

import java.util.Scanner; 

public class Examen1P1_RodrigoVasquez {

    public static void main(String[] args) {
        menu(); 
    }
    
    public static void menu(){
        Scanner rabbitSeason = new Scanner(System.in);
        int choice = 0; 
        do{
            System.out.print("1. Conjuntos\n2. Cifrado\n3. Sobre\n4. Salida\nIngrese que ejercio ejecutar: ");
            choice = rabbitSeason.nextInt(); 
            switch(choice){
                case 1:
                    conjuntos(); 
                    break; 
                case 2: 
                    System.out.print("Ingrese una cadena: ");
                    String cadena1 = rabbitSeason.next(); 
                    String cadena = cadena1.toLowerCase();
                    System.out.println(cifrado(cadena));
                    break; 
                case 3: 
                    System.out.print("Ingrese n: ");
                    int numSobre = rabbitSeason.nextInt(); 
                    if(numSobre%2==0&&numSobre>0){
                        System.out.print("Ingrese el contorno: ");
                        String substitute = rabbitSeason.next(); 
                        char contornoSobre = substitute.charAt(0); 
                        sobre(numSobre, contornoSobre);
                    }else{
                        System.out.println("El número tiene que ser positivo y par");   
                    }
                    break; 
                case 4: 
                    break; 
            }
        }while(choice!=4);
    }
    
    public static void conjuntos(){
        Scanner yeehawCowboy = new Scanner(System.in);
        System.out.print("Ingrese el primer conjunto: ");
        String conjunto1 = yeehawCowboy.nextLine(); 
        System.out.print("Ingrese el segundo conjunto: ");
        String conjunto2 = yeehawCowboy.nextLine();  
    }
    
    public static String cifrado(String cadena){
        int length = cadena.length();
        String acumCifrado = ""; 
        boolean flag = true; 
        for (int j = 0; j < length; j++) {
            int casteo = (int)cadena.charAt(j);
            if((casteo<97)||(casteo>122)){
                flag = false; 
            }
        }
        if(flag){
            for (int i = 0; i < length; i++) {
                int casteo = (int)cadena.charAt(i);
                if(casteo<110&&casteo>96){
                    int posicion1 = casteo - 97; 
                    int caracterInt = casteo + (25 - (2 * posicion1));
                    char nuevoChar = (char)caracterInt; 
                    acumCifrado += nuevoChar; 
                }else if(casteo>109&&casteo<123){
                    int posicion2 = 122 - casteo; 
                    int caracterInt = casteo - (25 - (2 * posicion2)); 
                    char nuevoChar = (char)caracterInt; 
                    acumCifrado += nuevoChar; 
                }
            }
        }else{
            System.out.println("No se permiten caracteres especiales");
        }
        return acumCifrado;
    }
    
    public static void sobre(int numSobre, char contornoSobre){
        int tamaño = (numSobre * 2) +  1;
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                if(i==0||i==tamaño-1){
                    System.out.print(contornoSobre);
                }else if((j==0||j==tamaño-1||j==i||j+i==tamaño-1)&&i<=numSobre){
                    System.out.print(contornoSobre);
                }else if(i>numSobre&&(j==0||j==tamaño-1)){
                    System.out.print(contornoSobre);
                }   else{
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }
}
