/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author TholutAkhyar
 */
public class DashboardFrame extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    ResultSet DashboardResultSet;
    lib.Master Master = new lib.Master();
    lib.MySQL MySQL = new lib.MySQL();
    
    Color ButtonColorEntered = new java.awt.Color(103, 123, 196);
    Color ButtonColorExited = new java.awt.Color(114, 137, 218);
    
    DefaultTableModel DTM_User;
    DefaultTableModel DTM_Kaset;
    DefaultTableModel DTM_Sewa;
    DefaultTableModel DTM_DetilSewa;
    DefaultTableModel DTM_CariUser;
    DefaultTableModel DTM_CariKaset;
    DefaultTableModel DTM_SewaBaruTransaksi;
    DefaultTableModel DTM_Laporan;
    
    // Data Login Info
    private int AuthUserId;
    private String AuthName;
    private String AuthRank;
    
    // Data Delete
    private String DataDeleteType;
    private int DataDeleteId;
    private String DataDeleteIdString;
    
    
    private String BukaTransaksiIdWhat;
    
    // Data Type UbahTambah
    
    //User
    private int IdDialogYesNo = 0;
    private String IdDialogYesNoString = "";
    private String TypeDialogYesNo = "";
    private int UserIdSelectPopup = 0;
    
    // Transaksi
    private String baruTransaksi = "";
    private String selectedKasetKode = "";
    private String selectedKasetStok = "0";
    private String selectedKasetHarga = "0";
    private String selectedUserId = "";
    
    
    private String transaksiYesNoselect = "";
    
    // Laporan
    
    int TotalPendapatan = 0;
    int TotalKasetKuluar = 0;
    int TotalPenyewa = 0;
    
    // Drag Move Frame
    
    // DashboardFrame
    int xx;
    int xy;
    
    // UbahTambahUserFrame
    int xxutuser;
    int xyutuser;
    
    // UbahTambahKasetFrame
    int xxutkaset;
    int xyutkaset;
    
    // PengaturanFrame
    int xxpengaturan;
    int xypengaturan;
    
    int xxubahtambahuser;
    int xyubahtambahuser;
    
    int xxubahtambahkaset;
    int xyubahtambahkaset;
    
    int xxtransaksibuka;
    int xytransaksibuka;
    
    int xxtransaksibaru;
    int xytransaksibaru;
    
    int xxtransaksicarikaset;
    int xytransaksicarikaset;
    
    int xxtransaksicariuser;
    int xytransaksicariuser;
    
    public DashboardFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        DeleteDialogYesNo.setLocationRelativeTo(null);
        UbahTambahUserDialog.setLocationRelativeTo(null);
        UbahTambahKasetDialog.setLocationRelativeTo(null);
        UbahTambahDialogYesNo.setLocationRelativeTo(null);
        PengaturanFrame.setLocationRelativeTo(null);
        TransaksiBukaFrame.setLocationRelativeTo(null);
        TransaksiBaruFrame.setLocationRelativeTo(null);
        TransaksiCariUserFrame.setLocationRelativeTo(null);
        TransaksiCariKasetFrame.setLocationRelativeTo(null);
        TransaksiYesNo.setLocationRelativeTo(null);
        LoadingCetak.setLocationRelativeTo(null);
        DTM_User = new DefaultTableModel(new String[]{"ID","Username","Password","Nama Lengkap","Alamat","NIK KTP","Telp","Email","Jabatan","Tgl Lahir","Tgl Masuk"},0);
        DashboardMUserTable.setModel(DTM_User);
        DTM_Kaset = new DefaultTableModel(new String[]{"Kode","Nama/Judul Game","Jumlah Keping","Kategori","Stok","Harga"},0);
        DashboardMKasetTable.setModel(DTM_Kaset);
        DTM_Sewa = new DefaultTableModel(new String[]{"ID","Penyewa","Karyawan","Status","Subtotal","Diskon","Bayar","Peminjaman","Pengembalian"},0);
        DashboardSewaTable.setModel(DTM_Sewa);
        DTM_DetilSewa = new DefaultTableModel(new String[]{"ID","Kode Kaset", "Nama Kaset", "Harga", "Jumlah", "Total"},0);
        DashboardDetilSewaTable.setModel(DTM_DetilSewa);
        DTM_CariUser = new DefaultTableModel(new String[]{"User Id", "Username", "Nama Lengkap"},0);
        TCUserTable.setModel(DTM_CariUser);
        DTM_CariKaset = new DefaultTableModel(new String[]{"Kode", "Nama", "Kategori", "Stok"},0);
        TCUserTable1.setModel(DTM_CariKaset);
        DTM_SewaBaruTransaksi = new DefaultTableModel(new String[]{"ID", "Kode Kaset", "Nama Kaset", "Harga", "Jumlah", "Total"},0);
        DashboardDetilSewaTable1.setModel(DTM_SewaBaruTransaksi);
        DashboardDetilSewaTable2.setModel(DTM_SewaBaruTransaksi);
        DashboardDetilSewaTable3.setModel(DTM_SewaBaruTransaksi);
        DTM_Laporan = new DefaultTableModel(new String[]{"ID","Penyewa","Karyawan","Status","Subtotal","Diskon","Bayar","Peminjaman","Pengembalian"},0);
        DashboardSewaTable1.setModel(DTM_Laporan);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DeleteDialogYesNo = new javax.swing.JFrame();
        DeleteDialogMainPanel = new javax.swing.JPanel();
        DeleteDialogHeader = new javax.swing.JPanel();
        DialogDelete_Close = new javax.swing.JLabel();
        DialogDelete_Title = new javax.swing.JLabel();
        DialogDelete_Icon = new javax.swing.JLabel();
        DialogDelete_Message = new javax.swing.JLabel();
        DialogDeleteTidakButton = new javax.swing.JLabel();
        DialogDeleteYaButton = new javax.swing.JLabel();
        DialogDeleteScrollPanel = new javax.swing.JScrollPane();
        DialogDeleteDetail = new javax.swing.JTextArea();
        UbahTambahUserDialog = new javax.swing.JFrame();
        UTUserMainPanel = new javax.swing.JPanel();
        UTUserHeaderPanel = new javax.swing.JPanel();
        UTUserHeaderTitle = new javax.swing.JLabel();
        UTUserButtonClose = new javax.swing.JLabel();
        UTUserUsernameInputLine = new javax.swing.JPanel();
        UTUserUsernameInputTitle = new javax.swing.JLabel();
        UTUserUsernameInput = new javax.swing.JTextField();
        UTUserNMLengkapInputTitle = new javax.swing.JLabel();
        UTUserNMLengkapInput = new javax.swing.JTextField();
        UTUserNMLengkapInputLine = new javax.swing.JPanel();
        UTUserAlamatInputTitle = new javax.swing.JLabel();
        UTUserAlamatInput = new javax.swing.JTextField();
        UTUserAlamatInputLine = new javax.swing.JPanel();
        UTUserPasswordInputTitle = new javax.swing.JLabel();
        UTUserPasswordInput = new javax.swing.JTextField();
        UTUserPasswordInputLine = new javax.swing.JPanel();
        UTUserJabatanInput = new javax.swing.JComboBox<>();
        UTUserTeleponInput = new javax.swing.JTextField();
        UTUserTeleponInputLine = new javax.swing.JPanel();
        UTUserTeleponInputTitle = new javax.swing.JLabel();
        UTUserNikKtpInput = new javax.swing.JTextField();
        UTUserNikKtpInputLine = new javax.swing.JPanel();
        UTUserNikKtpInputTitle = new javax.swing.JLabel();
        UTUserTitle = new javax.swing.JLabel();
        UTUserButtonBatal = new javax.swing.JLabel();
        UTUserButtonTambah = new javax.swing.JLabel();
        UTUserEmailInput = new javax.swing.JTextField();
        UTUserEmailInputLine = new javax.swing.JPanel();
        UTUserEmailInputTitle = new javax.swing.JLabel();
        UTUserJabatanTitle = new javax.swing.JLabel();
        UTUserTanggalLahirTitle = new javax.swing.JLabel();
        UTUserTanggalLahirInput = new com.toedter.calendar.JDateChooser();
        UbahTambahDialogYesNo = new javax.swing.JFrame();
        UbahTambahDialogMainPanel = new javax.swing.JPanel();
        UbahTambahDialogHeader = new javax.swing.JPanel();
        UbahTambahDialog_Close = new javax.swing.JLabel();
        UbahTambahDialog_Title = new javax.swing.JLabel();
        UbahTambahDialog_Icon = new javax.swing.JLabel();
        UbahTambahDialog_Message = new javax.swing.JLabel();
        UbahTambahDialogTidakButton = new javax.swing.JLabel();
        UbahTambahDialogYaButton = new javax.swing.JLabel();
        UbahTambahDialogScrollPanel = new javax.swing.JScrollPane();
        UbahTambahDialogDetail = new javax.swing.JTextArea();
        UbahTambahKasetDialog = new javax.swing.JFrame();
        UTKasetMainPanel = new javax.swing.JPanel();
        UTKasetHeaderPanel = new javax.swing.JPanel();
        UTKasetHeaderTitle = new javax.swing.JLabel();
        UTKasetButtonClose = new javax.swing.JLabel();
        UTKasetButtonBatal = new javax.swing.JLabel();
        UTKasetButtonTambah = new javax.swing.JLabel();
        UTKasetJumlahKepingInput = new javax.swing.JTextField();
        UTKasetStokInput = new javax.swing.JTextField();
        UTKasetHargaInputTitle = new javax.swing.JLabel();
        UTKasetJumlahKepingInputLine = new javax.swing.JPanel();
        UTKasetStokInputLine = new javax.swing.JPanel();
        UTKasetNamaInputTitle = new javax.swing.JLabel();
        UTKasetJumlahKepingInputTitle = new javax.swing.JLabel();
        UTKasetHargaInput = new javax.swing.JTextField();
        UTKasetNamaInput = new javax.swing.JTextField();
        UTKasetNamaInputLine = new javax.swing.JPanel();
        UTKasetHargaInputLine = new javax.swing.JPanel();
        UTKasetStokInputTitle = new javax.swing.JLabel();
        UTKasetTitle = new javax.swing.JLabel();
        UTKasetKategoriInputTitle = new javax.swing.JLabel();
        adventure_c = new javax.swing.JCheckBox();
        fight_c = new javax.swing.JCheckBox();
        racing_c = new javax.swing.JCheckBox();
        scifi_c = new javax.swing.JCheckBox();
        classic_c = new javax.swing.JCheckBox();
        sport_c = new javax.swing.JCheckBox();
        horror_c = new javax.swing.JCheckBox();
        puzzle_c = new javax.swing.JCheckBox();
        rpg_c = new javax.swing.JCheckBox();
        UTKasetKodeInput = new javax.swing.JTextField();
        UTKasetKodeInputLine = new javax.swing.JPanel();
        UTKasetKodeInputTitle = new javax.swing.JLabel();
        PengaturanFrame = new javax.swing.JFrame();
        PengaturanMainPanel = new javax.swing.JPanel();
        PengaturanHeader = new javax.swing.JPanel();
        PengaturanHeaderTitle = new javax.swing.JLabel();
        PengaturanButtonClose = new javax.swing.JLabel();
        PengaturanButtonBatal = new javax.swing.JLabel();
        PengaturanButtonSimpan = new javax.swing.JLabel();
        PengaturanUsernameInput = new javax.swing.JTextField();
        PengaturanUsernameInputTitle = new javax.swing.JLabel();
        PengaturanUsernameInputLine = new javax.swing.JPanel();
        PengaturanPasswordInput = new javax.swing.JTextField();
        PengaturanPasswordInputLine = new javax.swing.JPanel();
        PengaturanPasswordInputTitle = new javax.swing.JLabel();
        PengaturanAlamatInputTitle = new javax.swing.JLabel();
        PengaturanAlamatInputLine = new javax.swing.JPanel();
        PengaturanAlamatInput = new javax.swing.JTextField();
        PengaturanNMLengkapInputLine = new javax.swing.JPanel();
        PengaturanNMLengkapInput = new javax.swing.JTextField();
        PengaturanNMLengkapInputTitle = new javax.swing.JLabel();
        PengaturanEmailInput = new javax.swing.JTextField();
        PengaturanEmailInputLine = new javax.swing.JPanel();
        PengaturanEmailInputTitle = new javax.swing.JLabel();
        PengaturanTeleponInput = new javax.swing.JTextField();
        PengaturanTeleponInputLine = new javax.swing.JPanel();
        PengaturanTeleponInputTitle = new javax.swing.JLabel();
        PengaturanNikKtpInputLine = new javax.swing.JPanel();
        PengaturanNikKtpInput = new javax.swing.JTextField();
        PengaturanNikKtpInputTitle = new javax.swing.JLabel();
        PengaturanTanggalLahirInputLine = new javax.swing.JLabel();
        PengaturanTanggalLahirInput = new com.toedter.calendar.JDateChooser();
        PengaturanYesNo = new javax.swing.JFrame();
        PengaturanYesNoMainPanel = new javax.swing.JPanel();
        PengaturanYesNoHeader = new javax.swing.JPanel();
        PengaturanYesNo_Close = new javax.swing.JLabel();
        PengaturanYesNo_Title = new javax.swing.JLabel();
        PengaturanYesNo_Icon = new javax.swing.JLabel();
        PengaturanYesNo_Message = new javax.swing.JLabel();
        PengaturanYesNoTidakButton = new javax.swing.JLabel();
        PengaturanYesNoYaButton = new javax.swing.JLabel();
        TransaksiBukaFrame = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        TBFTransaksiId = new javax.swing.JLabel();
        DashboardDetilSewaScrollPanel = new javax.swing.JScrollPane();
        DashboardDetilSewaTable = new javax.swing.JTable();
        PengaturanYesNoHeader7 = new javax.swing.JPanel();
        PengaturanYesNo_Close7 = new javax.swing.JLabel();
        PengaturanYesNo_Title7 = new javax.swing.JLabel();
        TBFNama = new javax.swing.JLabel();
        TBFUserId = new javax.swing.JLabel();
        TBFNama1 = new javax.swing.JLabel();
        TBFTglPeminjaman = new javax.swing.JLabel();
        TBFTglPengembalian = new javax.swing.JLabel();
        PengaturanButtonBatal7 = new javax.swing.JLabel();
        PengaturanButtonBatal8 = new javax.swing.JLabel();
        TBFNama3 = new javax.swing.JLabel();
        TBFTglPeminjaman3 = new javax.swing.JLabel();
        TBFTglPengembalian3 = new javax.swing.JLabel();
        TBFUserId3 = new javax.swing.JLabel();
        TBFUserId4 = new javax.swing.JLabel();
        TBFUserId5 = new javax.swing.JLabel();
        TBFUserId6 = new javax.swing.JLabel();
        TBFUserId7 = new javax.swing.JLabel();
        TBFTglPengembalian4 = new javax.swing.JLabel();
        TBFTglPeminjaman4 = new javax.swing.JLabel();
        TBFNama5 = new javax.swing.JLabel();
        TBFUserId8 = new javax.swing.JLabel();
        TBFUserId9 = new javax.swing.JLabel();
        TBFUserId10 = new javax.swing.JLabel();
        TBFUserId11 = new javax.swing.JLabel();
        TBFUserId12 = new javax.swing.JLabel();
        TBFUserId13 = new javax.swing.JLabel();
        TBFTglPengembalian5 = new javax.swing.JLabel();
        TBFTglPeminjaman5 = new javax.swing.JLabel();
        TBFNama6 = new javax.swing.JLabel();
        TBFNama7 = new javax.swing.JLabel();
        TBFUserId14 = new javax.swing.JLabel();
        TBFNama8 = new javax.swing.JLabel();
        TBFTglPengembalian6 = new javax.swing.JLabel();
        TBFUserId15 = new javax.swing.JLabel();
        TBFTglPengembalian7 = new javax.swing.JLabel();
        TransaksiBaruFrame = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        PengaturanYesNoHeader8 = new javax.swing.JPanel();
        PengaturanYesNo_Close8 = new javax.swing.JLabel();
        PengaturanYesNo_Title8 = new javax.swing.JLabel();
        TransaksiBaruContent = new javax.swing.JPanel();
        SewaProcessAwal = new javax.swing.JPanel();
        DashboardDetilSewaScrollPanel1 = new javax.swing.JScrollPane();
        DashboardDetilSewaTable1 = new javax.swing.JTable();
        DashboardMUserTambahButton1 = new javax.swing.JLabel();
        DashboardMUserTambahButton2 = new javax.swing.JLabel();
        DashboardMUserTambahButton3 = new javax.swing.JLabel();
        DashboardMUserTambahButton4 = new javax.swing.JLabel();
        TBFTransaksiId2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        TBFUserId2 = new javax.swing.JLabel();
        TBFNama4 = new javax.swing.JLabel();
        TBFTglPeminjaman2 = new javax.swing.JLabel();
        TBFTglPengembalian2 = new javax.swing.JLabel();
        DashboardMUserTambahButton6 = new javax.swing.JLabel();
        DashboardMUserTambahButton7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        TBFUserId1 = new javax.swing.JLabel();
        TBFTransaksiId1 = new javax.swing.JLabel();
        TBFNama2 = new javax.swing.JLabel();
        TBFTglPeminjaman1 = new javax.swing.JLabel();
        TBFTglPengembalian1 = new javax.swing.JLabel();
        DashboardMUserTambahButton5 = new javax.swing.JLabel();
        SewaProcessKedua = new javax.swing.JPanel();
        DashboardDetilSewaScrollPanel2 = new javax.swing.JScrollPane();
        DashboardDetilSewaTable2 = new javax.swing.JTable();
        DashboardMUserTambahButton8 = new javax.swing.JLabel();
        DashboardMUserTambahButton9 = new javax.swing.JLabel();
        DashboardMUserTambahButton11 = new javax.swing.JLabel();
        TBFTransaksiId3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        TBFTransaksiId4 = new javax.swing.JLabel();
        TBFTransaksiId5 = new javax.swing.JLabel();
        TBFTransaksiId6 = new javax.swing.JLabel();
        TBFTransaksiId7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        TBFTransaksiId8 = new javax.swing.JLabel();
        TBFTransaksiId9 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        TBFTransaksiId32 = new javax.swing.JLabel();
        TBFTransaksiId33 = new javax.swing.JLabel();
        TBFTransaksiId34 = new javax.swing.JLabel();
        SewaProcessAkhir = new javax.swing.JPanel();
        DashboardDetilSewaScrollPanel3 = new javax.swing.JScrollPane();
        DashboardDetilSewaTable3 = new javax.swing.JTable();
        DashboardMUserTambahButton10 = new javax.swing.JLabel();
        DashboardMUserTambahButton13 = new javax.swing.JLabel();
        TBFTransaksiId10 = new javax.swing.JLabel();
        TBFTransaksiId11 = new javax.swing.JLabel();
        TBFTransaksiId12 = new javax.swing.JLabel();
        TBFTransaksiId13 = new javax.swing.JLabel();
        TBFTransaksiId14 = new javax.swing.JLabel();
        TBFTransaksiId15 = new javax.swing.JLabel();
        TBFTransaksiId16 = new javax.swing.JLabel();
        DashboardMUserTambahButton14 = new javax.swing.JLabel();
        TBFTransaksiId17 = new javax.swing.JLabel();
        TBFTransaksiId18 = new javax.swing.JLabel();
        TBFTransaksiId19 = new javax.swing.JLabel();
        TBFTransaksiId20 = new javax.swing.JLabel();
        TBFTransaksiId21 = new javax.swing.JLabel();
        TBFTransaksiId22 = new javax.swing.JLabel();
        TBFTransaksiId23 = new javax.swing.JLabel();
        TBFTransaksiId24 = new javax.swing.JLabel();
        TBFTransaksiId26 = new javax.swing.JLabel();
        TBFTransaksiId27 = new javax.swing.JLabel();
        TBFTransaksiId28 = new javax.swing.JLabel();
        TBFTransaksiId29 = new javax.swing.JLabel();
        TBFTransaksiId25 = new javax.swing.JLabel();
        TBFTransaksiId30 = new javax.swing.JLabel();
        TBFTransaksiId31 = new javax.swing.JLabel();
        TransaksiCariUserFrame = new javax.swing.JFrame();
        jPanel6 = new javax.swing.JPanel();
        PengaturanYesNoHeader9 = new javax.swing.JPanel();
        PengaturanYesNo_Close9 = new javax.swing.JLabel();
        PengaturanYesNo_Title9 = new javax.swing.JLabel();
        PengaturanUsernameInput1 = new javax.swing.JTextField();
        PengaturanUsernameInputLine1 = new javax.swing.JPanel();
        PengaturanButtonBatal1 = new javax.swing.JLabel();
        DashboardMUserJenis1 = new javax.swing.JComboBox<>();
        PengaturanButtonBatal2 = new javax.swing.JLabel();
        PengaturanButtonBatal3 = new javax.swing.JLabel();
        DashboardMUserScrollPanel1 = new javax.swing.JScrollPane();
        TCUserTable = new javax.swing.JTable();
        TBFTransaksiId35 = new javax.swing.JLabel();
        TransaksiCariKasetFrame = new javax.swing.JFrame();
        jPanel7 = new javax.swing.JPanel();
        PengaturanYesNoHeader10 = new javax.swing.JPanel();
        PengaturanYesNo_Close10 = new javax.swing.JLabel();
        PengaturanYesNo_Title10 = new javax.swing.JLabel();
        PengaturanUsernameInput2 = new javax.swing.JTextField();
        PengaturanUsernameInputLine2 = new javax.swing.JPanel();
        PengaturanButtonBatal4 = new javax.swing.JLabel();
        DashboardMUserJenis2 = new javax.swing.JComboBox<>();
        PengaturanButtonBatal5 = new javax.swing.JLabel();
        PengaturanButtonBatal6 = new javax.swing.JLabel();
        DashboardMUserScrollPanel2 = new javax.swing.JScrollPane();
        TCUserTable1 = new javax.swing.JTable();
        TBFTransaksiId36 = new javax.swing.JLabel();
        TransaksiYesNo = new javax.swing.JFrame();
        PengaturanYesNoMainPanel1 = new javax.swing.JPanel();
        PengaturanYesNoHeader1 = new javax.swing.JPanel();
        PengaturanYesNo_Close1 = new javax.swing.JLabel();
        PengaturanYesNo_Title1 = new javax.swing.JLabel();
        PengaturanYesNo_Icon1 = new javax.swing.JLabel();
        PengaturanYesNo_Message1 = new javax.swing.JLabel();
        PengaturanYesNoTidakButton1 = new javax.swing.JLabel();
        PengaturanYesNoYaButton1 = new javax.swing.JLabel();
        LoadingCetak = new javax.swing.JFrame();
        PengaturanYesNoMainPanel2 = new javax.swing.JPanel();
        PengaturanYesNoHeader2 = new javax.swing.JPanel();
        PengaturanYesNo_Close2 = new javax.swing.JLabel();
        PengaturanYesNo_Title2 = new javax.swing.JLabel();
        PengaturanYesNo_Message2 = new javax.swing.JLabel();
        DashboardMainPanel = new javax.swing.JPanel();
        DashboardHeader = new javax.swing.JPanel();
        DashboardHeaderDrag = new javax.swing.JPanel();
        DashboardTitle = new javax.swing.JLabel();
        DashboardClose = new javax.swing.JLabel();
        DashboardMinimize = new javax.swing.JLabel();
        DashboardKeluarButton = new javax.swing.JLabel();
        DashboardPengaturanButton = new javax.swing.JLabel();
        DashboardBerandaButton = new javax.swing.JLabel();
        DashboardMUserButton = new javax.swing.JLabel();
        DashboardMKasetButton = new javax.swing.JLabel();
        DashboardSewaButton = new javax.swing.JLabel();
        DashboardLaporanButton = new javax.swing.JLabel();
        DashboardLoginUsername = new javax.swing.JLabel();
        DashboardContent = new javax.swing.JPanel();
        DashboardContentBeranda = new javax.swing.JPanel();
        DashboardContentBerandaTitle = new javax.swing.JLabel();
        DashboardContentBerandaTitle1 = new javax.swing.JLabel();
        DashboardContentMUser = new javax.swing.JPanel();
        DashboardContentMUserTitle = new javax.swing.JLabel();
        DashboardMUserCariButton = new javax.swing.JLabel();
        DashboardMUserCariInput = new javax.swing.JTextField();
        DashboardMUserCariInputLine = new javax.swing.JPanel();
        DashboardMUserJenis = new javax.swing.JComboBox<>();
        DashboardMUserScrollPanel = new javax.swing.JScrollPane();
        DashboardMUserTable = new javax.swing.JTable();
        DashboardMUserTambahButton = new javax.swing.JLabel();
        DashboardMUserUbahButton = new javax.swing.JLabel();
        DashboardMUserHapusButton = new javax.swing.JLabel();
        DashboardMUserSegarkanButton = new javax.swing.JLabel();
        DashboardContentMKaset = new javax.swing.JPanel();
        DashboardContentMKasetTitle = new javax.swing.JLabel();
        DashboardMKasetCariButton = new javax.swing.JLabel();
        DashboardMKasetCariInput = new javax.swing.JTextField();
        DashboardMKasetCariInputLine = new javax.swing.JPanel();
        DashboardMKasetJenis = new javax.swing.JComboBox<>();
        DashboardMKasetScrollPanel = new javax.swing.JScrollPane();
        DashboardMKasetTable = new javax.swing.JTable();
        DashboardMKasetTambahButton = new javax.swing.JLabel();
        DashboardMKasetUbahButton = new javax.swing.JLabel();
        DashboardMKasetHapusButton = new javax.swing.JLabel();
        DashboardMKasetSegarkanButton = new javax.swing.JLabel();
        DashboardContentSewa = new javax.swing.JPanel();
        DashboardContentSewaTitle = new javax.swing.JLabel();
        DashboardMKasetScrollPanel1 = new javax.swing.JScrollPane();
        DashboardSewaTable = new javax.swing.JTable();
        DashboardMKasetCariButton1 = new javax.swing.JLabel();
        DashboardMKasetCariInput1 = new javax.swing.JTextField();
        DashboardMKasetCariInputLine1 = new javax.swing.JPanel();
        DashboardMKasetJenis1 = new javax.swing.JComboBox<>();
        DashboardMKasetTambahButton1 = new javax.swing.JLabel();
        DashboardMKasetUbahButton1 = new javax.swing.JLabel();
        DashboardMKasetSegarkanButton1 = new javax.swing.JLabel();
        DashboardContentLaporan = new javax.swing.JPanel();
        DashboardContentLaporanTitle = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        DashboardContentLaporanTitle1 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        DashboardMKasetScrollPanel2 = new javax.swing.JScrollPane();
        DashboardSewaTable1 = new javax.swing.JTable();
        DashboardMKasetCariButton3 = new javax.swing.JLabel();
        DashboardContentLaporanTitle2 = new javax.swing.JLabel();
        DashboardContentLaporanTitle3 = new javax.swing.JLabel();
        DashboardContentLaporanTitle4 = new javax.swing.JLabel();

        DeleteDialogYesNo.setUndecorated(true);
        DeleteDialogYesNo.setSize(new java.awt.Dimension(400, 300));

        DeleteDialogMainPanel.setBackground(new java.awt.Color(35, 39, 42));
        DeleteDialogMainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));

        DeleteDialogHeader.setBackground(new java.awt.Color(32, 34, 37));

        DialogDelete_Close.setBackground(new java.awt.Color(32, 34, 37));
        DialogDelete_Close.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        DialogDelete_Close.setForeground(new java.awt.Color(255, 255, 255));
        DialogDelete_Close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DialogDelete_Close.setText("X");
        DialogDelete_Close.setOpaque(true);
        DialogDelete_Close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DialogDelete_CloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DialogDelete_CloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DialogDelete_CloseMouseExited(evt);
            }
        });

        DialogDelete_Title.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        DialogDelete_Title.setForeground(new java.awt.Color(255, 255, 255));
        DialogDelete_Title.setText("Informasi");

        javax.swing.GroupLayout DeleteDialogHeaderLayout = new javax.swing.GroupLayout(DeleteDialogHeader);
        DeleteDialogHeader.setLayout(DeleteDialogHeaderLayout);
        DeleteDialogHeaderLayout.setHorizontalGroup(
            DeleteDialogHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeleteDialogHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DialogDelete_Title, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DialogDelete_Close, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        DeleteDialogHeaderLayout.setVerticalGroup(
            DeleteDialogHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeleteDialogHeaderLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(DeleteDialogHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DialogDelete_Close, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(DialogDelete_Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        DialogDelete_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LogoAsk.png"))); // NOI18N

        DialogDelete_Message.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        DialogDelete_Message.setForeground(new java.awt.Color(255, 255, 255));
        DialogDelete_Message.setText("Apakah anda yakin ingin mehapus data ini?");
        DialogDelete_Message.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        DialogDeleteTidakButton.setBackground(new java.awt.Color(114, 137, 218));
        DialogDeleteTidakButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DialogDeleteTidakButton.setForeground(new java.awt.Color(255, 255, 255));
        DialogDeleteTidakButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DialogDeleteTidakButton.setText("Tidak");
        DialogDeleteTidakButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DialogDeleteTidakButton.setMaximumSize(new java.awt.Dimension(80, 30));
        DialogDeleteTidakButton.setMinimumSize(new java.awt.Dimension(80, 30));
        DialogDeleteTidakButton.setOpaque(true);
        DialogDeleteTidakButton.setPreferredSize(new java.awt.Dimension(80, 30));
        DialogDeleteTidakButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DialogDeleteTidakButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DialogDeleteTidakButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DialogDeleteTidakButtonMouseExited(evt);
            }
        });

        DialogDeleteYaButton.setBackground(new java.awt.Color(114, 137, 218));
        DialogDeleteYaButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DialogDeleteYaButton.setForeground(new java.awt.Color(255, 255, 255));
        DialogDeleteYaButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DialogDeleteYaButton.setText("Ya");
        DialogDeleteYaButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DialogDeleteYaButton.setMaximumSize(new java.awt.Dimension(80, 30));
        DialogDeleteYaButton.setMinimumSize(new java.awt.Dimension(80, 30));
        DialogDeleteYaButton.setOpaque(true);
        DialogDeleteYaButton.setPreferredSize(new java.awt.Dimension(80, 30));
        DialogDeleteYaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DialogDeleteYaButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DialogDeleteYaButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DialogDeleteYaButtonMouseExited(evt);
            }
        });

        DialogDeleteScrollPanel.setBorder(null);

        DialogDeleteDetail.setColumns(20);
        DialogDeleteDetail.setRows(5);
        DialogDeleteDetail.setEnabled(false);
        DialogDeleteScrollPanel.setViewportView(DialogDeleteDetail);

        javax.swing.GroupLayout DeleteDialogMainPanelLayout = new javax.swing.GroupLayout(DeleteDialogMainPanel);
        DeleteDialogMainPanel.setLayout(DeleteDialogMainPanelLayout);
        DeleteDialogMainPanelLayout.setHorizontalGroup(
            DeleteDialogMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DeleteDialogHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeleteDialogMainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DeleteDialogMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(DeleteDialogMainPanelLayout.createSequentialGroup()
                        .addComponent(DialogDelete_Icon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DeleteDialogMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DeleteDialogMainPanelLayout.createSequentialGroup()
                                .addComponent(DialogDelete_Message, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(65, 65, 65))
                            .addComponent(DialogDeleteScrollPanel)))
                    .addGroup(DeleteDialogMainPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(DialogDeleteYaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DialogDeleteTidakButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );
        DeleteDialogMainPanelLayout.setVerticalGroup(
            DeleteDialogMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeleteDialogMainPanelLayout.createSequentialGroup()
                .addComponent(DeleteDialogHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DeleteDialogMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DialogDelete_Icon)
                    .addGroup(DeleteDialogMainPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(DialogDelete_Message, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(DialogDeleteScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(DeleteDialogMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DialogDeleteTidakButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DialogDeleteYaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DeleteDialogYesNoLayout = new javax.swing.GroupLayout(DeleteDialogYesNo.getContentPane());
        DeleteDialogYesNo.getContentPane().setLayout(DeleteDialogYesNoLayout);
        DeleteDialogYesNoLayout.setHorizontalGroup(
            DeleteDialogYesNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DeleteDialogMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DeleteDialogYesNoLayout.setVerticalGroup(
            DeleteDialogYesNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DeleteDialogMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        UbahTambahUserDialog.setUndecorated(true);
        UbahTambahUserDialog.setSize(new java.awt.Dimension(740, 520));

        UTUserMainPanel.setBackground(new java.awt.Color(44, 47, 51));
        UTUserMainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        UTUserMainPanel.setPreferredSize(new java.awt.Dimension(740, 520));

        UTUserHeaderPanel.setBackground(new java.awt.Color(32, 34, 37));
        UTUserHeaderPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                UTUserHeaderPanelMouseDragged(evt);
            }
        });
        UTUserHeaderPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                UTUserHeaderPanelMousePressed(evt);
            }
        });

        UTUserHeaderTitle.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        UTUserHeaderTitle.setForeground(new java.awt.Color(255, 255, 255));
        UTUserHeaderTitle.setText("Informasi");

        UTUserButtonClose.setBackground(new java.awt.Color(32, 34, 37));
        UTUserButtonClose.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        UTUserButtonClose.setForeground(new java.awt.Color(255, 255, 255));
        UTUserButtonClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UTUserButtonClose.setText("X");
        UTUserButtonClose.setOpaque(true);
        UTUserButtonClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UTUserButtonCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UTUserButtonCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UTUserButtonCloseMouseExited(evt);
            }
        });

        javax.swing.GroupLayout UTUserHeaderPanelLayout = new javax.swing.GroupLayout(UTUserHeaderPanel);
        UTUserHeaderPanel.setLayout(UTUserHeaderPanelLayout);
        UTUserHeaderPanelLayout.setHorizontalGroup(
            UTUserHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UTUserHeaderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(UTUserHeaderTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 506, Short.MAX_VALUE)
                .addComponent(UTUserButtonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        UTUserHeaderPanelLayout.setVerticalGroup(
            UTUserHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UTUserHeaderPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(UTUserHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(UTUserButtonClose, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(UTUserHeaderTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        UTUserUsernameInputLine.setBackground(new java.awt.Color(35, 39, 42));

        javax.swing.GroupLayout UTUserUsernameInputLineLayout = new javax.swing.GroupLayout(UTUserUsernameInputLine);
        UTUserUsernameInputLine.setLayout(UTUserUsernameInputLineLayout);
        UTUserUsernameInputLineLayout.setHorizontalGroup(
            UTUserUsernameInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        UTUserUsernameInputLineLayout.setVerticalGroup(
            UTUserUsernameInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        UTUserUsernameInputTitle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        UTUserUsernameInputTitle.setForeground(new java.awt.Color(255, 255, 255));
        UTUserUsernameInputTitle.setText(" ");

        UTUserUsernameInput.setBackground(new java.awt.Color(44, 47, 51));
        UTUserUsernameInput.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        UTUserUsernameInput.setForeground(new java.awt.Color(255, 255, 255));
        UTUserUsernameInput.setText("Username");
        UTUserUsernameInput.setBorder(null);
        UTUserUsernameInput.setOpaque(false);
        UTUserUsernameInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UTUserUsernameInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                UTUserUsernameInputFocusLost(evt);
            }
        });

        UTUserNMLengkapInputTitle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        UTUserNMLengkapInputTitle.setForeground(new java.awt.Color(255, 255, 255));
        UTUserNMLengkapInputTitle.setText(" ");

        UTUserNMLengkapInput.setBackground(new java.awt.Color(44, 47, 51));
        UTUserNMLengkapInput.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        UTUserNMLengkapInput.setForeground(new java.awt.Color(255, 255, 255));
        UTUserNMLengkapInput.setText("Nama Lengkap");
        UTUserNMLengkapInput.setBorder(null);
        UTUserNMLengkapInput.setOpaque(false);
        UTUserNMLengkapInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UTUserNMLengkapInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                UTUserNMLengkapInputFocusLost(evt);
            }
        });
        UTUserNMLengkapInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                UTUserNMLengkapInputKeyTyped(evt);
            }
        });

        UTUserNMLengkapInputLine.setBackground(new java.awt.Color(35, 39, 42));

        javax.swing.GroupLayout UTUserNMLengkapInputLineLayout = new javax.swing.GroupLayout(UTUserNMLengkapInputLine);
        UTUserNMLengkapInputLine.setLayout(UTUserNMLengkapInputLineLayout);
        UTUserNMLengkapInputLineLayout.setHorizontalGroup(
            UTUserNMLengkapInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        UTUserNMLengkapInputLineLayout.setVerticalGroup(
            UTUserNMLengkapInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        UTUserAlamatInputTitle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        UTUserAlamatInputTitle.setForeground(new java.awt.Color(255, 255, 255));
        UTUserAlamatInputTitle.setText(" ");

        UTUserAlamatInput.setBackground(new java.awt.Color(44, 47, 51));
        UTUserAlamatInput.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        UTUserAlamatInput.setForeground(new java.awt.Color(255, 255, 255));
        UTUserAlamatInput.setText("Alamat");
        UTUserAlamatInput.setBorder(null);
        UTUserAlamatInput.setOpaque(false);
        UTUserAlamatInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UTUserAlamatInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                UTUserAlamatInputFocusLost(evt);
            }
        });

        UTUserAlamatInputLine.setBackground(new java.awt.Color(35, 39, 42));

        javax.swing.GroupLayout UTUserAlamatInputLineLayout = new javax.swing.GroupLayout(UTUserAlamatInputLine);
        UTUserAlamatInputLine.setLayout(UTUserAlamatInputLineLayout);
        UTUserAlamatInputLineLayout.setHorizontalGroup(
            UTUserAlamatInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        UTUserAlamatInputLineLayout.setVerticalGroup(
            UTUserAlamatInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        UTUserPasswordInputTitle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        UTUserPasswordInputTitle.setForeground(new java.awt.Color(255, 255, 255));
        UTUserPasswordInputTitle.setText(" ");

        UTUserPasswordInput.setBackground(new java.awt.Color(44, 47, 51));
        UTUserPasswordInput.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        UTUserPasswordInput.setForeground(new java.awt.Color(255, 255, 255));
        UTUserPasswordInput.setText("Password");
        UTUserPasswordInput.setBorder(null);
        UTUserPasswordInput.setOpaque(false);
        UTUserPasswordInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UTUserPasswordInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                UTUserPasswordInputFocusLost(evt);
            }
        });

        UTUserPasswordInputLine.setBackground(new java.awt.Color(35, 39, 42));

        javax.swing.GroupLayout UTUserPasswordInputLineLayout = new javax.swing.GroupLayout(UTUserPasswordInputLine);
        UTUserPasswordInputLine.setLayout(UTUserPasswordInputLineLayout);
        UTUserPasswordInputLineLayout.setHorizontalGroup(
            UTUserPasswordInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        UTUserPasswordInputLineLayout.setVerticalGroup(
            UTUserPasswordInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        UTUserJabatanInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pelanggan", "Karyawan", "Pemilik" }));

        UTUserTeleponInput.setBackground(new java.awt.Color(44, 47, 51));
        UTUserTeleponInput.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        UTUserTeleponInput.setForeground(new java.awt.Color(255, 255, 255));
        UTUserTeleponInput.setText("Telepon");
        UTUserTeleponInput.setBorder(null);
        UTUserTeleponInput.setOpaque(false);
        UTUserTeleponInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UTUserTeleponInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                UTUserTeleponInputFocusLost(evt);
            }
        });
        UTUserTeleponInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                UTUserTeleponInputKeyTyped(evt);
            }
        });

        UTUserTeleponInputLine.setBackground(new java.awt.Color(35, 39, 42));

        javax.swing.GroupLayout UTUserTeleponInputLineLayout = new javax.swing.GroupLayout(UTUserTeleponInputLine);
        UTUserTeleponInputLine.setLayout(UTUserTeleponInputLineLayout);
        UTUserTeleponInputLineLayout.setHorizontalGroup(
            UTUserTeleponInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        UTUserTeleponInputLineLayout.setVerticalGroup(
            UTUserTeleponInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        UTUserTeleponInputTitle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        UTUserTeleponInputTitle.setForeground(new java.awt.Color(255, 255, 255));
        UTUserTeleponInputTitle.setText(" ");

        UTUserNikKtpInput.setBackground(new java.awt.Color(44, 47, 51));
        UTUserNikKtpInput.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        UTUserNikKtpInput.setForeground(new java.awt.Color(255, 255, 255));
        UTUserNikKtpInput.setText("Nik KTP");
        UTUserNikKtpInput.setBorder(null);
        UTUserNikKtpInput.setOpaque(false);
        UTUserNikKtpInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UTUserNikKtpInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                UTUserNikKtpInputFocusLost(evt);
            }
        });
        UTUserNikKtpInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                UTUserNikKtpInputKeyTyped(evt);
            }
        });

        UTUserNikKtpInputLine.setBackground(new java.awt.Color(35, 39, 42));

        javax.swing.GroupLayout UTUserNikKtpInputLineLayout = new javax.swing.GroupLayout(UTUserNikKtpInputLine);
        UTUserNikKtpInputLine.setLayout(UTUserNikKtpInputLineLayout);
        UTUserNikKtpInputLineLayout.setHorizontalGroup(
            UTUserNikKtpInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        UTUserNikKtpInputLineLayout.setVerticalGroup(
            UTUserNikKtpInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        UTUserNikKtpInputTitle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        UTUserNikKtpInputTitle.setForeground(new java.awt.Color(255, 255, 255));
        UTUserNikKtpInputTitle.setText(" ");

        UTUserTitle.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        UTUserTitle.setForeground(new java.awt.Color(255, 255, 255));
        UTUserTitle.setText("Tambah Data");

        UTUserButtonBatal.setBackground(new java.awt.Color(114, 137, 218));
        UTUserButtonBatal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        UTUserButtonBatal.setForeground(new java.awt.Color(255, 255, 255));
        UTUserButtonBatal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UTUserButtonBatal.setText("Batal");
        UTUserButtonBatal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UTUserButtonBatal.setOpaque(true);
        UTUserButtonBatal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UTUserButtonBatalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UTUserButtonBatalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UTUserButtonBatalMouseExited(evt);
            }
        });

        UTUserButtonTambah.setBackground(new java.awt.Color(114, 137, 218));
        UTUserButtonTambah.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        UTUserButtonTambah.setForeground(new java.awt.Color(255, 255, 255));
        UTUserButtonTambah.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UTUserButtonTambah.setText("Tambah");
        UTUserButtonTambah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UTUserButtonTambah.setOpaque(true);
        UTUserButtonTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UTUserButtonTambahMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UTUserButtonTambahMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UTUserButtonTambahMouseExited(evt);
            }
        });

        UTUserEmailInput.setBackground(new java.awt.Color(44, 47, 51));
        UTUserEmailInput.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        UTUserEmailInput.setForeground(new java.awt.Color(255, 255, 255));
        UTUserEmailInput.setText("Email");
        UTUserEmailInput.setBorder(null);
        UTUserEmailInput.setOpaque(false);
        UTUserEmailInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UTUserEmailInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                UTUserEmailInputFocusLost(evt);
            }
        });

        UTUserEmailInputLine.setBackground(new java.awt.Color(35, 39, 42));

        javax.swing.GroupLayout UTUserEmailInputLineLayout = new javax.swing.GroupLayout(UTUserEmailInputLine);
        UTUserEmailInputLine.setLayout(UTUserEmailInputLineLayout);
        UTUserEmailInputLineLayout.setHorizontalGroup(
            UTUserEmailInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        UTUserEmailInputLineLayout.setVerticalGroup(
            UTUserEmailInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        UTUserEmailInputTitle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        UTUserEmailInputTitle.setForeground(new java.awt.Color(255, 255, 255));
        UTUserEmailInputTitle.setText(" ");

        UTUserJabatanTitle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        UTUserJabatanTitle.setForeground(new java.awt.Color(255, 255, 255));
        UTUserJabatanTitle.setText("Jabatan");

        UTUserTanggalLahirTitle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        UTUserTanggalLahirTitle.setForeground(new java.awt.Color(255, 255, 255));
        UTUserTanggalLahirTitle.setText("Tanggal Lahir");

        UTUserTanggalLahirInput.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout UTUserMainPanelLayout = new javax.swing.GroupLayout(UTUserMainPanel);
        UTUserMainPanel.setLayout(UTUserMainPanelLayout);
        UTUserMainPanelLayout.setHorizontalGroup(
            UTUserMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UTUserHeaderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UTUserMainPanelLayout.createSequentialGroup()
                .addGroup(UTUserMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(UTUserMainPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(UTUserButtonBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(UTUserButtonTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UTUserMainPanelLayout.createSequentialGroup()
                        .addGroup(UTUserMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(UTUserMainPanelLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(UTUserMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(UTUserUsernameInputTitle)
                                    .addComponent(UTUserUsernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(UTUserUsernameInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(UTUserNMLengkapInputTitle)
                                    .addComponent(UTUserNMLengkapInput, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(UTUserNMLengkapInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(UTUserMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(UTUserAlamatInputTitle)
                                        .addComponent(UTUserAlamatInput)
                                        .addComponent(UTUserNikKtpInputTitle)
                                        .addComponent(UTUserNikKtpInput)
                                        .addComponent(UTUserNikKtpInputLine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(UTUserTeleponInputTitle)
                                        .addComponent(UTUserTeleponInput)
                                        .addComponent(UTUserTeleponInputLine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(UTUserAlamatInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(UTUserMainPanelLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(UTUserTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(UTUserMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(UTUserPasswordInputTitle)
                            .addComponent(UTUserPasswordInput, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(UTUserPasswordInputLine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(UTUserJabatanInput, 0, 300, Short.MAX_VALUE)
                            .addComponent(UTUserEmailInputTitle)
                            .addComponent(UTUserEmailInput)
                            .addComponent(UTUserEmailInputLine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(UTUserJabatanTitle)
                            .addComponent(UTUserTanggalLahirTitle)
                            .addComponent(UTUserTanggalLahirInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(56, 56, 56))
        );
        UTUserMainPanelLayout.setVerticalGroup(
            UTUserMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UTUserMainPanelLayout.createSequentialGroup()
                .addComponent(UTUserHeaderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UTUserTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(UTUserMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(UTUserMainPanelLayout.createSequentialGroup()
                        .addComponent(UTUserUsernameInputTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UTUserUsernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UTUserUsernameInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UTUserNMLengkapInputTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UTUserNMLengkapInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UTUserNMLengkapInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UTUserMainPanelLayout.createSequentialGroup()
                        .addComponent(UTUserPasswordInputTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UTUserPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UTUserPasswordInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(UTUserEmailInputTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UTUserEmailInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UTUserEmailInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(UTUserMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UTUserAlamatInputTitle)
                    .addComponent(UTUserJabatanTitle))
                .addGroup(UTUserMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UTUserMainPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UTUserAlamatInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UTUserAlamatInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UTUserNikKtpInputTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UTUserNikKtpInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UTUserNikKtpInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UTUserMainPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(UTUserJabatanInput, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(UTUserTanggalLahirTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UTUserTanggalLahirInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(UTUserMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UTUserMainPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UTUserTeleponInputTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(UTUserTeleponInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UTUserTeleponInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UTUserMainPanelLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(UTUserMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UTUserButtonTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UTUserButtonBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout UbahTambahUserDialogLayout = new javax.swing.GroupLayout(UbahTambahUserDialog.getContentPane());
        UbahTambahUserDialog.getContentPane().setLayout(UbahTambahUserDialogLayout);
        UbahTambahUserDialogLayout.setHorizontalGroup(
            UbahTambahUserDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UTUserMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        UbahTambahUserDialogLayout.setVerticalGroup(
            UbahTambahUserDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UTUserMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        UbahTambahDialogYesNo.setUndecorated(true);
        UbahTambahDialogYesNo.setSize(new java.awt.Dimension(400, 300));

        UbahTambahDialogMainPanel.setBackground(new java.awt.Color(35, 39, 42));
        UbahTambahDialogMainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));

        UbahTambahDialogHeader.setBackground(new java.awt.Color(32, 34, 37));

        UbahTambahDialog_Close.setBackground(new java.awt.Color(32, 34, 37));
        UbahTambahDialog_Close.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        UbahTambahDialog_Close.setForeground(new java.awt.Color(255, 255, 255));
        UbahTambahDialog_Close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UbahTambahDialog_Close.setText("X");
        UbahTambahDialog_Close.setOpaque(true);
        UbahTambahDialog_Close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UbahTambahDialog_CloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UbahTambahDialog_CloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UbahTambahDialog_CloseMouseExited(evt);
            }
        });

        UbahTambahDialog_Title.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        UbahTambahDialog_Title.setForeground(new java.awt.Color(255, 255, 255));
        UbahTambahDialog_Title.setText("Informasi");

        javax.swing.GroupLayout UbahTambahDialogHeaderLayout = new javax.swing.GroupLayout(UbahTambahDialogHeader);
        UbahTambahDialogHeader.setLayout(UbahTambahDialogHeaderLayout);
        UbahTambahDialogHeaderLayout.setHorizontalGroup(
            UbahTambahDialogHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UbahTambahDialogHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(UbahTambahDialog_Title, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(UbahTambahDialog_Close, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        UbahTambahDialogHeaderLayout.setVerticalGroup(
            UbahTambahDialogHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UbahTambahDialogHeaderLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(UbahTambahDialogHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(UbahTambahDialog_Close, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(UbahTambahDialog_Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        UbahTambahDialog_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LogoAsk.png"))); // NOI18N

        UbahTambahDialog_Message.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        UbahTambahDialog_Message.setForeground(new java.awt.Color(255, 255, 255));
        UbahTambahDialog_Message.setText("Apakah anda yakin ingin meubah data ini?");
        UbahTambahDialog_Message.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        UbahTambahDialogTidakButton.setBackground(new java.awt.Color(114, 137, 218));
        UbahTambahDialogTidakButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        UbahTambahDialogTidakButton.setForeground(new java.awt.Color(255, 255, 255));
        UbahTambahDialogTidakButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UbahTambahDialogTidakButton.setText("Tidak");
        UbahTambahDialogTidakButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UbahTambahDialogTidakButton.setMaximumSize(new java.awt.Dimension(80, 30));
        UbahTambahDialogTidakButton.setMinimumSize(new java.awt.Dimension(80, 30));
        UbahTambahDialogTidakButton.setOpaque(true);
        UbahTambahDialogTidakButton.setPreferredSize(new java.awt.Dimension(80, 30));
        UbahTambahDialogTidakButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UbahTambahDialogTidakButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UbahTambahDialogTidakButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UbahTambahDialogTidakButtonMouseExited(evt);
            }
        });

        UbahTambahDialogYaButton.setBackground(new java.awt.Color(114, 137, 218));
        UbahTambahDialogYaButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        UbahTambahDialogYaButton.setForeground(new java.awt.Color(255, 255, 255));
        UbahTambahDialogYaButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UbahTambahDialogYaButton.setText("Ya");
        UbahTambahDialogYaButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UbahTambahDialogYaButton.setMaximumSize(new java.awt.Dimension(80, 30));
        UbahTambahDialogYaButton.setMinimumSize(new java.awt.Dimension(80, 30));
        UbahTambahDialogYaButton.setOpaque(true);
        UbahTambahDialogYaButton.setPreferredSize(new java.awt.Dimension(80, 30));
        UbahTambahDialogYaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UbahTambahDialogYaButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UbahTambahDialogYaButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UbahTambahDialogYaButtonMouseExited(evt);
            }
        });

        UbahTambahDialogScrollPanel.setBorder(null);

        UbahTambahDialogDetail.setColumns(20);
        UbahTambahDialogDetail.setRows(5);
        UbahTambahDialogDetail.setEnabled(false);
        UbahTambahDialogScrollPanel.setViewportView(UbahTambahDialogDetail);

        javax.swing.GroupLayout UbahTambahDialogMainPanelLayout = new javax.swing.GroupLayout(UbahTambahDialogMainPanel);
        UbahTambahDialogMainPanel.setLayout(UbahTambahDialogMainPanelLayout);
        UbahTambahDialogMainPanelLayout.setHorizontalGroup(
            UbahTambahDialogMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UbahTambahDialogHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UbahTambahDialogMainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UbahTambahDialogMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(UbahTambahDialogMainPanelLayout.createSequentialGroup()
                        .addComponent(UbahTambahDialog_Icon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(UbahTambahDialogMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(UbahTambahDialogMainPanelLayout.createSequentialGroup()
                                .addComponent(UbahTambahDialog_Message, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(65, 65, 65))
                            .addComponent(UbahTambahDialogScrollPanel)))
                    .addGroup(UbahTambahDialogMainPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(UbahTambahDialogYaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(UbahTambahDialogTidakButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );
        UbahTambahDialogMainPanelLayout.setVerticalGroup(
            UbahTambahDialogMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UbahTambahDialogMainPanelLayout.createSequentialGroup()
                .addComponent(UbahTambahDialogHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(UbahTambahDialogMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UbahTambahDialog_Icon)
                    .addGroup(UbahTambahDialogMainPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(UbahTambahDialog_Message, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(UbahTambahDialogScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(UbahTambahDialogMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UbahTambahDialogTidakButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UbahTambahDialogYaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout UbahTambahDialogYesNoLayout = new javax.swing.GroupLayout(UbahTambahDialogYesNo.getContentPane());
        UbahTambahDialogYesNo.getContentPane().setLayout(UbahTambahDialogYesNoLayout);
        UbahTambahDialogYesNoLayout.setHorizontalGroup(
            UbahTambahDialogYesNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UbahTambahDialogMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        UbahTambahDialogYesNoLayout.setVerticalGroup(
            UbahTambahDialogYesNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UbahTambahDialogMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        UbahTambahKasetDialog.setUndecorated(true);
        UbahTambahKasetDialog.setSize(new java.awt.Dimension(760, 420));

        UTKasetMainPanel.setBackground(new java.awt.Color(44, 47, 51));
        UTKasetMainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));

        UTKasetHeaderPanel.setBackground(new java.awt.Color(32, 34, 37));
        UTKasetHeaderPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                UTKasetHeaderPanelMouseDragged(evt);
            }
        });
        UTKasetHeaderPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                UTKasetHeaderPanelMousePressed(evt);
            }
        });

        UTKasetHeaderTitle.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        UTKasetHeaderTitle.setForeground(new java.awt.Color(255, 255, 255));
        UTKasetHeaderTitle.setText("Informasi");

        UTKasetButtonClose.setBackground(new java.awt.Color(32, 34, 37));
        UTKasetButtonClose.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        UTKasetButtonClose.setForeground(new java.awt.Color(255, 255, 255));
        UTKasetButtonClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UTKasetButtonClose.setText("X");
        UTKasetButtonClose.setOpaque(true);
        UTKasetButtonClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UTKasetButtonCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UTKasetButtonCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UTKasetButtonCloseMouseExited(evt);
            }
        });

        javax.swing.GroupLayout UTKasetHeaderPanelLayout = new javax.swing.GroupLayout(UTKasetHeaderPanel);
        UTKasetHeaderPanel.setLayout(UTKasetHeaderPanelLayout);
        UTKasetHeaderPanelLayout.setHorizontalGroup(
            UTKasetHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UTKasetHeaderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(UTKasetHeaderTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 526, Short.MAX_VALUE)
                .addComponent(UTKasetButtonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        UTKasetHeaderPanelLayout.setVerticalGroup(
            UTKasetHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UTKasetHeaderPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(UTKasetHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(UTKasetButtonClose, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(UTKasetHeaderTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        UTKasetButtonBatal.setBackground(new java.awt.Color(114, 137, 218));
        UTKasetButtonBatal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        UTKasetButtonBatal.setForeground(new java.awt.Color(255, 255, 255));
        UTKasetButtonBatal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UTKasetButtonBatal.setText("Batal");
        UTKasetButtonBatal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UTKasetButtonBatal.setOpaque(true);
        UTKasetButtonBatal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UTKasetButtonBatalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UTKasetButtonBatalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UTKasetButtonBatalMouseExited(evt);
            }
        });

        UTKasetButtonTambah.setBackground(new java.awt.Color(114, 137, 218));
        UTKasetButtonTambah.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        UTKasetButtonTambah.setForeground(new java.awt.Color(255, 255, 255));
        UTKasetButtonTambah.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UTKasetButtonTambah.setText("Tambah");
        UTKasetButtonTambah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UTKasetButtonTambah.setOpaque(true);
        UTKasetButtonTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UTKasetButtonTambahMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UTKasetButtonTambahMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UTKasetButtonTambahMouseExited(evt);
            }
        });

        UTKasetJumlahKepingInput.setBackground(new java.awt.Color(44, 47, 51));
        UTKasetJumlahKepingInput.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        UTKasetJumlahKepingInput.setForeground(new java.awt.Color(255, 255, 255));
        UTKasetJumlahKepingInput.setText("Jumlah Keping");
        UTKasetJumlahKepingInput.setBorder(null);
        UTKasetJumlahKepingInput.setOpaque(false);
        UTKasetJumlahKepingInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UTKasetJumlahKepingInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                UTKasetJumlahKepingInputFocusLost(evt);
            }
        });
        UTKasetJumlahKepingInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                UTKasetJumlahKepingInputKeyTyped(evt);
            }
        });

        UTKasetStokInput.setBackground(new java.awt.Color(44, 47, 51));
        UTKasetStokInput.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        UTKasetStokInput.setForeground(new java.awt.Color(255, 255, 255));
        UTKasetStokInput.setText("Stok");
        UTKasetStokInput.setBorder(null);
        UTKasetStokInput.setOpaque(false);
        UTKasetStokInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UTKasetStokInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                UTKasetStokInputFocusLost(evt);
            }
        });
        UTKasetStokInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                UTKasetStokInputKeyTyped(evt);
            }
        });

        UTKasetHargaInputTitle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        UTKasetHargaInputTitle.setForeground(new java.awt.Color(255, 255, 255));
        UTKasetHargaInputTitle.setText(" ");

        UTKasetJumlahKepingInputLine.setBackground(new java.awt.Color(35, 39, 42));

        javax.swing.GroupLayout UTKasetJumlahKepingInputLineLayout = new javax.swing.GroupLayout(UTKasetJumlahKepingInputLine);
        UTKasetJumlahKepingInputLine.setLayout(UTKasetJumlahKepingInputLineLayout);
        UTKasetJumlahKepingInputLineLayout.setHorizontalGroup(
            UTKasetJumlahKepingInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        UTKasetJumlahKepingInputLineLayout.setVerticalGroup(
            UTKasetJumlahKepingInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        UTKasetStokInputLine.setBackground(new java.awt.Color(35, 39, 42));

        javax.swing.GroupLayout UTKasetStokInputLineLayout = new javax.swing.GroupLayout(UTKasetStokInputLine);
        UTKasetStokInputLine.setLayout(UTKasetStokInputLineLayout);
        UTKasetStokInputLineLayout.setHorizontalGroup(
            UTKasetStokInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        UTKasetStokInputLineLayout.setVerticalGroup(
            UTKasetStokInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        UTKasetNamaInputTitle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        UTKasetNamaInputTitle.setForeground(new java.awt.Color(255, 255, 255));
        UTKasetNamaInputTitle.setText(" ");

        UTKasetJumlahKepingInputTitle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        UTKasetJumlahKepingInputTitle.setForeground(new java.awt.Color(255, 255, 255));
        UTKasetJumlahKepingInputTitle.setText(" ");

        UTKasetHargaInput.setBackground(new java.awt.Color(44, 47, 51));
        UTKasetHargaInput.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        UTKasetHargaInput.setForeground(new java.awt.Color(255, 255, 255));
        UTKasetHargaInput.setText("Harga");
        UTKasetHargaInput.setBorder(null);
        UTKasetHargaInput.setOpaque(false);
        UTKasetHargaInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UTKasetHargaInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                UTKasetHargaInputFocusLost(evt);
            }
        });
        UTKasetHargaInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                UTKasetHargaInputKeyTyped(evt);
            }
        });

        UTKasetNamaInput.setBackground(new java.awt.Color(44, 47, 51));
        UTKasetNamaInput.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        UTKasetNamaInput.setForeground(new java.awt.Color(255, 255, 255));
        UTKasetNamaInput.setText("Nama");
        UTKasetNamaInput.setBorder(null);
        UTKasetNamaInput.setOpaque(false);
        UTKasetNamaInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UTKasetNamaInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                UTKasetNamaInputFocusLost(evt);
            }
        });
        UTKasetNamaInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                UTKasetNamaInputKeyTyped(evt);
            }
        });

        UTKasetNamaInputLine.setBackground(new java.awt.Color(35, 39, 42));

        javax.swing.GroupLayout UTKasetNamaInputLineLayout = new javax.swing.GroupLayout(UTKasetNamaInputLine);
        UTKasetNamaInputLine.setLayout(UTKasetNamaInputLineLayout);
        UTKasetNamaInputLineLayout.setHorizontalGroup(
            UTKasetNamaInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        UTKasetNamaInputLineLayout.setVerticalGroup(
            UTKasetNamaInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        UTKasetHargaInputLine.setBackground(new java.awt.Color(35, 39, 42));

        javax.swing.GroupLayout UTKasetHargaInputLineLayout = new javax.swing.GroupLayout(UTKasetHargaInputLine);
        UTKasetHargaInputLine.setLayout(UTKasetHargaInputLineLayout);
        UTKasetHargaInputLineLayout.setHorizontalGroup(
            UTKasetHargaInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        UTKasetHargaInputLineLayout.setVerticalGroup(
            UTKasetHargaInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        UTKasetStokInputTitle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        UTKasetStokInputTitle.setForeground(new java.awt.Color(255, 255, 255));
        UTKasetStokInputTitle.setText(" ");

        UTKasetTitle.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        UTKasetTitle.setForeground(new java.awt.Color(255, 255, 255));
        UTKasetTitle.setText("Tambah Data");

        UTKasetKategoriInputTitle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        UTKasetKategoriInputTitle.setForeground(new java.awt.Color(255, 255, 255));
        UTKasetKategoriInputTitle.setText("Kategori");

        adventure_c.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        adventure_c.setForeground(new java.awt.Color(255, 255, 255));
        adventure_c.setText("Adventure");
        adventure_c.setOpaque(false);

        fight_c.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fight_c.setForeground(new java.awt.Color(255, 255, 255));
        fight_c.setText("Fight");
        fight_c.setOpaque(false);

        racing_c.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        racing_c.setForeground(new java.awt.Color(255, 255, 255));
        racing_c.setText("Racing");
        racing_c.setOpaque(false);

        scifi_c.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        scifi_c.setForeground(new java.awt.Color(255, 255, 255));
        scifi_c.setText("Sci-fi");
        scifi_c.setOpaque(false);

        classic_c.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        classic_c.setForeground(new java.awt.Color(255, 255, 255));
        classic_c.setText("Classic");
        classic_c.setOpaque(false);

        sport_c.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sport_c.setForeground(new java.awt.Color(255, 255, 255));
        sport_c.setText("Sport");
        sport_c.setOpaque(false);

        horror_c.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        horror_c.setForeground(new java.awt.Color(255, 255, 255));
        horror_c.setText("Horror");
        horror_c.setOpaque(false);

        puzzle_c.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        puzzle_c.setForeground(new java.awt.Color(255, 255, 255));
        puzzle_c.setText("Puzzle");
        puzzle_c.setOpaque(false);

        rpg_c.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rpg_c.setForeground(new java.awt.Color(255, 255, 255));
        rpg_c.setText("RPG");
        rpg_c.setOpaque(false);

        UTKasetKodeInput.setBackground(new java.awt.Color(44, 47, 51));
        UTKasetKodeInput.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        UTKasetKodeInput.setForeground(new java.awt.Color(255, 255, 255));
        UTKasetKodeInput.setText("Kode");
        UTKasetKodeInput.setBorder(null);
        UTKasetKodeInput.setEnabled(false);
        UTKasetKodeInput.setOpaque(false);
        UTKasetKodeInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UTKasetKodeInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                UTKasetKodeInputFocusLost(evt);
            }
        });

        UTKasetKodeInputLine.setBackground(new java.awt.Color(35, 39, 42));

        javax.swing.GroupLayout UTKasetKodeInputLineLayout = new javax.swing.GroupLayout(UTKasetKodeInputLine);
        UTKasetKodeInputLine.setLayout(UTKasetKodeInputLineLayout);
        UTKasetKodeInputLineLayout.setHorizontalGroup(
            UTKasetKodeInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        UTKasetKodeInputLineLayout.setVerticalGroup(
            UTKasetKodeInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        UTKasetKodeInputTitle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        UTKasetKodeInputTitle.setForeground(new java.awt.Color(255, 255, 255));
        UTKasetKodeInputTitle.setText(" ");

        javax.swing.GroupLayout UTKasetMainPanelLayout = new javax.swing.GroupLayout(UTKasetMainPanel);
        UTKasetMainPanel.setLayout(UTKasetMainPanelLayout);
        UTKasetMainPanelLayout.setHorizontalGroup(
            UTKasetMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UTKasetHeaderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(UTKasetMainPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(UTKasetMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(UTKasetMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(UTKasetJumlahKepingInputTitle)
                        .addComponent(UTKasetNamaInputTitle)
                        .addComponent(UTKasetNamaInput, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(UTKasetNamaInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(UTKasetJumlahKepingInput, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(UTKasetJumlahKepingInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(UTKasetKodeInputTitle)
                        .addComponent(UTKasetKodeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(UTKasetKodeInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(UTKasetTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(UTKasetMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UTKasetMainPanelLayout.createSequentialGroup()
                        .addGroup(UTKasetMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(UTKasetMainPanelLayout.createSequentialGroup()
                                .addGroup(UTKasetMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(UTKasetKategoriInputTitle)
                                    .addGroup(UTKasetMainPanelLayout.createSequentialGroup()
                                        .addGroup(UTKasetMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fight_c)
                                            .addComponent(racing_c)
                                            .addComponent(adventure_c))
                                        .addGap(27, 27, 27)
                                        .addGroup(UTKasetMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(classic_c)
                                            .addComponent(scifi_c)
                                            .addComponent(sport_c))))
                                .addGap(39, 39, 39))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UTKasetMainPanelLayout.createSequentialGroup()
                                .addComponent(UTKasetButtonBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)))
                        .addGroup(UTKasetMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rpg_c)
                            .addComponent(puzzle_c)
                            .addComponent(horror_c)
                            .addComponent(UTKasetButtonTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(UTKasetMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(UTKasetStokInputTitle)
                        .addComponent(UTKasetStokInput)
                        .addComponent(UTKasetHargaInputTitle)
                        .addComponent(UTKasetHargaInput)
                        .addComponent(UTKasetHargaInputLine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(UTKasetStokInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        UTKasetMainPanelLayout.setVerticalGroup(
            UTKasetMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UTKasetMainPanelLayout.createSequentialGroup()
                .addComponent(UTKasetHeaderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(UTKasetTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(UTKasetMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UTKasetMainPanelLayout.createSequentialGroup()
                        .addComponent(UTKasetKodeInputTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UTKasetKodeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UTKasetKodeInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UTKasetNamaInputTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UTKasetNamaInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UTKasetNamaInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UTKasetJumlahKepingInputTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UTKasetJumlahKepingInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UTKasetJumlahKepingInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UTKasetMainPanelLayout.createSequentialGroup()
                        .addComponent(UTKasetStokInputTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UTKasetStokInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UTKasetStokInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UTKasetHargaInputTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UTKasetHargaInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UTKasetHargaInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(UTKasetKategoriInputTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(UTKasetMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(UTKasetMainPanelLayout.createSequentialGroup()
                                .addComponent(adventure_c, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fight_c, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(racing_c, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UTKasetMainPanelLayout.createSequentialGroup()
                                .addComponent(sport_c, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(classic_c, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(scifi_c, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(UTKasetMainPanelLayout.createSequentialGroup()
                                .addComponent(horror_c, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(puzzle_c, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rpg_c, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(UTKasetMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UTKasetButtonBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UTKasetButtonTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout UbahTambahKasetDialogLayout = new javax.swing.GroupLayout(UbahTambahKasetDialog.getContentPane());
        UbahTambahKasetDialog.getContentPane().setLayout(UbahTambahKasetDialogLayout);
        UbahTambahKasetDialogLayout.setHorizontalGroup(
            UbahTambahKasetDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UTKasetMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        UbahTambahKasetDialogLayout.setVerticalGroup(
            UbahTambahKasetDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UTKasetMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PengaturanFrame.setUndecorated(true);
        PengaturanFrame.setSize(new java.awt.Dimension(720, 400));

        PengaturanMainPanel.setBackground(new java.awt.Color(44, 47, 51));
        PengaturanMainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));

        PengaturanHeader.setBackground(new java.awt.Color(32, 34, 37));
        PengaturanHeader.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                PengaturanHeaderMouseDragged(evt);
            }
        });
        PengaturanHeader.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PengaturanHeaderMousePressed(evt);
            }
        });

        PengaturanHeaderTitle.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        PengaturanHeaderTitle.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanHeaderTitle.setText("Pengaturan");

        PengaturanButtonClose.setBackground(new java.awt.Color(32, 34, 37));
        PengaturanButtonClose.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        PengaturanButtonClose.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanButtonClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PengaturanButtonClose.setText("X");
        PengaturanButtonClose.setOpaque(true);
        PengaturanButtonClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PengaturanButtonCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PengaturanButtonCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PengaturanButtonCloseMouseExited(evt);
            }
        });

        javax.swing.GroupLayout PengaturanHeaderLayout = new javax.swing.GroupLayout(PengaturanHeader);
        PengaturanHeader.setLayout(PengaturanHeaderLayout);
        PengaturanHeaderLayout.setHorizontalGroup(
            PengaturanHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PengaturanHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PengaturanHeaderTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 486, Short.MAX_VALUE)
                .addComponent(PengaturanButtonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PengaturanHeaderLayout.setVerticalGroup(
            PengaturanHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PengaturanHeaderLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(PengaturanHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PengaturanButtonClose, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(PengaturanHeaderTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        PengaturanButtonBatal.setBackground(new java.awt.Color(114, 137, 218));
        PengaturanButtonBatal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PengaturanButtonBatal.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanButtonBatal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PengaturanButtonBatal.setText("Batal");
        PengaturanButtonBatal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PengaturanButtonBatal.setOpaque(true);
        PengaturanButtonBatal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PengaturanButtonBatalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PengaturanButtonBatalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PengaturanButtonBatalMouseExited(evt);
            }
        });

        PengaturanButtonSimpan.setBackground(new java.awt.Color(114, 137, 218));
        PengaturanButtonSimpan.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PengaturanButtonSimpan.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanButtonSimpan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PengaturanButtonSimpan.setText("Simpan");
        PengaturanButtonSimpan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PengaturanButtonSimpan.setOpaque(true);
        PengaturanButtonSimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PengaturanButtonSimpanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PengaturanButtonSimpanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PengaturanButtonSimpanMouseExited(evt);
            }
        });

        PengaturanUsernameInput.setBackground(new java.awt.Color(44, 47, 51));
        PengaturanUsernameInput.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        PengaturanUsernameInput.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanUsernameInput.setText("Username");
        PengaturanUsernameInput.setBorder(null);
        PengaturanUsernameInput.setOpaque(false);
        PengaturanUsernameInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PengaturanUsernameInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PengaturanUsernameInputFocusLost(evt);
            }
        });

        PengaturanUsernameInputTitle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        PengaturanUsernameInputTitle.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanUsernameInputTitle.setText(" ");

        PengaturanUsernameInputLine.setBackground(new java.awt.Color(35, 39, 42));

        javax.swing.GroupLayout PengaturanUsernameInputLineLayout = new javax.swing.GroupLayout(PengaturanUsernameInputLine);
        PengaturanUsernameInputLine.setLayout(PengaturanUsernameInputLineLayout);
        PengaturanUsernameInputLineLayout.setHorizontalGroup(
            PengaturanUsernameInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        PengaturanUsernameInputLineLayout.setVerticalGroup(
            PengaturanUsernameInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        PengaturanPasswordInput.setBackground(new java.awt.Color(44, 47, 51));
        PengaturanPasswordInput.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        PengaturanPasswordInput.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanPasswordInput.setText("Password");
        PengaturanPasswordInput.setBorder(null);
        PengaturanPasswordInput.setOpaque(false);
        PengaturanPasswordInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PengaturanPasswordInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PengaturanPasswordInputFocusLost(evt);
            }
        });

        PengaturanPasswordInputLine.setBackground(new java.awt.Color(35, 39, 42));

        javax.swing.GroupLayout PengaturanPasswordInputLineLayout = new javax.swing.GroupLayout(PengaturanPasswordInputLine);
        PengaturanPasswordInputLine.setLayout(PengaturanPasswordInputLineLayout);
        PengaturanPasswordInputLineLayout.setHorizontalGroup(
            PengaturanPasswordInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        PengaturanPasswordInputLineLayout.setVerticalGroup(
            PengaturanPasswordInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        PengaturanPasswordInputTitle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        PengaturanPasswordInputTitle.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanPasswordInputTitle.setText(" ");

        PengaturanAlamatInputTitle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        PengaturanAlamatInputTitle.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanAlamatInputTitle.setText(" ");

        PengaturanAlamatInputLine.setBackground(new java.awt.Color(35, 39, 42));

        javax.swing.GroupLayout PengaturanAlamatInputLineLayout = new javax.swing.GroupLayout(PengaturanAlamatInputLine);
        PengaturanAlamatInputLine.setLayout(PengaturanAlamatInputLineLayout);
        PengaturanAlamatInputLineLayout.setHorizontalGroup(
            PengaturanAlamatInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        PengaturanAlamatInputLineLayout.setVerticalGroup(
            PengaturanAlamatInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        PengaturanAlamatInput.setBackground(new java.awt.Color(44, 47, 51));
        PengaturanAlamatInput.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        PengaturanAlamatInput.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanAlamatInput.setText("Alamat");
        PengaturanAlamatInput.setBorder(null);
        PengaturanAlamatInput.setOpaque(false);
        PengaturanAlamatInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PengaturanAlamatInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PengaturanAlamatInputFocusLost(evt);
            }
        });

        PengaturanNMLengkapInputLine.setBackground(new java.awt.Color(35, 39, 42));

        javax.swing.GroupLayout PengaturanNMLengkapInputLineLayout = new javax.swing.GroupLayout(PengaturanNMLengkapInputLine);
        PengaturanNMLengkapInputLine.setLayout(PengaturanNMLengkapInputLineLayout);
        PengaturanNMLengkapInputLineLayout.setHorizontalGroup(
            PengaturanNMLengkapInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        PengaturanNMLengkapInputLineLayout.setVerticalGroup(
            PengaturanNMLengkapInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        PengaturanNMLengkapInput.setBackground(new java.awt.Color(44, 47, 51));
        PengaturanNMLengkapInput.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        PengaturanNMLengkapInput.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanNMLengkapInput.setText("Nama Lengkap");
        PengaturanNMLengkapInput.setBorder(null);
        PengaturanNMLengkapInput.setOpaque(false);
        PengaturanNMLengkapInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PengaturanNMLengkapInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PengaturanNMLengkapInputFocusLost(evt);
            }
        });
        PengaturanNMLengkapInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PengaturanNMLengkapInputKeyTyped(evt);
            }
        });

        PengaturanNMLengkapInputTitle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        PengaturanNMLengkapInputTitle.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanNMLengkapInputTitle.setText(" ");

        PengaturanEmailInput.setBackground(new java.awt.Color(44, 47, 51));
        PengaturanEmailInput.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        PengaturanEmailInput.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanEmailInput.setText("Email");
        PengaturanEmailInput.setBorder(null);
        PengaturanEmailInput.setOpaque(false);
        PengaturanEmailInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PengaturanEmailInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PengaturanEmailInputFocusLost(evt);
            }
        });

        PengaturanEmailInputLine.setBackground(new java.awt.Color(35, 39, 42));

        javax.swing.GroupLayout PengaturanEmailInputLineLayout = new javax.swing.GroupLayout(PengaturanEmailInputLine);
        PengaturanEmailInputLine.setLayout(PengaturanEmailInputLineLayout);
        PengaturanEmailInputLineLayout.setHorizontalGroup(
            PengaturanEmailInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        PengaturanEmailInputLineLayout.setVerticalGroup(
            PengaturanEmailInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        PengaturanEmailInputTitle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        PengaturanEmailInputTitle.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanEmailInputTitle.setText(" ");

        PengaturanTeleponInput.setBackground(new java.awt.Color(44, 47, 51));
        PengaturanTeleponInput.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        PengaturanTeleponInput.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanTeleponInput.setText("Telepon");
        PengaturanTeleponInput.setBorder(null);
        PengaturanTeleponInput.setOpaque(false);
        PengaturanTeleponInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PengaturanTeleponInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PengaturanTeleponInputFocusLost(evt);
            }
        });
        PengaturanTeleponInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PengaturanTeleponInputKeyTyped(evt);
            }
        });

        PengaturanTeleponInputLine.setBackground(new java.awt.Color(35, 39, 42));

        javax.swing.GroupLayout PengaturanTeleponInputLineLayout = new javax.swing.GroupLayout(PengaturanTeleponInputLine);
        PengaturanTeleponInputLine.setLayout(PengaturanTeleponInputLineLayout);
        PengaturanTeleponInputLineLayout.setHorizontalGroup(
            PengaturanTeleponInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        PengaturanTeleponInputLineLayout.setVerticalGroup(
            PengaturanTeleponInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        PengaturanTeleponInputTitle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        PengaturanTeleponInputTitle.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanTeleponInputTitle.setText(" ");

        PengaturanNikKtpInputLine.setBackground(new java.awt.Color(35, 39, 42));

        javax.swing.GroupLayout PengaturanNikKtpInputLineLayout = new javax.swing.GroupLayout(PengaturanNikKtpInputLine);
        PengaturanNikKtpInputLine.setLayout(PengaturanNikKtpInputLineLayout);
        PengaturanNikKtpInputLineLayout.setHorizontalGroup(
            PengaturanNikKtpInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        PengaturanNikKtpInputLineLayout.setVerticalGroup(
            PengaturanNikKtpInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        PengaturanNikKtpInput.setBackground(new java.awt.Color(44, 47, 51));
        PengaturanNikKtpInput.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        PengaturanNikKtpInput.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanNikKtpInput.setText("Nik KTP");
        PengaturanNikKtpInput.setBorder(null);
        PengaturanNikKtpInput.setOpaque(false);
        PengaturanNikKtpInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PengaturanNikKtpInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PengaturanNikKtpInputFocusLost(evt);
            }
        });
        PengaturanNikKtpInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PengaturanNikKtpInputKeyTyped(evt);
            }
        });

        PengaturanNikKtpInputTitle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        PengaturanNikKtpInputTitle.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanNikKtpInputTitle.setText(" ");

        PengaturanTanggalLahirInputLine.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        PengaturanTanggalLahirInputLine.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanTanggalLahirInputLine.setText("Tanggal Lahir");

        javax.swing.GroupLayout PengaturanMainPanelLayout = new javax.swing.GroupLayout(PengaturanMainPanel);
        PengaturanMainPanel.setLayout(PengaturanMainPanelLayout);
        PengaturanMainPanelLayout.setHorizontalGroup(
            PengaturanMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PengaturanHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PengaturanMainPanelLayout.createSequentialGroup()
                .addGroup(PengaturanMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PengaturanMainPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PengaturanButtonBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(PengaturanButtonSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PengaturanMainPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(PengaturanMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PengaturanAlamatInputTitle)
                            .addComponent(PengaturanAlamatInput, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PengaturanAlamatInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PengaturanUsernameInputTitle)
                            .addComponent(PengaturanUsernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PengaturanUsernameInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PengaturanPasswordInputTitle)
                            .addComponent(PengaturanPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PengaturanPasswordInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PengaturanNMLengkapInputTitle)
                            .addComponent(PengaturanNMLengkapInput, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PengaturanNMLengkapInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PengaturanMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PengaturanNikKtpInputTitle)
                            .addComponent(PengaturanNikKtpInput, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PengaturanNikKtpInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PengaturanTeleponInputTitle)
                            .addComponent(PengaturanTeleponInput, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PengaturanTeleponInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PengaturanEmailInputTitle)
                            .addComponent(PengaturanEmailInput, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PengaturanEmailInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PengaturanTanggalLahirInputLine)
                            .addComponent(PengaturanTanggalLahirInput, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40))
        );
        PengaturanMainPanelLayout.setVerticalGroup(
            PengaturanMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PengaturanMainPanelLayout.createSequentialGroup()
                .addComponent(PengaturanHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PengaturanMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PengaturanMainPanelLayout.createSequentialGroup()
                        .addComponent(PengaturanUsernameInputTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PengaturanUsernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PengaturanUsernameInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PengaturanPasswordInputTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PengaturanPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PengaturanPasswordInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PengaturanNMLengkapInputTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PengaturanNMLengkapInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PengaturanNMLengkapInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PengaturanMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PengaturanAlamatInputTitle)
                            .addComponent(PengaturanTanggalLahirInputLine))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PengaturanMainPanelLayout.createSequentialGroup()
                        .addComponent(PengaturanNikKtpInputTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PengaturanNikKtpInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PengaturanNikKtpInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PengaturanTeleponInputTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PengaturanTeleponInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PengaturanTeleponInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PengaturanEmailInputTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PengaturanEmailInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PengaturanEmailInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)))
                .addGroup(PengaturanMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PengaturanTanggalLahirInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PengaturanMainPanelLayout.createSequentialGroup()
                        .addComponent(PengaturanAlamatInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PengaturanAlamatInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(PengaturanMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PengaturanButtonBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PengaturanButtonSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout PengaturanFrameLayout = new javax.swing.GroupLayout(PengaturanFrame.getContentPane());
        PengaturanFrame.getContentPane().setLayout(PengaturanFrameLayout);
        PengaturanFrameLayout.setHorizontalGroup(
            PengaturanFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PengaturanMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PengaturanFrameLayout.setVerticalGroup(
            PengaturanFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PengaturanMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PengaturanYesNo.setUndecorated(true);
        PengaturanYesNo.setSize(new java.awt.Dimension(400, 140));

        PengaturanYesNoMainPanel.setBackground(new java.awt.Color(35, 39, 42));
        PengaturanYesNoMainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));

        PengaturanYesNoHeader.setBackground(new java.awt.Color(32, 34, 37));

        PengaturanYesNo_Close.setBackground(new java.awt.Color(32, 34, 37));
        PengaturanYesNo_Close.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        PengaturanYesNo_Close.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanYesNo_Close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PengaturanYesNo_Close.setText("X");
        PengaturanYesNo_Close.setOpaque(true);
        PengaturanYesNo_Close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PengaturanYesNo_CloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PengaturanYesNo_CloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PengaturanYesNo_CloseMouseExited(evt);
            }
        });

        PengaturanYesNo_Title.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        PengaturanYesNo_Title.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanYesNo_Title.setText("Informasi");

        javax.swing.GroupLayout PengaturanYesNoHeaderLayout = new javax.swing.GroupLayout(PengaturanYesNoHeader);
        PengaturanYesNoHeader.setLayout(PengaturanYesNoHeaderLayout);
        PengaturanYesNoHeaderLayout.setHorizontalGroup(
            PengaturanYesNoHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PengaturanYesNoHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PengaturanYesNo_Title, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PengaturanYesNo_Close, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PengaturanYesNoHeaderLayout.setVerticalGroup(
            PengaturanYesNoHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PengaturanYesNoHeaderLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(PengaturanYesNoHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PengaturanYesNo_Close, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(PengaturanYesNo_Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PengaturanYesNo_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LogoAsk.png"))); // NOI18N

        PengaturanYesNo_Message.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        PengaturanYesNo_Message.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanYesNo_Message.setText("Apakah anda yakin ingin menyimpan ini?");
        PengaturanYesNo_Message.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        PengaturanYesNoTidakButton.setBackground(new java.awt.Color(114, 137, 218));
        PengaturanYesNoTidakButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PengaturanYesNoTidakButton.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanYesNoTidakButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PengaturanYesNoTidakButton.setText("Tidak");
        PengaturanYesNoTidakButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PengaturanYesNoTidakButton.setMaximumSize(new java.awt.Dimension(80, 30));
        PengaturanYesNoTidakButton.setMinimumSize(new java.awt.Dimension(80, 30));
        PengaturanYesNoTidakButton.setOpaque(true);
        PengaturanYesNoTidakButton.setPreferredSize(new java.awt.Dimension(80, 30));
        PengaturanYesNoTidakButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PengaturanYesNoTidakButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PengaturanYesNoTidakButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PengaturanYesNoTidakButtonMouseExited(evt);
            }
        });

        PengaturanYesNoYaButton.setBackground(new java.awt.Color(114, 137, 218));
        PengaturanYesNoYaButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PengaturanYesNoYaButton.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanYesNoYaButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PengaturanYesNoYaButton.setText("Ya");
        PengaturanYesNoYaButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PengaturanYesNoYaButton.setMaximumSize(new java.awt.Dimension(80, 30));
        PengaturanYesNoYaButton.setMinimumSize(new java.awt.Dimension(80, 30));
        PengaturanYesNoYaButton.setOpaque(true);
        PengaturanYesNoYaButton.setPreferredSize(new java.awt.Dimension(80, 30));
        PengaturanYesNoYaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PengaturanYesNoYaButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PengaturanYesNoYaButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PengaturanYesNoYaButtonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout PengaturanYesNoMainPanelLayout = new javax.swing.GroupLayout(PengaturanYesNoMainPanel);
        PengaturanYesNoMainPanel.setLayout(PengaturanYesNoMainPanelLayout);
        PengaturanYesNoMainPanelLayout.setHorizontalGroup(
            PengaturanYesNoMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PengaturanYesNoHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PengaturanYesNoMainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PengaturanYesNo_Icon)
                .addGroup(PengaturanYesNoMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PengaturanYesNoMainPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PengaturanYesNo_Message, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(84, 84, 84))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PengaturanYesNoMainPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PengaturanYesNoYaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PengaturanYesNoTidakButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        PengaturanYesNoMainPanelLayout.setVerticalGroup(
            PengaturanYesNoMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PengaturanYesNoMainPanelLayout.createSequentialGroup()
                .addComponent(PengaturanYesNoHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PengaturanYesNoMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PengaturanYesNo_Icon)
                    .addGroup(PengaturanYesNoMainPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(PengaturanYesNo_Message, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PengaturanYesNoMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PengaturanYesNoTidakButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PengaturanYesNoYaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PengaturanYesNoLayout = new javax.swing.GroupLayout(PengaturanYesNo.getContentPane());
        PengaturanYesNo.getContentPane().setLayout(PengaturanYesNoLayout);
        PengaturanYesNoLayout.setHorizontalGroup(
            PengaturanYesNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PengaturanYesNoMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PengaturanYesNoLayout.setVerticalGroup(
            PengaturanYesNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PengaturanYesNoMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        TransaksiBukaFrame.setUndecorated(true);
        TransaksiBukaFrame.setSize(new java.awt.Dimension(750, 500));

        jPanel1.setBackground(new java.awt.Color(35, 39, 42));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        jPanel1.setPreferredSize(new java.awt.Dimension(750, 500));

        TBFTransaksiId.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        TBFTransaksiId.setForeground(new java.awt.Color(255, 255, 255));
        TBFTransaksiId.setText("Transaksi ID: 2");

        DashboardDetilSewaScrollPanel.setBorder(null);
        DashboardDetilSewaScrollPanel.setForeground(new java.awt.Color(51, 51, 51));
        DashboardDetilSewaScrollPanel.setOpaque(false);

        DashboardDetilSewaTable = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        DashboardDetilSewaTable.setForeground(new java.awt.Color(51, 51, 51));
        DashboardDetilSewaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), "Tholut", "Akhyar"},
                { new Integer(2), "Stacia", "Lewis"},
                { new Integer(3), "Kuriyama", "Mirai"},
                { new Integer(4), "Hanekawa", "Tsubasa"}
            },
            new String [] {
                "No", "First Name", "Last Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        DashboardDetilSewaTable.setGridColor(new java.awt.Color(255, 255, 255));
        DashboardDetilSewaTable.setSelectionBackground(new java.awt.Color(114, 137, 218));
        DashboardDetilSewaScrollPanel.setViewportView(DashboardDetilSewaTable);

        PengaturanYesNoHeader7.setBackground(new java.awt.Color(32, 34, 37));
        PengaturanYesNoHeader7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                PengaturanYesNoHeader7MouseDragged(evt);
            }
        });
        PengaturanYesNoHeader7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PengaturanYesNoHeader7MousePressed(evt);
            }
        });

        PengaturanYesNo_Close7.setBackground(new java.awt.Color(32, 34, 37));
        PengaturanYesNo_Close7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        PengaturanYesNo_Close7.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanYesNo_Close7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PengaturanYesNo_Close7.setText("X");
        PengaturanYesNo_Close7.setOpaque(true);
        PengaturanYesNo_Close7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PengaturanYesNo_Close7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PengaturanYesNo_Close7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PengaturanYesNo_Close7MouseExited(evt);
            }
        });

        PengaturanYesNo_Title7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        PengaturanYesNo_Title7.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanYesNo_Title7.setText("Transaksi Detil");

        javax.swing.GroupLayout PengaturanYesNoHeader7Layout = new javax.swing.GroupLayout(PengaturanYesNoHeader7);
        PengaturanYesNoHeader7.setLayout(PengaturanYesNoHeader7Layout);
        PengaturanYesNoHeader7Layout.setHorizontalGroup(
            PengaturanYesNoHeader7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PengaturanYesNoHeader7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PengaturanYesNo_Title7, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PengaturanYesNo_Close7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PengaturanYesNoHeader7Layout.setVerticalGroup(
            PengaturanYesNoHeader7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PengaturanYesNoHeader7Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(PengaturanYesNoHeader7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PengaturanYesNo_Close7, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(PengaturanYesNo_Title7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TBFNama.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TBFNama.setForeground(new java.awt.Color(255, 255, 255));
        TBFNama.setText("Tholut Akhyar");

        TBFUserId.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TBFUserId.setForeground(new java.awt.Color(255, 255, 255));
        TBFUserId.setText("2");

        TBFNama1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TBFNama1.setForeground(new java.awt.Color(255, 255, 255));
        TBFNama1.setText("Barang Yang di Sewa:");

        TBFTglPeminjaman.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TBFTglPeminjaman.setForeground(new java.awt.Color(255, 255, 255));
        TBFTglPeminjaman.setText("20-02-2018");

        TBFTglPengembalian.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TBFTglPengembalian.setForeground(new java.awt.Color(255, 255, 255));
        TBFTglPengembalian.setText("20-02-2018");

        PengaturanButtonBatal7.setBackground(new java.awt.Color(114, 137, 218));
        PengaturanButtonBatal7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PengaturanButtonBatal7.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanButtonBatal7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PengaturanButtonBatal7.setText("Cetak");
        PengaturanButtonBatal7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PengaturanButtonBatal7.setOpaque(true);
        PengaturanButtonBatal7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PengaturanButtonBatal7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PengaturanButtonBatal7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PengaturanButtonBatal7MouseExited(evt);
            }
        });

        PengaturanButtonBatal8.setBackground(new java.awt.Color(114, 137, 218));
        PengaturanButtonBatal8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PengaturanButtonBatal8.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanButtonBatal8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PengaturanButtonBatal8.setText("Mengembalikan");
        PengaturanButtonBatal8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PengaturanButtonBatal8.setOpaque(true);
        PengaturanButtonBatal8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PengaturanButtonBatal8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PengaturanButtonBatal8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PengaturanButtonBatal8MouseExited(evt);
            }
        });

        TBFNama3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TBFNama3.setForeground(new java.awt.Color(255, 255, 255));
        TBFNama3.setText("Nama Penyewa");

        TBFTglPeminjaman3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TBFTglPeminjaman3.setForeground(new java.awt.Color(255, 255, 255));
        TBFTglPeminjaman3.setText("Tgl Peminjaman");

        TBFTglPengembalian3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TBFTglPengembalian3.setForeground(new java.awt.Color(255, 255, 255));
        TBFTglPengembalian3.setText("Tgl Pengembalian");

        TBFUserId3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TBFUserId3.setForeground(new java.awt.Color(255, 255, 255));
        TBFUserId3.setText("User Id");

        TBFUserId4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TBFUserId4.setForeground(new java.awt.Color(255, 255, 255));
        TBFUserId4.setText(":");

        TBFUserId5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TBFUserId5.setForeground(new java.awt.Color(255, 255, 255));
        TBFUserId5.setText(":");

        TBFUserId6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TBFUserId6.setForeground(new java.awt.Color(255, 255, 255));
        TBFUserId6.setText(":");

        TBFUserId7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TBFUserId7.setForeground(new java.awt.Color(255, 255, 255));
        TBFUserId7.setText(":");

        TBFTglPengembalian4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TBFTglPengembalian4.setForeground(new java.awt.Color(255, 255, 255));
        TBFTglPengembalian4.setText("Bayar");

        TBFTglPeminjaman4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TBFTglPeminjaman4.setForeground(new java.awt.Color(255, 255, 255));
        TBFTglPeminjaman4.setText("Grand Total");

        TBFNama5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TBFNama5.setForeground(new java.awt.Color(255, 255, 255));
        TBFNama5.setText("Discount");

        TBFUserId8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TBFUserId8.setForeground(new java.awt.Color(255, 255, 255));
        TBFUserId8.setText("Subtotal");

        TBFUserId9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TBFUserId9.setForeground(new java.awt.Color(255, 255, 255));
        TBFUserId9.setText("0");

        TBFUserId10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TBFUserId10.setForeground(new java.awt.Color(255, 255, 255));
        TBFUserId10.setText(":");

        TBFUserId11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TBFUserId11.setForeground(new java.awt.Color(255, 255, 255));
        TBFUserId11.setText(":");

        TBFUserId12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TBFUserId12.setForeground(new java.awt.Color(255, 255, 255));
        TBFUserId12.setText(":");

        TBFUserId13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TBFUserId13.setForeground(new java.awt.Color(255, 255, 255));
        TBFUserId13.setText(":");

        TBFTglPengembalian5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TBFTglPengembalian5.setForeground(new java.awt.Color(255, 255, 255));
        TBFTglPengembalian5.setText("0");

        TBFTglPeminjaman5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TBFTglPeminjaman5.setForeground(new java.awt.Color(255, 255, 255));
        TBFTglPeminjaman5.setText("0");

        TBFNama6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TBFNama6.setForeground(new java.awt.Color(255, 255, 255));
        TBFNama6.setText("0%");

        TBFNama7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TBFNama7.setForeground(new java.awt.Color(255, 255, 255));
        TBFNama7.setText("Nama Karyawan");

        TBFUserId14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TBFUserId14.setForeground(new java.awt.Color(255, 255, 255));
        TBFUserId14.setText(":");

        TBFNama8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TBFNama8.setForeground(new java.awt.Color(255, 255, 255));
        TBFNama8.setText("Tholut Akhyar");

        TBFTglPengembalian6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TBFTglPengembalian6.setForeground(new java.awt.Color(255, 255, 255));
        TBFTglPengembalian6.setText("Kembalian");

        TBFUserId15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TBFUserId15.setForeground(new java.awt.Color(255, 255, 255));
        TBFUserId15.setText(":");

        TBFTglPengembalian7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TBFTglPengembalian7.setForeground(new java.awt.Color(255, 255, 255));
        TBFTglPengembalian7.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PengaturanYesNoHeader7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TBFNama7, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TBFUserId14, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TBFNama8, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(176, 176, 176)
                        .addComponent(TBFTglPengembalian6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TBFUserId15, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TBFTglPengembalian7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(TBFTransaksiId, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(TBFUserId3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TBFNama3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TBFTglPeminjaman3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TBFTglPengembalian3, javax.swing.GroupLayout.Alignment.LEADING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(TBFUserId7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TBFUserId6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TBFUserId4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TBFUserId5, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TBFUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TBFNama, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(TBFTglPeminjaman, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TBFTglPengembalian, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(TBFUserId8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TBFNama5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TBFTglPeminjaman4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TBFTglPengembalian4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TBFUserId11, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TBFUserId10))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(TBFNama6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TBFUserId9, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(TBFUserId13, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TBFTglPengembalian5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(TBFUserId12, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TBFTglPeminjaman5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(TBFNama1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PengaturanButtonBatal8, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(PengaturanButtonBatal7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(DashboardDetilSewaScrollPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(PengaturanYesNoHeader7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(TBFTransaksiId)
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TBFUserId3)
                            .addComponent(TBFUserId4)
                            .addComponent(TBFUserId))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TBFNama3)
                            .addComponent(TBFUserId5)
                            .addComponent(TBFNama))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TBFTglPeminjaman3)
                            .addComponent(TBFUserId6)
                            .addComponent(TBFTglPeminjaman))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TBFTglPengembalian3)
                            .addComponent(TBFUserId7)
                            .addComponent(TBFTglPengembalian)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TBFUserId8)
                            .addComponent(TBFUserId10)
                            .addComponent(TBFUserId9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TBFNama5)
                            .addComponent(TBFUserId11)
                            .addComponent(TBFNama6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TBFTglPeminjaman4)
                            .addComponent(TBFUserId12)
                            .addComponent(TBFTglPeminjaman5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TBFTglPengembalian4)
                            .addComponent(TBFUserId13)
                            .addComponent(TBFTglPengembalian5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TBFTglPengembalian6)
                        .addComponent(TBFUserId15)
                        .addComponent(TBFTglPengembalian7))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TBFNama7)
                        .addComponent(TBFUserId14)
                        .addComponent(TBFNama8)))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TBFNama1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(PengaturanButtonBatal7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PengaturanButtonBatal8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DashboardDetilSewaScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout TransaksiBukaFrameLayout = new javax.swing.GroupLayout(TransaksiBukaFrame.getContentPane());
        TransaksiBukaFrame.getContentPane().setLayout(TransaksiBukaFrameLayout);
        TransaksiBukaFrameLayout.setHorizontalGroup(
            TransaksiBukaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        TransaksiBukaFrameLayout.setVerticalGroup(
            TransaksiBukaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
        );

        TransaksiBaruFrame.setUndecorated(true);
        TransaksiBaruFrame.setSize(new java.awt.Dimension(828, 500));

        jPanel2.setBackground(new java.awt.Color(35, 39, 42));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));

        PengaturanYesNoHeader8.setBackground(new java.awt.Color(32, 34, 37));
        PengaturanYesNoHeader8.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                PengaturanYesNoHeader8MouseDragged(evt);
            }
        });
        PengaturanYesNoHeader8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PengaturanYesNoHeader8MousePressed(evt);
            }
        });

        PengaturanYesNo_Close8.setBackground(new java.awt.Color(32, 34, 37));
        PengaturanYesNo_Close8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        PengaturanYesNo_Close8.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanYesNo_Close8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PengaturanYesNo_Close8.setText("X");
        PengaturanYesNo_Close8.setOpaque(true);
        PengaturanYesNo_Close8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PengaturanYesNo_Close8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PengaturanYesNo_Close8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PengaturanYesNo_Close8MouseExited(evt);
            }
        });

        PengaturanYesNo_Title8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        PengaturanYesNo_Title8.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanYesNo_Title8.setText("Transaksi Baru");

        javax.swing.GroupLayout PengaturanYesNoHeader8Layout = new javax.swing.GroupLayout(PengaturanYesNoHeader8);
        PengaturanYesNoHeader8.setLayout(PengaturanYesNoHeader8Layout);
        PengaturanYesNoHeader8Layout.setHorizontalGroup(
            PengaturanYesNoHeader8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PengaturanYesNoHeader8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PengaturanYesNo_Title8, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 598, Short.MAX_VALUE)
                .addComponent(PengaturanYesNo_Close8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PengaturanYesNoHeader8Layout.setVerticalGroup(
            PengaturanYesNoHeader8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PengaturanYesNoHeader8Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(PengaturanYesNoHeader8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PengaturanYesNo_Close8, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(PengaturanYesNo_Title8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TransaksiBaruContent.setBackground(new java.awt.Color(44, 47, 51));
        TransaksiBaruContent.setLayout(new java.awt.CardLayout());

        SewaProcessAwal.setBackground(new java.awt.Color(44, 47, 51));

        DashboardDetilSewaScrollPanel1.setBorder(null);
        DashboardDetilSewaScrollPanel1.setForeground(new java.awt.Color(51, 51, 51));
        DashboardDetilSewaScrollPanel1.setOpaque(false);

        DashboardDetilSewaTable1 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        DashboardDetilSewaTable1.setForeground(new java.awt.Color(51, 51, 51));
        DashboardDetilSewaTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), "Tholut", "Akhyar"},
                { new Integer(2), "Stacia", "Lewis"},
                { new Integer(3), "Kuriyama", "Mirai"},
                { new Integer(4), "Hanekawa", "Tsubasa"}
            },
            new String [] {
                "No", "First Name", "Last Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        DashboardDetilSewaTable1.setGridColor(new java.awt.Color(255, 255, 255));
        DashboardDetilSewaTable1.setSelectionBackground(new java.awt.Color(114, 137, 218));
        DashboardDetilSewaScrollPanel1.setViewportView(DashboardDetilSewaTable1);

        DashboardMUserTambahButton1.setBackground(new java.awt.Color(114, 137, 218));
        DashboardMUserTambahButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DashboardMUserTambahButton1.setForeground(new java.awt.Color(255, 255, 255));
        DashboardMUserTambahButton1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashboardMUserTambahButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/calculator_24.png"))); // NOI18N
        DashboardMUserTambahButton1.setText("Hitung");
        DashboardMUserTambahButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DashboardMUserTambahButton1.setOpaque(true);
        DashboardMUserTambahButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton1MouseExited(evt);
            }
        });

        DashboardMUserTambahButton2.setBackground(new java.awt.Color(114, 137, 218));
        DashboardMUserTambahButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DashboardMUserTambahButton2.setForeground(new java.awt.Color(255, 255, 255));
        DashboardMUserTambahButton2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashboardMUserTambahButton2.setText("Reset");
        DashboardMUserTambahButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DashboardMUserTambahButton2.setOpaque(true);
        DashboardMUserTambahButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton2MouseExited(evt);
            }
        });

        DashboardMUserTambahButton3.setBackground(new java.awt.Color(114, 137, 218));
        DashboardMUserTambahButton3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DashboardMUserTambahButton3.setForeground(new java.awt.Color(255, 255, 255));
        DashboardMUserTambahButton3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashboardMUserTambahButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/delete_24.png"))); // NOI18N
        DashboardMUserTambahButton3.setText("Hapus");
        DashboardMUserTambahButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DashboardMUserTambahButton3.setOpaque(true);
        DashboardMUserTambahButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton3MouseExited(evt);
            }
        });

        DashboardMUserTambahButton4.setBackground(new java.awt.Color(114, 137, 218));
        DashboardMUserTambahButton4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DashboardMUserTambahButton4.setForeground(new java.awt.Color(255, 255, 255));
        DashboardMUserTambahButton4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashboardMUserTambahButton4.setText("Batal");
        DashboardMUserTambahButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DashboardMUserTambahButton4.setOpaque(true);
        DashboardMUserTambahButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton4MouseExited(evt);
            }
        });

        TBFTransaksiId2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        TBFTransaksiId2.setForeground(new java.awt.Color(255, 255, 255));
        TBFTransaksiId2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        TBFTransaksiId2.setText("Total: Rp 0");

        jPanel5.setBackground(new java.awt.Color(35, 39, 42));

        TBFUserId2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TBFUserId2.setForeground(new java.awt.Color(255, 255, 255));
        TBFUserId2.setText("Kaset Id: 0");

        TBFNama4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TBFNama4.setForeground(new java.awt.Color(255, 255, 255));
        TBFNama4.setText("Judul: Tidak Ada");

        TBFTglPeminjaman2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TBFTglPeminjaman2.setForeground(new java.awt.Color(255, 255, 255));
        TBFTglPeminjaman2.setText("Jumlah Keping: 0");

        TBFTglPengembalian2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TBFTglPengembalian2.setForeground(new java.awt.Color(255, 255, 255));
        TBFTglPengembalian2.setText("Harga: 0");

        DashboardMUserTambahButton6.setBackground(new java.awt.Color(114, 137, 218));
        DashboardMUserTambahButton6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DashboardMUserTambahButton6.setForeground(new java.awt.Color(255, 255, 255));
        DashboardMUserTambahButton6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashboardMUserTambahButton6.setText("Cari Kaset");
        DashboardMUserTambahButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DashboardMUserTambahButton6.setOpaque(true);
        DashboardMUserTambahButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton6MouseExited(evt);
            }
        });

        DashboardMUserTambahButton7.setBackground(new java.awt.Color(114, 137, 218));
        DashboardMUserTambahButton7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DashboardMUserTambahButton7.setForeground(new java.awt.Color(255, 255, 255));
        DashboardMUserTambahButton7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashboardMUserTambahButton7.setText("Tambahkan");
        DashboardMUserTambahButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DashboardMUserTambahButton7.setOpaque(true);
        DashboardMUserTambahButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton7MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TBFTglPengembalian2, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                    .addComponent(TBFUserId2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TBFTglPeminjaman2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TBFNama4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DashboardMUserTambahButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DashboardMUserTambahButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DashboardMUserTambahButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TBFUserId2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TBFNama4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TBFTglPeminjaman2)
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TBFTglPengembalian2)
                    .addComponent(DashboardMUserTambahButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(35, 39, 42));

        TBFUserId1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TBFUserId1.setForeground(new java.awt.Color(255, 255, 255));
        TBFUserId1.setText("User Id: 0");

        TBFTransaksiId1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        TBFTransaksiId1.setForeground(new java.awt.Color(255, 255, 255));
        TBFTransaksiId1.setText("Transaksi ID: 2");

        TBFNama2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TBFNama2.setForeground(new java.awt.Color(255, 255, 255));
        TBFNama2.setText("Nama Penyewa: Tidak Ada");

        TBFTglPeminjaman1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TBFTglPeminjaman1.setForeground(new java.awt.Color(255, 255, 255));
        TBFTglPeminjaman1.setText("Alamat: Tidak Ada");

        TBFTglPengembalian1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TBFTglPengembalian1.setForeground(new java.awt.Color(255, 255, 255));
        TBFTglPengembalian1.setText("Nik KTP: 00000000000000");

        DashboardMUserTambahButton5.setBackground(new java.awt.Color(114, 137, 218));
        DashboardMUserTambahButton5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DashboardMUserTambahButton5.setForeground(new java.awt.Color(255, 255, 255));
        DashboardMUserTambahButton5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashboardMUserTambahButton5.setText("Cari User");
        DashboardMUserTambahButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DashboardMUserTambahButton5.setOpaque(true);
        DashboardMUserTambahButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton5MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TBFNama2)
                    .addComponent(TBFTglPeminjaman1)
                    .addComponent(TBFTglPengembalian1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TBFTransaksiId1)
                            .addComponent(TBFUserId1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DashboardMUserTambahButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(TBFTransaksiId1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TBFUserId1))
                    .addComponent(DashboardMUserTambahButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TBFNama2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TBFTglPeminjaman1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TBFTglPengembalian1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SewaProcessAwalLayout = new javax.swing.GroupLayout(SewaProcessAwal);
        SewaProcessAwal.setLayout(SewaProcessAwalLayout);
        SewaProcessAwalLayout.setHorizontalGroup(
            SewaProcessAwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SewaProcessAwalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SewaProcessAwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SewaProcessAwalLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addGroup(SewaProcessAwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TBFTransaksiId2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(SewaProcessAwalLayout.createSequentialGroup()
                        .addComponent(DashboardMUserTambahButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DashboardMUserTambahButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DashboardMUserTambahButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DashboardMUserTambahButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 114, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(SewaProcessAwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(SewaProcessAwalLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(DashboardDetilSewaScrollPanel1)
                    .addContainerGap()))
        );
        SewaProcessAwalLayout.setVerticalGroup(
            SewaProcessAwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SewaProcessAwalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SewaProcessAwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(SewaProcessAwalLayout.createSequentialGroup()
                        .addComponent(TBFTransaksiId2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(218, 218, 218)
                .addGroup(SewaProcessAwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DashboardMUserTambahButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(DashboardMUserTambahButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(DashboardMUserTambahButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(DashboardMUserTambahButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(SewaProcessAwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(SewaProcessAwalLayout.createSequentialGroup()
                    .addGap(196, 196, 196)
                    .addComponent(DashboardDetilSewaScrollPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(67, Short.MAX_VALUE)))
        );

        TransaksiBaruContent.add(SewaProcessAwal, "card1");

        SewaProcessKedua.setBackground(new java.awt.Color(44, 47, 51));

        DashboardDetilSewaScrollPanel2.setBorder(null);
        DashboardDetilSewaScrollPanel2.setForeground(new java.awt.Color(51, 51, 51));
        DashboardDetilSewaScrollPanel2.setOpaque(false);

        DashboardDetilSewaTable2 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        DashboardDetilSewaTable2.setForeground(new java.awt.Color(51, 51, 51));
        DashboardDetilSewaTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), "Tholut", "Akhyar"},
                { new Integer(2), "Stacia", "Lewis"},
                { new Integer(3), "Kuriyama", "Mirai"},
                { new Integer(4), "Hanekawa", "Tsubasa"}
            },
            new String [] {
                "No", "First Name", "Last Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        DashboardDetilSewaTable2.setGridColor(new java.awt.Color(255, 255, 255));
        DashboardDetilSewaTable2.setSelectionBackground(new java.awt.Color(114, 137, 218));
        DashboardDetilSewaScrollPanel2.setViewportView(DashboardDetilSewaTable2);

        DashboardMUserTambahButton8.setBackground(new java.awt.Color(114, 137, 218));
        DashboardMUserTambahButton8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DashboardMUserTambahButton8.setForeground(new java.awt.Color(255, 255, 255));
        DashboardMUserTambahButton8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashboardMUserTambahButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/kembali_24.png"))); // NOI18N
        DashboardMUserTambahButton8.setText("Kembali");
        DashboardMUserTambahButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DashboardMUserTambahButton8.setOpaque(true);
        DashboardMUserTambahButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton8MouseExited(evt);
            }
        });

        DashboardMUserTambahButton9.setBackground(new java.awt.Color(114, 137, 218));
        DashboardMUserTambahButton9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DashboardMUserTambahButton9.setForeground(new java.awt.Color(255, 255, 255));
        DashboardMUserTambahButton9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashboardMUserTambahButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/calculator_24.png"))); // NOI18N
        DashboardMUserTambahButton9.setText("Hitung");
        DashboardMUserTambahButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DashboardMUserTambahButton9.setOpaque(true);
        DashboardMUserTambahButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton9MouseExited(evt);
            }
        });

        DashboardMUserTambahButton11.setBackground(new java.awt.Color(114, 137, 218));
        DashboardMUserTambahButton11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DashboardMUserTambahButton11.setForeground(new java.awt.Color(255, 255, 255));
        DashboardMUserTambahButton11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashboardMUserTambahButton11.setText("Batal");
        DashboardMUserTambahButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DashboardMUserTambahButton11.setOpaque(true);
        DashboardMUserTambahButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton11MouseExited(evt);
            }
        });

        TBFTransaksiId3.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        TBFTransaksiId3.setForeground(new java.awt.Color(255, 255, 255));
        TBFTransaksiId3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        TBFTransaksiId3.setText("Total: Rp 0");

        jTextField1.setEditable(false);

        jTextField2.setEditable(false);
        jTextField2.setText("0");

        jTextField3.setEditable(false);

        TBFTransaksiId4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TBFTransaksiId4.setForeground(new java.awt.Color(255, 255, 255));
        TBFTransaksiId4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TBFTransaksiId4.setText("Discount");

        TBFTransaksiId5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TBFTransaksiId5.setForeground(new java.awt.Color(255, 255, 255));
        TBFTransaksiId5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TBFTransaksiId5.setText("Sub Total");

        TBFTransaksiId6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TBFTransaksiId6.setForeground(new java.awt.Color(255, 255, 255));
        TBFTransaksiId6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TBFTransaksiId6.setText("Grand Total");

        TBFTransaksiId7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TBFTransaksiId7.setForeground(new java.awt.Color(255, 255, 255));
        TBFTransaksiId7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TBFTransaksiId7.setText("Bayar");

        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });

        TBFTransaksiId8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TBFTransaksiId8.setForeground(new java.awt.Color(255, 255, 255));
        TBFTransaksiId8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TBFTransaksiId8.setText("12-12-2012");

        TBFTransaksiId9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TBFTransaksiId9.setForeground(new java.awt.Color(255, 255, 255));
        TBFTransaksiId9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TBFTransaksiId9.setText("Tanggal Pengembalian ");

        jDateChooser1.setDateFormatString("yyyy - MM - d");
        jDateChooser1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jDateChooser1.setMinSelectableDate(new java.util.Date(-62125369200000L));

        TBFTransaksiId32.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TBFTransaksiId32.setForeground(new java.awt.Color(255, 255, 255));
        TBFTransaksiId32.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TBFTransaksiId32.setText("Tanggal Peminnjaman");

        TBFTransaksiId33.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TBFTransaksiId33.setForeground(new java.awt.Color(255, 255, 255));
        TBFTransaksiId33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TBFTransaksiId33.setText(":");

        TBFTransaksiId34.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TBFTransaksiId34.setForeground(new java.awt.Color(255, 255, 255));
        TBFTransaksiId34.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TBFTransaksiId34.setText(":");

        javax.swing.GroupLayout SewaProcessKeduaLayout = new javax.swing.GroupLayout(SewaProcessKedua);
        SewaProcessKedua.setLayout(SewaProcessKeduaLayout);
        SewaProcessKeduaLayout.setHorizontalGroup(
            SewaProcessKeduaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SewaProcessKeduaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SewaProcessKeduaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SewaProcessKeduaLayout.createSequentialGroup()
                        .addComponent(DashboardMUserTambahButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(SewaProcessKeduaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SewaProcessKeduaLayout.createSequentialGroup()
                                .addGap(180, 180, 180)
                                .addComponent(TBFTransaksiId3, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE))
                            .addGroup(SewaProcessKeduaLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(DashboardMUserTambahButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(DashboardMUserTambahButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SewaProcessKeduaLayout.createSequentialGroup()
                        .addGroup(SewaProcessKeduaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(SewaProcessKeduaLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(SewaProcessKeduaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TBFTransaksiId7, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TBFTransaksiId6, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SewaProcessKeduaLayout.createSequentialGroup()
                                .addGroup(SewaProcessKeduaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TBFTransaksiId32)
                                    .addComponent(TBFTransaksiId9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(SewaProcessKeduaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(SewaProcessKeduaLayout.createSequentialGroup()
                                        .addComponent(TBFTransaksiId33)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TBFTransaksiId8))
                                    .addGroup(SewaProcessKeduaLayout.createSequentialGroup()
                                        .addComponent(TBFTransaksiId34)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(SewaProcessKeduaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TBFTransaksiId5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TBFTransaksiId4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(29, 29, 29)
                        .addGroup(SewaProcessKeduaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField4)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
            .addGroup(SewaProcessKeduaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(SewaProcessKeduaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(DashboardDetilSewaScrollPanel2)
                    .addContainerGap()))
        );
        SewaProcessKeduaLayout.setVerticalGroup(
            SewaProcessKeduaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SewaProcessKeduaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TBFTransaksiId3)
                .addGap(186, 186, 186)
                .addGroup(SewaProcessKeduaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SewaProcessKeduaLayout.createSequentialGroup()
                        .addGroup(SewaProcessKeduaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TBFTransaksiId5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SewaProcessKeduaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TBFTransaksiId4)))
                    .addGroup(SewaProcessKeduaLayout.createSequentialGroup()
                        .addGroup(SewaProcessKeduaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TBFTransaksiId32)
                            .addComponent(TBFTransaksiId33)
                            .addComponent(TBFTransaksiId8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SewaProcessKeduaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SewaProcessKeduaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TBFTransaksiId9)
                                .addComponent(TBFTransaksiId34))
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SewaProcessKeduaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TBFTransaksiId6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SewaProcessKeduaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TBFTransaksiId7))
                .addGap(19, 19, 19)
                .addGroup(SewaProcessKeduaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DashboardMUserTambahButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(DashboardMUserTambahButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(DashboardMUserTambahButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(SewaProcessKeduaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(SewaProcessKeduaLayout.createSequentialGroup()
                    .addGap(66, 66, 66)
                    .addComponent(DashboardDetilSewaScrollPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(224, Short.MAX_VALUE)))
        );

        TransaksiBaruContent.add(SewaProcessKedua, "card2");

        SewaProcessAkhir.setBackground(new java.awt.Color(44, 47, 51));

        DashboardDetilSewaScrollPanel3.setBorder(null);
        DashboardDetilSewaScrollPanel3.setForeground(new java.awt.Color(51, 51, 51));
        DashboardDetilSewaScrollPanel3.setOpaque(false);

        DashboardDetilSewaTable3 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        DashboardDetilSewaTable3.setForeground(new java.awt.Color(51, 51, 51));
        DashboardDetilSewaTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), "Tholut", "Akhyar"},
                { new Integer(2), "Stacia", "Lewis"},
                { new Integer(3), "Kuriyama", "Mirai"},
                { new Integer(4), "Hanekawa", "Tsubasa"}
            },
            new String [] {
                "No", "First Name", "Last Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        DashboardDetilSewaTable3.setGridColor(new java.awt.Color(255, 255, 255));
        DashboardDetilSewaTable3.setSelectionBackground(new java.awt.Color(114, 137, 218));
        DashboardDetilSewaScrollPanel3.setViewportView(DashboardDetilSewaTable3);

        DashboardMUserTambahButton10.setBackground(new java.awt.Color(114, 137, 218));
        DashboardMUserTambahButton10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DashboardMUserTambahButton10.setForeground(new java.awt.Color(255, 255, 255));
        DashboardMUserTambahButton10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashboardMUserTambahButton10.setText("Buat Lagi");
        DashboardMUserTambahButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DashboardMUserTambahButton10.setOpaque(true);
        DashboardMUserTambahButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton10MouseExited(evt);
            }
        });

        DashboardMUserTambahButton13.setBackground(new java.awt.Color(114, 137, 218));
        DashboardMUserTambahButton13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DashboardMUserTambahButton13.setForeground(new java.awt.Color(255, 255, 255));
        DashboardMUserTambahButton13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashboardMUserTambahButton13.setText("Tutup");
        DashboardMUserTambahButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DashboardMUserTambahButton13.setOpaque(true);
        DashboardMUserTambahButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton13MouseExited(evt);
            }
        });

        TBFTransaksiId10.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        TBFTransaksiId10.setForeground(new java.awt.Color(255, 255, 255));
        TBFTransaksiId10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        TBFTransaksiId10.setText("Kembalian: Rp 0");

        TBFTransaksiId11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TBFTransaksiId11.setForeground(new java.awt.Color(255, 255, 255));
        TBFTransaksiId11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TBFTransaksiId11.setText("0%");

        TBFTransaksiId12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TBFTransaksiId12.setForeground(new java.awt.Color(255, 255, 255));
        TBFTransaksiId12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TBFTransaksiId12.setText("0");

        TBFTransaksiId13.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TBFTransaksiId13.setForeground(new java.awt.Color(255, 255, 255));
        TBFTransaksiId13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TBFTransaksiId13.setText("0");

        TBFTransaksiId14.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TBFTransaksiId14.setForeground(new java.awt.Color(255, 255, 255));
        TBFTransaksiId14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TBFTransaksiId14.setText("0");

        TBFTransaksiId15.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TBFTransaksiId15.setForeground(new java.awt.Color(255, 255, 255));
        TBFTransaksiId15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TBFTransaksiId15.setText("12-12-2012");

        TBFTransaksiId16.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TBFTransaksiId16.setForeground(new java.awt.Color(255, 255, 255));
        TBFTransaksiId16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TBFTransaksiId16.setText("12-24-2012");

        DashboardMUserTambahButton14.setBackground(new java.awt.Color(114, 137, 218));
        DashboardMUserTambahButton14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DashboardMUserTambahButton14.setForeground(new java.awt.Color(255, 255, 255));
        DashboardMUserTambahButton14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashboardMUserTambahButton14.setText("Cetak");
        DashboardMUserTambahButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DashboardMUserTambahButton14.setOpaque(true);
        DashboardMUserTambahButton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButton14MouseExited(evt);
            }
        });

        TBFTransaksiId17.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TBFTransaksiId17.setForeground(new java.awt.Color(255, 255, 255));
        TBFTransaksiId17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TBFTransaksiId17.setText("Sub Total");

        TBFTransaksiId18.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TBFTransaksiId18.setForeground(new java.awt.Color(255, 255, 255));
        TBFTransaksiId18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TBFTransaksiId18.setText("Discount");

        TBFTransaksiId19.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TBFTransaksiId19.setForeground(new java.awt.Color(255, 255, 255));
        TBFTransaksiId19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TBFTransaksiId19.setText("Bayar");

        TBFTransaksiId20.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TBFTransaksiId20.setForeground(new java.awt.Color(255, 255, 255));
        TBFTransaksiId20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TBFTransaksiId20.setText("Grand Total");

        TBFTransaksiId21.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TBFTransaksiId21.setForeground(new java.awt.Color(255, 255, 255));
        TBFTransaksiId21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TBFTransaksiId21.setText(":");

        TBFTransaksiId22.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TBFTransaksiId22.setForeground(new java.awt.Color(255, 255, 255));
        TBFTransaksiId22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TBFTransaksiId22.setText(":");

        TBFTransaksiId23.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TBFTransaksiId23.setForeground(new java.awt.Color(255, 255, 255));
        TBFTransaksiId23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TBFTransaksiId23.setText(":");

        TBFTransaksiId24.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TBFTransaksiId24.setForeground(new java.awt.Color(255, 255, 255));
        TBFTransaksiId24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TBFTransaksiId24.setText(":");

        TBFTransaksiId26.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TBFTransaksiId26.setForeground(new java.awt.Color(255, 255, 255));
        TBFTransaksiId26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TBFTransaksiId26.setText("Tanggal Peminnjaman");

        TBFTransaksiId27.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TBFTransaksiId27.setForeground(new java.awt.Color(255, 255, 255));
        TBFTransaksiId27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TBFTransaksiId27.setText("Tanggal Pengembalian");

        TBFTransaksiId28.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TBFTransaksiId28.setForeground(new java.awt.Color(255, 255, 255));
        TBFTransaksiId28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TBFTransaksiId28.setText(":");

        TBFTransaksiId29.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TBFTransaksiId29.setForeground(new java.awt.Color(255, 255, 255));
        TBFTransaksiId29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TBFTransaksiId29.setText(":");

        TBFTransaksiId25.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TBFTransaksiId25.setForeground(new java.awt.Color(255, 255, 255));
        TBFTransaksiId25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TBFTransaksiId25.setText("Kembalian");

        TBFTransaksiId30.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TBFTransaksiId30.setForeground(new java.awt.Color(255, 255, 255));
        TBFTransaksiId30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TBFTransaksiId30.setText(":");

        TBFTransaksiId31.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TBFTransaksiId31.setForeground(new java.awt.Color(255, 255, 255));
        TBFTransaksiId31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TBFTransaksiId31.setText("0");

        javax.swing.GroupLayout SewaProcessAkhirLayout = new javax.swing.GroupLayout(SewaProcessAkhir);
        SewaProcessAkhir.setLayout(SewaProcessAkhirLayout);
        SewaProcessAkhirLayout.setHorizontalGroup(
            SewaProcessAkhirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SewaProcessAkhirLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SewaProcessAkhirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SewaProcessAkhirLayout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(TBFTransaksiId10, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE))
                    .addGroup(SewaProcessAkhirLayout.createSequentialGroup()
                        .addComponent(DashboardMUserTambahButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DashboardMUserTambahButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DashboardMUserTambahButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SewaProcessAkhirLayout.createSequentialGroup()
                        .addGroup(SewaProcessAkhirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SewaProcessAkhirLayout.createSequentialGroup()
                                .addGroup(SewaProcessAkhirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TBFTransaksiId27)
                                    .addComponent(TBFTransaksiId26))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(SewaProcessAkhirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TBFTransaksiId29)
                                    .addComponent(TBFTransaksiId28))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(SewaProcessAkhirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TBFTransaksiId16)
                                    .addComponent(TBFTransaksiId15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(SewaProcessAkhirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TBFTransaksiId18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TBFTransaksiId20, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                    .addComponent(TBFTransaksiId17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(SewaProcessAkhirLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(SewaProcessAkhirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TBFTransaksiId25, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TBFTransaksiId19, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(SewaProcessAkhirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SewaProcessAkhirLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(SewaProcessAkhirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TBFTransaksiId24, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TBFTransaksiId23, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(SewaProcessAkhirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(TBFTransaksiId22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TBFTransaksiId21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(SewaProcessAkhirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TBFTransaksiId14, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SewaProcessAkhirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TBFTransaksiId12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TBFTransaksiId11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TBFTransaksiId13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SewaProcessAkhirLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TBFTransaksiId30, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TBFTransaksiId31, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(SewaProcessAkhirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(SewaProcessAkhirLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(DashboardDetilSewaScrollPanel3)
                    .addContainerGap()))
        );
        SewaProcessAkhirLayout.setVerticalGroup(
            SewaProcessAkhirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SewaProcessAkhirLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SewaProcessAkhirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(SewaProcessAkhirLayout.createSequentialGroup()
                        .addComponent(TBFTransaksiId10)
                        .addGap(188, 188, 188)
                        .addGroup(SewaProcessAkhirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SewaProcessAkhirLayout.createSequentialGroup()
                                .addComponent(TBFTransaksiId17, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(TBFTransaksiId13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TBFTransaksiId14))
                            .addGroup(SewaProcessAkhirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(SewaProcessAkhirLayout.createSequentialGroup()
                                    .addComponent(TBFTransaksiId12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(TBFTransaksiId11))
                                .addGroup(SewaProcessAkhirLayout.createSequentialGroup()
                                    .addComponent(TBFTransaksiId26)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(TBFTransaksiId27))
                                .addGroup(SewaProcessAkhirLayout.createSequentialGroup()
                                    .addGroup(SewaProcessAkhirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TBFTransaksiId29)
                                        .addComponent(TBFTransaksiId15))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(SewaProcessAkhirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TBFTransaksiId28)
                                        .addComponent(TBFTransaksiId16))))
                            .addGroup(SewaProcessAkhirLayout.createSequentialGroup()
                                .addComponent(TBFTransaksiId21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(SewaProcessAkhirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TBFTransaksiId22)
                                    .addComponent(TBFTransaksiId18))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(SewaProcessAkhirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(SewaProcessAkhirLayout.createSequentialGroup()
                                        .addGroup(SewaProcessAkhirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(TBFTransaksiId23)
                                            .addComponent(TBFTransaksiId20))
                                        .addGap(28, 28, 28))
                                    .addGroup(SewaProcessAkhirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TBFTransaksiId24)
                                        .addComponent(TBFTransaksiId19)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TBFTransaksiId25))
                    .addGroup(SewaProcessAkhirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(SewaProcessAkhirLayout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addComponent(TBFTransaksiId31))
                        .addComponent(TBFTransaksiId30)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(SewaProcessAkhirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DashboardMUserTambahButton10, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(DashboardMUserTambahButton13, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(DashboardMUserTambahButton14, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(SewaProcessAkhirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(SewaProcessAkhirLayout.createSequentialGroup()
                    .addGap(66, 66, 66)
                    .addComponent(DashboardDetilSewaScrollPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(224, Short.MAX_VALUE)))
        );

        TransaksiBaruContent.add(SewaProcessAkhir, "card3");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PengaturanYesNoHeader8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(11, Short.MAX_VALUE)
                    .addComponent(TransaksiBaruContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(13, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(PengaturanYesNoHeader8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(475, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(36, Short.MAX_VALUE)
                    .addComponent(TransaksiBaruContent, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout TransaksiBaruFrameLayout = new javax.swing.GroupLayout(TransaksiBaruFrame.getContentPane());
        TransaksiBaruFrame.getContentPane().setLayout(TransaksiBaruFrameLayout);
        TransaksiBaruFrameLayout.setHorizontalGroup(
            TransaksiBaruFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        TransaksiBaruFrameLayout.setVerticalGroup(
            TransaksiBaruFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TransaksiCariUserFrame.setUndecorated(true);
        TransaksiCariUserFrame.setSize(new java.awt.Dimension(450, 480));
        TransaksiCariUserFrame.setType(java.awt.Window.Type.POPUP);

        jPanel6.setBackground(new java.awt.Color(44, 47, 51));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));

        PengaturanYesNoHeader9.setBackground(new java.awt.Color(32, 34, 37));
        PengaturanYesNoHeader9.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                PengaturanYesNoHeader9MouseDragged(evt);
            }
        });
        PengaturanYesNoHeader9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PengaturanYesNoHeader9MousePressed(evt);
            }
        });

        PengaturanYesNo_Close9.setBackground(new java.awt.Color(32, 34, 37));
        PengaturanYesNo_Close9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        PengaturanYesNo_Close9.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanYesNo_Close9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PengaturanYesNo_Close9.setText("X");
        PengaturanYesNo_Close9.setOpaque(true);
        PengaturanYesNo_Close9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PengaturanYesNo_Close9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PengaturanYesNo_Close9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PengaturanYesNo_Close9MouseExited(evt);
            }
        });

        PengaturanYesNo_Title9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        PengaturanYesNo_Title9.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanYesNo_Title9.setText("Cari User");

        javax.swing.GroupLayout PengaturanYesNoHeader9Layout = new javax.swing.GroupLayout(PengaturanYesNoHeader9);
        PengaturanYesNoHeader9.setLayout(PengaturanYesNoHeader9Layout);
        PengaturanYesNoHeader9Layout.setHorizontalGroup(
            PengaturanYesNoHeader9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PengaturanYesNoHeader9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PengaturanYesNo_Title9, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
                .addComponent(PengaturanYesNo_Close9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PengaturanYesNoHeader9Layout.setVerticalGroup(
            PengaturanYesNoHeader9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PengaturanYesNoHeader9Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(PengaturanYesNoHeader9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PengaturanYesNo_Close9, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(PengaturanYesNo_Title9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PengaturanUsernameInput1.setBackground(new java.awt.Color(44, 47, 51));
        PengaturanUsernameInput1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        PengaturanUsernameInput1.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanUsernameInput1.setText("Pencarian");
        PengaturanUsernameInput1.setBorder(null);
        PengaturanUsernameInput1.setOpaque(false);
        PengaturanUsernameInput1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PengaturanUsernameInput1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PengaturanUsernameInput1FocusLost(evt);
            }
        });
        PengaturanUsernameInput1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PengaturanUsernameInput1KeyPressed(evt);
            }
        });

        PengaturanUsernameInputLine1.setBackground(new java.awt.Color(35, 39, 42));

        javax.swing.GroupLayout PengaturanUsernameInputLine1Layout = new javax.swing.GroupLayout(PengaturanUsernameInputLine1);
        PengaturanUsernameInputLine1.setLayout(PengaturanUsernameInputLine1Layout);
        PengaturanUsernameInputLine1Layout.setHorizontalGroup(
            PengaturanUsernameInputLine1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PengaturanUsernameInputLine1Layout.setVerticalGroup(
            PengaturanUsernameInputLine1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        PengaturanButtonBatal1.setBackground(new java.awt.Color(114, 137, 218));
        PengaturanButtonBatal1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PengaturanButtonBatal1.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanButtonBatal1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PengaturanButtonBatal1.setText("Cari");
        PengaturanButtonBatal1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PengaturanButtonBatal1.setOpaque(true);
        PengaturanButtonBatal1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PengaturanButtonBatal1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PengaturanButtonBatal1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PengaturanButtonBatal1MouseExited(evt);
            }
        });

        DashboardMUserJenis1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama", "User Id", "NIK" }));

        PengaturanButtonBatal2.setBackground(new java.awt.Color(114, 137, 218));
        PengaturanButtonBatal2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PengaturanButtonBatal2.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanButtonBatal2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PengaturanButtonBatal2.setText("Batal");
        PengaturanButtonBatal2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PengaturanButtonBatal2.setOpaque(true);
        PengaturanButtonBatal2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PengaturanButtonBatal2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PengaturanButtonBatal2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PengaturanButtonBatal2MouseExited(evt);
            }
        });

        PengaturanButtonBatal3.setBackground(new java.awt.Color(114, 137, 218));
        PengaturanButtonBatal3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PengaturanButtonBatal3.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanButtonBatal3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PengaturanButtonBatal3.setText("Pilih");
        PengaturanButtonBatal3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PengaturanButtonBatal3.setOpaque(true);
        PengaturanButtonBatal3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PengaturanButtonBatal3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PengaturanButtonBatal3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PengaturanButtonBatal3MouseExited(evt);
            }
        });

        DashboardMUserScrollPanel1.setBorder(null);
        DashboardMUserScrollPanel1.setForeground(new java.awt.Color(51, 51, 51));
        DashboardMUserScrollPanel1.setOpaque(false);

        TCUserTable = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        TCUserTable.setForeground(new java.awt.Color(51, 51, 51));
        TCUserTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), "Tholut", "Akhyar"},
                { new Integer(2), "Stacia", "Lewis"},
                { new Integer(3), "Kuriyama", "Mirai"},
                { new Integer(4), "Hanekawa", "Tsubasa"}
            },
            new String [] {
                "No", "First Name", "Last Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TCUserTable.setGridColor(new java.awt.Color(255, 255, 255));
        TCUserTable.setSelectionBackground(new java.awt.Color(114, 137, 218));
        DashboardMUserScrollPanel1.setViewportView(TCUserTable);

        TBFTransaksiId35.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TBFTransaksiId35.setForeground(new java.awt.Color(255, 255, 255));
        TBFTransaksiId35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TBFTransaksiId35.setText("List User :");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PengaturanYesNoHeader9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(PengaturanButtonBatal1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PengaturanUsernameInput1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(PengaturanUsernameInputLine1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DashboardMUserJenis1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PengaturanButtonBatal3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PengaturanButtonBatal2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DashboardMUserScrollPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TBFTransaksiId35)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(PengaturanYesNoHeader9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(PengaturanUsernameInput1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PengaturanUsernameInputLine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PengaturanButtonBatal1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(DashboardMUserJenis1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TBFTransaksiId35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DashboardMUserScrollPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PengaturanButtonBatal2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(PengaturanButtonBatal3, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout TransaksiCariUserFrameLayout = new javax.swing.GroupLayout(TransaksiCariUserFrame.getContentPane());
        TransaksiCariUserFrame.getContentPane().setLayout(TransaksiCariUserFrameLayout);
        TransaksiCariUserFrameLayout.setHorizontalGroup(
            TransaksiCariUserFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        TransaksiCariUserFrameLayout.setVerticalGroup(
            TransaksiCariUserFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TransaksiCariKasetFrame.setUndecorated(true);
        TransaksiCariKasetFrame.setSize(new java.awt.Dimension(400, 475));

        jPanel7.setBackground(new java.awt.Color(44, 47, 51));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));

        PengaturanYesNoHeader10.setBackground(new java.awt.Color(32, 34, 37));
        PengaturanYesNoHeader10.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                PengaturanYesNoHeader10MouseDragged(evt);
            }
        });
        PengaturanYesNoHeader10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PengaturanYesNoHeader10MousePressed(evt);
            }
        });

        PengaturanYesNo_Close10.setBackground(new java.awt.Color(32, 34, 37));
        PengaturanYesNo_Close10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        PengaturanYesNo_Close10.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanYesNo_Close10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PengaturanYesNo_Close10.setText("X");
        PengaturanYesNo_Close10.setOpaque(true);
        PengaturanYesNo_Close10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PengaturanYesNo_Close10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PengaturanYesNo_Close10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PengaturanYesNo_Close10MouseExited(evt);
            }
        });

        PengaturanYesNo_Title10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        PengaturanYesNo_Title10.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanYesNo_Title10.setText("Cari Kaset");

        javax.swing.GroupLayout PengaturanYesNoHeader10Layout = new javax.swing.GroupLayout(PengaturanYesNoHeader10);
        PengaturanYesNoHeader10.setLayout(PengaturanYesNoHeader10Layout);
        PengaturanYesNoHeader10Layout.setHorizontalGroup(
            PengaturanYesNoHeader10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PengaturanYesNoHeader10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PengaturanYesNo_Title10, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                .addComponent(PengaturanYesNo_Close10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PengaturanYesNoHeader10Layout.setVerticalGroup(
            PengaturanYesNoHeader10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PengaturanYesNoHeader10Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(PengaturanYesNoHeader10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PengaturanYesNo_Close10, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(PengaturanYesNo_Title10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PengaturanUsernameInput2.setBackground(new java.awt.Color(44, 47, 51));
        PengaturanUsernameInput2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        PengaturanUsernameInput2.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanUsernameInput2.setText("Pencarian");
        PengaturanUsernameInput2.setBorder(null);
        PengaturanUsernameInput2.setOpaque(false);
        PengaturanUsernameInput2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PengaturanUsernameInput2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PengaturanUsernameInput2FocusLost(evt);
            }
        });
        PengaturanUsernameInput2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PengaturanUsernameInput2KeyPressed(evt);
            }
        });

        PengaturanUsernameInputLine2.setBackground(new java.awt.Color(35, 39, 42));

        javax.swing.GroupLayout PengaturanUsernameInputLine2Layout = new javax.swing.GroupLayout(PengaturanUsernameInputLine2);
        PengaturanUsernameInputLine2.setLayout(PengaturanUsernameInputLine2Layout);
        PengaturanUsernameInputLine2Layout.setHorizontalGroup(
            PengaturanUsernameInputLine2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PengaturanUsernameInputLine2Layout.setVerticalGroup(
            PengaturanUsernameInputLine2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        PengaturanButtonBatal4.setBackground(new java.awt.Color(114, 137, 218));
        PengaturanButtonBatal4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PengaturanButtonBatal4.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanButtonBatal4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PengaturanButtonBatal4.setText("Cari");
        PengaturanButtonBatal4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PengaturanButtonBatal4.setOpaque(true);
        PengaturanButtonBatal4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PengaturanButtonBatal4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PengaturanButtonBatal4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PengaturanButtonBatal4MouseExited(evt);
            }
        });

        DashboardMUserJenis2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Judul", "Kode", "Kategori" }));

        PengaturanButtonBatal5.setBackground(new java.awt.Color(114, 137, 218));
        PengaturanButtonBatal5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PengaturanButtonBatal5.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanButtonBatal5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PengaturanButtonBatal5.setText("Batal");
        PengaturanButtonBatal5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PengaturanButtonBatal5.setOpaque(true);
        PengaturanButtonBatal5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PengaturanButtonBatal5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PengaturanButtonBatal5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PengaturanButtonBatal5MouseExited(evt);
            }
        });

        PengaturanButtonBatal6.setBackground(new java.awt.Color(114, 137, 218));
        PengaturanButtonBatal6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PengaturanButtonBatal6.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanButtonBatal6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PengaturanButtonBatal6.setText("Pilih");
        PengaturanButtonBatal6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PengaturanButtonBatal6.setOpaque(true);
        PengaturanButtonBatal6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PengaturanButtonBatal6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PengaturanButtonBatal6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PengaturanButtonBatal6MouseExited(evt);
            }
        });

        DashboardMUserScrollPanel2.setBorder(null);
        DashboardMUserScrollPanel2.setForeground(new java.awt.Color(51, 51, 51));
        DashboardMUserScrollPanel2.setOpaque(false);

        TCUserTable1 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        TCUserTable1.setForeground(new java.awt.Color(51, 51, 51));
        TCUserTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), "Tholut", "Akhyar"},
                { new Integer(2), "Stacia", "Lewis"},
                { new Integer(3), "Kuriyama", "Mirai"},
                { new Integer(4), "Hanekawa", "Tsubasa"}
            },
            new String [] {
                "No", "First Name", "Last Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TCUserTable1.setGridColor(new java.awt.Color(255, 255, 255));
        TCUserTable1.setSelectionBackground(new java.awt.Color(114, 137, 218));
        DashboardMUserScrollPanel2.setViewportView(TCUserTable1);

        TBFTransaksiId36.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TBFTransaksiId36.setForeground(new java.awt.Color(255, 255, 255));
        TBFTransaksiId36.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TBFTransaksiId36.setText("List Kaset :");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PengaturanYesNoHeader10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(PengaturanButtonBatal4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PengaturanUsernameInput2, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                    .addComponent(PengaturanUsernameInputLine2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DashboardMUserJenis2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PengaturanButtonBatal6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PengaturanButtonBatal5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DashboardMUserScrollPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TBFTransaksiId36)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(PengaturanYesNoHeader10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(PengaturanUsernameInput2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PengaturanUsernameInputLine2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PengaturanButtonBatal4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DashboardMUserJenis2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TBFTransaksiId36)
                .addGap(12, 12, 12)
                .addComponent(DashboardMUserScrollPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PengaturanButtonBatal5, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(PengaturanButtonBatal6, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout TransaksiCariKasetFrameLayout = new javax.swing.GroupLayout(TransaksiCariKasetFrame.getContentPane());
        TransaksiCariKasetFrame.getContentPane().setLayout(TransaksiCariKasetFrameLayout);
        TransaksiCariKasetFrameLayout.setHorizontalGroup(
            TransaksiCariKasetFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        TransaksiCariKasetFrameLayout.setVerticalGroup(
            TransaksiCariKasetFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TransaksiYesNo.setUndecorated(true);
        TransaksiYesNo.setSize(new java.awt.Dimension(400, 140));
        TransaksiYesNo.setType(java.awt.Window.Type.POPUP);

        PengaturanYesNoMainPanel1.setBackground(new java.awt.Color(35, 39, 42));
        PengaturanYesNoMainPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));

        PengaturanYesNoHeader1.setBackground(new java.awt.Color(32, 34, 37));

        PengaturanYesNo_Close1.setBackground(new java.awt.Color(32, 34, 37));
        PengaturanYesNo_Close1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        PengaturanYesNo_Close1.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanYesNo_Close1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PengaturanYesNo_Close1.setText("X");
        PengaturanYesNo_Close1.setOpaque(true);
        PengaturanYesNo_Close1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PengaturanYesNo_Close1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PengaturanYesNo_Close1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PengaturanYesNo_Close1MouseExited(evt);
            }
        });

        PengaturanYesNo_Title1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        PengaturanYesNo_Title1.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanYesNo_Title1.setText("Informasi");

        javax.swing.GroupLayout PengaturanYesNoHeader1Layout = new javax.swing.GroupLayout(PengaturanYesNoHeader1);
        PengaturanYesNoHeader1.setLayout(PengaturanYesNoHeader1Layout);
        PengaturanYesNoHeader1Layout.setHorizontalGroup(
            PengaturanYesNoHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PengaturanYesNoHeader1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PengaturanYesNo_Title1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PengaturanYesNo_Close1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PengaturanYesNoHeader1Layout.setVerticalGroup(
            PengaturanYesNoHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PengaturanYesNoHeader1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(PengaturanYesNoHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PengaturanYesNo_Close1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(PengaturanYesNo_Title1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PengaturanYesNo_Icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LogoAsk.png"))); // NOI18N

        PengaturanYesNo_Message1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        PengaturanYesNo_Message1.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanYesNo_Message1.setText("Apakah anda yakin ingin menyimpan ini?");
        PengaturanYesNo_Message1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        PengaturanYesNoTidakButton1.setBackground(new java.awt.Color(114, 137, 218));
        PengaturanYesNoTidakButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PengaturanYesNoTidakButton1.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanYesNoTidakButton1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PengaturanYesNoTidakButton1.setText("Tidak");
        PengaturanYesNoTidakButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PengaturanYesNoTidakButton1.setMaximumSize(new java.awt.Dimension(80, 30));
        PengaturanYesNoTidakButton1.setMinimumSize(new java.awt.Dimension(80, 30));
        PengaturanYesNoTidakButton1.setOpaque(true);
        PengaturanYesNoTidakButton1.setPreferredSize(new java.awt.Dimension(80, 30));
        PengaturanYesNoTidakButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PengaturanYesNoTidakButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PengaturanYesNoTidakButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PengaturanYesNoTidakButton1MouseExited(evt);
            }
        });

        PengaturanYesNoYaButton1.setBackground(new java.awt.Color(114, 137, 218));
        PengaturanYesNoYaButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PengaturanYesNoYaButton1.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanYesNoYaButton1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PengaturanYesNoYaButton1.setText("Ya");
        PengaturanYesNoYaButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PengaturanYesNoYaButton1.setMaximumSize(new java.awt.Dimension(80, 30));
        PengaturanYesNoYaButton1.setMinimumSize(new java.awt.Dimension(80, 30));
        PengaturanYesNoYaButton1.setOpaque(true);
        PengaturanYesNoYaButton1.setPreferredSize(new java.awt.Dimension(80, 30));
        PengaturanYesNoYaButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PengaturanYesNoYaButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PengaturanYesNoYaButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PengaturanYesNoYaButton1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout PengaturanYesNoMainPanel1Layout = new javax.swing.GroupLayout(PengaturanYesNoMainPanel1);
        PengaturanYesNoMainPanel1.setLayout(PengaturanYesNoMainPanel1Layout);
        PengaturanYesNoMainPanel1Layout.setHorizontalGroup(
            PengaturanYesNoMainPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PengaturanYesNoHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PengaturanYesNoMainPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PengaturanYesNo_Icon1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PengaturanYesNoMainPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PengaturanYesNoMainPanel1Layout.createSequentialGroup()
                        .addGap(0, 111, Short.MAX_VALUE)
                        .addComponent(PengaturanYesNoYaButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PengaturanYesNoTidakButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PengaturanYesNo_Message1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        PengaturanYesNoMainPanel1Layout.setVerticalGroup(
            PengaturanYesNoMainPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PengaturanYesNoMainPanel1Layout.createSequentialGroup()
                .addComponent(PengaturanYesNoHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PengaturanYesNoMainPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PengaturanYesNo_Icon1)
                    .addGroup(PengaturanYesNoMainPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(PengaturanYesNo_Message1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PengaturanYesNoMainPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PengaturanYesNoTidakButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PengaturanYesNoYaButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout TransaksiYesNoLayout = new javax.swing.GroupLayout(TransaksiYesNo.getContentPane());
        TransaksiYesNo.getContentPane().setLayout(TransaksiYesNoLayout);
        TransaksiYesNoLayout.setHorizontalGroup(
            TransaksiYesNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PengaturanYesNoMainPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        TransaksiYesNoLayout.setVerticalGroup(
            TransaksiYesNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PengaturanYesNoMainPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        LoadingCetak.setUndecorated(true);
        LoadingCetak.setSize(new java.awt.Dimension(400, 140));
        LoadingCetak.setType(java.awt.Window.Type.POPUP);

        PengaturanYesNoMainPanel2.setBackground(new java.awt.Color(35, 39, 42));

        PengaturanYesNoHeader2.setBackground(new java.awt.Color(32, 34, 37));

        PengaturanYesNo_Close2.setBackground(new java.awt.Color(32, 34, 37));
        PengaturanYesNo_Close2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        PengaturanYesNo_Close2.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanYesNo_Close2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PengaturanYesNo_Close2.setText("X");
        PengaturanYesNo_Close2.setOpaque(true);
        PengaturanYesNo_Close2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PengaturanYesNo_Close2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PengaturanYesNo_Close2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PengaturanYesNo_Close2MouseExited(evt);
            }
        });

        PengaturanYesNo_Title2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        PengaturanYesNo_Title2.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanYesNo_Title2.setText("Tunggu Sebentar");

        javax.swing.GroupLayout PengaturanYesNoHeader2Layout = new javax.swing.GroupLayout(PengaturanYesNoHeader2);
        PengaturanYesNoHeader2.setLayout(PengaturanYesNoHeader2Layout);
        PengaturanYesNoHeader2Layout.setHorizontalGroup(
            PengaturanYesNoHeader2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PengaturanYesNoHeader2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PengaturanYesNo_Title2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                .addComponent(PengaturanYesNo_Close2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PengaturanYesNoHeader2Layout.setVerticalGroup(
            PengaturanYesNoHeader2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PengaturanYesNoHeader2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(PengaturanYesNoHeader2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PengaturanYesNo_Close2, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(PengaturanYesNo_Title2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PengaturanYesNo_Message2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        PengaturanYesNo_Message2.setForeground(new java.awt.Color(255, 255, 255));
        PengaturanYesNo_Message2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PengaturanYesNo_Message2.setText("Loading Cetak Data......");

        javax.swing.GroupLayout PengaturanYesNoMainPanel2Layout = new javax.swing.GroupLayout(PengaturanYesNoMainPanel2);
        PengaturanYesNoMainPanel2.setLayout(PengaturanYesNoMainPanel2Layout);
        PengaturanYesNoMainPanel2Layout.setHorizontalGroup(
            PengaturanYesNoMainPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PengaturanYesNoHeader2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PengaturanYesNoMainPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PengaturanYesNo_Message2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PengaturanYesNoMainPanel2Layout.setVerticalGroup(
            PengaturanYesNoMainPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PengaturanYesNoMainPanel2Layout.createSequentialGroup()
                .addComponent(PengaturanYesNoHeader2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PengaturanYesNo_Message2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout LoadingCetakLayout = new javax.swing.GroupLayout(LoadingCetak.getContentPane());
        LoadingCetak.getContentPane().setLayout(LoadingCetakLayout);
        LoadingCetakLayout.setHorizontalGroup(
            LoadingCetakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PengaturanYesNoMainPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        LoadingCetakLayout.setVerticalGroup(
            LoadingCetakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PengaturanYesNoMainPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setUndecorated(true);
        setSize(new java.awt.Dimension(1000, 600));

        DashboardMainPanel.setBackground(new java.awt.Color(35, 39, 42));
        DashboardMainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));

        DashboardHeader.setBackground(new java.awt.Color(44, 47, 51));

        DashboardHeaderDrag.setBackground(new java.awt.Color(32, 34, 37));
        DashboardHeaderDrag.setPreferredSize(new java.awt.Dimension(1000, 25));
        DashboardHeaderDrag.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                DashboardHeaderDragMouseDragged(evt);
            }
        });
        DashboardHeaderDrag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DashboardHeaderDragMousePressed(evt);
            }
        });

        DashboardTitle.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        DashboardTitle.setForeground(new java.awt.Color(255, 255, 255));
        DashboardTitle.setText("Dashboard");

        DashboardClose.setBackground(new java.awt.Color(32, 34, 37));
        DashboardClose.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        DashboardClose.setForeground(new java.awt.Color(255, 255, 255));
        DashboardClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashboardClose.setText("X");
        DashboardClose.setOpaque(true);
        DashboardClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardCloseMouseExited(evt);
            }
        });

        DashboardMinimize.setBackground(new java.awt.Color(32, 34, 37));
        DashboardMinimize.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        DashboardMinimize.setForeground(new java.awt.Color(255, 255, 255));
        DashboardMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashboardMinimize.setText("-");
        DashboardMinimize.setOpaque(true);
        DashboardMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardMinimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardMinimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardMinimizeMouseExited(evt);
            }
        });

        DashboardKeluarButton.setBackground(new java.awt.Color(114, 137, 218));
        DashboardKeluarButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DashboardKeluarButton.setForeground(new java.awt.Color(255, 255, 255));
        DashboardKeluarButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashboardKeluarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/logout_12.png"))); // NOI18N
        DashboardKeluarButton.setText("Keluar");
        DashboardKeluarButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DashboardKeluarButton.setOpaque(true);
        DashboardKeluarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardKeluarButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardKeluarButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardKeluarButtonMouseExited(evt);
            }
        });

        DashboardPengaturanButton.setBackground(new java.awt.Color(114, 137, 218));
        DashboardPengaturanButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DashboardPengaturanButton.setForeground(new java.awt.Color(255, 255, 255));
        DashboardPengaturanButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashboardPengaturanButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/settings_12.png"))); // NOI18N
        DashboardPengaturanButton.setText("Pengaturan");
        DashboardPengaturanButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DashboardPengaturanButton.setOpaque(true);
        DashboardPengaturanButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardPengaturanButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardPengaturanButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardPengaturanButtonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout DashboardHeaderDragLayout = new javax.swing.GroupLayout(DashboardHeaderDrag);
        DashboardHeaderDrag.setLayout(DashboardHeaderDragLayout);
        DashboardHeaderDragLayout.setHorizontalGroup(
            DashboardHeaderDragLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardHeaderDragLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DashboardTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DashboardPengaturanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DashboardKeluarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DashboardMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(DashboardClose, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        DashboardHeaderDragLayout.setVerticalGroup(
            DashboardHeaderDragLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DashboardMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(DashboardClose, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
            .addGroup(DashboardHeaderDragLayout.createSequentialGroup()
                .addGroup(DashboardHeaderDragLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DashboardKeluarButton)
                    .addComponent(DashboardPengaturanButton))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(DashboardTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        DashboardBerandaButton.setBackground(new java.awt.Color(35, 39, 42));
        DashboardBerandaButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DashboardBerandaButton.setForeground(new java.awt.Color(255, 255, 255));
        DashboardBerandaButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashboardBerandaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/home_24.png"))); // NOI18N
        DashboardBerandaButton.setText("Beranda");
        DashboardBerandaButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DashboardBerandaButton.setOpaque(true);
        DashboardBerandaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardBerandaButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardBerandaButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardBerandaButtonMouseExited(evt);
            }
        });

        DashboardMUserButton.setBackground(new java.awt.Color(114, 137, 218));
        DashboardMUserButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DashboardMUserButton.setForeground(new java.awt.Color(255, 255, 255));
        DashboardMUserButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashboardMUserButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/database_24.png"))); // NOI18N
        DashboardMUserButton.setText("Master User");
        DashboardMUserButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DashboardMUserButton.setOpaque(true);
        DashboardMUserButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardMUserButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardMUserButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardMUserButtonMouseExited(evt);
            }
        });

        DashboardMKasetButton.setBackground(new java.awt.Color(114, 137, 218));
        DashboardMKasetButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DashboardMKasetButton.setForeground(new java.awt.Color(255, 255, 255));
        DashboardMKasetButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashboardMKasetButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/database_24.png"))); // NOI18N
        DashboardMKasetButton.setText("Master Kaset");
        DashboardMKasetButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DashboardMKasetButton.setOpaque(true);
        DashboardMKasetButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardMKasetButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardMKasetButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardMKasetButtonMouseExited(evt);
            }
        });

        DashboardSewaButton.setBackground(new java.awt.Color(114, 137, 218));
        DashboardSewaButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DashboardSewaButton.setForeground(new java.awt.Color(255, 255, 255));
        DashboardSewaButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashboardSewaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/cart_24.png"))); // NOI18N
        DashboardSewaButton.setText("Sewa Kaset");
        DashboardSewaButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DashboardSewaButton.setOpaque(true);
        DashboardSewaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardSewaButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardSewaButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardSewaButtonMouseExited(evt);
            }
        });

        DashboardLaporanButton.setBackground(new java.awt.Color(114, 137, 218));
        DashboardLaporanButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DashboardLaporanButton.setForeground(new java.awt.Color(255, 255, 255));
        DashboardLaporanButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashboardLaporanButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/report_24.png"))); // NOI18N
        DashboardLaporanButton.setText("Laporan");
        DashboardLaporanButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DashboardLaporanButton.setOpaque(true);
        DashboardLaporanButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardLaporanButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardLaporanButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardLaporanButtonMouseExited(evt);
            }
        });

        DashboardLoginUsername.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        DashboardLoginUsername.setForeground(new java.awt.Color(255, 255, 255));
        DashboardLoginUsername.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/user_24.png"))); // NOI18N
        DashboardLoginUsername.setText("null (rank)");

        javax.swing.GroupLayout DashboardHeaderLayout = new javax.swing.GroupLayout(DashboardHeader);
        DashboardHeader.setLayout(DashboardHeaderLayout);
        DashboardHeaderLayout.setHorizontalGroup(
            DashboardHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DashboardHeaderDrag, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE)
            .addGroup(DashboardHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DashboardHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(DashboardLoginUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(DashboardHeaderLayout.createSequentialGroup()
                        .addComponent(DashboardBerandaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DashboardMUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DashboardMKasetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DashboardSewaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DashboardLaporanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DashboardHeaderLayout.setVerticalGroup(
            DashboardHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardHeaderLayout.createSequentialGroup()
                .addComponent(DashboardHeaderDrag, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DashboardLoginUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(DashboardHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DashboardBerandaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DashboardMUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DashboardMKasetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DashboardSewaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DashboardLaporanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        DashboardContent.setBackground(new java.awt.Color(44, 47, 51));
        DashboardContent.setLayout(new java.awt.CardLayout());

        DashboardContentBeranda.setBackground(new java.awt.Color(44, 47, 51));

        DashboardContentBerandaTitle.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        DashboardContentBerandaTitle.setForeground(new java.awt.Color(255, 255, 255));
        DashboardContentBerandaTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/home_24.png"))); // NOI18N
        DashboardContentBerandaTitle.setText("Beranda");

        DashboardContentBerandaTitle1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        DashboardContentBerandaTitle1.setForeground(new java.awt.Color(255, 255, 255));
        DashboardContentBerandaTitle1.setText("Selamat Datang Di Dashboard! Thol");

        javax.swing.GroupLayout DashboardContentBerandaLayout = new javax.swing.GroupLayout(DashboardContentBeranda);
        DashboardContentBeranda.setLayout(DashboardContentBerandaLayout);
        DashboardContentBerandaLayout.setHorizontalGroup(
            DashboardContentBerandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardContentBerandaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DashboardContentBerandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashboardContentBerandaLayout.createSequentialGroup()
                        .addComponent(DashboardContentBerandaTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(DashboardContentBerandaTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, 956, Short.MAX_VALUE))
                .addContainerGap())
        );
        DashboardContentBerandaLayout.setVerticalGroup(
            DashboardContentBerandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardContentBerandaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DashboardContentBerandaTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DashboardContentBerandaTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(349, Short.MAX_VALUE))
        );

        DashboardContent.add(DashboardContentBeranda, "card1");

        DashboardContentMUser.setBackground(new java.awt.Color(44, 47, 51));

        DashboardContentMUserTitle.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        DashboardContentMUserTitle.setForeground(new java.awt.Color(255, 255, 255));
        DashboardContentMUserTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/database_24.png"))); // NOI18N
        DashboardContentMUserTitle.setText("Data User");
        DashboardContentMUserTitle.setMaximumSize(new java.awt.Dimension(110, 40));
        DashboardContentMUserTitle.setMinimumSize(new java.awt.Dimension(110, 40));
        DashboardContentMUserTitle.setPreferredSize(new java.awt.Dimension(110, 40));

        DashboardMUserCariButton.setBackground(new java.awt.Color(114, 137, 218));
        DashboardMUserCariButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DashboardMUserCariButton.setForeground(new java.awt.Color(255, 255, 255));
        DashboardMUserCariButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashboardMUserCariButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/search_24.png"))); // NOI18N
        DashboardMUserCariButton.setText("Cari");
        DashboardMUserCariButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DashboardMUserCariButton.setOpaque(true);
        DashboardMUserCariButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardMUserCariButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardMUserCariButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardMUserCariButtonMouseExited(evt);
            }
        });

        DashboardMUserCariInput.setBackground(new java.awt.Color(44, 47, 51));
        DashboardMUserCariInput.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        DashboardMUserCariInput.setForeground(new java.awt.Color(255, 255, 255));
        DashboardMUserCariInput.setText("Pencarian");
        DashboardMUserCariInput.setBorder(null);
        DashboardMUserCariInput.setOpaque(false);
        DashboardMUserCariInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                DashboardMUserCariInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                DashboardMUserCariInputFocusLost(evt);
            }
        });
        DashboardMUserCariInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DashboardMUserCariInputKeyPressed(evt);
            }
        });

        DashboardMUserCariInputLine.setBackground(new java.awt.Color(35, 39, 42));

        javax.swing.GroupLayout DashboardMUserCariInputLineLayout = new javax.swing.GroupLayout(DashboardMUserCariInputLine);
        DashboardMUserCariInputLine.setLayout(DashboardMUserCariInputLineLayout);
        DashboardMUserCariInputLineLayout.setHorizontalGroup(
            DashboardMUserCariInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        DashboardMUserCariInputLineLayout.setVerticalGroup(
            DashboardMUserCariInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        DashboardMUserJenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama", "User Id", "NIK" }));

        DashboardMUserScrollPanel.setBorder(null);
        DashboardMUserScrollPanel.setForeground(new java.awt.Color(51, 51, 51));
        DashboardMUserScrollPanel.setOpaque(false);

        DashboardMUserTable = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        DashboardMUserTable.setForeground(new java.awt.Color(51, 51, 51));
        DashboardMUserTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), "Tholut", "Akhyar"},
                { new Integer(2), "Stacia", "Lewis"},
                { new Integer(3), "Kuriyama", "Mirai"},
                { new Integer(4), "Hanekawa", "Tsubasa"}
            },
            new String [] {
                "No", "First Name", "Last Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        DashboardMUserTable.setGridColor(new java.awt.Color(255, 255, 255));
        DashboardMUserTable.setSelectionBackground(new java.awt.Color(114, 137, 218));
        DashboardMUserScrollPanel.setViewportView(DashboardMUserTable);

        DashboardMUserTambahButton.setBackground(new java.awt.Color(114, 137, 218));
        DashboardMUserTambahButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DashboardMUserTambahButton.setForeground(new java.awt.Color(255, 255, 255));
        DashboardMUserTambahButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashboardMUserTambahButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/plus_24.png"))); // NOI18N
        DashboardMUserTambahButton.setText("Tambah");
        DashboardMUserTambahButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DashboardMUserTambahButton.setOpaque(true);
        DashboardMUserTambahButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardMUserTambahButtonMouseExited(evt);
            }
        });

        DashboardMUserUbahButton.setBackground(new java.awt.Color(114, 137, 218));
        DashboardMUserUbahButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DashboardMUserUbahButton.setForeground(new java.awt.Color(255, 255, 255));
        DashboardMUserUbahButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashboardMUserUbahButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/edit_24.png"))); // NOI18N
        DashboardMUserUbahButton.setText("Ubah");
        DashboardMUserUbahButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DashboardMUserUbahButton.setOpaque(true);
        DashboardMUserUbahButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardMUserUbahButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardMUserUbahButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardMUserUbahButtonMouseExited(evt);
            }
        });

        DashboardMUserHapusButton.setBackground(new java.awt.Color(114, 137, 218));
        DashboardMUserHapusButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DashboardMUserHapusButton.setForeground(new java.awt.Color(255, 255, 255));
        DashboardMUserHapusButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashboardMUserHapusButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/delete_24.png"))); // NOI18N
        DashboardMUserHapusButton.setText("Hapus");
        DashboardMUserHapusButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DashboardMUserHapusButton.setOpaque(true);
        DashboardMUserHapusButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardMUserHapusButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardMUserHapusButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardMUserHapusButtonMouseExited(evt);
            }
        });

        DashboardMUserSegarkanButton.setBackground(new java.awt.Color(114, 137, 218));
        DashboardMUserSegarkanButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DashboardMUserSegarkanButton.setForeground(new java.awt.Color(255, 255, 255));
        DashboardMUserSegarkanButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashboardMUserSegarkanButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/refresh_24.png"))); // NOI18N
        DashboardMUserSegarkanButton.setText("Segarkan");
        DashboardMUserSegarkanButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DashboardMUserSegarkanButton.setOpaque(true);
        DashboardMUserSegarkanButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardMUserSegarkanButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardMUserSegarkanButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardMUserSegarkanButtonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout DashboardContentMUserLayout = new javax.swing.GroupLayout(DashboardContentMUser);
        DashboardContentMUser.setLayout(DashboardContentMUserLayout);
        DashboardContentMUserLayout.setHorizontalGroup(
            DashboardContentMUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardContentMUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DashboardContentMUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DashboardMUserScrollPanel)
                    .addGroup(DashboardContentMUserLayout.createSequentialGroup()
                        .addComponent(DashboardContentMUserTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DashboardMUserCariButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(DashboardContentMUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DashboardMUserCariInput, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                            .addComponent(DashboardMUserCariInputLine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DashboardMUserJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DashboardContentMUserLayout.createSequentialGroup()
                        .addComponent(DashboardMUserTambahButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DashboardMUserUbahButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(DashboardMUserHapusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DashboardMUserSegarkanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 286, Short.MAX_VALUE)))
                .addContainerGap())
        );
        DashboardContentMUserLayout.setVerticalGroup(
            DashboardContentMUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardContentMUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DashboardContentMUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashboardContentMUserLayout.createSequentialGroup()
                        .addComponent(DashboardContentMUserTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(DashboardContentMUserLayout.createSequentialGroup()
                        .addGroup(DashboardContentMUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DashboardMUserJenis, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DashboardMUserCariButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(DashboardContentMUserLayout.createSequentialGroup()
                                .addComponent(DashboardMUserCariInput, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DashboardMUserCariInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)))
                .addComponent(DashboardMUserScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DashboardContentMUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DashboardMUserTambahButton, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(DashboardMUserUbahButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DashboardMUserSegarkanButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DashboardMUserHapusButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        DashboardContent.add(DashboardContentMUser, "card2");

        DashboardContentMKaset.setBackground(new java.awt.Color(44, 47, 51));

        DashboardContentMKasetTitle.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        DashboardContentMKasetTitle.setForeground(new java.awt.Color(255, 255, 255));
        DashboardContentMKasetTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/database_24.png"))); // NOI18N
        DashboardContentMKasetTitle.setText("Data Kaset");
        DashboardContentMKasetTitle.setMaximumSize(new java.awt.Dimension(110, 40));
        DashboardContentMKasetTitle.setMinimumSize(new java.awt.Dimension(110, 40));
        DashboardContentMKasetTitle.setPreferredSize(new java.awt.Dimension(110, 40));

        DashboardMKasetCariButton.setBackground(new java.awt.Color(114, 137, 218));
        DashboardMKasetCariButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DashboardMKasetCariButton.setForeground(new java.awt.Color(255, 255, 255));
        DashboardMKasetCariButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashboardMKasetCariButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/search_24.png"))); // NOI18N
        DashboardMKasetCariButton.setText("Cari");
        DashboardMKasetCariButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DashboardMKasetCariButton.setOpaque(true);
        DashboardMKasetCariButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardMKasetCariButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardMKasetCariButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardMKasetCariButtonMouseExited(evt);
            }
        });

        DashboardMKasetCariInput.setBackground(new java.awt.Color(44, 47, 51));
        DashboardMKasetCariInput.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        DashboardMKasetCariInput.setForeground(new java.awt.Color(255, 255, 255));
        DashboardMKasetCariInput.setText("Pencarian");
        DashboardMKasetCariInput.setBorder(null);
        DashboardMKasetCariInput.setOpaque(false);
        DashboardMKasetCariInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                DashboardMKasetCariInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                DashboardMKasetCariInputFocusLost(evt);
            }
        });
        DashboardMKasetCariInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DashboardMKasetCariInputKeyPressed(evt);
            }
        });

        DashboardMKasetCariInputLine.setBackground(new java.awt.Color(35, 39, 42));

        javax.swing.GroupLayout DashboardMKasetCariInputLineLayout = new javax.swing.GroupLayout(DashboardMKasetCariInputLine);
        DashboardMKasetCariInputLine.setLayout(DashboardMKasetCariInputLineLayout);
        DashboardMKasetCariInputLineLayout.setHorizontalGroup(
            DashboardMKasetCariInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        DashboardMKasetCariInputLineLayout.setVerticalGroup(
            DashboardMKasetCariInputLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        DashboardMKasetJenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Judul", "Kode", "Kategori" }));

        DashboardMKasetScrollPanel.setBorder(null);
        DashboardMKasetScrollPanel.setForeground(new java.awt.Color(51, 51, 51));
        DashboardMKasetScrollPanel.setOpaque(false);

        DashboardMKasetTable = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        DashboardMKasetTable.setForeground(new java.awt.Color(51, 51, 51));
        DashboardMKasetTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), "Tholut", "Akhyar"},
                { new Integer(2), "Stacia", "Lewis"},
                { new Integer(3), "Kuriyama", "Mirai"},
                { new Integer(4), "Hanekawa", "Tsubasa"}
            },
            new String [] {
                "No", "First Name", "Last Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        DashboardMKasetTable.setGridColor(new java.awt.Color(255, 255, 255));
        DashboardMKasetTable.setSelectionBackground(new java.awt.Color(114, 137, 218));
        DashboardMKasetScrollPanel.setViewportView(DashboardMKasetTable);

        DashboardMKasetTambahButton.setBackground(new java.awt.Color(114, 137, 218));
        DashboardMKasetTambahButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DashboardMKasetTambahButton.setForeground(new java.awt.Color(255, 255, 255));
        DashboardMKasetTambahButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashboardMKasetTambahButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/plus_24.png"))); // NOI18N
        DashboardMKasetTambahButton.setText("Tambah");
        DashboardMKasetTambahButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DashboardMKasetTambahButton.setOpaque(true);
        DashboardMKasetTambahButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardMKasetTambahButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardMKasetTambahButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardMKasetTambahButtonMouseExited(evt);
            }
        });

        DashboardMKasetUbahButton.setBackground(new java.awt.Color(114, 137, 218));
        DashboardMKasetUbahButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DashboardMKasetUbahButton.setForeground(new java.awt.Color(255, 255, 255));
        DashboardMKasetUbahButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashboardMKasetUbahButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/edit_24.png"))); // NOI18N
        DashboardMKasetUbahButton.setText("Ubah");
        DashboardMKasetUbahButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DashboardMKasetUbahButton.setOpaque(true);
        DashboardMKasetUbahButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardMKasetUbahButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardMKasetUbahButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardMKasetUbahButtonMouseExited(evt);
            }
        });

        DashboardMKasetHapusButton.setBackground(new java.awt.Color(114, 137, 218));
        DashboardMKasetHapusButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DashboardMKasetHapusButton.setForeground(new java.awt.Color(255, 255, 255));
        DashboardMKasetHapusButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashboardMKasetHapusButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/delete_24.png"))); // NOI18N
        DashboardMKasetHapusButton.setText("Hapus");
        DashboardMKasetHapusButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DashboardMKasetHapusButton.setOpaque(true);
        DashboardMKasetHapusButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardMKasetHapusButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardMKasetHapusButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardMKasetHapusButtonMouseExited(evt);
            }
        });

        DashboardMKasetSegarkanButton.setBackground(new java.awt.Color(114, 137, 218));
        DashboardMKasetSegarkanButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DashboardMKasetSegarkanButton.setForeground(new java.awt.Color(255, 255, 255));
        DashboardMKasetSegarkanButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashboardMKasetSegarkanButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/refresh_24.png"))); // NOI18N
        DashboardMKasetSegarkanButton.setText("Segarkan");
        DashboardMKasetSegarkanButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DashboardMKasetSegarkanButton.setOpaque(true);
        DashboardMKasetSegarkanButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardMKasetSegarkanButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardMKasetSegarkanButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardMKasetSegarkanButtonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout DashboardContentMKasetLayout = new javax.swing.GroupLayout(DashboardContentMKaset);
        DashboardContentMKaset.setLayout(DashboardContentMKasetLayout);
        DashboardContentMKasetLayout.setHorizontalGroup(
            DashboardContentMKasetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardContentMKasetLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DashboardContentMKasetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DashboardMKasetScrollPanel)
                    .addGroup(DashboardContentMKasetLayout.createSequentialGroup()
                        .addComponent(DashboardContentMKasetTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DashboardMKasetCariButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(DashboardContentMKasetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DashboardMKasetCariInput, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                            .addComponent(DashboardMKasetCariInputLine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DashboardMKasetJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DashboardContentMKasetLayout.createSequentialGroup()
                        .addComponent(DashboardMKasetTambahButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DashboardMKasetUbahButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(DashboardMKasetHapusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DashboardMKasetSegarkanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 286, Short.MAX_VALUE)))
                .addContainerGap())
        );
        DashboardContentMKasetLayout.setVerticalGroup(
            DashboardContentMKasetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardContentMKasetLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DashboardContentMKasetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashboardContentMKasetLayout.createSequentialGroup()
                        .addComponent(DashboardContentMKasetTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(DashboardContentMKasetLayout.createSequentialGroup()
                        .addGroup(DashboardContentMKasetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DashboardMKasetJenis, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DashboardMKasetCariButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(DashboardContentMKasetLayout.createSequentialGroup()
                                .addComponent(DashboardMKasetCariInput, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DashboardMKasetCariInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)))
                .addComponent(DashboardMKasetScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DashboardContentMKasetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DashboardMKasetTambahButton, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(DashboardMKasetUbahButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DashboardMKasetSegarkanButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DashboardMKasetHapusButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        DashboardContent.add(DashboardContentMKaset, "card3");

        DashboardContentSewa.setBackground(new java.awt.Color(44, 47, 51));

        DashboardContentSewaTitle.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        DashboardContentSewaTitle.setForeground(new java.awt.Color(255, 255, 255));
        DashboardContentSewaTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/cart_24.png"))); // NOI18N
        DashboardContentSewaTitle.setText("Sewa Kaset");

        DashboardMKasetScrollPanel1.setBorder(null);
        DashboardMKasetScrollPanel1.setForeground(new java.awt.Color(51, 51, 51));
        DashboardMKasetScrollPanel1.setOpaque(false);

        DashboardSewaTable = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        DashboardSewaTable.setForeground(new java.awt.Color(51, 51, 51));
        DashboardSewaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), "Tholut", "Akhyar"},
                { new Integer(2), "Stacia", "Lewis"},
                { new Integer(3), "Kuriyama", "Mirai"},
                { new Integer(4), "Hanekawa", "Tsubasa"}
            },
            new String [] {
                "No", "First Name", "Last Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        DashboardSewaTable.setGridColor(new java.awt.Color(255, 255, 255));
        DashboardSewaTable.setSelectionBackground(new java.awt.Color(114, 137, 218));
        DashboardMKasetScrollPanel1.setViewportView(DashboardSewaTable);

        DashboardMKasetCariButton1.setBackground(new java.awt.Color(114, 137, 218));
        DashboardMKasetCariButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DashboardMKasetCariButton1.setForeground(new java.awt.Color(255, 255, 255));
        DashboardMKasetCariButton1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashboardMKasetCariButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/search_24.png"))); // NOI18N
        DashboardMKasetCariButton1.setText("Cari");
        DashboardMKasetCariButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DashboardMKasetCariButton1.setOpaque(true);
        DashboardMKasetCariButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardMKasetCariButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardMKasetCariButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardMKasetCariButton1MouseExited(evt);
            }
        });

        DashboardMKasetCariInput1.setBackground(new java.awt.Color(44, 47, 51));
        DashboardMKasetCariInput1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        DashboardMKasetCariInput1.setForeground(new java.awt.Color(255, 255, 255));
        DashboardMKasetCariInput1.setText("Pencarian");
        DashboardMKasetCariInput1.setBorder(null);
        DashboardMKasetCariInput1.setOpaque(false);
        DashboardMKasetCariInput1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                DashboardMKasetCariInput1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                DashboardMKasetCariInput1FocusLost(evt);
            }
        });
        DashboardMKasetCariInput1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DashboardMKasetCariInput1KeyPressed(evt);
            }
        });

        DashboardMKasetCariInputLine1.setBackground(new java.awt.Color(35, 39, 42));

        javax.swing.GroupLayout DashboardMKasetCariInputLine1Layout = new javax.swing.GroupLayout(DashboardMKasetCariInputLine1);
        DashboardMKasetCariInputLine1.setLayout(DashboardMKasetCariInputLine1Layout);
        DashboardMKasetCariInputLine1Layout.setHorizontalGroup(
            DashboardMKasetCariInputLine1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        DashboardMKasetCariInputLine1Layout.setVerticalGroup(
            DashboardMKasetCariInputLine1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        DashboardMKasetJenis1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Transaksi Id" }));

        DashboardMKasetTambahButton1.setBackground(new java.awt.Color(114, 137, 218));
        DashboardMKasetTambahButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DashboardMKasetTambahButton1.setForeground(new java.awt.Color(255, 255, 255));
        DashboardMKasetTambahButton1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashboardMKasetTambahButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/plus_24.png"))); // NOI18N
        DashboardMKasetTambahButton1.setText("Transaksi Baru");
        DashboardMKasetTambahButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DashboardMKasetTambahButton1.setOpaque(true);
        DashboardMKasetTambahButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardMKasetTambahButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardMKasetTambahButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardMKasetTambahButton1MouseExited(evt);
            }
        });

        DashboardMKasetUbahButton1.setBackground(new java.awt.Color(114, 137, 218));
        DashboardMKasetUbahButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DashboardMKasetUbahButton1.setForeground(new java.awt.Color(255, 255, 255));
        DashboardMKasetUbahButton1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashboardMKasetUbahButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/open_24.png"))); // NOI18N
        DashboardMKasetUbahButton1.setText("Buka Transaksi");
        DashboardMKasetUbahButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DashboardMKasetUbahButton1.setOpaque(true);
        DashboardMKasetUbahButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardMKasetUbahButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardMKasetUbahButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardMKasetUbahButton1MouseExited(evt);
            }
        });

        DashboardMKasetSegarkanButton1.setBackground(new java.awt.Color(114, 137, 218));
        DashboardMKasetSegarkanButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DashboardMKasetSegarkanButton1.setForeground(new java.awt.Color(255, 255, 255));
        DashboardMKasetSegarkanButton1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashboardMKasetSegarkanButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/refresh_24.png"))); // NOI18N
        DashboardMKasetSegarkanButton1.setText("Segarkan");
        DashboardMKasetSegarkanButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DashboardMKasetSegarkanButton1.setOpaque(true);
        DashboardMKasetSegarkanButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardMKasetSegarkanButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardMKasetSegarkanButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardMKasetSegarkanButton1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout DashboardContentSewaLayout = new javax.swing.GroupLayout(DashboardContentSewa);
        DashboardContentSewa.setLayout(DashboardContentSewaLayout);
        DashboardContentSewaLayout.setHorizontalGroup(
            DashboardContentSewaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardContentSewaLayout.createSequentialGroup()
                .addGroup(DashboardContentSewaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashboardContentSewaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(DashboardContentSewaTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DashboardMKasetCariButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DashboardContentSewaLayout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(DashboardMKasetSegarkanButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(466, Short.MAX_VALUE))
            .addGroup(DashboardContentSewaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashboardContentSewaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(DashboardContentSewaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(DashboardMKasetScrollPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 956, Short.MAX_VALUE)
                        .addGroup(DashboardContentSewaLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(DashboardContentSewaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(DashboardMKasetCariInput1, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                                .addComponent(DashboardMKasetCariInputLine1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addComponent(DashboardMKasetJenis1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(DashboardContentSewaLayout.createSequentialGroup()
                            .addComponent(DashboardMKasetTambahButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(DashboardMKasetUbahButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        DashboardContentSewaLayout.setVerticalGroup(
            DashboardContentSewaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardContentSewaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DashboardContentSewaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DashboardMKasetCariButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DashboardContentSewaTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 349, Short.MAX_VALUE)
                .addComponent(DashboardMKasetSegarkanButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(DashboardContentSewaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashboardContentSewaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(DashboardContentSewaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(DashboardContentSewaLayout.createSequentialGroup()
                            .addComponent(DashboardMKasetJenis1)
                            .addGap(12, 12, 12))
                        .addGroup(DashboardContentSewaLayout.createSequentialGroup()
                            .addComponent(DashboardMKasetCariInput1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DashboardMKasetCariInputLine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                    .addComponent(DashboardMKasetScrollPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(DashboardContentSewaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(DashboardMKasetTambahButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(DashboardMKasetUbahButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap()))
        );

        DashboardContent.add(DashboardContentSewa, "card4");

        DashboardContentLaporan.setBackground(new java.awt.Color(44, 47, 51));

        DashboardContentLaporanTitle.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        DashboardContentLaporanTitle.setForeground(new java.awt.Color(255, 255, 255));
        DashboardContentLaporanTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/report_24.png"))); // NOI18N
        DashboardContentLaporanTitle.setText("Laporan");

        jDateChooser2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jDateChooser2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser2PropertyChange(evt);
            }
        });

        DashboardContentLaporanTitle1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        DashboardContentLaporanTitle1.setForeground(new java.awt.Color(255, 255, 255));
        DashboardContentLaporanTitle1.setText("S/d");

        jDateChooser3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jDateChooser3.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser3PropertyChange(evt);
            }
        });

        DashboardMKasetScrollPanel2.setBorder(null);
        DashboardMKasetScrollPanel2.setForeground(new java.awt.Color(51, 51, 51));
        DashboardMKasetScrollPanel2.setOpaque(false);

        DashboardSewaTable1 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        DashboardSewaTable1.setForeground(new java.awt.Color(51, 51, 51));
        DashboardSewaTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), "Tholut", "Akhyar"},
                { new Integer(2), "Stacia", "Lewis"},
                { new Integer(3), "Kuriyama", "Mirai"},
                { new Integer(4), "Hanekawa", "Tsubasa"}
            },
            new String [] {
                "No", "First Name", "Last Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        DashboardSewaTable1.setGridColor(new java.awt.Color(255, 255, 255));
        DashboardSewaTable1.setSelectionBackground(new java.awt.Color(114, 137, 218));
        DashboardMKasetScrollPanel2.setViewportView(DashboardSewaTable1);

        DashboardMKasetCariButton3.setBackground(new java.awt.Color(114, 137, 218));
        DashboardMKasetCariButton3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DashboardMKasetCariButton3.setForeground(new java.awt.Color(255, 255, 255));
        DashboardMKasetCariButton3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashboardMKasetCariButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/printer_24.png"))); // NOI18N
        DashboardMKasetCariButton3.setText("Cetak");
        DashboardMKasetCariButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DashboardMKasetCariButton3.setOpaque(true);
        DashboardMKasetCariButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardMKasetCariButton3MouseClicked(evt);
            }
        });

        DashboardContentLaporanTitle2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        DashboardContentLaporanTitle2.setForeground(new java.awt.Color(255, 255, 255));
        DashboardContentLaporanTitle2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/user_24.png"))); // NOI18N
        DashboardContentLaporanTitle2.setText("Total Penyewa: 0");

        DashboardContentLaporanTitle3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        DashboardContentLaporanTitle3.setForeground(new java.awt.Color(255, 255, 255));
        DashboardContentLaporanTitle3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashboardContentLaporanTitle3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/cd_24.png"))); // NOI18N
        DashboardContentLaporanTitle3.setText("Total Kaset Keluar: 0");

        DashboardContentLaporanTitle4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        DashboardContentLaporanTitle4.setForeground(new java.awt.Color(255, 255, 255));
        DashboardContentLaporanTitle4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        DashboardContentLaporanTitle4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/banknotes_24.png"))); // NOI18N
        DashboardContentLaporanTitle4.setText("Total Pendapatan: 0");

        javax.swing.GroupLayout DashboardContentLaporanLayout = new javax.swing.GroupLayout(DashboardContentLaporan);
        DashboardContentLaporan.setLayout(DashboardContentLaporanLayout);
        DashboardContentLaporanLayout.setHorizontalGroup(
            DashboardContentLaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardContentLaporanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DashboardContentLaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashboardContentLaporanLayout.createSequentialGroup()
                        .addComponent(DashboardContentLaporanTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DashboardContentLaporanTitle3, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(DashboardContentLaporanTitle4, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DashboardContentLaporanLayout.createSequentialGroup()
                        .addComponent(DashboardContentLaporanTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(DashboardContentLaporanTitle1)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DashboardMKasetCariButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(DashboardContentLaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashboardContentLaporanLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(DashboardMKasetScrollPanel2)
                    .addContainerGap()))
        );
        DashboardContentLaporanLayout.setVerticalGroup(
            DashboardContentLaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardContentLaporanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DashboardContentLaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(DashboardContentLaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(DashboardContentLaporanTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DashboardContentLaporanTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDateChooser3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(DashboardMKasetCariButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 365, Short.MAX_VALUE)
                .addGroup(DashboardContentLaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DashboardContentLaporanTitle2)
                    .addComponent(DashboardContentLaporanTitle3)
                    .addComponent(DashboardContentLaporanTitle4))
                .addContainerGap())
            .addGroup(DashboardContentLaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashboardContentLaporanLayout.createSequentialGroup()
                    .addGap(63, 63, 63)
                    .addComponent(DashboardMKasetScrollPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(46, Short.MAX_VALUE)))
        );

        DashboardContent.add(DashboardContentLaporan, "card5");

        javax.swing.GroupLayout DashboardMainPanelLayout = new javax.swing.GroupLayout(DashboardMainPanel);
        DashboardMainPanel.setLayout(DashboardMainPanelLayout);
        DashboardMainPanelLayout.setHorizontalGroup(
            DashboardMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DashboardHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(DashboardMainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DashboardContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        DashboardMainPanelLayout.setVerticalGroup(
            DashboardMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardMainPanelLayout.createSequentialGroup()
                .addComponent(DashboardHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DashboardContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DashboardMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DashboardMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void MasterDashboard(int GotID, String GotName, int GotRankID) {
        String LocalRankName = Master.RankName(GotRankID);
        DashboardFrame Dsbd = new DashboardFrame();
        Dsbd.setTitle("Dashboard - "+Master.RankName(GotRankID));
        Dsbd.setVisible(true);
        Dsbd.DashboardLoginUsername.setText("Account: "+GotName+" ("+LocalRankName+")");
        Dsbd.AuthUserId = GotID;
        Dsbd.AuthName = GotName;
        Dsbd.AuthRank = LocalRankName;
        Dsbd.LoadTableData("User","","");
        Dsbd.LoadTableData("Kaset","","");
        Dsbd.LoadTableData("Sewa","","");
        Dsbd.LoadTableData("Laporan","","");
        
        
        Dsbd.DashboardContentBerandaTitle1.setText("Selamat Datang Di Dashboard! "+GotName);
        /*
        if (!"Pemilik".equals(LocalRankName)) {
            Dsbd.DashboardLaporanButton.setVisible(false);
        }
        */
    }        
    
    private void BatalTransaksi() {
        System.out.println("batal transaksi (hapus data transaksi)");
        
        TransaksiInputReset();
        
        SewaProcessAwal.setVisible(true);
        SewaProcessKedua.setVisible(false);
        SewaProcessAkhir.setVisible(false);
        
        try {
            int hasil = MySQL.MySQLUpdate("DELETE FROM transaksi WHERE ts_id = '"+baruTransaksi+"'");
            
            if (hasil == 1) {
                System.out.println("data ter delete");
            } else {
                System.out.println("data gagal delete");
            }
            
            int hasil2 = MySQL.MySQLUpdate("DELETE FROM transaksi_detil WHERE ts_id = '"+baruTransaksi+"'");
            
            if (hasil2 == 1) {
                System.out.println("data ter delete");
            } else {
                System.out.println("data gagal delete");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DashboardFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        TransaksiBaruFrame.setVisible(false);
        LoadTableData("Sewa","","");
    }
        
    private void LoadTableData(String DataWhat, String FindWhat, String TypeWhat) {
        try {
            if (DataWhat == "User") {
                while (DTM_User.getRowCount() > 0) {
                    DTM_User.removeRow(0);
                }

                String[][] data_sql = MySQL.MySQLGetUser(FindWhat, TypeWhat, AuthRank);

                int xd = 0;

                while (xd < data_sql.length) {
                    DTM_User.addRow(new Object[]{data_sql[xd][0],data_sql[xd][1],data_sql[xd][2],data_sql[xd][3],data_sql[xd][4],data_sql[xd][5],data_sql[xd][6],data_sql[xd][7],Master.RankName(Integer.parseInt(data_sql[xd][8])),data_sql[xd][9],data_sql[xd][10]});
                    xd++;
                }
            
            } else if (DataWhat == "Kaset") {
            
                while (DTM_Kaset.getRowCount() > 0) {
                    DTM_Kaset.removeRow(0);
                }

                String[][] data_sql = MySQL.MySQLGetKaset(FindWhat, TypeWhat);

                int xd = 0;

                while (xd < data_sql.length) {
                    DTM_Kaset.addRow(new Object[]{data_sql[xd][0],data_sql[xd][1],data_sql[xd][2],data_sql[xd][3],data_sql[xd][4],data_sql[xd][5]});
                    xd++;
                }
            
            } else if (DataWhat == "Sewa") {
                while (DTM_Sewa.getRowCount() > 0) {
                    DTM_Sewa.removeRow(0);
                }

                String[][] data_sql = MySQL.MySQLGetSewa(FindWhat, TypeWhat);

                int xd = 0;

                while (xd < data_sql.length) {
                    DTM_Sewa.addRow(new Object[]{data_sql[xd][0],Master.GetName(Integer.parseInt(data_sql[xd][1])),Master.GetName(Integer.parseInt(data_sql[xd][2])),Master.GetStatus(Integer.parseInt(data_sql[xd][3])),data_sql[xd][4],data_sql[xd][5],data_sql[xd][6],data_sql[xd][7],data_sql[xd][8]});
                    xd++;
                }
            } else if (DataWhat == "CariUser") {
                while (DTM_CariUser.getRowCount() > 0) {
                    DTM_CariUser.removeRow(0);
                }

                String[][] data_sql = MySQL.MySQLGetUser(FindWhat, TypeWhat, AuthRank);

                int xd = 0;

                while (xd < data_sql.length) {
                    DTM_CariUser.addRow(new Object[]{data_sql[xd][0],data_sql[xd][1],data_sql[xd][3]});
                    xd++;
                }
            } else if (DataWhat == "CariKaset") {
                while (DTM_CariKaset.getRowCount() > 0) {
                    DTM_CariKaset.removeRow(0);
                }

                String[][] data_sql = MySQL.MySQLGetKaset(FindWhat, TypeWhat);

                int xd = 0;
                

                while (xd < data_sql.length) {
                    DashboardResultSet = MySQL.MySQLQuery("SELECT COUNT(*) AS 'Jumlah' FROM transaksi_detil, transaksi WHERE transaksi.ts_status_kembali = '0' and transaksi_detil.ts_id = transaksi.ts_id and transaksi_detil.kaset_id = '"+data_sql[xd][0]+"'");
                    if (DashboardResultSet.next()) {
                        System.out.println("["+data_sql[xd][0]+"] Jumlah Kaset Keluar: "+DashboardResultSet.getString("Jumlah").toString());
                        int counting = Integer.parseInt(data_sql[xd][4]) - Integer.parseInt(DashboardResultSet.getString("Jumlah"));
                        System.out.println("["+data_sql[xd][0]+"] Kaset Tersedia Kaset: "+counting);
                        if (counting >= 1) {
                            DTM_CariKaset.addRow(new Object[]{data_sql[xd][0], data_sql[xd][1], data_sql[xd][3], counting});
                        } else {
                            DTM_CariKaset.addRow(new Object[]{data_sql[xd][0], data_sql[xd][1], data_sql[xd][3], "Stok Habis"});
                        }
                    }
                    xd++;
                }
            } else if (DataWhat == "Laporan") {
                while (DTM_Laporan.getRowCount() > 0) {
                    DTM_Laporan.removeRow(0);
                }

                String[][] data_sql = MySQL.MySQLGetSewa(FindWhat, TypeWhat);

                int xd = 0;
                int pendapatan = 0;
                int kasetss = 0;
                while (xd < data_sql.length) {
                    pendapatan = pendapatan + Integer.parseInt(data_sql[xd][4]);
                     DashboardResultSet = MySQL.MySQLQuery("SELECT COUNT(*) AS 'Jumlah' FROM transaksi_detil WHERE ts_id = '"+data_sql[xd][0]+"'");
                    if (DashboardResultSet.next()) {
                        System.out.println("Jumlah Kaset Keluar "+DashboardResultSet.getString("Jumlah"));
                        kasetss = kasetss + Integer.parseInt(DashboardResultSet.getString("Jumlah"));
                        DTM_Laporan.addRow(new Object[]{data_sql[xd][0],Master.GetName(Integer.parseInt(data_sql[xd][1])),Master.GetName(Integer.parseInt(data_sql[xd][2])),Master.GetStatus(Integer.parseInt(data_sql[xd][3])),data_sql[xd][4],data_sql[xd][5],data_sql[xd][6],data_sql[xd][7],data_sql[xd][8]});
                    }
                    xd++;
                }
                TotalPendapatan = pendapatan;
                TotalKasetKuluar = kasetss;
                TotalPenyewa = xd;
                DashboardContentLaporanTitle2.setText("Total Penyewa: "+xd);
                DashboardContentLaporanTitle3.setText("Total Kaset Keluar: "+kasetss);
                DashboardContentLaporanTitle4.setText("Total Pendapatan: "+pendapatan);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    private void TransaksiYesNoFunct(String whatmodel) {
        if ("Batal".equals(whatmodel)) {
            BatalTransaksi();
        } else if ("Reset".equals(whatmodel)) {
            System.out.println("reset data transaksi");
            try {
                int hasil2 = MySQL.MySQLUpdate("DELETE FROM transaksi_detil WHERE ts_id = '"+baruTransaksi+"'");

                while (DTM_SewaBaruTransaksi.getRowCount() > 0) {
                    DTM_SewaBaruTransaksi.removeRow(0);
                }

            } catch (SQLException ex) {
                Logger.getLogger(DashboardFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            TBFTransaksiId2.setText("Total: Rp 0");
            TBFTransaksiId3.setText("Total: Rp 0");
            jTextField1.setText("0");
            jTextField3.setText("0");
        } else if ("Hapus".equals(whatmodel)) {
            System.out.println("hapus barang di list transaksi");
            int Row_ID = DashboardDetilSewaTable1.getSelectedRow();
            String Master_ID =(DashboardDetilSewaTable1.getModel().getValueAt(Row_ID, 0).toString());
            try {
                int hasil2 = MySQL.MySQLUpdate("DELETE FROM transaksi_detil WHERE ts_detil_id = '"+Master_ID+"'");

                String data_sql[][] = MySQL.MySQLGetDetilSewa(baruTransaksi);

                while (DTM_SewaBaruTransaksi.getRowCount() > 0) {
                    DTM_SewaBaruTransaksi.removeRow(0);
                }

                int xd = 0;
                int Total = 0;
                while (xd < data_sql.length) {
                    String data_detill[][] = MySQL.MySQLGetKaset(data_sql[xd][2], "SewaKaset");
                    int TotalHarga = Integer.parseInt(data_detill[0][5])*Integer.parseInt(data_sql[xd][3]);
                    DTM_SewaBaruTransaksi.addRow(new Object[]{data_sql[xd][0], data_sql[xd][2],data_detill[0][1],data_detill[0][5],data_sql[xd][3],TotalHarga});
                    Total = Total + TotalHarga;
                    xd++;
                }

                TBFTransaksiId2.setText("Total: Rp "+Total);
                TBFTransaksiId3.setText("Total: Rp "+Total);
            } catch (SQLException ex) {
                Logger.getLogger(DashboardFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if ("Checkout".equals(whatmodel)) {
            int bayarrr = Integer.parseInt(jTextField4.getText());
            int subtoalll = Integer.parseInt(jTextField1.getText());
            int diskonnn = Integer.parseInt(jTextField2.getText());
            int grandtoalll = Integer.parseInt(jTextField3.getText());
            if (jDateChooser1.getDate() != null) {
                if (bayarrr >= grandtoalll) {
                    System.out.println("uangnya cuku gan");
                    SewaProcessAwal.setVisible(false);
                    SewaProcessKedua.setVisible(false);
                    SewaProcessAkhir.setVisible(true);
                    int kembalians = bayarrr - grandtoalll;
                    TBFTransaksiId10.setText("Kembalian: Rp "+kembalians);

                    try {
                        DateFormat fmt2 = new SimpleDateFormat("yyyy-MM-dd");
                        String tmp_dte2 = fmt2.format(this.jDateChooser1.getDate());
                        System.out.println(tmp_dte2);
                        TBFTransaksiId12.setText(jTextField1.getText());
                        TBFTransaksiId11.setText("0%");
                        TBFTransaksiId13.setText(jTextField3.getText());
                        TBFTransaksiId14.setText(jTextField4.getText());
                        TBFTransaksiId31.setText(String.valueOf(kembalians));
                        TBFTransaksiId16.setText(tmp_dte2);
                        jTextField4.setText("");
                        int hasil = MySQL.MySQLUpdate("UPDATE transaksi SET ts_tgl_pengembalian='"+tmp_dte2+"', ts_diskon='"+diskonnn+"',ts_subtotal='"+subtoalll+"', ts_bayar='"+bayarrr+"', status_pending='0' where ts_id='"+baruTransaksi+"'");
                        LoadTableData("Sewa","","");
                    } catch (SQLException ex) {
                        Logger.getLogger(DashboardFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    System.out.println("uangnya kurang gan");
                    Master.showTholutDialogOk("Informasi", "Maaf uangnya kurang", "Information");
                }
            } else {
                System.out.println("tanggalnya di isi");
                Master.showTholutDialogOk("Informasi", "Tanggal pengembalian kosong", "Information");
            }
        } else if ("Mengembalikan".equals(whatmodel)) {
            System.out.println("kaset kembali");
            if ("Mengembalikan".equals(PengaturanButtonBatal8.getText())) {
                PengaturanButtonBatal8.setText("Sudah Kembali");
                int hasil;
                try {
                    hasil = MySQL.MySQLUpdate("UPDATE transaksi SET ts_status_kembali = '1' WHERE ts_id = '"+BukaTransaksiIdWhat+"' ");

                    if (hasil == 1) {
                        System.out.println("data ter update");
                        Master.showTholutDialogOk("Success", "Berhasil Mengembalikan Peminjaman", "Success");
                        LoadTableData("Kaset","","");
                        UbahTambahKasetDialog.setVisible(false);
                    } else {
                        System.out.println("data gagal di update");
                        Master.showTholutDialogOk("Failed", "Pengembalian Gagal", "Failed");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(DashboardFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                LoadTableData("Sewa","","");
            }
        }
    }
    
    private void PopupUserResetTitleField(String YouWant) {
        if (YouWant == "Title") {
            UTUserUsernameInputTitle.setText(" ");
            UTUserPasswordInputTitle.setText(" ");
            UTUserEmailInputTitle.setText(" ");
            UTUserNikKtpInputTitle.setText(" ");
            UTUserAlamatInputTitle.setText(" ");
            UTUserTeleponInputTitle.setText(" ");
            UTUserNMLengkapInputTitle.setText(" ");
            UTUserUsernameInput.setText("Username");
            UTUserPasswordInput.setText("Password");
            UTUserEmailInput.setText("Email");
            UTUserNikKtpInput.setText("Nik KTP");
            UTUserAlamatInput.setText("Alamat");
            UTUserTeleponInput.setText("Telepon");
            UTUserNMLengkapInput.setText("Nama Lengkap");
        } else if (YouWant == "Input") {
            UTUserUsernameInputTitle.setText("Username");
            UTUserPasswordInputTitle.setText("Password");
            UTUserEmailInputTitle.setText("Email");
            UTUserNikKtpInputTitle.setText("Nik KTP");
            UTUserAlamatInputTitle.setText("Alamat");
            UTUserTeleponInputTitle.setText("Telepon");
            UTUserNMLengkapInputTitle.setText("Nama Lengkap");
            UTUserUsernameInput.setText("");
            UTUserPasswordInput.setText("");
            UTUserEmailInput.setText("");
            UTUserNikKtpInput.setText("");
            UTUserAlamatInput.setText("");
            UTUserTeleponInput.setText("");
            UTUserNMLengkapInput.setText("");
        }
    }
    
    private void PopupKasetResetTitleField(String YouWant) {
        if (YouWant == "Title") {
            UTKasetKodeInputTitle.setText(" ");
            UTKasetNamaInputTitle.setText(" ");
            UTKasetJumlahKepingInputTitle.setText(" ");
            UTKasetStokInputTitle.setText(" ");
            UTKasetHargaInputTitle.setText(" ");
            UTKasetKodeInput.setText("Kode");
            UTKasetNamaInput.setText("Nama");
            UTKasetJumlahKepingInput.setText("Jumlah Keping");
            UTKasetStokInput.setText("Stok");
            UTKasetHargaInput.setText("Harga");
        } else if (YouWant == "Input") {
            UTKasetKodeInputTitle.setText("Kode");
            UTKasetNamaInputTitle.setText("Nama");
            UTKasetJumlahKepingInputTitle.setText("Jumlah Keping");
            UTKasetStokInputTitle.setText("Stok");
            UTKasetHargaInputTitle.setText("Harga");
            UTKasetKodeInput.setText("");
            UTKasetNamaInput.setText("");
            UTKasetJumlahKepingInput.setText("");
            UTKasetStokInput.setText("");
            UTKasetHargaInput.setText("");
        }
    }
    
    private void PengaturanResetTitleField(String YouWant) {
        if (YouWant == "Title") {
            PengaturanUsernameInputTitle.setText(" ");
            PengaturanPasswordInputTitle.setText(" ");
            PengaturanNMLengkapInputTitle.setText(" ");
            PengaturanAlamatInputTitle.setText(" ");
            PengaturanNikKtpInputTitle.setText(" ");
            PengaturanTeleponInputTitle.setText(" ");
            PengaturanEmailInputTitle.setText(" ");
            PengaturanUsernameInput.setText("Username");
            PengaturanPasswordInput.setText("Password");
            PengaturanNMLengkapInput.setText("Nama Lengkap");
            PengaturanAlamatInput.setText("Alamat");
            PengaturanNikKtpInput.setText("Nik KTP");
            PengaturanTeleponInput.setText("Telepon");
            PengaturanEmailInput.setText("Email");
        } else if (YouWant == "Input") {
            PengaturanUsernameInputTitle.setText("Username");
            PengaturanPasswordInputTitle.setText("Password");
            PengaturanNMLengkapInputTitle.setText("Nama Lengkap");
            PengaturanAlamatInputTitle.setText("Alamat");
            PengaturanNikKtpInputTitle.setText("Nik KTP");
            PengaturanTeleponInputTitle.setText("Telepon");
            PengaturanEmailInputTitle.setText("Email");
            PengaturanUsernameInput.setText("");
            PengaturanPasswordInput.setText("");
            PengaturanNMLengkapInput.setText("");
            PengaturanAlamatInput.setText("");
            PengaturanNikKtpInput.setText("");
            PengaturanTeleponInput.setText("");
            PengaturanEmailInput.setText("");
        }
    }
    
    private void PopupUserUbahTambah(String Type, int ItemID) throws ParseException {
        UTUserPasswordInput.setVisible(true);
        UTUserPasswordInputLine.setVisible(true);
        UTUserPasswordInputTitle.setVisible(true);
        UTUserJabatanTitle.setVisible(true);
        UTUserJabatanInput.setVisible(true);
        
        if (!"Pemilik".equals(AuthRank)) {
            UTUserPasswordInput.setVisible(false);
            UTUserPasswordInputLine.setVisible(false);
            UTUserPasswordInputTitle.setVisible(false);
            UTUserJabatanTitle.setVisible(false);
            UTUserJabatanInput.setVisible(false);
        }
        
        if ("Ubah".equals(Type)) {
            try {
                String[][] data_sql = MySQL.MySQLGetUser(String.valueOf(ItemID), "User Id", "Pemilik");
        
                UTUserUsernameInput.setText(data_sql[0][1]);
                UTUserPasswordInput.setText(data_sql[0][2]);
                UTUserEmailInput.setText(data_sql[0][7]);
                UTUserNikKtpInput.setText(data_sql[0][5]);
                UTUserAlamatInput.setText(data_sql[0][4]);
                UTUserTeleponInput.setText(data_sql[0][6]);
                UTUserNMLengkapInput.setText(data_sql[0][3]);
                
                java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(data_sql[0][9]);
                UTUserTanggalLahirInput.setDate(date);
                
                if ("1".equals(data_sql[0][8])) {
                    UTUserJabatanInput.setSelectedIndex(2);
                } else if ("2".equals(data_sql[0][8])) {
                    UTUserJabatanInput.setSelectedIndex(1);
                } else if ("3".equals(data_sql[0][8])) {
                    UTUserJabatanInput.setSelectedIndex(0);
                }
                
                UTUserTitle.setText("Ubah Data");
                UTUserButtonTambah.setText("Ubah");
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
            UbahTambahUserDialog.setVisible(true);
        } else if ("Tambah".equals(Type)) {
            UTUserTitle.setText("Tambah Data");
            UTUserButtonTambah.setText("Tambah");
            UbahTambahUserDialog.setVisible(true);
        }
    }
    
    private void TransaksiInputReset() {
        TBFUserId1.setText("User Id: 0");
        TBFNama2.setText("Nama Penyewa: Tidak Ada");
        TBFTglPeminjaman1.setText("Alamat: Tidak Ada");
        TBFTglPengembalian1.setText("Nik KTP: 00000000000000");
        TBFUserId2.setText("Kaset Id: 0");
        TBFNama4.setText("Judul: Tidak Ada");
        TBFTglPeminjaman2.setText("Jumlah Keping: 0");
        TBFTransaksiId2.setText("Total: Rp 0");
    }
    
    private void PopupKasetUbahTambah(String Type, String ItemID) throws ParseException {
        ResetCheckboxKaset();
        if ("Ubah".equals(Type)) {
            try {
                String[][] data_sql = MySQL.MySQLGetKaset(ItemID, "Kode");
        
                UTKasetKodeInput.setText(data_sql[0][0]);
                UTKasetNamaInput.setText(data_sql[0][1]);
                UTKasetJumlahKepingInput.setText(data_sql[0][2]);
                UTKasetStokInput.setText(data_sql[0][4]);
                UTKasetHargaInput.setText(data_sql[0][5]);
                
                String asdd[] = data_sql[0][3].split(", ");
        
                for (int asd = 0; asd<asdd.length; asd++) {

                    if ("Adventure".equals(asdd[asd])) {
                        adventure_c.setSelected(true);
                    }

                    if ("Fight".equals(asdd[asd])) {
                        fight_c.setSelected(true);
                    }

                    if ("Racing".equals(asdd[asd])) {
                        racing_c.setSelected(true);
                    }

                    if ("Sport".equals(asdd[asd])) {
                        sport_c.setSelected(true);
                    }
                            
                    if ("Classic".equals(asdd[asd])) {
                        classic_c.setSelected(true);
                    }
                            
                    if ("Sci-Fi".equals(asdd[asd])) {
                        scifi_c.setSelected(true);
                    }
                            
                    if ("Horror".equals(asdd[asd])) {
                        horror_c.setSelected(true);
                    }
                            
                    if ("Puzzle".equals(asdd[asd])) {
                        puzzle_c.setSelected(true);
                    }
                            
                    if ("RPG".equals(asdd[asd])) {
                        rpg_c.setSelected(true);
                    }
                }
                
                UTKasetTitle.setText("Ubah Data");
                UTKasetButtonTambah.setText("Ubah");
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
            UbahTambahKasetDialog.setVisible(true);
        } else if ("Tambah".equals(Type)) {
            try {
                DashboardResultSet = MySQL.MySQLQuery("select * from kaset order by kaset_id desc");
                if (DashboardResultSet.next()) {
                    String nofak = DashboardResultSet.getString("kaset_id").substring(2);
                    String AN = "" + (Integer.parseInt(nofak) + 1);
                    String Nol = "";

                    if(AN.length()==1) {
                        Nol = "000";
                    } else if(AN.length()==2) {
                        Nol = "00";
                    } else if(AN.length()==3) {
                        Nol = "0";
                    } else if(AN.length()==4) {
                        Nol = "";
                    }
                
                    UTKasetKodeInput.setText("KS" + Nol + AN);
                } else {
                    UTKasetKodeInput.setText("KS0001");
                }
            
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
            UTKasetTitle.setText("Tambah Data");
            UTKasetButtonTambah.setText("Tambah");
            UbahTambahKasetDialog.setVisible(true);
        }
    }
    
    private void SettingLoadUser() throws ParseException {
        PengaturanResetTitleField("Input");
        try {
            String[][] data_sql = MySQL.MySQLGetUser(""+AuthUserId, "User Id", "Pemilik");
            PengaturanUsernameInput.setText(data_sql[0][1]);
            PengaturanPasswordInput.setText(data_sql[0][2]);
            PengaturanNMLengkapInput.setText(data_sql[0][3]);
            PengaturanAlamatInput.setText(data_sql[0][4]);
            PengaturanNikKtpInput.setText(data_sql[0][5]);
            PengaturanTeleponInput.setText(data_sql[0][6]);
            PengaturanEmailInput.setText(data_sql[0][7]);
            java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(data_sql[0][9]);
            PengaturanTanggalLahirInput.setDate(date);
            PengaturanFrame.setVisible(true);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    private void SettingSaveUser() throws SQLException {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        String tmp_dte22 = fmt.format(this.PengaturanTanggalLahirInput.getDate());
        
        int hasil = MySQL.MySQLUpdate("UPDATE user SET username = '"+PengaturanUsernameInput.getText()+"', password = '"+PengaturanPasswordInput.getText()+"',user_namalengkap = '"+PengaturanNMLengkapInput.getText()+"',user_alamat = '"+PengaturanAlamatInput.getText()+"',user_nik_ktp = '"+PengaturanNikKtpInput.getText()+"' ,user_telp = '"+PengaturanTeleponInput.getText()+"',user_email = '"+PengaturanEmailInput.getText()+"',user_tgl_lahir = '"+tmp_dte22+"' WHERE user_id = '"+AuthUserId+"' ");
        
        if (hasil == 1) {
            System.out.println("data ter update");
            Master.showTholutDialogOk("Success", "Data berhasil di ubah", "Success");
            LoadTableData("User","","");
            UbahTambahUserDialog.setVisible(false);
        } else {
            System.out.println("data gagal di update");
            Master.showTholutDialogOk("Failed", "Data gagal di ubah", "Failed");
        }
    }
    
    private void LaporanAinx() {
        System.out.println("laporan refresh ea");
        if (jDateChooser2.getDate() != null && jDateChooser3.getDate() != null) {
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            String dari = fmt.format(this.jDateChooser2.getDate());
            DateFormat fmt2 = new SimpleDateFormat("yyyy-MM-dd");
            String sampai = fmt2.format(this.jDateChooser3.getDate());
            System.out.println("Rekap Data Dari ["+dari+"] sampai ["+sampai+"]");
            
            while (DTM_Laporan.getRowCount() > 0) {
                DTM_Laporan.removeRow(0);
            }

            try {
                String[][] data_sql = MySQL.MySQLGetLaporan(dari, sampai);
                
                int xd = 0;
                int pendapatan = 0;
                int kasetss = 0;
                while (xd < data_sql.length) {
                    pendapatan = pendapatan + Integer.parseInt(data_sql[xd][4]);
                     DashboardResultSet = MySQL.MySQLQuery("SELECT COUNT(*) AS 'Jumlah' FROM transaksi_detil WHERE ts_id = '"+data_sql[xd][0]+"'");
                    if (DashboardResultSet.next()) {
                        System.out.println("Jumlah Kaset Keluar "+DashboardResultSet.getString("Jumlah"));
                        kasetss = kasetss + Integer.parseInt(DashboardResultSet.getString("Jumlah"));
                        DTM_Laporan.addRow(new Object[]{data_sql[xd][0],Master.GetName(Integer.parseInt(data_sql[xd][1])),Master.GetName(Integer.parseInt(data_sql[xd][2])),Master.GetStatus(Integer.parseInt(data_sql[xd][3])),data_sql[xd][4],data_sql[xd][5],data_sql[xd][6],data_sql[xd][7],data_sql[xd][8]});
                    }
                    xd++;
                }
                
                TotalPendapatan = pendapatan;
                TotalKasetKuluar = kasetss;
                TotalPenyewa = xd;
                
                DashboardContentLaporanTitle2.setText("Total Penyewa: "+xd);
                DashboardContentLaporanTitle3.setText("Total Kaset Keluar: "+kasetss);
                DashboardContentLaporanTitle4.setText("Total Pendapatan: "+pendapatan);
                
            } catch (SQLException ex) {
                Logger.getLogger(DashboardFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    
    private void CetakFromViewNota() {
        try {
            DefaultTableModel de = (DefaultTableModel) DashboardDetilSewaTable.getModel();
            JRTableModelDataSource datasource = new JRTableModelDataSource(de);
            String reportSource = "./NotaTemplate.jrxml";
            
            JasperReport jr = JasperCompileManager.compileReport(reportSource);
            
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("KODE_TRANSAKSI", BukaTransaksiIdWhat);
            params.put("KARYAWAN", TBFNama8.getText());
            params.put("TOTAL", TBFTglPeminjaman5.getText());
            params.put("TUNAI", TBFTglPengembalian5.getText());
            params.put("TGL_PEMINJAMAN", TBFTglPeminjaman.getText());
            params.put("TGL_PENGEMBALIAN",  TBFTglPengembalian.getText());
            params.put("PELANGGAN", Master.GetName(Integer.parseInt(TBFUserId.getText())));
            params.put("KEMBALIAN", Integer.parseInt(TBFTglPengembalian7.getText()));
            params.put("IS_IGNORE_PAGINATION", true);
            
            JasperPrint jp = JasperFillManager.fillReport(jr, params, datasource);
            JasperViewer.viewReport(jp, false);
            System.out.println("[JasperReport] Nota Success");
            //LoadingCetak.setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void CetakTransaksiNota() {
        try {
            DefaultTableModel de = (DefaultTableModel) DashboardDetilSewaTable2.getModel();
            JRTableModelDataSource datasource = new JRTableModelDataSource(de);
            String reportSource = "./NotaTemplate.jrxml";
            
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            String sampai = fmt.format(this.jDateChooser1.getDate());
            
            String pembuat = Master.GetName(AuthUserId);
            java.sql.Date mulai2 = new java.sql.Date(new java.util.Date().getTime());
            String mulai = fmt.format(mulai2);
            System.out.println("[JasperReport] Nota Loading ID: "+baruTransaksi+", Karyawan: "+pembuat+", Total: "+jTextField3.getText()+", Tunai: "+jTextField3.getText());
            JasperReport jr = JasperCompileManager.compileReport(reportSource);
            
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("KODE_TRANSAKSI", baruTransaksi);
            params.put("KARYAWAN", pembuat);
            params.put("TOTAL", jTextField3.getText());
            params.put("TUNAI", TBFTransaksiId14.getText());
            params.put("TGL_PEMINJAMAN", mulai);
            params.put("TGL_PENGEMBALIAN",  sampai);
            params.put("PELANGGAN", Master.GetName(Integer.parseInt(selectedUserId)));
            params.put("KEMBALIAN", Integer.parseInt(TBFTransaksiId31.getText()));
            params.put("IS_IGNORE_PAGINATION", true);
            
            JasperPrint jp = JasperFillManager.fillReport(jr, params, datasource);
            JasperViewer.viewReport(jp, false);
            System.out.println("[JasperReport] Nota Success");
            //LoadingCetak.setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void CetakLaporan() {
        try {
            DefaultTableModel de = (DefaultTableModel) DashboardSewaTable1.getModel();
            JRTableModelDataSource datasource = new JRTableModelDataSource(de);
            String reportSource = "./LaporanTemplate.jrxml";
            
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            String dari = fmt.format(this.jDateChooser2.getDate());
            String sampai = fmt.format(this.jDateChooser3.getDate());
            String pembuat = Master.GetName(AuthUserId);
            
            JasperReport jr = JasperCompileManager.compileReport(reportSource);
            System.out.println("[JasperReport] Laporan Dari: "+dari+", Sampai: "+sampai+", Pembuat: "+pembuat);
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("LAPORAN_DARI", dari);
            params.put("LAPORAN_SAMPAI", sampai);
            params.put("PENYETAK", pembuat);
            params.put("TOTAL_PENDAPATAN", TotalPendapatan);
            params.put("TOTAL_PENYEWA", TotalPenyewa);
            params.put("TOTAL_KASET_KELUAR", TotalKasetKuluar);
            
            JasperPrint jp = JasperFillManager.fillReport(jr, params, datasource);

            JasperViewer.viewReport(jp, false);
            //LoadingCetak.setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void TransaksiBaruKuy() {
        try {
                DashboardResultSet = MySQL.MySQLQuery("select * from transaksi order by ts_id desc");
                if (DashboardResultSet.next()) {
                    String nofak = DashboardResultSet.getString("ts_id").substring(4);
                    String AN = "" + (Integer.parseInt(nofak) + 1);
                    String Nol = "";

                    if(AN.length()==1) {
                        Nol = "00000";
                    } else if(AN.length()==2) {
                        Nol = "0000";
                    } else if(AN.length()==3) {
                        Nol = "000";
                    } else if(AN.length()==4) {
                        Nol = "00";
                    } else if(AN.length()==5) {
                        Nol = "0";
                    } else if(AN.length()==6) {
                        Nol = "";
                    }
                
                    TBFTransaksiId1.setText("TRKS" + Nol + AN);
                } else {
                    TBFTransaksiId1.setText("TRKS000001");
                }
                baruTransaksi = TBFTransaksiId1.getText();
                java.sql.Date date_today2 = new java.sql.Date(new java.util.Date().getTime());
                TBFTransaksiId8.setText(""+date_today2);
                TBFTransaksiId15.setText(""+date_today2);
                int mantap = MySQL.MySQLUpdate("INSERT INTO `transaksi` (`ts_id`, `pelanggan_id`, `karyawan_id`, `ts_status_kembali`, `ts_subtotal`, `ts_diskon`, `ts_bayar`, `ts_tgl_peminjaman`, `ts_tgl_pengembalian`,`status_pending`) VALUES ('"+baruTransaksi+"', '0', '"+AuthUserId+"', '0', '0', '0', '0', '"+date_today2+"', '"+date_today2+"', '1')");
                if (mantap==1) {
                    System.out.println("Transaksi Baru");
                }
        } catch (SQLException ex) {
                System.out.println(ex);
        }
        TransaksiBaruFrame.setVisible(true);
               
        while (DTM_SewaBaruTransaksi.getRowCount() > 0) {
            DTM_SewaBaruTransaksi.removeRow(0);
        }
    }
    
    private void BukaTransaksiDetil(String ItemID) throws ParseException {
        try {
            String data_sql[][] = MySQL.MySQLGetDetilSewa(ItemID);
            
            while (DTM_DetilSewa.getRowCount() > 0) {
                DTM_DetilSewa.removeRow(0);
            }
            
            BukaTransaksiIdWhat = ItemID;

            int xd = 0;
            while (xd < data_sql.length) {
                String data_detill[][] = MySQL.MySQLGetKaset(data_sql[xd][2], "SewaKaset");
                int TotalHarga = Integer.parseInt(data_detill[0][5])*Integer.parseInt(data_sql[xd][3]);
                DTM_DetilSewa.addRow(new Object[]{data_sql[xd][0],data_sql[xd][2],data_detill[0][1],data_detill[0][5],data_sql[xd][3],TotalHarga});
                xd++;
            }
            
            String data_prv[][] = MySQL.MySQLGetSewa(ItemID, "SewaDetil");
            
            TBFTransaksiId.setText("Transaksi ID: "+ItemID);
            TBFNama.setText(Master.GetName(Integer.parseInt(data_prv[0][1])));
            TBFTglPeminjaman.setText(data_prv[0][7]);
            TBFTglPengembalian.setText(data_prv[0][8]);
            TransaksiBukaFrame.setVisible(true);
            TBFUserId9.setText(data_prv[0][4]);
            TBFTglPeminjaman5.setText(data_prv[0][4]);
            TBFTglPengembalian5.setText(data_prv[0][6]);
            TBFNama8.setText(Master.GetName(Integer.parseInt(data_prv[0][2])));
            TBFTglPengembalian7.setText(""+(Integer.parseInt(TBFTglPengembalian5.getText()) - Integer.parseInt(TBFTglPeminjaman5.getText())));
            
            
            if ("0".equals(data_prv[0][3])) {
                PengaturanButtonBatal8.setText("Mengembalikan");
            } else if ("1".equals(data_prv[0][3])) {
                PengaturanButtonBatal8.setText("Sudah Kembali");
            }
            
        } catch (SQLException ex) {
                System.out.println(ex);
        }
    }
    
    private String GetCheckboxKaset() {
        String pilihan_select = "";
        int i = 0;
        
        if (adventure_c.isSelected()){
            if (i >= 1) {
                pilihan_select += ", Adventure";
            } else {
                pilihan_select += "Adventure";
            }
            i++;
        }
        if (fight_c.isSelected()){
            if (i >= 1) {
                pilihan_select += ", Fight";
            } else {
                pilihan_select += "Fight";
            }
            i++;
        }
        if (racing_c.isSelected()){
            if (i >= 1) {
                pilihan_select += ", Racing";
            } else {
                pilihan_select += "Racing";
            }
            i++;
        }
        if (sport_c.isSelected()){
            if (i >= 1) {
                pilihan_select += ", Sport";
            } else {
                pilihan_select += "Sport";
            }
            i++;
        }
        if (classic_c.isSelected()){
            if (i >= 1) {
                pilihan_select += ", Classic";
            } else {
                pilihan_select += "Classic";
            }
            i++;
        }
        if (scifi_c.isSelected()){
            if (i >= 1) {
                pilihan_select += ", Sci-Fi";
            } else {
                pilihan_select += "Sci-Fi";
            }
            i++;
        }
        if (horror_c.isSelected()){
            if (i >= 1) {
                pilihan_select += ", Horror";
            } else {
                pilihan_select += "Horror";
            }
            i++;
        }
        if (puzzle_c.isSelected()){
            if (i >= 1) {
                pilihan_select += ", Puzzle";
            } else {
                pilihan_select += "Puzzle";
            }
            i++;
        }
        if (rpg_c.isSelected()){
            if (i >= 1) {
                pilihan_select += ", RPG";
            } else {
                pilihan_select += "RPG";
            }
            i++;
        }
        
        return pilihan_select;
    }
     
     private void ResetCheckboxKaset() {
        adventure_c.setSelected(false);
        fight_c.setSelected(false);
        racing_c.setSelected(false);
        sport_c.setSelected(false);
        classic_c.setSelected(false);
        scifi_c.setSelected(false);
        horror_c.setSelected(false);
        puzzle_c.setSelected(false);
        rpg_c.setSelected(false);
    }
    
    private void selectedBtnColor(JLabel lbl) {
        lbl.setBackground(new Color(35,39,42));
    }
    
    private void defaultBtnColor(JLabel lbl) {
        lbl.setBackground(new Color(114,137,218));
    }
    
    private void ButtonSwitchPanel(String tabname) {
        defaultBtnColor(DashboardBerandaButton);
        defaultBtnColor(DashboardMUserButton);
        defaultBtnColor(DashboardMKasetButton);
        defaultBtnColor(DashboardSewaButton);
        defaultBtnColor(DashboardLaporanButton);
        DashboardContentBeranda.setVisible(false);
        DashboardContentMUser.setVisible(false);
        DashboardContentMKaset.setVisible(false);
        DashboardContentSewa.setVisible(false);
        DashboardContentLaporan.setVisible(false);
        
        if ("Beranda".equals(tabname)) {
            selectedBtnColor(DashboardBerandaButton);
            DashboardContentBeranda.setVisible(true);  
        } else if ("User".equals(tabname)) {
            selectedBtnColor(DashboardMUserButton);
            DashboardContentMUser.setVisible(true);
        } else if ("Kaset".equals(tabname)) {
            selectedBtnColor(DashboardMKasetButton);
            DashboardContentMKaset.setVisible(true);
        } else if ("Sewa".equals(tabname)) {
            selectedBtnColor(DashboardSewaButton);
            DashboardContentSewa.setVisible(true);
        } else if ("Laporan".equals(tabname)) {
            selectedBtnColor(DashboardLaporanButton);
            DashboardContentLaporan.setVisible(true); 
        }
    }
    
    private void CariTableData(String DataWhat) {
        if ("Kaset".equals(DataWhat)) {
            String d_find[] = {DashboardMKasetCariInput.getText(), (String) DashboardMKasetJenis.getSelectedItem()};
            System.out.print("Find: "+d_find[0]+", Type: "+d_find[1]+"\n");
            if (!"Pencarian".equals(d_find[0])) {
                LoadTableData("Kaset",d_find[0],d_find[1]);
            } else {
                LoadTableData("Kaset","","");
            }
        } else if ("User".equals(DataWhat)) {
            String d_find[] = {DashboardMUserCariInput.getText(), (String) DashboardMUserJenis.getSelectedItem()};
            System.out.print("Find: "+d_find[0]+", Type: "+d_find[1]+"\n");
            if (!"Pencarian".equals(d_find[0])) {
                LoadTableData("User",d_find[0],d_find[1]);
            } else {
                LoadTableData("User","","");
            }
        } else if ("CariUser".equals(DataWhat)) {
            String d_find[] = {PengaturanUsernameInput1.getText(), (String) DashboardMUserJenis1.getSelectedItem()};
            System.out.print("Find: "+d_find[0]+", Type: "+d_find[1]+"\n");
            if (!"Pencarian".equals(d_find[0])) {
                LoadTableData("CariUser",d_find[0],d_find[1]);
            } else {
                LoadTableData("CariUser","","");
            }
        } else if ("CariKaset".equals(DataWhat)) {
            String d_find[] = {PengaturanUsernameInput2.getText(), (String) DashboardMUserJenis2.getSelectedItem()};
            System.out.print("Find: "+d_find[0]+", Type: "+d_find[1]+"\n");
            if (!"Pencarian".equals(d_find[0])) {
                LoadTableData("CariKaset",d_find[0],d_find[1]);
            } else {
                LoadTableData("CariKaset","","");
            }
        } else if ("Sewa".equals(DataWhat)) {
            String d_find[] = {DashboardMKasetCariInput1.getText(), (String) DashboardMKasetJenis1.getSelectedItem()};
            System.out.print("Find: "+d_find[0]+", Type: "+d_find[1]+"\n");
            if (!"Pencarian".equals(d_find[0])) {
                LoadTableData("Sewa",d_find[0],d_find[1]);
            } else {
                LoadTableData("Sewa","","");
            }
        }
    }
    
    private void DashboardMUserCariInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DashboardMUserCariInputFocusGained
        // TODO add your handling code here:
        DashboardMUserCariInputLine.setBackground(new java.awt.Color(255,255,255));
        if ("Pencarian".equals(DashboardMUserCariInput.getText())) {
            DashboardMUserCariInput.setText("");
        }
        
    }//GEN-LAST:event_DashboardMUserCariInputFocusGained

    private void DashboardMUserCariInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DashboardMUserCariInputFocusLost
        // TODO add your handling code here:
        DashboardMUserCariInputLine.setBackground(new java.awt.Color(35, 39, 42));
        if ("".equals(DashboardMUserCariInput.getText())) {
            DashboardMUserCariInput.setText("Pencarian");
        }
        
    }//GEN-LAST:event_DashboardMUserCariInputFocusLost

    private void DashboardMKasetCariInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DashboardMKasetCariInputFocusGained
        // TODO add your handling code here:
        DashboardMKasetCariInputLine.setBackground(new java.awt.Color(255,255,255));
        if ("Pencarian".equals(DashboardMKasetCariInput.getText())) {
            DashboardMKasetCariInput.setText("");
        }
    }//GEN-LAST:event_DashboardMKasetCariInputFocusGained

    private void DashboardMKasetCariInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DashboardMKasetCariInputFocusLost
        // TODO add your handling code here:
        DashboardMKasetCariInputLine.setBackground(new java.awt.Color(35, 39, 42));
        if ("".equals(DashboardMKasetCariInput.getText())) {
            DashboardMKasetCariInput.setText("Pencarian");
        }
    }//GEN-LAST:event_DashboardMKasetCariInputFocusLost

    private void DashboardBerandaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardBerandaButtonMouseClicked
        // TODO add your handling code here:
        ButtonSwitchPanel("Beranda");
    }//GEN-LAST:event_DashboardBerandaButtonMouseClicked

    private void DashboardMUserButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserButtonMouseClicked
        // TODO add your handling code here:
        ButtonSwitchPanel("User");
    }//GEN-LAST:event_DashboardMUserButtonMouseClicked

    private void DashboardMKasetButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMKasetButtonMouseClicked
        // TODO add your handling code here:
        ButtonSwitchPanel("Kaset");
    }//GEN-LAST:event_DashboardMKasetButtonMouseClicked

    private void DashboardSewaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardSewaButtonMouseClicked
        // TODO add your handling code here:
        ButtonSwitchPanel("Sewa");
    }//GEN-LAST:event_DashboardSewaButtonMouseClicked

    private void DashboardLaporanButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardLaporanButtonMouseClicked
        // TODO add your handling code here:
        ButtonSwitchPanel("Laporan");
    }//GEN-LAST:event_DashboardLaporanButtonMouseClicked

    private void DashboardCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardCloseMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_DashboardCloseMouseClicked

    private void DashboardCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardCloseMouseEntered
        // TODO add your handling code here:
        DashboardClose.setBackground(new java.awt.Color(240, 71, 71));
    }//GEN-LAST:event_DashboardCloseMouseEntered

    private void DashboardCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardCloseMouseExited
        // TODO add your handling code here:
        DashboardClose.setBackground(new java.awt.Color(32,34,37));
    }//GEN-LAST:event_DashboardCloseMouseExited

    private void DashboardMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMinimizeMouseClicked
        // TODO add your handling code here:
        this.setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_DashboardMinimizeMouseClicked

    private void DashboardMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMinimizeMouseEntered
        // TODO add your handling code here:
        DashboardMinimize.setBackground(new java.awt.Color(43, 44, 47));
    }//GEN-LAST:event_DashboardMinimizeMouseEntered

    private void DashboardMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMinimizeMouseExited
        // TODO add your handling code here:
        DashboardMinimize.setBackground(new java.awt.Color(32,34,37));
    }//GEN-LAST:event_DashboardMinimizeMouseExited

    private void DashboardHeaderDragMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardHeaderDragMousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_DashboardHeaderDragMousePressed

    private void DashboardHeaderDragMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardHeaderDragMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xx,y-xy);
    }//GEN-LAST:event_DashboardHeaderDragMouseDragged

    private void DashboardKeluarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardKeluarButtonMouseClicked
        // TODO add your handling code here:
        DashboardLoginUsername.setText("Account: null (rank)");
        gui.LoginFrame pkg = new gui.LoginFrame();
        pkg.setVisible(true);
        AuthUserId = 0;
        AuthName = null;
        AuthRank = null;
        this.setVisible(false);
        Master.showTholutDialogOk("Informasi", "Anda berhasil keluar", "Success");
    }//GEN-LAST:event_DashboardKeluarButtonMouseClicked

    private void DashboardBerandaButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardBerandaButtonMouseEntered
        // TODO add your handling code here:
        if (DashboardContentBeranda.isVisible() == false) {
            DashboardBerandaButton.setBackground(ButtonColorEntered);
        }
    }//GEN-LAST:event_DashboardBerandaButtonMouseEntered

    private void DashboardBerandaButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardBerandaButtonMouseExited
        // TODO add your handling code here:
        
        if (DashboardContentBeranda.isVisible() == false) {
            DashboardBerandaButton.setBackground(ButtonColorExited);
        }
    }//GEN-LAST:event_DashboardBerandaButtonMouseExited

    private void DashboardMUserButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserButtonMouseEntered
        // TODO add your handling code here:
        if (DashboardContentMUser.isVisible() == false) {
            DashboardMUserButton.setBackground(ButtonColorEntered);
        }
    }//GEN-LAST:event_DashboardMUserButtonMouseEntered

    private void DashboardMUserButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserButtonMouseExited
        // TODO add your handling code here:
        if (DashboardContentMUser.isVisible() == false) {
            DashboardMUserButton.setBackground(ButtonColorExited);
        }
    }//GEN-LAST:event_DashboardMUserButtonMouseExited

    private void DashboardMKasetButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMKasetButtonMouseEntered
        // TODO add your handling code here:
        if (DashboardContentMKaset.isVisible() == false) {
            DashboardMKasetButton.setBackground(ButtonColorEntered);
        }
    }//GEN-LAST:event_DashboardMKasetButtonMouseEntered

    private void DashboardMKasetButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMKasetButtonMouseExited
        // TODO add your handling code here:
        if (DashboardContentMKaset.isVisible() == false) {
            DashboardMKasetButton.setBackground(ButtonColorExited);
        }
    }//GEN-LAST:event_DashboardMKasetButtonMouseExited

    private void DashboardSewaButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardSewaButtonMouseEntered
        // TODO add your handling code here:
        if (DashboardContentSewa.isVisible() == false) {
            DashboardSewaButton.setBackground(ButtonColorEntered);
        }
    }//GEN-LAST:event_DashboardSewaButtonMouseEntered

    private void DashboardSewaButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardSewaButtonMouseExited
        // TODO add your handling code here:
        if (DashboardContentSewa.isVisible() == false) {
            DashboardSewaButton.setBackground(ButtonColorExited);
        }
    }//GEN-LAST:event_DashboardSewaButtonMouseExited

    private void DashboardLaporanButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardLaporanButtonMouseEntered
        // TODO add your handling code here:
        if (DashboardContentLaporan.isVisible() == false) {
            DashboardLaporanButton.setBackground(ButtonColorEntered);
        }
    }//GEN-LAST:event_DashboardLaporanButtonMouseEntered

    private void DashboardLaporanButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardLaporanButtonMouseExited
        // TODO add your handling code here:
        if (DashboardContentLaporan.isVisible() == false) {
            DashboardLaporanButton.setBackground(ButtonColorExited);
        }
    }//GEN-LAST:event_DashboardLaporanButtonMouseExited

    private void DashboardMKasetCariButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMKasetCariButtonMouseEntered
        // TODO add your handling code here:
        DashboardMKasetCariButton.setBackground(ButtonColorEntered);
    }//GEN-LAST:event_DashboardMKasetCariButtonMouseEntered

    private void DashboardMKasetCariButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMKasetCariButtonMouseExited
        // TODO add your handling code here:
        DashboardMKasetCariButton.setBackground(ButtonColorExited);
    }//GEN-LAST:event_DashboardMKasetCariButtonMouseExited

    private void DashboardMKasetTambahButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMKasetTambahButtonMouseEntered
        // TODO add your handling code here:
        DashboardMKasetTambahButton.setBackground(ButtonColorEntered);
    }//GEN-LAST:event_DashboardMKasetTambahButtonMouseEntered

    private void DashboardMKasetTambahButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMKasetTambahButtonMouseExited
        // TODO add your handling code here:
        DashboardMKasetTambahButton.setBackground(ButtonColorExited);
    }//GEN-LAST:event_DashboardMKasetTambahButtonMouseExited

    private void DashboardMKasetUbahButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMKasetUbahButtonMouseEntered
        // TODO add your handling code here:
        DashboardMKasetUbahButton.setBackground(ButtonColorEntered);
    }//GEN-LAST:event_DashboardMKasetUbahButtonMouseEntered

    private void DashboardMKasetUbahButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMKasetUbahButtonMouseExited
        // TODO add your handling code here:
        DashboardMKasetUbahButton.setBackground(ButtonColorExited);
    }//GEN-LAST:event_DashboardMKasetUbahButtonMouseExited

    private void DashboardMKasetHapusButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMKasetHapusButtonMouseEntered
        // TODO add your handling code here:
        DashboardMKasetHapusButton.setBackground(ButtonColorEntered);
    }//GEN-LAST:event_DashboardMKasetHapusButtonMouseEntered

    private void DashboardMKasetHapusButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMKasetHapusButtonMouseExited
        // TODO add your handling code here:
        DashboardMKasetHapusButton.setBackground(ButtonColorExited);
    }//GEN-LAST:event_DashboardMKasetHapusButtonMouseExited

    private void DashboardMUserCariButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserCariButtonMouseEntered
        // TODO add your handling code here:
        DashboardMUserCariButton.setBackground(ButtonColorEntered);
    }//GEN-LAST:event_DashboardMUserCariButtonMouseEntered

    private void DashboardMUserCariButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserCariButtonMouseExited
        // TODO add your handling code here:
        DashboardMUserCariButton.setBackground(ButtonColorExited);
    }//GEN-LAST:event_DashboardMUserCariButtonMouseExited

    private void DashboardMUserTambahButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButtonMouseEntered
        // TODO add your handling code here:
        DashboardMUserTambahButton.setBackground(ButtonColorEntered);
    }//GEN-LAST:event_DashboardMUserTambahButtonMouseEntered

    private void DashboardMUserTambahButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButtonMouseExited
        // TODO add your handling code here:
        DashboardMUserTambahButton.setBackground(ButtonColorExited);
    }//GEN-LAST:event_DashboardMUserTambahButtonMouseExited

    private void DashboardMUserUbahButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserUbahButtonMouseEntered
        // TODO add your handling code here:
        DashboardMUserUbahButton.setBackground(ButtonColorEntered);
    }//GEN-LAST:event_DashboardMUserUbahButtonMouseEntered

    private void DashboardMUserUbahButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserUbahButtonMouseExited
        // TODO add your handling code here:
        DashboardMUserUbahButton.setBackground(ButtonColorExited);
    }//GEN-LAST:event_DashboardMUserUbahButtonMouseExited

    private void DashboardMUserHapusButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserHapusButtonMouseEntered
        // TODO add your handling code here:
        DashboardMUserHapusButton.setBackground(ButtonColorEntered);
    }//GEN-LAST:event_DashboardMUserHapusButtonMouseEntered

    private void DashboardMUserHapusButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserHapusButtonMouseExited
        // TODO add your handling code here:
        DashboardMUserHapusButton.setBackground(ButtonColorExited);
    }//GEN-LAST:event_DashboardMUserHapusButtonMouseExited

    private void DashboardMUserCariButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserCariButtonMouseClicked
        // TODO add your handling code here:
        CariTableData("User");
    }//GEN-LAST:event_DashboardMUserCariButtonMouseClicked

    private void DashboardMKasetCariButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMKasetCariButtonMouseClicked
        // TODO add your handling code here:
        CariTableData("Kaset");
    }//GEN-LAST:event_DashboardMKasetCariButtonMouseClicked

    private void DashboardMKasetSegarkanButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMKasetSegarkanButtonMouseEntered
        // TODO add your handling code here:
        DashboardMKasetSegarkanButton.setBackground(ButtonColorEntered);
    }//GEN-LAST:event_DashboardMKasetSegarkanButtonMouseEntered

    private void DashboardMKasetSegarkanButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMKasetSegarkanButtonMouseExited
        // TODO add your handling code here:
        DashboardMKasetSegarkanButton.setBackground(ButtonColorExited);
    }//GEN-LAST:event_DashboardMKasetSegarkanButtonMouseExited

    private void DashboardMUserSegarkanButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserSegarkanButtonMouseEntered
        // TODO add your handling code here:
        DashboardMUserSegarkanButton.setBackground(ButtonColorEntered);
    }//GEN-LAST:event_DashboardMUserSegarkanButtonMouseEntered

    private void DashboardMUserSegarkanButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserSegarkanButtonMouseExited
        // TODO add your handling code here:
        DashboardMUserSegarkanButton.setBackground(ButtonColorExited);
    }//GEN-LAST:event_DashboardMUserSegarkanButtonMouseExited

    private void DashboardKeluarButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardKeluarButtonMouseEntered
        // TODO add your handling code here:
        DashboardKeluarButton.setBackground(ButtonColorEntered);
    }//GEN-LAST:event_DashboardKeluarButtonMouseEntered

    private void DashboardKeluarButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardKeluarButtonMouseExited
        // TODO add your handling code here:
        DashboardKeluarButton.setBackground(ButtonColorExited);
    }//GEN-LAST:event_DashboardKeluarButtonMouseExited

    private void DashboardMUserTambahButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButtonMouseClicked
        // TODO add your handling code here:
        PopupUserResetTitleField("Title");
        TypeDialogYesNo = "User";
        try {
            PopupUserUbahTambah("Tambah",1);
        } catch (ParseException ex) {
            Logger.getLogger(DashboardFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_DashboardMUserTambahButtonMouseClicked

    private void DashboardMKasetTambahButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMKasetTambahButtonMouseClicked
        // TODO add your handling code here:
        PopupKasetResetTitleField("Title");
        TypeDialogYesNo = "Kaset";
        try {
            PopupKasetUbahTambah("Tambah","1");
        } catch (ParseException ex) {
            Logger.getLogger(DashboardFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_DashboardMKasetTambahButtonMouseClicked

    private void DashboardMUserUbahButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserUbahButtonMouseClicked
        // TODO add your handling code here:
        int Row_ID = DashboardMUserTable.getSelectedRow();
        if (Row_ID >= 0) {
            PopupUserResetTitleField("Input");
            String Master_ID =(DashboardMUserTable.getModel().getValueAt(Row_ID, 0).toString());
            IdDialogYesNo = Integer.parseInt(Master_ID);
            TypeDialogYesNo = "User";
            try {
                PopupUserUbahTambah("Ubah",IdDialogYesNo);
            } catch (ParseException ex) {
                Logger.getLogger(DashboardFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Master.showTholutDialogOk("Informasi", "Silahkan pilih salah satu data", "Information");
        }
    }//GEN-LAST:event_DashboardMUserUbahButtonMouseClicked

    private void DashboardMKasetUbahButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMKasetUbahButtonMouseClicked
        // TODO add your handling code here:
        int Row_ID = DashboardMKasetTable.getSelectedRow();
        if (Row_ID >= 0) {
            PopupKasetResetTitleField("Input");
            String Master_ID =(DashboardMKasetTable.getModel().getValueAt(Row_ID, 0).toString());
            TypeDialogYesNo = "Kaset";
            IdDialogYesNoString = Master_ID;
            try {
                PopupKasetUbahTambah("Ubah",IdDialogYesNoString);
            } catch (ParseException ex) {
                Logger.getLogger(DashboardFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Master.showTholutDialogOk("Informasi", "Silahkan pilih salah satu data", "Information");
        }
    }//GEN-LAST:event_DashboardMKasetUbahButtonMouseClicked

    private void DashboardMUserHapusButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserHapusButtonMouseClicked
        // TODO add your handling code here:
        int Row_ID = DashboardMUserTable.getSelectedRow();
        if (Row_ID >= 0) {
            String Master_ID =(DashboardMUserTable.getModel().getValueAt(Row_ID, 0).toString());
            try {
                String[][] data_sql = MySQL.MySQLGetUser(Master_ID, "User Id", AuthRank);
                DialogDeleteDetail.setText(
                    "User Id: "+data_sql[0][0]+
                    "\nUsername: "+data_sql[0][1]+
                    "\nNama Lengkap: "+data_sql[0][3]+
                    "\nJabatan: "+data_sql[0][8]+
                    "\nEmail: "+data_sql[0][7]
                    );
            } catch (SQLException ex) {
                Logger.getLogger(DashboardFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            DataDeleteType = "User";
            DataDeleteId = Integer.parseInt(Master_ID);

            DeleteDialogYesNo.setVisible(true);
        } else {
            Master.showTholutDialogOk("Informasi", "Silahkan pilih salah satu data", "Information");
        }
    }//GEN-LAST:event_DashboardMUserHapusButtonMouseClicked

    private void DashboardMKasetHapusButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMKasetHapusButtonMouseClicked
        // TODO add your handling code here:
        int Row_ID = DashboardMKasetTable.getSelectedRow();
        if (Row_ID >= 0) {
            String Master_ID =(DashboardMKasetTable.getModel().getValueAt(Row_ID, 0).toString());

            try {
                String[][] data_sql = MySQL.MySQLGetKaset(Master_ID, "Kode");
                DialogDeleteDetail.setText(
                    "Kode: "+data_sql[0][0]+
                    "\nNama\\Judul: "+data_sql[0][1]+
                    "\nHarga: "+data_sql[0][5]
                    );
            } catch (SQLException ex) {
                Logger.getLogger(DashboardFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            DataDeleteType = "Kaset";
            DataDeleteIdString = Master_ID;

            DeleteDialogYesNo.setVisible(true);
        } else {
            Master.showTholutDialogOk("Informasi", "Silahkan pilih salah satu data", "Information");
        }
    }//GEN-LAST:event_DashboardMKasetHapusButtonMouseClicked

    private void DashboardMUserSegarkanButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserSegarkanButtonMouseClicked
        // TODO add your handling code here:
        DashboardMUserCariInput.setText("Pencarian");
        LoadTableData("User","","");
    }//GEN-LAST:event_DashboardMUserSegarkanButtonMouseClicked

    private void DashboardMKasetSegarkanButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMKasetSegarkanButtonMouseClicked
        // TODO add your handling code here:
        DashboardMKasetCariInput.setText("Pencarian");
        LoadTableData("Kaset","","");
    }//GEN-LAST:event_DashboardMKasetSegarkanButtonMouseClicked

    private void DialogDelete_CloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DialogDelete_CloseMouseClicked
        // TODO add your handling code here:
        DeleteDialogYesNo.setVisible(false);
    }//GEN-LAST:event_DialogDelete_CloseMouseClicked

    private void DialogDelete_CloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DialogDelete_CloseMouseEntered
        // TODO add your handling code here:
        DialogDelete_Close.setBackground(new java.awt.Color(240, 71, 71));
    }//GEN-LAST:event_DialogDelete_CloseMouseEntered

    private void DialogDelete_CloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DialogDelete_CloseMouseExited
        // TODO add your handling code here:
        DialogDelete_Close.setBackground(new java.awt.Color(32,34,37));
    }//GEN-LAST:event_DialogDelete_CloseMouseExited

    private void DialogDeleteTidakButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DialogDeleteTidakButtonMouseClicked
        // TODO add your handling code here:
        DeleteDialogYesNo.setVisible(false);
    }//GEN-LAST:event_DialogDeleteTidakButtonMouseClicked

    private void DialogDeleteTidakButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DialogDeleteTidakButtonMouseEntered
        // TODO add your handling code here:
        DialogDeleteTidakButton.setBackground(ButtonColorEntered);
    }//GEN-LAST:event_DialogDeleteTidakButtonMouseEntered

    private void DialogDeleteTidakButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DialogDeleteTidakButtonMouseExited
        // TODO add your handling code here:
        DialogDeleteTidakButton.setBackground(ButtonColorExited);
    }//GEN-LAST:event_DialogDeleteTidakButtonMouseExited

    private void DialogDeleteYaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DialogDeleteYaButtonMouseClicked
        // TODO add your handling code here:
        try {
            if ("Kaset".equals(DataDeleteType)) {
                int hasil = MySQL.MySQLUpdate("DELETE FROM kaset WHERE kaset_id = '"+DataDeleteIdString+"'");

                if (hasil == 1) {
                    System.out.println("data ter delete");
                    Master.showTholutDialogOk("Success", "Data berhasil di hapus", "Success");
                } else {
                    System.out.println("data gagal delete");
                    Master.showTholutDialogOk("Failed", "Data gagal di hapus", "Failed");
                }
                LoadTableData("Kaset","","");
            } else if ("User".equals(DataDeleteType)) {
                int hasil = MySQL.MySQLUpdate("DELETE FROM user WHERE user_id = '"+DataDeleteId+"'");
                    
                if (hasil == 1) {
                    System.out.println("data ter delete");
                    Master.showTholutDialogOk("Success", "Data berhasil di hapus", "Success");
                } else {
                    System.out.println("data gagal delete");
                    Master.showTholutDialogOk("Failed", "Data gagal di hapus", "Failed");
                }
                LoadTableData("User","","");
            }
                
        } catch (SQLException ex) {
                System.out.println(ex);
        }
        
        DeleteDialogYesNo.setVisible(false);
    }//GEN-LAST:event_DialogDeleteYaButtonMouseClicked

    private void DialogDeleteYaButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DialogDeleteYaButtonMouseEntered
        // TODO add your handling code here:
        DialogDeleteYaButton.setBackground(ButtonColorEntered);
    }//GEN-LAST:event_DialogDeleteYaButtonMouseEntered

    private void DialogDeleteYaButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DialogDeleteYaButtonMouseExited
        // TODO add your handling code here:
        DialogDeleteYaButton.setBackground(ButtonColorExited);
    }//GEN-LAST:event_DialogDeleteYaButtonMouseExited

    private void UTUserButtonCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UTUserButtonCloseMouseClicked
        // TODO add your handling code here:
        UbahTambahUserDialog.setVisible(false);
    }//GEN-LAST:event_UTUserButtonCloseMouseClicked

    private void UTUserButtonCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UTUserButtonCloseMouseEntered
        // TODO add your handling code here:
        UTUserButtonClose.setBackground(new java.awt.Color(240, 71, 71));
    }//GEN-LAST:event_UTUserButtonCloseMouseEntered

    private void UTUserButtonCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UTUserButtonCloseMouseExited
        // TODO add your handling code here:
        UTUserButtonClose.setBackground(new java.awt.Color(32,34,37));
    }//GEN-LAST:event_UTUserButtonCloseMouseExited

    private void UTUserUsernameInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UTUserUsernameInputFocusGained
        // TODO add your handling code here:
        UTUserUsernameInputLine.setBackground(new java.awt.Color(255,255,255));
        if ("Username".equals(UTUserUsernameInput.getText())) {
            UTUserUsernameInput.setText("");
            UTUserUsernameInputTitle.setText("Username");
        }
    }//GEN-LAST:event_UTUserUsernameInputFocusGained

    private void UTUserUsernameInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UTUserUsernameInputFocusLost
        // TODO add your handling code here:
        UTUserUsernameInputLine.setBackground(new java.awt.Color(35, 39, 42));
        if ("".equals(UTUserUsernameInput.getText())) {
            UTUserUsernameInput.setText("Username");
            UTUserUsernameInputTitle.setText(" ");
        }
    }//GEN-LAST:event_UTUserUsernameInputFocusLost

    private void UTUserNMLengkapInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UTUserNMLengkapInputFocusGained
        // TODO add your handling code here:
        UTUserNMLengkapInputLine.setBackground(new java.awt.Color(255,255,255));
        if ("Nama Lengkap".equals(UTUserNMLengkapInput.getText())) {
            UTUserNMLengkapInput.setText("");
            UTUserNMLengkapInputTitle.setText("Nama Lengkap");
        }
    }//GEN-LAST:event_UTUserNMLengkapInputFocusGained

    private void UTUserNMLengkapInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UTUserNMLengkapInputFocusLost
        // TODO add your handling code here:
        UTUserNMLengkapInputLine.setBackground(new java.awt.Color(35, 39, 42));
        if ("".equals(UTUserNMLengkapInput.getText())) {
            UTUserNMLengkapInput.setText("Nama Lengkap");
            UTUserNMLengkapInputTitle.setText(" ");
        }
    }//GEN-LAST:event_UTUserNMLengkapInputFocusLost

    private void UTUserAlamatInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UTUserAlamatInputFocusGained
        // TODO add your handling code here:
        UTUserAlamatInputLine.setBackground(new java.awt.Color(255,255,255));
        if ("Alamat".equals(UTUserAlamatInput.getText())) {
            UTUserAlamatInput.setText("");
            UTUserAlamatInputTitle.setText("Alamat");
        }
    }//GEN-LAST:event_UTUserAlamatInputFocusGained

    private void UTUserAlamatInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UTUserAlamatInputFocusLost
        // TODO add your handling code here:
        UTUserAlamatInputLine.setBackground(new java.awt.Color(35, 39, 42));
        if ("".equals(UTUserAlamatInput.getText())) {
            UTUserAlamatInput.setText("Alamat");
            UTUserAlamatInputTitle.setText(" ");
        }
    }//GEN-LAST:event_UTUserAlamatInputFocusLost

    private void UTUserNikKtpInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UTUserNikKtpInputFocusGained
        // TODO add your handling code here:
        UTUserNikKtpInputLine.setBackground(new java.awt.Color(255,255,255));
        if ("Nik KTP".equals(UTUserNikKtpInput.getText())) {
            UTUserNikKtpInput.setText("");
            UTUserNikKtpInputTitle.setText("Nik KTP");
        }
    }//GEN-LAST:event_UTUserNikKtpInputFocusGained

    private void UTUserNikKtpInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UTUserNikKtpInputFocusLost
        // TODO add your handling code here:
        UTUserNikKtpInputLine.setBackground(new java.awt.Color(35, 39, 42));
        if ("".equals(UTUserNikKtpInput.getText())) {
            UTUserNikKtpInput.setText("Nik KTP");
            UTUserNikKtpInputTitle.setText(" ");
        }
    }//GEN-LAST:event_UTUserNikKtpInputFocusLost

    private void UTUserTeleponInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UTUserTeleponInputFocusGained
        // TODO add your handling code here:
        UTUserTeleponInputLine.setBackground(new java.awt.Color(255,255,255));
        if ("Telepon".equals(UTUserTeleponInput.getText())) {
            UTUserTeleponInput.setText("");
            UTUserTeleponInputTitle.setText("Telepon");
        }
    }//GEN-LAST:event_UTUserTeleponInputFocusGained

    private void UTUserTeleponInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UTUserTeleponInputFocusLost
        // TODO add your handling code here:
        UTUserTeleponInputLine.setBackground(new java.awt.Color(35, 39, 42));
        if ("".equals(UTUserTeleponInput.getText())) {
            UTUserTeleponInput.setText("Telepon");
            UTUserTeleponInputTitle.setText(" ");
        }
    }//GEN-LAST:event_UTUserTeleponInputFocusLost

    private void UTUserPasswordInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UTUserPasswordInputFocusGained
        // TODO add your handling code here:
        UTUserPasswordInputLine.setBackground(new java.awt.Color(255,255,255));
        if ("Password".equals(UTUserPasswordInput.getText())) {
            UTUserPasswordInput.setText("");
            UTUserPasswordInputTitle.setText("Password");
        }
    }//GEN-LAST:event_UTUserPasswordInputFocusGained

    private void UTUserPasswordInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UTUserPasswordInputFocusLost
        // TODO add your handling code here:
        UTUserPasswordInputLine.setBackground(new java.awt.Color(35, 39, 42));
        if ("".equals(UTUserPasswordInput.getText())) {
            UTUserPasswordInput.setText("Password");
            UTUserPasswordInputTitle.setText(" ");
        }
    }//GEN-LAST:event_UTUserPasswordInputFocusLost

    private void UTUserEmailInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UTUserEmailInputFocusGained
        // TODO add your handling code here:
        UTUserEmailInputLine.setBackground(new java.awt.Color(255,255,255));
        if ("Email".equals(UTUserEmailInput.getText())) {
            UTUserEmailInput.setText("");
            UTUserEmailInputTitle.setText("Email");
        }
    }//GEN-LAST:event_UTUserEmailInputFocusGained

    private void UTUserEmailInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UTUserEmailInputFocusLost
        // TODO add your handling code here:
        UTUserEmailInputLine.setBackground(new java.awt.Color(35, 39, 42));
        if ("".equals(UTUserEmailInput.getText())) {
            UTUserEmailInput.setText("Email");
            UTUserEmailInputTitle.setText(" ");
        }
    }//GEN-LAST:event_UTUserEmailInputFocusLost

    private void UTUserButtonBatalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UTUserButtonBatalMouseClicked
        // TODO add your handling code here:
        UbahTambahUserDialog.setVisible(false);
    }//GEN-LAST:event_UTUserButtonBatalMouseClicked

    private void UTUserButtonTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UTUserButtonTambahMouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        String data_k[] = {UTUserUsernameInput.getText(),
            UTUserNMLengkapInput.getText(),
            UTUserNikKtpInput.getText(),
            UTUserTeleponInput.getText(),
            UTUserEmailInput.getText(),
            UTUserPasswordInput.getText(),
            (String) UTUserJabatanInput.getSelectedItem(),
            UTUserAlamatInput.getText()
        };
        
        if (data_k[0] != null && !"Username".equals(data_k[0]) &&
            data_k[1] != null  && !"Nama Lengkap".equals(data_k[1]) &&
            data_k[2] != null  && !"Nik KTP".equals(data_k[2]) &&
            data_k[3] != null  && !"Telepon".equals(data_k[3]) &&
            data_k[4] != null  && !"Email".equals(data_k[4]) &&
            data_k[5] != null  && !"Password".equals(data_k[5]) &&
            data_k[6] != null  &&
            data_k[7] != null && !"Alamat".equals(data_k[7]) &&
            UTUserTanggalLahirInput.getDate() != null) {
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            String tmp_dte = fmt.format(this.UTUserTanggalLahirInput.getDate());

            UbahTambahDialogDetail.setText(
                "Username: "+data_k[0]+
                "\nPassword: "+data_k[5]+
                "\nNama Lengkap: "+data_k[1]+
                "\nEmail: "+data_k[4]+
                "\nTelepon: "+data_k[3]+
                "\nNik KTP: "+data_k[2]+
                "\nAlamat: "+data_k[7]+
                "\nJabatan: "+data_k[6]+
                "\nTanggal Lahir: "+tmp_dte
            );
            UbahTambahDialogYesNo.setVisible(true);
        } else {
           Master.showTholutDialogOk("Peringatan", "Data tidak boleh kosong!", "Warning"); 
        }
    }//GEN-LAST:event_UTUserButtonTambahMouseClicked

    private void UTUserHeaderPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UTUserHeaderPanelMousePressed
        // TODO add your handling code here:
        xxutuser = evt.getX();
        xyutuser = evt.getY();
    }//GEN-LAST:event_UTUserHeaderPanelMousePressed

    private void UTUserHeaderPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UTUserHeaderPanelMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        UbahTambahUserDialog.setLocation(x-xxutuser,y-xyutuser);
    }//GEN-LAST:event_UTUserHeaderPanelMouseDragged

    private void UTUserButtonTambahMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UTUserButtonTambahMouseEntered
        // TODO add your handling code here:
        UTUserButtonTambah.setBackground(ButtonColorEntered);
    }//GEN-LAST:event_UTUserButtonTambahMouseEntered

    private void UTUserButtonBatalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UTUserButtonBatalMouseEntered
        // TODO add your handling code here:
        UTUserButtonBatal.setBackground(ButtonColorEntered);
    }//GEN-LAST:event_UTUserButtonBatalMouseEntered

    private void UTUserButtonTambahMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UTUserButtonTambahMouseExited
        // TODO add your handling code here:
        UTUserButtonTambah.setBackground(ButtonColorExited);
    }//GEN-LAST:event_UTUserButtonTambahMouseExited

    private void UTUserButtonBatalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UTUserButtonBatalMouseExited
        // TODO add your handling code here:
        UTUserButtonBatal.setBackground(ButtonColorExited);
    }//GEN-LAST:event_UTUserButtonBatalMouseExited

    private void UbahTambahDialog_CloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UbahTambahDialog_CloseMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_UbahTambahDialog_CloseMouseClicked

    private void UbahTambahDialog_CloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UbahTambahDialog_CloseMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_UbahTambahDialog_CloseMouseEntered

    private void UbahTambahDialog_CloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UbahTambahDialog_CloseMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_UbahTambahDialog_CloseMouseExited

    private void UbahTambahDialogTidakButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UbahTambahDialogTidakButtonMouseClicked
        // TODO add your handling code here:
        UbahTambahDialogYesNo.setVisible(false);
    }//GEN-LAST:event_UbahTambahDialogTidakButtonMouseClicked

    private void UbahTambahDialogTidakButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UbahTambahDialogTidakButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_UbahTambahDialogTidakButtonMouseEntered

    private void UbahTambahDialogTidakButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UbahTambahDialogTidakButtonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_UbahTambahDialogTidakButtonMouseExited

    private void UbahTambahDialogYaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UbahTambahDialogYaButtonMouseClicked
        // TODO add your handling code here:
        String Type = UTUserButtonTambah.getText();
        String Type2 = UTKasetButtonTambah.getText();
        String data_user[] = {UTUserUsernameInput.getText(),UTUserNMLengkapInput.getText(),UTUserNikKtpInput.getText(),UTUserTeleponInput.getText(),UTUserEmailInput.getText(),UTUserPasswordInput.getText(),(String) UTUserJabatanInput.getSelectedItem(),UTUserAlamatInput.getText()};
        String data_kaset[] = {UTKasetKodeInput.getText(),UTKasetNamaInput.getText(),UTKasetJumlahKepingInput.getText(),UTKasetStokInput.getText(),UTKasetHargaInput.getText()};
        System.out.print(Type);
        System.out.print(TypeDialogYesNo);
        
        
        if ("Kaset".equals(TypeDialogYesNo)) {
            if ("Tambah".equals(Type2)) {
                try {
                    
                    int hasil = MySQL.MySQLUpdate("INSERT INTO `kaset` (`kaset_id`, `kaset_nama`, `kaset_jumlah_keping`, `kaset_kategori`, `kaset_stok`, `kaset_harga`) VALUES ('"+data_kaset[0]+"', '"+data_kaset[1]+"', '"+data_kaset[2]+"', '"+GetCheckboxKaset()+"', '"+data_kaset[3]+"', '"+data_kaset[4]+"')");
                    if (hasil == 1) {
                        System.out.println("data ter masukan");
                        Master.showTholutDialogOk("Success", "Data berhasil di tambahkan", "Success");
                        LoadTableData("Kaset","","");
                        UbahTambahKasetDialog.setVisible(false);
                    } else {
                        System.out.println("data gagal dimasukan");
                        Master.showTholutDialogOk("Failed", "Data gagal di tambahkan", "Failed");
                    }
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            } else if ("Ubah".equals(Type2)) {
                try {
                    
                   int hasil = MySQL.MySQLUpdate("UPDATE kaset SET kaset_nama = '"+data_kaset[1]+"',kaset_jumlah_keping = '"+data_kaset[2]+"',kaset_kategori = '"+GetCheckboxKaset()+"',kaset_stok = '"+data_kaset[3]+"' ,kaset_harga = '"+data_kaset[4]+"' WHERE kaset_id = '"+IdDialogYesNoString+"' ");
                    if (hasil == 1) {
                        System.out.println("data ter update");
                        Master.showTholutDialogOk("Success", "Data berhasil di ubah", "Success");
                        LoadTableData("Kaset","","");
                        UbahTambahKasetDialog.setVisible(false);
                    } else {
                        System.out.println("data gagal di update");
                        Master.showTholutDialogOk("Failed", "Data gagal di ubah", "Failed");
                    }
                    
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        } else if ("User".equals(TypeDialogYesNo)) {
            
            String jabatanwhat = (String) UTUserJabatanInput.getSelectedItem();
            String tmp_jbt = "";
            
            if (jabatanwhat == "Pemilik") {
                    tmp_jbt = "1";
                } else if (jabatanwhat == "Karyawan") {
                    tmp_jbt = "2";
                } else if (jabatanwhat == "Pelanggan") {
                    tmp_jbt = "3";
            }
            
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            String tmp_dte = fmt.format(this.UTUserTanggalLahirInput.getDate());
            
                
            if ("Tambah".equals(Type)) {
                try {
                    
                    java.sql.Timestamp date_today = new java.sql.Timestamp(new java.util.Date().getTime());

                    int hasil = MySQL.MySQLUpdate("INSERT into user(username,password,user_namalengkap,user_alamat,user_nik_ktp,user_telp,user_email,user_jabatan,user_tgl_lahir,user_tgl_masuk)values('"+data_user[0]+"','"+data_user[5]+"','"+data_user[1]+"','"+data_user[7]+"','"+data_user[2]+"','"+data_user[3]+"','"+data_user[4]+"', '"+tmp_jbt+"', '"+tmp_dte+"', '"+date_today+"')");
                    if (hasil == 1) {
                        System.out.println("data ter masukan");
                        Master.showTholutDialogOk("Success", "Data berhasil di tambahkan", "Success");
                        LoadTableData("User","","");
                        UbahTambahUserDialog.setVisible(false);
                    } else {
                        System.out.println("data gagal dimasukan");
                        Master.showTholutDialogOk("Failed", "Data gagal di tambahkan", "Failed");
                    }
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            } else if ("Ubah".equals(Type)) {
                try {
                    
                    int hasil = MySQL.MySQLUpdate("UPDATE user SET username = '"+data_user[0]+"', password = '"+data_user[5]+"',user_namalengkap = '"+data_user[1]+"',user_alamat = '"+data_user[7]+"',user_nik_ktp = '"+data_user[2]+"' ,user_telp = '"+data_user[3]+"',user_email = '"+data_user[4]+"',user_jabatan = '"+tmp_jbt+"',user_tgl_lahir = '"+tmp_dte+"' WHERE user_id = '"+IdDialogYesNo+"' ");
                    if (hasil == 1) {
                        System.out.println("data ter update");
                        Master.showTholutDialogOk("Success", "Data berhasil di ubah", "Success");
                        LoadTableData("User","","");
                        UbahTambahUserDialog.setVisible(false);
                    } else {
                        System.out.println("data gagal di update");
                        Master.showTholutDialogOk("Failed", "Data gagal di ubah", "Failed");
                    }
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        }
            
        UbahTambahDialogYesNo.setVisible(false);
    }//GEN-LAST:event_UbahTambahDialogYaButtonMouseClicked

    private void UbahTambahDialogYaButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UbahTambahDialogYaButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_UbahTambahDialogYaButtonMouseEntered

    private void UbahTambahDialogYaButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UbahTambahDialogYaButtonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_UbahTambahDialogYaButtonMouseExited

    private void DashboardMUserCariInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DashboardMUserCariInputKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER) {
            CariTableData("User");
        }
    }//GEN-LAST:event_DashboardMUserCariInputKeyPressed

    private void DashboardMKasetCariInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DashboardMKasetCariInputKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER) {
            CariTableData("Kaset");
        }
    }//GEN-LAST:event_DashboardMKasetCariInputKeyPressed

    private void UTKasetButtonCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UTKasetButtonCloseMouseClicked
        // TODO add your handling code here:
        UbahTambahKasetDialog.setVisible(false);
    }//GEN-LAST:event_UTKasetButtonCloseMouseClicked

    private void UTKasetButtonCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UTKasetButtonCloseMouseEntered
        // TODO add your handling code here:
        UTKasetButtonClose.setBackground(new java.awt.Color(240, 71, 71));
    }//GEN-LAST:event_UTKasetButtonCloseMouseEntered

    private void UTKasetButtonCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UTKasetButtonCloseMouseExited
        // TODO add your handling code here:
        UTKasetButtonClose.setBackground(new java.awt.Color(32,34,37));
    }//GEN-LAST:event_UTKasetButtonCloseMouseExited

    private void UTKasetButtonBatalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UTKasetButtonBatalMouseClicked
        // TODO add your handling code here:
        UbahTambahKasetDialog.setVisible(false);
    }//GEN-LAST:event_UTKasetButtonBatalMouseClicked

    private void UTKasetButtonBatalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UTKasetButtonBatalMouseEntered
        // TODO add your handling code here:
        UTKasetButtonBatal.setBackground(ButtonColorEntered);
    }//GEN-LAST:event_UTKasetButtonBatalMouseEntered

    private void UTKasetButtonBatalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UTKasetButtonBatalMouseExited
        // TODO add your handling code here:
        UTKasetButtonBatal.setBackground(ButtonColorExited);
    }//GEN-LAST:event_UTKasetButtonBatalMouseExited

    private void UTKasetButtonTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UTKasetButtonTambahMouseClicked
        // TODO add your handling code here:
        String data_k[] = {UTKasetKodeInput.getText(),UTKasetNamaInput.getText(),UTKasetJumlahKepingInput.getText(),UTKasetStokInput.getText(),UTKasetHargaInput.getText()};
        if (data_k[0] != null && !"Kode".equals(data_k[0]) &&
            data_k[1] != null  && !"Nama".equals(data_k[1]) &&
            data_k[2] != null  && !"Jumlah Keping".equals(data_k[2]) &&
            data_k[3] != null  && !"Stok".equals(data_k[3]) &&
            data_k[4] != null  && !"Harga".equals(data_k[4]) &&
                !"".equals(GetCheckboxKaset())) {
            
            UbahTambahDialogDetail.setText(
                "Kode: "+data_k[0]+
                "\nNama\\Judul: "+data_k[1]+
                "\nJumlah Keping: "+data_k[2]+
                "\nStok: "+data_k[3]+
                "\nHarga: "+data_k[4]+
                "\nKategori: "+GetCheckboxKaset()
            );
            UbahTambahDialogYesNo.setVisible(true);
        } else {
           Master.showTholutDialogOk("Peringatan", "Data tidak boleh kosong!", "Warning"); 
        }
    }//GEN-LAST:event_UTKasetButtonTambahMouseClicked

    private void UTKasetButtonTambahMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UTKasetButtonTambahMouseEntered
        // TODO add your handling code here:
        UTKasetButtonTambah.setBackground(ButtonColorEntered);
    }//GEN-LAST:event_UTKasetButtonTambahMouseEntered

    private void UTKasetButtonTambahMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UTKasetButtonTambahMouseExited
        // TODO add your handling code here:
        UTKasetButtonTambah.setBackground(ButtonColorExited);
    }//GEN-LAST:event_UTKasetButtonTambahMouseExited

    private void UTKasetNamaInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UTKasetNamaInputFocusGained
        // TODO add your handling code here:
        UTKasetNamaInputLine.setBackground(new java.awt.Color(255,255,255));
        if ("Nama".equals(UTKasetNamaInput.getText())) {
            UTKasetNamaInput.setText("");
            UTKasetNamaInputTitle.setText("Nama");
        }
    }//GEN-LAST:event_UTKasetNamaInputFocusGained

    private void UTKasetNamaInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UTKasetNamaInputFocusLost
        // TODO add your handling code here:
        UTKasetNamaInputLine.setBackground(new java.awt.Color(35, 39, 42));
        if ("".equals(UTKasetNamaInput.getText())) {
            UTKasetNamaInput.setText("Nama");
            UTKasetNamaInputTitle.setText(" ");
        }
    }//GEN-LAST:event_UTKasetNamaInputFocusLost

    private void UTKasetJumlahKepingInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UTKasetJumlahKepingInputFocusGained
        // TODO add your handling code here:
        UTKasetJumlahKepingInputLine.setBackground(new java.awt.Color(255,255,255));
        if ("Jumlah Keping".equals(UTKasetJumlahKepingInput.getText())) {
            UTKasetJumlahKepingInput.setText("");
            UTKasetJumlahKepingInputTitle.setText("Jumlah Keping");
        }
    }//GEN-LAST:event_UTKasetJumlahKepingInputFocusGained

    private void UTKasetJumlahKepingInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UTKasetJumlahKepingInputFocusLost
        // TODO add your handling code here:
        UTKasetJumlahKepingInputLine.setBackground(new java.awt.Color(35, 39, 42));
        if ("".equals(UTKasetJumlahKepingInput.getText())) {
            UTKasetJumlahKepingInput.setText("Jumlah Keping");
            UTKasetJumlahKepingInputTitle.setText(" ");
        }
    }//GEN-LAST:event_UTKasetJumlahKepingInputFocusLost

    private void UTKasetStokInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UTKasetStokInputFocusGained
        // TODO add your handling code here:
        UTKasetStokInputLine.setBackground(new java.awt.Color(255,255,255));
        if ("Stok".equals(UTKasetStokInput.getText())) {
            UTKasetStokInput.setText("");
            UTKasetStokInputTitle.setText("Stok");
        }
    }//GEN-LAST:event_UTKasetStokInputFocusGained

    private void UTKasetStokInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UTKasetStokInputFocusLost
        // TODO add your handling code here:
        UTKasetStokInputLine.setBackground(new java.awt.Color(35, 39, 42));
        if ("".equals(UTKasetStokInput.getText())) {
            UTKasetStokInput.setText("Stok");
            UTKasetStokInputTitle.setText(" ");
        }
    }//GEN-LAST:event_UTKasetStokInputFocusLost

    private void UTKasetHargaInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UTKasetHargaInputFocusGained
        // TODO add your handling code here:
        UTKasetHargaInputLine.setBackground(new java.awt.Color(255,255,255));
        if ("Harga".equals(UTKasetHargaInput.getText())) {
            UTKasetHargaInput.setText("");
            UTKasetHargaInputTitle.setText("Harga");
        }
    }//GEN-LAST:event_UTKasetHargaInputFocusGained

    private void UTKasetHargaInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UTKasetHargaInputFocusLost
        // TODO add your handling code here:
        UTKasetHargaInputLine.setBackground(new java.awt.Color(35, 39, 42));
        if ("".equals(UTKasetHargaInput.getText())) {
            UTKasetHargaInput.setText("Harga");
            UTKasetHargaInputTitle.setText(" ");
        }
    }//GEN-LAST:event_UTKasetHargaInputFocusLost

    private void UTKasetKodeInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UTKasetKodeInputFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_UTKasetKodeInputFocusGained

    private void UTKasetKodeInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UTKasetKodeInputFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_UTKasetKodeInputFocusLost

    private void UTKasetHeaderPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UTKasetHeaderPanelMousePressed
        // TODO add your handling code here:
        xxutkaset = evt.getX();
        xyutkaset = evt.getY();
    }//GEN-LAST:event_UTKasetHeaderPanelMousePressed

    private void UTKasetHeaderPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UTKasetHeaderPanelMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        UbahTambahKasetDialog.setLocation(x-xxutkaset,y-xyutkaset);
    }//GEN-LAST:event_UTKasetHeaderPanelMouseDragged

    private void DashboardPengaturanButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardPengaturanButtonMouseClicked
        try {
            SettingLoadUser();
        } catch (ParseException ex) {
            Logger.getLogger(DashboardFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_DashboardPengaturanButtonMouseClicked

    private void DashboardPengaturanButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardPengaturanButtonMouseEntered
        // TODO add your handling code here:
        DashboardPengaturanButton.setBackground(ButtonColorEntered);
    }//GEN-LAST:event_DashboardPengaturanButtonMouseEntered

    private void DashboardPengaturanButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardPengaturanButtonMouseExited
        // TODO add your handling code here:
        DashboardPengaturanButton.setBackground(ButtonColorExited);
    }//GEN-LAST:event_DashboardPengaturanButtonMouseExited

    private void PengaturanButtonCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanButtonCloseMouseClicked
        // TODO add your handling code here:
        PengaturanFrame.setVisible(false);
    }//GEN-LAST:event_PengaturanButtonCloseMouseClicked

    private void PengaturanButtonCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanButtonCloseMouseEntered
        // TODO add your handling code here:
        PengaturanButtonClose.setBackground(new java.awt.Color(240, 71, 71));
    }//GEN-LAST:event_PengaturanButtonCloseMouseEntered

    private void PengaturanButtonCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanButtonCloseMouseExited
        // TODO add your handling code here:
        PengaturanButtonClose.setBackground(new java.awt.Color(32,34,37));
    }//GEN-LAST:event_PengaturanButtonCloseMouseExited

    private void PengaturanButtonBatalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanButtonBatalMouseClicked
        // TODO add your handling code here:
        PengaturanFrame.setVisible(false);
    }//GEN-LAST:event_PengaturanButtonBatalMouseClicked

    private void PengaturanButtonBatalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanButtonBatalMouseEntered
        // TODO add your handling code here:
        PengaturanButtonBatal.setBackground(ButtonColorEntered);
    }//GEN-LAST:event_PengaturanButtonBatalMouseEntered

    private void PengaturanButtonBatalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanButtonBatalMouseExited
        // TODO add your handling code here:
        PengaturanButtonBatal.setBackground(ButtonColorExited);
    }//GEN-LAST:event_PengaturanButtonBatalMouseExited

    private void PengaturanButtonSimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanButtonSimpanMouseClicked
        try {
            // TODO add your handling code here:
            SettingSaveUser();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PengaturanButtonSimpanMouseClicked

    private void PengaturanButtonSimpanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanButtonSimpanMouseEntered
        // TODO add your handling code here:
        PengaturanButtonSimpan.setBackground(ButtonColorEntered);
    }//GEN-LAST:event_PengaturanButtonSimpanMouseEntered

    private void PengaturanButtonSimpanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanButtonSimpanMouseExited
        // TODO add your handling code here:
        PengaturanButtonSimpan.setBackground(ButtonColorExited);
    }//GEN-LAST:event_PengaturanButtonSimpanMouseExited

    private void PengaturanHeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanHeaderMousePressed
        // TODO add your handling code here:
        xxpengaturan = evt.getX();
        xypengaturan = evt.getY();
    }//GEN-LAST:event_PengaturanHeaderMousePressed

    private void PengaturanHeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanHeaderMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        PengaturanFrame.setLocation(x-xxpengaturan,y-xypengaturan);
    }//GEN-LAST:event_PengaturanHeaderMouseDragged

    private void PengaturanUsernameInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PengaturanUsernameInputFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanUsernameInputFocusGained

    private void PengaturanUsernameInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PengaturanUsernameInputFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanUsernameInputFocusLost

    private void PengaturanPasswordInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PengaturanPasswordInputFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanPasswordInputFocusGained

    private void PengaturanPasswordInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PengaturanPasswordInputFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanPasswordInputFocusLost

    private void PengaturanAlamatInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PengaturanAlamatInputFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanAlamatInputFocusGained

    private void PengaturanAlamatInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PengaturanAlamatInputFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanAlamatInputFocusLost

    private void PengaturanNMLengkapInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PengaturanNMLengkapInputFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanNMLengkapInputFocusGained

    private void PengaturanNMLengkapInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PengaturanNMLengkapInputFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanNMLengkapInputFocusLost

    private void PengaturanEmailInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PengaturanEmailInputFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanEmailInputFocusGained

    private void PengaturanEmailInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PengaturanEmailInputFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanEmailInputFocusLost

    private void PengaturanTeleponInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PengaturanTeleponInputFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanTeleponInputFocusGained

    private void PengaturanTeleponInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PengaturanTeleponInputFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanTeleponInputFocusLost

    private void PengaturanNikKtpInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PengaturanNikKtpInputFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanNikKtpInputFocusGained

    private void PengaturanNikKtpInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PengaturanNikKtpInputFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanNikKtpInputFocusLost

    private void PengaturanYesNo_CloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNo_CloseMouseClicked
        // TODO add your handling code here:
        PengaturanYesNo.setVisible(false);
    }//GEN-LAST:event_PengaturanYesNo_CloseMouseClicked

    private void PengaturanYesNo_CloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNo_CloseMouseEntered
        // TODO add your handling code here:
        PengaturanYesNo_Close.setBackground(new java.awt.Color(240, 71, 71));
    }//GEN-LAST:event_PengaturanYesNo_CloseMouseEntered

    private void PengaturanYesNo_CloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNo_CloseMouseExited
        // TODO add your handling code here:
        PengaturanYesNo_Close.setBackground(new java.awt.Color(32,34,37));
    }//GEN-LAST:event_PengaturanYesNo_CloseMouseExited

    private void PengaturanYesNoTidakButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNoTidakButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanYesNoTidakButtonMouseClicked

    private void PengaturanYesNoTidakButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNoTidakButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanYesNoTidakButtonMouseEntered

    private void PengaturanYesNoTidakButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNoTidakButtonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanYesNoTidakButtonMouseExited

    private void PengaturanYesNoYaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNoYaButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanYesNoYaButtonMouseClicked

    private void PengaturanYesNoYaButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNoYaButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanYesNoYaButtonMouseEntered

    private void PengaturanYesNoYaButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNoYaButtonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanYesNoYaButtonMouseExited

    private void DashboardMKasetCariButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMKasetCariButton1MouseClicked
        // TODO add your handling code here:
        CariTableData("Sewa");
    }//GEN-LAST:event_DashboardMKasetCariButton1MouseClicked

    private void DashboardMKasetCariButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMKasetCariButton1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboardMKasetCariButton1MouseEntered

    private void DashboardMKasetCariButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMKasetCariButton1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboardMKasetCariButton1MouseExited

    private void DashboardMKasetCariInput1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DashboardMKasetCariInput1FocusGained
        // TODO add your handling code here:
        DashboardMKasetCariInputLine1.setBackground(new java.awt.Color(255,255,255));
        if ("Pencarian".equals(DashboardMKasetCariInput1.getText())) {
            DashboardMKasetCariInput1.setText("");
        }
    }//GEN-LAST:event_DashboardMKasetCariInput1FocusGained

    private void DashboardMKasetCariInput1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DashboardMKasetCariInput1FocusLost
        // TODO add your handling code here:
        DashboardMKasetCariInputLine1.setBackground(new java.awt.Color(35, 39, 42));
        if ("".equals(DashboardMKasetCariInput1.getText())) {
            DashboardMKasetCariInput1.setText("Pencarian");
        }
    }//GEN-LAST:event_DashboardMKasetCariInput1FocusLost

    private void DashboardMKasetCariInput1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DashboardMKasetCariInput1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER) {
            CariTableData("Sewa");
        }
    }//GEN-LAST:event_DashboardMKasetCariInput1KeyPressed

    private void DashboardMKasetTambahButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMKasetTambahButton1MouseClicked
        // TODO add your handling code here:
        TransaksiBaruKuy();
    }//GEN-LAST:event_DashboardMKasetTambahButton1MouseClicked

    private void DashboardMKasetTambahButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMKasetTambahButton1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboardMKasetTambahButton1MouseEntered

    private void DashboardMKasetTambahButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMKasetTambahButton1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboardMKasetTambahButton1MouseExited

    private void DashboardMKasetUbahButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMKasetUbahButton1MouseClicked
        // TODO add your handling code here:
        int Row_ID = DashboardSewaTable.getSelectedRow();
        String Master_ID =(DashboardSewaTable.getModel().getValueAt(Row_ID, 0).toString());
        try {
            BukaTransaksiDetil(Master_ID);
        } catch (ParseException ex) {
            Logger.getLogger(DashboardFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_DashboardMKasetUbahButton1MouseClicked

    private void DashboardMKasetUbahButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMKasetUbahButton1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboardMKasetUbahButton1MouseEntered

    private void DashboardMKasetUbahButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMKasetUbahButton1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboardMKasetUbahButton1MouseExited

    private void DashboardMKasetSegarkanButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMKasetSegarkanButton1MouseClicked
        // TODO add your handling code here:
        LoadTableData("Sewa","","");
    }//GEN-LAST:event_DashboardMKasetSegarkanButton1MouseClicked

    private void DashboardMKasetSegarkanButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMKasetSegarkanButton1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboardMKasetSegarkanButton1MouseEntered

    private void DashboardMKasetSegarkanButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMKasetSegarkanButton1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboardMKasetSegarkanButton1MouseExited

    private void PengaturanYesNo_Close7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNo_Close7MouseClicked
        // TODO add your handling code here:
        TransaksiBukaFrame.setVisible(false);
    }//GEN-LAST:event_PengaturanYesNo_Close7MouseClicked

    private void PengaturanYesNo_Close7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNo_Close7MouseEntered
        // TODO add your handling code here:
        PengaturanYesNo_Close7.setBackground(new java.awt.Color(240, 71, 71));
    }//GEN-LAST:event_PengaturanYesNo_Close7MouseEntered

    private void PengaturanYesNo_Close7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNo_Close7MouseExited
        // TODO add your handling code here:
        PengaturanYesNo_Close7.setBackground(new java.awt.Color(32,34,37));
    }//GEN-LAST:event_PengaturanYesNo_Close7MouseExited

    private void PengaturanYesNo_Close8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNo_Close8MouseClicked
        // TODO add your handling code here:
        BatalTransaksi();
        TransaksiBaruFrame.setVisible(false);
    }//GEN-LAST:event_PengaturanYesNo_Close8MouseClicked

    private void PengaturanYesNo_Close8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNo_Close8MouseEntered
        // TODO add your handling code here:
        PengaturanYesNo_Close8.setBackground(new java.awt.Color(240, 71, 71));
    }//GEN-LAST:event_PengaturanYesNo_Close8MouseEntered

    private void PengaturanYesNo_Close8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNo_Close8MouseExited
        // TODO add your handling code here:
        PengaturanYesNo_Close8.setBackground(new java.awt.Color(32,34,37));
    }//GEN-LAST:event_PengaturanYesNo_Close8MouseExited

    private void DashboardMUserTambahButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton1MouseClicked
        // TODO add your handling code here:
        System.out.println("menghitung");
        if (!"User Id: 0".equals(TBFUserId1.getText())) {
            if (!"Total: Rp 0".equals(TBFTransaksiId2.getText())) {
                SewaProcessAwal.setVisible(false);
                SewaProcessKedua.setVisible(true);
                SewaProcessAkhir.setVisible(false);
                
                jDateChooser1.setMinSelectableDate(new java.util.Date());
            } else {
                Master.showTholutDialogOk("Gagal", "Harus meminjam 1 kaset", "Failed");
            }
        } else {
            Master.showTholutDialogOk("Gagal", "Belum memilih peminjam", "Failed");
        }
    }//GEN-LAST:event_DashboardMUserTambahButton1MouseClicked

    private void DashboardMUserTambahButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboardMUserTambahButton1MouseEntered

    private void DashboardMUserTambahButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboardMUserTambahButton1MouseExited

    private void DashboardMUserTambahButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton2MouseClicked
        // TODO add your handling code here:
        transaksiYesNoselect = "Reset";
        PengaturanYesNo_Message1.setText("Apakah Anda Ingin Mereset?");
        TransaksiYesNo.setVisible(true);
    }//GEN-LAST:event_DashboardMUserTambahButton2MouseClicked

    private void DashboardMUserTambahButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboardMUserTambahButton2MouseEntered

    private void DashboardMUserTambahButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboardMUserTambahButton2MouseExited

    private void DashboardMUserTambahButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton3MouseClicked
        // TODO add your handling code here:
        transaksiYesNoselect = "Hapus";
        PengaturanYesNo_Message1.setText("Apakah Anda Ingin Menghapus?");
        TransaksiYesNo.setVisible(true);
    }//GEN-LAST:event_DashboardMUserTambahButton3MouseClicked

    private void DashboardMUserTambahButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboardMUserTambahButton3MouseEntered

    private void DashboardMUserTambahButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboardMUserTambahButton3MouseExited

    private void DashboardMUserTambahButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton4MouseClicked
        // TODO add your handling code here:
        transaksiYesNoselect = "Batal";
        PengaturanYesNo_Message1.setText("Apakah Anda Ingin Membatalkan Transaksi?");
        TransaksiYesNo.setVisible(true);
        //BatalTransaksi();
    }//GEN-LAST:event_DashboardMUserTambahButton4MouseClicked

    private void DashboardMUserTambahButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboardMUserTambahButton4MouseEntered

    private void DashboardMUserTambahButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboardMUserTambahButton4MouseExited

    private void DashboardMUserTambahButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton5MouseClicked
        // TODO add your handling code here:
        System.out.println("cari user");
        LoadTableData("CariUser","","");
        TransaksiCariUserFrame.setVisible(true);
    }//GEN-LAST:event_DashboardMUserTambahButton5MouseClicked

    private void DashboardMUserTambahButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboardMUserTambahButton5MouseEntered

    private void DashboardMUserTambahButton5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboardMUserTambahButton5MouseExited

    private void DashboardMUserTambahButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton6MouseClicked
        // TODO add your handling code here:
        System.out.println("cari kaset");
        LoadTableData("CariKaset","","");
        TransaksiCariKasetFrame.setVisible(true);
    }//GEN-LAST:event_DashboardMUserTambahButton6MouseClicked

    private void DashboardMUserTambahButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboardMUserTambahButton6MouseEntered

    private void DashboardMUserTambahButton6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton6MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboardMUserTambahButton6MouseExited

    private void DashboardMUserTambahButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton7MouseClicked
        // TODO add your handling code here:
        System.out.println("tambahkan ke list barang");
        
        try {
            
            DashboardResultSet = MySQL.MySQLQuery("SELECT COUNT(*) AS 'Jumlah' FROM transaksi_detil, transaksi WHERE transaksi.ts_status_kembali = '0' and transaksi_detil.ts_id = transaksi.ts_id and transaksi_detil.kaset_id = '"+selectedKasetKode+"'");
            if (DashboardResultSet.next()) {
                System.out.println("Jumlah Kaset Keluar "+DashboardResultSet.getString("Jumlah"));
                int counting = Integer.parseInt(selectedKasetStok) - Integer.parseInt(DashboardResultSet.getString("Jumlah"));
                
                if (counting >= 1) {
                    int hasil = MySQL.MySQLUpdate("INSERT into transaksi_detil(ts_id,kaset_id, ts_detil_harga, ts_detil_jumlah)values('"+baruTransaksi+"','"+selectedKasetKode+"', '"+selectedKasetHarga+"' ,'1')");
                    if (hasil == 1) {
                        System.out.println("data ter masukan");
                        Master.showTholutDialogOk("Success", "Data berhasil di tambahkan", "Success");
                        LoadTableData("User","","");
                        UbahTambahUserDialog.setVisible(false);
                    } else {
                        System.out.println("data gagal dimasukan");
                        Master.showTholutDialogOk("Failed", "Data gagal di tambahkan", "Failed");
                    }
                } else {
                    Master.showTholutDialogOk("Peringatan", "Maaf stok habis", "Warning");
                }
            }
                    
            String data_sql[][] = MySQL.MySQLGetDetilSewa(baruTransaksi);
            
            while (DTM_SewaBaruTransaksi.getRowCount() > 0) {
                DTM_SewaBaruTransaksi.removeRow(0);
            }

            int xd = 0;
            int Total = 0;
            
            while (xd < data_sql.length) {
                String data_detill[][] = MySQL.MySQLGetKaset(data_sql[xd][2], "SewaKaset");
                int TotalHarga = Integer.parseInt(data_detill[0][5])*Integer.parseInt(data_sql[xd][3]);
                DTM_SewaBaruTransaksi.addRow(new Object[]{data_sql[xd][0], data_sql[xd][2],data_detill[0][1],data_detill[0][5],data_sql[xd][3],TotalHarga});
                Total = Total + TotalHarga;
                xd++;
            }
            
            TBFTransaksiId2.setText("Total: Rp "+Total);
            TBFTransaksiId3.setText("Total: Rp "+Total);
            jTextField1.setText(""+Total);
            jTextField3.setText(""+Total);
        } catch (SQLException ex) {
                System.out.println(ex);
        }
    }//GEN-LAST:event_DashboardMUserTambahButton7MouseClicked

    private void DashboardMUserTambahButton7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton7MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboardMUserTambahButton7MouseEntered

    private void DashboardMUserTambahButton7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton7MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboardMUserTambahButton7MouseExited

    private void PengaturanYesNo_Close9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNo_Close9MouseClicked
        // TODO add your handling code here:
        TransaksiCariUserFrame.setVisible(false);
    }//GEN-LAST:event_PengaturanYesNo_Close9MouseClicked

    private void PengaturanYesNo_Close9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNo_Close9MouseEntered
        // TODO add your handling code here:
        PengaturanYesNo_Close9.setBackground(new java.awt.Color(240, 71, 71));
    }//GEN-LAST:event_PengaturanYesNo_Close9MouseEntered

    private void PengaturanYesNo_Close9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNo_Close9MouseExited
        // TODO add your handling code here:
        PengaturanYesNo_Close9.setBackground(new java.awt.Color(32,34,37));
    }//GEN-LAST:event_PengaturanYesNo_Close9MouseExited

    private void PengaturanUsernameInput1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PengaturanUsernameInput1FocusGained
        // TODO add your handling code here:
        PengaturanUsernameInputLine1.setBackground(new java.awt.Color(255,255,255));
        if ("Pencarian".equals(PengaturanUsernameInput1.getText())) {
            PengaturanUsernameInput1.setText("");
        }
    }//GEN-LAST:event_PengaturanUsernameInput1FocusGained

    private void PengaturanUsernameInput1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PengaturanUsernameInput1FocusLost
        // TODO add your handling code here:
        PengaturanUsernameInputLine1.setBackground(new java.awt.Color(35, 39, 42));
        if ("".equals(PengaturanUsernameInput1.getText())) {
            PengaturanUsernameInput1.setText("Pencarian");
        }
    }//GEN-LAST:event_PengaturanUsernameInput1FocusLost

    private void PengaturanButtonBatal1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanButtonBatal1MouseClicked
        // TODO add your handling code here:
        CariTableData("CariUser");
    }//GEN-LAST:event_PengaturanButtonBatal1MouseClicked

    private void PengaturanButtonBatal1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanButtonBatal1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanButtonBatal1MouseEntered

    private void PengaturanButtonBatal1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanButtonBatal1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanButtonBatal1MouseExited

    private void PengaturanButtonBatal2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanButtonBatal2MouseClicked
        // TODO add your handling code here:
        TransaksiCariUserFrame.setVisible(false);
    }//GEN-LAST:event_PengaturanButtonBatal2MouseClicked

    private void PengaturanButtonBatal2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanButtonBatal2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanButtonBatal2MouseEntered

    private void PengaturanButtonBatal2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanButtonBatal2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanButtonBatal2MouseExited

    private void PengaturanButtonBatal3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanButtonBatal3MouseClicked
        // TODO add your handling code here:
        int Row_ID = TCUserTable.getSelectedRow();
        String Master_ID =(TCUserTable.getModel().getValueAt(Row_ID, 0).toString());

        try {
            String[][] data_sql = MySQL.MySQLGetUser(String.valueOf(Master_ID), "User Id", "Pemilik");
            
            int hasil = MySQL.MySQLUpdate("UPDATE transaksi SET pelanggan_id='"+data_sql[0][0]+"' where ts_id='"+baruTransaksi+"'");
            selectedUserId = data_sql[0][0];
            TBFUserId1.setText("User Id: "+data_sql[0][0]);
            TBFNama2.setText("Nama: "+data_sql[0][3]);
            TBFTglPeminjaman1.setText("Alamat: "+data_sql[0][4]);
            TBFTglPengembalian1.setText("Nik Ktp: "+data_sql[0][5]);
               
            TransaksiCariUserFrame.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(DashboardFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PengaturanButtonBatal3MouseClicked

    private void PengaturanButtonBatal3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanButtonBatal3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanButtonBatal3MouseEntered

    private void PengaturanButtonBatal3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanButtonBatal3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanButtonBatal3MouseExited

    private void PengaturanYesNo_Close10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNo_Close10MouseClicked
        // TODO add your handling code here:
        TransaksiCariKasetFrame.setVisible(false);
    }//GEN-LAST:event_PengaturanYesNo_Close10MouseClicked

    private void PengaturanYesNo_Close10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNo_Close10MouseEntered
        // TODO add your handling code here:
        PengaturanYesNo_Close10.setBackground(new java.awt.Color(240, 71, 71));
    }//GEN-LAST:event_PengaturanYesNo_Close10MouseEntered

    private void PengaturanYesNo_Close10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNo_Close10MouseExited
        // TODO add your handling code here:
        PengaturanYesNo_Close10.setBackground(new java.awt.Color(32,34,37));
    }//GEN-LAST:event_PengaturanYesNo_Close10MouseExited

    private void PengaturanUsernameInput2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PengaturanUsernameInput2FocusGained
        // TODO add your handling code here:
        PengaturanUsernameInputLine2.setBackground(new java.awt.Color(255,255,255));
        if ("Pencarian".equals(PengaturanUsernameInput2.getText())) {
            PengaturanUsernameInput2.setText("");
        }
    }//GEN-LAST:event_PengaturanUsernameInput2FocusGained

    private void PengaturanUsernameInput2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PengaturanUsernameInput2FocusLost
        // TODO add your handling code here:
        PengaturanUsernameInputLine2.setBackground(new java.awt.Color(35, 39, 42));
        if ("".equals(PengaturanUsernameInput2.getText())) {
            PengaturanUsernameInput2.setText("Pencarian");
        }
    }//GEN-LAST:event_PengaturanUsernameInput2FocusLost

    private void PengaturanButtonBatal4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanButtonBatal4MouseClicked
        // TODO add your handling code here:
        CariTableData("CariKaset");
    }//GEN-LAST:event_PengaturanButtonBatal4MouseClicked

    private void PengaturanButtonBatal4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanButtonBatal4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanButtonBatal4MouseEntered

    private void PengaturanButtonBatal4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanButtonBatal4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanButtonBatal4MouseExited

    private void PengaturanButtonBatal5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanButtonBatal5MouseClicked
        // TODO add your handling code here:
        TransaksiCariKasetFrame.setVisible(false);
    }//GEN-LAST:event_PengaturanButtonBatal5MouseClicked

    private void PengaturanButtonBatal5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanButtonBatal5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanButtonBatal5MouseEntered

    private void PengaturanButtonBatal5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanButtonBatal5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanButtonBatal5MouseExited

    private void PengaturanButtonBatal6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanButtonBatal6MouseClicked
        // TODO add your handling code here:
        int Row_ID = TCUserTable1.getSelectedRow();
        String Master_ID =(TCUserTable1.getModel().getValueAt(Row_ID, 0).toString());

        try {
            String[][] data_sql = MySQL.MySQLGetKaset(String.valueOf(Master_ID), "Kode");
            
            DashboardResultSet = MySQL.MySQLQuery("SELECT COUNT(*) AS 'Jumlah' FROM transaksi_detil, transaksi WHERE transaksi.ts_status_kembali = '0' and transaksi_detil.ts_id = transaksi.ts_id and transaksi_detil.kaset_id = '"+data_sql[0][0]+"'");
            if (DashboardResultSet.next()) {
                System.out.println("Jumlah Kaset Keluar "+DashboardResultSet.getString("Jumlah").toString());
                int counting = Integer.parseInt(data_sql[0][4]) - Integer.parseInt(DashboardResultSet.getString("Jumlah"));
                
                if (counting >= 1) {
                    selectedKasetKode = data_sql[0][0];
                    selectedKasetStok = data_sql[0][4];
                    selectedKasetHarga = data_sql[0][5];
                    TBFUserId2.setText("Kaset Id: "+data_sql[0][0]);
                    TBFNama4.setText("Judul: "+data_sql[0][1]);
                    TBFTglPeminjaman2.setText("Jumlah Keping: "+data_sql[0][2]);
                    TBFTglPengembalian2.setText("Harga: "+data_sql[0][5]);

                    TransaksiCariKasetFrame.setVisible(false);
                } else {
                    Master.showTholutDialogOk("Peringatan", "Maaf stok habis", "Warning");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DashboardFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PengaturanButtonBatal6MouseClicked

    private void PengaturanButtonBatal6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanButtonBatal6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanButtonBatal6MouseEntered

    private void PengaturanButtonBatal6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanButtonBatal6MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanButtonBatal6MouseExited

    private void DashboardMUserTambahButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton8MouseClicked
        // TODO add your handling code here:
        SewaProcessAwal.setVisible(true);
        SewaProcessKedua.setVisible(false);
        SewaProcessAkhir.setVisible(false);
    }//GEN-LAST:event_DashboardMUserTambahButton8MouseClicked

    private void DashboardMUserTambahButton8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton8MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboardMUserTambahButton8MouseEntered

    private void DashboardMUserTambahButton8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton8MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboardMUserTambahButton8MouseExited

    private void DashboardMUserTambahButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton9MouseClicked
        // TODO add your handling code here:
        transaksiYesNoselect = "Checkout";
        PengaturanYesNo_Message1.setText("Apakah anda ingin melakukan transaksi?");
        TransaksiYesNo.setVisible(true);
    }//GEN-LAST:event_DashboardMUserTambahButton9MouseClicked

    private void DashboardMUserTambahButton9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton9MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboardMUserTambahButton9MouseEntered

    private void DashboardMUserTambahButton9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton9MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboardMUserTambahButton9MouseExited

    private void DashboardMUserTambahButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton11MouseClicked
        // TODO add your handling code here:
        transaksiYesNoselect = "Batal";
        PengaturanYesNo_Message1.setText("Apakah Anda Ingin Membatalkan Transaksi?");
        TransaksiYesNo.setVisible(true);
    }//GEN-LAST:event_DashboardMUserTambahButton11MouseClicked

    private void DashboardMUserTambahButton11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton11MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboardMUserTambahButton11MouseEntered

    private void DashboardMUserTambahButton11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton11MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboardMUserTambahButton11MouseExited

    private void DashboardMUserTambahButton13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton13MouseClicked
        // TODO add your handling code here:
        TransaksiBaruFrame.setVisible(false);
        SewaProcessAwal.setVisible(true);
        SewaProcessKedua.setVisible(false);
        SewaProcessAkhir.setVisible(false);
        TransaksiInputReset();
    }//GEN-LAST:event_DashboardMUserTambahButton13MouseClicked

    private void DashboardMUserTambahButton13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton13MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboardMUserTambahButton13MouseEntered

    private void DashboardMUserTambahButton13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton13MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboardMUserTambahButton13MouseExited

    private void DashboardMUserTambahButton10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton10MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboardMUserTambahButton10MouseExited

    private void DashboardMUserTambahButton10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton10MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboardMUserTambahButton10MouseEntered

    private void DashboardMUserTambahButton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton10MouseClicked
        // TODO add your handling code here:
        TransaksiBaruFrame.setVisible(true);
        SewaProcessAwal.setVisible(true);
        SewaProcessKedua.setVisible(false);
        SewaProcessAkhir.setVisible(false);
        TransaksiInputReset();
        TransaksiBaruKuy();
    }//GEN-LAST:event_DashboardMUserTambahButton10MouseClicked

    private void DashboardMUserTambahButton14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton14MouseClicked
        // TODO add your handling code here:
        //LoadingCetak.setVisible(true);
        CetakTransaksiNota();
    }//GEN-LAST:event_DashboardMUserTambahButton14MouseClicked

    private void DashboardMUserTambahButton14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton14MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboardMUserTambahButton14MouseEntered

    private void DashboardMUserTambahButton14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMUserTambahButton14MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboardMUserTambahButton14MouseExited
    
    private void jDateChooser2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser2PropertyChange
        // TODO add your handling code here:
        LaporanAinx();
    }//GEN-LAST:event_jDateChooser2PropertyChange

    private void jDateChooser3PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser3PropertyChange
        // TODO add your handling code here:
        LaporanAinx();
    }//GEN-LAST:event_jDateChooser3PropertyChange

    private void PengaturanButtonBatal7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanButtonBatal7MouseClicked
        // TODO add your handling code here:
        CetakFromViewNota();
    }//GEN-LAST:event_PengaturanButtonBatal7MouseClicked

    private void PengaturanButtonBatal7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanButtonBatal7MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanButtonBatal7MouseEntered

    private void PengaturanButtonBatal7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanButtonBatal7MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanButtonBatal7MouseExited

    private void PengaturanButtonBatal8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanButtonBatal8MouseClicked
        // TODO add your handling code here:
        if ("Mengembalikan".equals(PengaturanButtonBatal8.getText())) {
            TransaksiYesNo.setVisible(true);
            PengaturanYesNo_Message1.setText("Apakah pelanggan ini mengembalikan?");
            transaksiYesNoselect = "Mengembalikan";
        }
    }//GEN-LAST:event_PengaturanButtonBatal8MouseClicked

    private void PengaturanButtonBatal8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanButtonBatal8MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanButtonBatal8MouseEntered

    private void PengaturanButtonBatal8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanButtonBatal8MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanButtonBatal8MouseExited

    private void DashboardMKasetCariButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMKasetCariButton3MouseClicked
        // TODO add your handling code here:
        //LoadingCetak.setVisible(true);
        CetakLaporan();
    }//GEN-LAST:event_DashboardMKasetCariButton3MouseClicked

    private void PengaturanYesNoHeader10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNoHeader10MousePressed
        // TODO add your handling code here:
        xxtransaksicarikaset = evt.getX();
        xytransaksicarikaset = evt.getY();
    }//GEN-LAST:event_PengaturanYesNoHeader10MousePressed

    private void PengaturanYesNoHeader10MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNoHeader10MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        TransaksiCariKasetFrame.setLocation(x-xxtransaksicarikaset,y-xytransaksicarikaset);
    }//GEN-LAST:event_PengaturanYesNoHeader10MouseDragged

    private void PengaturanYesNoHeader9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNoHeader9MousePressed
        // TODO add your handling code here:
        xxtransaksicariuser = evt.getX();
        xytransaksicariuser = evt.getY();
    }//GEN-LAST:event_PengaturanYesNoHeader9MousePressed

    private void PengaturanYesNoHeader9MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNoHeader9MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        TransaksiCariUserFrame.setLocation(x-xxtransaksicariuser,y-xytransaksicariuser);
    }//GEN-LAST:event_PengaturanYesNoHeader9MouseDragged

    private void PengaturanYesNoHeader8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNoHeader8MousePressed
        // TODO add your handling code here:
        xxtransaksibaru = evt.getX();
        xytransaksibaru = evt.getY();
    }//GEN-LAST:event_PengaturanYesNoHeader8MousePressed

    private void PengaturanYesNoHeader8MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNoHeader8MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        TransaksiBaruFrame.setLocation(x-xxtransaksibaru,y-xytransaksibaru);
    }//GEN-LAST:event_PengaturanYesNoHeader8MouseDragged

    private void PengaturanYesNoHeader7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNoHeader7MousePressed
        // TODO add your handling code here:
        xxtransaksibaru = evt.getX();
        xytransaksibaru = evt.getY();
    }//GEN-LAST:event_PengaturanYesNoHeader7MousePressed

    private void PengaturanYesNoHeader7MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNoHeader7MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        TransaksiBukaFrame.setLocation(x-xxtransaksibaru,y-xytransaksibaru);
    }//GEN-LAST:event_PengaturanYesNoHeader7MouseDragged

    private void UTKasetJumlahKepingInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UTKasetJumlahKepingInputKeyTyped
        // TODO add your handling code here:
        char whatis = evt.getKeyChar();
        if(!(Character.isDigit(whatis) || (whatis == KeyEvent.VK_BACK_SPACE) || (whatis == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
    }//GEN-LAST:event_UTKasetJumlahKepingInputKeyTyped

    private void UTKasetStokInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UTKasetStokInputKeyTyped
        // TODO add your handling code here:
        char whatis = evt.getKeyChar();
        if(!(Character.isDigit(whatis) || (whatis == KeyEvent.VK_BACK_SPACE) || (whatis == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
    }//GEN-LAST:event_UTKasetStokInputKeyTyped

    private void UTKasetHargaInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UTKasetHargaInputKeyTyped
        // TODO add your handling code here:
        char whatis = evt.getKeyChar();
        if(!(Character.isDigit(whatis) || (whatis == KeyEvent.VK_BACK_SPACE) || (whatis == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
    }//GEN-LAST:event_UTKasetHargaInputKeyTyped

    private void UTUserNikKtpInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UTUserNikKtpInputKeyTyped
        // TODO add your handling code here:
        char whatis = evt.getKeyChar();
        if(!(Character.isDigit(whatis) || (whatis == KeyEvent.VK_BACK_SPACE) || (whatis == KeyEvent.VK_DELETE)) || UTUserNikKtpInput.getText().trim().length()==9) {
            evt.consume();
        }
    }//GEN-LAST:event_UTUserNikKtpInputKeyTyped

    private void UTUserTeleponInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UTUserTeleponInputKeyTyped
        // TODO add your handling code here:
        char whatis = evt.getKeyChar();
        if(!(Character.isDigit(whatis) || (whatis == KeyEvent.VK_BACK_SPACE) || (whatis == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
    }//GEN-LAST:event_UTUserTeleponInputKeyTyped

    private void PengaturanNikKtpInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PengaturanNikKtpInputKeyTyped
        // TODO add your handling code here:
        char whatis = evt.getKeyChar();
        if(!(Character.isDigit(whatis) || (whatis == KeyEvent.VK_BACK_SPACE) || (whatis == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
    }//GEN-LAST:event_PengaturanNikKtpInputKeyTyped

    private void PengaturanTeleponInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PengaturanTeleponInputKeyTyped
        // TODO add your handling code here:
        char whatis = evt.getKeyChar();
        if(!(Character.isDigit(whatis) || (whatis == KeyEvent.VK_BACK_SPACE) || (whatis == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
    }//GEN-LAST:event_PengaturanTeleponInputKeyTyped

    private void PengaturanNMLengkapInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PengaturanNMLengkapInputKeyTyped
        // TODO add your handling code here:
        char whatis = evt.getKeyChar();
        if(!(Character.isLetter(whatis) || (whatis == KeyEvent.VK_SPACE) || (whatis == KeyEvent.VK_BACK_SPACE) || (whatis == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
    }//GEN-LAST:event_PengaturanNMLengkapInputKeyTyped

    private void UTKasetNamaInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UTKasetNamaInputKeyTyped
        // TODO add your handling code here:
        char whatis = evt.getKeyChar();
        if(!(Character.isLetter(whatis) || (whatis == KeyEvent.VK_SPACE) || (whatis == KeyEvent.VK_BACK_SPACE) || (whatis == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
    }//GEN-LAST:event_UTKasetNamaInputKeyTyped

    private void UTUserNMLengkapInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UTUserNMLengkapInputKeyTyped
        // TODO add your handling code here:
        char whatis = evt.getKeyChar();
        if(!(Character.isLetter(whatis) || (whatis == KeyEvent.VK_SPACE) || (whatis == KeyEvent.VK_BACK_SPACE) || (whatis == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
    }//GEN-LAST:event_UTUserNMLengkapInputKeyTyped

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        // TODO add your handling code here:
        char whatis = evt.getKeyChar();
        if(!(Character.isDigit(whatis) || (whatis == KeyEvent.VK_BACK_SPACE) || (whatis == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField4KeyTyped

    private void PengaturanYesNo_Close1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNo_Close1MouseClicked
        // TODO add your handling code here:
        TransaksiYesNo.setVisible(false);
    }//GEN-LAST:event_PengaturanYesNo_Close1MouseClicked

    private void PengaturanYesNo_Close1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNo_Close1MouseEntered
        // TODO add your handling code here:
        PengaturanYesNo_Close1.setBackground(new java.awt.Color(240, 71, 71));
    }//GEN-LAST:event_PengaturanYesNo_Close1MouseEntered

    private void PengaturanYesNo_Close1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNo_Close1MouseExited
        // TODO add your handling code here:
        PengaturanYesNo_Close1.setBackground(new java.awt.Color(32,34,37));
    }//GEN-LAST:event_PengaturanYesNo_Close1MouseExited

    private void PengaturanYesNoTidakButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNoTidakButton1MouseClicked
        // TODO add your handling code here:
        TransaksiYesNo.setVisible(false);
    }//GEN-LAST:event_PengaturanYesNoTidakButton1MouseClicked

    private void PengaturanYesNoTidakButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNoTidakButton1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanYesNoTidakButton1MouseEntered

    private void PengaturanYesNoTidakButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNoTidakButton1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanYesNoTidakButton1MouseExited

    private void PengaturanYesNoYaButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNoYaButton1MouseClicked
        // TODO add your handling code here:
        TransaksiYesNoFunct(transaksiYesNoselect);
        TransaksiYesNo.setVisible(false);
    }//GEN-LAST:event_PengaturanYesNoYaButton1MouseClicked

    private void PengaturanYesNoYaButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNoYaButton1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanYesNoYaButton1MouseEntered

    private void PengaturanYesNoYaButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNoYaButton1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanYesNoYaButton1MouseExited

    private void PengaturanYesNo_Close2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNo_Close2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanYesNo_Close2MouseClicked

    private void PengaturanYesNo_Close2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNo_Close2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanYesNo_Close2MouseEntered

    private void PengaturanYesNo_Close2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PengaturanYesNo_Close2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_PengaturanYesNo_Close2MouseExited

    private void PengaturanUsernameInput1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PengaturanUsernameInput1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER) {
            CariTableData("CariUser");
        }
    }//GEN-LAST:event_PengaturanUsernameInput1KeyPressed

    private void PengaturanUsernameInput2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PengaturanUsernameInput2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER) {
            CariTableData("CariKaset");
        }
    }//GEN-LAST:event_PengaturanUsernameInput2KeyPressed
        
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DashboardBerandaButton;
    private javax.swing.JLabel DashboardClose;
    private javax.swing.JPanel DashboardContent;
    private javax.swing.JPanel DashboardContentBeranda;
    private javax.swing.JLabel DashboardContentBerandaTitle;
    private javax.swing.JLabel DashboardContentBerandaTitle1;
    private javax.swing.JPanel DashboardContentLaporan;
    private javax.swing.JLabel DashboardContentLaporanTitle;
    private javax.swing.JLabel DashboardContentLaporanTitle1;
    private javax.swing.JLabel DashboardContentLaporanTitle2;
    private javax.swing.JLabel DashboardContentLaporanTitle3;
    private javax.swing.JLabel DashboardContentLaporanTitle4;
    private javax.swing.JPanel DashboardContentMKaset;
    private javax.swing.JLabel DashboardContentMKasetTitle;
    private javax.swing.JPanel DashboardContentMUser;
    private javax.swing.JLabel DashboardContentMUserTitle;
    private javax.swing.JPanel DashboardContentSewa;
    private javax.swing.JLabel DashboardContentSewaTitle;
    private javax.swing.JScrollPane DashboardDetilSewaScrollPanel;
    private javax.swing.JScrollPane DashboardDetilSewaScrollPanel1;
    private javax.swing.JScrollPane DashboardDetilSewaScrollPanel2;
    private javax.swing.JScrollPane DashboardDetilSewaScrollPanel3;
    private javax.swing.JTable DashboardDetilSewaTable;
    private javax.swing.JTable DashboardDetilSewaTable1;
    private javax.swing.JTable DashboardDetilSewaTable2;
    private javax.swing.JTable DashboardDetilSewaTable3;
    private javax.swing.JPanel DashboardHeader;
    private javax.swing.JPanel DashboardHeaderDrag;
    private javax.swing.JLabel DashboardKeluarButton;
    private javax.swing.JLabel DashboardLaporanButton;
    private javax.swing.JLabel DashboardLoginUsername;
    private javax.swing.JLabel DashboardMKasetButton;
    private javax.swing.JLabel DashboardMKasetCariButton;
    private javax.swing.JLabel DashboardMKasetCariButton1;
    private javax.swing.JLabel DashboardMKasetCariButton3;
    private javax.swing.JTextField DashboardMKasetCariInput;
    private javax.swing.JTextField DashboardMKasetCariInput1;
    private javax.swing.JPanel DashboardMKasetCariInputLine;
    private javax.swing.JPanel DashboardMKasetCariInputLine1;
    private javax.swing.JLabel DashboardMKasetHapusButton;
    private javax.swing.JComboBox<String> DashboardMKasetJenis;
    private javax.swing.JComboBox<String> DashboardMKasetJenis1;
    private javax.swing.JScrollPane DashboardMKasetScrollPanel;
    private javax.swing.JScrollPane DashboardMKasetScrollPanel1;
    private javax.swing.JScrollPane DashboardMKasetScrollPanel2;
    private javax.swing.JLabel DashboardMKasetSegarkanButton;
    private javax.swing.JLabel DashboardMKasetSegarkanButton1;
    private javax.swing.JTable DashboardMKasetTable;
    private javax.swing.JLabel DashboardMKasetTambahButton;
    private javax.swing.JLabel DashboardMKasetTambahButton1;
    private javax.swing.JLabel DashboardMKasetUbahButton;
    private javax.swing.JLabel DashboardMKasetUbahButton1;
    private javax.swing.JLabel DashboardMUserButton;
    private javax.swing.JLabel DashboardMUserCariButton;
    private javax.swing.JTextField DashboardMUserCariInput;
    private javax.swing.JPanel DashboardMUserCariInputLine;
    private javax.swing.JLabel DashboardMUserHapusButton;
    private javax.swing.JComboBox<String> DashboardMUserJenis;
    private javax.swing.JComboBox<String> DashboardMUserJenis1;
    private javax.swing.JComboBox<String> DashboardMUserJenis2;
    private javax.swing.JScrollPane DashboardMUserScrollPanel;
    private javax.swing.JScrollPane DashboardMUserScrollPanel1;
    private javax.swing.JScrollPane DashboardMUserScrollPanel2;
    private javax.swing.JLabel DashboardMUserSegarkanButton;
    private javax.swing.JTable DashboardMUserTable;
    private javax.swing.JLabel DashboardMUserTambahButton;
    private javax.swing.JLabel DashboardMUserTambahButton1;
    private javax.swing.JLabel DashboardMUserTambahButton10;
    private javax.swing.JLabel DashboardMUserTambahButton11;
    private javax.swing.JLabel DashboardMUserTambahButton13;
    private javax.swing.JLabel DashboardMUserTambahButton14;
    private javax.swing.JLabel DashboardMUserTambahButton2;
    private javax.swing.JLabel DashboardMUserTambahButton3;
    private javax.swing.JLabel DashboardMUserTambahButton4;
    private javax.swing.JLabel DashboardMUserTambahButton5;
    private javax.swing.JLabel DashboardMUserTambahButton6;
    private javax.swing.JLabel DashboardMUserTambahButton7;
    private javax.swing.JLabel DashboardMUserTambahButton8;
    private javax.swing.JLabel DashboardMUserTambahButton9;
    private javax.swing.JLabel DashboardMUserUbahButton;
    private javax.swing.JPanel DashboardMainPanel;
    private javax.swing.JLabel DashboardMinimize;
    private javax.swing.JLabel DashboardPengaturanButton;
    private javax.swing.JLabel DashboardSewaButton;
    private javax.swing.JTable DashboardSewaTable;
    private javax.swing.JTable DashboardSewaTable1;
    private javax.swing.JLabel DashboardTitle;
    private javax.swing.JPanel DeleteDialogHeader;
    private javax.swing.JPanel DeleteDialogMainPanel;
    private javax.swing.JFrame DeleteDialogYesNo;
    private javax.swing.JTextArea DialogDeleteDetail;
    private javax.swing.JScrollPane DialogDeleteScrollPanel;
    private javax.swing.JLabel DialogDeleteTidakButton;
    private javax.swing.JLabel DialogDeleteYaButton;
    private javax.swing.JLabel DialogDelete_Close;
    private javax.swing.JLabel DialogDelete_Icon;
    private javax.swing.JLabel DialogDelete_Message;
    private javax.swing.JLabel DialogDelete_Title;
    private javax.swing.JFrame LoadingCetak;
    private javax.swing.JTextField PengaturanAlamatInput;
    private javax.swing.JPanel PengaturanAlamatInputLine;
    private javax.swing.JLabel PengaturanAlamatInputTitle;
    private javax.swing.JLabel PengaturanButtonBatal;
    private javax.swing.JLabel PengaturanButtonBatal1;
    private javax.swing.JLabel PengaturanButtonBatal2;
    private javax.swing.JLabel PengaturanButtonBatal3;
    private javax.swing.JLabel PengaturanButtonBatal4;
    private javax.swing.JLabel PengaturanButtonBatal5;
    private javax.swing.JLabel PengaturanButtonBatal6;
    private javax.swing.JLabel PengaturanButtonBatal7;
    private javax.swing.JLabel PengaturanButtonBatal8;
    private javax.swing.JLabel PengaturanButtonClose;
    private javax.swing.JLabel PengaturanButtonSimpan;
    private javax.swing.JTextField PengaturanEmailInput;
    private javax.swing.JPanel PengaturanEmailInputLine;
    private javax.swing.JLabel PengaturanEmailInputTitle;
    private javax.swing.JFrame PengaturanFrame;
    private javax.swing.JPanel PengaturanHeader;
    private javax.swing.JLabel PengaturanHeaderTitle;
    private javax.swing.JPanel PengaturanMainPanel;
    private javax.swing.JTextField PengaturanNMLengkapInput;
    private javax.swing.JPanel PengaturanNMLengkapInputLine;
    private javax.swing.JLabel PengaturanNMLengkapInputTitle;
    private javax.swing.JTextField PengaturanNikKtpInput;
    private javax.swing.JPanel PengaturanNikKtpInputLine;
    private javax.swing.JLabel PengaturanNikKtpInputTitle;
    private javax.swing.JTextField PengaturanPasswordInput;
    private javax.swing.JPanel PengaturanPasswordInputLine;
    private javax.swing.JLabel PengaturanPasswordInputTitle;
    private com.toedter.calendar.JDateChooser PengaturanTanggalLahirInput;
    private javax.swing.JLabel PengaturanTanggalLahirInputLine;
    private javax.swing.JTextField PengaturanTeleponInput;
    private javax.swing.JPanel PengaturanTeleponInputLine;
    private javax.swing.JLabel PengaturanTeleponInputTitle;
    private javax.swing.JTextField PengaturanUsernameInput;
    private javax.swing.JTextField PengaturanUsernameInput1;
    private javax.swing.JTextField PengaturanUsernameInput2;
    private javax.swing.JPanel PengaturanUsernameInputLine;
    private javax.swing.JPanel PengaturanUsernameInputLine1;
    private javax.swing.JPanel PengaturanUsernameInputLine2;
    private javax.swing.JLabel PengaturanUsernameInputTitle;
    private javax.swing.JFrame PengaturanYesNo;
    private javax.swing.JPanel PengaturanYesNoHeader;
    private javax.swing.JPanel PengaturanYesNoHeader1;
    private javax.swing.JPanel PengaturanYesNoHeader10;
    private javax.swing.JPanel PengaturanYesNoHeader2;
    private javax.swing.JPanel PengaturanYesNoHeader7;
    private javax.swing.JPanel PengaturanYesNoHeader8;
    private javax.swing.JPanel PengaturanYesNoHeader9;
    private javax.swing.JPanel PengaturanYesNoMainPanel;
    private javax.swing.JPanel PengaturanYesNoMainPanel1;
    private javax.swing.JPanel PengaturanYesNoMainPanel2;
    private javax.swing.JLabel PengaturanYesNoTidakButton;
    private javax.swing.JLabel PengaturanYesNoTidakButton1;
    private javax.swing.JLabel PengaturanYesNoYaButton;
    private javax.swing.JLabel PengaturanYesNoYaButton1;
    private javax.swing.JLabel PengaturanYesNo_Close;
    private javax.swing.JLabel PengaturanYesNo_Close1;
    private javax.swing.JLabel PengaturanYesNo_Close10;
    private javax.swing.JLabel PengaturanYesNo_Close2;
    private javax.swing.JLabel PengaturanYesNo_Close7;
    private javax.swing.JLabel PengaturanYesNo_Close8;
    private javax.swing.JLabel PengaturanYesNo_Close9;
    private javax.swing.JLabel PengaturanYesNo_Icon;
    private javax.swing.JLabel PengaturanYesNo_Icon1;
    private javax.swing.JLabel PengaturanYesNo_Message;
    private javax.swing.JLabel PengaturanYesNo_Message1;
    private javax.swing.JLabel PengaturanYesNo_Message2;
    private javax.swing.JLabel PengaturanYesNo_Title;
    private javax.swing.JLabel PengaturanYesNo_Title1;
    private javax.swing.JLabel PengaturanYesNo_Title10;
    private javax.swing.JLabel PengaturanYesNo_Title2;
    private javax.swing.JLabel PengaturanYesNo_Title7;
    private javax.swing.JLabel PengaturanYesNo_Title8;
    private javax.swing.JLabel PengaturanYesNo_Title9;
    private javax.swing.JPanel SewaProcessAkhir;
    private javax.swing.JPanel SewaProcessAwal;
    private javax.swing.JPanel SewaProcessKedua;
    private javax.swing.JLabel TBFNama;
    private javax.swing.JLabel TBFNama1;
    private javax.swing.JLabel TBFNama2;
    private javax.swing.JLabel TBFNama3;
    private javax.swing.JLabel TBFNama4;
    private javax.swing.JLabel TBFNama5;
    private javax.swing.JLabel TBFNama6;
    private javax.swing.JLabel TBFNama7;
    private javax.swing.JLabel TBFNama8;
    private javax.swing.JLabel TBFTglPeminjaman;
    private javax.swing.JLabel TBFTglPeminjaman1;
    private javax.swing.JLabel TBFTglPeminjaman2;
    private javax.swing.JLabel TBFTglPeminjaman3;
    private javax.swing.JLabel TBFTglPeminjaman4;
    private javax.swing.JLabel TBFTglPeminjaman5;
    private javax.swing.JLabel TBFTglPengembalian;
    private javax.swing.JLabel TBFTglPengembalian1;
    private javax.swing.JLabel TBFTglPengembalian2;
    private javax.swing.JLabel TBFTglPengembalian3;
    private javax.swing.JLabel TBFTglPengembalian4;
    private javax.swing.JLabel TBFTglPengembalian5;
    private javax.swing.JLabel TBFTglPengembalian6;
    private javax.swing.JLabel TBFTglPengembalian7;
    private javax.swing.JLabel TBFTransaksiId;
    private javax.swing.JLabel TBFTransaksiId1;
    private javax.swing.JLabel TBFTransaksiId10;
    private javax.swing.JLabel TBFTransaksiId11;
    private javax.swing.JLabel TBFTransaksiId12;
    private javax.swing.JLabel TBFTransaksiId13;
    private javax.swing.JLabel TBFTransaksiId14;
    private javax.swing.JLabel TBFTransaksiId15;
    private javax.swing.JLabel TBFTransaksiId16;
    private javax.swing.JLabel TBFTransaksiId17;
    private javax.swing.JLabel TBFTransaksiId18;
    private javax.swing.JLabel TBFTransaksiId19;
    private javax.swing.JLabel TBFTransaksiId2;
    private javax.swing.JLabel TBFTransaksiId20;
    private javax.swing.JLabel TBFTransaksiId21;
    private javax.swing.JLabel TBFTransaksiId22;
    private javax.swing.JLabel TBFTransaksiId23;
    private javax.swing.JLabel TBFTransaksiId24;
    private javax.swing.JLabel TBFTransaksiId25;
    private javax.swing.JLabel TBFTransaksiId26;
    private javax.swing.JLabel TBFTransaksiId27;
    private javax.swing.JLabel TBFTransaksiId28;
    private javax.swing.JLabel TBFTransaksiId29;
    private javax.swing.JLabel TBFTransaksiId3;
    private javax.swing.JLabel TBFTransaksiId30;
    private javax.swing.JLabel TBFTransaksiId31;
    private javax.swing.JLabel TBFTransaksiId32;
    private javax.swing.JLabel TBFTransaksiId33;
    private javax.swing.JLabel TBFTransaksiId34;
    private javax.swing.JLabel TBFTransaksiId35;
    private javax.swing.JLabel TBFTransaksiId36;
    private javax.swing.JLabel TBFTransaksiId4;
    private javax.swing.JLabel TBFTransaksiId5;
    private javax.swing.JLabel TBFTransaksiId6;
    private javax.swing.JLabel TBFTransaksiId7;
    private javax.swing.JLabel TBFTransaksiId8;
    private javax.swing.JLabel TBFTransaksiId9;
    private javax.swing.JLabel TBFUserId;
    private javax.swing.JLabel TBFUserId1;
    private javax.swing.JLabel TBFUserId10;
    private javax.swing.JLabel TBFUserId11;
    private javax.swing.JLabel TBFUserId12;
    private javax.swing.JLabel TBFUserId13;
    private javax.swing.JLabel TBFUserId14;
    private javax.swing.JLabel TBFUserId15;
    private javax.swing.JLabel TBFUserId2;
    private javax.swing.JLabel TBFUserId3;
    private javax.swing.JLabel TBFUserId4;
    private javax.swing.JLabel TBFUserId5;
    private javax.swing.JLabel TBFUserId6;
    private javax.swing.JLabel TBFUserId7;
    private javax.swing.JLabel TBFUserId8;
    private javax.swing.JLabel TBFUserId9;
    private javax.swing.JTable TCUserTable;
    private javax.swing.JTable TCUserTable1;
    private javax.swing.JPanel TransaksiBaruContent;
    private javax.swing.JFrame TransaksiBaruFrame;
    private javax.swing.JFrame TransaksiBukaFrame;
    private javax.swing.JFrame TransaksiCariKasetFrame;
    private javax.swing.JFrame TransaksiCariUserFrame;
    private javax.swing.JFrame TransaksiYesNo;
    private javax.swing.JLabel UTKasetButtonBatal;
    private javax.swing.JLabel UTKasetButtonClose;
    private javax.swing.JLabel UTKasetButtonTambah;
    private javax.swing.JTextField UTKasetHargaInput;
    private javax.swing.JPanel UTKasetHargaInputLine;
    private javax.swing.JLabel UTKasetHargaInputTitle;
    private javax.swing.JPanel UTKasetHeaderPanel;
    private javax.swing.JLabel UTKasetHeaderTitle;
    private javax.swing.JTextField UTKasetJumlahKepingInput;
    private javax.swing.JPanel UTKasetJumlahKepingInputLine;
    private javax.swing.JLabel UTKasetJumlahKepingInputTitle;
    private javax.swing.JLabel UTKasetKategoriInputTitle;
    private javax.swing.JTextField UTKasetKodeInput;
    private javax.swing.JPanel UTKasetKodeInputLine;
    private javax.swing.JLabel UTKasetKodeInputTitle;
    private javax.swing.JPanel UTKasetMainPanel;
    private javax.swing.JTextField UTKasetNamaInput;
    private javax.swing.JPanel UTKasetNamaInputLine;
    private javax.swing.JLabel UTKasetNamaInputTitle;
    private javax.swing.JTextField UTKasetStokInput;
    private javax.swing.JPanel UTKasetStokInputLine;
    private javax.swing.JLabel UTKasetStokInputTitle;
    private javax.swing.JLabel UTKasetTitle;
    private javax.swing.JTextField UTUserAlamatInput;
    private javax.swing.JPanel UTUserAlamatInputLine;
    private javax.swing.JLabel UTUserAlamatInputTitle;
    private javax.swing.JLabel UTUserButtonBatal;
    private javax.swing.JLabel UTUserButtonClose;
    private javax.swing.JLabel UTUserButtonTambah;
    private javax.swing.JTextField UTUserEmailInput;
    private javax.swing.JPanel UTUserEmailInputLine;
    private javax.swing.JLabel UTUserEmailInputTitle;
    private javax.swing.JPanel UTUserHeaderPanel;
    private javax.swing.JLabel UTUserHeaderTitle;
    private javax.swing.JComboBox<String> UTUserJabatanInput;
    private javax.swing.JLabel UTUserJabatanTitle;
    private javax.swing.JPanel UTUserMainPanel;
    private javax.swing.JTextField UTUserNMLengkapInput;
    private javax.swing.JPanel UTUserNMLengkapInputLine;
    private javax.swing.JLabel UTUserNMLengkapInputTitle;
    private javax.swing.JTextField UTUserNikKtpInput;
    private javax.swing.JPanel UTUserNikKtpInputLine;
    private javax.swing.JLabel UTUserNikKtpInputTitle;
    private javax.swing.JTextField UTUserPasswordInput;
    private javax.swing.JPanel UTUserPasswordInputLine;
    private javax.swing.JLabel UTUserPasswordInputTitle;
    private com.toedter.calendar.JDateChooser UTUserTanggalLahirInput;
    private javax.swing.JLabel UTUserTanggalLahirTitle;
    private javax.swing.JTextField UTUserTeleponInput;
    private javax.swing.JPanel UTUserTeleponInputLine;
    private javax.swing.JLabel UTUserTeleponInputTitle;
    private javax.swing.JLabel UTUserTitle;
    private javax.swing.JTextField UTUserUsernameInput;
    private javax.swing.JPanel UTUserUsernameInputLine;
    private javax.swing.JLabel UTUserUsernameInputTitle;
    private javax.swing.JTextArea UbahTambahDialogDetail;
    private javax.swing.JPanel UbahTambahDialogHeader;
    private javax.swing.JPanel UbahTambahDialogMainPanel;
    private javax.swing.JScrollPane UbahTambahDialogScrollPanel;
    private javax.swing.JLabel UbahTambahDialogTidakButton;
    private javax.swing.JLabel UbahTambahDialogYaButton;
    private javax.swing.JFrame UbahTambahDialogYesNo;
    private javax.swing.JLabel UbahTambahDialog_Close;
    private javax.swing.JLabel UbahTambahDialog_Icon;
    private javax.swing.JLabel UbahTambahDialog_Message;
    private javax.swing.JLabel UbahTambahDialog_Title;
    private javax.swing.JFrame UbahTambahKasetDialog;
    private javax.swing.JFrame UbahTambahUserDialog;
    private javax.swing.JCheckBox adventure_c;
    private javax.swing.JCheckBox classic_c;
    private javax.swing.JCheckBox fight_c;
    private javax.swing.JCheckBox horror_c;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JCheckBox puzzle_c;
    private javax.swing.JCheckBox racing_c;
    private javax.swing.JCheckBox rpg_c;
    private javax.swing.JCheckBox scifi_c;
    private javax.swing.JCheckBox sport_c;
    // End of variables declaration//GEN-END:variables
}