package ManagerInfrastructure;

import MembersManager.Members;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class GuiManager extends javax.swing.JFrame {

    private List<Infras> listInfras = new ArrayList<> ();
    private List<InfrasQuality> listQuality = new ArrayList<> ();

    private DefaultTableModel tblModel;
    private DefaultTableModel tblModel2;
    private final List<Infras> list = new ArrayList<>();

    public GuiManager() throws SQLException {
        initComponents();
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
        String url = "jdbc:mysql://localhost:3306/demo-jdbc";
        Connection con = DriverManager.getConnection(url,"root","huy123");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 187, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 43, Short.MAX_VALUE)
        );

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 3, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("tab1", jPanel4);

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
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", jPanel5);

        name.setText("Tên: ");

        name1.setText("Số lượng:");

        name2.setText("Hãng nhập:");

        name3.setText("Vị trí: ");

        jLabel1.setText("Ngày nhập: ");

        btAdd.setText("Thêm");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        btUpdate.setText("Sửa");
        btUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateActionPerformed(evt);
            }
        });

        btDelete.setText("Xóa");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        btFind.setText("Tìm kiếm");
        btFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFindActionPerformed(evt);
            }
        });

        jLabel2.setText("Bảo hành: ");

        Clear.setText("Clear");
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
                                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(23, 23, 23)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(dateImportTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(name1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(countTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(insuranceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(name2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(importFirmTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(name3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(locationTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(Clear, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(btAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btFind, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel1)
                                                .addComponent(dateImportTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btAdd)
                                                .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(insuranceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(name1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(countTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btUpdate)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(name2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(importFirmTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btDelete))
                                .addGap(8, 8, 8)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(locationTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(name3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btFind))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Clear)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                                .addGap(6, 6, 6)
                                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    // End of variables declaration
}
