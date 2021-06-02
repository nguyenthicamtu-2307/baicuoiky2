package View;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Controller.Controller;
import Model.ThanhVien;

public class KhachHang extends JFrame {

	private JPanel contentPane;
	private JTextField hoten;
	private JTextField sdt;
	private JTextField tenCS;
	private JTextField sdtCS;
	private JTextField maCS;
	public static JTable table;
	ThanhVien thanhVien;
	Controller controller;
	private JTextField hoTenGH;
	private JTextField maTheGH;
	double tien;
	double tienGH;
	private JComboBox thoiGianHieuLuc;
	private JComboBox loaiThe;
	private JComboBox loaiHinhThe;
	private JTextField diaChi;
	private JTextField GT;
	ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton rbDK;
	JRadioButton rbLT;
	JRadioButton rbGT;
	JDateChooser dateChooser;
	JDateChooser dateChooser_1;
	private JTextField diaChiCS;

	public KhachHang() {
		setTitle("Khách hàng");
		initialize();
		thanhVien = new ThanhVien();
		controller = new Controller();
		buttonGroup.add(rbDK);
		buttonGroup.add(rbLT);
		buttonGroup.add(rbGT);
	}

	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 571);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(10, 11, 725, 45);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u0110\u0103ng k\u00FD th\u1EBB");

		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(25, 11, 90, 25);
		panel.add(lblNewLabel);

		JLabel lblGiaHnTh = new JLabel("Gia h\u1EA1n th\u1EBB");

		lblGiaHnTh.setFont(new Font("Arial", Font.BOLD, 14));
		lblGiaHnTh.setBounds(132, 11, 90, 25);
		panel.add(lblGiaHnTh);

		JLabel lblChnhSa = new JLabel("Ch\u1EC9nh s\u1EEDa");

		lblChnhSa.setFont(new Font("Arial", Font.BOLD, 14));
		lblChnhSa.setBounds(250, 11, 90, 25);
		panel.add(lblChnhSa);

		JLabel lblXemThngTin = new JLabel("Xem th\u00F4ng tin");

		lblXemThngTin.setFont(new Font("Arial", Font.BOLD, 14));
		lblXemThngTin.setBounds(350, 11, 104, 25);
		panel.add(lblXemThngTin);

		JLabel lblNewLabel_1 = new JLabel("Home");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login.kh.dispose();
				Login.home.setVisible(true);
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ASUS\\Desktop\\full\\New folder\\Home-icon.png"));
		lblNewLabel_1.setBounds(611, 10, 91, 28);
		panel.add(lblNewLabel_1);

		JLayeredPane KhachHang = new JLayeredPane();
		KhachHang.setBounds(10, 67, 720, 454);
		contentPane.add(KhachHang);
		KhachHang.setLayout(new CardLayout(0, 0));

		JPanel DangKyThe = new JPanel();
		KhachHang.add(DangKyThe, "name_325196578552000");
		DangKyThe.setLayout(null);

		JLabel lblHVTn = new JLabel("H\u1ECD v\u00E0 t\u00EAn");
		lblHVTn.setFont(new Font("Arial", Font.BOLD, 16));
		lblHVTn.setBounds(87, 55, 90, 25);
		DangKyThe.add(lblHVTn);

		JLabel lblSinThoi = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		lblSinThoi.setFont(new Font("Arial", Font.BOLD, 16));
		lblSinThoi.setBounds(87, 126, 125, 25);
		DangKyThe.add(lblSinThoi);

		JLabel lblaCh = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblaCh.setFont(new Font("Arial", Font.BOLD, 16));
		lblaCh.setBounds(87, 211, 90, 25);
		DangKyThe.add(lblaCh);

		JLabel lblThiGianHiu = new JLabel("Th\u1EDDi gian hi\u1EC7u l\u1EF1c");
		lblThiGianHiu.setFont(new Font("Arial", Font.BOLD, 16));
		lblThiGianHiu.setBounds(466, 46, 142, 25);
		DangKyThe.add(lblThiGianHiu);

		JLabel lblLoiTh = new JLabel("Lo\u1EA1i th\u1EBB");
		lblLoiTh.setFont(new Font("Arial", Font.BOLD, 16));
		lblLoiTh.setBounds(466, 126, 90, 25);
		DangKyThe.add(lblLoiTh);

		JLabel lblLoiHnhTh = new JLabel("Lo\u1EA1i h\u00ECnh th\u1EBB");
		lblLoiHnhTh.setFont(new Font("Arial", Font.BOLD, 16));
		lblLoiHnhTh.setBounds(466, 211, 154, 25);
		DangKyThe.add(lblLoiHnhTh);

		JLabel lblNewLabel_2 = new JLabel("\u0110\u0103ng k\u00FD th\u1EBB");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2.setBounds(301, 0, 121, 35);
		DangKyThe.add(lblNewLabel_2);

		hoten = new JTextField();
		hoten.setColumns(10);
		hoten.setBounds(87, 78, 154, 25);
		DangKyThe.add(hoten);

		sdt = new JTextField();
		sdt.setColumns(10);
		sdt.setBounds(87, 162, 154, 25);
		DangKyThe.add(sdt);

		thoiGianHieuLuc = new JComboBox();
		thoiGianHieuLuc
				.setModel(new DefaultComboBoxModel(new String[] { "", "1 tháng", "3 tháng", "6 tháng", "1 năm" }));
		thoiGianHieuLuc.setBounds(466, 78, 142, 28);
		DangKyThe.add(thoiGianHieuLuc);

		loaiThe = new JComboBox();
		loaiThe.setModel(new DefaultComboBoxModel(new String[] { "", "Fulltime", "Parttime" }));
		loaiThe.setBounds(466, 160, 142, 27);
		DangKyThe.add(loaiThe);

		loaiHinhThe = new JComboBox();
		loaiHinhThe.setModel(new DefaultComboBoxModel(new String[] { "", "Có HLV", "Không HLV" }));
		loaiHinhThe.setBounds(466, 244, 142, 28);
		DangKyThe.add(loaiHinhThe);

		JLabel tongTien = new JLabel("");
		tongTien.setForeground(Color.RED);
		tongTien.setFont(new Font("Arial", Font.BOLD, 16));
		tongTien.setBounds(345, 333, 90, 25);
		DangKyThe.add(tongTien);

		JButton btnDK = new JButton("\u0110\u0103ng k\u00FD");
		btnDK.setEnabled(false);
		btnDK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hoten.getText().isEmpty() || sdt.getText().isEmpty() || diaChi.getText().isEmpty()
						|| loaiThe.getSelectedIndex() == 0 || thoiGianHieuLuc.getSelectedIndex() == 0
						|| loaiHinhThe.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đầy đủ thông tin");
				} else {
					thanhVien.setTenKH(hoten.getText());
					thanhVien.setSdt(sdt.getText());
					thanhVien.setDiaChi(diaChi.getText());
					thanhVien.setTrangThaiThe("Kích hoạt");
					thanhVien.setThoiGianHieuLuc(thoiGianHieuLuc.getSelectedItem().toString());
					thanhVien.setLoaiThe(loaiThe.getSelectedItem().toString());
					thanhVien.setLoaiHinhThe(loaiHinhThe.getSelectedItem().toString());
					thanhVien.setTongTien(Double.parseDouble(tongTien.getText()));
					controller.addThanhVien(thanhVien);
					JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
					clear();
				}
				btnDK.setEnabled(false);
				tongTien.setText("");
			}
		});
		btnDK.setFont(new Font("Arial", Font.BOLD, 14));
		btnDK.setBounds(288, 381, 107, 35);
		DangKyThe.add(btnDK);

		JLabel lblTngTin = new JLabel("Tổng tiền:");
		lblTngTin.setFont(new Font("Arial", Font.BOLD, 16));
		lblTngTin.setBounds(245, 333, 90, 25);
		DangKyThe.add(lblTngTin);

		JButton btnNewButton_1 = new JButton("Xem tổng tiền");
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tien = 0;
				if (thoiGianHieuLuc.getSelectedIndex() == 1)
					tien += 200;
				if (thoiGianHieuLuc.getSelectedIndex() == 2)
					tien += 600;
				if (thoiGianHieuLuc.getSelectedIndex() == 3)
					tien += 1200;
				if (thoiGianHieuLuc.getSelectedIndex() == 4)
					tien += 2000;
				if (loaiThe.getSelectedIndex() == 1)
					tien += 400;
				if (loaiThe.getSelectedIndex() == 2)
					tien += 200;
				if (loaiHinhThe.getSelectedIndex() == 1)
					tien += 500;
				if (loaiHinhThe.getSelectedIndex() == 2)
					tien += 0;
				tongTien.setText(Double.toString(tien));
				btnDK.setEnabled(true);
			}
		});
		btnNewButton_1.setBounds(276, 287, 132, 35);
		DangKyThe.add(btnNewButton_1);

		diaChi = new JTextField();
		diaChi.setColumns(10);
		diaChi.setBounds(87, 244, 154, 28);
		DangKyThe.add(diaChi);

		JPanel ChinhSua = new JPanel();
		KhachHang.add(ChinhSua, "name_326272328344200");
		ChinhSua.setLayout(null);

		JLabel lblNewLabel_2_4 = new JLabel("Ch\u1EC9nh s\u1EEDa th\u00F4ng tin c\u00E1 nh\u00E2n");
		lblNewLabel_2_4.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2_4.setBounds(232, 11, 264, 35);
		ChinhSua.add(lblNewLabel_2_4);

		JLabel lblHVTn_2 = new JLabel("H\u1ECD v\u00E0 t\u00EAn");
		lblHVTn_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblHVTn_2.setBounds(127, 177, 90, 25);
		ChinhSua.add(lblHVTn_2);

		tenCS = new JTextField();
		tenCS.setColumns(10);
		tenCS.setBounds(127, 203, 154, 25);
		ChinhSua.add(tenCS);

		JLabel lblSinThoi_1 = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		lblSinThoi_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblSinThoi_1.setBounds(394, 91, 125, 25);
		ChinhSua.add(lblSinThoi_1);

		sdtCS = new JTextField();
		sdtCS.setColumns(10);
		sdtCS.setBounds(394, 116, 154, 25);
		ChinhSua.add(sdtCS);

		JLabel lblaCh_1 = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblaCh_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblaCh_1.setBounds(394, 177, 90, 25);
		ChinhSua.add(lblaCh_1);

		JLabel lblHVTn_2_1 = new JLabel("ID");
		lblHVTn_2_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblHVTn_2_1.setBounds(127, 96, 90, 25);
		ChinhSua.add(lblHVTn_2_1);

		maCS = new JTextField();
		maCS.setColumns(10);
		maCS.setBounds(127, 119, 154, 25);
		ChinhSua.add(maCS);

		JButton btnLuThngTin = new JButton("L\u01B0u th\u00F4ng tin");
		btnLuThngTin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (maCS.getText().isEmpty() || tenCS.getText().isEmpty() || sdtCS.getText().isEmpty()
						|| diaChiCS.getText().isEmpty()) {
					JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đầy đủ thông tin");
				} else {
					thanhVien.setMaThanhVien(Integer.parseInt(maCS.getText()));
					thanhVien.setTenKH(tenCS.getText());
					thanhVien.setSdt(sdtCS.getText());
					thanhVien.setDiaChi(diaChiCS.getText());
					controller.updateInfoThanhVien(thanhVien);
					JOptionPane.showMessageDialog(rootPane, "Chỉnh sửa thành công");
					clearCS();
				}
			}
		});
		btnLuThngTin.setFont(new Font("Arial", Font.BOLD, 14));
		btnLuThngTin.setBounds(242, 319, 179, 35);
		ChinhSua.add(btnLuThngTin);

		diaChiCS = new JTextField();
		diaChiCS.setColumns(10);
		diaChiCS.setBounds(394, 203, 154, 25);
		ChinhSua.add(diaChiCS);

		JPanel XemTT = new JPanel();
		KhachHang.add(XemTT, "name_327472842820400");
		XemTT.setLayout(null);

		JLabel lblDanhSchNgi = new JLabel("Danh s\u00E1ch ng\u01B0\u1EDDi \u0111\u0103ng k\u00FD");
		lblDanhSchNgi.setFont(new Font("Arial", Font.BOLD, 16));
		lblDanhSchNgi.setBounds(248, 11, 220, 25);
		XemTT.add(lblDanhSchNgi);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 120, 700, 323);
		XemTT.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));
		scrollPane.setViewportView(table);

		rbDK = new JRadioButton("Theo ngày đăng ký");
		rbDK.setFont(new Font("Arial", Font.BOLD, 14));
		rbDK.setBounds(20, 59, 181, 23);
		XemTT.add(rbDK);

		rbLT = new JRadioButton("Theo loại thẻ");
		rbLT.setFont(new Font("Arial", Font.BOLD, 14));
		rbLT.setBounds(258, 59, 138, 23);
		XemTT.add(rbLT);

		rbGT = new JRadioButton("Theo giá tiền");
		rbGT.setFont(new Font("Arial", Font.BOLD, 14));
		rbGT.setBounds(468, 59, 117, 23);
		XemTT.add(rbGT);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(20, 89, 74, 20);
		XemTT.add(dateChooser);

		dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(127, 89, 74, 20);
		XemTT.add(dateChooser_1);

		JComboBox LT = new JComboBox();
		LT.setModel(new DefaultComboBoxModel(new String[] { "", "Fulltime", "Parttime" }));
		LT.setBounds(268, 87, 116, 22);
		XemTT.add(LT);

		GT = new JTextField();
		GT.setBounds(478, 89, 107, 20);
		XemTT.add(GT);
		GT.setColumns(10);

		JButton btnNewButton_2 = new JButton("Lọc");
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_2.setBounds(609, 60, 89, 23);
		XemTT.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Refresh");
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_3.setBounds(609, 86, 89, 23);
		XemTT.add(btnNewButton_3);

		JPanel GiaHanThe = new JPanel();
		GiaHanThe.setLayout(null);
		KhachHang.add(GiaHanThe, "name_498353022368800");

		JLabel lblNewLabel_2_1 = new JLabel("Gia hạn thẻ");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(289, 11, 121, 35);
		GiaHanThe.add(lblNewLabel_2_1);

		JLabel lblHVTn_1 = new JLabel("Họ và tên");
		lblHVTn_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblHVTn_1.setBounds(67, 78, 90, 25);
		GiaHanThe.add(lblHVTn_1);

		hoTenGH = new JTextField();
		hoTenGH.setColumns(10);
		hoTenGH.setBounds(67, 101, 154, 25);
		GiaHanThe.add(hoTenGH);

		JLabel lblMTh = new JLabel("Mã thẻ");
		lblMTh.setFont(new Font("Arial", Font.BOLD, 16));
		lblMTh.setBounds(67, 157, 125, 25);
		GiaHanThe.add(lblMTh);

		maTheGH = new JTextField();
		maTheGH.setColumns(10);
		maTheGH.setBounds(67, 182, 154, 25);
		GiaHanThe.add(maTheGH);

		JLabel lblThiGianHiu_1 = new JLabel("Thời gian hiệu lực");
		lblThiGianHiu_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblThiGianHiu_1.setBounds(425, 78, 142, 25);
		GiaHanThe.add(lblThiGianHiu_1);

		JComboBox thoiGianHieuLucGH = new JComboBox();
		thoiGianHieuLucGH
				.setModel(new DefaultComboBoxModel(new String[] { "", "1 tháng", "3 tháng", "6 tháng", "1 năm" }));
		thoiGianHieuLucGH.setBounds(425, 102, 147, 24);
		GiaHanThe.add(thoiGianHieuLucGH);

		JLabel lblLoiTh_1 = new JLabel("Loại thẻ");
		lblLoiTh_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblLoiTh_1.setBounds(425, 149, 90, 25);
		GiaHanThe.add(lblLoiTh_1);

		JComboBox loaiTheGH = new JComboBox();
		loaiTheGH.setModel(new DefaultComboBoxModel(new String[] { "", "Fulltime", "Parttime" }));
		loaiTheGH.setBounds(425, 183, 147, 24);
		GiaHanThe.add(loaiTheGH);

		JLabel lblLoiHnhTh_1 = new JLabel("Loại hình thẻ");
		lblLoiHnhTh_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblLoiHnhTh_1.setBounds(425, 231, 154, 25);
		GiaHanThe.add(lblLoiHnhTh_1);

		JComboBox loaiHinhTheGH = new JComboBox();
		loaiHinhTheGH.setModel(new DefaultComboBoxModel(new String[] { "", "Có HLV", "Không HLV" }));
		loaiHinhTheGH.setBounds(425, 260, 147, 25);
		GiaHanThe.add(loaiHinhTheGH);

		JButton btnGiaHn = new JButton("Gia hạn");
		btnGiaHn.setEnabled(false);

		btnGiaHn.setFont(new Font("Arial", Font.BOLD, 14));
		btnGiaHn.setBounds(274, 380, 107, 35);
		GiaHanThe.add(btnGiaHn);

		JLabel lblTngTin_1 = new JLabel("Tổng tiền:");
		lblTngTin_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblTngTin_1.setBounds(238, 331, 90, 25);
		GiaHanThe.add(lblTngTin_1);

		JLabel tongTienGH = new JLabel("");
		tongTienGH.setForeground(Color.RED);
		tongTienGH.setFont(new Font("Arial", Font.BOLD, 16));
		tongTienGH.setBounds(328, 331, 90, 25);
		GiaHanThe.add(tongTienGH);

		JButton btnNewButton_4 = new JButton("Xem tổng tiền");
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tienGH = 0;
				if (thoiGianHieuLucGH.getSelectedIndex() == 1)
					tienGH += 200;
				if (thoiGianHieuLucGH.getSelectedIndex() == 2)
					tienGH += 600;
				if (thoiGianHieuLucGH.getSelectedIndex() == 3)
					tienGH += 1200;
				if (thoiGianHieuLucGH.getSelectedIndex() == 4)
					tienGH += 2000;
				if (loaiTheGH.getSelectedIndex() == 1)
					tienGH += 400;
				if (loaiTheGH.getSelectedIndex() == 2)
					tienGH += 200;
				if (loaiHinhTheGH.getSelectedIndex() == 1)
					tienGH += 500;
				if (loaiHinhTheGH.getSelectedIndex() == 2)
					tienGH += 0;
				tongTienGH.setText(Double.toString(tienGH));
				btnGiaHn.setEnabled(true);
			}
		});
		btnNewButton_4.setBounds(260, 289, 136, 26);
		GiaHanThe.add(btnNewButton_4);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				KhachHang.removeAll();
				KhachHang.add(DangKyThe);
				KhachHang.repaint();
				KhachHang.revalidate();
			}
		});
		lblGiaHnTh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				KhachHang.removeAll();
				KhachHang.add(GiaHanThe);
				KhachHang.repaint();
				KhachHang.revalidate();
			}
		});
		lblChnhSa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				KhachHang.removeAll();
				KhachHang.add(ChinhSua);
				KhachHang.repaint();
				KhachHang.revalidate();
			}
		});
		lblXemThngTin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				KhachHang.removeAll();
				KhachHang.add(XemTT);
				KhachHang.repaint();
				KhachHang.revalidate();
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbDK.isSelected()) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String ngayBD = sdf.format(dateChooser.getDate());
					String ngayKT = sdf.format(dateChooser_1.getDate());
					try {
						controller.loadLocNgayDK(ngayBD, ngayKT);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else if (rbLT.isSelected()) {
					try {
						controller.loadLoaiThe(LT.getSelectedItem().toString());
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else {
					try {
						controller.loadGiaTien(Double.parseDouble(GT.getText()));
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controller.loadThanhVien();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnGiaHn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hoTenGH.getText().isEmpty() || maTheGH.getText().isEmpty() || loaiTheGH.getSelectedIndex() == 0
						|| thoiGianHieuLucGH.getSelectedIndex() == 0 || loaiHinhTheGH.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đầy đủ thông tin");
				} else {
					thanhVien.setMaThanhVien(Integer.parseInt(maTheGH.getText()));
					thanhVien.setTenKH(hoTenGH.getText());
					thanhVien.setTrangThaiThe("Kích hoạt");
					thanhVien.setThoiGianHieuLuc(thoiGianHieuLucGH.getSelectedItem().toString());
					thanhVien.setLoaiThe(loaiTheGH.getSelectedItem().toString());
					thanhVien.setLoaiHinhThe(loaiHinhTheGH.getSelectedItem().toString());
					thanhVien.setTongTien(Double.parseDouble(tongTienGH.getText()));
					controller.updateTheThanhVien(thanhVien);
					JOptionPane.showMessageDialog(rootPane, "Gia hạn thành công");
					clearGH();
					tongTienGH.setText("");
				}
				btnGiaHn.setEnabled(false);
				tongTienGH.setText("");
			}
		});
	}

	public void clearCS() {
		tenCS.setText("");
		maCS.setText("");
		diaChiCS.setText("");
		sdtCS.setText("");
	}

	public void clear() {
		hoten.setText("");
		sdt.setText("");
		diaChi.setText("");
		thoiGianHieuLuc.setSelectedIndex(0);
		loaiThe.setSelectedIndex(0);
		loaiHinhThe.setSelectedIndex(0);
	}

	public void clearGH() {
		hoTenGH.setText("");
		maTheGH.setText("");
		thoiGianHieuLuc.setSelectedIndex(0);
		loaiThe.setSelectedIndex(0);
		loaiHinhThe.setSelectedIndex(0);
	}
}
