package View;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Controller.Controller;
import Model.DonHang;
import Model.KhoHang;
import Model.ThietBi;
import javax.swing.DefaultComboBoxModel;

public class NhanVien extends JFrame {

	private JPanel contentPane;
	public static JTable table_1;
	private JTextField tenHang;
	private JTextField soLuong;
	private JTextField giaTien;
	public static JTable table_2;
	public static JTable table_3;
	private JTextField maTB;
	private JTextField tenTB;
	private JTextField ngayNhap;
	private JTextField tinhTrang;
	private JTextField xuatXu;
	public static JTable table_4;
	private JTextField maHang;
	KhoHang hangHoa;
	Controller controller;
	List<DonHang> list;
	DefaultTableModel tableModel;
	double tien;
	private JTable table_5;
	DonHang donHang;
	public static JTable table;
	private JTextField thoiGianBH;
	ThietBi thietBi;
	private JTextField maTBSua;
	JLabel tc;
	JLabel tt;
	private JTextField loaiHang;
	public static JComboBox comboBox;
	List<String> listLoaiHang;

	public NhanVien() {
		setTitle("Nhân viên");
		initialize();
		hangHoa = new KhoHang();
		controller = new Controller();
		list = new ArrayList<DonHang>();
		donHang = new DonHang();
		thietBi = new ThietBi();
		listLoaiHang = new ArrayList<String>();
		listLoaiHang.removeAll(listLoaiHang);
		listLoaiHang = controller.getDataIntoComboBox();
		if (comboBox.getItemCount() != 0)
			comboBox.removeAllItems();
		for (String i : listLoaiHang) {
			comboBox.addItem(i);
		}
	}

	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(10, 11, 734, 39);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Qu\u1EA3n l\u00ED b\u00E1n h\u00E0ng");

		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 128, 17);
		panel.add(lblNewLabel);

		JLabel lblQunLDoanh = new JLabel("Qu\u1EA3n l\u00ED doanh thu");

		lblQunLDoanh.setFont(new Font("Arial", Font.BOLD, 14));
		lblQunLDoanh.setBounds(177, 11, 128, 17);
		panel.add(lblQunLDoanh);

		JLabel lblQunLThit = new JLabel("Qu\u1EA3n l\u00ED thi\u1EBFt b\u1ECB");

		lblQunLThit.setFont(new Font("Arial", Font.BOLD, 14));
		lblQunLThit.setBounds(346, 11, 128, 17);
		panel.add(lblQunLThit);

		JLabel lblNewLabel_2 = new JLabel("Home");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login.nv.dispose();
				Login.home.setVisible(true);
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\ASUS\\Desktop\\full\\New folder\\Home-icon.png"));
		lblNewLabel_2.setBounds(647, 6, 77, 26);
		panel.add(lblNewLabel_2);

		JLayeredPane NhanVien = new JLayeredPane();
		NhanVien.setBounds(10, 61, 734, 392);
		contentPane.add(NhanVien);
		NhanVien.setLayout(new CardLayout(0, 0));

		JPanel QuanLiBanHang = new JPanel();
		NhanVien.add(QuanLiBanHang, "name_328644693241600");
		QuanLiBanHang.setLayout(null);

		JButton btnNewButton_1 = new JButton("B\u00E1n h\u00E0ng");
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 14));

		btnNewButton_1.setBounds(27, 6, 105, 33);
		QuanLiBanHang.add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("Nh\u1EADp h\u00E0ng");
		btnNewButton_1_1.setFont(new Font("Arial", Font.BOLD, 14));

		btnNewButton_1_1.setBounds(142, 6, 113, 33);
		QuanLiBanHang.add(btnNewButton_1_1);

		JButton btnNewButton_1_2 = new JButton("Ki\u1EC3m tra");
		btnNewButton_1_2.setFont(new Font("Arial", Font.BOLD, 14));

		btnNewButton_1_2.setBounds(265, 7, 105, 31);
		QuanLiBanHang.add(btnNewButton_1_2);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 48, 714, 333);
		QuanLiBanHang.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));

		JPanel BH = new JPanel();
		layeredPane.add(BH, "name_328725665404400");
		BH.setLayout(null);

		JLabel lblLoiHng = new JLabel("Lo\u1EA1i h\u00E0ng");
		lblLoiHng.setFont(new Font("Arial", Font.BOLD, 14));
		lblLoiHng.setBounds(31, 14, 81, 27);
		BH.add(lblLoiHng);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "" }));
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					if (comboBox.getItemCount() != 0)
						controller.loadSanPham(comboBox.getSelectedItem().toString());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		comboBox.setBounds(112, 17, 137, 22);
		BH.add(comboBox);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(21, 52, 295, 270);
		BH.add(scrollPane_1);

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "T\u00EAn h\u00E0ng", "Gi\u00E1 ti\u1EC1n" }));
		scrollPane_1.setViewportView(table_1);

		JButton btnDel = new JButton("X");
		btnDel.setEnabled(false);
		btnDel.setFont(new Font("Arial", Font.BOLD, 14));

		btnDel.setBounds(345, 152, 50, 43);
		BH.add(btnDel);

		JButton btnTT = new JButton("TT");
		btnTT.setEnabled(false);
		btnTT.setFont(new Font("Arial", Font.BOLD, 14));
		btnTT.setBounds(345, 216, 50, 43);
		BH.add(btnTT);

		JLabel lblTngTin = new JLabel("T\u1ED5ng ti\u1EC1n: ");
		lblTngTin.setFont(new Font("Arial", Font.BOLD, 14));
		lblTngTin.setBounds(419, 309, 81, 17);
		BH.add(lblTngTin);

		JLabel lblnHng = new JLabel("\u0110\u01A1n h\u00E0ng");
		lblnHng.setFont(new Font("Arial", Font.BOLD, 14));
		lblnHng.setBounds(534, 24, 81, 17);
		BH.add(lblnHng);

		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(419, 52, 285, 246);
		BH.add(scrollPane_5);

		table_5 = new JTable();
		table_5.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "STT", "M\u00E3 h\u00E0ng",
				"T\u00EAn h\u00E0ng", "S\u1ED1 l\u01B0\u1EE3ng", "Gi\u00E1 ti\u1EC1n" }) {
			Class[] columnTypes = new Class[] { Integer.class, String.class, String.class, Integer.class,
					Double.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_5.setViewportView(table_5);

		JLabel tongCong = new JLabel("");
		tongCong.setForeground(Color.RED);
		tongCong.setFont(new Font("Arial", Font.BOLD, 14));
		tongCong.setBounds(498, 309, 81, 17);
		BH.add(tongCong);

		JButton btnAdd = new JButton(">");
		btnAdd.setEnabled(false);
		btnAdd.setFont(new Font("Arial", Font.BOLD, 14));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadDonHang();
				tongCong.setText(Double.toString(tongTien()));
				btnAdd.setEnabled(false);
				btnTT.setEnabled(true);
			}
		});
		btnAdd.setBounds(345, 87, 50, 43);
		BH.add(btnAdd);

		JPanel NH = new JPanel();
		layeredPane.add(NH, "name_328897294683400");
		NH.setLayout(null);

		JLabel lblTn = new JLabel("Tên hàng");
		lblTn.setFont(new Font("Arial", Font.BOLD, 14));
		lblTn.setBounds(10, 63, 76, 17);
		NH.add(lblTn);

		JLabel lblSLng = new JLabel("S\u1ED1 l\u01B0\u1EE3ng");
		lblSLng.setFont(new Font("Arial", Font.BOLD, 14));
		lblSLng.setBounds(10, 91, 76, 17);
		NH.add(lblSLng);

		JLabel lblLoi = new JLabel("Lo\u1EA1i");
		lblLoi.setFont(new Font("Arial", Font.BOLD, 14));
		lblLoi.setBounds(10, 119, 64, 17);
		NH.add(lblLoi);

		JLabel lblGiTin = new JLabel("Gi\u00E1 ti\u1EC1n");
		lblGiTin.setFont(new Font("Arial", Font.BOLD, 14));
		lblGiTin.setBounds(10, 150, 64, 17);
		NH.add(lblGiTin);

		tenHang = new JTextField();
		tenHang.setBounds(106, 62, 111, 20);
		NH.add(tenHang);
		tenHang.setColumns(10);

		soLuong = new JTextField();
		soLuong.setColumns(10);
		soLuong.setBounds(106, 93, 111, 20);
		NH.add(soLuong);

		giaTien = new JTextField();
		giaTien.setColumns(10);
		giaTien.setBounds(106, 149, 111, 20);
		NH.add(giaTien);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(237, 30, 467, 292);
		NH.add(scrollPane_2);

		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "T\u00EAn", "Lo\u1EA1i", "S\u1ED1 l\u01B0\u1EE3ng", "Gi\u00E1" }));
		scrollPane_2.setViewportView(table_2);

		JButton btnNewButton_1_3 = new JButton("Th\u00EAm");
		btnNewButton_1_3.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (maHang.getText().isEmpty() || tenHang.getText().isEmpty() || soLuong.getText().isEmpty()
						|| giaTien.getText().isEmpty()) {
					JOptionPane.showMessageDialog(rootPane, "Vui lòng điền đầy đủ thông tin");
				} else {
					hangHoa.setMaHang(maHang.getText());
					hangHoa.setTenHang(tenHang.getText());
					hangHoa.setLoaiHang(loaiHang.getText());
					hangHoa.setSoLuong(Integer.parseInt(soLuong.getText()));
					hangHoa.setGiaTien(Double.parseDouble(giaTien.getText()));
					if (!controller.check(hangHoa.getMaHang())) {
						controller.addHangHoa(hangHoa);
						controller.addLoaiHang(hangHoa.getLoaiHang());
						JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
						clear();
						try {
							controller.loadKhoHang();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(rootPane, "Trùng mã hàng");
					}
				}
			}
		});
		btnNewButton_1_3.setBounds(10, 198, 89, 35);
		NH.add(btnNewButton_1_3);

		JButton btnS = new JButton("S\u1EEDa");
		btnS.setEnabled(false);
		btnS.setFont(new Font("Arial", Font.BOLD, 14));
		btnS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (JOptionPane.showConfirmDialog(rootPane, "Xác nhận sửa?", "Confirm",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						hangHoa.setMaHang((String) table_2.getValueAt(table_2.getSelectedRow(), 1));
						hangHoa.setTenHang(tenHang.getText());
						hangHoa.setLoaiHang(loaiHang.getText());
						hangHoa.setSoLuong(Integer.parseInt(soLuong.getText()));
						hangHoa.setGiaTien(Double.parseDouble(giaTien.getText()));
						controller.updateHangHoa(hangHoa);
						controller.loadKhoHang();
						clear();
						JOptionPane.showMessageDialog(rootPane, "Sửa thành công");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				btnS.setEnabled(false);
			}
		});
		btnS.setBounds(116, 198, 89, 35);
		NH.add(btnS);

		JButton btnX = new JButton("X\u00F3a");
		btnX.setEnabled(false);
		btnX.setFont(new Font("Arial", Font.BOLD, 14));
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (JOptionPane.showConfirmDialog(rootPane, "Xác nhận xóa?", "Confirm",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						controller.deleteHangHoa((String) table_2.getValueAt(table_2.getSelectedRow(), 1));
					}
					controller.loadKhoHang();
					clear();
					JOptionPane.showMessageDialog(rootPane, "Xóa thành công");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				btnX.setEnabled(false);
			}
		});
		btnX.setBounds(63, 249, 89, 35);
		NH.add(btnX);

		JLabel lblMHng = new JLabel("M\u00E3 h\u00E0ng");
		lblMHng.setFont(new Font("Arial", Font.BOLD, 14));
		lblMHng.setBounds(10, 35, 71, 17);
		NH.add(lblMHng);

		maHang = new JTextField();
		maHang.setColumns(10);
		maHang.setBounds(106, 34, 111, 20);
		NH.add(maHang);

		loaiHang = new JTextField();
		loaiHang.setColumns(10);
		loaiHang.setBounds(106, 119, 111, 20);
		NH.add(loaiHang);

		JPanel KH = new JPanel();
		layeredPane.add(KH, "name_329048513829500");
		KH.setLayout(null);

		JComboBox loaiHangCheck = new JComboBox();
		loaiHangCheck.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					controller.loadLoaiHang(loaiHangCheck.getSelectedItem().toString());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		loaiHangCheck.setBounds(182, 33, 125, 22);
		KH.add(loaiHangCheck);

		JLabel lblNewLabel_1 = new JLabel("Lo\u1EA1i h\u00E0ng");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(50, 32, 91, 22);
		KH.add(lblNewLabel_1);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 80, 694, 242);
		KH.add(scrollPane_3);

		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "T\u00EAn", "Lo\u1EA1i", "SL", "Gi\u00E1" }));
		scrollPane_3.setViewportView(table_3);

		JPanel QuanLiThietBi = new JPanel();
		NhanVien.add(QuanLiThietBi, "name_329188332252200");
		QuanLiThietBi.setLayout(null);

		JButton btnNewButton_3 = new JButton("Nhập hàng");
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 14));

		btnNewButton_3.setBounds(23, 11, 113, 31);
		QuanLiThietBi.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Kiểm hàng");
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 14));

		btnNewButton_4.setBounds(166, 11, 113, 31);
		QuanLiThietBi.add(btnNewButton_4);

		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBounds(10, 53, 714, 328);
		QuanLiThietBi.add(layeredPane_1);
		layeredPane_1.setLayout(new CardLayout(0, 0));

		JPanel Nhap = new JPanel();
		layeredPane_1.add(Nhap, "name_330432697597400");
		Nhap.setLayout(null);

		JLabel lblTn_1 = new JLabel("Mã thiêt bị");
		lblTn_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblTn_1.setBounds(130, 23, 101, 28);
		Nhap.add(lblTn_1);

		maTB = new JTextField();
		maTB.setColumns(10);
		maTB.setBounds(130, 54, 116, 20);
		Nhap.add(maTB);

		JLabel lblM = new JLabel("Tên thiết bị");
		lblM.setFont(new Font("Arial", Font.BOLD, 14));
		lblM.setBounds(130, 85, 94, 17);
		Nhap.add(lblM);

		tenTB = new JTextField();
		tenTB.setColumns(10);
		tenTB.setBounds(130, 113, 116, 20);
		Nhap.add(tenTB);

		JLabel lblNgyNhpk = new JLabel("Ngày nhập");
		lblNgyNhpk.setFont(new Font("Arial", Font.BOLD, 14));
		lblNgyNhpk.setBounds(130, 147, 128, 17);
		Nhap.add(lblNgyNhpk);

		ngayNhap = new JTextField();
		ngayNhap.setColumns(10);
		ngayNhap.setBounds(130, 175, 116, 20);
		Nhap.add(ngayNhap);

		JLabel lblThiGianBo = new JLabel("Thời gian bảo hành");
		lblThiGianBo.setFont(new Font("Arial", Font.BOLD, 14));
		lblThiGianBo.setBounds(400, 29, 128, 17);
		Nhap.add(lblThiGianBo);

		JButton btnNewButton_4_1 = new JButton("L\u01B0u th\u00F4ng tin");
		btnNewButton_4_1.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (maTB.getText().isEmpty() || tenTB.getText().isEmpty() || ngayNhap.getText().isEmpty()
						|| thoiGianBH.getText().isEmpty() || xuatXu.getText().isEmpty()
						|| tinhTrang.getText().isEmpty()) {
					JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đầy đủ thông tin.");
				} else {
					thietBi.setMaTB(maTB.getText());
					thietBi.setTenTB(tenTB.getText());
					thietBi.setNgayNhap(ngayNhap.getText());
					thietBi.setThoiGianBaoHanh(thoiGianBH.getText());
					thietBi.setXuatXu(xuatXu.getText());
					thietBi.setTinhTrang(tinhTrang.getText());
					if (!controller.checkTB(thietBi.getMaTB())) {
						controller.addThietBi(thietBi);
						JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
						clearTB();
					} else {
						JOptionPane.showMessageDialog(rootPane, "Trùng mã thiết bị");
					}

				}
			}
		});
		btnNewButton_4_1.setBounds(255, 234, 139, 38);
		Nhap.add(btnNewButton_4_1);

		tinhTrang = new JTextField();
		tinhTrang.setColumns(10);
		tinhTrang.setBounds(400, 175, 113, 20);
		Nhap.add(tinhTrang);

		JLabel lblTnhTrng = new JLabel("T\u00ECnh tr\u1EA1ng");
		lblTnhTrng.setFont(new Font("Arial", Font.BOLD, 14));
		lblTnhTrng.setBounds(400, 147, 128, 17);
		Nhap.add(lblTnhTrng);

		xuatXu = new JTextField();
		xuatXu.setColumns(10);
		xuatXu.setBounds(400, 113, 116, 20);
		Nhap.add(xuatXu);

		JLabel lblXutX = new JLabel("Xuất xứ");
		lblXutX.setFont(new Font("Arial", Font.BOLD, 14));
		lblXutX.setBounds(400, 85, 128, 17);
		Nhap.add(lblXutX);

		thoiGianBH = new JTextField();
		thoiGianBH.setColumns(10);
		thoiGianBH.setBounds(400, 54, 116, 20);
		Nhap.add(thoiGianBH);

		JPanel XemTB = new JPanel();
		layeredPane_1.add(XemTB, "name_330452267552300");
		XemTB.setLayout(null);

		JLabel lblTnhTrng_1 = new JLabel("T\u00ECnh tr\u1EA1ng");
		lblTnhTrng_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblTnhTrng_1.setBounds(26, 22, 89, 17);
		XemTB.add(lblTnhTrng_1);

		JComboBox tinhTrangTB = new JComboBox();
		tinhTrangTB.setModel(new DefaultComboBoxModel(new String[] { "Tất cả", "Bình thường", "Hư hỏng" }));
		tinhTrangTB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (tinhTrangTB.getSelectedIndex() == 0) {
					try {
						controller.loadThietBi2();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else {
					try {
						controller.loadThietBi(tinhTrangTB.getSelectedItem().toString());
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		tinhTrangTB.setBounds(125, 22, 84, 19);
		XemTB.add(tinhTrangTB);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(22, 60, 682, 246);
		XemTB.add(scrollPane_4);

		table_4 = new JTable();
		table_4.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "STT", "M\u00E3", "T\u00EAn", "N\u0103m" }));
		scrollPane_4.setViewportView(table_4);

		JLabel lblTnhTrng_1_1 = new JLabel("Mã TB");
		lblTnhTrng_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblTnhTrng_1_1.setBounds(386, 11, 84, 17);
		XemTB.add(lblTnhTrng_1_1);

		maTBSua = new JTextField();
		maTBSua.setBounds(463, 10, 84, 18);
		XemTB.add(maTBSua);
		maTBSua.setColumns(10);

		JLabel lblTnhTrng_1_2 = new JLabel("Tình trạng");
		lblTnhTrng_1_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblTnhTrng_1_2.setBounds(386, 32, 84, 17);
		XemTB.add(lblTnhTrng_1_2);

		JComboBox tinhTrangTB_1 = new JComboBox();
		tinhTrangTB_1.setModel(new DefaultComboBoxModel(new String[] { "", "Bình thường", "Hư hỏng" }));
		tinhTrangTB_1.setBounds(463, 30, 84, 19);
		XemTB.add(tinhTrangTB_1);

		JButton btnNewButton_5 = new JButton("Cập nhật");
		btnNewButton_5.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.updateThietBi(maTBSua.getText(), tinhTrangTB_1.getSelectedItem().toString());
				JOptionPane.showMessageDialog(rootPane, "Sửa thành công");
				try {
					controller.loadThietBi2();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				maTBSua.setText("");
				tinhTrangTB_1.setSelectedIndex(0);
			}
		});
		btnNewButton_5.setBounds(573, 11, 102, 34);
		XemTB.add(btnNewButton_5);

		JPanel QuanLiDoanhThu = new JPanel();
		QuanLiDoanhThu.setLayout(null);
		NhanVien.add(QuanLiDoanhThu, "name_97075011317500");

		JLabel lblNgyBtu = new JLabel("Ngày bắt đầu");
		lblNgyBtu.setFont(new Font("Arial", Font.BOLD, 14));
		lblNgyBtu.setBounds(36, 35, 128, 17);
		QuanLiDoanhThu.add(lblNgyBtu);

		JLabel lblNgyKtThc = new JLabel("Ngày kết thúc");
		lblNgyKtThc.setFont(new Font("Arial", Font.BOLD, 14));
		lblNgyKtThc.setBounds(193, 35, 128, 17);
		QuanLiDoanhThu.add(lblNgyKtThc);

		JDateChooser ngayBatDau = new JDateChooser();
		ngayBatDau.setBounds(36, 63, 101, 20);
		QuanLiDoanhThu.add(ngayBatDau);

		JDateChooser ngayKetThuc = new JDateChooser();
		ngayKetThuc.setBounds(193, 63, 101, 20);
		QuanLiDoanhThu.add(ngayKetThuc);

		JButton btnNewButton = new JButton("Thống kê");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String ngayBD = sdf.format(ngayBatDau.getDate());
				String ngayKT = sdf.format(ngayKetThuc.getDate());
				try {
					controller.loadTableThongKe(ngayBD, ngayKT);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				tc.setText(Integer.toString(dtm.getRowCount()));
				List<DonHang> dh = controller.lichSu(ngayBD, ngayKT);
				double tong = 0;
				for (DonHang i : dh) {
					tong += i.getThanhTien();
				}
				tt.setText(Double.toString(tong));
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(346, 58, 110, 25);
		QuanLiDoanhThu.add(btnNewButton);

		JLabel lblSLngBn = new JLabel("Số lượng bán:");
		lblSLngBn.setFont(new Font("Arial", Font.BOLD, 14));
		lblSLngBn.setBounds(474, 23, 101, 17);
		QuanLiDoanhThu.add(lblSLngBn);

		JLabel lblTngTin_1 = new JLabel("Tổng tiền:");
		lblTngTin_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblTngTin_1.setBounds(505, 48, 70, 17);
		QuanLiDoanhThu.add(lblTngTin_1);

		tc = new JLabel("");
		tc.setForeground(Color.RED);
		tc.setFont(new Font("Arial", Font.BOLD, 14));
		tc.setBounds(585, 23, 128, 17);
		QuanLiDoanhThu.add(tc);

		tt = new JLabel("");
		tt.setForeground(Color.RED);
		tt.setFont(new Font("Arial", Font.BOLD, 14));
		tt.setBounds(585, 50, 128, 17);
		QuanLiDoanhThu.add(tt);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 101, 714, 280);
		QuanLiDoanhThu.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NhanVien.removeAll();
				NhanVien.add(QuanLiBanHang);
				NhanVien.repaint();
				NhanVien.revalidate();
				listLoaiHang.removeAll(listLoaiHang);
				listLoaiHang = controller.getDataIntoComboBox();
				if (comboBox.getItemCount() != 0)
					comboBox.removeAllItems();
				for (String i : listLoaiHang) {
					comboBox.addItem(i);
				}
			}
		});
		lblQunLDoanh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NhanVien.removeAll();
				NhanVien.add(QuanLiDoanhThu);
				NhanVien.repaint();
				NhanVien.revalidate();
				try {
					controller.loadLichSu();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				tc.setText(Integer.toString(dtm.getRowCount()));
				double money = 0;
				for (int i = 0; i < dtm.getRowCount(); i++) {
					String tien = dtm.getValueAt(i, 5).toString();
					money += Double.valueOf(tien);
				}
				tt.setText(Double.toString(money));
			}
		});
		lblQunLThit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NhanVien.removeAll();
				NhanVien.add(QuanLiThietBi);
				NhanVien.repaint();
				NhanVien.revalidate();
				try {
					controller.loadThietBi2();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(BH);
				layeredPane.repaint();
				layeredPane.revalidate();
				listLoaiHang.removeAll(listLoaiHang);
				listLoaiHang = controller.getDataIntoComboBox();
				if (comboBox.getItemCount() != 0)
					comboBox.removeAllItems();
				for (String i : listLoaiHang) {
					comboBox.addItem(i);
				}
			}
		});
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(NH);
				layeredPane.repaint();
				layeredPane.revalidate();
				try {
					controller.loadKhoHang();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(KH);
				layeredPane.repaint();
				layeredPane.revalidate();
				List<String> listLoaiHang = null;
				listLoaiHang = controller.getDataIntoComboBox();
				if (loaiHangCheck.getItemCount() == 0) {
					for (String i : listLoaiHang) {
						loaiHangCheck.addItem(i);
					}
				}
			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(Nhap);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
			}
		});
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(XemTB);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
			}
		});
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int removeIndex = table_5.getSelectedRow();
				list.remove(removeIndex);
				tongCong.setText(Double.toString(tongTien()));
				showResult();
			}
		});
		btnTT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (DonHang i : list) {
					donHang = new DonHang();
					donHang.setMaHang(i.getMaHang());
					donHang.setTenHang(i.getTenHang());
					donHang.setSoLuong(i.getSoLuong());
					donHang.setThanhTien(i.getThanhTien());
					controller.addDonHang(donHang);
				}
				tableModel.setRowCount(0);
				tongCong.setText("0");
				JOptionPane.showMessageDialog(rootPane, "Thanh toán thành công.");
				list.removeAll(list);
				btnAdd.setEnabled(false);
				btnDel.setEnabled(false);
				btnTT.setEnabled(false);
			}
		});
		BH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnAdd.setEnabled(false);
				btnDel.setEnabled(false);
			}
		});
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnAdd.setEnabled(true);
			}
		});
		table_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnDel.setEnabled(true);
			}
		});
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maHang.setText((String) table_2.getValueAt(table_2.getSelectedRow(), 1));
				tenHang.setText((String) table_2.getValueAt(table_2.getSelectedRow(), 2));
				loaiHang.setText((String) table_2.getValueAt(table_2.getSelectedRow(), 3));
				soLuong.setText(table_2.getValueAt(table_2.getSelectedRow(), 4).toString());
				giaTien.setText(table_2.getValueAt(table_2.getSelectedRow(), 5).toString());
				btnX.setEnabled(true);
				btnS.setEnabled(true);
			}
		});
		NH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnX.setEnabled(false);
				btnS.setEnabled(false);
			}
		});
	}

	public void clear() {
		maHang.setText("");
		tenHang.setText("");
		soLuong.setText("");
		giaTien.setText("");
		loaiHang.setText("");
	}

	public void clearTB() {
		maTB.setText("");
		tenTB.setText("");
		ngayNhap.setText("");
		thoiGianBH.setText("");
		xuatXu.setText("");
		tinhTrang.setText("");
	}

	public double tongTien() {
		tien = 0;
		for (DonHang i : list)
			tien += i.getThanhTien();
		return tien;
	}

	public void showResult() {
		tableModel.setRowCount(0);
		for (DonHang i : list) {
			tableModel.addRow(new Object[] { table_5.getRowCount() + 1, i.getMaHang(), i.getTenHang(), i.getSoLuong(),
					i.getThanhTien() });
		}
	}

	public void loadDonHang() {
		tableModel = (DefaultTableModel) table_5.getModel();
		DonHang donHang = new DonHang();
		donHang.setMaHang((String) table_1.getValueAt(table_1.getSelectedRow(), 1));
		donHang.setTenHang((String) table_1.getValueAt(table_1.getSelectedRow(), 2));
		donHang.setSoLuong(1);
		donHang.setThanhTien((Double) table_1.getValueAt(table_1.getSelectedRow(), 3));
		list.add(donHang);
		showResult();
	}
}
