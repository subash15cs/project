
package tfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.sql.*;
import javax.swing.JOptionPane;
public class stopword extends javax.swing.JFrame {
       public ResultSet rs;
    public Statement st;
    public static String line, cont, ch1, u, str, str1, str2, cond1, sv,name;
 public static Set<String> stopWords = new HashSet<String>();
    public stopword() {
        initComponents();
        try {
            String url = "jdbc:mysql://localhost:3306/fileconversion";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection(url, "root", "");
            st = conn.createStatement();
            System.out.println("Connected to the database");
 st.executeUpdate("DROP TABLE IF EXISTS `stopwords`");
            st.executeUpdate("CREATE TABLE `stopwords` (`sno` VARCHAR(30) ,`words` VARCHAR(10000)  )");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("stopword");
        setMinimumSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "STOPWORD REMOVAL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Input File");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(340, 40, 80, 30);

        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(jTextField1);
        jTextField1.setBounds(60, 80, 630, 30);

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setText("Remove Stopwords ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(120, 130, 190, 30);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FILE CONTENT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(20, 20, 610, 290);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(60, 180, 640, 330);

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton2.setText("Store Stopwords");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(330, 130, 190, 30);

        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton3.setText("Proceed");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(550, 130, 110, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 10, 740, 540);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/collweb.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 800, 560);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         try {
            stopWords.add("a");
            stopWords.add("as");
            stopWords.add("and");
            stopWords.add("is");
            stopWords.add("to");
            stopWords.add("all");
            stopWords.add("the");
            stopWords.add("his");
            stopWords.add("or");
            stopWords.add("of");
            stopWords.add("i'm");
            stopWords.add("who's");
            stopWords.add("after");
            stopWords.add("with");
            stopWords.add("what's");
            stopWords.add("there's");
            stopWords.add("you");
            stopWords.add("their");
            stopWords.add("when");
            stopWords.add("going");
            stopWords.add("an");
            stopWords.add("its");
            stopWords.add("are");
            stopWords.add("why");
            stopWords.add("go");
            stopWords.add("w");
            stopWords.add("e");
            stopWords.add("b");
            stopWords.add("these");
            stopWords.add("not");
            stopWords.add("now");
            stopWords.add("s");
            stopWords.add("t");
            stopWords.add("v");
            stopWords.add("at");
            stopWords.add("like");
            stopWords.add("been");
            stopWords.add("me");
            stopWords.add("se");
            stopWords.add("ve");
            stopWords.add("from");
            stopWords.add("so");
            stopWords.add("your");
            stopWords.add("ever");
            stopWords.add("was");
            stopWords.add("there");
            stopWords.add("their");
            stopWords.add("this");
            stopWords.add("them");
            stopWords.add("it's");
            stopWords.add("nt");
            stopWords.add("i");
            stopWords.add("th");
            stopWords.add("they");
            stopWords.add("in");
            stopWords.add("on");
            stopWords.add("it");
            stopWords.add("can");
            stopWords.add("be");
            stopWords.add("he");
            stopWords.add("she");
            stopWords.add("m");
            stopWords.add("wa");
            stopWords.add("ar");
            stopWords.add("however");
            stopWords.add("would");
            stopWords.add("put");
            stopWords.add("other");
            stopWords.add("help");
            stopWords.add("under");
            stopWords.add("while");
            stopWords.add("does");
            stopWords.add("must");
            stopWords.add("leave");
            stopWords.add("out");
            stopWords.add("ha");
            stopWords.add("but");
            stopWords.add("have");
            stopWords.add("has");
            stopWords.add("had");
            stopWords.add("could");
            stopWords.add("if");
            stopWords.add("are");
            stopWords.add("that");
            stopWords.add("by");
            stopWords.add("wasn't");
            stopWords.add("didn't");
            stopWords.add("which");
            stopWords.add("for");
            stopWords.add("what's");
            stopWords.add("which");
            stopWords.add("what");
            stopWords.add("that");
            stopWords.add("we");
            stopWords.add("how");
            stopWords.add("be");
               stopWords.add("");
                  stopWords.add("---");
            System.out.println("removing stop words");
            jTextArea1.append("*****************************************************************************" + "\n");
            jTextArea1.append("After Removing Stop Words" + "\n");
            jTextArea1.append("****************************************************************************" + "\n");
            BufferedReader br = new BufferedReader(new FileReader(".//Extract.txt"));
         File   f2 = new File("./Stopword.txt");
         String get=br.readLine();
         File n=new File(get);
         jTextField1.setText(n.getAbsolutePath());
            str2 = f2.getPath();
            FileWriter fw22 = new FileWriter(f2);
            BufferedWriter bw1 = new BufferedWriter(fw22);
            while ((line = br.readLine()) != null) {
                StringTokenizer tokens = new StringTokenizer(line, " </>_.:,'[]^\"0123456789()|%;+-$&#@{}!*?");
                while (tokens.hasMoreTokens()) {
                    cont = tokens.nextToken();
                    if (!stopWords.contains(cont.toLowerCase())) {
                        jTextArea1.append(cont + "\n");
                        bw1.write(cont);
                        bw1.newLine();
                    }
                }
            }
            bw1.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
  
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       try
       {
           String s,s1;    
           int  cnt = 1;
           BufferedReader br = new BufferedReader(new FileReader(".//Stopword.txt"));
            while ((s = br.readLine()) != null) {
        
                StringTokenizer stt = new StringTokenizer(s, ",");
                while (stt.hasMoreTokens()) {
                    s1 = (stt.nextToken());
                  
                    int fg = 0;
                    
                    st.executeUpdate("INSERT INTO `stopwords` VALUES (" + cnt + ",'" + s1 + "')");
                    cnt++;
                }
            }
            JOptionPane.showMessageDialog(this, "Data is successfully inserted into the database.");
       
       }
       catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        group s=new group();
        s.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(stopword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(stopword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(stopword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(stopword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new stopword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
