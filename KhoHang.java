package Model;

public class KhoHang {
	private String maHang;
	private String tenHang;
	private String loaiHang;
	private int soLuong;
	private double giaTien;

	public KhoHang() {
	}

	public KhoHang(String maHang, String tenHang, String loaiHang, int soLuong, double giaTien) {
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.loaiHang = loaiHang;
		this.soLuong = soLuong;
		this.giaTien = giaTien;
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

	public String getLoaiHang() {
		return loaiHang;
	}

	public void setLoaiHang(String loaiHang) {
		this.loaiHang = loaiHang;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(double giaTien) {
		this.giaTien = giaTien;
	}

}
