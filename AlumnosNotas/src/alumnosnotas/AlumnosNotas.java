
package alumnosnotas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class AlumnosNotas {

    
    public static void main(String[] args) throws IOException {
        
       //Utilizamos las clases FileReader, BufferedReader,
       //FileWriter y BufferedWriter para lectura y escritura, respectivamente

        FileReader lector = null; 
        BufferedReader lectura = null;
        FileWriter escritor = null;
        BufferedWriter escritura = null;
        
        try {
             lector = new FileReader("alumnosNotas.txt");
             lectura=new BufferedReader(lector);
             escritor=new FileWriter("Medias.txt");
             escritura=new BufferedWriter(escritor);
             String texto;
             
             
             while ((texto=lectura.readLine()) !=null) {
                 //mientras que se lea una línea
                 
                     String [] notas =texto.split(":");
                     //esto divide cada línea y la guarda en un array de String de longitud 3
                
                     String nombre=notas[0]; //la posición cero del array es el nombre
                     int nota1=Integer.parseInt(notas[1]); //la posición 1 es la primera nota
                     int nota2=Integer.parseInt(notas[2]); //la posición 2 es la segunda nota
                     int nota3=Integer.parseInt(notas[3]); //la posición 3 es la tercera nota
                     int suma=nota1+nota2+nota3;
                     double media=((double)suma)/3; //hacemos el cast
                 
                     String linea="La nota media de "+nombre+" es "+media;
                     escritura.write(linea+"\n"); //introducimos la linea en el archivo de Medias.txt
                     
                 
                     System.out.println(linea);
                 
                 
             }
             
             System.out.println("\n¡El archivo con las notas medias se ha generado de manera exitosa!");
             
             
        }catch (FileNotFoundException e) {
            System.out.println("Error, no se ha encontrado el archivo "+e.getMessage());
            
             
        }catch (IOException e) {
                System.out.println("Error, "+e.getMessage());
                
                
                
               
                
                
                
                } finally {
                      if (lectura !=null && escritura !=null) { //si el BufferedWriter y el BufferedReader
                          //no son null
                       lectura.close(); //cerramos el BufferedReader
                       escritura.close();//cerramoos el BufferedWriter
            }
        }
                
    
    
        
    
} 
}
