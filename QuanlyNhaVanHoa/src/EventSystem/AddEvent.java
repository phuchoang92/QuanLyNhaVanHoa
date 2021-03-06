
package EventSystem;

import ManagerInfrastructure.GuiManager;
import ManagerInfrastructure.Infras;
import ManagerInfrastructure.InfrasQuality;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AddEvent extends javax.swing.JFrame {

    private DefaultTableModel tblModel;
    private List<Event> list = new ArrayList<>();

    public AddEvent() throws SQLException {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initTable();
        initData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        eventTable1 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        addButton = new javax.swing.JButton();
        fixButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        eventNameTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        hostNameTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        startTimeTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        endTimeTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        feeTF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Qu???n L?? S??? Ki???n");

        eventTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane1.setViewportView(eventTable1);

        addButton.setBackground(new java.awt.Color(0, 153, 255));
        addButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Th??m");
        addButton.setBorder(null);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    addButtonActionPerformed(evt);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        fixButton.setBackground(new java.awt.Color(0, 153, 255));
        fixButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fixButton.setForeground(new java.awt.Color(255, 255, 255));
        fixButton.setText("S???a");
        fixButton.setBorder(null);

        deleteButton.setBackground(new java.awt.Color(0, 153, 255));
        deleteButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("X??a");
        deleteButton.setBorder(null);

        clearButton.setBackground(new java.awt.Color(0, 153, 255));
        clearButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        clearButton.setForeground(new java.awt.Color(255, 255, 255));
        clearButton.setText("Reset");
        clearButton.setBorder(null);

        eventNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventNameTxtActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("T??n S??? ki???n");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("T??n Ch??? Nh??");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Ng??y b???t ?????u");

        endTimeTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endTimeTFActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Ng??y K???t Th??c");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Ph?? thu??");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("VND");

        feeTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feeTFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(32, 32, 32)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(67, 67, 67)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(hostNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(startTimeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(endTimeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(55, 55, 55)
                                                                .addComponent(fixButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(50, 50, 50)
                                                                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(56, 56, 56)
                                                                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(eventNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(85, 85, 85)
                                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(feeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(98, 98, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(293, 293, 293)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                                        .addComponent(fixButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(eventNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(feeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(hostNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(startTimeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(endTimeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void feeTFActionPerformed(ActionEvent evt) {
    }

    private void endTimeTFActionPerformed(ActionEvent evt) {
    }

    private void eventNameTxtActionPerformed(ActionEvent evt) {
    }


    public void fillTable(){
        int n = 0;
        while(tblModel.getRowCount() > 0)
            tblModel.removeRow(0);

        for(Event event : list){
            tblModel.addRow(new String[]{String.valueOf(++n),event.getName(), event.getHostName(), event.getStartTime(), event.getEndTime(), String.valueOf(event.getFee())});
        }
        tblModel.fireTableDataChanged();
    }

    public void initData() throws SQLException {

        String sql = "SELECT * FROM ktpm.events";
        String url = "jdbc:mysql://localhost:3306/ktpm";
        Connection con = DriverManager.getConnection(url,"root","Hoanghuuphuc1415");

        try{
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            Event event;
            while(rs.next()){
                event = new Event(rs.getString("name"), rs.getString("hostname"), rs.getString("startTime"), rs.getString("endTime"),rs.getInt("fee"));
                list.add(event);
            }

        } catch (SQLException ex){
        }
    }

    public void initTable() throws SQLException{

        eventTable1.getTableHeader().setBackground(Color.WHITE);
        eventTable1.getTableHeader().setFont(new Font("Tohama",Font.PLAIN,12));
        tblModel = new DefaultTableModel();
        String[] cols = new String[]{"STT", "T??n S??? Ki???n", "T??n ch??? tr??", "Th???i gian b???t ?????u", "Th???i gian K???t Th??c", "Chi Ph??"};
        tblModel.setColumnIdentifiers(cols);
        eventTable1.setModel(tblModel);
        fillTable();

    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) throws SQLException, ClassNotFoundException {
        String name = eventNameTxt.getText();
        StringBuilder sb = new StringBuilder();

        if(name.equals(""))
            sb.append("Name is empty");

        if(sb.length() > 0)
            JOptionPane.showMessageDialog(this, sb.toString(),"T??n tr???ng",JOptionPane.ERROR_MESSAGE);
        else{
            int choose = JOptionPane.showConfirmDialog(this, "B???n mu???n th??m "+name+" v??o danh s??ch kh??ng?","",JOptionPane.YES_NO_OPTION);
            if(choose == JOptionPane.YES_OPTION){
                sql.insertEvent(name, hostNameTxt.getText(), startTimeTF.getText(), endTimeTF.getText(), Integer.parseInt(feeTF.getText()));
                list.add(new Event(name, hostNameTxt.getText(),startTimeTF.getText(), endTimeTF.getText(), Integer.parseInt(feeTF.getText())));
            }
            fillTable();
        }
    }

    private void fixButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        String name = eventNameTxt.getText();
        StringBuilder sb = new StringBuilder();
        if(sb.length() > 0)
            JOptionPane.showMessageDialog(this, sb.toString(),"T??n tr???ng",JOptionPane.ERROR_MESSAGE);
        else{
            int choose = JOptionPane.showConfirmDialog(this, "B???n c?? mu???n s???a d??? li???u c???a "+name+" kh??ng?","",JOptionPane.YES_NO_OPTION);
            if(choose == JOptionPane.YES_OPTION){
                for(Event i:list){
                    if(i.getName().equals(name)){
                        if(!hostNameTxt.getText().isEmpty()){

                            try {
                                sql.updateInfras(name, hostNameTxt.getText(), i.getStartTime(), i.getEndTime(), i.getFee());
                            } catch (ClassNotFoundException | SQLException ex) {
                                Logger.getLogger(GuiManager.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            i.setHostName(hostNameTxt.getText());
                        }
                        if(!startTimeTF.getText().isEmpty()){

                            try {
                                sql.updateInfras(name, i.getHostName(), startTimeTF.getText(), i.getEndTime(), i.getFee());
                            } catch (ClassNotFoundException | SQLException ex) {
                                Logger.getLogger(GuiManager.class.getName()).log(Level.SEVERE, null, ex);
                            }

                           i.setStartTime(startTimeTF.getText());
                        }
                        if(!endTimeTF.getText().isEmpty()){

                            try {
                                sql.updateInfras(name, i.getHostName(), i.getStartTime(), endTimeTF.getText(), i.getFee());
                            } catch (ClassNotFoundException | SQLException ex) {
                                Logger.getLogger(GuiManager.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            i.setEndTime(endTimeTF.getText());
                        }
                        if(!feeTF.getText().isEmpty()){

                            try {
                                sql.updateInfras(name, i.getHostName(), i.getStartTime(), i.getEndTime(),Integer.parseInt(feeTF.getText()));
                            } catch (ClassNotFoundException | SQLException ex) {
                                Logger.getLogger(GuiManager.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            i.setFee(Integer.parseInt(feeTF.getText()));
                        }
                        fillTable();
                        return;
                    }
                }
                JOptionPane.showMessageDialog(this, "T??n kh??ng t???n t???i trong danh s??ch");
            }
            fillTable();
        }
    }

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {
        String name = eventNameTxt.getText();

        StringBuilder sb = new StringBuilder();
        if(name.equals(""))
            sb.append("T??n tr???ng");

        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb.toString());
        }else {
            for(Event i: list){
                if(i.getName().equals(name)){
                    int choose = JOptionPane.showConfirmDialog(this,"B???n c?? mu???n x??a kh??ng?","",JOptionPane.YES_NO_OPTION);
                    if(choose == JOptionPane.YES_OPTION){
                        list.remove(i);
                        fillTable();
                        return;
                    }
                }
            }
            JOptionPane.showMessageDialog(this, "T??n kh??ng t???n t???i trong danh s??ch");
        }
    }

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        hostNameTxt.setText("");
        startTimeTF.setText("");
        endTimeTF.setText("");
        eventNameTxt.setText("");
        feeTF.setText("");
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {
        // TODO add your handling code here:
        fillTable();
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AddEvent().setVisible(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton addButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField endTimeTF;
    private javax.swing.JTextField eventNameTxt;
    private javax.swing.JTextField feeTF;
    private javax.swing.JButton fixButton;
    private javax.swing.JTextField hostNameTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable eventTable1;
    private javax.swing.JTextField startTimeTF;
    // End of variables declaration
}
