package com.poly.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class ChiTietDonHangPK implements Serializable {
	@Column(name="MaDonHang", insertable=false, updatable=false)
	private int maDonHang;

	@Column(name="MaGiay", insertable=false, updatable=false)
	private int maGiay;

	public int getMaDonHang() {
		return maDonHang;
	}

	public void setMaDonHang(int maDonHang) {
		this.maDonHang = maDonHang;
	}

	public int getMaGiay() {
		return maGiay;
	}

	public void setMaGiay(int maGiay) {
		this.maGiay = maGiay;
	}
	
	
}
