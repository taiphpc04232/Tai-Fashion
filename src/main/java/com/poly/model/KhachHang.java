package com.poly.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Entity
@Table(name="khachhangs")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class KhachHang implements Serializable {
	@Id
	@Column(name="TaiKhoan")
	private String taiKhoan;

	@Column(name="MatKhau")
	private String matKhau;
	
	@Column(name="TenKhachHang")
	private String tenKhachHang;

	@Column(name="SoDienThoai")
	private String soDienThoai;
	
	@Column(name="DiaChi")
	private String diaChi;

//	//bi-directional many-to-one association to DonHang
//	@JsonIgnore
//	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//	@JoinColumn(name = "maDonHang")
//	private List<DonHang> donhangs;
	
	@ManyToOne
	@JoinColumn(name = "maQuyen")
	private Quyen quyen;

	public String getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public Quyen getQuyen() {
		return quyen;
	}

	public void setQuyen(Quyen quyen) {
		this.quyen = quyen;
	}	
	
	
}
