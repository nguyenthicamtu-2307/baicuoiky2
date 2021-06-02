package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.DonHang;
import Model.KhoHang;
import Model.ThanhVien;
import Model.ThietBi;

public class DAO {
	Connection con = SQLConnection.getConnection();

	public void addLoaiHang(String loaiHang) {
		String sql = "insert into tblLoaiHang(loaiHang) values (?)";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, loaiHang);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void addHangHoa(KhoHang hangHoa) {
		String sql = "insert into tblKhoHang(maHang,tenHang,loaiHang,soLuong,giaTien) values(?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, hangHoa.getMaHang());
			preparedStatement.setString(2, hangHoa.getTenHang());
			preparedStatement.setString(3, hangHoa.getLoaiHang());
			preparedStatement.setInt(4, hangHoa.getSoLuong());
			preparedStatement.setDouble(5, hangHoa.getGiaTien());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean check(String maHang) {
		Connection con = SQLConnection.getConnection();
		String sql = "select * from tblKhoHang";
		try {
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				if (resultSet.getString("maHang").equals(maHang))
					return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<KhoHang> getDataFromKhoHang() {
		String sql = "select * from tblKhoHang";
		try {
			List<KhoHang> list = new ArrayList<KhoHang>();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				KhoHang hangHoa = new KhoHang(rs.getString("maHang"), rs.getString("tenHang"), rs.getString("loaiHang"),
						rs.getInt("soLuong"), rs.getDouble("giaTien"));
				list.add(hangHoa);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateHangHoa(KhoHang hangHoa) {
		String sql = "update tblKhoHang set tenHang = ?, loaiHang = ?, soLuong = ?, giaTien = ? where maHang = ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, hangHoa.getTenHang());
			preparedStatement.setString(2, hangHoa.getLoaiHang());
			preparedStatement.setInt(3, hangHoa.getSoLuong());
			preparedStatement.setDouble(4, hangHoa.getGiaTien());
			preparedStatement.setString(5, hangHoa.getMaHang());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteHangHoa(String maHang) {
		Connection con = SQLConnection.getConnection();
		String sql = "delete tblKhoHang where maHang = ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maHang);
			preparedStatement.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public List<KhoHang> loadLoaiHang(String loaiHang) {
		String sql = "select * from tblKhoHang where loaiHang = ?";
		try {
			List<KhoHang> list = new ArrayList<KhoHang>();
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, loaiHang);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				KhoHang hangHoa = new KhoHang(rs.getString("maHang"), rs.getString("tenHang"), rs.getString("loaiHang"),
						rs.getInt("soLuong"), rs.getDouble("giaTien"));
				list.add(hangHoa);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<String> getDataIntoComboBox() {
		List<String> list = new ArrayList<String>();
		String sql = "select * from tblLoaiHang";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(2));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<DonHang> loadThongKe(String ngayBatDau, String ngayKetThuc) {
		String sql = "select * from tblDonHang where ngayMua>=? and ngayMua<=? ";
		List<DonHang> list = new ArrayList<DonHang>();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, ngayBatDau);
			preparedStatement.setString(2, ngayKetThuc);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				DonHang donHang = new DonHang(rs.getInt("STT"), rs.getString("maHang"), rs.getString("tenHang"),
						rs.getString("ngayMua"), rs.getInt("soLuongMua"), rs.getDouble("thanhTien"));
				list.add(donHang);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<DonHang> lichSuBH() {
		String sql = "select * from tblDonHang";
		Statement statement;
		List<DonHang> list = new ArrayList<DonHang>();
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				DonHang donHang = new DonHang(rs.getInt("STT"), rs.getString("maHang"), rs.getString("tenHang"),
						rs.getString("ngayMua"), rs.getInt("soLuongMua"), rs.getDouble("thanhTien"));
				list.add(donHang);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	long millis = System.currentTimeMillis();
	java.sql.Date date = new java.sql.Date(millis);

	public void addDonHang(DonHang donHang) {
		String sql = "insert into tblDonHang(maHang,tenHang,ngayMua,soLuongMua,thanhTien) values (?,?,?,?,?)";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, donHang.getMaHang());
			preparedStatement.setString(2, donHang.getTenHang());
			preparedStatement.setDate(3, date);
			preparedStatement.setInt(4, donHang.getSoLuong());
			preparedStatement.setDouble(5, donHang.getThanhTien());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addThanhVien(ThanhVien thanhVien) {
		String sql = "insert into tblThanhVien(tenThanhVien, SDT,diaChi,trangThaiThe,ngayDangKy,thoiGianHieuLuc,loaiThe,loaiHinhThe,tongTien) values(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, thanhVien.getTenKH());
			preparedStatement.setString(2, thanhVien.getSdt());
			preparedStatement.setString(3, thanhVien.getDiaChi());
			preparedStatement.setString(4, thanhVien.getTrangThaiThe());
			preparedStatement.setDate(5, date);
			preparedStatement.setString(6, thanhVien.getThoiGianHieuLuc());
			preparedStatement.setString(7, thanhVien.getLoaiThe());
			preparedStatement.setString(8, thanhVien.getLoaiHinhThe());
			preparedStatement.setDouble(9, thanhVien.getTongTien());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateTheThanhVien(ThanhVien thanhVien) {
		String sql = "update tblThanhVien set trangThaiThe = ?, ngayDangKy = ?, thoiGianHieuLuc = ?, loaiThe = ?, loaiHinhThe = ?, tongTien = ? where maThanhVien = ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, "Kích hoạt");
			preparedStatement.setDate(2, date);
			preparedStatement.setString(3, thanhVien.getThoiGianHieuLuc());
			preparedStatement.setString(4, thanhVien.getLoaiThe());
			preparedStatement.setString(5, thanhVien.getLoaiHinhThe());
			preparedStatement.setDouble(6, thanhVien.getTongTien());
			preparedStatement.setInt(7, thanhVien.getMaThanhVien());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateInfoThanhVien(ThanhVien thanhVien) {
		String sql = "update tblThanhVien set tenThanhVien = ?, SDT = ?, diaChi = ? where maThanhVien = ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, thanhVien.getTenKH());
			preparedStatement.setString(2, thanhVien.getSdt());
			preparedStatement.setString(3, thanhVien.getDiaChi());
			preparedStatement.setInt(4, thanhVien.getMaThanhVien());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<ThanhVien> getListThanhVien() {
		ArrayList<ThanhVien> list = new ArrayList<ThanhVien>();
		String sql = "SELECT * FROM tblThanhVien";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ThanhVien thanhVien = new ThanhVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getDouble(10));
				list.add(thanhVien);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<ThanhVien> findDate(String ngayBD, String ngayKT) {
		ArrayList<ThanhVien> list = new ArrayList<ThanhVien>();
		String sql = "Select * from tblThanhVien where ?<=ngayDangKy and ngayDangKy<=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ngayBD);
			ps.setString(2, ngayKT);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ThanhVien thanhVien = new ThanhVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getDouble(10));
				list.add(thanhVien);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<ThanhVien> findThe(String loaithe) {
		ArrayList<ThanhVien> list = new ArrayList<ThanhVien>();
		String sql = "Select * from tblThanhVien where loaiThe=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loaithe);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ThanhVien thanhVien = new ThanhVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getDouble(10));
				list.add(thanhVien);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<ThanhVien> findGTien(double giatien) {
		ArrayList<ThanhVien> list = new ArrayList<ThanhVien>();
		String sql = "Select * from tblThanhVien where tongTien<=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, giatien);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ThanhVien thanhVien = new ThanhVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getDouble(10));
				list.add(thanhVien);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void addThietBi(ThietBi thietBi) {
		String sql = "insert into tblThietBi(maTB,tenTB,ngayNhap,thoiGianBaoHanh,xuatXu,tinhTrang) values (?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, thietBi.getMaTB());
			preparedStatement.setString(2, thietBi.getTenTB());
			preparedStatement.setString(3, thietBi.getNgayNhap());
			preparedStatement.setString(4, thietBi.getThoiGianBaoHanh());
			preparedStatement.setString(5, thietBi.getXuatXu());
			preparedStatement.setString(6, thietBi.getTinhTrang());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean checkTB(String maTB) {
		Connection con = SQLConnection.getConnection();
		String sql = "select * from tblThietBi";
		try {
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				if (resultSet.getString("maTB").equals(maTB))
					return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<ThietBi> getThietBi(String tinhTrang) {
		String sql = "select * from tblThietBi where tinhTrang = ?";
		List<ThietBi> list = new ArrayList<ThietBi>();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, tinhTrang);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				ThietBi thietBi = new ThietBi(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6));
				list.add(thietBi);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ThietBi> getThietBi2() {
		String sql = "select * from tblThietBi";
		List<ThietBi> list = new ArrayList<ThietBi>();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = con.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				ThietBi thietBi = new ThietBi(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6));
				list.add(thietBi);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateThietBi(String maTB, String tinhTrang) {
		String sql = "update tblThietBi set tinhTrang = ? where maTB = ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, tinhTrang);
			preparedStatement.setString(2, maTB);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
