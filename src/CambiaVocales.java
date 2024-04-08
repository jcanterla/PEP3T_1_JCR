import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class CambiaVocales {
    public static void main(String[] args) {
        System.out.println("\t\t\t\t\t\t\t\t\033[1;4mPROGRAMA CAMBIA VOCALES\033[0m\n");
        escrituraFichero();
        cambioVocales();
    }

    public static void escrituraFichero() {
        Scanner teclado = new Scanner(System.in);

        PrintWriter salida = null;
        try {
            salida = new PrintWriter("src/fichero.txt");
            String cadena;
            System.out.println("\033[1mIntroduzca el texto: \033[0m");
            int contador = 0;
            do {
                System.out.print("\t");
                cadena = teclado.nextLine();
                if(!cadena.equalsIgnoreCase("FIN")) {
                    if(cadena.length() > 80){
                        System.out.println("Excede el tamaño");
                        cadena = cadena.substring(0, 80);
                    }
                    salida.println(cadena);
                    contador++;
                }

            } while (!cadena.equalsIgnoreCase("FIN") && contador < 6);
            salida.flush();
            System.out.println("\n\t\t\t\t\t\033[1moo00 Las líneas se han escrito en el fichero 00oo\033[0m");
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } finally {
            salida.close();
        }
    }

    public static void cambioVocales() {
        FileReader fr = null;
        System.out.println("\n\033[1mEl texto almacenado, una vez procesado:\033[0m");
        try{
            fr = new FileReader("src/fichero.txt");
            BufferedReader entrada = new BufferedReader(fr);
            String cadena = entrada.readLine();
            while (cadena != null){
                String cambio;
                cambio = cadena.replace('a', 'i')
                        .replace('e', 'o')
                        .replace('A', 'I')
                        .replace('E', 'O');
                System.out.println("\tEn el fichero -> " + cadena + " y en pantalla -> " + cambio);
                cadena = entrada.readLine();
            }
        }catch (FileNotFoundException fnfe){
            System.out.println(fnfe.getMessage());
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        } finally {
            try {
                if(fr != null){
                    fr.close();
                }
            }catch (IOException ioe){
                System.out.println(ioe.getMessage());
            }
        }

        System.out.println("\n\t\t\t\t\t\033[1moo00 Se acabó el programa 00oo\033[0m");
    }
}




