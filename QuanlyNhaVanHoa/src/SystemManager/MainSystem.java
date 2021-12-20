/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemManager;

import EventSystem.AddEvent;
import EventSystem.GeneralEventSignUp;
import ManagerInfrastructure.GuiManager;
import MembersManager.Members;
import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class MainSystem extends javax.swing.JFrame {

    private DefaultTableModel tblModel;
    private final List<Members> list = new ArrayList<>();

    public MainSystem() throws SQLException {
        initComponents();
        setLocationRelativeTo(null);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Date date = new Date();
                    SimpleDateFormat tf = new SimpleDateFormat("h:mm:ss aa");

                    String time = tf.format(date);
                    txtTime.setText(time.split(" ")[0]);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.err.println(e);
                    }
                }
            }
        }).start();

        initTable();
    }

    public void initTable() throws SQLException{
        tblMembers.getTableHeader().setBackground(Color.WHITE);
        tblMembers.getTableHeader().setFont(new Font("Tohama",Font.BOLD,18));
        tblModel = new DefaultTableModel();
        String[] cols = new String[]{"STT","Tên","Chức vụ","Ngày sinh","Điện thoại"};
        tblModel.setColumnIdentifiers(cols);
        tblMembers.setModel(tblModel);
        initData();
        thanhVien.setText(""+list.size());
        feeBigLabel.setText(""+1000000000);
    }

    public void initData() throws SQLException{
        String sql = "SELECT * FROM ktpm.members";
        String url = "jdbc:mysql://localhost:3306/ktpm";
        Connection con = DriverManager.getConnection(url,"root","Hoanghuuphuc1415");
        try{
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            Members members;
            while(rs.next()){
                String dateOfBirth = rs.getString("dateOfBirth");
                String[] numbersArray = dateOfBirth.split("/");
                members = new Members(rs.getString("name"),rs.getString("job"),
                        Integer.parseInt(numbersArray[0]),Integer.parseInt(numbersArray[1]),Integer.parseInt(numbersArray[2]),rs.getString("phoneNumber"));
                list.add(members);
            }
        } catch (SQLException ignored){
        }
    }

    public void fillTable(){
        int n = 0;
        while(tblModel.getRowCount() > 0)
            tblModel.removeRow(0);

        for(Members staff : list){
            tblModel.addRow(new String[]{String.valueOf(++n),staff.getName(),staff.getJob(),staff.dateOfBirth()
                    ,staff.getPhoneNumber()});
        }

        tblModel.fireTableDataChanged();
    }

    private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    jPanel3 = new javax.swing.JPanel();
    jPanel5 = new javax.swing.JPanel();
    jScrollPane1 = new javax.swing.JScrollPane();
    tblMembers = new javax.swing.JTable();
    jPanel6 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    window = new javax.swing.JButton();
    jLabel2 = new javax.swing.JLabel();
    infrasButton = new javax.swing.JButton();
    jButton3 = new javax.swing.JButton();
    jLabel3 = new javax.swing.JLabel();
    generalEventbutton = new javax.swing.JButton();
    calendarButton = new javax.swing.JButton();
    sortEventButton = new javax.swing.JButton();
    jLabel4 = new javax.swing.JLabel();
    budgetButton = new javax.swing.JButton();
    LogOut = new javax.swing.JButton();
    staffButton = new javax.swing.JButton();
    jPanel7 = new javax.swing.JPanel();
    jLabel5 = new javax.swing.JLabel();
    jSeparator1 = new javax.swing.JSeparator();
    feeBigLabel = new javax.swing.JLabel();
    thanhVien = new javax.swing.JLabel();
    txtTime = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    jLabel9 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    addWindowListener(new java.awt.event.WindowAdapter() {
        public void windowOpened(java.awt.event.WindowEvent evt) {
            formWindowOpened(evt);
        }
    });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );

        tblMembers.setModel(new javax.swing.table.DefaultTableModel(
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
        tblMembers.setRowHeight(24);
        jScrollPane1.setViewportView(tblMembers);

    javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
            );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
            );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("quản  lý nhà văn hóa");

        window.setBackground(new java.awt.Color(255, 255, 255));
        window.setBorder(null);
        window.setContentAreaFilled(false);
        window.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            windowActionPerformed(evt);
        }
    });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setText("Cơ sở vật chất");

        infrasButton.setBackground(new java.awt.Color(255, 255, 255));
        infrasButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        infrasButton.setForeground(new java.awt.Color(102, 204, 255));
        infrasButton.setText("Thông tin chung");
        infrasButton.setBorder(null);
        infrasButton.setContentAreaFilled(false);
        infrasButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            infrasButtonActionPerformed(evt);
        }
    });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(102, 204, 255));
        jButton3.setText("Hiên trạng");
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setDefaultCapable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton3ActionPerformed(evt);
        }
    });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setText("     Sự kiện");

        generalEventbutton.setBackground(new java.awt.Color(255, 255, 255));
        generalEventbutton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        generalEventbutton.setForeground(new java.awt.Color(102, 204, 255));
        generalEventbutton.setText("Các sự kiện chung");
        generalEventbutton.setBorder(null);
        generalEventbutton.setContentAreaFilled(false);
        generalEventbutton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            generalEventbuttonActionPerformed(evt);
        }
    });

        calendarButton.setBackground(new java.awt.Color(255, 255, 255));
        calendarButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        calendarButton.setForeground(new java.awt.Color(102, 204, 255));
        calendarButton.setText("Lịch đăng kí");
        calendarButton.setBorder(null);
        calendarButton.setContentAreaFilled(false);
        calendarButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            calendarButtonActionPerformed(evt);
        }
    });

        sortEventButton.setBackground(new java.awt.Color(255, 255, 255));
        sortEventButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sortEventButton.setForeground(new java.awt.Color(102, 204, 255));
        sortEventButton.setText("Sắp xếp dự phòng");
        sortEventButton.setBorder(null);
        sortEventButton.setContentAreaFilled(false);
        sortEventButton.setDefaultCapable(false);
        sortEventButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            sortEventButtonActionPerformed(evt);
        }
    });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setText("Lựa chọn khác");

        budgetButton.setBackground(new java.awt.Color(255, 255, 255));
        budgetButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        budgetButton.setForeground(new java.awt.Color(51, 204, 255));
        budgetButton.setText("Ngân Quỹ");
        budgetButton.setBorder(null);
        budgetButton.setContentAreaFilled(false);
        budgetButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            budgetButtonActionPerformed(evt);
        }
    });

        LogOut.setBackground(new java.awt.Color(255, 255, 255));
        LogOut.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LogOut.setForeground(new java.awt.Color(0, 0, 204));
        LogOut.setText("Đăng xuất");
        LogOut.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LogOut.setContentAreaFilled(false);
        LogOut.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            LogOutActionPerformed(evt);
        }
    });

        staffButton.setBackground(new java.awt.Color(255, 255, 255));
        staffButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        staffButton.setForeground(new java.awt.Color(51, 204, 255));
        staffButton.setText("Quản lý nhân sự");
        staffButton.setBorder(null);
        staffButton.setContentAreaFilled(false);
        staffButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            staffButtonActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(sortEventButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(window))
            .addComponent(generalEventbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addComponent(infrasButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(budgetButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(staffButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                                .addGap(19, 19, 19)
                                                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                                                                .addGap(27, 27, 27)
                                                                .addComponent(LogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                                                                .addGap(28, 28, 28)
                                                                .addComponent(calendarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(0, 0, Short.MAX_VALUE)))
            .addContainerGap())
            );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addComponent(window))
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(infrasButton)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(generalEventbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(calendarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sortEventButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(staffButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(budgetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(LogOut)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 255));
        jLabel5.setText("Data of Manager");

        jSeparator1.setForeground(new java.awt.Color(255, 51, 51));

        feeBigLabel.setBackground(new java.awt.Color(255, 255, 255));
        feeBigLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        feeBigLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        thanhVien.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        thanhVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtTime.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setForeground(new java.awt.Color(102, 102, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Ngân quỹ");

        jLabel9.setForeground(new java.awt.Color(102, 102, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Thành viên");

        jLabel7.setForeground(new java.awt.Color(102, 102, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Thời gian");

    javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(feeBigLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(90, 90, 90)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                        .addComponent(thanhVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                                .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(45, 45, 45))))
            );
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel7))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addComponent(feeBigLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(5, 5, 5))
            .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addComponent(thanhVien, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                                                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addComponent(txtTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addContainerGap())))
            );

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(0, 28, Short.MAX_VALUE))))
            );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26)
                                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 15, Short.MAX_VALUE))
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
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

    private void generalEventbuttonActionPerformed(ActionEvent evt) {
        try {
            new AddEvent().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(GuiManager.class.getName()).log(Level.SEVERE, null, ex);
        };
    }

    private void budgetButtonActionPerformed(ActionEvent evt) {
    }

    private void staffButtonActionPerformed(ActionEvent evt) {
    }

    private void windowActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void infrasButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            new GuiManager().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(GuiManager.class.getName()).log(Level.SEVERE, null, ex);
        };
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void calendarButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            new GeneralEventSignUp().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(GuiManager.class.getName()).log(Level.SEVERE, null, ex);
        };
    }

    private void sortEventButtonActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {
        fillTable();
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            try {
                new MainSystem().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(MainSystem.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton LogOut;
    private javax.swing.JButton generalEventbutton;
    private javax.swing.JLabel feeBigLabel;
    private javax.swing.JButton infrasButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton calendarButton;
    private javax.swing.JButton sortEventButton;
    private javax.swing.JButton budgetButton;
    private javax.swing.JButton staffButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblMembers;
    private javax.swing.JLabel thanhVien;
    private javax.swing.JLabel txtTime;
    private javax.swing.JButton window;
    // End of variables declaration
}
