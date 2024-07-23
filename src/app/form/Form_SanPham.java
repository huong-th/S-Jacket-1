/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package app.form;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import app.model.ChatLieu;
import app.model.KieuDang;
import app.model.LopLot;
import app.model.MauSac;
import app.model.Mu;
import app.model.SanPham;
import app.model.Size;
import app.service.ChatLieuService;
import app.service.KieuDangService;
import app.service.LopLotService;
import app.service.MauSacService;
import app.service.MuService;
import app.service.SanPhamService;
import app.service.SizeService;

/**
 *
 * @author dungn
 */
public class Form_SanPham extends javax.swing.JPanel {

    private final SanPhamService sps = new SanPhamService();
    private final ChatLieuService cls = new ChatLieuService();
    private final SizeService ss = new SizeService();
    private final MuService ms = new MuService();
    private final MauSacService mss = new MauSacService();
    private final KieuDangService kds = new KieuDangService();
    private final LopLotService lls = new LopLotService();
    DefaultTableModel tblModel = new DefaultTableModel();

    /**
     * Creates new form Form_SanPham
     */
    public Form_SanPham() {
        initComponents();
        lb.setText("Form sản phẩm ");
        tblSanPham.removeAll();
        tblSanPham.setModel(tblModel);
        String headerSP[] = {
            "STT", "Mã sản phẩm", "Tên sản phẩm", "Trạng thái"
        };
        tblModel.setColumnIdentifiers(headerSP);
        tblModel = (DefaultTableModel) tblSanPham.getModel();
        loadDataSanPham(sps.getAllSanPham());
        rdoHoatDong3.setSelected(true);
//        String text = txtTimKiem.getText();
//        if(rdoSearchHD.isSelected()){
//            loadDataSanPham(sps.getAllSPHD(text));
//        }
//        if(rdoSearchNHD.isSelected()){
//            loadDataSanPham(sps.getAllSPNHD(text));
//        }

    }

    private void loadDataSanPham(ArrayList<SanPham> list) {
        tblModel.setRowCount(0);
        int stt = 1;
        for (SanPham sp : list) {
            tblModel.addRow(new Object[]{
                stt++,
                sp.getMaSP(),
                sp.getTenSP(),
                sp.isTrangThai() ? "Hoạt động" : "Ngưng hoạt động"
            });
        }
    }

    private void loadDataChatLieu(ArrayList<ChatLieu> listCL) {
        tblModel.setRowCount(0);
        int stt = 1;
        for (ChatLieu cl : listCL) {
            tblModel.addRow(new Object[]{
                stt++,
                cl.getMaChatLieu(),
                cl.getTenChatLieu(),
                cl.isTrangThai() ? "Hoạt động" : "Ngưng hoạt động"
            });
        }
    }

    private void loadDataMauSac(ArrayList<MauSac> list) {
        tblModel.setRowCount(0);
        int stt = 1;
        for (MauSac ms : list) {
            tblModel.addRow(new Object[]{
                stt++,
                ms.getMaMauSac(),
                ms.getTenMauSac(),
                ms.isTrangThai() ? "Hoạt động" : "Ngưng hoạt động"
            });
        }
    }

    private void loadDataKieuDang(ArrayList<KieuDang> list) {
        tblModel.setRowCount(0);
        int stt = 1;
        for (KieuDang kd : list) {
            tblModel.addRow(new Object[]{
                stt++,
                kd.getMaKieuDang(),
                kd.getTenKieuDang(),
                kd.isTrangThai() ? "Hoạt động" : "Ngưng hoạt động"
            });
        }
    }

    private void loadDataLopLot(ArrayList<LopLot> list) {
        tblModel.setRowCount(0);
        int stt = 1;
        for (LopLot ll : list) {
            tblModel.addRow(new Object[]{
                stt++,
                ll.getMaLopLot(),
                ll.getTenLopLot(),
                ll.isTrangThai() ? "Hoạt động" : "Ngưng hoạt động"
            });
        }
    }

    private void loadDataMu(ArrayList<Mu> list) {
        tblModel.setRowCount(0);
        int stt = 1;
        for (Mu m : list) {
            tblModel.addRow(new Object[]{
                stt++,
                m.getMaMu(),
                m.getTenMu(),
                m.isTrangThai() ? "Hoạt động" : "Ngưng hoạt động"
            });
        }
    }

    private void loadDataSize(ArrayList<Size> list) {
        tblModel.setRowCount(0);
        int stt = 1;
        for (Size s : list) {
            tblModel.addRow(new Object[]{
                stt++,
                s.getMaSize(),
                s.getTenSize(),
                s.isTrangThai() ? "Hoạt động" : "Ngưng hoạt động"
            });
        }
    }

    private void showDetailSP() {
        int index = tblSanPham.getSelectedRow();
        txtMaSanPham3.setText(tblModel.getValueAt(index, 1).toString());
        txtTenSanPham3.setText(tblModel.getValueAt(index, 2).toString());
        boolean tt = tblModel.getValueAt(index, 3).toString().equalsIgnoreCase("Hoạt động") ? true : false;
        rdoHoatDong3.setSelected(tt);
        rdoNgungHoatDong3.setSelected(!tt);
    }

    private void showDetailTT() {
        int index = tblThuocTinh.getSelectedRow();
        txtMaThuocTinh.setText(tblModel.getValueAt(index, 1).toString());
        txtTenThuocTinh.setText(tblModel.getValueAt(index, 2).toString());
        boolean tt = tblModel.getValueAt(index, 3).toString().equalsIgnoreCase("Hoạt động") ? true : false;
        rdoHDTT.setSelected(tt);
        rdoNHDTT.setSelected(!tt);
    }

    private SanPham getSPFormInput() {
        SanPham sp = new SanPham();
        sp.setMaSP(txtMaSanPham3.getText());
        sp.setTenSP(txtTenSanPham3.getText());
        sp.setTrangThai(rdoHoatDong3.isSelected() ? true : false);
        return sp;
    }

    private MauSac getMSFormInput() {
        MauSac ms = new MauSac();
        ms.setMaMauSac(txtMaThuocTinh.getText());
        ms.setTenMauSac(txtTenThuocTinh.getText());
        ms.setTrangThai(rdoHDTT.isSelected() ? true : false);
        return ms;
    }

    private Size getSizeFormInput() {
        Size s = new Size();
        s.setMaSize(txtMaThuocTinh.getText());
        s.setTenSize(txtTenThuocTinh.getText());
        s.setTrangThai(rdoHDTT.isSelected() ? true : false);
        return s;
    }

    private ChatLieu getCLFormInput() {
        ChatLieu cl = new ChatLieu();
        cl.setMaChatLieu(txtMaThuocTinh.getText());
        cl.setTenChatLieu(txtTenThuocTinh.getText());
        cl.setTrangThai(rdoHDTT.isSelected() ? true : false);
        return cl;
    }

    private Mu getMuFormInput() {
        Mu m = new Mu();
        m.setMaMu(txtMaThuocTinh.getText());
        m.setTenMu(txtTenThuocTinh.getText());
        m.setTrangThai(rdoHDTT.isSelected() ? true : false);
        return m;
    }

    private LopLot getLLFormInput() {
        LopLot ll = new LopLot();
        ll.setMaLopLot(txtMaThuocTinh.getText());
        ll.setTenLopLot(txtTenThuocTinh.getText());
        ll.setTrangThai(rdoHDTT.isSelected() ? true : false);
        return ll;
    }

    private KieuDang getKDFormInput() {
        KieuDang kd = new KieuDang();
        kd.setMaKieuDang(txtMaThuocTinh.getText());
        kd.setTenKieuDang(txtTenThuocTinh.getText());
        kd.setTrangThai(rdoHDTT.isSelected() ? true : false);
        return kd;
    }

    private void clearFormSP() {
        txtMaSanPham3.setText("");
        txtTenSanPham3.setText("");
        rdoHoatDong3.setSelected(true);
        rdoNgungHoatDong3.setSelected(false);
    }

    private void clearFormTT() {
        txtMaThuocTinh.setText("");
        txtTenThuocTinh.setText("");
        rdoHDTT.setSelected(true);
        rdoNHDTT.setSelected(false);
    }

    private boolean validateSP() {
        if (txtMaSanPham3.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Mã sản phẩm không được để trống");
            return false;
        }
        if (txtTenSanPham3.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Tên sản phẩm không được để trống");
            return false;
        }
        return true;
    }

    private boolean validateTT() {
        if (txtMaThuocTinh.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Mã thuộc tính không được để trống");
            return false;
        }
        if (txtTenThuocTinh.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Tên thuộc tính không được để trống");
            return false;
        }
        return true;
    }

    private boolean checkTrungMaSP(String maSP) {
        for (int i = 0; i < tblSanPham.getRowCount() - 1; i++) {
            if (tblSanPham.getValueAt(i, 1).toString().equalsIgnoreCase(maSP)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkTrungMaTT(String maTT) {
        for (int i = 0; i < tblThuocTinh.getRowCount() - 1; i++) {
            if (tblSanPham.getValueAt(i, 1).toString().equalsIgnoreCase(maTT)) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        lb = new javax.swing.JLabel();
        pnTong = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtTenSanPham3 = new javax.swing.JTextField();
        txtMaSanPham3 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        rdoHoatDong3 = new javax.swing.JRadioButton();
        rdoNgungHoatDong3 = new javax.swing.JRadioButton();
        jPanel12 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnCTSP = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        btnLast = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnFert = new javax.swing.JButton();
        rdoSearchHD = new javax.swing.JRadioButton();
        rdoSearchNHD = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        tfMaSpct = new javax.swing.JTextField();
        tfSoLuong = new javax.swing.JTextField();
        tfGia = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        taMoTa = new javax.swing.JTextArea();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        cbbMu = new javax.swing.JComboBox<>();
        cbbSize = new javax.swing.JComboBox<>();
        cbbMauSac = new javax.swing.JComboBox<>();
        cbbChatLieu = new javax.swing.JComboBox<>();
        jPanel15 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        cbbTenSanPham = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        tfTimKiemSpct = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbSanPhamChiTiet = new javax.swing.JTable();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        lbTrangSpct = new javax.swing.JLabel();
        lbSoTrangSpct = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnAddTT = new javax.swing.JButton();
        btnUpdateTT = new javax.swing.JButton();
        btnNewTT = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        rdoSize = new javax.swing.JRadioButton();
        rdoMauSac = new javax.swing.JRadioButton();
        rdoChatLieu = new javax.swing.JRadioButton();
        rdoMu = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rdoLopLot = new javax.swing.JRadioButton();
        rdoKieuDang = new javax.swing.JRadioButton();
        jPanel20 = new javax.swing.JPanel();
        lblMaThuocTinh = new javax.swing.JLabel();
        lblTenThuocTinh = new javax.swing.JLabel();
        txtMaThuocTinh = new javax.swing.JTextField();
        txtTenThuocTinh = new javax.swing.JTextField();
        rdoHDTT = new javax.swing.JRadioButton();
        rdoNHDTT = new javax.swing.JRadioButton();
        lblTenThuocTinh1 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblThuocTinh = new javax.swing.JTable();

        lb.setFont(new java.awt.Font("sansserif", 1, 48)); // NOI18N
        lb.setForeground(new java.awt.Color(125, 125, 125));
        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("Form");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(1014, 600));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin Sản Phẩm"));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setText("Mã Sản Phẩm");

        jLabel12.setText("Tên Sản Phẩm");

        jLabel20.setText("Trạng thái");

        buttonGroup1.add(rdoHoatDong3);
        rdoHoatDong3.setText("Hoạt động");

        buttonGroup1.add(rdoNgungHoatDong3);
        rdoNgungHoatDong3.setText("Ngưng hoạt động");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaSanPham3, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel20))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(rdoHoatDong3)
                                .addGap(54, 54, 54)
                                .addComponent(rdoNgungHoatDong3))
                            .addComponent(txtTenSanPham3, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtMaSanPham3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtTenSanPham3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(rdoHoatDong3)
                    .addComponent(rdoNgungHoatDong3))
                .addGap(33, 33, 33))
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnCTSP.setText("Chi Tiết Sản Phẩm");
        btnCTSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCTSPActionPerformed(evt);
            }
        });

        btnNew.setText("Làm mới");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCTSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCTSP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNew)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Dạnh Sách Sản Phẩm"));

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyTyped(evt);
            }
        });

        jLabel13.setText("Tìm Kiếm");

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Sản Phẩm", "Tên Sản Phẩm", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        btnLast.setText("<<");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnPrev.setText("<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setText(">");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnFert.setText(">>");
        btnFert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFertActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdoSearchHD);
        rdoSearchHD.setText("Hoạt động");
        rdoSearchHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoSearchHDMouseClicked(evt);
            }
        });
        rdoSearchHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoSearchHDActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdoSearchNHD);
        rdoSearchNHD.setText("Ngừng hoạt động");
        rdoSearchNHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoSearchNHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 886, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(155, 155, 155)
                                .addComponent(rdoSearchHD)
                                .addGap(65, 65, 65)
                                .addComponent(rdoSearchNHD))))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFert, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(rdoSearchHD)
                    .addComponent(rdoSearchNHD))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLast)
                    .addComponent(btnPrev)
                    .addComponent(btnNext)
                    .addComponent(btnFert))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(243, Short.MAX_VALUE))
        );

        pnTong.addTab("Sản Phẩm", jPanel5);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin Sản Phẩm"));

        jLabel14.setText("Mã SP");

        jLabel15.setText("Tên SP");

        jLabel16.setText("Số Lượng");

        jLabel21.setText("Giá");

        jLabel22.setText("Mô Tả");

        tfMaSpct.setEnabled(false);

        taMoTa.setColumns(20);
        taMoTa.setRows(5);
        jScrollPane2.setViewportView(taMoTa);

        jLabel23.setText("Size");

        jLabel24.setText("Màu Sắc");

        jLabel25.setText("Chất Liệu");

        jLabel26.setText("Lớp lót");

        cbbMu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lông thỏ", "Lông vũ", "Lông thường", "Lông cừu" }));

        cbbSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "M", "L", "Xl", "XXL" }));

        cbbMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đen", "Be", "Trắng", "Xanh", "Đỏ", "Vàng", "Tím" }));

        cbbChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cotton", "Kaki", "Jean", "Len", "Nilon" }));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton2.setText("Thêm Sản Phẩm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cập Nhật Sản Phẩm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Làm Mới");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Quay Lại Sản Phẩm");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addGap(28, 28, 28)
                .addComponent(jButton3)
                .addGap(26, 26, 26)
                .addComponent(jButton4)
                .addGap(34, 34, 34)
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cbbTenSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton6.setText("+");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("+");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton13.setText("+");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("+");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22))
                .addGap(26, 26, 26)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                    .addComponent(tfGia)
                    .addComponent(tfSoLuong)
                    .addComponent(tfMaSpct)
                    .addComponent(cbbTenSanPham, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(65, 65, 65)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jLabel23)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cbbMu, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbChatLieu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6)
                    .addComponent(jButton7)
                    .addComponent(jButton13)
                    .addComponent(jButton14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(tfMaSpct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23)
                            .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6))
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(cbbTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel24)
                                    .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton7))))
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(tfSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel25)
                                    .addComponent(cbbChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton13))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21)
                                    .addComponent(tfGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbbMu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26)
                                    .addComponent(jButton14)))))
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder("Dạnh Sách Sản Phẩm"));

        tfTimKiemSpct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTimKiemSpctActionPerformed(evt);
            }
        });
        tfTimKiemSpct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfTimKiemSpctKeyTyped(evt);
            }
        });

        jLabel27.setText("Tìm Kiếm");

        tbSanPhamChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "MASP", "TENSP", "MAUSAC", "CHATLIEU", "LOP LOT", "SOLUONG", "SIZE", "GIA", "MOTA", "TRANGTHAI"
            }
        ));
        tbSanPhamChiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSanPhamChiTietMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbSanPhamChiTiet);

        jButton15.setText("<<");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("<");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setText(">");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setText(">>");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        lbTrangSpct.setText("jLabel3");

        lbSoTrangSpct.setText("jLabel4");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 887, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(18, 18, 18)
                                .addComponent(tfTimKiemSpct, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbTrangSpct)
                        .addGap(18, 18, 18)
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(lbSoTrangSpct)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTimKiemSpct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton15)
                    .addComponent(jButton16)
                    .addComponent(lbTrangSpct)
                    .addComponent(jButton17)
                    .addComponent(jButton18)
                    .addComponent(lbSoTrangSpct))
                .addContainerGap(176, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 40, Short.MAX_VALUE))
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnTong.addTab("Sản Phẩm Chi Tiết", jPanel7);

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder("Thiết Lập Thuộc Tính"));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnAddTT.setText("Thêm");
        btnAddTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTTActionPerformed(evt);
            }
        });

        btnUpdateTT.setText("Sửa");
        btnUpdateTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateTTActionPerformed(evt);
            }
        });

        btnNewTT.setText("Làm mới");
        btnNewTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewTTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNewTT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddTT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdateTT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnAddTT)
                .addGap(27, 27, 27)
                .addComponent(btnUpdateTT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(btnNewTT)
                .addGap(25, 25, 25))
        );

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel28.setText("Size");

        jLabel29.setText("Màu Sắc");

        jLabel30.setText("Chất Liệu");
        jLabel30.setToolTipText("");

        jLabel31.setText("Mũ");

        buttonGroup3.add(rdoSize);
        rdoSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoSizeActionPerformed(evt);
            }
        });

        buttonGroup3.add(rdoMauSac);
        rdoMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoMauSacActionPerformed(evt);
            }
        });

        buttonGroup3.add(rdoChatLieu);
        rdoChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoChatLieuActionPerformed(evt);
            }
        });

        buttonGroup3.add(rdoMu);
        rdoMu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoMuActionPerformed(evt);
            }
        });

        jLabel1.setText("Lớp lót");

        jLabel2.setText("Kiểu dáng");

        buttonGroup3.add(rdoLopLot);
        rdoLopLot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoLopLotActionPerformed(evt);
            }
        });

        buttonGroup3.add(rdoKieuDang);
        rdoKieuDang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoKieuDangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel29))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdoLopLot)
                            .addComponent(rdoSize)
                            .addComponent(rdoMauSac))))
                .addGap(37, 37, 37)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdoKieuDang)
                    .addComponent(rdoMu)
                    .addComponent(rdoChatLieu))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(jLabel30)
                    .addComponent(rdoSize)
                    .addComponent(rdoChatLieu))
                .addGap(31, 31, 31)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdoMauSac)
                    .addComponent(jLabel29)
                    .addComponent(jLabel31)
                    .addComponent(rdoMu))
                .addGap(30, 30, 30)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addComponent(rdoLopLot)
                    .addComponent(rdoKieuDang))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblMaThuocTinh.setText("Mã Thuộc Tính");

        lblTenThuocTinh.setText("Tên Thuộc Tính");

        txtTenThuocTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenThuocTinhActionPerformed(evt);
            }
        });

        buttonGroup4.add(rdoHDTT);
        rdoHDTT.setSelected(true);
        rdoHDTT.setText("Hoạt động");

        buttonGroup4.add(rdoNHDTT);
        rdoNHDTT.setText("Ngừng hoạt động");

        lblTenThuocTinh1.setText("Trạng thái");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMaThuocTinh)
                    .addComponent(lblTenThuocTinh)
                    .addComponent(lblTenThuocTinh1))
                .addGap(42, 42, 42)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(rdoHDTT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoNHDTT)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtMaThuocTinh)
                    .addComponent(txtTenThuocTinh))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaThuocTinh)
                    .addComponent(txtMaThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTenThuocTinh))
                .addGap(24, 24, 24)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenThuocTinh1)
                    .addComponent(rdoHDTT)
                    .addComponent(rdoNHDTT))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh Sách Thuộc Tính"));

        tblThuocTinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Mã Thuộc TÍnh", "Tên Thuộc Tính"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblThuocTinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThuocTinhMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblThuocTinh);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 877, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 191, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        pnTong.addTab("Thuộc Tính Sản Phẩm", jPanel17);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1038, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnTong)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 843, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnTong)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (validateSP()) {
            try {
                SanPham sp = getSPFormInput();
                if (checkTrungMaSP(sp.getMaSP()) == false) {
                    JOptionPane.showMessageDialog(this, "Mã sản phẩm đã tồn tại");
                    return;
                } else {
                    if (sps.addSanPham(sp) != null) {
                        JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công");
                        System.out.println("Thêm thành công");
                        ArrayList<SanPham> allSanPham = sps.getAllSanPham();
                        allSanPham.add(0, sp); // Thêm phần tử mới vào đầu danh sách
                        // Tải lại dữ liệu vào bảng
                        loadDataSanPham(allSanPham);
                        clearFormSP();
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Thêm sản phẩm không thành công");
                e.printStackTrace(System.out);
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (validateSP()) {
            try {
                SanPham sp = getSPFormInput();
                if (sps.updateSanPham(sp) != null) {
                    JOptionPane.showMessageDialog(this, "Sửa sản phẩm thành công");
                    System.out.println("Sửa thành công");
                    loadDataSanPham(sps.getAllSanPham());
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Sửa sản phẩm không thành công");
                e.printStackTrace(System.out);
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnCTSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCTSPActionPerformed

    }//GEN-LAST:event_btnCTSPActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        clearFormSP();
    }//GEN-LAST:event_btnNewActionPerformed

    private void txtTimKiemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyTyped

    }//GEN-LAST:event_txtTimKiemKeyTyped

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        try {
            showDetailSP();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed

    }//GEN-LAST:event_btnLastActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed

    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed

    }//GEN-LAST:event_btnNextActionPerformed

    private void btnFertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFertActionPerformed

    }//GEN-LAST:event_btnFertActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed

    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed

    }//GEN-LAST:event_jButton14ActionPerformed

    private void tfTimKiemSpctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTimKiemSpctActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTimKiemSpctActionPerformed

    private void tfTimKiemSpctKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTimKiemSpctKeyTyped

    }//GEN-LAST:event_tfTimKiemSpctKeyTyped

    private void tbSanPhamChiTietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSanPhamChiTietMouseClicked

    }//GEN-LAST:event_tbSanPhamChiTietMouseClicked

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed

    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed

    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed

    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed

    }//GEN-LAST:event_jButton18ActionPerformed

    private void btnAddTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTTActionPerformed
        //Thêm size
        if (rdoSize.isSelected() == true) {
            if (validateTT()) {
                try {
                    Size s = getSizeFormInput();
                    if (checkTrungMaTT(s.getMaSize()) == false) {
                        JOptionPane.showMessageDialog(this, "Mã size đã tồn tại");
                        return;
                    } else {
                        if (ss.addSize(s) != null) {
                            JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công");
                            System.out.println("Thêm thành công");
                            loadDataSize(ss.getAllSize());
                            clearFormTT();
                        }
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Thêm màu sắc không thành công");
                    e.printStackTrace(System.out);
                }
            }
        }
        //Thêm Chất liệu
        if (rdoSize.isSelected() == true) {
            if (validateTT()) {
                try {
                    Size s = getSizeFormInput();
                    if (checkTrungMaTT(s.getMaSize()) == false) {
                        JOptionPane.showMessageDialog(this, "Mã size đã tồn tại");
                        return;
                    } else {
                        if (ss.addSize(s) != null) {
                            JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công");
                            System.out.println("Thêm thành công");
                            loadDataSize(ss.getAllSize());
                            clearFormTT();
                        }
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Thêm màu sắc không thành công");
                    e.printStackTrace(System.out);
                }
            }
        }
        //Thêm màu sắc
        if (rdoSize.isSelected() == true) {
            if (validateTT()) {
                try {
                    Size s = getSizeFormInput();
                    if (checkTrungMaTT(s.getMaSize()) == false) {
                        JOptionPane.showMessageDialog(this, "Mã size đã tồn tại");
                        return;
                    } else {
                        if (ss.addSize(s) != null) {
                            JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công");
                            System.out.println("Thêm thành công");
                            loadDataSize(ss.getAllSize());
                            clearFormTT();
                        }
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Thêm màu sắc không thành công");
                    e.printStackTrace(System.out);
                }
            }
        }
        //Thêm mũ
        if (rdoSize.isSelected() == true) {
            if (validateTT()) {
                try {
                    Size s = getSizeFormInput();
                    if (checkTrungMaTT(s.getMaSize()) == false) {
                        JOptionPane.showMessageDialog(this, "Mã size đã tồn tại");
                        return;
                    } else {
                        if (ss.addSize(s) != null) {
                            JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công");
                            System.out.println("Thêm thành công");
                            loadDataSize(ss.getAllSize());
                            clearFormTT();
                        }
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Thêm màu sắc không thành công");
                    e.printStackTrace(System.out);
                }
            }
        }
        //Thêm lớp lót
        if (rdoSize.isSelected() == true) {
            if (validateTT()) {
                try {
                    Size s = getSizeFormInput();
                    if (checkTrungMaTT(s.getMaSize()) == false) {
                        JOptionPane.showMessageDialog(this, "Mã size đã tồn tại");
                        return;
                    } else {
                        if (ss.addSize(s) != null) {
                            JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công");
                            System.out.println("Thêm thành công");
                            loadDataSize(ss.getAllSize());
                            clearFormTT();
                        }
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Thêm màu sắc không thành công");
                    e.printStackTrace(System.out);
                }
            }
        }
        //Thêm kiểu dáng
        if (rdoSize.isSelected() == true) {
            if (validateTT()) {
                try {
                    Size s = getSizeFormInput();
                    if (checkTrungMaTT(s.getMaSize()) == false) {
                        JOptionPane.showMessageDialog(this, "Mã size đã tồn tại");
                        return;
                    } else {
                        if (ss.addSize(s) != null) {
                            JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công");
                            System.out.println("Thêm thành công");
                            loadDataSize(ss.getAllSize());
                            clearFormTT();
                        }
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Thêm màu sắc không thành công");
                    e.printStackTrace(System.out);
                }
            }
        }
    }//GEN-LAST:event_btnAddTTActionPerformed

    private void btnUpdateTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateTTActionPerformed
        if (rdoSize.isSelected()) {
            if (validateTT()) {
                try {
                    Size s = getSizeFormInput();
                    if (ss.updateSize(s) != null) {
                        JOptionPane.showMessageDialog(this, "Sửa thuộc tính thành công");
                        System.out.println("Sửa thành công");
                        loadDataSize(ss.getAllSize());
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Sửa thuộc tính không thành công");
                    e.printStackTrace(System.out);
                }
            }
        }

        if (rdoChatLieu.isSelected()) {
            if (validateTT()) {
                try {
                    ChatLieu cl = getCLFormInput();
                    if (cls.updateChatLieu(cl) != null) {
                        JOptionPane.showMessageDialog(this, "Sửa thuộc tính thành công");
                        System.out.println("Sửa thành công");
                        loadDataChatLieu(cls.getAllChatLieu());
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Sửa thuộc tính không thành công");
                    e.printStackTrace(System.out);
                }
            }
        }

        if (rdoMauSac.isSelected()) {
            if (validateTT()) {
                try {
                    MauSac ms = getMSFormInput();
                    if (mss.updateMauSac(ms) != null) {
                        JOptionPane.showMessageDialog(this, "Sửa thuộc tính thành công");
                        System.out.println("Sửa thành công");
                        loadDataMauSac(mss.getAllMauSac());
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Sửa thuộc tính không thành công");
                    e.printStackTrace(System.out);
                }
            }
        }

        if (rdoMu.isSelected()) {
            if (validateTT()) {
                try {
                    Mu m = getMuFormInput();
                    if (ms.updateMu(m) != null) {
                        JOptionPane.showMessageDialog(this, "Sửa thuộc tính thành công");
                        System.out.println("Sửa thành công");
                        loadDataMu(ms.getAllMu());
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Sửa thuộc tính không thành công");
                    e.printStackTrace(System.out);
                }
            }
        }

        if (rdoLopLot.isSelected()) {
            if (validateTT()) {
                try {
                    LopLot ll = getLLFormInput();
                    if (lls.updateLopLot(ll) != null) {
                        JOptionPane.showMessageDialog(this, "Sửa thuộc tính thành công");
                        System.out.println("Sửa thành công");
                        loadDataLopLot(lls.getAllLopLot());
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Sửa thuộc tính không thành công");
                    e.printStackTrace(System.out);
                }
            }
        }

        if (rdoKieuDang.isSelected()) {
            if (validateTT()) {
                try {
                    KieuDang kd = getKDFormInput();
                    if (kds.updateKieuDang(kd) != null) {
                        JOptionPane.showMessageDialog(this, "Sửa thuộc tính thành công");
                        System.out.println("Sửa thành công");
                        loadDataKieuDang(kds.getAllKieuDang());
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Sửa thuộc tính không thành công");
                    e.printStackTrace(System.out);
                }
            }
        }
    }//GEN-LAST:event_btnUpdateTTActionPerformed

    private void btnNewTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewTTActionPerformed
        // TODO add your handling code here:
        clearFormTT();
    }//GEN-LAST:event_btnNewTTActionPerformed

    private void rdoSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoSizeActionPerformed
        tblThuocTinh.removeAll();
        tblThuocTinh.setModel(tblModel);
        String header[] = {
            "STT", "Mã Size", "Tên size", "Trạng thái"
        };
        tblModel.setColumnIdentifiers(header);
        tblModel = (DefaultTableModel) tblThuocTinh.getModel();
        loadDataSize(ss.getAllSize());
    }//GEN-LAST:event_rdoSizeActionPerformed

    private void rdoMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoMauSacActionPerformed
        tblThuocTinh.removeAll();
        tblThuocTinh.setModel(tblModel);
        String header[] = {
            "STT", "Mã màu sắc", "Tên màu sắc", "Trạng thái"
        };
        tblModel.setColumnIdentifiers(header);
        tblModel = (DefaultTableModel) tblThuocTinh.getModel();
        loadDataMauSac(mss.getAllMauSac());
    }//GEN-LAST:event_rdoMauSacActionPerformed

    private void rdoChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoChatLieuActionPerformed
        // TODO add your handling code here:
        tblThuocTinh.removeAll();
        tblThuocTinh.setModel(tblModel);
        String headerCL[] = {
            "STT", "Mã chất liệu", "Tên chất liệu", "Trạng thái"
        };
        tblModel.setColumnIdentifiers(headerCL);
        tblModel = (DefaultTableModel) tblThuocTinh.getModel();
        loadDataChatLieu(cls.getAllChatLieu());
    }//GEN-LAST:event_rdoChatLieuActionPerformed

    private void rdoMuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoMuActionPerformed
        // TODO add your handling code here:
        tblThuocTinh.removeAll();
        tblThuocTinh.setModel(tblModel);
        String header[] = {
            "STT", "Mã mũ", "Tên mũ", "Trạng thái"
        };
        tblModel.setColumnIdentifiers(header);
        tblModel = (DefaultTableModel) tblThuocTinh.getModel();
        loadDataMu(ms.getAllMu());
    }//GEN-LAST:event_rdoMuActionPerformed

    private void tblThuocTinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThuocTinhMouseClicked
        // TODO add your handling code here:
        try {
            showDetailTT();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

    }//GEN-LAST:event_tblThuocTinhMouseClicked

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
//        try {
//            String text = "%" + txtTimKiem.getText().trim() + "%";
//            if (txtTimKiem.getText().isEmpty()) {
//                loadDataSanPham(sps.getAllSanPham());
//            } else {
//                ArrayList<SanPham> list = sps.searchSP(text);
//                loadDataSanPham(list);
//            }
//        } catch (Exception e) {
//            e.printStackTrace(System.out);
//        }

        try {
            String text = "%" + txtTimKiem.getText().trim() + "%";
            if (rdoSearchHD.isSelected()) {
                loadDataSanPham(sps.getAllSPHD(text));
            } else {
                //ArrayList<SanPham> list = sps.getAllSPNHD(text);
                loadDataSanPham(sps.getAllSPNHD(text));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void rdoSearchHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoSearchHDMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoSearchHDMouseClicked

    private void rdoSearchHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoSearchHDActionPerformed
        // TODO add your handling code here:
        try {
            String text = "%" + txtTimKiem.getText().trim() + "%";
            if (txtTimKiem.getText().isEmpty()) {
                loadDataSanPham(sps.getAllSPHD(text));
            } else {
                ArrayList<SanPham> list = sps.getAllSPHD(text);
                loadDataSanPham(list);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }//GEN-LAST:event_rdoSearchHDActionPerformed

    private void rdoSearchNHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoSearchNHDActionPerformed
        // TODO add your handling code here:
        try {
            String text = "%" + txtTimKiem.getText().trim() + "%";
            if (txtTimKiem.getText().isEmpty()) {
                loadDataSanPham(sps.getAllSPNHD(text));
            } else {
                ArrayList<SanPham> list = sps.getAllSPNHD(text);
                loadDataSanPham(list);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }//GEN-LAST:event_rdoSearchNHDActionPerformed

    private void txtTenThuocTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenThuocTinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenThuocTinhActionPerformed

    private void rdoLopLotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoLopLotActionPerformed
        // TODO add your handling code here:
        tblThuocTinh.removeAll();
        tblThuocTinh.setModel(tblModel);
        String header[] = {
            "STT", "Mã lớp lót", "Tên lớp lót", "Trạng thái"
        };
        tblModel.setColumnIdentifiers(header);
        tblModel = (DefaultTableModel) tblThuocTinh.getModel();
        loadDataLopLot(lls.getAllLopLot());
    }//GEN-LAST:event_rdoLopLotActionPerformed

    private void rdoKieuDangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoKieuDangActionPerformed
        // TODO add your handling code here:
        tblThuocTinh.removeAll();
        tblThuocTinh.setModel(tblModel);
        String header[] = {
            "STT", "Mã kiểu dáng", "Tên kiểu dáng", "Trạng thái"
        };
        tblModel.setColumnIdentifiers(header);
        tblModel = (DefaultTableModel) tblThuocTinh.getModel();
        loadDataKieuDang(kds.getAllKieuDang());
    }//GEN-LAST:event_rdoKieuDangActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddTT;
    private javax.swing.JButton btnCTSP;
    private javax.swing.JButton btnFert;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNewTT;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnUpdateTT;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JComboBox<String> cbbChatLieu;
    private javax.swing.JComboBox<String> cbbMauSac;
    private javax.swing.JComboBox<String> cbbMu;
    private javax.swing.JComboBox<String> cbbSize;
    private javax.swing.JComboBox<String> cbbTenSanPham;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lbSoTrangSpct;
    private javax.swing.JLabel lbTrangSpct;
    private javax.swing.JLabel lblMaThuocTinh;
    private javax.swing.JLabel lblTenThuocTinh;
    private javax.swing.JLabel lblTenThuocTinh1;
    private javax.swing.JTabbedPane pnTong;
    private javax.swing.JRadioButton rdoChatLieu;
    private javax.swing.JRadioButton rdoHDTT;
    private javax.swing.JRadioButton rdoHoatDong3;
    private javax.swing.JRadioButton rdoKieuDang;
    private javax.swing.JRadioButton rdoLopLot;
    private javax.swing.JRadioButton rdoMauSac;
    private javax.swing.JRadioButton rdoMu;
    private javax.swing.JRadioButton rdoNHDTT;
    private javax.swing.JRadioButton rdoNgungHoatDong3;
    private javax.swing.JRadioButton rdoSearchHD;
    private javax.swing.JRadioButton rdoSearchNHD;
    private javax.swing.JRadioButton rdoSize;
    private javax.swing.JTextArea taMoTa;
    private javax.swing.JTable tbSanPhamChiTiet;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTable tblThuocTinh;
    private javax.swing.JTextField tfGia;
    private javax.swing.JTextField tfMaSpct;
    private javax.swing.JTextField tfSoLuong;
    private javax.swing.JTextField tfTimKiemSpct;
    private javax.swing.JTextField txtMaSanPham3;
    private javax.swing.JTextField txtMaThuocTinh;
    private javax.swing.JTextField txtTenSanPham3;
    private javax.swing.JTextField txtTenThuocTinh;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
