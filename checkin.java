/* To change this template, choose Tools | Templates9
 * and open the template in the editor.
 */

/*
 * checkin.java
 *
 * Created on 10-Sep-2019, 19:50:43
 */
/**
 *
 * @author TOSHIBA
 */
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class checkin extends javax.swing.JInternalFrame {
    Connection con;
    void opencon(){
        try{
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/xiia1920", "root", "hello**231**");
        }catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    void refresh(){
        try{
            String q = "Select cust_id,first_name,last_name,room_no,nationality,id_proof,gender,check_in,check_out,adults,children,email,phone_no from custinfo;";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(q);
            DefaultTableModel dtm = (DefaultTableModel)tbl.getModel();
            while (dtm.getRowCount() > 0) {
                dtm.removeRow(0);
            }
            String cid, fn, ln, rno, nat, idp, gen, ci, co, adls, cldrn, em, ph;
            while (rs.next()) {
                cid = rs.getString(1);
                fn = rs.getString(2);
                ln = rs.getString(3);
                rno = rs.getString(4);
                nat = rs.getString(5);
                idp = rs.getString(6);
                gen = rs.getString(7);
                ci = rs.getString(8);
                co = rs.getString(9);
                adls = rs.getString(10);
                cldrn = rs.getString(11);
                em = rs.getString(12);
                ph = rs.getString(13);
                Object nr[] = {cid, fn, ln, rno, nat, idp, gen,ci, co, adls, cldrn, em, ph};
                dtm.addRow(nr);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    /** Creates new form checkin */
    public checkin() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        close = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rpd = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        floor = new javax.swing.JComboBox();
        roomtype = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        roomno = new javax.swing.JComboBox();
        c_id = new javax.swing.JTextField();
        fname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        adults = new javax.swing.JTextField();
        nalty = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        check_in = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        children = new javax.swing.JTextField();
        clear = new javax.swing.JButton();
        floor1 = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        floor2 = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Check-In");
        setAutoscrolls(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        close.setText("Close");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Georgia Pro", 0, 18));
        jLabel1.setText("Room Type");

        jLabel2.setFont(new java.awt.Font("Georgia Pro", 0, 18));
        jLabel2.setText("Floor");

        jLabel5.setFont(new java.awt.Font("Georgia Pro", 0, 18));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Rent per day (₹)");

        jLabel4.setFont(new java.awt.Font("Georgia Pro", 0, 18));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Room Number");

        floor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ground", "First ", "Second", "Third" }));
        floor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                floorActionPerformed(evt);
            }
        });

        roomtype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Single", "Double", "Studio", "Deluxe ", "Suit" }));
        roomtype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomtypeActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 0, 0));
        jLabel3.setFont(new java.awt.Font("Georgia Pro", 1, 26));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Resort & Spa");
        jLabel3.setOpaque(true);

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
        jLabel6.setForeground(new java.awt.Color(0, 153, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("<html><body><h1><u>Check-In</u></h1></body></html>");

        roomno.setPreferredSize(new java.awt.Dimension(60, 20));
        roomno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomnoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Georgia Pro", 0, 18));
        jLabel7.setText("Customer ID");

        jLabel8.setFont(new java.awt.Font("Georgia Pro", 0, 18));
        jLabel8.setText("First Name");

        jLabel9.setFont(new java.awt.Font("Georgia Pro", 0, 18));
        jLabel9.setText("Last Name");

        jLabel10.setFont(new java.awt.Font("Georgia Pro", 0, 18));
        jLabel10.setText("Nationality");

        jLabel11.setFont(new java.awt.Font("Georgia Pro", 0, 18));
        jLabel11.setText("ID Proof");

        jLabel12.setFont(new java.awt.Font("Georgia Pro", 0, 18));
        jLabel12.setText("Email ID");

        jLabel13.setFont(new java.awt.Font("Georgia Pro", 0, 18));
        jLabel13.setText("Phone No.");

        jLabel14.setFont(new java.awt.Font("Georgia Pro", 0, 18));
        jLabel14.setText("Adults");

        jLabel15.setFont(new java.awt.Font("Georgia Pro", 0, 18));
        jLabel15.setText("Children");

        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Georgia Pro", 0, 18));
        jLabel16.setText("Check-In Date");

        jLabel17.setFont(new java.awt.Font("Georgia Pro", 0, 18));
        jLabel17.setText("Expected Check-Out Date");

        check_in.setText("Check-In");
        check_in.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_inActionPerformed(evt);
            }
        });

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Customer ID", "First Name", "Last Name", "Room Number", "Nationality", "ID Proof", "Gender", "Check-In", "Check-Out", "Adults", "Children", "Email ID", "Phone "
            }
        ));
        tbl.setName("Check-In information"); // NOI18N
        tbl.setRowHeight(18);
        tbl.setSelectionBackground(new java.awt.Color(0, 204, 204));
        jScrollPane1.setViewportView(tbl);

        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        floor1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Passport", "Aadhar Card", "Ration Card", "Voter ID" }));
        floor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                floor1ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Georgia Pro", 0, 18));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Gender");

        floor2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        floor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                floor2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(375, 375, 375)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(428, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(934, 934, 934)
                .addComponent(close)
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(48, 48, 48))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(children)
                    .addComponent(floor2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(adults)
                    .addComponent(phone)
                    .addComponent(lname)
                    .addComponent(fname, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(c_id, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(floor1, 0, 170, Short.MAX_VALUE)
                    .addComponent(nalty, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(email))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16))))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(roomtype, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(floor, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roomno, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rpd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clear, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(check_in, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 973, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(c_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(roomtype, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(floor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(roomno, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rpd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nalty, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(floor1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(floor2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(check_in))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(jLabel16)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(adults, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel17)
                    .addComponent(clear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(children, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(close)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void roomtypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomtypeActionPerformed
// TODO add your handling code here:
        try{
            //floor.removeAllItems();
            String q1 = (String)roomtype.getSelectedItem();
            String q2 = "Select distinct floor from rinfo where status='vacant' and room_type='"+q1+"'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(q2);
            String r;
            while(rs.next()){
                r = rs.getString(1);
                floor.addItem(r);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }

}//GEN-LAST:event_roomtypeActionPerformed

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
// TODO add your handling code here:
        try {
            opencon();
            refresh();

//Enter values in room type combo box
            String q = "Select distinct room_type from rinfo where status='vacant'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(q);
            String r;
            while (rs.next()) {
                r = rs.getString(1);
                roomtype.addItem(r);
            }

//Generate and display customer id
            String q1 = "Select max(id)+1 from custinfo";
            Statement stmt1 = con.createStatement();
            ResultSet rs2 = stmt1.executeQuery(q1);
            String cid = "";
            while (rs2.next()) {
                cid = rs2.getString(1);
            }
            c_id.setText(cid);

//Enter check-in date by default
            java.util.Date d;
            d = new java.util.Date();
//            cin.setDate(""+d);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_formInternalFrameOpened

    private void check_inActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_inActionPerformed
//Extracting data from the fields
        try{
            String cid = c_id.getText();
            String f = fname.getText();
            String l = lname.getText();
            String nat = nalty.getText();
            String e = email.getText();
            String pno = phone.getText();
            String a = adults.getText();
            String c = children.getText();
//            String ci = cin.getDate();
  //          String co = cout.getDate();
            String rno = (String)roomno.getSelectedItem();
            String prf = (String)floor1.getSelectedItem();
            String gen = (String)floor2.getSelectedItem();

//Get checkin and checkout date as String objects
            SimpleDateFormat formatter;
            formatter = new SimpleDateFormat("yyyy-MM-dd");
          //  String ci = formatter.format(cin.getDate());
           // String co = formatter.format(cout.getDate());

 //Inserting values in table cust
            String q = "Insert into cust values('"+cid+"','"+f+"','"+l+"',"+rno+",'"+nat+",'"+prf+"','"+gen+"','"+/*ci+"','"+co+*/"',"+a+","+c+",'"+e+"',"+pno+",total_bill=0)";
            Statement stmt=con.createStatement();
            stmt.executeUpdate(q);

 //Changing status to Occupied
            String q2 = "Update rinfo set status = 'Occupied' where room_no="+rno;
            stmt.executeUpdate(q2);
            refresh();
            JOptionPane.showMessageDialog(this,"Check-in Successful");
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }  
    }//GEN-LAST:event_check_inActionPerformed

    private void floorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_floorActionPerformed
// TODO add your handling code here:
        try{
            //roomno.removeAllItems();
            String q1 = (String)roomtype.getSelectedItem();
            String q2 = (String)floor.getSelectedItem();
            String q3 = "Select room_no from rinfo where status='vacant' and room_type='"+q1+"'and floor="+q2;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(q3);
            String r;
            while(rs.next()){
                r=rs.getString(1);
                roomno.addItem(r);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }//GEN-LAST:event_floorActionPerformed

    private void roomnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomnoActionPerformed
// TODO add your handling code here:
        try{
            String r = (String)roomno.getSelectedItem();
            String q = "Select rent_per_day from rinfo where room_no="+r;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(q);
            while(rs.next()){
                r = rs.getString(1);
                rpd.setText(r);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }//GEN-LAST:event_roomnoActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
// TODO add your handling code here:
        try{
    //Generate and display customer id
    String q1 = "select max(id)+1 from custinfo";
    Statement stmt1 = con.createStatement();
    ResultSet rs = stmt1.executeQuery(q1);
    String cid = "";
    while(rs.next())
        cid = rs.getString(1);
    c_id.setText(cid);
    //Enter check-in date by default
            java.util.Date d;
            d=new java.util.Date();
//    cin.setDate(d);

    //Clear text fields
    fname.setText("");
    lname.setText("");
    nalty.setText("");
    floor1.setSelectedIndex(1);
    floor2.setSelectedIndex(1);
    email.setText("");
    phone.setText("");
    adults.setText("");
    children.setText("");
    roomtype.setSelectedIndex(1);
//    cout.setDate(null);
}catch(Exception e){
    JOptionPane.showMessageDialog(this,e.getMessage());
}

    }//GEN-LAST:event_clearActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
// TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_closeActionPerformed

    private void floor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_floor1ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_floor1ActionPerformed

    private void floor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_floor2ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_floor2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adults;
    private javax.swing.JTextField c_id;
    private javax.swing.JButton check_in;
    private javax.swing.JTextField children;
    private javax.swing.JButton clear;
    private javax.swing.JButton close;
    private javax.swing.JTextField email;
    private javax.swing.JComboBox floor;
    private javax.swing.JComboBox floor1;
    private javax.swing.JComboBox floor2;
    private javax.swing.JTextField fname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField nalty;
    private javax.swing.JTextField phone;
    private javax.swing.JComboBox roomno;
    private javax.swing.JComboBox roomtype;
    private javax.swing.JTextField rpd;
    private javax.swing.JTable tbl;
    // End of variables declaration//GEN-END:variables
}
