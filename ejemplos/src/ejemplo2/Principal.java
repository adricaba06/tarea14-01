package ejemplo2;

import java.io.File;

public class Principal {
    public static void main(String[] args) {
        File[] lista = File.listRoots(); // array de ficheros

        for (File root : lista){
            System.out.println(root.getAbsoluteFile());
        }

    }
}
