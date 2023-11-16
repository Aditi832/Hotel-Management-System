/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * report.java
 *
 * Created on 09-Sep-2019, 16:54:25
 */

/**
 *
 * @author TOSHIBA
 */
import java.sql.*;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

public class report extends javax.swing.JInternalFrame {
    Connection con;
    void opencon(){
        try{
            Class.forName("java.sql.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/xiia1920","root","hello**231**");
            trc.setEditable(false);
        }catch(Exception e){
        JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }

    String rt = "" , fr = "" , to = "";

    void refresh(){
        try{
            String q = "Select cust_id,custinfo.room_no,floor,room_type,id_proof,check_in,check_out,rent_per_day,bill from rinfo,custinfo where rinfo.room_no=custinfo.room_no and bill<>0";
            if(rt.equals("")){
                q+= " and room_type = '" + rt + "'";
            }

//Filter between dates
            if(fr.equals("")&&to.equals("")){
                q+= " and check_out between '" + fr + "' and '" + to + "'";
            }

//Sort
            if(frb.isSelected())
                q+= " order by floor";
            if(rpdrb.isSelected())
                q+= " order by rent_per_day";
            if(rnrb.isSelected())
                q+= " order by room_no";
            if(asc.isSelected())
                q+= " asc";
            if(desc.isSelected())
                q+= " desc";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(q);
            DefaultTableModel dtm=(DefaultTableModel)tbl.getModel();
            while (dtm.getRowCount()>0){
                dtm.removeRow(0);
            }

            String id, r, f, rmt, p, ci, co, rpd,b;
            double sumBill=0.0;
            while (rs.next()) {
                id = rs.getString(1);
                r = rs.getString(2);
                f = rs.getString(3);
                rmt = rs.getString(4);
                p = rs.getString(5);
                ci = rs.getString(6);
                co = rs.getString(7);
                rpd = rs.getString(8);
                b = rs.getString(9);
                sumBill+= Double.parseDouble(b);
                Object nr[] = {id, r, f, rmt, p, ci, co, rpd,b};
                dtm.addRow(nr);
            }
            trc.setText("" + sumBill);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }


    /** Creates new form report */
    public report() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        rmty = new javax.swing.JLabel();
        rtype = new javax.swing.JComboBox();
        date1 = new javax.swing.JLabel();
        show = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        jLabel39 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        rpdrb = new javax.swing.JRadioButton();
        rnrb = new javax.swing.JRadioButton();
        frb = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        asc = new javax.swing.JRadioButton();
        desc = new javax.swing.JRadioButton();
        remove = new javax.swing.JButton();
        fromd = new com.toedter.calendar.JDateChooser();
        tod = new com.toedter.calendar.JDateChooser();
        date2 = new javax.swing.JLabel();
        close = new javax.swing.JButton();
        revenue = new javax.swing.JLabel();
        trc = new javax.swing.JTextField();
        background = new javax.swing.JLabel();

        setResizable(true);
        setTitle("Report");
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
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);

        rmty.setFont(new java.awt.Font("Georgia Pro", 1, 18));
        rmty.setForeground(new java.awt.Color(255, 255, 255));
        rmty.setText("Room Type:");

        rtype.setFont(new java.awt.Font("Tahoma", 1, 14));
        rtype.setForeground(new java.awt.Color(0, 153, 51));
        rtype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Single", "Double", "Studio", "Deluxe", "Suit" }));
        rtype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rtypeActionPerformed(evt);
            }
        });

        date1.setFont(new java.awt.Font("Georgia Pro", 1, 18));
        date1.setForeground(new java.awt.Color(255, 255, 255));
        date1.setText("From:");

        show.setFont(new java.awt.Font("Georgia Pro", 1, 15));
        show.setForeground(new java.awt.Color(0, 0, 255));
        show.setText("Search");
        show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showActionPerformed(evt);
            }
        });

        tbl.setFont(new java.awt.Font("Times New Roman", 0, 14));
        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
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
                "ID", "ROOM NO.", "FLOOR", "ROOM TYPE", "ID PROOF", "CHECK IN", "CHECK OUT", "RENT", "TOTAL BILL"
            }
        ));
        jScrollPane1.setViewportView(tbl);

        jLabel39.setBackground(new java.awt.Color(255, 0, 0));
        jLabel39.setFont(new java.awt.Font("Georgia Pro", 1, 26));
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("HOTEL SKYLINE");
        jLabel39.setOpaque(true);

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
        jLabel6.setForeground(new java.awt.Color(153, 255, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("<html><body><h1><u>Report</u></h1></body></html>");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sort By", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Georgia Pro", 1, 15), new java.awt.Color(255, 255, 204))); // NOI18N
        jPanel2.setOpaque(false);

        rpdrb.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rpdrb);
        rpdrb.setFont(new java.awt.Font("Tahoma", 1, 15));
        rpdrb.setForeground(new java.awt.Color(255, 255, 255));
        rpdrb.setText("Rent Per Day");
        rpdrb.setOpaque(false);
        rpdrb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rpdrbActionPerformed(evt);
            }
        });

        rnrb.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rnrb);
        rnrb.setFont(new java.awt.Font("Tahoma", 1, 15));
        rnrb.setForeground(new java.awt.Color(255, 255, 255));
        rnrb.setText("Room No");
        rnrb.setOpaque(false);
        rnrb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rnrbActionPerformed(evt);
            }
        });

        frb.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(frb);
        frb.setFont(new java.awt.Font("Tahoma", 1, 15));
        frb.setForeground(new java.awt.Color(255, 255, 255));
        frb.setText("Floor");
        frb.setOpaque(false);
        frb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(rnrb)
                .addGap(27, 27, 27)
                .addComponent(rpdrb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(frb)
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(frb)
                    .addComponent(rnrb)
                    .addComponent(rpdrb))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Order", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Georgia Pro", 1, 15), new java.awt.Color(255, 255, 204))); // NOI18N
        jPanel3.setOpaque(false);

        asc.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(asc);
        asc.setFont(new java.awt.Font("Tahoma", 1, 15));
        asc.setForeground(new java.awt.Color(255, 255, 255));
        asc.setText("Ascending");
        asc.setOpaque(false);
        asc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ascActionPerformed(evt);
            }
        });

        desc.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(desc);
        desc.setFont(new java.awt.Font("Tahoma", 1, 15));
        desc.setForeground(new java.awt.Color(255, 255, 255));
        desc.setText("Descending");
        desc.setOpaque(false);
        desc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(asc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(desc)
                .addGap(36, 36, 36))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(desc)
                    .addComponent(asc))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        remove.setFont(new java.awt.Font("Georgia Pro", 1, 15));
        remove.setForeground(new java.awt.Color(0, 0, 255));
        remove.setText("Remove Search Filter");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });

        fromd.setForeground(new java.awt.Color(0, 153, 51));
        fromd.setFont(new java.awt.Font("Tahoma", 1, 14));

        tod.setForeground(new java.awt.Color(0, 153, 51));
        tod.setFont(new java.awt.Font("Tahoma", 1, 14));

        date2.setFont(new java.awt.Font("Georgia Pro", 1, 18));
        date2.setForeground(new java.awt.Color(255, 255, 255));
        date2.setText("To:");

        close.setFont(new java.awt.Font("Georgia Pro", 1, 15));
        close.setForeground(new java.awt.Color(0, 0, 255));
        close.setText("Close");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        revenue.setFont(new java.awt.Font("Georgia Pro", 1, 18));
        revenue.setForeground(new java.awt.Color(255, 255, 255));
        revenue.setText("Total Revenue Collected (₹)");

        trc.setFont(new java.awt.Font("Tahoma", 1, 14));
        trc.setForeground(new java.awt.Color(0, 153, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 1155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(rmty)
                .addGap(34, 34, 34)
                .addComponent(rtype, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(date1)
                .addGap(26, 26, 26)
                .addComponent(fromd, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(date2)
                .addGap(35, 35, 35)
                .addComponent(tod, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(183, 183, 183))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(show, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(remove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(117, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 938, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(516, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(revenue)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(trc, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(201, 201, 201))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(458, 458, 458)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(467, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rtype, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rmty, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(date2)
                        .addComponent(date1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tod, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, Short.MAX_VALUE)
                                .addComponent(fromd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(60, 60, 60)
                            .addComponent(show, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(remove, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(58, 58, 58)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(91, 91, 91)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(trc, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(revenue))
                .addGap(18, 18, 18)
                .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1150, 720);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background2.jpg"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(0, 0, 1230, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
// TODO add your handling code here:
        try {
        opencon();
        rnrb.setSelected(true);
        asc.setSelected(true);
        refresh();
        rnrb.doClick();

//Room type combobox
        rtype.removeAllItems();
        String q = "Select distinct room_type from rinfo";
        Statement stmt = con.createStatement();
        ResultSet rst = stmt.executeQuery(q);
        String s;
        while(rst.next()){
            s = rst.getString(1);
            rtype.addItem(s);
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }//GEN-LAST:event_formInternalFrameOpened

    private void showActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showActionPerformed
// TODO add your handling code here:
        try {
            rt = (String)rtype.getSelectedItem();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
            fr = formatter.format(fromd.getDate());
            to = formatter.format(tod.getDate());
            refresh();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }

    }//GEN-LAST:event_showActionPerformed

    private void rtypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rtypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rtypeActionPerformed

    private void frbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frbActionPerformed
// TODO add your handling code here:
        try{
            refresh();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }//GEN-LAST:event_frbActionPerformed

    private void rpdrbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rpdrbActionPerformed
// TODO add your handling code here:
        try{
            refresh();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
}//GEN-LAST:event_rpdrbActionPerformed

    private void rnrbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rnrbActionPerformed
// TODO add your handling code here:
        try{
            refresh();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }//GEN-LAST:event_rnrbActionPerformed

    private void ascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ascActionPerformed
// TODO add your handling code here:
        try{
            refresh();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }//GEN-LAST:event_ascActionPerformed

    private void descActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descActionPerformed
// TODO add your handling code here:
        try{
            refresh();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }//GEN-LAST:event_descActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
// TODO add your handling code here:
        try{
            rt="";
            fr="";
            to="";
            refresh();
            fromd.setDate(null);
            tod.setDate(null);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
}//GEN-LAST:event_removeActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
// TODO add your handling code here:
        this.dispose();
}//GEN-LAST:event_closeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton asc;
    private javax.swing.JLabel background;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton close;
    private javax.swing.JLabel date1;
    private javax.swing.JLabel date2;
    private javax.swing.JRadioButton desc;
    private javax.swing.JRadioButton frb;
    private com.toedter.calendar.JDateChooser fromd;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton remove;
    private javax.swing.JLabel revenue;
    private javax.swing.JLabel rmty;
    private javax.swing.JRadioButton rnrb;
    private javax.swing.JRadioButton rpdrb;
    private javax.swing.JComboBox rtype;
    private javax.swing.JButton show;
    private javax.swing.JTable tbl;
    private com.toedter.calendar.JDateChooser tod;
    private javax.swing.JTextField trc;
    // End of variables declaration//GEN-END:variables

}
