package com.poly.model;

import java.io.Serializable;
import java.util.List;

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
@Table(name="giays")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Giay implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maGiay;
	private String tenGiay;
	private int donGia;
	private double giamGia;
	private String moTa;
	private String hinhAnh;
	
	@JsonIgnore
	@OneToMany(mappedBy = "giay")
	private List<DanhGia> danhGias;

	@JsonIgnore
	@OneToMany(mappedBy = "giay")
	private List<ChiTietDonHang> chiTietDonHangs;
	// bi-directional many-to-one association to HangGiay
	
	@ManyToOne
	@JoinColumn(name = "maHang")
	private HangGiay hangGiay;

	// bi-directional many-to-one association to LoaiGiay
	
	@ManyToOne
	@JoinColumn(name = "maLoaiGiay")
	private LoaiGiay loaiGiay;

	public int getMaGiay() {
		return maGiay;
	}

	public void setMaGiay(int maGiay) {
		this.maGiay = maGiay;
	}

	public String getTenGiay() {
		return tenGiay;
	}

	public void setTenGiay(String tenGiay) {
		this.tenGiay = tenGiay;
	}

	public int getDonGia() {
		return donGia;
	}

	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}

	public double getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(double giamGia) {
		this.giamGia = giamGia;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public List<DanhGia> getDanhGias() {
		return danhGias;
	}

	public void setDanhGias(List<DanhGia> danhGias) {
		this.danhGias = danhGias;
	}

	public List<ChiTietDonHang> getChiTietDonHangs() {
		return chiTietDonHangs;
	}

	public void setChiTietDonHangs(List<ChiTietDonHang> chiTietDonHangs) {
		this.chiTietDonHangs = chiTietDonHangs;
	}

	public HangGiay getHangGiay() {
		return hangGiay;
	}

	public void setHangGiay(HangGiay hangGiay) {
		this.hangGiay = hangGiay;
	}

	public LoaiGiay getLoaiGiay() {
		return loaiGiay;
	}

	public void setLoaiGiay(LoaiGiay loaiGiay) {
		this.loaiGiay = loaiGiay;
	}

	

}
