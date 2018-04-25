/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import gui.DashboardFrame;
import java.sql.ResultSet;
import java.sql.SQLException;


/*
------------------- Master --------------------

Deskripsi:
Semuanya di panggil dari sini, meskipun bisa di panggil dalam satu script.

------------------ Informasi ------------------

Rank:
1 = Pemilik
2 = Karyawan
3 = Pelanggan (Tidak Bisa Masuk)

*/

/**
 *
 * @author TholutAkhyar
 */
public class Master {
    ResultSet MasterResultSet;
    lib.MySQL MySQL = new lib.MySQL();
    
    public String RankName(int Rank) {
        String resultCv = "";
                
        if (Rank == 1) {
            resultCv = "Pemilik";
        } else if (Rank == 2) {
            resultCv = "Karyawan";
        } else if (Rank == 3) {
            resultCv = "Pelanggan";
        } else {
            resultCv = "Tidak Ada";
        }
        
        return resultCv;
    }
    
    public String GetName(int UserId) throws SQLException {
        String resultnm = "";
        lib.MySQL MySQL = new lib.MySQL();
            
        String sql = "select * from user where user_id = '"+UserId+ "'";
        MasterResultSet = MySQL.MySQLQuery(sql);
            
        if (MasterResultSet.next()) {
            resultnm = MasterResultSet.getString("user_namalengkap"); 
        } else {
            resultnm = String.valueOf(UserId);
        }
        
        return resultnm;
    }
    
    public String GetData(int UserId) throws SQLException {
        String resultnm = "";
        lib.MySQL MySQL = new lib.MySQL();
            
        String sql = "select * from user where user_id = '"+UserId+ "'";
        MasterResultSet = MySQL.MySQLQuery(sql);
            
        if (MasterResultSet.next()) {
            resultnm = MasterResultSet.getString("user_namalengkap"); 
        } else {
            resultnm = String.valueOf(UserId);
        }
        
        return resultnm;
    }
    
    public String GetStatus(int Status) {
        String resultnm = "";
        
        if (Status == 0) {
            //false
            resultnm = "Belum Kembali";
        } else if (Status == 1) {
            //true
            resultnm = "Sudah Kembali";
        }
        
        return resultnm;
    }
    
    public void showTholutDialogOk(String title, String msg, String icon) {
        gui.DialogOkFrame DialogOk = new gui.DialogOkFrame();
        String DataIcon = "LogoInformation.png";
        String DataTitle = "Information";
        String DataMessage = "No message";
        
        if (null == icon) {
            DataIcon = "LogoInformation.png";
        } else switch (icon) {
            case "Warning":
                DataIcon = "LogoWarning.png";
                break;
            case "Error":
                DataIcon = "LogoError.png";
                break;
            case "Information":
                DataIcon = "LogoInformation.png";
                break;
            case "Success":
                DataIcon = "LogoSuccess.png";
                break;
            case "Failed":
                DataIcon = "LogoFailed.png";
                break;
            case "Ask":
                DataIcon = "LogoAsk.png";
                break;
            default:
                DataIcon = "LogoInformation.png";
                break;
        }
        
        if ("".equals(title)) {
            DataTitle = "Information";
        } else {
            DataTitle = title;
        }
        
        if ("".equals(msg)) {
            DataMessage = "No message";
        } else {
            DataMessage = msg;
        }
        
        DialogOk.MasterDialogOk(DataTitle, DataMessage, DataIcon);
    }
    
    public void showTholutDashboard(int User_ID) {
        gui.DashboardFrame Dashboard = new gui.DashboardFrame();
        String data_dash[] = {"Title", "Nama", "Jabatan"};
        try {
            
            String sql = "select * from user where user_id = '"+User_ID+ "'";
            
            MasterResultSet = MySQL.MySQLQuery(sql);
            
            if (MasterResultSet.next()) {
                data_dash[0] = MasterResultSet.getString("user_id");
                data_dash[1] = MasterResultSet.getString("username");
                data_dash[2] = MasterResultSet.getString("user_jabatan");
                
                System.out.println("UserID: "+MasterResultSet.getString("user_id"));
            } else {
                showTholutDialogOk("Informasi", "Maaf user ini tidak ada", "Error");
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        Dashboard.MasterDashboard(Integer.parseInt(data_dash[0]), data_dash[1], Integer.parseInt(data_dash[2]));
    }

}
