import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import analizadorlex.*;
import analizadorsintactico.AnalizadorSintactico;

/**
 * El siguiente programa analiza cadenas almacenadas dentro de un archivo de texto
 * Equipo:
 * Manuel Alejandro Ceniceros Mercado
 * Misael Hernández Villareal
 * Francisco Félix Terrazas Zaffa
 * Mauricio Alejandro Martínez Pacheco
 */

public class GUI extends javax.swing.JFrame {
    //Declaración de atributos
    protected FileReader fichero = null;
    static String nombre;
    static File filein;
    File fileout;
    static FileReader filereader;

    public GUI() {
        initComponents();
        //Se abre un archivo creado con anterioridad
        directorio.setText(System.getProperty("user.dir") + File.separator + "analizar.txt");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        directorio = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        salida = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        salida1 = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AUTOMATA");

        jLabel4.setText("Archvo de cadenas");

        jButton1.setText("Abrir otro archivo...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        directorio.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        directorio.setText("directorio");

        salida.setEditable(false);
        salida.setColumns(20);
        salida.setRows(5);
        jScrollPane1.setViewportView(salida);

        jLabel6.setText("Tokens");

        jButton2.setText("Procesar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Limpiar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        salida1.setEditable(false);
        salida1.setColumns(20);
        salida1.setForeground(new java.awt.Color(255, 0, 0));
        salida1.setRows(5);
        salida1.setCaretColor(new java.awt.Color(255, 0, 0));
        jScrollPane2.setViewportView(salida1);

        jButton4.setText("Limpiar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel7.setText("Errores");

        jButton5.setText("GUARDAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(directorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(4, 4, 4)
                .addComponent(directorio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jButton3)
                    .addComponent(jLabel7)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Abrir componente JFileChooser para elegir un archivo en el equipo y poner la ruta en la interfaz
        JFileChooser chooser = new JFileChooser();
        JFrame frame=new JFrame();
        String directoriostring=""; 
        chooser.setDialogTitle("Abrir cadenas");
        chooser.setMultiSelectionEnabled(false);
        int sel = chooser.showOpenDialog(frame);
        if (sel == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            directoriostring=selectedFile.getAbsolutePath();
            directorio.setText(directoriostring);
        } 
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public void alexico(FileReader fichero) {
        //Creamos la instancia de la clase analizador (yylex)
        Analizador sampleLex = new Analizador(fichero);
        Yytoken token = null;
        String buff;
        boolean error=false;
        do {
            try {
        //como hemos renombrado el metodo en las directivas ahora es nextToken
                token = sampleLex.nextToken();
                if(sampleLex.getError()==true){
                    salida1.setForeground(Color.red);
                    salida1.setText("Analizador Léxico:\nError 1200: Token Inválido :"+token.toString()+"\n");
                    error=true;
                }
                
            } catch (java.io.IOException e) {
                
            }
            //Mientras no este vacio
            if (token != null) //Escribimos en consola
            {
                salida.setText(salida.getText()+token+"\n");
            }
        } while (token != null);
        if(error==false){
            salida1.setForeground(Color.blue);
            salida1.setText("Analizador Léxico: No hay errores\n");
        }
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Procesar cadenas del archivo
        try {
            filein = new File (directorio.getText());
            filereader = new FileReader(filein);
            alexico(filereader);
            AnalizadorSintactico sintactico= new AnalizadorSintactico(directorio.getText());
            if (sintactico.getError() == true) {
                salida1.setForeground(Color.red);
                salida1.append("Analizador Sintáctico: Error de sintaxis\n");
            }else{
                salida1.setForeground(Color.blue);
                salida1.append("Analizador Sintáctico: No hay errores\n");
            }
        } catch (FileNotFoundException ioe) {
            System.out.println(ioe);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Limpiar consola
        salida.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        salida1.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        //Guardar archivos de texto
        //Buffers de escritura
        FileWriter pw = null;
        FileWriter pw2 = null;
        try {
            //Dialogo para guardar los archivos
            JFileChooser chooser = new JFileChooser();
            JFrame frame = new JFrame();
            String directorioguardar = "";
            chooser.setDialogTitle("Guardar Resultados");
            chooser.setMultiSelectionEnabled(false);
            int sel = chooser.showSaveDialog(frame);
            if (sel == JFileChooser.APPROVE_OPTION) {
                File selectedFile = chooser.getSelectedFile();
                directorioguardar = selectedFile.getAbsolutePath();
            }
            //Se crea el buffer en el directorio elegido y se le agrega su extension a cada uno
            pw = new FileWriter(directorioguardar + ".txt");
            pw2 = new FileWriter(directorioguardar + "errores.txt");
            //Se escribe en el buffer el contenido de los JTextArea
            salida.write(pw);
            salida1.write(pw2);
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                //Se cierran los archivos si todo salió bien
                pw.close();
                pw2.close();
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel directorio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea salida;
    private javax.swing.JTextArea salida1;
    // End of variables declaration//GEN-END:variables
}
