package tfile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.rtf.RTFEditorKit;
import org.apache.poi.hdf.extractor.WordDocument;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.eventfilesystem.POIFSReader;
import org.apache.poi.poifs.eventfilesystem.POIFSReaderEvent;
import org.apache.poi.poifs.eventfilesystem.POIFSReaderListener;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.util.LittleEndian;
import org.pdfbox.cos.COSDocument;
import org.pdfbox.pdfparser.PDFParser;
import org.pdfbox.pdmodel.PDDocument;
import org.pdfbox.util.PDFTextStripper;

public class fileconversion extends javax.swing.JFrame {
 StringBuffer sb = new StringBuffer(8192);
    public ResultSet rs;
    public Statement st;
    public static String[] ar;
    public static ArrayList<String> cn = new ArrayList();
    public static int fsize;

    public static String fnam;

    public fileconversion() {
        initComponents();
        try {
            String url = "jdbc:mysql://localhost:3306/fileconversion";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection(url, "root", "");
             System.out.println("Connected to the database");
             st = conn.createStatement();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "File Conversion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setText("Select File");
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(140, 190, 130, 30);

        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel2.add(jTextField1);
        jTextField1.setBounds(40, 250, 370, 30);

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton2.setText("Extract");
        jButton2.setOpaque(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(40, 330, 140, 40);

        jList1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jList1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(jList1);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(60, 50, 300, 110);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Choose File Type");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(140, 30, 150, 20);

        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton3.setText("Process");
        jButton3.setOpaque(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(220, 330, 140, 40);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 10, 420, 440);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "text file content", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(14, 17, 310, 400);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(440, 20, 330, 430);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/collweb.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 850, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            JFileChooser jf = new JFileChooser();
            jf.showOpenDialog(jPanel1);
            String ss = jf.getSelectedFile().getAbsolutePath();
            fnam = jf.getSelectedFile().getAbsolutePath();
            int len = ss.length();
            String sss = "";
            sss = (String) jList1.getSelectedValue().toString();
            String f = ss.substring(len - 4, len);
            if (sss.equals(f)) {
                jTextField1.setText(ss);
            } else {
                JOptionPane.showMessageDialog(jPanel1, "Not a Selected File");
            }

        } catch (Exception e) {
            System.out.println("except1 "+e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            cn.add(".doc");
            cn.add(".xls");
            cn.add(".ppt");
            cn.add(".pdf");
            cn.add(".rft");
            System.out.println("cn=" + cn);
            ar = new String[cn.size()];
            ar = cn.toArray(ar);
            for (String saa : ar) {
                System.out.println("ar=" + saa);
            }
            for (int i = 0; i < ar.length; i++) {
                jList1.setListData(ar);
            }

        } catch (Exception e) {
            System.out.println("Except2 "+e.getMessage());
        }
    }//GEN-LAST:event_formWindowOpened

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTextArea1.setVisible(true);
        try {
            fileconversion rff=new fileconversion();
            FileWriter fs = new FileWriter("./Extract.txt");
            BufferedWriter bw = new BufferedWriter(fs);
            String inp = jTextField1.getText();

            File f = new File(inp);
            fsize = (int) f.length();
            fnam = f.getName();
            System.out.println("Fname in Read:" + fnam);
            if (!f.exists()) {
                System.out.println("Sorry File does not Exists!");
            } else {
                if (f.getName().endsWith(".pdf") || f.getName().endsWith(".PDF")) {

                    jTextArea1.append(rff.pdftotext(inp));
                    bw.write(rff.pdftotext(inp));
                    bw.newLine();
                } else if (f.getName().endsWith(".doc") || f.getName().endsWith(".DOC")) {

                    jTextArea1.append(rff.doc2text(inp));
                    bw.write(rff.doc2text(inp));
                    bw.newLine();
                } else if (f.getName().endsWith(".rtf") || f.getName().endsWith(".RTF")) {

                    jTextArea1.append(rff.rtf2text(new FileInputStream(inp)));
                    bw.write(rff.rtf2text(new FileInputStream(inp)));
                    bw.newLine();
                } else if (f.getName().endsWith(".ppt") || f.getName().endsWith(".PPT")) {

                    jTextArea1.append(rff.ppt2text(inp));
                    bw.write(rff.ppt2text(inp));
                    bw.newLine();
                } else if (f.getName().endsWith(".xls") || f.getName().endsWith(".XLS")) {

                    jTextArea1.append(rff.xls2text(new FileInputStream(inp)));
                    bw.write(rff.xls2text(new FileInputStream(inp)));
                    bw.newLine();

                }
                bw.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      stopword st=new stopword();
      st.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed
public String doc2text(String fileName) throws IOException
{
    WordDocument wd = new WordDocument(fileName);
    StringWriter docTextWriter = new StringWriter();
    wd.writeAllText(new PrintWriter(docTextWriter));
    docTextWriter.close();
    return docTextWriter.toString();
}


public String rtf2text(InputStream is) throws Exception {
DefaultStyledDocument styledDoc = new DefaultStyledDocument();
new RTFEditorKit().read(is, styledDoc, 0);
return styledDoc.getText(0, styledDoc.getLength());
}
public String ppt2text(String fileName) throws Exception {
POIFSReader poifReader = new POIFSReader();
poifReader.registerListener(new fileconversion.MyPOIFSReaderListener());
poifReader.read(new FileInputStream(fileName));
return sb.toString();
}


class MyPOIFSReaderListener implements POIFSReaderListener {
public void processPOIFSReaderEvent(POIFSReaderEvent event) {
char ch0 = (char) 0;
char ch11 = (char) 11;
try {
DocumentInputStream dis = null;
dis = event.getStream();
byte btoWrite[] = new byte[dis.available()];
dis.read(btoWrite, 0, dis.available());
for (int i = 0; i < btoWrite.length - 20; i++) {
long type = LittleEndian.getUShort(btoWrite, i + 2);
long size = LittleEndian.getUInt(btoWrite, i + 4);
if (type == 4008) {
try {
String s = new String(btoWrite, i + 4 + 1, (int) size + 3).replace(ch0, ' ').replace(ch11, ' ');
if (s.trim().startsWith("Click to edit") == false) {
sb.append(s);
}
} catch (Exception ee) {
System.out.println("error:" + ee);
}
}
}
} catch (Exception ex) {
ex.printStackTrace();
return;
}
}
}


public String pdftotext(String fileName) {
PDFParser parser;
String parsedText;
PDFTextStripper pdfStripper;
PDDocument pdDoc = null;
COSDocument cosDoc = null;
File f = new File(fileName);
try {
parser = new PDFParser(new FileInputStream(f));
} catch (Exception e) {
System.out.println("Unable to open PDF Parser.");
return null;
}
try {
parser.parse();
cosDoc = parser.getDocument();
pdfStripper = new PDFTextStripper();
pdDoc = new PDDocument(cosDoc);
parsedText = pdfStripper.getText(pdDoc);
cosDoc.close();
pdDoc.close();
} catch (Exception e) {
System.out.println("An exception occured in parsing the PDF Document.");
e.printStackTrace();
try {
if (cosDoc != null) {
cosDoc.close();
}
if (pdDoc != null) {
pdDoc.close();
}
} catch (Exception e1) {
e1.printStackTrace();
}
return null;
}
System.out.println("Done.");
return parsedText;
}


public String xls2text(InputStream in) throws Exception
{
HSSFWorkbook excelWb = new HSSFWorkbook(in);
StringBuffer result = new StringBuffer(4096);
int numberOfSheets = excelWb.getNumberOfSheets();
for (int i = 0; i < numberOfSheets; i++)
{
HSSFSheet sheet = excelWb.getSheetAt(i);
int numberOfRows = sheet.getPhysicalNumberOfRows();
if (numberOfRows > 0)
{
if (excelWb.getSheetName(i) != null && excelWb.getSheetName(i).length() != 0)
{
// append sheet name to content
if (i > 0)
result.append("\n\n");
result.append(excelWb.getSheetName(i).trim());
result.append(":\n\n");
}

Iterator<HSSFRow> rowIt = sheet.rowIterator();
while (rowIt.hasNext())
{
HSSFRow row = rowIt.next();
if (row != null)
{
boolean hasContent = false;
Iterator<HSSFCell> it = row.cellIterator();
while (it.hasNext())
{
HSSFCell cell = it.next();
String text = null;
try
{
switch (cell.getCellType())
{
case HSSFCell.CELL_TYPE_BLANK:
case HSSFCell.CELL_TYPE_ERROR:
// ignore all blank or error cells
break;
case HSSFCell.CELL_TYPE_NUMERIC:
text = Double.toString(cell.getNumericCellValue());
break;
case HSSFCell.CELL_TYPE_BOOLEAN:
text = Boolean.toString(cell.getBooleanCellValue());
break;
case HSSFCell.CELL_TYPE_STRING:
default:
text = cell.getStringCellValue();
break;
}
}
catch (Exception e){}
if ((text != null) && (text.length() != 0))
{
result.append(text.trim());
result.append(' ');
hasContent = true;
}
}
if (hasContent)
{
// append a newline at the end of each row that has content
result.append('\n');
}
}
}
}
}
return result.toString();
}


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
            java.util.logging.Logger.getLogger(fileconversion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fileconversion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fileconversion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fileconversion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fileconversion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
