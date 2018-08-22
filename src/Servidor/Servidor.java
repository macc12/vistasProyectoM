package Servidor;

import java.io.*;
import java.net.*;
import java.util.logging.*;
public class Servidor {
    public static void main(String args[]) throws IOException {
        ServerSocket ss;
        System.out.print("Inicializando servidor... ");
           
        try {
            ss = new ServerSocket(10578);
            System.out.println("\t[OK]");
            int idSession = 0;
            while (true) {
                Socket socket;
                socket = ss.accept();
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                 DataInputStream dis = new DataInputStream(socket.getInputStream());
                System.out.println("Nueva conexión entrante: "+socket);
 
              
                InputStream llegada = socket.getInputStream();
                      String path = "C:/Users/JHOHAN/Documents/NetBeansProject/socketsProyectoM/test1.txt";
                FileOutputStream destino = new FileOutputStream(path);
                byte[] buffer = new byte[1024];
                int len;
                while ((len = llegada.read(buffer)) > 0) {
                    destino.write(buffer, 0, len);
                }
                idSession++;
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
