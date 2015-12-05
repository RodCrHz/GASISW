package GUI;


import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rodrigo
 */
public class PantallaGASISW extends javax.swing.JFrame {
   public String tipoGAS = null;
   
    Timer timer = new Timer(); // El timer que se encarga de administrar los tiempo de repeticion
	public int segundos; // manejar el valor del contador
	public boolean frozen; // manejar el estado del contador TIMER AUTOMATICO -- True Detenido | False Corriendo
 
	// clase interna que representa una tarea, se puede crear varias tareas y asignarle al timer luego
	class panico extends TimerTask {
		public void run() {
			segundos++;
			System.out.println(segundos);
			// aqui se puede escribir el codigo de la tarea que necesitamos ejecutar
                        
                        if(segundos<5){
                            btnPanico.setEnabled(false);
                            btnServir.setEnabled(false);
                        }else{
                            btnPanico.setEnabled(true);
                            btnServir.setEnabled(true);
                            
                        }
                            
                        
                                                    
		}// end run()
	}// end SincronizacionAutomatica
        
        class estacion extends TimerTask {
		public void run() {
			segundos++;
			System.out.println(segundos);
			// aqui se puede escribir el codigo de la tarea que necesitamos ejecutar
         
                       
        if (cmbEstacion.getSelectedItem()=="Estacion 1"){
           
            cmbEstacion.removeItem("Estacion 1");
            
        }else if (cmbEstacion.getSelectedItem()=="Estacion 2"){
            
            cmbEstacion.removeItem("Estacion 2");
        }                  
                            
                        
                                                    
		}// end run()
	}// end SincronizacionAutomatica
 
	public void Start(int pSeg) throws Exception {
		frozen = false;
		// le asignamos una tarea al timer
		timer.schedule(new panico(), 0, pSeg * 1000);
	}// end Start
        
        public void StartGAS(int pSeg) throws Exception {
		frozen = false;
		// le asignamos una tarea al timer
		timer.schedule(new estacion(), 0, pSeg * 1000);
	}// end Start
 
	public void Stop() {
		System.out.println("Stop");
		frozen = true;
	}// end Stop
 
    public void Reset() {
		System.out.println("Reset");
		frozen = true;
		segundos = 0;
	}// end Reset
    
    public void llenarGal(){
        
         String dolares = txtDolares.getText();

        if (optRegular.isSelected()==true){
            tipoGAS = "2.20";
        }else if (optDiesel.isSelected()==true){
            tipoGAS = "2.10";
        }else{
            tipoGAS = "2.30";
        }

        double calculo = Double.parseDouble(dolares)/Double.parseDouble(tipoGAS);

        txtGalones.setText(String.valueOf(calculo));
        
        }
      public void llenarDol(){
        
         String galones = txtGalones.getText();

        if (optRegular.isSelected()==true){
            tipoGAS = "2.20";
        }else if (optDiesel.isSelected()==true){
            tipoGAS = "2.10";
        }else{
            tipoGAS = "2.30";
        }

        double calculo = Double.parseDouble(galones)*Double.parseDouble(tipoGAS);

        txtDolares.setText(String.valueOf(calculo));
        
        }
    
    //Variables de conexión
  /*  private OutputStream output=null;
    SerialPort serialPort;
    private final String PUERTO="COM3";
    
    private static final int TIMEOUT=2000; //Milisegundos
    
    private static final int DATA_RATE=115200; */
    
    
    public PantallaGASISW() {
        initComponents();
       // inicializarConexion();
            }
    
  /*  public void inicializarConexion(){
        CommPortIdentifier puertoID=null;
        Enumeration puertoEnum=CommPortIdentifier.getPortIdentifiers();
        
        while(puertoEnum.hasMoreElements()){
            CommPortIdentifier actualPuertoID=(CommPortIdentifier) puertoEnum.nextElement();
            if(PUERTO.equals(actualPuertoID.getName())){
                puertoID=actualPuertoID;
                break;
            }
        }
        
        if(puertoID==null){
            mostrarError("No se puede conectar al puerto");
            System.exit(ERROR);
        }
        
        try{
            serialPort = (SerialPort) puertoID.open(this.getClass().getName(), TIMEOUT);
            //Parámetros puerto serie
            
            serialPort.setSerialPortParams(DATA_RATE, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            
            output = serialPort.getOutputStream();
        } catch(Exception e){
            mostrarError(e.getMessage());
            System.exit(ERROR);
            
        }
    } 
    
    private void enviarDatos(String datos){
        try{
            output.write(datos.getBytes());
        } catch(Exception e){
            mostrarError("ERROR");
            System.exit(ERROR);
        }
    }    
    
    public void mostrarError(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    
    */
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        cmbEstacion = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        optRegular = new javax.swing.JRadioButton();
        optEspecial = new javax.swing.JRadioButton();
        optDiesel = new javax.swing.JRadioButton();
        btnServir = new javax.swing.JButton();
        btnPanico = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtDolares = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtGalones = new javax.swing.JTextField();
        btnval = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Seleccione la Estacion:");

        cmbEstacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Estacion 1", "Estacion 2" }));

        jLabel2.setText("Tipo de Gasolina");

        buttonGroup1.add(optRegular);
        optRegular.setText("Regular");
        optRegular.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                optRegularFocusGained(evt);
            }
        });
        optRegular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optRegularActionPerformed(evt);
            }
        });

        buttonGroup1.add(optEspecial);
        optEspecial.setText("Especial");
        optEspecial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optEspecialActionPerformed(evt);
            }
        });

        buttonGroup1.add(optDiesel);
        optDiesel.setText("Diesel");
        optDiesel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optDieselActionPerformed(evt);
            }
        });

        btnServir.setText("Servir");
        btnServir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServirActionPerformed(evt);
            }
        });

        btnPanico.setText("Panico");
        btnPanico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPanicoActionPerformed(evt);
            }
        });

        jLabel4.setText("Cantidad en Dolares");

        txtDolares.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDolaresFocusLost(evt);
            }
        });
        txtDolares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDolaresActionPerformed(evt);
            }
        });
        txtDolares.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDolaresKeyReleased(evt);
            }
        });

        jLabel3.setText("Cantidad en Galones");

        txtGalones.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtGalonesFocusLost(evt);
            }
        });
        txtGalones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGalonesKeyReleased(evt);
            }
        });

        btnval.setText("valores");
        btnval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(optDiesel)
                            .addComponent(optRegular)
                            .addComponent(cmbEstacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(optEspecial))
                        .addContainerGap(145, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGalones)
                                    .addComponent(txtDolares)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPanico)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnServir)))
                        .addGap(50, 50, 50))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnval)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnval)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbEstacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(optRegular))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(optDiesel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(optEspecial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDolares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtGalones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnServir)
                    .addComponent(btnPanico))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnServirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServirActionPerformed
        // TODO add your handling code here:
                String estacion;
        
        String Galones;
        
        if (cmbEstacion.getSelectedItem()=="Estacion 1"){
            estacion ="1";
        }else{
            estacion ="2";
        }
        
      //JOptionPane.showMessageDialog(null, estacion);
        
        if (optRegular.isSelected()==true){
            tipoGAS = "R";
        }else if (optDiesel.isSelected()==true){
            tipoGAS = "D";
        }else if ((optEspecial.isSelected()==true)&&(estacion.equals("1"))){
            tipoGAS = "P";
        }else if ((optEspecial.isSelected()==true)&&(estacion.equals("2"))){
            JOptionPane.showMessageDialog(null, "Especial no disponible en bomba 2");
        }else{
            JOptionPane.showMessageDialog(null, "Por favor, elija un tipo de combustible");
            
        }
    
        Galones = txtGalones.getText();
        
               
       //JOptionPane.showMessageDialog(null,estacion+tipoGAS+Galones); 
        String cadena =estacion+"\n"+tipoGAS+"\n"+Galones+"\n";
        //enviarDatos(cadena);
        double tiempogalD = Double.parseDouble(Galones); 
        int tiempogalI = (int)tiempogalD;
        
       try {
           StartGAS(tiempogalI);
       } catch (Exception ex) {
           Logger.getLogger(PantallaGASISW.class.getName()).log(Level.SEVERE, null, ex);
       }

        
        
    }//GEN-LAST:event_btnServirActionPerformed

    private void btnPanicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPanicoActionPerformed
        // TODO add your handling code here:
        //enviarDatos("x"); 
        try {
            // TODO add your handling code here:
            Start(5);
            Reset();
            
        } catch (Exception ex) {
            Logger.getLogger(PantallaGASISW.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnPanicoActionPerformed

    private void txtDolaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDolaresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDolaresActionPerformed

    private void txtDolaresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDolaresKeyReleased
        // TODO add your handling code here:
        llenarGal();
        
    }//GEN-LAST:event_txtDolaresKeyReleased

    private void btnvalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvalActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnvalActionPerformed

    private void optRegularFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_optRegularFocusGained
        // TODO add your handling code here:
        
    }//GEN-LAST:event_optRegularFocusGained

    private void optRegularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optRegularActionPerformed
        // TODO add your handling code here:
        //llenarGal();
        //llenarDol();
    }//GEN-LAST:event_optRegularActionPerformed

    private void optDieselActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optDieselActionPerformed
        // TODO add your handling code here:
       // llenarGal();
       // llenarDol();
    }//GEN-LAST:event_optDieselActionPerformed

    private void optEspecialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optEspecialActionPerformed
        // TODO add your handling code here:
       // llenarGal();
       // llenarDol();
    }//GEN-LAST:event_optEspecialActionPerformed

    private void txtGalonesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGalonesKeyReleased
        // TODO add your handling code here:
        llenarDol();
    }//GEN-LAST:event_txtGalonesKeyReleased

    private void txtDolaresFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDolaresFocusLost
        // TODO add your handling code here:
        llenarGal();
    }//GEN-LAST:event_txtDolaresFocusLost

    private void txtGalonesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGalonesFocusLost
        // TODO add your handling code here:
        llenarDol();
    }//GEN-LAST:event_txtGalonesFocusLost

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaGASISW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaGASISW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaGASISW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaGASISW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaGASISW().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPanico;
    private javax.swing.JButton btnServir;
    private javax.swing.JButton btnval;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JComboBox cmbEstacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton optDiesel;
    private javax.swing.JRadioButton optEspecial;
    private javax.swing.JRadioButton optRegular;
    private javax.swing.JTextField txtDolares;
    private javax.swing.JTextField txtGalones;
    // End of variables declaration//GEN-END:variables
}
