/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import app.service.DBConnect;
import java.util.ArrayList;
import model.SanPham;
import java.sql.*;

/**
 *
 * @author Dat
 */
public class SanPhamService {

    public ArrayList<SanPham> getAllSanPham() {
        ArrayList<SanPham> list = new ArrayList<>();
        String sql = "select IDSANPHAM ,MASP, TENSP, TRANGTHAI \n"
                + "from SANPHAM";
        Connection con = DBConnect.getConnection();
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setId(rs.getInt("IDSANPHAM"));
                sp.setMaSP(rs.getString("MASP"));
                sp.setTenSP(rs.getString("TENSP"));
                sp.setTrangThai(rs.getBoolean("TRANGTHAI"));
                list.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public Integer addSanPham(SanPham sp) {
        Integer row = null;
        String sql = "insert into SANPHAM(MASP, TENSP, TRANGTHAI)"
                + "values(?, ?, ?)";
        Connection con = DBConnect.getConnection();
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, sp.getMaSP());
            pstm.setString(2, sp.getTenSP());
            pstm.setBoolean(3, sp.isTrangThai());
            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return row;
    }

    public Integer deleteSanPham(SanPham sp) {
        Integer row = null;
        String sql = "update SANPHAM\n"
                + "set TRANGTHAI = 0\n"
                + "where MASP = ?";
        Connection con = DBConnect.getConnection();
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            //pstm.setBoolean(1, sp.isTrangThai());
            pstm.setString(1, sp.getMaSP());
            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return row;
    }

    public static void main(String[] args) {
        for (SanPham sp : new SanPhamService().getAllSanPham()) {
            System.out.println(sp);
        }
    }
}
