/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renan
 */
public class kR




{


   // d is the number of characters in the input alphabet


   public final static int d = 256;


   


   /* pat -> pattern


       txt -> text


       q -> A prime number


   */


   static void search(String pat, String txt)


   {


       int q = 101; // A prime number


       int M = pat.length();


       int N = txt.length();


       int i, j;


       int p = 0; // hash value for pattern


       int t = 0; // hash value for txt


       int h = 1; 


   


       // The value of h would be "pow(d, M-1)%q"


       for (i = 0; i < M-1; i++)


           h = (h*d)%q;


   


       // Calculate the hash value of pattern and first


       // window of text


       for (i = 0; i < M; i++)


       {


           p = (d*p + pat.charAt(i))%q;


           t = (d*t + txt.charAt(i))%q;


       }


   


       // Slide the pattern over text one by one


       for (i = 0; i <= N - M; i++)


       {


   


           // Check the hash values of current window of text


           // and pattern. If the hash values match then only


           // check for characters one by one


           if ( p == t )


           {


               /* Check for characters one by one */


               for (j = 0; j < M; j++)


               {


                   if (txt.charAt(i+j) != pat.charAt(j))


                       break;


               }


   


               // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]


               if (j == M)


                   System.out.println("Pattern found at index " + i);


           }


   


           // Calculate hash value for next window of text: Remove


           // leading digit, add trailing digit


           if ( i < N-M )


           {


               t = (d*(t - txt.charAt(i)*h) + txt.charAt(i+M))%q;


   


               // We might get negative value of t, converting it


               // to positive


               if (t < 0)


               t = (t + q);


           }


       }


   }


   


   /* Driver program to test above function */


   public static void main(String[] args)


   {
     String content="";
       try {
           content = new String(Files.readAllBytes(Paths.get("Ingresar ruta local archivo .txt a leer")));
      } catch (IOException ex) {
           Logger.getLogger(BM.class.getName()).log(Level.SEVERE, null, ex);
       } 
       
       long TInicio, TFin, tiempo; 
       TInicio = System.currentTimeMillis();


       String txt = content ;


       String pat = "Ingresar texto a buscar dentro del archivo .txt";


       search(pat, txt);
       TFin = System.currentTimeMillis(); 
       tiempo = TFin - TInicio; 
       System.out.println("Tiempo des ejecución en milisegundos: " + tiempo); 

   }
//Busca el inicio de los patrones.

}

