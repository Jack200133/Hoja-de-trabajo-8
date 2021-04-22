import java.io.File;
import java.util.Scanner;

public class Modelo {
    VectorHeap vh = new VectorHeap();
    VectorHeapSegunda vhs = new VectorHeapSegunda();
    public void agregar(){
        try {
            File myObj = new File("pacientes.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] temp = data.split(",");
                Pacientes pt = new Pacientes(temp[2],temp[1],temp[0]);
                vh.add(pt);
                vhs.add(pt);
            }
            myReader.close();
        }catch (Exception e) {
            System.out.println("Archivo no encontrado");
            e.printStackTrace();
        }

        for (int i = 0; i < vh.size();) {
            System.out.println(vh.remove());
        }

        System.out.println("------------------------IMPLEMENTACION DEL JAVACOLLECTION---------------------");
        for (int i = 0; i < vhs.size();) {
            System.out.println(vhs.remove());
        }

    }
}
