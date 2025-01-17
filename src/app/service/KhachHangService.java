/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.service;

import app.model.KhachHang;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 *
 * @author PC
 */
public class KhachHangService {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    List<KhachHang> list;

    public List<KhachHang> getall() {
        List<KhachHang> listKhachHang = new ArrayList<>();
        try {
            con = SQLServerConnection.getConnection("DUAN1");
            sql = "select* from KhachHang";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                KhachHang kh = new KhachHang();
                kh.setId(rs.getInt(1));
                kh.setMaKH(rs.getString(2));
                kh.setTenKH(rs.getString(3));
                kh.setGioiTinh(rs.getBoolean(4));
                kh.setSdt(rs.getString(5));
                kh.setNgaySinh(rs.getDate(6));
                kh.setEmail(rs.getString(7));
                kh.setNgayTao(rs.getDate(8));
                kh.setNgaySua(rs.getDate(9));
                kh.setNguoiTao(rs.getString(10));
                kh.setNguoiSua(rs.getString(11));
                kh.setTrangThai(rs.getBoolean(12));
                listKhachHang.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listKhachHang;

    }

    public Integer addKh(KhachHang kh) {
        int result = 0;
        sql = "insert into KHACHHANG(MAKHACHHANG, HOTEN, GIOITINH, SDT, NGAYSINH, EMAIL) values (?,?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setObject(1, kh.getMaKH());
            ps.setObject(2, kh.getTenKH());
            ps.setObject(3, kh.isGioiTinh());
            ps.setObject(4, kh.getSdt());
            ps.setObject(5, kh.getNgaySinh());
            ps.setObject(6, kh.getEmail());

            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return result;
    }

    public int deleteKH(KhachHang kh, String ma) {
        int result = 0;
        try {
            sql = "delete from KhachHang where makhachhang=?";
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int updateKh(KhachHang kh, int id) {
        int result = 0;
        sql = "UPDATE [dbo].[KHACHHANG] SET  [HOTEN] = ?,[GIOITINH] = ?,[NGAYSINH]=?,[SDT] = ?,[EMAIL] = ? WHERE IDKHACHHANG = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setObject(1, kh.getTenKH());
            ps.setObject(2, kh.isGioiTinh());
            ps.setObject(3, kh.getNgaySinh());
            ps.setObject(4, kh.getSdt());
            ps.setObject(5, kh.getEmail());
            ps.setObject(6, id);

            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<KhachHang> search(String ma) {
        list = new ArrayList<>();
        try {
            sql = "select MaKhachHang, HoTen, GioiTinh, NgaySinh, Email, SDT from KhachHang where MaKhachHang like '%'+?+'%' or HoTen like '%'+?+'%'  or SDT like '%'+?+'%'";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, ma);
            ps.setObject(2, ma);
            ps.setObject(3, ma);
            rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getString(5),
                        null, true, true);
                list.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
        return list;
    }

    public List<KhachHang> loc(String gender) {
        list = new ArrayList<>();
        try {
            sql = "SELECT MaKhachHang, HoTen, GioiTinh, NgaySinh, Email, SDT FROM KhachHang WHERE GioiTinh = ?";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, gender);
            rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getString(5),
                        null, true, true);
                list.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
         System.out.println("getAll() returned " + list.size() + " items."); 
        return list;
        
        

    }

}
