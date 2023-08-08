package com.poly.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Entity
@Table(name="chitietdonhangs")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChiTietDonHang implements Serializable {

	@EmbeddedId
	private ChiTietDonHangPK id;
	@Column(name = "SoLuong")
	private int soLuong;
	@Column(name = "DonGia")
	private int donGia;

	//bi-directional many-to-one association to Giay
	@ManyToOne(optional=false)
	@JoinColumn(name="maGiay", insertable=false, updatable=false)
	private Giay giay;

	//bi-directional many-to-one association to GioHang
	@ManyToOne(optional=false)
	@JoinColumn(name="maDonHang", insertable=false, updatable=false)
	private DonHang donHang;

	public ChiTietDonHangPK getId() {
		return id;
	}

	public void setId(ChiTietDonHangPK id) {
		this.id = id;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getDonGia() {
		return donGia;
	}

	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}

	public Giay getGiay() {
		return giay;
	}

	public void setGiay(Giay giay) {
		this.giay = giay;
	}

	public DonHang getDonHang() {
		return donHang;
	}

	public void setDonHang(DonHang donHang) {
		this.donHang = donHang;
	}
	
	
}
