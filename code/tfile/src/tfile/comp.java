/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tfile;

import java.io.File;

/**
 *
 * @author New
 */
public class comp extends javax.swing.JFrame {
    javax.swing.table.DefaultTableModel t1=new javax.swing.table.DefaultTableModel();
    public static File folder1;
    public static String fnm[]=new String[1000];
    public static float t[]=new float[group.no];
    public static float val[]=new float[group.no];
    /**
     * Creates new form comp
     */
    public comp() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 580));
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Result", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setText("Result");
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(130, 340, 97, 39);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(32, 110, 166, 197);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(240, 110, 166, 197);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("File Name");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(70, 70, 74, 22);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Similarity ");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(280, 70, 73, 22);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Result");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(500, 70, 45, 22);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane1.setViewportView(jTextArea3);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(440, 110, 166, 197);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 680, 490);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/collweb.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 710, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        jTable1.setModel(t1);
        String files1 = null;
//        int r=0;
//        t1.addColumn("File Name");
//        t1.addColumn("Similarity");
        File[] list1=group.folder1.listFiles();
//        int l=list1.length;
        for (int lf1 = 0; lf1 <list1.length; lf1++)
            {
                if (list1[lf1].isFile())
                {
                     files1 = list1[lf1].getName();
                }
                    jTextArea1.append(files1+"\n");
                    jTextArea2.append(Float.toString(reduce.t[lf1])+"\n");
                    if(reduce.t[lf1]>=.95 ){
                        jTextArea3.append("100% same\n");
                    }
                    else if(reduce.t[lf1]<=.94 && reduce.t[lf1]>.85){
                        jTextArea3.append("90% same\n");
                    }
                    else if(reduce.t[lf1]<=.84 && reduce.t[lf1]>.75){
                        jTextArea3.append("80% same\n");
                    }
                    else if(reduce.t[lf1]<=.74 && reduce.t[lf1]>.65){
                        jTextArea3.append("70% same\n");
                    }
                    else if(reduce.t[lf1]<=.64 && reduce.t[lf1]>.55){
                        jTextArea3.append("60% same\n");
                    }
                    else if(reduce.t[lf1]<=.54 && reduce.t[lf1]>.5){
                        jTextArea3.append("50% same\n");
                    }
                    else if(reduce.t[lf1]<=.49 && reduce.t[lf1]>.4){
                        jTextArea3.append("40% same\n");
                    }
                    else if(reduce.t[lf1]<=.39 && reduce.t[lf1]>.3){
                        jTextArea3.append("30% same\n");
                    }
                    else if(reduce.t[lf1]<=.29 && reduce.t[lf1]>.2){
                        jTextArea3.append("20% same");
                    }
                    else if(reduce.t[lf1]<=.19 && reduce.t[lf1]>.1){
                        jTextArea3.append("10% same\n");
                    }
                    else{
                        jTextArea3.append("content not similar\n");
                    }
                }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(comp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(comp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(comp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(comp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new comp().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    // End of variables declaration//GEN-END:variables
}
