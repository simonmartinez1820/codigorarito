
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;
public class buscadorplacas
{
    public static void leerplacas(String n) throws java.io.IOException, FileNotFoundException  {
         String fileName = "HistorialOperaciones.txt";
    String line = null;
    String searchString=n;
    int acum =0;
     try {
      FileReader fileReader = new FileReader(fileName);
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      while ((line = bufferedReader.readLine()) != null) {
        if (line.contains(searchString)) {
          acum++;
        }
      }
      bufferedReader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("esta placa tiene "+acum+" denuncias.");
    }
}
