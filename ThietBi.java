package Model;

public class ThietBi {
	private String maTB;
	private String tenTB;
	private String ngayNhap;
	private String thoiGianBaoHanh;
	private String xuatXu;
	private String tinhTrang;

	public ThietBi() {
	}

	public ThietBi(String maTB, String tenTB, String ngayNhap, String thoiGianBaoHanh, String xuatXu,
			String tinhTrang) {
		this.maTB = maTB;
		this.tenTB = tenTB;
		this.ngayNhap = ngayNhap;
		this.thoiGianBaoHanh = thoiGianBaoHanh;
		this.xuatXu = xuatXu;
		this.tinhTrang = tinhTrang;
	}

	public String getMaTB() {
		return maTB;
	}

	public void setMaTB(String maTB) {
		this.maTB = maTB;
	}

	public String getTenTB() {
		return tenTB;
	}

	public void setTenTB(String tenTB) {
		this.tenTB = tenTB;
	}

	public String getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(String ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public String getThoiGianBaoHanh() {
		return thoiGianBaoHanh;
	}

	public void setThoiGianBaoHanh(String thoiGianBaoHanh) {
		this.thoiGianBaoHanh = thoiGianBaoHanh;
	}

	public String getXuatXu() {
		return xuatXu;
	}

	public void setXuatXu(String xuatXu) {
		this.xuatXu = xuatXu;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

}
