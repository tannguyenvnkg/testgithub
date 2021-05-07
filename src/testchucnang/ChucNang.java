/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testchucnang;

import java.awt.MenuItem;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tanng
 */
public class ChucNang extends  Database{
    
    public void AddNhanVienVaoPhong(DefaultTableModel model) throws SQLException{
        connect();
        int rows = model.getRowCount();
        for (int i = 0; i < rows; i++) {
            
            String manhanvien = model.getValueAt(i, 0).toString();
            String tennhanvien = model.getValueAt(i, 1).toString();
            
            String query = "insert into a values('"+manhanvien+"',N'"+tennhanvien+"')";
            Statement stmt1 = conn.createStatement();
            stmt1.execute(query);
        }
        JOptionPane.showMessageDialog(null, "Add thành công");
    }
    public int KiemTraKieuDuLieuCuaChuoi(String chuoi){
        Character c = chuoi.charAt(0);
        int flag;
        if(Character.isDigit(c)) flag = 1; 
        else flag = 2;
        int kytuhientai = 0;
        for (int i = 0; i < chuoi.length(); i++) {
            if(Character.isDigit(chuoi.charAt(i))) kytuhientai = 1;
            else kytuhientai = 2;
            if(flag != kytuhientai) return 3;
        }
        return kytuhientai;
    }
    public void test() throws SQLException{
        connect();
        //String maphong = getMaphong(tenphong);
        String query = "select manhanvien from phong where maphong = 'kt1'";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {                
            System.out.println(rs.getString(1));
        }
    }
   
}
