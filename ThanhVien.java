package Model;

public class ThanhVien {
	private int maThanhVien;
	private String tenKH;
	private String sdt;
	private String diaChi;
	private String trangThaiThe;
	private String ngayDangKy;
	private String thoiGianHieuLuc;
	private String loaiThe;
	private String loaiHinhThe;
	private double tongTien;

	public ThanhVien() {
	}

	public ThanhVien(int maThanhVien, String tenKH, String sdt, String diaChi, String trangThaiThe,String ngayDangKy, String thoiGianHieuLuc,
			String loaiThe, String loaiHinhThe, double tongTien) {
		this.maThanhVien = maThanhVien;
		this.tenKH = tenKH;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.trangThaiThe = trangThaiThe;
		this.ngayDangKy = ngayDangKy;
		this.thoiGianHieuLuc = thoiGianHieuLuc;
		this.loaiThe = loaiThe;
		this.loaiHinhThe = loaiHinhThe;
		this.tongTien = tongTien;
	}
	
	public ThanhVien(int maThanhVien, String tenKH, String trangThaiThe,String ngayDangKy, String thoiGianHieuLuc,
			String loaiThe, String loaiHinhThe, double tongTien) {
		this.maThanhVien = maThanhVien;
		this.tenKH = tenKH;
		this.thoiGianHieuLuc = thoiGianHieuLuc;
		this.loaiThe = loaiThe;
		this.loaiHinhThe = loaiHinhThe;
		this.tongTien = tongTien;
	}
	
	public ThanhVien(int maThanhVien, String tenKH, String sdt, String diaChi) {
		this.maThanhVien = maThanhVien;
		this.tenKH = tenKH;
		this.sdt = sdt;
		this.diaChi = diaChi;
	}

	public String getNgayDangKy() {
		return ngayDangKy;
	}

	public void setNgayDangKy(String ngayDangKy) {
		this.ngayDangKy = ngayDangKy;
	}

	public int getMaThanhVien() {
		return maThanhVien;
	}

	public void setMaThanhVien(int maThanhVien) {
		this.maThanhVien = maThanhVien;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getTrangThaiThe() {
		return trangThaiThe;
	}

	public void setTrangThaiThe(String email) {
		this.trangThaiThe = email;
	}

	public String getThoiGianHieuLuc() {
		return thoiGianHieuLuc;
	}

	public void setThoiGianHieuLuc(String thoiGianHieuLuc) {
		this.thoiGianHieuLuc = thoiGianHieuLuc;
	}

	public String getLoaiThe() {
		return loaiThe;
	}

	public void setLoaiThe(String loaiThe) {
		this.loaiThe = loaiThe;
	}

	public String getLoaiHinhThe() {
		return loaiHinhThe;
	}

	public void setLoaiHinhThe(String loaiHinhThe) {
		this.loaiHinhThe = loaiHinhThe;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

}
