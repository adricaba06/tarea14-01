package ejemplo4vs2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        String nombre;
        String telefono;



        try{
            FileWriter flS = new FileWriter("Agenda.txt");
            BufferedWriter fs = new BufferedWriter(flS);
            do{
                System.out.println("Introduce el nombre: ");
                nombre = sc.nextLine();
                if(!nombre.isEmpty()){
                    System.out.println("Telefono:");
                    telefono = sc.nextLine();
                    fs.write(nombre + "," + telefono);
                    fs.newLine();

                }
            }while(!nombre.isEmpty());
        }catch (IOException | RuntimeException e){
            System.out.println("aaa");
        }
        finally{
            fs.close();
            System.out.println("Adio");
        }


    }
}
