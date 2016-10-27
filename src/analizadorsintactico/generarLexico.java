/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorsintactico;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author arturo
 */
public class generarLexico {

    /**
     * Muestra un menu para elegir la opcion
     * mas conveniente
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion = 3;
        java.util.Scanner in = new java.util.Scanner(System.in);
        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1) Generar");
            System.out.println("2) Salir");
            System.out.print("Opcion: ");
            opcion = in.nextInt();
            switch (opcion) {
                case 1: {
                    System.out.println("\n*** Generando ***\n");
                    String archLex = "";
                    if(args.length > 0){
                        System.out.println("\n*** Procesando archivo custom ***\n");
                        archLex = args[0];
                    }else{
                        System.out.println("\n*** Procesando archivo default ***\n");
                    
                        archLex= "alexicoparasintactico.flex";
                    }
                    String[] entrada = {archLex};
                    jflex.Main.main(entrada);
                    //Movemos el archivo generado al directorio src
                    File arch = new File("AnalizadorLexico.java");
                    if(arch.exists()){
                        System.out.println("" + arch);
                        Path currentRelativePath = Paths.get("");
                        String nuevoDir = currentRelativePath.toAbsolutePath().toString()
                                + File.separator + "src" + File.separator 
                                + "analizadorsintactico" + File.separator+arch.getName();
                        File archViejo = new File(nuevoDir);
                        archViejo.delete();
                        if(arch.renameTo(new File(nuevoDir))){
                            System.out.println("\n*** Generado ***\n");
                            System.out.println("\n*** Saliendo automaticamente ***\n");
                            System.exit(0);
                        }else{
                            System.out.println("\n*** No generado ***\n");
                        }
                    }else{
                        System.out.println("\n*** Codigo no existente ***\n");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Programa finalizado!\nVuelva pronto.");
                    break;
                }
                default: {
                    System.out.println("Opcion no valida.");
                    break;
                }
            }
        } while (opcion != 3);
    }

}
