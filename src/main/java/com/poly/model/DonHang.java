package com.poly.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name="donhangs")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DonHang implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaDonHang")
	private int maDonHang;
	@Column(name = "DiaChi")
	private String diaChi;
	@Column(name = "TenNguoiNhan")
	private String tenNguoiNhan;
	@Column(name = "TongTien")
	private int tongTien;
	@Column(name = "GhiChuKhachHang")
	private String ghiChuKhachHang;
	@Column(name = "GhiChuAdmin")
	private String ghiChuAdmin;
	@Column(name = "NgayDatHang")
	private Timestamp ngayDatHang;
	@Column(name = "TrangThai")
	private String trangThai;
	@Column(name = "SoDienThoai")
	private String soDienThoai;

	@JsonIgnore
	@OneToMany(mappedBy="donHang")
	private List<ChiTietDonHang> chiTietDonHangs;
	//bi-directional many-to-one association to KhachHang
	@ManyToOne
	@JoinColumn(name = "taiKhoan")
	private KhachHang khachHang;
	public int getMaDonHang() {
		return maDonHang;
	}
	public void setMaDonHang(int maDonHang) {
		this.maDonHang = maDonHang;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getTenNguoiNhan() {
		return tenNguoiNhan;
	}
	public void setTenNguoiNhan(String tenNguoiNhan) {
		this.tenNguoiNhan = tenNguoiNhan;
	}
	public int getTongTien() {
		return tongTien;
	}
	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}
	public String getGhiChuKhachHang() {
		return ghiChuKhachHang;
	}
	public void setGhiChuKhachHang(String ghiChuKhachHang) {
		this.ghiChuKhachHang = ghiChuKhachHang;
	}
	public String getGhiChuAdmin() {
		return ghiChuAdmin;
	}
	public void setGhiChuAdmin(String ghiChuAdmin) {
		this.ghiChuAdmin = ghiChuAdmin;
	}
	public Timestamp getNgayDatHang() {
		return ngayDatHang;
	}
	public void setNgayDatHang(Timestamp ngayDatHang) {
		this.ngayDatHang = ngayDatHang;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public List<ChiTietDonHang> getChiTietDonHangs() {
		return chiTietDonHangs;
	}
	public void setChiTietDonHangs(List<ChiTietDonHang> chiTietDonHangs) {
		this.chiTietDonHangs = chiTietDonHangs;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	
	
}
