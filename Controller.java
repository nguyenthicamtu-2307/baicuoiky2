package Controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import DAO.DAO;
import Model.DonHang;
import Model.KhoHang;
import Model.ThanhVien;
import Model.ThietBi;
import View.KhachHang;
import View.NhanVien;

public class Controller {
	DAO dao;

	public Controller() {
		dao = new DAO();
	}

	public void addLoaiHang(String loaiHang) {
		dao.addLoaiHang(loaiHang);
	}

	public void addHangHoa(KhoHang hangHoa) {
		dao.addHangHoa(hangHoa);
	}

	public boolean check(String maHang) {
		return dao.check(maHang);
	}

	public List<KhoHang> getDataFromKhoHang() {
		return dao.getDataFromKhoHang();
	}

	public List<String> getDataIntoComboBox() {
		return dao.getDataIntoComboBox();
	}

	public void loadKhoHang() throws SQLException {
		Controller controller = new Controller();
		DefaultTableModel tableModel = new DefaultTableModel();
		Vector column = new Vector();
		column.add("STT");
		column.add("Mã hàng");
		column.add("Tên hàng");
		column.add("Loại hàng");
		column.add("Số lượng");
		column.add("Giá tiền");
		tableModel.setColumnIdentifiers(column);
		List<KhoHang> list = getDataFromKhoHang();
		for (int i = 0; i < list.size(); i++) {
			KhoHang hangHoa = (KhoHang) list.get(i);
			Vector row = new Vector();
			row.add(tableModel.getRowCount() + 1);
			row.add(hangHoa.getMaHang());
			row.add(hangHoa.getTenHang());
			row.add(hangHoa.getLoaiHang());
			row.add(hangHoa.getSoLuong());
			row.add(hangHoa.getGiaTien());
			tableModel.addRow(row);
		}
		NhanVien.table_2.setModel(tableModel);
	}

	public void updateHangHoa(KhoHang hangHoa) {
		dao.updateHangHoa(hangHoa);
	}

	public void deleteHangHoa(String maHang) {
		dao.deleteHangHoa(maHang);
	}

	public void loadLoaiHang(String loaiHang) throws SQLException {
		DefaultTableModel tableModel = new DefaultTableModel();
		Vector column = new Vector();
		column.add("STT");
		column.add("Mã hàng");
		column.add("Tên hàng");
		column.add("Loại hàng");
		column.add("Số lượng");
		column.add("Giá tiền");
		tableModel.setColumnIdentifiers(column);
		List<KhoHang> list = dao.loadLoaiHang(loaiHang);
		for (int i = 0; i < list.size(); i++) {
			KhoHang hangHoa = (KhoHang) list.get(i);
			Vector row = new Vector();
			row.add(tableModel.getRowCount() + 1);
			row.add(hangHoa.getMaHang());
			row.add(hangHoa.getTenHang());
			row.add(hangHoa.getLoaiHang());
			row.add(hangHoa.getSoLuong());
			row.add(hangHoa.getGiaTien());
			tableModel.addRow(row);
		}
		NhanVien.table_3.setModel(tableModel);
	}

	public List<DonHang> loadThongKe(String ngayBD, String ngayKT) {
		return dao.loadThongKe(ngayBD, ngayKT);
	}

	public void loadTableThongKe(String ngayBD, String ngayKT) throws SQLException {
		DefaultTableModel tableModel = new DefaultTableModel();
		Vector column = new Vector();
		column.add("STT");
		column.add("Mã hàng");
		column.add("Tên hàng");
		column.add("Ngày mua");
		column.add("Số lượng");
		column.add("Giá tiền");
		tableModel.setColumnIdentifiers(column);
		List<DonHang> list = dao.loadThongKe(ngayBD, ngayKT);
		for (int i = 0; i < list.size(); i++) {
			DonHang donHang = (DonHang) list.get(i);
			Vector row = new Vector();
			row.add(donHang.getSTT());
			row.add(donHang.getMaHang());
			row.add(donHang.getTenHang());
			row.add(donHang.getNgayMua());
			row.add(donHang.getSoLuong());
			row.add(donHang.getThanhTien());
			tableModel.addRow(row);
		}
		NhanVien.table.setModel(tableModel);
	}

	public List<DonHang> lichSu(String ngayBatDau, String ngayKetThuc) {
		return dao.loadThongKe(ngayBatDau, ngayKetThuc);
	}

	public void loadLichSu() throws SQLException {
		DefaultTableModel tableModel = new DefaultTableModel();
		Vector column = new Vector();
		column.add("STT");
		column.add("Mã hàng");
		column.add("Tên hàng");
		column.add("Ngày mua");
		column.add("Số lượng");
		column.add("Giá tiền");
		tableModel.setColumnIdentifiers(column);
		List<DonHang> list = dao.lichSuBH();
		for (int i = 0; i < list.size(); i++) {
			DonHang donHang = (DonHang) list.get(i);
			Vector row = new Vector();
			row.add(donHang.getSTT());
			row.add(donHang.getMaHang());
			row.add(donHang.getTenHang());
			row.add(donHang.getNgayMua());
			row.add(donHang.getSoLuong());
			row.add(donHang.getThanhTien());
			tableModel.addRow(row);
		}
		NhanVien.table.setModel(tableModel);
	}

	public void loadSanPham(String loaiHang) throws SQLException {
		DefaultTableModel tableModel = new DefaultTableModel();
		Vector column = new Vector();
		column.add("STT");
		column.add("Mã hàng");
		column.add("Tên hàng");
		column.add("Giá tiền");
		tableModel.setColumnIdentifiers(column);
		List<KhoHang> list = dao.loadLoaiHang(loaiHang);
		for (int i = 0; i < list.size(); i++) {
			KhoHang hangHoa = (KhoHang) list.get(i);
			Vector row = new Vector();
			row.add(tableModel.getRowCount() + 1);
			row.add(hangHoa.getMaHang());
			row.add(hangHoa.getTenHang());
			row.add(hangHoa.getGiaTien());
			tableModel.addRow(row);
		}
		NhanVien.table_1.setModel(tableModel);
	}

	public void addDonHang(DonHang donHang) {
		dao.addDonHang(donHang);
	}

	public void addThanhVien(ThanhVien thanhVien) {
		dao.addThanhVien(thanhVien);
	}

	public void updateTheThanhVien(ThanhVien thanhVien) {
		dao.updateTheThanhVien(thanhVien);
	}

	public void updateInfoThanhVien(ThanhVien thanhVien) {
		dao.updateInfoThanhVien(thanhVien);
	}

	public void loadThanhVien() throws SQLException {
		DefaultTableModel tableModel = new DefaultTableModel();
		Vector column = new Vector();
		column.add("Mã thành viên");
		column.add("Tên thành viên");
		column.add("SĐT");
		column.add("Địa chỉ");
		column.add("Trạng thái thẻ");
		column.add("Ngày đăng ký");
		column.add("Thời gian hiệu lực");
		column.add("Loại thẻ");
		column.add("Loại hình thẻ");
		column.add("Tổng tiền");
		tableModel.setColumnIdentifiers(column);
		List<ThanhVien> list = dao.getListThanhVien();
		for (int i = 0; i < list.size(); i++) {
			ThanhVien thanhVien = (ThanhVien) list.get(i);
			Vector row = new Vector();
			row.add(thanhVien.getMaThanhVien());
			row.add(thanhVien.getTenKH());
			row.add(thanhVien.getSdt());
			row.add(thanhVien.getDiaChi());
			row.add(thanhVien.getTrangThaiThe());
			row.add(thanhVien.getNgayDangKy());
			row.add(thanhVien.getThoiGianHieuLuc());
			row.add(thanhVien.getLoaiThe());
			row.add(thanhVien.getLoaiHinhThe());
			row.add(thanhVien.getTongTien());
			tableModel.addRow(row);
		}
		KhachHang.table.setModel(tableModel);
	}

	public void loadLocNgayDK(String ngayBD, String ngayKT) throws SQLException {
		DefaultTableModel tableModel = new DefaultTableModel();
		Vector column = new Vector();
		column.add("Mã thành viên");
		column.add("Tên thành viên");
		column.add("SĐT");
		column.add("Địa chỉ");
		column.add("Trạng thái thẻ");
		column.add("Ngày đăng ký");
		column.add("Thời gian hiệu lực");
		column.add("Loại thẻ");
		column.add("Loại hình thẻ");
		column.add("Tổng tiền");
		tableModel.setColumnIdentifiers(column);
		List<ThanhVien> list = dao.findDate(ngayBD, ngayKT);
		for (int i = 0; i < list.size(); i++) {
			ThanhVien thanhVien = (ThanhVien) list.get(i);
			Vector row = new Vector();
			row.add(thanhVien.getMaThanhVien());
			row.add(thanhVien.getTenKH());
			row.add(thanhVien.getSdt());
			row.add(thanhVien.getDiaChi());
			row.add(thanhVien.getTrangThaiThe());
			row.add(thanhVien.getNgayDangKy());
			row.add(thanhVien.getThoiGianHieuLuc());
			row.add(thanhVien.getLoaiThe());
			row.add(thanhVien.getLoaiHinhThe());
			row.add(thanhVien.getTongTien());
			tableModel.addRow(row);
		}
		KhachHang.table.setModel(tableModel);
	}

	public void loadLoaiThe(String loaiThe) throws SQLException {
		DefaultTableModel tableModel = new DefaultTableModel();
		Vector column = new Vector();
		column.add("Mã thành viên");
		column.add("Tên thành viên");
		column.add("SĐT");
		column.add("Địa chỉ");
		column.add("Trạng thái thẻ");
		column.add("Ngày đăng ký");
		column.add("Thời gian hiệu lực");
		column.add("Loại thẻ");
		column.add("Loại hình thẻ");
		column.add("Tổng tiền");
		tableModel.setColumnIdentifiers(column);
		List<ThanhVien> list = dao.findThe(loaiThe);
		for (int i = 0; i < list.size(); i++) {
			ThanhVien thanhVien = (ThanhVien) list.get(i);
			Vector row = new Vector();
			row.add(thanhVien.getMaThanhVien());
			row.add(thanhVien.getTenKH());
			row.add(thanhVien.getSdt());
			row.add(thanhVien.getDiaChi());
			row.add(thanhVien.getTrangThaiThe());
			row.add(thanhVien.getNgayDangKy());
			row.add(thanhVien.getThoiGianHieuLuc());
			row.add(thanhVien.getLoaiThe());
			row.add(thanhVien.getLoaiHinhThe());
			row.add(thanhVien.getTongTien());
			tableModel.addRow(row);
		}
		KhachHang.table.setModel(tableModel);
	}

	public void loadGiaTien(double giaTien) throws SQLException {
		DefaultTableModel tableModel = new DefaultTableModel();
		Vector column = new Vector();
		column.add("Mã thành viên");
		column.add("Tên thành viên");
		column.add("SĐT");
		column.add("Địa chỉ");
		column.add("Trạng thái thẻ");
		column.add("Ngày đăng ký");
		column.add("Thời gian hiệu lực");
		column.add("Loại thẻ");
		column.add("Loại hình thẻ");
		column.add("Tổng tiền");
		tableModel.setColumnIdentifiers(column);
		List<ThanhVien> list = dao.findGTien(giaTien);
		for (int i = 0; i < list.size(); i++) {
			ThanhVien thanhVien = (ThanhVien) list.get(i);
			Vector row = new Vector();
			row.add(thanhVien.getMaThanhVien());
			row.add(thanhVien.getTenKH());
			row.add(thanhVien.getSdt());
			row.add(thanhVien.getDiaChi());
			row.add(thanhVien.getTrangThaiThe());
			row.add(thanhVien.getNgayDangKy());
			row.add(thanhVien.getThoiGianHieuLuc());
			row.add(thanhVien.getLoaiThe());
			row.add(thanhVien.getLoaiHinhThe());
			row.add(thanhVien.getTongTien());
			tableModel.addRow(row);
		}
		KhachHang.table.setModel(tableModel);
	}

	public void addThietBi(ThietBi thietBi) {
		dao.addThietBi(thietBi);
	}

	public boolean checkTB(String maTB) {
		return dao.checkTB(maTB);
	}

	public void loadThietBi(String tinhTrang) throws SQLException {
		DefaultTableModel tableModel = new DefaultTableModel();
		Vector column = new Vector();
		column.add("Mã ");
		column.add("Tên ");
		column.add("ngày nhập");
		column.add("thời gian BH");
		column.add("xuất xứ");
		column.add("tình trạng");
		tableModel.setColumnIdentifiers(column);
		List<ThietBi> list = dao.getThietBi(tinhTrang);
		for (int i = 0; i < list.size(); i++) {
			ThietBi thietBi = (ThietBi) list.get(i);
			Vector row = new Vector();
			row.add(thietBi.getMaTB());
			row.add(thietBi.getTenTB());
			row.add(thietBi.getNgayNhap());
			row.add(thietBi.getThoiGianBaoHanh());
			row.add(thietBi.getXuatXu());
			row.add(thietBi.getTinhTrang());
			tableModel.addRow(row);
		}
		NhanVien.table_4.setModel(tableModel);
	}

	public void loadThietBi2() throws SQLException {
		DefaultTableModel tableModel = new DefaultTableModel();
		Vector column = new Vector();
		column.add("Mã ");
		column.add("Tên ");
		column.add("ngày nhập");
		column.add("thời gian BH");
		column.add("xuất xứ");
		column.add("tình trạng");
		tableModel.setColumnIdentifiers(column);
		List<ThietBi> list = dao.getThietBi2();
		for (int i = 0; i < list.size(); i++) {
			ThietBi thietBi = (ThietBi) list.get(i);
			Vector row = new Vector();
			row.add(thietBi.getMaTB());
			row.add(thietBi.getTenTB());
			row.add(thietBi.getNgayNhap());
			row.add(thietBi.getThoiGianBaoHanh());
			row.add(thietBi.getXuatXu());
			row.add(thietBi.getTinhTrang());
			tableModel.addRow(row);
		}
		NhanVien.table_4.setModel(tableModel);
	}

	public void updateThietBi(String maTB, String tinhTrang) {
		dao.updateThietBi(maTB, tinhTrang);
	}
}
