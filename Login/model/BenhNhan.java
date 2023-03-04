package model;

public class BenhNhan {

	private String maBN;
	private String hoVaTen;
	private String gioiTinh;
	private String ngaySinh;
	private String queQuan;
	private String ngayVaoVien;
	private String tenBenh;
	private String tenBacSi;
	private int phong;
	public BenhNhan() {
		super();
	}
	public BenhNhan(String maBN, String hoVaTen, String gioiTinh, String ngaySinh, String queQuan, String ngayVaoVien,
			String tenBenh, String tenBacSi, int phong) {
		super();
		this.maBN = maBN;
		this.hoVaTen = hoVaTen;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.queQuan = queQuan;
		this.ngayVaoVien = ngayVaoVien;
		this.tenBenh = tenBenh;
		this.tenBacSi = tenBacSi;
		this.phong = phong;
	}
	public String getMaBN() {
		return maBN;
	}
	public void setMaBN(String maBN) {
		this.maBN = maBN;
	}
	public String getHoVaTen() {
		return hoVaTen;
	}
	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getQueQuan() {
		return queQuan;
	}
	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}
	public String getNgayVaoVien() {
		return ngayVaoVien;
	}
	public void setNgayVaoVien(String ngayVaoVien) {
		this.ngayVaoVien = ngayVaoVien;
	}
	public String getTenBenh() {
		return tenBenh;
	}
	public void setTenBenh(String tenBenh) {
		this.tenBenh = tenBenh;
	}
	public String getTenBacSi() {
		return tenBacSi;
	}
	public void setTenBacSi(String tenBacSi) {
		this.tenBacSi = tenBacSi;
	}
	public int getPhong() {
		return phong;
	}
	public void setPhong(int phong) {
		this.phong = phong;
	}
	@Override
	public String toString() {
		return "BenhNhan [maBN=" + maBN + ", hoVaTen=" + hoVaTen + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh
				+ ", queQuan=" + queQuan + ", ngayVaoVien=" + ngayVaoVien + ", tenBenh=" + tenBenh + ", tenBacSi="
				+ tenBacSi + ", phong=" + phong + "]";
	}
	
	
}
