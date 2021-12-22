package ManagerInfrastructure;

import MembersManager.Members;//import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public final class GuiManager extends javax.swing.JFrame {

    private List<Infras> listInfras = new ArrayList<> ();
    private List<InfrasQuality> listQuality = new ArrayList<> ();

    private DefaultTableModel tblModel;
    private DefaultTableModel tblModel2;
    private final List<Infras> list = new ArrayList<>();

    public GuiManager() throws SQLException {
        initComponents();
        setTitle("Quản Lý Cơ sở vật chất");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initTable();
        initData();
    }

    public void initTable() throws SQLException{
        tblInfras.getTableHeader().setBackground(Color.WHITE);
        tblInfras.getTableHeader().setFont(new Font("Tohama",Font.PLAIN,12));
        tblModel = new DefaultTableModel();
        String[] cols = new String[]{"STT","Tên","Số lượng","Hãng nhập","Vị trí","Ngày nhập","Bảo hiểm"};
        tblModel.setColumnIdentifiers(cols);
        tblInfras.setModel(tblModel);
        initData();
        fillTable();


        tblQuality.getTableHeader().setBackground(Color.WHITE);
        tblQuality.getTableHeader().setFont(new Font("Tohama",Font.PLAIN,12));
        tblModel2 = new DefaultTableModel();
        String[] cols2 = new String[]{"STT","Tên","Số lượng","Chất lượng","Trạng thái"};
        tblModel2.setColumnIdentifiers(cols2);
        tblQuality.setModel(tblModel2);
        listQuality.add(new InfrasQuality("Ban",12,"Moi","Cho muon"));
        fillTable2();
    }

    public void initData() throws SQLException{
        String sql = "SELECT * FROM ktpm.infras";
        String url = "jdbc:mysql://localhost:3306/ktpm";
        Connection con = DriverManager.getConnection(url,"root","Hoanghuuphuc1415");

        try{
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            Infras infras;
            while(rs.next()){
                infras = new Infras(rs.getString("name"), Integer.valueOf(rs.getInt("count")), rs.getString("importFrom"), rs.getString("location"), rs.getString("dateImport"), rs.getString("insurance"));
                list.add(infras);
            }

        } catch (SQLException ex){
        }
    }

    public void resetText(){
        nameTxt.setText("");
        countTxt.setText("");
        locationTxt.setText("");
        importFirmTxt.setText("");
        dateImportTxt.setText("");
        insuranceTxt.setText("");
    }

    public void fillTable(){
        int n = 0;
        while(tblModel.getRowCount() > 0)
            tblModel.removeRow(0);

        for(Infras infras : list){
            tblModel.addRow(new String[]{String.valueOf(++n),infras.getName(),String.valueOf(infras.getCount()),infras.getImportFirm()
                    ,infras.getLocation(),infras.getDateImport(),infras.getInsurance()});
        }

        tblModel.fireTableDataChanged();
    }

    public void fillTable2(){
        int n = 0;
        while(tblModel2.getRowCount() > 0)
            tblModel2.removeRow(0);

        for(InfrasQuality infras : listQuality){
            tblModel2.addRow(new String[]{String.valueOf(++n),infras.getName(),String.valueOf(infras.getCount()),infras.getQuality()
                    ,infras.getState()});
        }
        tblModel2.fireTableDataChanged();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInfras = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblQuality = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        nameTxt = new javax.swing.JTextField();
        name1 = new javax.swing.JLabel();
        countTxt = new javax.swing.JTextField();
        name2 = new javax.swing.JLabel();
        importFirmTxt = new javax.swing.JTextField();
        name3 = new javax.swing.JLabel();
        locationTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        dateImportTxt = new javax.swing.JTextField();
        btAdd = new javax.swing.JButton();
        btUpdate = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        btFind = new javax.swing.JButton();
        insuranceTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Clear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        firstImage = new javax.swing.JLabel(){
            ImageIcon icon = new ImageIcon("QuanlyNhaVanHoa/Picture/ban-ghe-tiec-2.jpg");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }

        };

        secondImage = new javax.swing.JLabel(){
            ImageIcon icon = new ImageIcon("QuanlyNhaVanHoa/Picture/chari.jpeg");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }

        };
        thirdImage = new javax.swing.JLabel(){
            ImageIcon icon = new ImageIcon("P:\\Projects\\QuanLyNhaVanHoa\\QuanlyNhaVanHoa\\Picture\\images.jpg");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }

        };

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(firstImage, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                        .addComponent(secondImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(thirdImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(firstImage, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(secondImage, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(thirdImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(14, 14, 14))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 255));
        jLabel3.setText("QUẢN LÝ CƠ SỞ VẬT CHẤT");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(231, 231, 231))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tblInfras.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblInfras);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Thêm thông tin", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        tblQuality.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblQuality);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Trạng thái", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        name.setText("Tên: ");

        nameTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        name1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        name1.setText("Số lượng:");

        countTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        name2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        name2.setText("Hãng nhập:");

        importFirmTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        name3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        name3.setText("Vị trí: ");

        locationTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Ngày nhập: ");

        dateImportTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btAdd.setBackground(new java.awt.Color(0, 153, 255));
        btAdd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btAdd.setForeground(new java.awt.Color(255, 255, 255));
        btAdd.setText("Thêm");
        btAdd.setBorder(null);
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        btUpdate.setBackground(new java.awt.Color(0, 153, 255));
        btUpdate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btUpdate.setText("Sửa");
        btUpdate.setBorder(null);
        btUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateActionPerformed(evt);
            }
        });

        btDelete.setBackground(new java.awt.Color(0, 153, 255));
        btDelete.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btDelete.setForeground(new java.awt.Color(255, 255, 255));
        btDelete.setText("Xóa");
        btDelete.setBorder(null);
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        btFind.setBackground(new java.awt.Color(0, 153, 255));
        btFind.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btFind.setForeground(new java.awt.Color(255, 255, 255));
        btFind.setText("Tìm kiếm");
        btFind.setBorder(null);
        btFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFindActionPerformed(evt);
            }
        });

        insuranceTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Bảo hành: ");

        Clear.setBackground(new java.awt.Color(0, 153, 255));
        Clear.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Clear.setForeground(new java.awt.Color(255, 255, 255));
        Clear.setText("Clear");
        Clear.setBorder(null);
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(name3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(name2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(countTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                                        .addComponent(importFirmTxt)
                                                        .addComponent(locationTxt))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(name1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(39, 39, 39)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(dateImportTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(insuranceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(Clear, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                        .addComponent(btAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btFind, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel1)
                                                .addComponent(dateImportTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                                        .addComponent(btAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(insuranceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(name1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(countTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(btUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(name2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(importFirmTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(name3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(locationTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btFind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTabbedPane1)
                                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))
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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {

    }

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {
        String name = nameTxt.getText();
        String count = countTxt.getText();
        StringBuilder sb = new StringBuilder();

        if(name.equals(""))
            sb.append("Name is empty");
        else if(count.equals(""))
            sb.append("Count is empty");

        if(sb.length() > 0)
            JOptionPane.showMessageDialog(this, sb.toString(),"Tên trống",JOptionPane.ERROR_MESSAGE);
        else{
            int choose = JOptionPane.showConfirmDialog(this, "Bạn muốn thêm "+name+" vào danh sách không?","",JOptionPane.YES_NO_OPTION);
            if(choose == JOptionPane.YES_OPTION){

                try {
                    sql.insertInfras(name, Integer.valueOf(count), importFirmTxt.getText(), locationTxt.getText(), dateImportTxt.getText(), insuranceTxt.getText());
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(GuiManager.class.getName()).log(Level.SEVERE, null, ex);
                }

                list.add(new Infras(name, Integer.valueOf(count), importFirmTxt.getText(), locationTxt.getText(), dateImportTxt.getText(), insuranceTxt.getText()));
                listQuality.add(new InfrasQuality(name, Integer.valueOf(count), "Tot", "San sang"));
            }
            fillTable();
            fillTable2();
        }
    }

    private void btUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        String name = nameTxt.getText();
        StringBuilder sb = new StringBuilder();
        if(sb.length() > 0)
            JOptionPane.showMessageDialog(this, sb.toString(),"Tên trống",JOptionPane.ERROR_MESSAGE);
        else{
            int choose = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa dữ liệu của "+name+" không?","",JOptionPane.YES_NO_OPTION);
            if(choose == JOptionPane.YES_OPTION){
                for(Infras i:list){
                    if(i.getName().equals(name)){
                        if(!countTxt.getText().isEmpty()){
                            i.setCount(Integer.valueOf(countTxt.getText()));
                            try {
                                sql.updateInfras(name, Integer.valueOf(countTxt.getText()), i.getImportFirm(), i.getLocation(), i.getDateImport(), i.getInsurance());
                            } catch (ClassNotFoundException | SQLException ex) {
                                Logger.getLogger(GuiManager.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            for(InfrasQuality q: listQuality){
                                if(q.getName().equals(name)){
                                    q.setCount(Integer.valueOf(countTxt.getText()));
                                    break;
                                }
                            }
                        }
                        if(!locationTxt.getText().isEmpty()){

                            try {
                                sql.updateInfras(name, i.getCount(), importFirmTxt.getText(), i.getLocation(), i.getDateImport(), i.getInsurance());
                            } catch (ClassNotFoundException | SQLException ex) {
                                Logger.getLogger(GuiManager.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            i.setLocation(locationTxt.getText());
                        }
                        if(!importFirmTxt.getText().isEmpty()){

                            try {
                                sql.updateInfras(name, i.getCount(), i.getImportFirm(), locationTxt.getText(), i.getDateImport(), i.getInsurance());
                            } catch (ClassNotFoundException | SQLException ex) {
                                Logger.getLogger(GuiManager.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            i.setImportFirm(importFirmTxt.getText());
                        }
                        if(!dateImportTxt.getText().isEmpty()){

                            try {
                                sql.updateInfras(name, i.getCount(), i.getImportFirm(), i.getLocation(), dateImportTxt.getText(), i.getInsurance());
                            } catch (ClassNotFoundException | SQLException ex) {
                                Logger.getLogger(GuiManager.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            i.setDateImport(dateImportTxt.getText());
                        }
                        if(!insuranceTxt.getText().isEmpty()){

                            try {
                                sql.updateInfras(name, i.getCount(), i.getImportFirm(), i.getLocation(), i.getDateImport(), insuranceTxt.getText());
                            } catch (ClassNotFoundException | SQLException ex) {
                                Logger.getLogger(GuiManager.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            i.setInsurance(insuranceTxt.getText());
                        }
                        fillTable2();
                        fillTable();
                        return;
                    }
                }
                JOptionPane.showMessageDialog(this, "Tên không tồn tại trong danh sách");
            }
            fillTable();
        }

    }

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        String name = nameTxt.getText();

        StringBuilder sb = new StringBuilder();
        if(name.equals(""))
            sb.append("Tên trống");

        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb.toString());
        }else {
            for(Infras i: list){
                if(i.getName().equals(name)){
                    int choose = JOptionPane.showConfirmDialog(this,"Bạn có muốn xóa không?","",JOptionPane.YES_NO_OPTION);
                    if(choose == JOptionPane.YES_OPTION){
                        list.remove(i);
                        for(InfrasQuality q: listQuality){
                            if(q.getName().equals(name)){

                                try {
                                    sql.deleteInfras(name);
                                } catch (SQLException | ClassNotFoundException ex) {
                                    Logger.getLogger(GuiManager.class.getName()).log(Level.SEVERE, null, ex);
                                }

                                listQuality.remove(q);
                                break;
                            }
                        }
                        fillTable2();
                        fillTable();
                        return;
                    }
                }
            }
            JOptionPane.showMessageDialog(this, "Tên không tồn tại trong danh sách");
        }
    }

    private void btFindActionPerformed(java.awt.event.ActionEvent evt) {
        String name = nameTxt.getText();
        StringBuilder sb = new StringBuilder();

        if(name.equals(""))
            sb.append("Name is empty");

        if(sb.length() > 0)
            JOptionPane.showMessageDialog(this, sb.toString(),"Ten trong",JOptionPane.ERROR_MESSAGE);
        else{
            for(Infras i: list){
                if(i.getName().equals(name)){
                    nameTxt.setText(i.getName());
                    countTxt.setText(String.valueOf(i.getCount()));
                    locationTxt.setText(i.getLocation());
                    importFirmTxt.setText(i.getImportFirm());
                    dateImportTxt.setText(i.getDateImport());
                    insuranceTxt.setText(i.getInsurance());
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Tên không tồn tại trong danh sách");

        }
    }

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {
        resetText();
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
            java.util.logging.Logger.getLogger(GuiManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GuiManager().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(GuiManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton Clear;
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btFind;
    private javax.swing.JButton btUpdate;
    private javax.swing.JTextField countTxt;
    private javax.swing.JTextField dateImportTxt;
    private javax.swing.JTextField importFirmTxt;
    private javax.swing.JTextField insuranceTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField locationTxt;
    private javax.swing.JLabel name;
    private javax.swing.JLabel name1;
    private javax.swing.JLabel name2;
    private javax.swing.JLabel name3;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JTable tblInfras;
    private javax.swing.JTable tblQuality;
    private javax.swing.JLabel secondImage;
    private javax.swing.JLabel thirdImage;
    private javax.swing.JLabel firstImage;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration
}
