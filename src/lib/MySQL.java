/*
 * Name         : dbconnect.java
 * Package      : libs
 * Written By   : Tholut Akhyar
 * Date Created : 03 - 06 - 2018
 * Date Updated : 03 - 06 - 2018
 */

package lib;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author TholutAkhyar
 */

public class MySQL {
    
    public static Connection MySQLConn;
    public static Statement MySQLStatement;
    public static ResultSet MySQLResultSet;
    
    static String MySQLDriver = "com.mysql.jdbc.Driver";
    static String MySQLUrl = "jdbc:mysql://localhost/";
    static String MySQLDb = "apkg_db";
    static String MySQLUser = "root";
    static String MySQLPass = "1234";
    
    // Checking if you are connected with database
    public static Connection MySQLConnection() {
        if (MySQLConn == null) {
            try {
                Class.forName(MySQLDriver);
                MySQLConn = (Connection) DriverManager.getConnection(MySQLUrl+MySQLDb, MySQLUser, MySQLPass);
                MySQLStatement = (Statement) MySQLConn.createStatement(); 
                System.out.println("[Lib][MySQL] Connection Success");
            } catch (ClassNotFoundException | SQLException e) {
                System.err.println("[Lib][MySQL] Connection Failed [ "+e.getMessage()+" ]");
            }
        }
        return MySQLConn;
    }
    
    // Method called for do Query Select
    public ResultSet MySQLQuery(String sql) throws SQLException {
        Connection Conn = (Connection) MySQL.MySQLConnection();
        MySQLResultSet = MySQLStatement.executeQuery(sql);
        
        return MySQLResultSet;
    }
    
    // Method called for do Query Insert, Update, Delete
    public int MySQLUpdate(String sql) throws SQLException {
        int SuccessUpdate;
        Connection Conn = (Connection) MySQL.MySQLConnection();
        Statement Stm = (Statement) Conn.createStatement();
        SuccessUpdate = MySQLStatement.executeUpdate(sql);
        
        return SuccessUpdate;
    }
    
    // Method called for get Database Kaset
    public String[][] MySQLGetUser(String FindWhat, String TypeWhat, String UserJabatan) throws SQLException {
        Connection Conn = (Connection) MySQL.MySQLConnection();
        
        // Checking Type of Data
        if (null != TypeWhat) switch (TypeWhat) {
            case "User Id":
                TypeWhat = "user_id";
                break;
            case "Nama":
                TypeWhat = "user_namalengkap";
                break;
            case "NIK":
                TypeWhat = "user_nik_ktp";
                break;
            default:
                TypeWhat = "user_id";
                break;
        }
            
        String[] d_as = {FindWhat, TypeWhat};
        String query = "select * from user";
        
        if (!"".equals(d_as[0]) && !"".equals(d_as[1])) {
            query = "select * from user where "+d_as[1]+" like '%"+d_as[0]+"%'";
        }
        
        if (!"Pemilik".equals(UserJabatan)) {
            query = "select * from user where user_jabatan not like '1' and user_jabatan not like '2'";
            
            if (!"".equals(d_as[0]) && !"".equals(d_as[1])) {
                query = "select * from user where "+d_as[1]+" like '%"+d_as[0]+"%' and user_jabatan not like '1' and user_jabatan not like '2'";
            }
        }
        
        
        // Counting Data
        System.out.println("[Lib][MySQL] Running: ["+query+"]");
        MySQLResultSet = MySQLStatement.executeQuery(query);
        MySQLResultSet.last(); 
        int total = MySQLResultSet.getRow();
        String returnData[][] = new String[total][11];
        System.out.println("[Lib][MySQL] Total Data ["+total+"]");
        
        
        // Inserting Data to Array
        System.out.println("[Lib][MySQL] Running: ["+query+"]");
        MySQLResultSet = MySQLStatement.executeQuery(query);
        int x = 0;
        while (MySQLResultSet.next()) {
             returnData[x][0] = MySQLResultSet.getString("user_id");
             returnData[x][1] = MySQLResultSet.getString("username");
             returnData[x][2] = MySQLResultSet.getString("password");
             returnData[x][3] = MySQLResultSet.getString("user_namalengkap");
             returnData[x][4] = MySQLResultSet.getString("user_alamat");
             returnData[x][5] = MySQLResultSet.getString("user_nik_ktp");
             returnData[x][6] = MySQLResultSet.getString("user_telp");
             returnData[x][7] = MySQLResultSet.getString("user_email");
             returnData[x][8] = MySQLResultSet.getString("user_jabatan");
             returnData[x][9] = MySQLResultSet.getString("user_tgl_lahir");
             returnData[x][10] = MySQLResultSet.getString("user_tgl_masuk");
             x++;
        }
        System.out.println("[Lib][MySQL] "+total+" Data User Success Loaded");
        
        return returnData;
    }
    
    // Method called for get Database Kaset
    public String[][] MySQLGetKaset(String FindWhat, String TypeWhat) throws SQLException {
        Connection Conn = (Connection) MySQL.MySQLConnection();
        
        // Checking Type of Data
        if (null != TypeWhat) switch (TypeWhat) {
            case "Kode":
                TypeWhat = "kaset_id";
                break;
            case "Judul":
                TypeWhat = "kaset_nama";
                break;
            case "Kategori":
                TypeWhat = "kaset_kategori";
                break;
            case "SewaKaset":
                TypeWhat = "SewaKaset";
                break;
            default:
                TypeWhat = "kaset_id";
                break;
        }
            
        String[] d_as = {FindWhat, TypeWhat};
        String query = "select * from kaset";
            
        
        if (!"".equals(d_as[0]) && !"".equals(d_as[1])) {
            query = "select * from kaset where "+d_as[1]+" like '%"+d_as[0]+"%'";
        }
        
        if (TypeWhat == "SewaKaset") {
            query = "select * from kaset where kaset_id = '"+FindWhat+"'";
        }
        
        // Counting Data
        System.out.println("[Lib][MySQL] Running: ["+query+"]");
        MySQLResultSet = MySQLStatement.executeQuery(query);
        MySQLResultSet.last(); 
        int total = MySQLResultSet.getRow();
        String returnData[][] = new String[total][6];
        System.out.println("[Lib][MySQL] Total Data ["+total+"]");
        
        
        // Inserting Data to Array
        System.out.println("[Lib][MySQL] Running: ["+query+"]");
        MySQLResultSet = MySQLStatement.executeQuery(query);
        int x = 0;
        while (MySQLResultSet.next()) {
             returnData[x][0] = MySQLResultSet.getString("kaset_id");
             returnData[x][1] = MySQLResultSet.getString("kaset_nama");
             returnData[x][2] = MySQLResultSet.getString("kaset_jumlah_keping");
             returnData[x][3] = MySQLResultSet.getString("kaset_kategori");
             returnData[x][4] = MySQLResultSet.getString("kaset_stok");
             returnData[x][5] = MySQLResultSet.getString("kaset_harga");
             x++;
        }
        System.out.println("[Lib][MySQL] "+total+" Data Kaset Success Loaded");
        
        return returnData;
    }
    
    // Method called for get Database Kaset
    public String[][] MySQLGetSewa(String FindWhat, String TypeWhat) throws SQLException {
        Connection Conn = (Connection) MySQL.MySQLConnection();
        
        // Checking Type of Data
        if (null != TypeWhat) switch (TypeWhat) {
            case "ID":
                TypeWhat = "ts_id";
                break;
            case "Transaksi Id":
                TypeWhat = "mantapkuy";
                break;
            case "SewaDetil":
                TypeWhat = "SewaDetil";
                break;
            default:
                TypeWhat = "ts_id";
                break;
        }
            
        String[] d_as = {FindWhat, TypeWhat};
        String query = "select * from transaksi where status_pending = '0' order by ts_status_kembali asc";
        
        if ("SewaDetil".equals(TypeWhat)) {
            query = "select * from transaksi where ts_id = '"+FindWhat+"' and status_pending = '0' order by ts_status_kembali asc";
        }
        
        if ("mantapkuy".equals(TypeWhat)) {
            query = "select * from transaksi where ts_id like '%"+FindWhat+"%' and status_pending = '0' order by ts_status_kembali asc";
        }
        
        // Counting Data
        System.out.println("[Lib][MySQL] Running: ["+query+"]");
        MySQLResultSet = MySQLStatement.executeQuery(query);
        MySQLResultSet.last(); 
        int total = MySQLResultSet.getRow();
        String returnData[][] = new String[total][10];
        System.out.println("[Lib][MySQL] Total Data ["+total+"]");
        
        // Inserting Data to Array
        System.out.println("[Lib][MySQL] Running: ["+query+"]");
        MySQLResultSet = MySQLStatement.executeQuery(query);
        int x = 0;
        while (MySQLResultSet.next()) {
             returnData[x][0] = MySQLResultSet.getString("ts_id");
             returnData[x][1] = MySQLResultSet.getString("pelanggan_id");
             returnData[x][2] = MySQLResultSet.getString("karyawan_id");
             returnData[x][3] = MySQLResultSet.getString("ts_status_kembali");
             returnData[x][4] = MySQLResultSet.getString("ts_subtotal");
             returnData[x][5] = MySQLResultSet.getString("ts_diskon");
             returnData[x][6] = MySQLResultSet.getString("ts_bayar");
             returnData[x][7] = MySQLResultSet.getString("ts_tgl_peminjaman");
             returnData[x][8] = MySQLResultSet.getString("ts_tgl_pengembalian");
             returnData[x][9] = MySQLResultSet.getString("status_pending");
             x++;
        }
        System.out.println("[Lib][MySQL] "+total+" Data Kaset Success Loaded");
        
        return returnData;
    }
    
    // Method called for get Database Kaset
    public String[][] MySQLGetLaporan(String DariTanggal, String SampaiTanggal) throws SQLException {
        Connection Conn = (Connection) MySQL.MySQLConnection();
        //yyyy-MM-dd
        String dariHari = DariTanggal.substring(8);
        
        if ("0".equals(dariHari.substring(0,1))) {
            dariHari = dariHari.substring(1,2);
        }
        
        String dariBulan = DariTanggal.substring(5,7);
        
        if ("0".equals(dariBulan.substring(0,1))) {
            dariBulan = dariBulan.substring(1,2);
        }
        
        String dariTahun = DariTanggal.substring(0,4);
        
        String sampaiHari = SampaiTanggal.substring(8);
        
        if ("0".equals(sampaiHari.substring(0,1))) {
            sampaiHari = sampaiHari.substring(1,2);
        }
        
        String sampaiBulan = SampaiTanggal.substring(5,7);
        
        if ("0".equals(sampaiBulan.substring(0,1))) {
            sampaiBulan = sampaiBulan.substring(1,2);
        }
        
        String sampaiTahun = SampaiTanggal.substring(0,4);
        System.out.println("dari Hari:"+dariHari+", Bulan:"+dariBulan+", Tahun:"+dariTahun);
        System.out.println("sampai Hari:"+sampaiHari+", Bulan:"+sampaiBulan+", Tahun:"+sampaiTahun);
        
        String query = "select * from transaksi where year(ts_tgl_peminjaman) >= '"+dariTahun+"' and year(ts_tgl_peminjaman) <= '"+sampaiTahun+"' and month(ts_tgl_peminjaman) >= '"+dariBulan+"' and month(ts_tgl_peminjaman) <= '"+sampaiBulan+"' and day(ts_tgl_peminjaman) >= '"+dariHari+"' and day(ts_tgl_peminjaman) <= '"+sampaiHari+"' and status_pending = '0'";
        
        // Counting Data
        System.out.println("[Lib][MySQL] Running: ["+query+"]");
        MySQLResultSet = MySQLStatement.executeQuery(query);
        MySQLResultSet.last(); 
        int total = MySQLResultSet.getRow();
        String returnData[][] = new String[total][10];
        System.out.println("[Lib][MySQL] Total Data ["+total+"]");
        
        // Inserting Data to Array
        System.out.println("[Lib][MySQL] Running: ["+query+"]");
        MySQLResultSet = MySQLStatement.executeQuery(query);
        int x = 0;
        while (MySQLResultSet.next()) {
             returnData[x][0] = MySQLResultSet.getString("ts_id");
             returnData[x][1] = MySQLResultSet.getString("pelanggan_id");
             returnData[x][2] = MySQLResultSet.getString("karyawan_id");
             returnData[x][3] = MySQLResultSet.getString("ts_status_kembali");
             returnData[x][4] = MySQLResultSet.getString("ts_subtotal");
             returnData[x][5] = MySQLResultSet.getString("ts_diskon");
             returnData[x][6] = MySQLResultSet.getString("ts_bayar");
             returnData[x][7] = MySQLResultSet.getString("ts_tgl_peminjaman");
             returnData[x][8] = MySQLResultSet.getString("ts_tgl_pengembalian");
             returnData[x][9] = MySQLResultSet.getString("status_pending");
             x++;
        }
        System.out.println("[Lib][MySQL] "+total+" Data Kaset Success Loaded");
        
        return returnData;
    }
    
    // Method called for get Database Kaset
    public String[][] MySQLGetDetilSewa(String ID_Bois) throws SQLException {
        Connection Conn = (Connection) MySQL.MySQLConnection();
        
        String query = "select * from transaksi_detil where ts_id = '"+ID_Bois+"'";
        
        // Counting Data
        System.out.println("[Lib][MySQL] Running: ["+query+"]");
        MySQLResultSet = MySQLStatement.executeQuery(query);
        MySQLResultSet.last(); 
        int total = MySQLResultSet.getRow();
        String returnData[][] = new String[total][4];
        System.out.println("[Lib][MySQL] Total Data ["+total+"]");
        
        // Inserting Data to Array
        System.out.println("[Lib][MySQL] Running: ["+query+"]");
        MySQLResultSet = MySQLStatement.executeQuery(query);
        int x = 0;
        while (MySQLResultSet.next()) {
             returnData[x][0] = MySQLResultSet.getString("ts_detil_id");
             returnData[x][1] = MySQLResultSet.getString("ts_id");
             returnData[x][2] = MySQLResultSet.getString("kaset_id");
             returnData[x][3] = MySQLResultSet.getString("ts_detil_harga");
             returnData[x][3] = MySQLResultSet.getString("ts_detil_jumlah");
             x++;
        }
        System.out.println("[Lib][MySQL] "+total+" Data Transaksi Detil Success Loaded");
        
        return returnData;
    }
}
