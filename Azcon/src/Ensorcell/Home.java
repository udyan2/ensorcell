/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ensorcell;

/**
 *
 * @author Udyan Sharma
 */
//The main file for the application

import java.awt.Image;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.awt.Color;

//API Connection Libraries
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.json.JSONObject;
import org.json.JSONArray;


//Tesseract OCR Conversion Libraries
import java.io.File;  
import javax.swing.JFrame;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;


//SQL Connection Libraries
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;

/**
 *
 * @author Udyan Sharma
 */
public class Home extends javax.swing.JFrame {
    public static HttpURLConnection connection;
    private static final String username="1P1KD86FIO";
    private static final String password="91WppLkrdu";
    private static final String dataConn="jdbc:mysql://remotemysql.com:3306/1P1KD86FIO";
    
    Connection sqlConn =null;
    PreparedStatement pst = null;
    ResultSet rs=null;
    int q,i,id,deleteItem;
    
    
    /**
     * Creates new form Form1
     */
    public Home() {
        initComponents();
        upDateDB();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    //User Function
     public void upDateDB()
    {
        try
        {
           
           Class.forName("com.mysql.cj.jdbc.Driver"); 
            sqlConn = DriverManager.getConnection(dataConn,username,password);
            pst = sqlConn.prepareStatement("select * from 1P1KD86FIO");
            
            rs=pst.executeQuery();
            ResultSetMetaData StData=rs.getMetaData();
            
            q=StData.getColumnCount();
            
            DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel();
            RecordTable.setRowCount(0);
            
            while(rs.next()){
                
                Vector columnData = new Vector();
                
                for (i = 1; i <= q; i++)
                {
                   columnData.add(rs.getString("id"));
                   columnData.add(rs.getString("OwnerName"));
                   columnData.add(rs.getString("RegNumber"));
                   columnData.add(rs.getString("Location"));
                   columnData.add(rs.getString("Model"));
                   columnData.add(rs.getString("EngineNumber"));
                   columnData.add(rs.getString("RegYear"));
                   columnData.add(rs.getString("Chassis"));
                   columnData.add(rs.getString("Insurance"));
                   columnData.add(rs.getString("VehicleType"));
                }
                    RecordTable.addRow(columnData);                
                
            }
         
        }
        catch (Exception exc) {
            JOptionPane.showMessageDialog(null, exc);
        } 
        
    }
    //End User Function
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        InputImagebtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        checkAPI = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        exitbtn = new javax.swing.JButton();
        jLabelImage = new javax.swing.JLabel();
        vehiclenumber = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        reset = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Print = new javax.swing.JButton();
        addToDatabase = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        vehiclemodel = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        location = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        enginenumber = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        regyear = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        chassisnumber = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ownername = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        insurance = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        vehicletype = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ENSORCELL - By Azcon (Udyan Sharma)");
        setBackground(new java.awt.Color(255, 255, 0));
        setLocation(new java.awt.Point(800, 300));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        InputImagebtn.setBackground(new java.awt.Color(0, 0, 153));
        InputImagebtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        InputImagebtn.setForeground(new java.awt.Color(255, 255, 255));
        InputImagebtn.setText("Capture Image");
        InputImagebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputImagebtnActionPerformed(evt);
            }
        });
        getContentPane().add(InputImagebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, 380, 60));

        jButton2.setBackground(new java.awt.Color(0, 0, 153));
        jButton2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Check Database Connection");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 710, 380, 60));

        checkAPI.setBackground(new java.awt.Color(0, 0, 153));
        checkAPI.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        checkAPI.setForeground(new java.awt.Color(255, 255, 255));
        checkAPI.setText("Check API Connection");
        checkAPI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAPIActionPerformed(evt);
            }
        });
        getContentPane().add(checkAPI, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 610, 380, 60));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        jLabel1.setText("ENSORCELL");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, -1, 79));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("VEHICLE REGISTRATION NUMBER RECOGNITION APPLICATION");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, -1, -1));

        exitbtn.setBackground(new java.awt.Color(0, 0, 0));
        exitbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        exitbtn.setForeground(new java.awt.Color(255, 255, 255));
        exitbtn.setText("Exit");
        exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbtnActionPerformed(evt);
            }
        });
        getContentPane().add(exitbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 710, 210, 60));

        jLabelImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 4));
        getContentPane().add(jLabelImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 380, 260));

        vehiclenumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehiclenumberActionPerformed(evt);
            }
        });
        getContentPane().add(vehiclenumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 230, 210, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Registration Number");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, 210, 20));

        reset.setBackground(new java.awt.Color(0, 0, 0));
        reset.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        reset.setForeground(new java.awt.Color(255, 255, 255));
        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        getContentPane().add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 600, 210, 60));

        jLabel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 560, 60));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Registration Number", "Location", "Vehicle Model", "Engine Number", "Chassis Number", "Fuel Type", "Insurance", "Vehicle Type"
            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 260, 510, 140));

        Print.setBackground(new java.awt.Color(0, 0, 153));
        Print.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Print.setForeground(new java.awt.Color(255, 255, 255));
        Print.setText("Print");
        Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintActionPerformed(evt);
            }
        });
        getContentPane().add(Print, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 710, 510, 60));

        addToDatabase.setBackground(new java.awt.Color(0, 0, 153));
        addToDatabase.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addToDatabase.setForeground(new java.awt.Color(255, 255, 255));
        addToDatabase.setText("Add to Database");
        addToDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToDatabaseActionPerformed(evt);
            }
        });
        getContentPane().add(addToDatabase, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 500, 510, 60));

        Delete.setBackground(new java.awt.Color(0, 0, 153));
        Delete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Delete.setForeground(new java.awt.Color(255, 255, 255));
        Delete.setText("Delete Record");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        getContentPane().add(Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 610, 510, 60));

        vehiclemodel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehiclemodelActionPerformed(evt);
            }
        });
        getContentPane().add(vehiclemodel, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 310, 210, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Vehicle Model");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 310, 210, 20));

        location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationActionPerformed(evt);
            }
        });
        getContentPane().add(location, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 270, 210, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Location");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, 210, 20));

        enginenumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enginenumberActionPerformed(evt);
            }
        });
        getContentPane().add(enginenumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 350, 210, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Engine Number");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 350, 210, 20));

        regyear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regyearActionPerformed(evt);
            }
        });
        getContentPane().add(regyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 390, 210, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Registration Year");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 390, 210, 20));

        chassisnumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chassisnumberActionPerformed(evt);
            }
        });
        getContentPane().add(chassisnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 430, 210, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Chassis Number");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 430, 210, 20));

        ownername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ownernameActionPerformed(evt);
            }
        });
        getContentPane().add(ownername, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 190, 210, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Owner Name");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, 210, 20));

        insurance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insuranceActionPerformed(evt);
            }
        });
        getContentPane().add(insurance, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 470, 210, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Insurance");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 470, 210, 20));

        vehicletype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicletypeActionPerformed(evt);
            }
        });
        getContentPane().add(vehicletype, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 510, 210, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("Vehicle Type");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 510, 210, 20));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void InputImagebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputImagebtnActionPerformed
    
         // TODO add your handling code here:
         JFileChooser browseImageFile=new JFileChooser();
         //Image Extensions Filter
         FileNameExtensionFilter fnef=new FileNameExtensionFilter("jpg","png","jpeg");
         browseImageFile.addChoosableFileFilter(fnef);
         
         int showOpenDialogue = browseImageFile.showOpenDialog(null);
         if(showOpenDialogue==JFileChooser.APPROVE_OPTION){
         File selectedImageFile = browseImageFile.getSelectedFile();
         String imagePath=selectedImageFile.getAbsolutePath();
         JOptionPane.showMessageDialog(this,"Image File URL: \n"+imagePath);
         
         ImageIcon im = new ImageIcon(imagePath);
         jLabelImage.setIcon(im);
         
         //Resizing image for jLabel
         Image img = im.getImage().getScaledInstance(jLabelImage.getWidth(),jLabelImage.getHeight(),Image.SCALE_SMOOTH);
         jLabelImage.setIcon(new ImageIcon(img));
         
         Tesseract tessobj = new Tesseract();
         String vNum="";
            try {
                // the path of the tesseract data folder
                tessobj.setDatapath("C:/Users/Udyan Sharma/Downloads/Tess4J/tessdata");
                // The Image for Text Extraction
                String text = tessobj.doOCR(new File(imagePath));
                // Path of Output image file
                text = text.replaceAll("\\s", "");
                System.out.print("Vehicle Number: "+text);
                vNum=text;
            }
            catch (TesseractException exp) {
                exp.printStackTrace();
            }
         
         vehiclenumber.setText(vNum);
         
        BufferedReader reader;
	String line;
	StringBuffer responseContent = new StringBuffer();
		
		try{
	    	URL url=new URL("https://www.regcheck.org.uk/api/reg.asmx/CheckIndia?username=azcontest&&RegistrationNumber="+vNum);
	    	connection=(HttpURLConnection) url.openConnection();
	    	connection.setRequestMethod("GET");
		    	connection.setConnectTimeout(5000);
		    	connection.setReadTimeout(5000);
		    	
		    	int status = connection.getResponseCode();
		    	System.out.println("Successfully Connected to the API. Connection Status Code: "+status);
		    	JOptionPane.showMessageDialog(this,"Successfully Connected to the API. \nConnection Status Code: "+status);
		    	if (status>299) {
		    		reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
		    		while ((line=reader.readLine())!=null){
		    			responseContent.append(line+"\n");
		    		}
		    	reader.close();
		    	} else {
		    		reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		    		while ((line=reader.readLine())!=null){
		    			responseContent.append(line+"\n");
		    		}
		    	}
		    	reader.close();
//		    	System.out.println(responseContent);
                        System.out.println(responseContent.toString());
                        
                        String rC=responseContent.toString();
//                        parse(responseContent.toString());
                        regyear.setText(rC.substring(rC.indexOf("\"RegistrationYear\":")+21, rC.indexOf("\"RegistrationYear\":")+25));
                        chassisnumber.setText(rC.substring(rC.indexOf("cationNumber")+16, rC.indexOf("cationNumber")+32));
                        vehiclemodel.setText(rC.substring(rC.indexOf("<CarModel>")+10, rC.indexOf("</CarModel>")));
                        location.setText(rC.substring(rC.indexOf("\"Location\":")+13, rC.indexOf("\",\n" +"  \"ImageUrl\"")));
                        enginenumber.setText(rC.substring(rC.indexOf("\"EngineNumber\":")+17, rC.indexOf("\",\n" +"  \"FuelType\"")));
                        ownername.setText(rC.substring(rC.indexOf("\"Owner\":")+10, rC.indexOf("\",\n"+"  \"Fitness\":")));
                        insurance.setText(rC.substring(rC.indexOf("\"Insurance\":")+14,rC.indexOf("\"Insurance\":")+24));
                        vehicletype.setText(rC.substring(rC.indexOf("\"VehicleType\"")+16,rC.indexOf("\",\n"+"  \"Location\":")));
//		    	vehiclemake.setText(rC.substring(rC.indexOf("Description") + 3));
//                        vehiclemake.setText();
		    } catch (MalformedURLException e){
		    	e.printStackTrace();
		    } catch (IOException e){
		    	e.printStackTrace();
		    } finally{
		    	connection.disconnect();
		    }
         }
         
         

    }//GEN-LAST:event_InputImagebtnActionPerformed

    private void checkAPIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkAPIActionPerformed
        // TODO add your handling code here:
        
//        BufferedReader reader;
//	String line;
//	StringBuffer responseContent = new StringBuffer();
		
		try{
                //This API requires a username to run and function. So, an account needs to be created before running the program.
	    	URL url=new URL("https://www.regcheck.org.uk/api/reg.asmx/CheckIndia?username=udyan2&&RegistrationNumber=DL10SY9247");
	    	connection=(HttpURLConnection) url.openConnection();
	    	connection.setRequestMethod("GET");
		    	connection.setConnectTimeout(5000);
		    	connection.setReadTimeout(5000);
		    	
		    	int status = connection.getResponseCode();
		    	System.out.println("Successfully Connected to the API. Connection Status Code: "+status);
		    	JOptionPane.showMessageDialog(this,"Successfully Connected to the API. \nConnection Status Code: "+status);
//		    	if (status>299) {
//		    		reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
//		    		while ((line=reader.readLine())!=null){
//		    			responseContent.append(line);
//		    		}
//		    	reader.close();
//		    	} else {
//		    		reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//		    		while ((line=reader.readLine())!=null){
//		    			responseContent.append(line);
//		    		}
//		    	}
//		    	reader.close();
//		    	System.out.println(responseContent);
////                        parse(responseContent.toString());
//		    	
		    } catch (MalformedURLException e){
		    	e.printStackTrace();
		    } catch (IOException e){
		    	e.printStackTrace();
		    } finally{
		    	connection.disconnect();
		    }
                
    }//GEN-LAST:event_checkAPIActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this,"Database Connection Checked");
    }//GEN-LAST:event_jButton2ActionPerformed
    private JFrame exitFrame;
    private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbtnActionPerformed
        // TODO add your handling code here:
        exitFrame=new JFrame("Exit");
        if(JOptionPane.showConfirmDialog(exitFrame,"Are you sure you want to exit?","Ensorcell",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_exitbtnActionPerformed

    private void vehiclenumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehiclenumberActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_vehiclenumberActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        ownername.setText("");
        vehiclenumber.setText("");
        vehiclemodel.setText("");
        location.setText("");
        enginenumber.setText("");
        regyear.setText("");
        chassisnumber.setText("");
        insurance.setText("");
        vehicletype.setText("");
        jLabelImage.setIcon(null);
    }//GEN-LAST:event_resetActionPerformed

    private void PrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintActionPerformed
        // TODO add your handling code here:
        MessageFormat header = new MessageFormat("Printing in progress");
        MessageFormat footer = new MessageFormat("Page {0, number, integer}");
        
        try{
            jTable1.print(JTable.PrintMode.NORMAL,header,footer);
        }
        catch(java.awt.print.PrinterException e){
            System.err.format("No Printer found", e.getMessage());
        }
    }//GEN-LAST:event_PrintActionPerformed

    private void addToDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToDatabaseActionPerformed
        // TODO add your handling code here:
        try
        {
           
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            sqlConn = DriverManager.getConnection(dataConn,username,password);
            pst = sqlConn.prepareStatement("insert into 1P1KD86FIO(OwnerName,RegNumber,Location,Model,EngineNumber,RegYear,Chassis,Insurance,VehicleType)value(?,?,?,?,?,?,?,?,?)");
        
            pst.setString(1, ownername.getText());
            pst.setString(2, vehiclenumber.getText());
            pst.setString(3, location.getText());
            pst.setString(4, vehiclemodel.getText());
            pst.setString(5, enginenumber.getText());
            pst.setString(6, regyear.getText());
            pst.setString(7, chassisnumber.getText());
            pst.setString(8, insurance.getText());
            pst.setString(9, vehicletype.getText());
            
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"Vehicle Record Added");
          upDateDB();
        
        }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, 
                    null, ex);
        } catch (SQLException ex) {
             //System.err.println(ex);
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } 

    }//GEN-LAST:event_addToDatabaseActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
         DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel();
        int SelectedRows = jTable1.getSelectedRow();
        try
        {
                    id = Integer.parseInt(RecordTable.getValueAt(SelectedRows, 0).toString());
                    deleteItem = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete?",
                    "Warning",JOptionPane.YES_NO_OPTION);
             if (deleteItem ==JOptionPane.YES_OPTION ){                 
         
           Class.forName("com.mysql.cj.jdbc.Driver"); 
            sqlConn = DriverManager.getConnection(dataConn,username,password);
                pst = sqlConn.prepareStatement("delete from 1P1KD86FIO where id =?");
                pst.setInt(1, id);
                pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"Record Deleted");
            upDateDB();
            ownername.setText("");
            vehiclenumber.setText("");
            vehiclemodel.setText("");
            location.setText("");
            enginenumber.setText("");
            regyear.setText("");
            chassisnumber.setText("");
            insurance.setText("");
            vehicletype.setText("");
                       
             }
           
        }
        
        catch (ClassNotFoundException ex) {
        java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, 
           null, ex);
        } catch (SQLException ex) {
             System.err.println(ex);
        } 
    }//GEN-LAST:event_DeleteActionPerformed

    private void vehiclemodelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehiclemodelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vehiclemodelActionPerformed

    private void locationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_locationActionPerformed

    private void enginenumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enginenumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enginenumberActionPerformed

    private void regyearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regyearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regyearActionPerformed

    private void chassisnumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chassisnumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chassisnumberActionPerformed

    private void ownernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ownernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ownernameActionPerformed

    private void insuranceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insuranceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insuranceActionPerformed

    private void vehicletypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicletypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vehicletypeActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Home home=new Home();
                home.setVisible(true);
                //Maximize the Frame
                home.setExtendedState(Home.MAXIMIZED_BOTH); 
                //Set the Background Colour to Red
                home.setBackground(Color.red);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Delete;
    private javax.swing.JButton InputImagebtn;
    private javax.swing.JButton Print;
    private javax.swing.JButton addToDatabase;
    private javax.swing.JTextField chassisnumber;
    private javax.swing.JButton checkAPI;
    private javax.swing.JTextField enginenumber;
    private javax.swing.JButton exitbtn;
    private javax.swing.JTextField insurance;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelImage;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField location;
    private javax.swing.JTextField ownername;
    private javax.swing.JTextField regyear;
    private javax.swing.JButton reset;
    private javax.swing.JTextField vehiclemodel;
    private javax.swing.JTextField vehiclenumber;
    private javax.swing.JTextField vehicletype;
    // End of variables declaration//GEN-END:variables
}