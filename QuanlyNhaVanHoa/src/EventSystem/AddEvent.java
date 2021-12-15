
package EventSystem;

import ManagerInfrastructure.GuiManager;
import ManagerInfrastructure.Infras;
import ManagerInfrastructure.InfrasQuality;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
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


        setBackground(new java.awt.Color(255, 255, 255));
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản Lý Sự Kiện");

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

        addButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addButton.setText("Thêm");
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

        fixButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fixButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fixButtonActionPerformed(evt);
            }
        });
        fixButton.setText("Sửa");

        deleteButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        deleteButton.setText("Xóa");

        clearButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        clearButton.setText("Reset");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tên Sự kiện");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Tên Chủ Nhà");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Ngày bắt đầu");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Ngày Kết Thúc");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Phí thuê");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("VND");


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
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(268, 268, 268)
                                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                .addGap(98, 98, Short.MAX_VALUE)))
                                .addContainerGap())
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
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(fixButton)
                                        .addComponent(deleteButton)
                                        .addComponent(clearButton)
                                        .addComponent(addButton))
                                .addGap(30, 30, 30)
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
                                .addContainerGap(23, Short.MAX_VALUE))
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
        String[] cols = new String[]{"STT", "Tên Sự Kiện", "Tên chủ trì", "Thời gian bắt đầu", "Thời gian Kết Thúc", "Chi Phí"};
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
            JOptionPane.showMessageDialog(this, sb.toString(),"Tên trống",JOptionPane.ERROR_MESSAGE);
        else{
            int choose = JOptionPane.showConfirmDialog(this, "Bạn muốn thêm "+name+" vào danh sách không?","",JOptionPane.YES_NO_OPTION);
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
            JOptionPane.showMessageDialog(this, sb.toString(),"Tên trống",JOptionPane.ERROR_MESSAGE);
        else{
            int choose = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa dữ liệu của "+name+" không?","",JOptionPane.YES_NO_OPTION);
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
                JOptionPane.showMessageDialog(this, "Tên không tồn tại trong danh sách");
            }
            fillTable();
        }
    }

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {
        String name = eventNameTxt.getText();

        StringBuilder sb = new StringBuilder();
        if(name.equals(""))
            sb.append("Tên trống");

        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb.toString());
        }else {
            for(Event i: list){
                if(i.getName().equals(name)){
                    int choose = JOptionPane.showConfirmDialog(this,"Bạn có muốn xóa không?","",JOptionPane.YES_NO_OPTION);
                    if(choose == JOptionPane.YES_OPTION){
                        list.remove(i);
                        fillTable();
                        return;
                    }
                }
            }
            JOptionPane.showMessageDialog(this, "Tên không tồn tại trong danh sách");
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
