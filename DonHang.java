package Model;

public class DonHang {
	private int STT;
	private String maHang;
	private String tenHang;
	private String ngayMua;
	private int soLuong;
	private double thanhTien;

	public DonHang() {
	}

	public DonHang(int STT, String maHang, String tenHang, String ngayMua, int soLuong, double thanhTien) {
		this.STT = STT;
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.ngayMua = ngayMua;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
	}

	public int getSTT() {
		return STT;
	}

	public void setSTT(int STT) {
		this.STT = STT;
	}

	public String getMaHang() {
		return maHang;
	}

	public void setMaHang(String maHang) {
		this.maHang = maHang;
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}

	public String getNgayMua() {
		return ngayMua;
	}

	public void setNgayMua(String ngayMua) {
		this.ngayMua = ngayMua;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}

}
